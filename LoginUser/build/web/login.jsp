<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <style>
            body { 
                font-family: Arial, sans-serif; 
                text-align: center; 
                background: linear-gradient(to right, #6a11cb, #2575fc); 
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                margin: 0;
            }
            .container { 
                width: 400px; 
                background: white; 
                padding: 25px; 
                border-radius: 10px; 
                box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.2); 
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
            input {
                width: 95%;
                padding: 10px;
                margin: 8px 0;
                border: 1px solid #ccc;
                border-radius: 5px;
                font-size: 16px;
            }
            .btn {
                width: 48%;
                padding: 10px;
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
            .error-message {
                color: red;
                font-weight: bold;
                margin-bottom: 10px;
            }
        </style>
        <script>
            function clearForm() {
                document.getElementById("loginForm").reset();
                document.getElementById("error-message").innerHTML = ""; // Clear error message
            }
        </script>
    </head>
    <body>
        <div class="container">
            <a href="index.jsp" class="close-btn">&#10060;</a>
            <h2>Login Here</h2>

            <!-- Error Message Section -->
            <div id="error-message">
                <% 
                    String errorMessage = (String) request.getAttribute("errorMessage");
                    if (errorMessage != null) { 
                %>
                    <p class="error-message"><%= errorMessage %></p>
                <% } %>
            </div>

            <form id="loginForm" action="LoginServlet" method="post">
                <input type="email" name="email" placeholder="Email" required><br>
                <input type="password" name="password" placeholder="Password" required><br>
                <button type="submit" class="btn btn-primary">Login</button>
                <button type="button" class="btn btn-secondary" onclick="clearForm()">Clear</button>
            </form>
        </div>
    </body>
</html>
