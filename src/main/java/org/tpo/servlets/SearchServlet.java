package org.tpo.servlets;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.sql.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(name = "searchServlet", value = "/search-servlet")
public class SearchServlet extends HttpServlet {
    final static Logger logger = LoggerFactory.getLogger(SearchServlet.class);

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String filter = request.getParameter("filter");

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:D:/STUDIA/TPO/servlets/database/tpo5db";
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();

            String sql = String.format("SELECT Id, Rodzaj, Marka, Model, Rok_produkcji, Zuzycie_paliwa, Moc FROM Cars WHERE Rodzaj LIKE '%s'", filter);
            resultSet = statement.executeQuery(sql);

            request.setAttribute("resultSet", resultSet);
            request.getRequestDispatcher("/display-servlet").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Wystąpił błąd: " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
                response.getWriter().println("Wystąpił błąd podczas zamykania połączenia: " + e.getMessage());
            }
        }
    }
}
