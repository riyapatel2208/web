<%-- 
    Document   : index
    Created on : 1 Mar, 2024, 9:00:21 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
        div.result {
            margin: auto;
            display: flex;
            justify-content: center;
            align-items: center;
            text-align: center;
            font-weight: bold;
        }

        label,
        input,
        button {
            display: block;
        }

        table,
        td {
            border: 1px solid #317c31;
            border-collapse: collapse;
            padding: 10px;
        }

        h3 {
            text-align: center;
        }

        label {
            font-weight: bold;
        }

        input[type="submit"],input[type="reset"] {
            padding: 10px 20px;
            background-color: #317c31;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin: auto;
            font-weight: bold;
        }
        #btn1{
            padding: 10px 20px;
            background-color: lime;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin: auto;
            font-weight: bold;
       }
       </style>
    </head>
    <body>
        <h3>Registration Form</h3>
    <div class="result">
         <% if("correct".equals(request.getAttribute("insertst"))) {%>
            <script>
                alert("Data submitted successfully!");
            </script>
        <%}%>
        <form name="registration" method="get" action="UserDatabase"  onsubmit="return validateForm()">
            
            <table>
                <tr>
                    <td>
                        <label for="first_name">First Name:</label>
                    </td>
                    <td>
                        <input type="text" id="first_name"  placeholder="Enter Your First Name" name="first_name" onfocusout="FristNameValid()">
                        <span id="error1" class="red"></span>
                    </td>

                </tr>
                <tr>
                    <td>
                        <label for="last_name">Last Name:</label>
                    </td>
                    <td>
                        <input type="text" id="last_name" placeholder="Enter Your Second Name" name="last_name" onfocusout="SecondNameValid()">
                        <span id="error2" class="red"></span>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="email">Email:</label>
                    </td>
                    <td>
                        <input type="email" id="email" name="email" placeholder="Enter Your Email Id" onfocusout="EmailValid()">
                        <span id="error3" class="red"></span>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="Password">Password </label>
                    </td>
                    <td>
                        <input type="password" id="Password" placeholder="Password less then 6 characters" name="Password" onfocusout="PassValid()">
                        <span id="error4" class="red"></span>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="ConformPassword">Conform Password </label>
                    </td>
                    <td>
                        <input type="password" id="Conform" placeholder="ReEnter Password" name="Password" onfocusout="SemPassValid()">
                        <span id="error5" class="red"></span>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="Number">Mobile Number</label>
                    </td>
                    <td>
                        <input type="text" id="Number" name="Number" onfocusout="NumberValid()">
                        <span id="error6" class="red"></span>
                    </td>
                </tr>
                <tr>
                <td>
                    <label for="add">Address</label><br>
                </td>

                <td>
                    <textarea name="add" id="add" cols="30" rows="5" required></textarea>
                     <span id="error7" class="red"></span>    
                </td>
                </tr>

                <tr>
                <td>
                    <label for="Role">Choose a Role:</label>
                </td>
                <td>
                    <select name="Role" id="res" required>

                        <option value="">Selcect Option</option>
                        <option value="101">Admin</option>
                        <option value="102">Registered User</option>
                        <option value="103">Guest </option>
                  
                    </select>
                    <span id="error5" class="red"></span>
                </td>
            </tr>

                <tr>
                   <td><input type="reset" value="Reset" name="reset"></td> <td colspan="2"><input type="submit" value="Register" name="submit"></td>
                </tr>

            </table>
        </form>
    </div>

    <script>
         var emailRegex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
         var nameRegex = /^[A-Za-z]+$/;
         var Isnumber = /^\d+$/;
         function FristNameValid(){
             var firstName = document.forms["registration"]["first_name"].value;
            
            if(!(nameRegex.test(firstName))){
                document.getElementById("error1").innerHTML = "Please Enter Valid Name";
                 document.getElementById("first_name").value="";
                return false;
            }
            else{
                document.getElementById("error1").innerHTML="";
                 return true;
            }
         }
         function SecondNameValid(){
            var lastName = document.forms["registration"]["last_name"].value;
            if(!(nameRegex.test(lastName))){
                document.getElementById("error2").innerHTML = "Please Enter Valid Name";
                 document.getElementById("lastName").value="";
                return false;
            }
            else{
                document.getElementById("error2").innerHTML="";
                 return true;
            }
         } 
         function EmailValid(){
             var email = document.forms["registration"]["email"].value;
             if(!(emailRegex.test(email))){
                document.getElementById("error3").innerHTML = "Please Enter Valid Email";
                 document.getElementById("email").value="";
                return false;
            }
            else{
                document.getElementById("error3").innerHTML="";
                 return true;
            }
         }
         function PassValid(){
              var Password = document.getElementById("Password").value;
              if(Password.length < 6){
                  document.getElementById("error4").innerHTML = "Password less 6 Charector";
                 document.getElementById("Password").value="";
                return false;
              }
              else{
                document.getElementById("error4").innerHTML="";
                 return true;
                }
         }
         function SemPassValid(){
             var Password = document.getElementById("Password").value;
             var cPassword = document.getElementById("Conform").value;
              if(Password != cPassword ){
                  document.getElementById("error5").innerHTML = "Enter a sem Password";
                 document.getElementById("Conform").value="";
                return false;
              }
              else{
                document.getElementById("error5").innerHTML="";
                 return true;
                }
         }
         function NumberValid(){
             var Number = document.forms["registration"]["Number"].value;
             if(!(Isnumber.test(Number)) || Number.length != 10){
                 document.getElementById("error6").innerHTML = "Enter a Valid Number";
                 document.getElementById("Number").value="";
                return false;
             }
             else{
                document.getElementById("error6").innerHTML="";
                 return true;  
             }
         }
         
    function validateForm() {
            if(FristNameValid() && SecondNameValid() && EmailValid() && PassValid() && SemPassValid() )  {
             return true; 
            }
            else{
                return false;
            }
        }
    </script>
    </body>
</html>
