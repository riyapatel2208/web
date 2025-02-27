import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    private static final String URL = "jdbc:mysql://localhost:3306/userdb";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            if ("add".equals(action)) {
                PreparedStatement ps = conn.prepareStatement("INSERT INTO users (name, email) VALUES (?, ?)");
                ps.setString(1, request.getParameter("name"));
                ps.setString(2, request.getParameter("email"));
                ps.executeUpdate();
            } else if ("update".equals(action)) {
                PreparedStatement ps = conn.prepareStatement("UPDATE users SET name=?, email=? WHERE id=?");
                ps.setString(1, request.getParameter("name"));
                ps.setString(2, request.getParameter("email"));
                ps.setInt(3, Integer.parseInt(request.getParameter("id")));
                ps.executeUpdate();
            } else if ("delete".equals(action)) {
                PreparedStatement ps = conn.prepareStatement("DELETE FROM users WHERE id=?");
                ps.setInt(1, Integer.parseInt(request.getParameter("id")));
                ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("index.jsp");
    }
}
