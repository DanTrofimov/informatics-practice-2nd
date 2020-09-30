package Registration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This is one of the simplest example.
 */
public class SimpleServlet extends HttpServlet{
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    PrintWriter out = resp.getWriter();
    out.println(getPageCode());
  }
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String name = req.getParameter("name");
    PrintWriter out = resp.getWriter();
    out.println(getPageCode());
  }

  protected String getPageCode(){
    return "<!DOCTYPE html><html>"
            + "<head><meta charset='UTF-8'><title>Hello page</title></head>"
            + "<body style='height: 100vh; display: grid; place-items: center'>"
            + "<form action='' method='POST' style='display: flex; flex-direction: column; gap: 10px; width: 400px'>" +
            "<h4>Registration</h4>"+
            "<input type='text' placeholder='Name' name='name'>" +
            "<input type='text' placeholder='Soname' name='soname'>"+
            "<input type='password' placeholder='Password' name='password'>"+
            "<input type='password' placeholder='Repeat password' name='password-check'>"+
            "Terms and conditions <br>"+
            "<input type='checkbox' name='rules'>"+
            "<input type='submit' value='register'>"+
            "</form>"
            + "</body></html>";
  }
}
