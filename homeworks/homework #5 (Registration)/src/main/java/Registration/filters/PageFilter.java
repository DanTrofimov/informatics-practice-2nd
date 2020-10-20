package Registration.filters;

import Registration.services.UsersData;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class PageFilter extends HttpFilter {
    protected final String[] protectedPaths = {"/profile"};

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        boolean isProtected = false;
        for (String path : protectedPaths){
            if (path.equals(request.getRequestURI().substring(request.getContextPath().length()))){
                isProtected = true;
                break;
            }
        }
        if (isProtected && !UsersData.isSigned(request)) {
            response.sendRedirect(request.getContextPath() + "/");
        }
        else {
            if (UsersData.isSigned(request)) {
                String name = (String) request.getSession().getAttribute("name");
                String email = (String) request.getSession().getAttribute("email");
                UsersData.addToSession(name, email, request);
            }
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {}
}
