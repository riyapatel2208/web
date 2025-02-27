package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class signup_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Signup</title>\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            font-family: Arial, sans-serif;\n");
      out.write("            background: linear-gradient(to right, #6a11cb, #2575fc);\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: center;\n");
      out.write("            align-items: center;\n");
      out.write("            height: 100vh;\n");
      out.write("            margin: 0;\n");
      out.write("            position: relative;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .container {\n");
      out.write("            background: white;\n");
      out.write("            padding: 25px;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.2);\n");
      out.write("            width: 400px;\n");
      out.write("            text-align: center;\n");
      out.write("            position: relative;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .close-btn {\n");
      out.write("            position: absolute;\n");
      out.write("            top: 10px;\n");
      out.write("            right: 10px;\n");
      out.write("            font-size: 20px;\n");
      out.write("            font-weight: bold;\n");
      out.write("            color: red;\n");
      out.write("            text-decoration: none;\n");
      out.write("            cursor: pointer;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .close-btn:hover {\n");
      out.write("            color: darkred;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        h2 {\n");
      out.write("            color: #333;\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        input, select, textarea {\n");
      out.write("            width: 95%;\n");
      out.write("            padding: 10px;\n");
      out.write("            margin: 8px 0;\n");
      out.write("            border: 1px solid #ccc;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            font-size: 16px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        textarea {\n");
      out.write("            resize: none;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .btn {\n");
      out.write("            width: 48%;\n");
      out.write("            padding: 12px;\n");
      out.write("            margin-top: 10px;\n");
      out.write("            border: none;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            cursor: pointer;\n");
      out.write("            font-size: 16px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .btn-primary {\n");
      out.write("            background: #6a11cb;\n");
      out.write("            color: white;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .btn-primary:hover {\n");
      out.write("            background: #4c0d9a;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .btn-secondary {\n");
      out.write("            background: #ccc;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .btn-secondary:hover {\n");
      out.write("            background: #999;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("\n");
      out.write("    <script>\n");
      out.write("        function validateForm() {\n");
      out.write("            let firstName = document.getElementById(\"firstName\").value;\n");
      out.write("            let lastName = document.getElementById(\"lastName\").value;\n");
      out.write("            let password = document.getElementById(\"password\").value;\n");
      out.write("            let confirmPassword = document.getElementById(\"confirmPassword\").value;\n");
      out.write("            let email = document.getElementById(\"email\").value;\n");
      out.write("            let phone = document.getElementById(\"phone\").value;\n");
      out.write("            let address = document.getElementById(\"address\").value;\n");
      out.write("            let role = document.getElementById(\"role\").value;\n");
      out.write("            let emailPattern = /^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$/;\n");
      out.write("            let namePattern = /^[A-Za-z]{6,}$/;\n");
      out.write("            let phonePattern = /^[0-9]{10}$/;\n");
      out.write("\n");
      out.write("            if (!namePattern.test(firstName)) {\n");
      out.write("                alert(\"First Name should contain only alphabets and be at least 6 characters.\");\n");
      out.write("                return false;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            if (!namePattern.test(lastName)) {\n");
      out.write("                alert(\"Last Name should contain only alphabets and be at least 6 characters.\");\n");
      out.write("                return false;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            if (password.length < 6) {\n");
      out.write("                alert(\"Password must be at least 6 characters.\");\n");
      out.write("                return false;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            if (password !== confirmPassword) {\n");
      out.write("                alert(\"Passwords do not match.\");\n");
      out.write("                return false;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            if (!emailPattern.test(email)) {\n");
      out.write("                alert(\"Enter a valid email.\");\n");
      out.write("                return false;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            if (!phonePattern.test(phone)) {\n");
      out.write("                alert(\"Phone number must be exactly 10 digits.\");\n");
      out.write("                return false;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            if (address.trim() === \"\") {\n");
      out.write("                alert(\"Address cannot be empty.\");\n");
      out.write("                return false;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            if (role === \"\") {\n");
      out.write("                alert(\"Please select a user role.\");\n");
      out.write("                return false;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            return true;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function clearForm() {\n");
      out.write("            document.getElementById(\"signupForm\").reset();\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <a href=\"index.jsp\" class=\"close-btn\">&#10060;</a>\n");
      out.write("        <h2>Registration Form</h2>\n");
      out.write("        <form id=\"signupForm\" action=\"RegisterServlet\" method=\"post\" onsubmit=\"return validateForm();\">\n");
      out.write("            <input type=\"text\" id=\"firstName\" name=\"firstName\" placeholder=\"First Name\" required><br>\n");
      out.write("            <input type=\"text\" id=\"lastName\" name=\"lastName\" placeholder=\"Last Name\" required><br>\n");
      out.write("            <input type=\"password\" id=\"password\" name=\"password\" placeholder=\"Password\" required><br>\n");
      out.write("            <input type=\"password\" id=\"confirmPassword\" name=\"confirmPassword\" placeholder=\"Confirm Password\" required><br>\n");
      out.write("            <input type=\"email\" id=\"email\" name=\"email\" placeholder=\"Email\" required><br>\n");
      out.write("            <input type=\"text\" id=\"phone\" name=\"phone\" placeholder=\"Phone Number\" required><br>\n");
      out.write("            <input type=\"text\" id=\"address\" name=\"address\" placeholder=\"Address\" required><br>\n");
      out.write("            <select id=\"role\" name=\"role\">\n");
      out.write("                <option value=\"\">Select Role</option>\n");
      out.write("                <option value=\"admin\">Admin</option>\n");
      out.write("                <option value=\"registered\">Registered User</option>\n");
      out.write("                <option value=\"guest\">Guest</option>\n");
      out.write("            </select><br>\n");
      out.write("            <button type=\"submit\" class=\"btn btn-primary\">Register</button>\n");
      out.write("            <button type=\"button\" class=\"btn btn-secondary\" onclick=\"clearForm()\">Clear</button>\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("</body>\n");
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
