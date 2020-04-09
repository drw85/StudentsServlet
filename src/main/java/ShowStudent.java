import com.google.gson.Gson;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class ShowStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        FileReader fr = new FileReader("stud.txt");
        Student[] desi = gson.fromJson(fr, Student[].class);
        Map<String, String[]> parameterMap = req.getParameterMap();
        int idd = Integer.parseInt(parameterMap.get("id")[0]);
        Student student = null;
        for (Student curr:desi) {
            if (curr.getId()==idd){
                student = curr;
            }
        }
        resp.setContentType("text/html");
        resp.addHeader("Cache-Control", "no-cache");
        resp.addHeader("Content-Type", "text/html");

        req.setAttribute("student", student);
        req.setAttribute("marks", student.getMarks());
        req.getRequestDispatcher("/singleStudent.jsp").forward(req, resp);
    }
}
