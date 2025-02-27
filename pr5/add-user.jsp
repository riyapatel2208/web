<html>
<head><title>Add User</title></head>
<body>
    <h2>Add User</h2>
    <form action="UserServlet" method="post">
        <input type="hidden" name="action" value="add">
        Name: <input type="text" name="name" required><br>
        Email: <input type="email" name="email" required><br>
        <input type="submit" value="Add User">
    </form>
</body>
</html>
