package servlets;

import domain.AccountService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class LoginServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
      
        if (session.getAttribute("username") == null) {            
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);       
        } else if (request.getParameter("logout").equals("Log Out")){  
            session.invalidate();
            session = request.getSession();

            request.setAttribute("message", "You have Successfully logged out");               
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        } 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (password.equals("") || username.equals("")) {
            request.setAttribute("message", "Check your username and password");
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

        } else if (username != "" && password != "") {
            HttpSession session = request.getSession();
            AccountService accountService = new AccountService();
            
            if (accountService.login(username, password) == null) {
                request.setAttribute("message", "Check your username and password");
                request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);               
            }
            session.setAttribute("username", username);
            response.sendRedirect("home");
        }
    }
}

