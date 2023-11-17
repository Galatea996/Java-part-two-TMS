package by.kotova.Home;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet (name = "WebHomeOne", urlPatterns = "/time")

public class WebHomeOne extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.setContentType("text/html");
       PrintWriter out = resp.getWriter();

       String zona = req.getParameter("zona");
        LocalTime localTime = LocalTime.now();

        if (zona == null || zona.isEmpty()){
            out.println("Current time: " + localTime);
            return;
        }
        ZonedDateTime returnZonaDataTime = ZonedDateTime.now();
        ZonedDateTime custamZonaDataTime = returnZonaDataTime.withZoneSameInstant(java.time.ZoneId.of(zona));

        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
        String scrin = custamZonaDataTime.format(format);

        out.print("Time: " + scrin);
    }
}

