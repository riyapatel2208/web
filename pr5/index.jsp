<%@ page import="java.sql.*" %>
<html>
<head><title>User List</title></head>
<body>
    <h2>User List</h2>
    <table border="1">
        <tr><th>ID</th><th>Name</th><th>Email</th><th>Actions</th></tr>
        <%
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb", "root", "");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("id") %></td>
            <td><%= rs.getString("name") %></td>
            <td><%= rs.getString("email") %></td>
            <td>
                <a href="edit-user.jsp?id=<%= rs.getInt("id") %>">Edit</a>
                <form action="UserServlet" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" value="<%= rs.getInt("id") %>">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
        <% } conn.close(); %>
    </table>
    <br>
    <a href="add-user.jsp">Add New User</a>
</body>
</html>
