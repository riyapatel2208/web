function validateForm() {
    let isValid = true;

    function setError(id, message) {
        document.getElementById(id).innerText = message;
        isValid = false;
    }

    function clearError(id) {
        document.getElementById(id).innerText = "";
    }

    let firstName = document.getElementById("firstName").value.trim();
    if (!/^[a-zA-Z]{6,}$/.test(firstName)) {
        setError("firstNameError", "Must be at least 6 letters.");
    } else {
        clearError("firstNameError");
    }

    let lastName = document.getElementById("lastName").value.trim();
    if (!/^[a-zA-Z]{6,}$/.test(lastName)) {
        setError("lastNameError", "Must be at least 6 letters.");
    } else {
        clearError("lastNameError");
    }

    let email = document.getElementById("email").value.trim();
    let emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
    if (!emailPattern.test(email)) {
        setError("emailError", "Invalid email format.");
    } else {
        clearError("emailError");
    }

    let password = document.getElementById("password").value;
    if (password.length < 6) {
        setError("passwordError", "Password must be at least 6 characters.");
    } else {
        clearError("passwordError");
    }

    let confirmPassword = document.getElementById("confirmPassword").value;
    if (confirmPassword !== password) {
        setError("confirmPasswordError", "Passwords do not match.");
    } else {
        clearError("confirmPasswordError");
    }

    let mobile = document.getElementById("mobile").value;
    if (!/^\d{10}$/.test(mobile)) {
        setError("mobileError", "Must be exactly 10 digits.");
    } else {
        clearError("mobileError");
    }

    let address = document.getElementById("address").value.trim();
    if (address === "") {
        setError("addressError", "Address cannot be empty.");
    } else {
        clearError("addressError");
    }

    let userRole = document.getElementById("userRole").value;
    if (userRole === "") {
        setError("userRoleError", "Please select a role.");
    } else {
        clearError("userRoleError");
    }

    return isValid;
}
