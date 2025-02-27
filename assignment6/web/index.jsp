<%-- 
    Document   : index
    Created on : 28 Feb, 2024, 8:15:16 PM
    Author     : AM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
             body{
                font-family: sans-serif;
            }
            input{
                margin-top:10px;
                margin-bottom:10px;
                width:90%;
                padding:10px;
                border:1px solid #ddd;
                border-radius:5px;
            }
            button{
                width: 97%;
                margin-top:10px;
                margin-bottom:10px;
                height:35px;
                background-color:#004B49;
                color:white;
                border-radius:5px;
                
            }
            table{
                margin-top:20%;
                margin-bottom:20%;
                width:300px;
            }
            .main{
                border:1px solid #ddd;
                border-radius:5px;
                width:400px;
                margin-bottom:50px;
                margin-right: 50px;
                margin-left: 400px;
                margin-top:120px;
                background-color:white;
                    
                
            }
            .wdt
            {
                 width:200px;
            }
            
            
        </style>
         
    </head>
    <body style="background-color:#004B49;">
       <form method="post" onsubmit="return validate()" action="Sixthservalet">
            <div class="main" align="center">
                
            <table>
                <tr><td style="text-align:center"><label>Login</label></td></tr>
                <tr>
                    <td><input type="text" name="unm" id="unm" placeholder="Enter Name"></td>
                   
                </tr>
                
                <tr>
                <div class="wdt"><td><button type="submit"><label>submit</label></button></td></div>
                   
                </tr>
            </table>
            </div>
        </form>
        <script>
            var snm=/^[a-zA-Z]+$/;
            function validate()
            {
                
                if(snm.test(document.getElementById("unm").value)==false)
                {
                    alert("Enter only alphabet");
                    document.getElementById("unm").value="";
                    return false;
                }
               
            }
        </script>
    </body>
</html>
