function pagination(page, size) {
    const param = new URLSearchParams({
        "page": page,
        "size": size
    });
    fetch(this.location.pathname + '/pagination?' + param).then(responce => responce.text()).then(fragment => {
        document.querySelector(".pagination_list").innerHTML = fragment;
        eventTable();
    });
}
