import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ShowAllStudents extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = System.getProperty("user.home") + File.separator + "studentsJson.txt";
        File file = new File(path);
        if (!file.exists()){
            file.createNewFile();
        }
        Gson gson = new Gson();
        FileReader fr = new FileReader(path);
        Student[] students = gson.fromJson(fr, Student[].class);
        resp.setContentType("text/html");
        resp.addHeader("Cache-Control", "no-cache");
        resp.addHeader("Content-Type", "text/html");
        req.setAttribute("students", students);
        req.getRequestDispatcher("/allStudents.jsp").forward(req, resp);
    }
}
