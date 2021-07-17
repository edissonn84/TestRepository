let domResolve;
let domReady = new Promise(function (resolve) {
    domResolve = resolve;
});

document.addEventListener("DOMContentLoaded", domResolve);

domReady.then(tab).then(clickOnFirstTab);


function createTab() {
    
}
function tab() {
    return new Promise((resolve => {
        const triggerTabList = document.querySelectorAll('#referencesTab a')
        triggerTabList.forEach(function (triggerEl) {
            const tabTrigger = new bootstrap.Tab(triggerEl);
            triggerEl.addEventListener('click', function (event) {
                event.preventDefault();
                const loadUrl = this.getAttribute('href'),
                    tabTarget = document.querySelector(this.getAttribute('data-bs-target'));
                deleteActive();
                tabTarget.classList.add('active');
                fetch(loadUrl).then(response => response.text()).then(fragment => {
                    tabTarget.innerHTML = fragment;
                })
                tabTrigger.show();
                return false;
            });
        })
        resolve();
    }))
}

function deleteActive() {
    document.querySelectorAll('.tab-pane').forEach(tb => {
        if (tb.classList.contains('active')) {
            tb.classList.remove('active')
        }
    })
}

function clickOnFirstTab() {
    const authorTab = document.querySelector('#referencesTab > li a');
    eventFire(authorTab, 'click');
}

function eventFire(el, etype) {
    if (el.fireEvent) {
        el.fireEvent('on' + etype);
    } else {
        let evObj = document.createEvent('Events');
        evObj.initEvent(etype, true, false);
        el.dispatchEvent(evObj);
    }
}