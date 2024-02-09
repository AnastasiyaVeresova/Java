package Sem_4;

/*
Реализовать стэк с помощью массива.
Нужно реализовать методы:
size(), empty(), push(), peek(), pop().
 */

public class Main4 {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("stack size: " + stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
