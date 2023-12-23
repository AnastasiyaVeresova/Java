package Sem_5;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class TrueOrFalseBrackets {
    public static void main(String[] args) {
        System.out.println(checkBrackets("a+(d*3)"));
        System.out.println(checkBrackets("[6+(3*3)]"));
        System.out.println(checkBrackets("{a}[+]{(d*3)}"));
        System.out.println(checkBrackets("<{a}+{(d*3)}>"));
        System.out.println(checkBrackets("a+(d*3))"));
        System.out.println(checkBrackets("[a+(1*3)"));
        System.out.println(checkBrackets("[a+(1]*3)"));
        System.out.println(checkBrackets("{a+]}{(d*3)}"));
    }

    static boolean checkBrackets(String s){
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('<', '>');
        map.put('{', '}');
        for (char c: s.toCharArray()){
            if (map.containsKey(c)){
                stack.push(c);
            }
            if (map.containsValue(c)){
                if (stack.empty() || map.get(stack.pop()) != c){
                    return false;
                }
            }
        }
        return stack.empty();
    }
}

