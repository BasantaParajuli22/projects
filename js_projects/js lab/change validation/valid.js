// Form validation function
function validateForm() {
    let isValid = true;

    console.log("Validation triggered."); // Debugging log

    const name = document.getElementById('name').value.trim();
    const email = document.getElementById('email').value.trim();
    const password = document.getElementById('password').value.trim();
    const confirmPassword = document.getElementById('confirmpassword').value.trim();
    const country = document.getElementById('selectcountry').value;
    const gender = document.querySelector('input[name="genderGroup"]:checked');
    const terms = document.getElementById('terms').checked;

    const nameError = document.getElementById('nameError');
    const emailError = document.getElementById('emailError');
    const passwordError = document.getElementById('passwordError');
    const confirmPasswordError = document.getElementById('confirmpasswordError');
    const countryError = document.getElementById('countryError');
    const genderError = document.getElementById('genderError');
    const termsError = document.getElementById('termsError');

    nameError.textContent = '';
    emailError.textContent = '';
    passwordError.textContent = '';
    confirmPasswordError.textContent = '';
    countryError.textContent = '';
    genderError.textContent = '';
    termsError.textContent = '';

    if (name === "") {
        nameError.textContent = "Name is required.";
        isValid = false;
    }

    const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    if (email === "") {
        emailError.textContent = "Email is required.";
        isValid = false;
    } else if (!emailPattern.test(email)) {
        emailError.textContent = "Please enter a valid email address.";
        isValid = false;
    }

    if (password === "") {
        passwordError.textContent = "Password is required.";
        isValid = false;
    } else if (password.length < 6) {
        passwordError.textContent = "Password must be at least 6 characters.";
        isValid = false;
    }

    if (confirmPassword === "") {
        confirmPasswordError.textContent = "Please confirm your password.";
        isValid = false;
    } else if (password !== confirmPassword) {
        confirmPasswordError.textContent = "Passwords do not match.";
        isValid = false;
    }

    if (country === "") {
        countryError.textContent = "Please select your country.";
        isValid = false;
    }

    if (!gender) {
        genderError.textContent = "Please select your gender.";
        isValid = false;
    }

    if (!terms) {
        termsError.textContent = "You must accept the terms and conditions.";
        isValid = false;
    }

    return isValid;
}

document.getElementById('registrationForm').addEventListener('submit', function (e) {
    if (!validateForm()) {
        e.preventDefault();
    }
});
