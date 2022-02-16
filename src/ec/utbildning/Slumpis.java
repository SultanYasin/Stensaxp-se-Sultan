package ec.utbildning;

import java.util.List;
import java.util.Random;

public class Slumpis implements Players {

    String klasensNamn = "Slumpis";

    public String getNamn() {
        return klasensNamn;
    } //ch

    List<String> val = List.of("sax","sten","påse");

    Random random = new Random();

    String slumpisVal(){
        String valet = val.get(random.nextInt(val.size()));
        return valet;
    }

    @Override
    public void takeTurn() {}

}
