package by.kotova.HomeName;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "WebAppName", urlPatterns = "/name")
public class WebAppName extends HttpServlet {

    HashSetNames namesSet = new HashSetNames();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        for (String name: namesSet.names){
            writer.println(name);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        String newName = req.getParameter("name");

        if(newName != null && !newName.isEmpty()){
            namesSet.names.add(newName);
            writer.println("Name added " + newName);
        }else {
            writer.println("The name was not transferred");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        String newName = req.getParameter("name");

        if(newName != null && !newName.isEmpty()){
            namesSet.names.remove(newName);
            writer.println("Name removed " + newName);
        }else {
            writer.println("The name has not been removed");
        }
    }
}
