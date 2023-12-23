package Sem_5;

import java.util.HashMap;
import java.util.Map;

public class Passports {
    private Map<String, String> map = new HashMap<>();

    void addNote(String numPassport, String name){
        map.put(numPassport, name);
    }

    String findByName(String name){
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, String> entry: map.entrySet()){
            String key = entry.getKey();
            String val = entry.getValue();
            if (val.equalsIgnoreCase(name)){
                stringBuilder.append(entry);
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }
}
