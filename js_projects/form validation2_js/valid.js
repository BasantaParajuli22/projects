const username = document.getElementById("username");
const email = document.getElementById("email");
const password = document.getElementById("password");
const confirmpassword = document.getElementById("confirmpassword");
const phoneno = document.getElementById("phoneno");
const country = document.getElementById("country");
const genderGroup = document.getElementsByName("genderGroup");//getElementsByName // to get a collection of objects based on the value of the NAME
const terms = document.getElementById("terms");

let usernameErr = document.getElementById("usernameErr");
let emailErr = document.getElementById("emailErr");
let passwordErr = document.getElementById("passwordErr");
let confirmpasswordErr = document.getElementById("confirmpasswordErr");
let phonenoErr = document.getElementById("phonenoErr");
let countryErr = document.getElementById("countryErr");
let genderErr = document.getElementById("genderErr");
let termsErr = document.getElementById("termsErr");

function validateForm(){

    let isFormValid = false;

    if(username.value.trim() == ""){
        usernameErr.innerText = "name cannot be empty";
    }else if(username.value.trim().length < 8){
        usernameErr.innerText = "name cannot be less than 8 characters";
    }else {
        usernameErr.innerText = "";
    }
    // usernameErr.innerText = usernameErr;

    if(email.value.trim() == ""){
        emailErr.innerText = "email cannot be empty";
    }else if(email.value.trim().length < 8){
        emailErr.innerText = "email cannot be less than 8 characters";
    }else{
        emailErr.innerText = "";
    }

    if(password.value == ""){
        passwordErr.innerText = "password cannot be empty";
    }else if(password.value.trim().length < 8){
        passwordErr.innerText = "password cannot be less than 8 characters";
    }else{
        passwordErr.innerText = "";
    }

    if(password.value != confirmpassword.value){
        confirmpasswordErr.innerText = "Password needs to be same";
    }else{
        confirmpasswordErr.innerText = "";
    }

    if(phoneno.value.trim() == ""){
        phonenoErr.innerText = "Phoneno cannot be empty";
    }else if(phoneno.value.trim().length < 10){
        phonenoErr.innerText = "phoneno cannot be less than 10 characters";
    }else{
        phonenoErr.innerText = "";
    }

    let string = /^[a-zA-Z0-9_-]+@[a-zA-Z]+.([a-zA-Z]{2,5})$/;
    if(string.test(email.value)){
       emailErr.innerText = "";
    }else{
        emailErr.innerText = "email not good ok";
    }

    if(country.value.trim() == ""){
        countryErr.innerText = "country cannot be empty";
    }else{
        countryErr.innerText = "";
    }

    //gender validation//
    //console.log(genderGroup);

    if (genderGroup.length > 0) {
        let isGenderSelected = false;
        for(let i = 0; i < genderGroup.length; i++){
            if(genderGroup[i].checked){//which one is checked??
                isGenderSelected = true;
                break;
            }
        }
        if(!isGenderSelected){
            genderErr.innerText = "Gender must be selected";
        } else {
            genderErr.innerText = "";
        }
    }

    if(!terms.checked){
        termsErr.innerText = "you need to agree to continue";
    }else{
        termsErr.innerText = "";
    }


}

username.addEventListener("change",validateForm);
email.addEventListener("change",validateForm);
password.addEventListener("change",validateForm);
confirmpassword.addEventListener("change",validateForm);
phoneno.addEventListener("change",validateForm);
country.addEventListener("change",validateForm);

for(let i = 0; i < genderGroup.length; i++){
    genderGroup[i].addEventListener("change", validateForm);
} 

