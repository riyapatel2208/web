
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String role = request.getParameter("role");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sem2", "root", "");

            String sql = "INSERT INTO user (first_name, last_name, password, email, phone, address, role) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, password);
            ps.setString(4, email);
            ps.setString(5, phone);
            ps.setString(6, address);
            ps.setString(7, role); // Store role in user table

            ps.executeUpdate();

            String roleSQL = "INSERT INTO user_role (email, role) VALUES (?, ?)";
            PreparedStatement rolePS = conn.prepareStatement(roleSQL);
            rolePS.setString(1, email);
            rolePS.setString(2, role);
            rolePS.executeUpdate();

            out.println("<html><head><title>Success</title>");
            out.println("<style>");
            out.println("body { background: linear-gradient(to right, #6a11cb, #2575fc); color: black; font-family: 'Poppins', sans-serif; text-align: center; padding: 50px; }");
            out.println(".container { background: white; padding: 30px; border-radius: 15px; box-shadow: 0px 5px 15px rgba(0, 0, 0, 0.2); display: inline-block; }");
            out.println("h2 { font-size: 2.5em; margin-bottom: 20px; }");
            out.println("a { text-decoration: none; background: #ff6f61; color: white; padding: 15px 25px; border-radius: 10px; font-size: 1.2em; font-weight: bold; transition: all 0.3s ease-in-out; display: inline-block; margin-top: 20px; }");
            out.println("a:hover { background: #ff3b30; transform: scale(1.1); box-shadow: 0px 0px 15px rgba(255, 107, 107, 0.7); }");
            out.println("</style></head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<h2>&#10003; Registration Successful! &#10003;</h2>");
            out.println("<a href='login.jsp'>Go to Login</a>");
            out.println("</div>");
            out.println("</body></html>");
        } catch (ClassNotFoundException | SQLException e) {
            out.println("<h2 style='color: red;'>Registration Failed! Please try again.</h2>");
        }
    }
}
