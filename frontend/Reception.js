function navigateTo(page) {
    window.location.href = page;
}

function logout() {
    if (confirm("Are you sure you want to logout?")) {
        window.location.href = "login.html";
    }
}
