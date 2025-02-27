import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String errorMessage = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sem2", "root", "")) {
                String sql = "SELECT u.password, r.role FROM user u JOIN user_role r ON u.email = r.email WHERE u.email = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, email);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    String dbPassword = rs.getString("password");
                    String role = rs.getString("role");

                    if (dbPassword.equals(password)) {
                        switch (role) {
                            case "admin":
                                response.sendRedirect("home_admin.jsp");
                                break;
                            case "registered":
                                response.sendRedirect("home_user.jsp");
                                break;
                            default:
                                response.sendRedirect("home_guest.jsp");
                                break;
                        }
                        return;
                    } else {
                        errorMessage = "Invalid Password!";
                    }
                } else {
                    errorMessage = "User Not Found!";
                }
            }
        } catch (IOException | ClassNotFoundException | SQLException e) {
            errorMessage = "Error: " + e.getMessage();
        }

        // Send error message back to login.jsp
        request.setAttribute("errorMessage", errorMessage);
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }
}
