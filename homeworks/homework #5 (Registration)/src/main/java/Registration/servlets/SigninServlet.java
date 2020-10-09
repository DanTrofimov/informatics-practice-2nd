package Registration.servlets;

import Registration.services.UsersData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sign-in")
public class SigninServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/views/sign-in.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

//        if (UsersData.checkUser(email, password)) {
            UsersData.addToSession(name, email, request);
            response.sendRedirect(getServletContext().getContextPath() + "/profile");
//            return;
//        }
//        response.sendRedirect(getServletContext().getContextPath() + "/profile");

//        request.setAttribute("email", request.getParameter("email"));
//        getServletContext().getRequestDispatcher("/WEB-INF/views/sign-in.jsp").forward(request, response);
    }
}
