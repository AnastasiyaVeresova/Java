package Exception;

import java.io.File;

/*В качестве аргумента методу передаётся путь к файлу в виде
строки. По этому пути мы делаем проверку существования файла. Если файл
не существует, возвращаем значение -1, которое фактически сообщает об
ошибке – нельзя запросить размер несуществующего файла. А если файл
существует — вернётся его длина в байтах.*/
public class Application {

    public static void main(String[] args) {
        System.out.println(getFileSize(new File("F:/х/Java/src/Exception/kc_house_data.csv")));
    }

    public static long getFileSize(File file){
//    File file = new File(path);
    if (!file.exists()) {
        return -1L;
    }
    return file.length();
    }
}
