var username = document.forms['vform']['login'];
var password = document.forms['vform']['password'];

var form = document.getElementsByName("vform");


username.addEventListener('keyup', testLogin.bind(this));
username.addEventListener('focus', testLogin.bind(this));


password.addEventListener('keyup', testPassword.bind(this));
password.addEventListener('focus', testPassword.bind(this));


function public_static_void_main() {
    form.reset();
}

function check() {
    return emptyCheck() && testLogin() && testPassword();

}

function emptyCheck() {
    if (username.value.length === '' || password.value.length === ''){
        username.setCustomValidity('This area is required');
        password.setCustomValidity('This area is required');
        return false;
    }
}


function testLogin(event) {
    if (username.value.length < 5){
        username.setCustomValidity("This field cannot be less than 5 symbols");
        event.target.style.borderColor = "red";
        return false;
    }
    username.setCustomValidity("");
    event.target.style.borderColor = "green";
    return true;
}

function testPassword(event) {
    if (password.value.length < 6){
        password.setCustomValidity("This field cannot be less than 6 symbols");
        event.target.style.borderColor = "red";
        return false;
    }
    password.setCustomValidity("");
    event.target.style.borderColor = "green";
    return true;
}
