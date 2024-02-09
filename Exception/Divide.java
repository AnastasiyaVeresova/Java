package Exception;

import java.util.Collections;

public class Divide {
    public static void main(String[] args) {
 /*1       System.out.println(divide(10,0));
    }
    public static int divide(int a1, int a2) {
        if (a2 == 0){

throw new RuntimeException("Divide by zero not permited");      }
        return a1/a2;

        -----------------------------------*/
        int number = 1;
        try {
            number = 10 / 1;
            String test = null;
//            System.out.println(test.length());
            Collections.emptyList().add(new Object());
        } catch (ArithmeticException e){
            System.out.println("Operation divide by zero not supported");
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
        } catch (Exception e){
            System.out.println("Exception");
        }
        System.out.println(number);
    }
}
