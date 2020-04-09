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
        Gson gson = new Gson();
//        ArrayList<Student> arr = new ArrayList<>();
//        arr.add(new Student(1, "AA", "BB"));
//        arr.add(new Student(2, "CC", "DD"));
//        arr.add(new Student(3, "EE", "FF"));
//        arr.add(new Student(4, "ZZ", "XX"));
//        FileWriter fw = new FileWriter("stud.txt");
//        gson.toJson(arr.toArray(), fw);
//        fw.flush();

        FileReader fr = new FileReader("stud.txt");
        Student[] desi = gson.fromJson(fr, Student[].class);


        resp.setContentType("text/html");
        resp.addHeader("Cache-Control", "no-cache");
        resp.addHeader("Content-Type", "text/html");
        req.setAttribute("students", desi);
        req.getRequestDispatcher("/allStudents.jsp").forward(req, resp);
//        resp.sendRedirect(req.getContextPath() + "/allStudents.jsp");
    }
}
