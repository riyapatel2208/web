<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Servlet Info</title>
        <style>
            body {
                font-family: 'Arial', sans-serif;
                background: linear-gradient(to right, #ff7e5f, #feb47b);
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                margin: 0;
            }
            .container {
                background: rgba(255, 255, 255, 0.9);
                padding: 40px;
                border-radius: 10px;
                box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
                text-align: center;
                width: 350px;
            }
            h1 {
                color: #333;
                font-size: 22px;
                margin-bottom: 20px;
            }
            button {
                background-color: #ff4b2b;
                color: white;
                border: none;
                padding: 12px 20px;
                border-radius: 25px;
                font-size: 16px;
                cursor: pointer;
                transition: 0.3s;
                width: 100%;
            }
            button:hover {
                background-color: #ff1e00;
                transform: scale(1.05);
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Welcome to Servlet Information Page</h1>
            <form action="Info" method="get">
                <button type="submit">Get Servlet and Request Details</button>
            </form>
        </div>
    </body>
</html>
