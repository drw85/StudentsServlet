import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class AddStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = System.getProperty("user.home") + File.separator + "studentsJson.txt";
        File file = new File(path);
        if (!file.exists()){
            file.createNewFile();
        }
        resp.setContentType("text/html");
        resp.addHeader("Cache-Control", "no-cache");
        resp.addHeader("Content-Type", "text/html");
        resp.sendRedirect(req.getContextPath() + "/addStudent.jsp");
    }
}
