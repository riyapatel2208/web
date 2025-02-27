/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AM
 */
public class viewdata extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Connection con;
            PreparedStatement ps;
            ResultSet rs;
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","");
            String done=request.getParameter("done");
            if("true".equals(done))
            {
               out.print("<script>");
               out.print("alert('data upadate sucessfully')");
               out.print("</script>");
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet viewdata</title>");   
            out.println("<script>"
                    +"function ondelete(){"
                    +"return confirm('Are you sure to delete this record');}"
                    + "</script>");
             out.println("<style>"
                    +"label{"
                  
                  +"width:100%;"
                  +"margin-top:10px;"
                  +"margin-bottom:5px;"
                  +"font-style: bold;"
                  +"color: #555;}"
                    
                    +"body{"
                    +"font-family: sans-serif;}"
                    
                    +".main{"
                +"border:1px solid #ddd;"
                +"border-radius:5px;"
                +"width:800px;"
                +"margin-bottom:50px;"
                +"margin-right: 50px;"
                +"margin-left:250px;"
                +"margin-top:1px;"
                +"background-color:white;"
                +"height:300px;"
                +"overflow-x:auto;}"
                    
                 +".tdv{"
                  +"margin-left:90px;"
                  +"font-style: bold;"
                  +"color: #555;"
                  +"align: center;"
                  +"margin-bottom:15px;"
                  +"font-size:30px;}"
                    
                 +"table{"
                +"margin-left:200px;"
                +"margin-top:10px;}"
                +" button {"
                 +"border-radius: 10px; "
                
                 +"width:100%;"
                 +"padding:10px;"
                 +" background-color:#1d415e;"
                 +" color:white;}"
                 
                   +".main2{"
                
                +"border-radius:5px;"
                +"width:800px;"
                +"margin-right: 50px;"
                +"margin-left:250px;"
                +"margin-top:120px;"
                +"background-color:#1d415e;}"
              
            
                    + "</style>");
                       
           
            out.println("</head>");
            out.println("<body style='background-color:#1d415e'>");
          
            ps=con.prepareStatement("select * from studs");
            rs=ps.executeQuery();
            out.println("<div class='main2'><form action='index.jsp'><button type='submit'>ADD STUDENT</button></form></div>");
            out.println("<div class='main'><table cellspacing='15'>");
           // out.println("<div style='margin:10px'><form action='index.jsp'><button type='submit'>ADD STUDENT</button></form></div>");
            out.println("<tr><td><label>ID</label></td><td><label>NAME</label></td><td><label>CORSE</label></td><td><label>EDIT</label></td><td><label>DELETE</label></td></tr>");
            while(rs.next())
            {
                out.println("<tr>"
                            +"<td><label>"+rs.getInt("sid")+"</label></td>"
                            +"<td><label>"+rs.getString("snm")+"</label></td>"
                            +"<td><label>"+rs.getString("course")+"</label></td>"
                            +"<td>"
                                 +"<form action=update.jsp method=post>"
                                    +"<input type='hidden' name='sid' value='"+rs.getInt("sid")+"'>"
                                    +"<input type='hidden' name='snm' value='"+rs.getString("snm")+"'>"
                                    +"<input type='hidden' name='course' value='"+rs.getString("course")+"''>"
                                    +"<button type='submit' value='edit' style='width:60px'> Edit </button>"
                                 +"</form>"
                            +"</td>"
                             +"<td>"
                                 +"<form action=delete_data method=post onsubmit='return ondelete()'>"
                                    +"<input type='hidden' name='sid' value='"+rs.getInt("sid")+"'>"
                                    +"<button type='submit' value='delete'>Delete</button>"
                                 +"</form>"
                            +"</td>"
                          //  +"<td><a href='update.jsp?sid="+rs.getInt("sid")+"&snm="+rs.getString("snm")+"&course="+rs.getString("course")+"'><label>Edit</label></a></td>"
                           // +"<td><a href='index.jsp?sid="+rs.getInt("sid")+"&snm="+rs.getString("snm")+"&course="+rs.getString("course")+"'><label>Delete</label></a></td></tr>"
                            );
            }
            out.println("</table></div>");
            
            out.println("</body>");
            out.println("</html>");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(viewdata.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(viewdata.class.getName()).log(Level.SEVERE, null, ex);
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
