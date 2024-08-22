document.getElementById("registrationForm").addEventListener("submit",function(event){

    let validate = true;

    ////clearing Error texts after every new submit 
    document.getElementById("nameError").innerHTML ="";
    document.getElementById("emailError").innerHTML ="";
    document.getElementById("passwordError").innerHTML ="";
    document.getElementById("confirmpasswordError").innerHTML ="";

    let nameValue = document.getElementById("name").value;
    let emailValue = document.getElementById("email").value;
    let passwordValue = document.getElementById("password").value;
    let confirmPasswordValue = document.getElementById("confirmpassword").value;

//     console.log(nameValue.length); 
//    console.log(typeof(nameValue));

    if(nameValue.length < 3){
        document.getElementById("nameError").innerHTML = `you cannot have ${nameValue.length} length as username`;
        validate = false;
    }

    if(passwordValue.length < 8){
        document.getElementById("passwordError").innerHTML = `you cannot have ${passwordValue.length} characters as password`;
        validate = false;
    }

    if(emailValue){
        emailValue = emailValue.toLowerCase();
        //console.log( emailValue.toLowerCase());
        const expression =  /^[^ ]+@[^ ]+\.[a-z]{2,3}$/;
        if(!emailValue.match(expression)){
            document.getElementById("emailError").innerHTML = `not a proper email`;
            validate = false;
        }
    }else{
        document.getElementById("emailError").innerHTML = `no email found `;
        validate = false;
    }

    if(confirmPasswordValue !== passwordValue){
        document.getElementById("confirmpasswordError").innerHTML = `The password didnot match`;
        validate = false;
    }
    if(!validate){
        event.preventDefault();//stopping form to reload
    }

});