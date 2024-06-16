package org.tpo.servlets;

import java.io.*;
import java.sql.ResultSet;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "displayServlet", value = "/display-servlet")
public class DisplayServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<a href=\"/request-servlet\">powrót do wyszukiwania</a>");
        out.println("<h1>Wyniki wyszukiwania</h1>");
        out.println("<table border=\"1\"><tr><th>Id</th><th>Rodzaj</th><th>Marka</th><th>Model</th><th>Rok produkcji</th><th>Zużycie paliwa</th><th>Moc</th></tr>");

        ResultSet resultSet = (ResultSet) request.getAttribute("resultSet");

        try {
            if (!resultSet.next()) {
                out.println("<tr><td colspan=\"7\">Brak danych</td></tr>");
            } else {
                do {
                    int id = resultSet.getInt("Id");
                    String rodzaj = resultSet.getString("Rodzaj");
                    String marka = resultSet.getString("Marka");
                    String model = resultSet.getString("Model");
                    int rokProdukcji = resultSet.getInt("Rok_produkcji");
                    float zuzyciePaliwa = resultSet.getFloat("Zuzycie_paliwa");
                    int moc = resultSet.getInt("Moc");

                    out.println("<tr><td>" + id + "</td><td>" + rodzaj + "</td><td>" + marka + "</td><td>" + model +
                            "</td><td>" + rokProdukcji + "</td><td>" + zuzyciePaliwa + "</td><td>" + moc + "</td></tr>");
                } while (resultSet.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.println("Wystąpił błąd: " + e.getMessage());
        } finally {
            out.println("</table>");
            out.println("</body></html>");
            out.close();
        }
    }
}
