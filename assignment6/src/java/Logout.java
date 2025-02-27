/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author AM
 */
public class Logout extends HttpServlet {

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
            HttpSession sn=request.getSession();
            String nm="";
            Integer count=0;
            if(sn!=null && sn.getAttribute("username")!=null)
            {
                nm=(String)sn.getAttribute("username");
                count=(Integer)sn.getAttribute("count");
                if(count == null)
                {
                    count=1;
                }
                else
                {
                    count++;
                }
                sn.setAttribute("count", count);
            }
           // String url = response.encodeURL(request.getRequestURI());
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Logout</title>");  
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
                +"width:550px;"
                +"margin-bottom:50px;"
                +"margin-right: 50px;"
                +"margin-left: 400px;"
                +"margin-top:120px;"
                +"background-color:white;"
                +"height:340px;"
                +"overflow-x:auto;}"  
                +"table{"
                +"margin-left:50px;"
                +"margin-top:60px;}"
                +" input {"
                 +"border-radius: 10px; "
                
                 +"width:100%;"
                 +"padding:10px;"
                 +"background-color:#004B49;"
                 +" color:white;}"
            
                    + "</style>");
                       
           
            out.println("</head>");
            out.println("<body style='background-color:#004B49'>");
            out.print("<div style='text-align:right'><label style='color:white'> Creation Time "+new Date(sn.getCreationTime())+"</label></div>");
            out.println("<div class='main'>"
                  
                    +"<table>"
                       +"<tr><td style='text-align:center'><label>Hello " +nm+"</label></td></tr>"
                       +"<tr><td style='text-align:center'><label>Access Count " +count+"</label></td></tr>"
                       +"<tr><td style='text-align:center'><label>Session information</label></td></tr>"
                       +"<tr>"
                               + "<td>"
                                      +"<ul><label>"
                                         + "<li>Session ID "+sn.getId()+"</li>"
                                         + "<li>Creation Time "+new Date(sn.getCreationTime())+"</li>"
                                         + "<li>Last Accessed Time "+new Date(sn.getLastAccessedTime())+"</li>"
                                      + "</label></ul>"
                               + "</td>"
                       + "</tr>"
                       +"<tr>"
                               + "<td style='text-align:center'>"
                                     +"<form action='LastPage' method='post'><input type='submit' value='Logout'></form>"
                               + "</td>"
                       + "</tr>"                          
                    +"</table>"
                    + "</div>");
            out.println("</body>");
            out.println("</html>");
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
