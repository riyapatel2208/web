<%@ page import="java.sql.*" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb", "root", "");
    PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE id=?");
    ps.setInt(1, id);
    ResultSet rs = ps.executeQuery();
    rs.next();
%>
<html>
<head><title>Edit User</title></head>
<body>
    <h2>Edit User</h2>
    <form action="UserServlet" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="<%= rs.getInt("id") %>">
        Name: <input type="text" name="name" value="<%= rs.getString("name") %>" required><br>
        Email: <input type="email" name="email" value="<%= rs.getString("email") %>" required><br>
        <input type="submit" value="Update User">
    </form>
</body>
</html>
