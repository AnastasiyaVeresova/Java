
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/*
Заполнить список названиями планет Солнечной системы в произвольном порядке с повторениями.
Вывести название каждой планеты и количество его повторений в списке
 */
public class Planets {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String[] planets= {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto"};
        int n = 10;
        Random rand = new Random();
        for(int i = 0; i < n; i++)
        {
            list.add(planets[rand.nextInt(0,planets.length)]);
        }

        for (String i: planets){
            int c = Collections.frequency(list, i);
            System.out.println(i+": "+c);
        }
        System.out.println(list);
    }
}
