package Registration.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import Registration.services.RegistrationChecker;
import Registration.services.UsersData;

@WebServlet("/sign-up")
public class SignupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordRepeat = request.getParameter("password-repeat");
        String userAgreement = request.getParameter("user-agreement");

        if (password != null && email != null && name != null && userAgreement != null
            && (password.length() >= 6)
            && password.equals(passwordRepeat)
            && RegistrationChecker.checkField(email, RegistrationChecker.EMAIL_REGEXP)
            && RegistrationChecker.checkField(name, RegistrationChecker.NAME_REGEXP)) {
                // OpenCSV
                UsersData ud = new UsersData();
                ud.writeData(name, email, password);
                request.getSession().setAttribute("name", name);
                response.sendRedirect(getServletContext().getContextPath() + "/profile");
                // request.setAttribute("name", name);
                // getServletContext().getRequestDispatcher("/WEB-INF/views/profile.jsp").forward(request, response);
        } else {
                request.setAttribute("inputStatus", "Incorrect input");
                getServletContext().getRequestDispatcher("/WEB-INF/views/signup-message.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/views/main.jsp").forward(request, response);
    }
}
