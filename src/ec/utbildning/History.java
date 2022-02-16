package ec.utbildning;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class History implements Players {
    Map<String, Integer> map = new HashMap<>();

    LocalDateTime now = LocalDateTime.now();

    public void setMap(String str, Integer in  ) {
        map.put(str, in);

    }


    public Map<String, Integer> getMap() {
        System.out.println("Det hände i " + now);
        return map;
    }

    @Override
    public void takeTurn() {

    }
}