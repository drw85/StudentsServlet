import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lesson29Sorting extends HttpServlet {
    private static String path = System.getProperty("user.home") + File.separator + "studentsJson.txt";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        resp.setContentType("text/html");
        resp.addHeader("Cache-Control", "no-cache");
        resp.addHeader("Content-Type", "text/html");
        req.setAttribute("students", getDataForShow());
        req.getRequestDispatcher("/l29Sorting.jsp").forward(req, resp);
    }

    private static List<String> getDataForShow() {
        List<String> toReturn;
        try {
            Gson gson = new Gson();
            FileReader fr = new FileReader(path);
            Student[] studentsArr = gson.fromJson(fr, Student[].class);
            toReturn = Arrays.stream(studentsArr)
                    .filter(s -> (s.getFirstname().length() > 3))
                    .filter(x -> threeVowels(x.getFirstname()))
                    .map(student -> {
                        student.setFirstname(student.getFirstname().toUpperCase());
                        return student;
                    })
                    .map(student -> {
                        student.setLastname(student.getLastname().toUpperCase());
                        return student;
                    })
                    .sorted((student1, student2) -> student1.getLastname().compareTo(student2.getLastname()))
                    .map(student -> student.getLastname())
                    .collect(Collectors.toList());

            return toReturn;
        } catch (Exception ex) {
            return new ArrayList<>();
        }
    }

    public static boolean threeVowels(String name) {
        String vowelsRus = "АаУуОоЫыИиЭэЯяЮюЁёЕе";
        String vowelsEng = "AaEeIiOoUu";
        List<Character> answer = name.chars()
                .mapToObj(c -> (char) c)
                .filter(x -> (vowelsRus.indexOf(x) != -1 || vowelsEng.indexOf(x) != -1))
                .collect(Collectors.toList());
        return answer.size() >= 3;
    }
}
