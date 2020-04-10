import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Arrays;

public class SaveStudent extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = System.getProperty("user.home") + File.separator + "studentsJson.txt";
        File file = new File(path);
        if (!file.exists()){
            file.createNewFile();
        }
        resp.setContentType("text/html");
        resp.addHeader("Cache-Control", "no-cache");
        resp.addHeader("Content-Type", "text/html");

        String firstnameParam = req.getParameter("firstname");
        String lastnameParam = req.getParameter("lastname");
        Gson gson = new Gson();
        FileReader fr = new FileReader(path);
        Student[] studentsArray;
        studentsArray = gson.fromJson(fr, Student[].class);
        if (studentsArray==null){
            studentsArray = new Student[0];
        }
        int nextId = 0;
        for (Student currentStudent : studentsArray) {
            if (nextId <= currentStudent.getId()) {
                nextId = currentStudent.getId();
            }
            if (firstnameParam.equals(currentStudent.getFirstname())&&lastnameParam.equals(currentStudent.getLastname())){
                req.setAttribute("message", "ТАКОЙ СТУДЕНТ УЖЕ ЕСТЬ");
                req.getRequestDispatcher("/message.jsp").forward(req, resp);
            }
        }
        Student studentToSave = new Student(nextId+1, firstnameParam, lastnameParam);
        Student[] tempArr = Arrays.copyOf(studentsArray, studentsArray.length+1);
        tempArr[tempArr.length-1] = studentToSave;
        try {
            FileWriter fw = new FileWriter(path);
            gson.toJson(tempArr, fw);
            fw.flush();
            fw.close();
        }  catch (Exception ex){
            req.setAttribute("message", ex);
            req.getRequestDispatcher("/message.jsp").forward(req, resp);
        }
        req.setAttribute("message", "СТУДЕНТ СОХРАНЕН");
        req.getRequestDispatcher("/message.jsp").forward(req, resp);
    }
}
