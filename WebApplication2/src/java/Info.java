import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Info")
public class Info extends HttpServlet {
    private String appName;
    private String version;
    
    @Override 
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        appName = config.getInitParameter("appName");
        version = config.getInitParameter("version");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Servlet Info</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background: linear-gradient(to right, #4facfe, #00f2fe);");
        out.println("display: flex; justify-content: center; align-items: center; padding: 80px; margin: 0;}");
        out.println(".container { background: rgba(255, 255, 255, 0.9); overflow-wrap: break-word; padding: 20px; border-radius: 10px;");
        out.println("box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2); width: 80%; max-width: 700px;}");
        out.println("h1, h2 { text-align: center; color: #333;}");
        out.println("ul { list-style: none; padding: 0;}");
        out.println("li { padding: 8px; background: white; margin: 5px 0; border-radius: 5px; box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);}");
        out.println(".back-button { display: block; margin: 20px auto; padding: 10px 15px; background: #ff5733; color: white;");
        out.println("border: none; border-radius: 5px; cursor: pointer; text-align: center; font-size: 16px; text-decoration: none;}");
        out.println(".back-button:hover { background: #e74c3c; }");
        out.println("</style>");
        out.println("</head><body>");
        out.println("<div class='container'>");

        out.println("<h1>Servlet Information</h1>");

        // Init Parameters
        out.println("<h2>Initialization Parameters</h2>");
        out.println("<ul>");
        ServletConfig config = getServletConfig();
        Enumeration<String> initParams = config.getInitParameterNames();
        while (initParams.hasMoreElements()) {
            String paramName = initParams.nextElement();
            out.println("<li><b>" + paramName + ":</b> " + config.getInitParameter(paramName) + "</li>");
        }
        out.println("</ul>");

        // Request Headers
        out.println("<h2>Request Headers</h2>");
        out.println("<ul>");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            out.println("<li><b>" + headerName + ":</b> " + request.getHeader(headerName) + "</li>");
        }
        out.println("</ul>");

        // Client/Browser Info
        out.println("<h2>Client & Browser Info</h2>");
        out.println("<ul>");
        out.println("<li><b>Remote Address:</b> " + request.getRemoteAddr() + "</li>");
        out.println("<li><b>Remote Host:</b> " + request.getRemoteHost() + "</li>");
        out.println("<li><b>User-Agent:</b> " + request.getHeader("User-Agent") + "</li>");
        out.println("</ul>");

        // Server Info
        out.println("<h2>Server Information</h2>");
        out.println("<ul>");
        out.println("<li><b>Server Name:</b> " + request.getServerName() + "</li>");
        out.println("<li><b>Server Port:</b> " + request.getServerPort() + "</li>");
        out.println("</ul>");

        // Back button
        out.println("<a class='back-button' href='index.jsp'>Go Back</a>");

        out.println("</div></body></html>");
    }
}
