import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;


public class UpdateStudent extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        try {
//            String idParam = req.getParameterValues("id")[0];
////            int id = Integer.parseInt(idParam);
////            resp.getOutputStream().println(Arrays.toString(strArrToIntArr(req.getParameterValues("marks"))));
//            resp.getOutputStream().println(idParam);
//        } catch (Exception ex) {
//            resp.getOutputStream().println(ex.toString());
//        }
        resp.setContentType("text/html");
        resp.addHeader("Cache-Control", "no-cache");
        resp.addHeader("Content-Type", "text/html");
        try {
            String idParam = req.getParameter("id");
            Gson gson = new Gson();
            FileReader fr = new FileReader("stud.txt");
            Student[] studentsArray = gson.fromJson(fr, Student[].class);
            for (int i = 0; i < studentsArray.length; i++) {
                if (studentsArray[i].getId() == Integer.parseInt(idParam)) {
                    studentsArray[i].setMarks(strArrToIntArr(req.getParameterValues("marks")));
                }
            }
            FileWriter fw = new FileWriter("stud.txt");
            gson.toJson(studentsArray, fw);
            fw.flush();
            fw.close();
            req.setAttribute("message", "ДАННЫЕ СТУДЕНТА ОБНОВЛЕНЫ");
            req.getRequestDispatcher("/message.jsp").forward(req, resp);
        } catch (Exception ex) {
            req.setAttribute("message", ex);
            req.getRequestDispatcher("/message.jsp").forward(req, resp);
        }

    }

    private int[] strArrToIntArr(String[] marks) throws Exception {
        int[] toReturn = new int[marks.length];
        for (int i = 0; i < marks.length; i++) {
            toReturn[i] = Integer.parseInt(marks[i]);
        }
        return toReturn;
    }
}
