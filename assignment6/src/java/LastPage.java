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
public class LastPage extends HttpServlet {

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
            if(sn!=null)
            {
                nm=(String)sn.getAttribute("username");
                long duration=System.currentTimeMillis()-sn.getCreationTime();
                long min=duration/1000;
                long sec=min/60;
                sec=sec%60;
                sn.invalidate();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LastPage</title>");            
            out.println("</head>");
            out.print("<style>"
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
                +"margin-left: 350px;"
                +"margin-top:120px;"
                +"background-color:white;"
                +"height:340px;"
                +"overflow-x:auto;}"  
                +"table{"
                +"margin-left:100px;"
                +"margin-top:130px;}"
                    + "</style>");
            out.println("<body style='background-color:#004B49'>");
             out.println("<div class='main'>"
                  
                    +"<table cellspacing=15>"
                       +"<tr><td style='text-align:center'><label>Thank you " +nm+"</label></td></tr>"
                       +"<tr><td style='text-align:center'><label>Session duration: " + min + " minutes " + sec +  " seconds"+"</label></td></tr>"
                                            
                    +"</table>"
                    + "</div>");
            out.println("</body>");
            out.println("</html>");
            }
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
