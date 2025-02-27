<%-- 
    Document   : update
    Created on : 2 Mar, 2024, 8:47:28 PM
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
           label{
                  
                  width:100%;
                  margin-top:10px;
                  margin-bottom:5px;
                  font-style: bold;
                  color: #555;
            }
            input{
                
                width:100%;
                padding: 10px;
                border:1px solid #ddd;
                border-radius:5px;
             }
             .main{
                border:1px solid #ddd;
                border-radius:5px;
                width:500px;
                margin-bottom:50px;
                margin-right: 50px;
                margin-left: 350px;
                margin-top:120px;
                background-color:white;
                height: 420px;
             }
             button
            {
                 border-radius: 10px; 
                 margin-top: 15px;
                 width:100%;
                 padding:10px;
                 background-color:#1d415e;
                 color:white;
             }
             
           table{
                margin-top:20%;
                margin-bottom:20%;
                width:300px;
              }
        </style>
        <script>
            var sid=/^[0-9]+$/;
            var snm=/^[a-zA-Z]+$/;
            function validate()
            {
                if(sid.test(document.getElementById("sid").value)==false)
                {
                    alert("Enter only numeric");
                   
                    return false;
                } 
                if(snm.test(document.getElementById("snm").value)==false)
                {
                    alert("Enter only alphabet in name ");
                    
                    return false;
                }
                if(snm.test(document.getElementById("sc").value)==false)
                {
                    alert("Enter only aalphabet in course ");
                    return false;
                }
               
            }
        </script>
 
    </head>
    <body style="background-color:#1d415e">
        <%
        String id=request.getParameter("sid");
        String nm=request.getParameter("snm");
        String cs=request.getParameter("course");
        if(id==null && nm==null && cs==null)
        {
            id="";
            nm="";
            cs="";
        }
    %>
        <div class="main">
            <form onsubmit="return validate()" action="update_data" method="post">
                <table align="center">
                <tr>
                    <td><label>Student id</label></td>
                    <td><input type="text" name="sid" id="sid"  placeholder="Id" value="<%=id%>"></td>
                </tr>
                
                <tr>
                    <td><label>Student name</label></td>
                    <td><input type="text" name="snm" id="snm" placeholder="Name" value="<%=nm%>"></td>
                </tr>
                
                 <tr>
                    <td><label>course</label></td>
                    <td><input type="text" name="sc" id="sc"placeholder="Course" value="<%=cs%>"></td>
                </tr>
                
                <tr>
                    <td colspan="2"><button type="submit" name="update" value="upadte">upadte</button></td>
                    
                </tr>
               
                </table>
            </form>
        </div>
    </body>
</html>
