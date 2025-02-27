import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalculateCompoundInterestServlet1")
public class CalculateCompoundInterestServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String principalStr = request.getParameter("principal");
            String rateStr = request.getParameter("rate");
            String yearsStr = request.getParameter("years");
            String monthsStr = request.getParameter("months");
            String daysStr = request.getParameter("days"); 
            String intervalStr = request.getParameter("interval");

            String errorMessage = validateInputs(principalStr, rateStr, yearsStr, monthsStr, daysStr, intervalStr);
            if (errorMessage != null) {
                displayError(response, errorMessage);
                return;
            }

            double principal = Double.parseDouble(principalStr);
            double rate = Double.parseDouble(rateStr);
            int years = Integer.parseInt(yearsStr);
            int months = Integer.parseInt(monthsStr);
            int days = Integer.parseInt(daysStr); 
            int interval = Integer.parseInt(intervalStr);

            double time = years + (double) months / 12 + (double) days / 365;

            double amount = principal * Math.pow((1 + rate / (interval * 100)), interval * time);
            double compoundInterest = amount - principal;

            displayResults(response, principal, rate, years, months, days, interval, compoundInterest, amount);
        } catch (NumberFormatException e) {
            displayError(response, "Please enter valid numeric values for all fields.");
        }
    }

    private String validateInputs(String principalStr, String rateStr, String yearsStr, String monthsStr, String daysStr, String intervalStr) {
        if (principalStr == null || principalStr.isEmpty() || !isPositiveNumber(principalStr)) {
            return "Principal amount must be a positive number.";
        }
        if (rateStr == null || rateStr.isEmpty() || !isPositiveNumber(rateStr)) {
            return "Rate of interest must be a positive number.";
        }
        if (yearsStr == null || yearsStr.isEmpty() || !isNonNegativeNumber(yearsStr) || Integer.parseInt(yearsStr) > 50) {
            return "Years must be a non-negative number and not above 50.";
        }
        if (monthsStr == null || monthsStr.isEmpty() || !isNonNegativeNumber(monthsStr) || Integer.parseInt(monthsStr) > 12) {
            return "Months must be a number between 0 and 12.";
        }
        if (daysStr == null || daysStr.isEmpty() || !isNonNegativeNumber(daysStr) || Integer.parseInt(daysStr) > 31) {
            return "Days must be a number between 0 and 31.";
        }
        if (intervalStr == null || intervalStr.isEmpty()) {
            return "Please select a compound interval.";
        }
        return null;
    }

    private boolean isPositiveNumber(String str) {
        try {
            double value = Double.parseDouble(str);
            return value > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isNonNegativeNumber(String str) {
        try {
            int value = Integer.parseInt(str);
            return value >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void displayResults(HttpServletResponse response, double principal, double rate, int years, int months, int days, int interval, double compoundInterest, double amount) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><style>");
        out.println("body { background: linear-gradient(to right, #6a11cb, #92a8cf); font-family: Arial, sans-serif; margin: 0; padding: 0; display: flex; justify-content: center; align-items: center; height: 100vh; }");
        out.println(".result-container { background-color: rgba(255, 255, 255, 0.9); padding: 20px; border-radius: 10px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); width: 60%; max-width: 800px; }");
        out.println("h1 { text-align: center; }");
        out.println("table { width: 100%; border-collapse: collapse; margin-top: 20px; }");
        out.println("table, th, td { border: 2px solid #000; }");
        out.println("th, td { padding: 12px; text-align: left; font-size: 16px; }");
        out.println("</style></head><body>");
        out.println("<div class='result-container'>");
        out.println("<h1>Compound Interest Calculation Result</h1>");
        out.println("<table>");
        out.println("<tr><th>Principal Amount</th><td>" + String.format("%.2f", principal) + "</td></tr>");
        out.println("<tr><th>Rate of Interest</th><td>" + String.format("%.2f", rate) + "%</td></tr>");
        out.println("<tr><th>Time Period</th><td>" + years + " years, " + months + " months, " + days + " days</td></tr>");
        out.println("<tr><th>Compound Interval</th><td>" + interval + " times/year</td></tr>");
        out.println("<tr><th>Compound Interest</th><td>" + String.format("%.2f", compoundInterest) + "</td></tr>");
        out.println("<tr><th>Future Value (Amount)</th><td>" + String.format("%.2f", amount) + "</td></tr>");
        out.println("</table>");
        out.println("</div>");
        out.println("</body></html>");
    }

    private void displayError(HttpServletResponse response, String errorMessage) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><style>");
        out.println("body { background: linear-gradient(to right, #ff4b2b, #ff416c); font-family: Arial, sans-serif; margin: 0; padding: 0; display: flex; justify-content: center; align-items: center; height: 100vh; }");
        out.println(".error-container { background-color: white; padding: 20px; border-radius: 10px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); width: 400px; text-align: center; }");
        out.println("h1 { color: red; }");
        out.println("</style></head><body>");
        out.println("<div class='error-container'>");
        out.println("<h1>Error</h1>");
        out.println("<p>" + errorMessage + "</p>");
        out.println("</div>");
        out.println("</body></html>");
    }
}
