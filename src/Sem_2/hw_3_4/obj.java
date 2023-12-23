package Sem_2.hw_3_4;

/*
Дана json строка (можно сохранить в файл и читать из файла)
[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
{"фамилия":"Петрова","оценка":"4","предмет":" Информатика"},
{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
Написать метод(ы), который распарсит json и,
используя StringBuilder, создаст строки вида: Студент [фамилия]
получил [оценка] по предмету [предмет]. Пример вывода:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика. 4*.
К калькулятору из предыдущего дз добавить логирование.

class Answer { public static void answer(String JSON, String ELEMENT1, String ELEMENT2, String ELEMENT3) {

    String jsonString = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},"

            + "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},"

            + "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";

    StringBuilder sb = new StringBuilder();

    String[] splitString = jsonString.split("\\{");

    for (int i = 1; i < splitString.length; i++) {
        String[] studentInfo = splitString[i].replace("}]", "").split("\",\"");

        sb.append("Студент " + studentInfo[0].split(":")[1].replace("\"", "") + " получил " + studentInfo[1].split(":")[1].replace("\"", "") + " по предмету " + studentInfo[2].split(":")[1].replace("\"", "").replace("},", "") + "\n");

    }
    System.out.println(sb.toString());

}
}
class Printer{ public static void main(String[] args) {
    String JSON = ""; String ELEMENT1 = ""; String ELEMENT2 = ""; String ELEMENT3 = "";
        if (args.length == 0) {
            JSON = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
                "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}," +
                "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
                ELEMENT1 = "Студент ";
                ELEMENT2 = " получил ";
                ELEMENT3 = " по предмету ";
                }
                else{
                JSON = args[0];
                ELEMENT1 = args[1];
                ELEMENT2 = args[2];
                ELEMENT3 = args[3];
                }

                Answer ans = new Answer();
                ans.answer(JSON, ELEMENT1, ELEMENT2, ELEMENT3);
        }
    }

 */
/*
import org.json.JSONArray;
import org.json.JSONObject;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class Main {

    public static void main(String[] args) {
        try {
            String jsonString = new String(Files.readAllBytes(Paths.get("data.json")));
            JSONArray jsonArray = new JSONArray(jsonString);

            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String фамилия = jsonObject.getString("фамилия");
                String оценка = jsonObject.getString("оценка");
                String предмет = jsonObject.getString("предмет");

                stringBuilder.append("Студент ")
                        .append(фамилия)
                        .append(" получил ")
                        .append(оценка)
                        .append(" по предмету ")
                        .append(предмет)
                        .append(".\n");
            }

            System.out.println(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

 */