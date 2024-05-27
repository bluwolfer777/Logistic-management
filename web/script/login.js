function seePassword() {
    if (document.getElementById("seePass").checked) {
        document.getElementById("password").type = "text";
    } else {
        document.getElementById("password").type = "password";
    }
}