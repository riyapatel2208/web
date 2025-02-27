/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author Admin
 */
public class UserDatabase extends HttpServlet {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String ufnm = request.getParameter("first_name");
            String ulnm = request.getParameter("last_name");
            String upwd = request.getParameter("Password");
            String umail = request.getParameter("email");
            String umno = request.getParameter("Number");
            String uddr = request.getParameter("add");
            int ur = Integer.parseInt(request.getParameter("Role"));

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/parikshit_20", "root", "");
            ps = con.prepareStatement("select * from user_info where Umail=?");
            ps.setString(1, umail);
            rs = ps.executeQuery();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserDatabase</title>");
            out.println("</head>");
            out.println("<body>");
            if (rs.next()) {
                out.println("<h1>user already exixst</h1>");
//           
            } else {
                ps = con.prepareStatement("insert into user_info(`Ufname`, `Ulname`, `Upwd`, `Umail`, `Umno`, `Uaddres`, `UserRole_Id`) values(?,?,?,?,?,?,?)");

                ps.setString(1, ufnm);
                ps.setString(2, ulnm);
                ps.setString(3, upwd);
                ps.setString(4, umail);
                ps.setString(5, umno);
                ps.setString(6, uddr);
                ps.setInt(7, ur);
                ps.executeUpdate();
                out.println("<h1>Data submitted successfully!</h1>");
//             
            }

            out.println("</html>");
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (ClassNotFoundException ce) {
            ce.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
