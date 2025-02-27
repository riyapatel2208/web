<!DOCTYPE html>
<html>
<head>
    <title>Signup</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #6a11cb, #2575fc);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            position: relative;
        }

        .container {
            background: white;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.2);
            width: 400px;
            text-align: center;
            position: relative;
        }

        .close-btn {
            position: absolute;
            top: 10px;
            right: 10px;
            font-size: 20px;
            font-weight: bold;
            color: red;
            text-decoration: none;
            cursor: pointer;
        }

        .close-btn:hover {
            color: darkred;
        }

        h2 {
            color: #333;
            margin-bottom: 20px;
        }

        input, select, textarea {
            width: 95%;
            padding: 10px;
            margin: 8px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }

        textarea {
            resize: none;
        }

        .btn {
            width: 48%;
            padding: 12px;
            margin-top: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }

        .btn-primary {
            background: #6a11cb;
            color: white;
        }

        .btn-primary:hover {
            background: #4c0d9a;
        }

        .btn-secondary {
            background: #ccc;
        }

        .btn-secondary:hover {
            background: #999;
        }
    </style>

    <script>
        function validateForm() {
            let firstName = document.getElementById("firstName").value;
            let lastName = document.getElementById("lastName").value;
            let password = document.getElementById("password").value;
            let confirmPassword = document.getElementById("confirmPassword").value;
            let email = document.getElementById("email").value;
            let phone = document.getElementById("phone").value;
            let address = document.getElementById("address").value;
            let role = document.getElementById("role").value;
            let emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            let namePattern = /^[A-Za-z]{6,}$/;
            let phonePattern = /^[0-9]{10}$/;

            if (!namePattern.test(firstName)) {
                alert("First Name should contain only alphabets and be at least 6 characters.");
                return false;
            }

            if (!namePattern.test(lastName)) {
                alert("Last Name should contain only alphabets and be at least 6 characters.");
                return false;
            }

            if (password.length < 6) {
                alert("Password must be at least 6 characters.");
                return false;
            }

            if (password !== confirmPassword) {
                alert("Passwords do not match.");
                return false;
            }

            if (!emailPattern.test(email)) {
                alert("Enter a valid email.");
                return false;
            }

            if (!phonePattern.test(phone)) {
                alert("Phone number must be exactly 10 digits.");
                return false;
            }

            if (address.trim() === "") {
                alert("Address cannot be empty.");
                return false;
            }

            if (role === "") {
                alert("Please select a user role.");
                return false;
            }

            return true;
        }

        function clearForm() {
            document.getElementById("signupForm").reset();
        }
    </script>
</head>
<body>
    <div class="container">
        <a href="index.jsp" class="close-btn">&#10060;</a>
        <h2>Registration Form</h2>
        <form id="signupForm" action="RegisterServlet" method="post" onsubmit="return validateForm();">
            <input type="text" id="firstName" name="firstName" placeholder="First Name" required><br>
            <input type="text" id="lastName" name="lastName" placeholder="Last Name" required><br>
            <input type="password" id="password" name="password" placeholder="Password" required><br>
            <input type="password" id="confirmPassword" name="confirmPassword" placeholder="Confirm Password" required><br>
            <input type="email" id="email" name="email" placeholder="Email" required><br>
            <input type="text" id="phone" name="phone" placeholder="Phone Number" required><br>
            <input type="text" id="address" name="address" placeholder="Address" required><br>
            <select id="role" name="role">
                <option value="">Select Role</option>
                <option value="admin">Admin</option>
                <option value="registered">Registered User</option>
                <option value="guest">Guest</option>
            </select><br>
            <button type="submit" class="btn btn-primary">Register</button>
            <button type="button" class="btn btn-secondary" onclick="clearForm()">Clear</button>
        </form>
    </div>
</body>
</html>
