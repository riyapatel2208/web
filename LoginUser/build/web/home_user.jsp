<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registered User Home</title>
    <style>
        body { text-align: center; font-family: Arial, sans-serif; padding-top: 50px; background: linear-gradient(to right, #00b09b, #96c93d); }
        .container { width: 400px; background: white; padding: 20px; margin: auto; border-radius: 10px; box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.2); }
        .logout-btn {
                display: inline-block;
                padding: 12px 25px;
                font-size: 16px;
                font-weight: bold;
                color: white;
                background: #ff6f61;
                text-decoration: none;
                border-radius: 8px;
                border: none;
                transition: 0.3s ease-in-out;
                box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.2);
            }

            .logout-btn:hover {
                background: #ff3b30;
                transform: scale(1.05);
                box-shadow: 0px 0px 15px rgba(255, 107, 107, 0.7);
            }
    </style>
</head>
<body>
    <div class="container">
        <h2>Welcome, Registered User!</h2>
        <p>You have limited access.</p>
        <a href="index.jsp" class="logout-btn">Logout</a>
    </div>
</body>
</html>
