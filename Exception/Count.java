package Exception;

/*Создайте класс Счетчик, у которого есть метод add(),
увеличивающий значение внутренней int переменной на 1.
Сделайте так, чтобы с объектом такого типа можно было работать в блоке try-with-resources. Подумайте, что должно происходить при закрытии этого ресурса? Напишите метод для проверки, закрыт ли ресурс.
При попытке вызвать add() у закрытого ресурса, должен выброситься IOException*/
public class Count implements AutoCloseable{
    public static void main(String[] args) {
        try(Count c = new Count()){
            c.add();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(Count.getCloser());
    }

    public static boolean getCloser() {
        return isOpen;
    }

    int a = 0;
    static boolean isOpen = true;
    public void add() {
        a++;
    }

    @Override
    public void close() throws Exception {
        isOpen = false;
        System.out.println("Thread closed");
    }
}
