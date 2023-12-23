package Sem_1;

public class Main5 {
    public static void main(String[] args) {
        System.out.println(power(3,2));
        System.out.println(power(2,-2));
        System.out.println(power(3,0));
        System.out.println(power(0,2));
        System.out.println(power(1,2));
    }

    private static double power(int a, int b) {
        if (b == 0 || a == 1) {
            return 1.0;
        }
        if (a == 0) {
            return 0;
        }
        double res = 1;
        if (b > 0) {
            for (int i = 0; i < b; i++) {
                res *= a;
            }
        } else {
            for (int i = 0; i < -b; i++) {
                res *= 1.0 / a;
            }
        }

        return  res;
    }
}
