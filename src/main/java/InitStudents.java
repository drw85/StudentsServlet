import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class InitStudents extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = System.getProperty("user.home") + File.separator + "studentsJson.txt";
        File file = new File(path);
        if (!file.exists()){
            file.createNewFile();
        }
        Gson gson = new Gson();
        FileReader fr = new FileReader(path);
        Student[] studentsArray = new Student[10];
        studentsArray[0] = new Student(1, "Кристофер", "Нолан");
        studentsArray[1] = new Student(2, "Лав", "Диас");
        studentsArray[2] = new Student(3, "Джеймс", "Кэмерон");
        studentsArray[3] = new Student(4, "Гаспар", "Ноэ");
        studentsArray[4] = new Student(5, "Уэс", "Андерсон");
        studentsArray[5] = new Student(6, "Йоргос", "Лантимос");
        studentsArray[6] = new Student(7, "Клинт", "Иствуд");
        studentsArray[7] = new Student(8, "Стивен", "Содерберг");
        studentsArray[8] = new Student(9, "Алехандро", "Гонсалес Иньярриту");
        studentsArray[9] = new Student(10, "Илья", "Хржановский");
        try {
            FileWriter fw = new FileWriter(path);
            gson.toJson(studentsArray, fw);
            fw.flush();
            fw.close();
            req.setAttribute("message", "СТУДЕНТЫ ИНИЦИАЛИЗИРОВАНЫ");
            req.getRequestDispatcher("/message.jsp").forward(req, resp);
        }  catch (Exception ex){
            req.setAttribute("message", ex);
            req.getRequestDispatcher("/message.jsp").forward(req, resp);
        }

    }
}
