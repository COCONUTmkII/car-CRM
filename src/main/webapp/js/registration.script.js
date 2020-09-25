//VAR MACHING REGEX
var login_regex = /^([A-Za-z])[\w+]{5,}/;
var password_regex = /(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])[A-Za-z0-9]{6,}/;
var email_regex = /^.+@.+\..+$/;
var phone_regex = /^\+375 \((17|29|33|44)\) [0-9]{3}-[0-9]{2}-[0-9]{2}/;
// SELECTING ALL TEXT ELEMENTS
var username = document.forms['vform']['login'];
var email = document.getElementById("mailID");
var password = document.forms['vform']['password'];
var repeat_password = document.forms['vform']['repeat_password'];
var managerName = document.forms['vform']['Name'];
var surname = document.forms['vform']['Surname'];
var patronymic = document.forms['vform']['Patronymic'];
var phone = document.forms['vform']['Telephone'];
// SELECTING ALL ERROR DISPLAY ELEMENTS

var form = document.getElementsByName("vform");
// SETTING ALL EVENT LISTENERS
username.addEventListener('blur', loginVerify.bind(this));
username.addEventListener('keyup', loginVerify.bind(this));
var usernameOk = false;

managerName.addEventListener('blur', nameVerify.bind(this));
managerName.addEventListener('keyup', nameVerify.bind(this));
var managerNameOk = false;

surname.addEventListener('blur', surnameVerify.bind(this));
surname.addEventListener('keyup', surnameVerify.bind(this));
var managerSurnameOK = false;

patronymic.addEventListener('blur', patronymicVerify.bind(this));
patronymic.addEventListener('keyup', patronymicVerify.bind(this));
var managerPatronymicOK = false;

phone.addEventListener('blur', phoneVerify.bind(this));
phone.addEventListener('keyup', phoneVerify.bind(this));
var phoneOk = false;

email.addEventListener('blur', emailVerify.bind(this));
email.addEventListener('keyup', emailVerify.bind(this));
var allEmailsOk = false;

password.addEventListener('blur', passwordVerify.bind(this));
password.addEventListener('keyup', passwordVerify.bind(this));
var passwordOk = false

repeat_password.addEventListener('blur', repeatPasswordVerify.bind(this));
repeat_password.addEventListener('keyup', repeatPasswordVerify.bind(this));
var repeatPasswordOk = false;

var registration = document.getElementById("registration");

// validation function
function public_static_void_main() {
    form.reset();
}
function allIsOk(){
    return usernameOk && allEmailsOk && repeatPasswordOk && passwordOk && managerNameOk &&
        managerSurnameOK && managerPatronymicOK && phoneOk;

}
// event handler functions

function emptyLogin() {
    if (username.value !== ''){
        usernameOk = true;
        //username.setCustomValidity("");
        allIsOk();
    } else {
        username.setCustomValidity("Username cannot be empty");
        usernameOk = false;
    }
}
function emptyPassword() {
    if (password.value !== ''){
        passwordOk = true;
        //password.setCustomValidity("");
        allIsOk();
    } else {
        password.setCustomValidity("Password cannot be empty");
        passwordOk = false;
    }
}

function emptyRepeatPassword() {
    if (repeat_password.value !== ''){
        repeatPasswordOk = true;
        //repeat_password.setCustomValidity("");
        allIsOk();
    } else {
        repeat_password.setCustomValidity("Password cannot be empty");
        repeatPasswordOk = false;
    }
}
function emptyEmail() {
    if (email.value !== ''){
        allEmailsOk = true;
       // email.setCustomValidity("");
        allIsOk();
    } else {
        email.setCustomValidity("Email cannot be empty");
        allEmailsOk = false;
    }
}

function emptyPhone() {
    if (phone.value !== ''){
        phoneOk = true;
       // phone.setCustomValidity("");
        allIsOk();
    } else {
        phone.setCustomValidity("Telephone cannot be empty");
        phoneOk = false;
    }
}

function emptyManagerName() {
    if (managerName.value !== ''){
        managerNameOk = true;
      //  managerName.setCustomValidity("");
        allIsOk();
    } else {
        managerName.setCustomValidity("Name cannot be empty");
        managerNameOk = false;
    }
}
function emptySurname() {
    if (surname.value !== ''){
        managerSurnameOK = true;
     //   surname.setCustomValidity("");
        allIsOk();
    } else {
        surname.setCustomValidity("Surname cannot be empty");
        managerSurnameOK = false;
    }
}

function emptyPatronymic() {
    if (patronymic.value !== ''){
        managerPatronymicOK = true;
     //   patronymic.setCustomValidity("");
        allIsOk();
    } else {
        patronymic.setCustomValidity("Patronymic cannot be empty");
        managerPatronymicOK = false;
    }
}


function loginVerify(event) {
    if (event.target.value.match(login_regex)) {
        event.target.style.borderColor = "green";
        usernameOk = true;
        username.setCustomValidity("");
        allIsOk();
    } else {
        username.setCustomValidity("Your login must contain at least 6 symbols")
        event.target.style.borderColor = "red";
        usernameOk = false;
    }
}

function nameVerify(event) {
    if (event.target.value.length> 4) {
        event.target.style.borderColor = "green";
        managerNameOk = true;
        managerName.setCustomValidity("");
        allIsOk();
    } else {
        event.target.style.borderColor = "red";
        managerName.setCustomValidity("Your name must be at least with 4 symbols");
        managerNameOk = false;
    }
}
function surnameVerify(event) {
    if (event.target.value.length> 4) {
        event.target.style.borderColor = "green";
        managerSurnameOK = true;
        surname.setCustomValidity("");
        allIsOk();
    } else {
        surname.setCustomValidity("Your surname must be at least with 4 symbols");
        event.target.style.borderColor = "red";
        managerSurnameOK = false;
    }
}
function patronymicVerify(event) {
    if (event.target.value.length> 4) {
        event.target.style.borderColor = "green";
        managerPatronymicOK = true;
        patronymic.setCustomValidity("");
        allIsOk();
    } else {
        patronymic.setCustomValidity("Your patronymic must be at least with 4 symbols");
        event.target.style.borderColor = "red";
        managerPatronymicOK = false;
    }
}
function passwordVerify(event) {
    if (event.target.value.match(password_regex)) {
        event.target.style.borderColor = "green";
        passwordOk = true;
        password.setCustomValidity("");
        allIsOk();
    } else {
        password.setCustomValidity("Your password must contain at least 1 capital letter, 1 special symbol, 1 number and 6 symbol length");
        event.target.style.borderColor = "red";
        passwordOk = false;
    }
    if(repeat_password.value){
        var repeat = { target: repeat_password}
        repeatPasswordVerify(repeat);
    }
}
function repeatPasswordVerify(event) {
    if (event.target.value.match(password_regex) && event.target.value === password.value) {
        event.target.style.borderColor = "green";
        repeatPasswordOk = true;
        repeat_password.setCustomValidity("");
        allIsOk();
    } else {
        repeat_password.setCustomValidity("Your password's are not match");
        event.target.style.borderColor = "red";
        repeatPasswordOk = false;
    }
}
function emailVerify(event) {
    if(event.target.value.match(email_regex)){
        event.target.style.borderColor = "green";
        allEmailsOk = true;
        email.setCustomValidity("");
        allIsOk();
    } else {
        event.target.style.borderColor = "red";
        email.setCustomValidity("Email must contain @ and . symbol");
        allEmailsOk = false;
    }
}

function phoneVerify(event) {
    if (event.target.value.match(phone_regex)) {
        event.target.style.borderColor = "green";
        phoneOk = true;
        phone.setCustomValidity("");
        allIsOk();
    } else {
        event.target.style.borderColor = "red";
        phone.setCustomValidity("Phone number must be like '+375 (XX) XXX-XX-XX");
        phoneOk = false;
    }
}

