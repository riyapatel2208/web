package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <style>\n");
      out.write("             body{\n");
      out.write("                font-family: sans-serif;\n");
      out.write("            }\n");
      out.write("            input{\n");
      out.write("                margin-top:10px;\n");
      out.write("                margin-bottom:10px;\n");
      out.write("                width:90%;\n");
      out.write("                padding:10px;\n");
      out.write("                border:1px solid #ddd;\n");
      out.write("                border-radius:5px;\n");
      out.write("            }\n");
      out.write("            button{\n");
      out.write("                width: 97%;\n");
      out.write("                margin-top:10px;\n");
      out.write("                margin-bottom:10px;\n");
      out.write("                height:35px;\n");
      out.write("                background-color:#004B49;\n");
      out.write("                color:white;\n");
      out.write("                border-radius:5px;\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("            table{\n");
      out.write("                margin-top:20%;\n");
      out.write("                margin-bottom:20%;\n");
      out.write("                width:300px;\n");
      out.write("            }\n");
      out.write("            .main{\n");
      out.write("                border:1px solid #ddd;\n");
      out.write("                border-radius:5px;\n");
      out.write("                width:400px;\n");
      out.write("                margin-bottom:50px;\n");
      out.write("                margin-right: 50px;\n");
      out.write("                margin-left: 400px;\n");
      out.write("                margin-top:120px;\n");
      out.write("                background-color:white;\n");
      out.write("                    \n");
      out.write("                \n");
      out.write("            }\n");
      out.write("            .wdt\n");
      out.write("            {\n");
      out.write("                 width:200px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            \n");
      out.write("        </style>\n");
      out.write("         <script>\n");
      out.write("            var snm=/^[a-zA-Z]+$/;\n");
      out.write("            function validate()\n");
      out.write("            {\n");
      out.write("                \n");
      out.write("                if(snm.test(document.getElementById(\"unm\").value)==false)\n");
      out.write("                {\n");
      out.write("                    alert(\"Enter only alphabet\");\n");
      out.write("                    document.getElementById(\"unm\").value=\"\";\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("               \n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body style=\"background-color:#004B49;\">\n");
      out.write("       <form method=\"post\" onsubmit=\"return validate()\" action=\"Sixthservalet\">\n");
      out.write("            <div class=\"main\" align=\"center\">\n");
      out.write("                \n");
      out.write("            <table>\n");
      out.write("                <tr><td style=\"text-align:center\"><label>Login</label></td></tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><input type=\"text\" name=\"unm\" id=\"unm\" placeholder=\"Enter Name\"></td>\n");
      out.write("                   \n");
      out.write("                </tr>\n");
      out.write("                \n");
      out.write("                <tr>\n");
      out.write("                <div class=\"wdt\"><td><button type=\"submit\"><label>submit</label></button></td></div>\n");
      out.write("                   \n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
