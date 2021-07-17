package com.example.library.library.controller;

import com.example.library.library.model.User;
import com.example.library.library.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/users")
public class UserController {

    public static final int PAGE_SIZE = 5;
    public static final int PAGE_ONE = 1;
    public static final Sort SORT = Sort.by(Sort.Direction.ASC, "lastName");

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String users(Model model) {
        Pageable firstPageWithFiveElements = PageRequest.of(PAGE_ONE - 1, PAGE_SIZE, SORT);
        Page<User> userPage = userService.findPaginated(firstPageWithFiveElements);
        model.addAttribute("userPage", userPage);
        addTotalPages(model, userPage.getTotalPages());
        return "user/user";
    }

    @GetMapping("/pagination")
    public String showUsersPagination(@RequestParam("page") Optional<Integer> page,
                                      @RequestParam("size") Optional<Integer> size,
                                      Model model) {
        Pageable firstPageWithFiveElements = PageRequest.of(page.orElse(PAGE_ONE) - 1, size.orElse(PAGE_SIZE), SORT);
        Page<User> userPage = userService.findPaginated(firstPageWithFiveElements);
        model.addAttribute("userPage", userPage);
        addTotalPages(model, userPage.getTotalPages());
        return "user/userTable :: user_list";
    }

    private void addTotalPages(Model model, int totalPages) {
        if (totalPages > 1) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
    }

    @PostMapping("/saveUser")
    public String saveUser(User user, Model model) {
        User newUser = userService.createNewUser(user);
        Pageable firstPageWithFiveElements = PageRequest.of(PAGE_ONE, PAGE_SIZE, SORT);
        Page<User> userPage = userService.findPaginatedByPid(newUser.getPid(), firstPageWithFiveElements);
        model.addAttribute("userPage", userPage);
        addTotalPages(model, userPage.getTotalPages());
        return "user/userTable :: user_list";
    }

    @PostMapping("/editUser")
    public String editUser(User user) {
        userService.createNewUser(user);
        return "redirect:/users";
    }

    @GetMapping("/addNewUser")
    public String addUser(Model model) {
        model.addAttribute("predefinedRoles", userService.getAllRoles());
        model.addAttribute("user", new User());
        return "user/modal/addUser";
    }

    @GetMapping("/edit")
    public ModelAndView edit(Long pid) {
        ModelAndView model = new ModelAndView("user/modal/editUser");
        model.addObject("user", userService.getUserById(pid).get());
        model.addObject("predefinedRoles", userService.getAllRoles());
        return model;
    }

    @GetMapping("/delete")
    public String delete(Long id, Model model) {
        userService.deleteUser(id);
        model.addAttribute("users", userService.getAllUsers());
        return "user/userTable :: user_list";
    }
}
