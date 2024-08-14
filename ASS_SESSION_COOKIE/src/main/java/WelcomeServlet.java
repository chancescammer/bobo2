import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        PrintWriter out = response.getWriter();

        if (session != null && session.getAttribute("username") != null) {
            String username = (String) session.getAttribute("username");
            out.println("<h1>Welcome, " + username + "!</h1>");
            out.println("<a href='LogoutServlet'>Logout</a>");
        } else {
            response.sendRedirect("Login.html");
        }
    }
}