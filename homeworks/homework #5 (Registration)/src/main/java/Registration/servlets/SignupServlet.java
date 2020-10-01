package Registration.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import Registration.services.RegistrationChecker;

@WebServlet("/sign-up")
public class SignupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordRepeat = request.getParameter("password-repeat");
        String userAgreement = request.getParameter("user-agreement");

        if (password != null && email != null && name != null && userAgreement != null
                && password.equals(passwordRepeat)
                && RegistrationChecker.checkField(email, RegistrationChecker.EMAIL_REGEXP)
                && RegistrationChecker.checkField(name, RegistrationChecker.NAME_REGEXP)) {
            request.setAttribute("name", name);
            getServletContext().getRequestDispatcher("/WEB-INF/views/profile.jsp").forward(request, response);
            // if u use redirect u will lose data from request.getAttribute
            // response.sendRedirect(getServletContext().getContextPath() + "/profile-page");
            } else {
            request.setAttribute("inputStatus", "Incorrect input");
            getServletContext().getRequestDispatcher("/WEB-INF/views/signup-message.jsp").forward(request, response);
        }
        // here u need to save user data into csv-file
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/views/main.jsp").forward(request, response);
    }
}
