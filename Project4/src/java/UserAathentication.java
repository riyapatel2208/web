/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Statement;
import java.sql.*;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Admin
 */
public class UserAathentication extends HttpServlet {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        ResultSet rs1 = null;
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
             String umail=request.getParameter("User");
             String upwd=request.getParameter("Password");
             String Role = null;
            Class.forName("com.mysql.jdbc.Driver");
            HttpSession sesstion = request.getSession();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/parikshit_20","root","");
            st= con.createStatement();
            rs = st.executeQuery("SELECT  `Umail`,`Upwd`,`UserRole_Id`,`Ufname` FROM `user_info` WHERE Umail = '" + umail + "' && Upwd ='" + upwd + "'");
            if(rs.next()){
               
               
                sesstion.setAttribute("UserName", rs.getString("Ufname"));
                sesstion.setAttribute("UserEmail", rs.getString("Umail"));
                rs1 = st.executeQuery("SELECT `Role_Name` FROM `user_role` WHERE UserRole_Id = " + rs.getInt("UserRole_Id"));
                System.out.println("Helloo");
            }
            else{
                 request.setAttribute("User", "Not");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            if(rs1.next()){
                
                Role = rs1.getString("Role_Name");
                sesstion.setAttribute("User",Role);
                 response.sendRedirect("Home.jsp");
//              
            }
//            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserAathentication</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserAathentication at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
        catch(SQLException se){
            se.printStackTrace();
        }
        catch(ClassNotFoundException ce){
            ce.printStackTrace();
        }
        catch(Exception e){
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
