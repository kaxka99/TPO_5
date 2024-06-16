package org.tpo.servlets;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "requestServlet", value = "/request-servlet")
public class RequestServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Wyszukiwanie samochodów</h1>");
        out.println("<form method=\"GET\" action=\"/search-servlet\">");
        out.println("  Rodzaj: <input type=\"text\" size=\"50\" name=\"filter\"><br>");
        out.println("  <input type=\"submit\" value=\"Szukaj\">");
        out.println("</form>");
        out.println("</body></html>");
        out.close();
    }
}
