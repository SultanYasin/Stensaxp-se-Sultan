package ec.utbildning;


import java.time.LocalDateTime;
import java.util.List;


public class Klockis implements Players{

    String klassensNamn = "Klockis";

    public String getNamn() {
        return klassensNamn;
    } // ch

    List<String> val = List.of("sax","sten","påse");

    LocalDateTime date = LocalDateTime.now();


    String min(){

        int minDrag = date.getMinute();

        String klockisVal;
        if (minDrag%3==0) {
            klockisVal = val.get(0);
        }
        else if (minDrag%2==0) {
            klockisVal = val.get(1);
        }
        else{ klockisVal = val.get(2);}


        return klockisVal;
    }

    @Override
    public void takeTurn() {

    }
}