<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Compound Interest Calculator</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background: linear-gradient(to right, #6a11cb, #92a8cf);
                color: #e00d0d;
                margin: 0;
                padding: 0;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }
            .form-container {
                background-color: rgba(255, 255, 255, 0.9);
                padding: 30px;
                border-radius: 10px;
                box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
                width: 400px;
                box-sizing: border-box;
            }

            h2 {
                text-align: center;
                color: #333;
                margin-top: 0;
                padding-bottom: 6px;
            }

            label {
                display: block;
                font-size: 16px;
                margin-bottom: 5px;
            }

            input[type="text"],
            select {
                width: 100%;
                padding: 10px;
                margin-bottom: 15px;
                border: 1px solid #ddd;
                border-radius: 5px;
                box-sizing: border-box;
            }

            input[type="text"]:focus,
            select:focus {
                border-color: #2575fc;
                outline: none;
            }

            button {
                width: 100%;
                padding: 12px;
                background-color: #2575fc;
                color: white;
                border: none;
                border-radius: 5px;
                font-size: 16px;
                cursor: pointer;
                transition: background-color 0.3s ease;
            }

            button:hover {
                background-color: #6a11cb;
            }

            form {
                margin: 0;
                background-color: white;
                padding: 20px;
                border-radius: 20px;
            }
        </style>
        <script>
            function validateForm() {
                let principal = document.forms["ciForm"]["principal"].value;
                let rate = document.forms["ciForm"]["rate"].value;
                let years = document.forms["ciForm"]["years"].value;
                let months = document.forms["ciForm"]["months"].value;
                let days = document.forms["ciForm"]["days"].value;
                let interval = document.forms["ciForm"]["interval"].value;

                if (principal === "" || isNaN(principal) || principal <= 0) {
                    alert("Principal must be a positive number and can not be empty.");
                    return false;
                }
                if (rate === "" || isNaN(rate) || rate <= 0) {
                    alert("Rate of interest must be a positive number and can not be empty.");
                    return false;
                }
                if (years === "" || isNaN(years) || years < 0 || years > 50) {
                    alert("Years must be a non-negative number (max 50 and can not be empty).");
                    return false;
                }
                if (months === "" || isNaN(months) || months < 0 || months > 12) {
                    alert("Months must be between 0 and 12 and can not be empty.");
                    return false;
                }
                if (days === "" || isNaN(days) || days < 0 || days > 31) {
                    alert("Days must be between 0 and 31 and can not be empty.");
                    return false;
                }
                if (interval === "") {
                    alert("Please select a compound interval.");
                    return false;
                }
                return true;
            }
        </script>
    </head>
    <body>
        <div class="container">
            <form name="ciForm" action="CalculateCompoundInterestServlet1" method="post" onsubmit="return validateForm()">
                <h2>Compound Interest Calculator</h2>
                <label for="principal">Principal Amount:</label>
                <input type="text" id="principal" name="principal" placeholder="Enter principal amount"><br>

                <label for="rate">Rate of Interest (% per year):</label>
                <input type="text" id="rate" name="rate" placeholder="Enter rate of interest"><br>

                <label for="years">Years:</label>
                <input type="text" id="years" name="years" placeholder="Enter number of years"><br>

                <label for="months">Months:</label>
                <input type="text" id="months" name="months" placeholder="Enter number of months (0-12)"><br>

                <label for="days">Days:</label>
                <input type="text" id="days" name="days" placeholder="Enter number of days (0-31)"><br>

                <label for="interval">Compound Interval:</label>
                <select id="interval" name="interval">
                    <option value="">Select Interval</option>
                    <option value="1">Annually(1)</option>
                    <option value="2">Semi-Annually(2)</option>
                    <option value="4">Quarterly(4)</option>
                    <option value="12">Monthly(12)</option>
                    <option value="365">Daily(365)</option>
                </select><br>

                <button type="submit">Calculate</button>
            </form>
        </div>
    </body>
</html>
