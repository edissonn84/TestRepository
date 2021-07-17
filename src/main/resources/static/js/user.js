document.addEventListener("DOMContentLoaded", function (event) {
    eventTable();
});


function eventTable() {
    document.querySelectorAll('.table #editBtn').forEach(editBtn => editBtn.addEventListener('click', function (event) {
        event.preventDefault();
        let href = this.getAttribute('href');
        fetch(href).then(response => response.text()).then(fragment => {
            document.querySelector("#editModal").innerHTML = fragment;
        }).then(() => {
            let model = new bootstrap.Modal(document.getElementById('editModal'), {});
            model.show();
        });
    }));

    document.querySelectorAll('.table #deleteBtn').forEach(deleteBtn => deleteBtn.addEventListener('click', function (event) {
        event.preventDefault();
        let href = this.getAttribute('href');
        document.querySelector('#deleteModal #delRef').setAttribute('href', href);
        let model = new bootstrap.Modal(document.getElementById('deleteModal'), {});
        model.show();
    }));

    document.getElementById('addBtn').addEventListener('click', function (event) {
        event.preventDefault();
        let href = this.getAttribute('href');
        fetch(href).then(response => response.text()).then(fragment => {
            document.querySelector("#addModal").innerHTML = fragment;
        }).then(() => {
            let model = new bootstrap.Modal(document.getElementById('addModal'), {});
            model.show();
            document.getElementById('addForm').addEventListener('submit', event => submitForm(event));
        });
    });

    document.getElementById('searchBtn').addEventListener('click', (event) => {
        const searchText = document.getElementById('search').value,
            param = new URLSearchParams({
                "search": searchText,
            });
        fetch("/books/search?" + param, {method: 'POST'}).then(response => response.text())
            .then(fragment => document.getElementsByClassName("book_list")[0].innerHTML = fragment)
            .then(() => eventTable());
    });
}

async function submitForm(event) {
    event.preventDefault();
    let formData = new FormData(event.target),
        request = new Request(event.target.action, {
            method: 'POST',
            body: formData
        });
    let response = await fetch(request);
    let userTable = await response.text();
    document.querySelector(".user_list").innerHTML = userTable;
    let modal = bootstrap.Modal.getInstance(document.getElementById('addModal'))
    modal.hide();
    eventTable();
}