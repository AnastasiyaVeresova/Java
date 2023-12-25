package Sem_6.hw_6;

import java.util.*;

public class Notebook {
    private String model;
    private int ram;
    private int diagonal;
    private int hardDisk;
    private String opsystem;
    private String colour;

    public Notebook(String model, int ram, int diagonal, int harddisc, String opsystem, String colour) {
        this.model = model;
        this.ram = ram;
        this.diagonal = diagonal;
        this.hardDisk = harddisc;
        this.opsystem = opsystem;
        this.colour = colour;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getRam() {
        return ram;
    }
    public void setRam(int ram) {
        this.ram = ram;
    }
    public int getDiagonal() {
        return diagonal;
    }
    public void setSsd(int diagonal) {
        this.diagonal = diagonal;
    }
    public int getHarddisc() {
        return hardDisk;
    }
    public void setHarddisc(int harddisc) {
        this.hardDisk = harddisc;
    }
    public String getOpsystem() {
        return opsystem;
    }
    public void setOpsystem(String opsystem) {
        this.opsystem = opsystem;
    }
    public  String getColour() {
        return  colour;
    }
    public void setColour(String colour) {
        this.colour = colour;
    }
    @Override
    public String toString() {
        return "Ноутбук {" +
                "Модель = '" + model + '\'' +
                ", Оперативная память = " + ram + "Гб" +
                ", Диагональ = " + diagonal + "'" +
                ", Жесткий диск = " + hardDisk + "Гб" +
                ", Операционная система = " + opsystem +
                ", Цвет = " + colour + '\'' +
                '}';
    }

    public static void filterNotebooks(Map<String, String> filters, List<Notebook> Notebook_ones) {
        for (Notebook notebook : Notebook_ones) {
            boolean passfilter = true;
            for (Map.Entry<String, String> entry : filters.entrySet()) {
                String filterKey = entry.getKey();
                String filterValue = entry.getValue();
                switch (filterKey) {
                    case "1":
                        if (!notebook.getModel().equalsIgnoreCase(filterValue)) {
                            passfilter = false;
                        }
                        break;
                    case "2":
                        if (notebook.getRam() < Integer.parseInt(filterValue)) {
                            passfilter = false;
                        }
                        break;
                    case "3":
                        if (notebook.getDiagonal() < Integer.parseInt(filterValue)) {
                            passfilter = false;
                        }
                        break;
                    case "4":
                        if (notebook.getHarddisc() < Integer.parseInt(filterValue)){
                            passfilter = false;
                        }
                        break;
                    case "5":
                        if (!notebook.getOpsystem().equalsIgnoreCase(filterValue)) {
                            passfilter = false;
                        }
                        break;
                    case "6":
                        if (!notebook.getColour().equalsIgnoreCase(filterValue)) {
                            passfilter = false;
                        }
                        break;
                    default:
                        System.out.println("Введен некорректный критерий фильтрации");
                        return;


                }
                if (!passfilter) {
                    break;
                }
            }
            if (passfilter) {
                System.out.println(notebook);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Notebook> Notebook_ones = new ArrayList<>();
        Notebook_ones.add(new Notebook("Lenovo", 8, 18, 4, "Windows", "Металлик"));
        Notebook_ones.add(new Notebook("Lenovo", 8, 18, 4, "Windows", "Белый"));
        Notebook_ones.add(new Notebook("Lenovo", 12, 21, 12, "Windows", "Белый"));
        Notebook_ones.add(new Notebook("Asus", 16, 21, 18, "Windows", "Черный"));
        Notebook_ones.add(new Notebook("Acer", 12, 23, 18, "Windows", "Зеленый"));
        Notebook_ones.add(new Notebook("Acer", 8, 28, 32, "Linux", "Синий"));
        Notebook_ones.add(new Notebook("Hp", 8, 18, 4, "Windows", "Белый"));
        Notebook_ones.add(new Notebook("Hp", 12, 18, 32, "Windows", "Синий"));
        Notebook_ones.add(new Notebook("Mac", 32, 21, 24, "Mac", "Черный"));
        Notebook_ones.add(new Notebook("Mac", 8, 22, 28, "Mac", "Металлик"));

        while (true) {
            System.out.println("Модель - 1,\nОперативная память, Гб - 2,\nДиагональ, дюймов - 3,\nЖесткий диск, Гб - 4,\nОперационная система - 5,\nЦвет - 6\n-----------\nВыход - 7");
            System.out.println("Введите номер критерия фильтрации (1-6) или 7 для выхода: ");
            String filterKey = String.valueOf(scanner.nextInt());
            switch (filterKey) {
                case "1":
                    System.out.println("Выбор моделей:");
                    Set<String> uniqueValuesModel = new HashSet<>();
                    for (Notebook Notebook : Notebook_ones) {
                        uniqueValuesModel.add(Notebook.getModel());
                    }
                    for (String valueModel : uniqueValuesModel) {
                        System.out.printf(valueModel + " ");
                    }
                    System.out.println();
                    System.out.println("Введите значение для фильтрации по модели: ");
                    break;

                case "2":
                    System.out.println("Диапазон ram:");
                    Set<Integer> uniqueValuesRam = new TreeSet<>();
                    for (Notebook Notebook : Notebook_ones) {
                        uniqueValuesRam.add(Notebook.getRam());
                    }
                    for (Integer valueRam : uniqueValuesRam) {
                        System.out.printf(valueRam + " ");
                    }
                    System.out.println();
                    System.out.println("Введите минимальное значение для фильтрации по оперативной памяти: ");
                    break;

                case "3":
                    System.out.println("Доступные диагонали:");
                    Set<Integer> uniqueValuesDiagonal = new TreeSet<>();
                    for (Notebook Notebook : Notebook_ones) {
                        uniqueValuesDiagonal.add(Notebook.getDiagonal());
                    }
                    for (Integer valueDiagonal : uniqueValuesDiagonal) {
                        System.out.printf(valueDiagonal + " ");
                    }
                    System.out.println();
                    System.out.println("Введите минимальное значение для фильтрации по длине диагонали: ");
                    break;

                case "4":
                    System.out.println("Возможные объемы жестких дисков:");
                    Set<Integer> uniqueValuesHdd = new TreeSet<>();
                    for (Notebook Notebook : Notebook_ones) {
                        uniqueValuesHdd.add(Notebook.getDiagonal());
                    }

                    for (Integer valueHdd : uniqueValuesHdd) {
                        System.out.printf(valueHdd + " ");
                    }
                    System.out.println();
                    System.out.println("Введите минимальное значение из доступных объемов жестких дисков: ");
                    break;

                case "5":
                    System.out.println("Доступные операционные системы:");
                    Set<String> uniqueValuesOpp = new TreeSet<>();
                    for (Notebook Notebook : Notebook_ones) {
                        uniqueValuesOpp.add(Notebook.getOpsystem());
                    }
                    for (String valueOpp : uniqueValuesOpp) {
                        System.out.printf(valueOpp + " ");
                    }
                    System.out.println();
                    System.out.println("Введите значение для фильтрации по оперативной системе: ");
                    break;

                case "6":

                    System.out.println("Доступные цвета:");
                    Set<String> uniqueValuesColours = new TreeSet<>();
                    for (Notebook Notebook : Notebook_ones) {
                        uniqueValuesColours.add(Notebook.getColour());
                    }

                    for (String valueColour : uniqueValuesColours) {
                        System.out.printf(valueColour + " ");
                    }
                    System.out.println();
                    System.out.println("Введите значение для фильтрации по цвету: ");
                    break;
                case "7":
                    System.out.println("Всего доброго, ждем вас снова!");
                    return;
                default:
                    System.out.println("Пожалуйста, повторите поиск с верными параметрами");
                    return;
            }
            scanner.nextLine();
            String filterValue = scanner.nextLine();
            Map<String, String> filters = new HashMap<>();
            filters.put(filterKey, filterValue);
            if (filters.isEmpty()) {
                System.out.println("Не найдено по параметру: " + filterValue);
            }
            else {
                System.out.println("Отфильтрованы по параметру: " + filterValue);
            }

            filterNotebooks(filters, Notebook_ones);
            System.out.println("----------");
        }
    }
}