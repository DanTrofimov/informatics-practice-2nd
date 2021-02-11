package REST.servlets;

import REST.models.User;
import REST.services.RestService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/rest-service")
public class RestServlet extends HttpServlet {
    private Gson gson;
    private RestService restService;
    private User user;

    @Override
    public void init() {
        gson = new GsonBuilder().create();
        restService = new RestService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        user = restService.getUser(gson.fromJson(req.getReader(), User.class));
        resp.setContentType("application/json");
        resp.getWriter().write(gson.toJson(user));
        resp.getWriter().flush();
        gson.toJson(user);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        user = gson.fromJson(req.getReader(), User.class);
        restService.createUser(user);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        user = gson.fromJson(req.getReader(), User.class);
        restService.deleteUser(user);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        user = gson.fromJson(req.getReader(), User.class);
        restService.updateUser(user);
    }
}
