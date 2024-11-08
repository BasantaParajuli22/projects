
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

function validateForm(field){
    let isFormValid = true;

    switch(field){
        case('username'): 
            if(username.value.trim() == ""){
                usernameErr.innerText = "name cannot be empty";
                isFormValid = false;
            }else if(username.value.trim().length < 8){
                usernameErr.innerText = "name cannot be less than 8 characters";
                isFormValid = false;
            }else {
                usernameErr.innerText = ""; 
            }
            break;
        case 'email': 
            let string = /^[a-zA-Z0-9_-]+@[a-zA-Z]+.([a-zA-Z]{2,5})$/;
            if(email.value.trim() == ""){
                emailErr.innerText = "email cannot be empty";
                isFormValid = false;
            }else if(!string.test(email.value)){
            emailErr.innerText = "Wrong email type should be email@example.com";
            isFormValid = false;
            }else{
                emailErr.innerText = "";
            }
            break;
        case'password': 
            if(password.value == ""){
                passwordErr.innerText = "password cannot be empty";
                isFormValid = false;
            }else if(password.value.trim().length < 8){
                passwordErr.innerText = "password cannot be less than 8 characters";
                isFormValid = false;
            }else{
                passwordErr.innerText = "";
            }

            if(password.value != confirmpassword.value){
                confirmpasswordErr.innerText = "Password needs to be same";
                isFormValid = false;
            }else{
                confirmpasswordErr.innerText = "";
            }
            break;
        case'phoneno': 
            const phoneregex = /^\d{10}$/; // Only accepts 10 digits
            if(phoneno.value.trim() == "") {
                phonenoErr.innerText = "Phone number cannot be empty";
                isFormValid = false;
            } else if (!phoneregex.test(phoneno.value)) {
                phonenoErr.innerText = "Phone number must be 10 digits";
                isFormValid = false;
            } else {
                phonenoErr.innerText = "";
            }
            break;
        case'country': 
            if(country.value.trim() == ""){
                countryErr.innerText = "country cannot be empty";
                isFormValid = false;
            }else{
                countryErr.innerText = "";
            }  
            break;
        case'gender': 
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
                isFormValid = false;
            } else {
                genderErr.innerText = "";
            }
            }
            break;
        case 'terms':
            if(!terms.checked){
                termsErr.innerText = "you need to agree to continue";
                isFormValid = false;
            }else{
                termsErr.innerText = "";
            }
            break;
        default:
            break;
    }
    return isFormValid;
}



username.addEventListener("change",function(){
    validateForm('username');
});
email.addEventListener("change",function(){
    validateForm('email');
});
password.addEventListener("change",function(){
    validateForm('password');
});
phoneno.addEventListener("change",function(){
    validateForm('phoneno');
});
country.addEventListener("change",function(){
    validateForm('country');
});
terms.addEventListener("change",function(){
    validateForm('terms');
});

//going through all gender values
for(let i = 0; i < genderGroup.length; i++){
    genderGroup[i].addEventListener("change", function(){
        validateForm('gender');
    });
} 

document.getElementById("registrationSubmit").addEventListener("submit",function(event){
    let isFormValid = true;

    // valid all forms before submitiing
    if (!validateForm('username') ||
    !validateForm('email')|| 
    !validateForm('password') || 
    !validateForm('phoneno') || 
    !validateForm('gender') ||
    !validateForm('terms')){
        isFormValid = false;
    }

    // If form is invalid, prevent submission
    if (!isFormValid) {
        event.preventDefault(); // Prevent form submission if any field is invalid
    }

})