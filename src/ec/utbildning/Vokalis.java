package ec.utbildning;

import java.util.*;
import java.util.regex.Pattern;

public class Vokalis implements Players {
    String klassensNamn = "Voklais";

    public String getNamn() {
        return klassensNamn;
    }

    List<String> val = List.of("sax","sten","påse");



    String  voklaisVal (String spelarensnamn){
        Pattern pattern = Pattern.compile("([auyieo].*){2,}");
        Pattern pattern1 = Pattern.compile("([auyieo].*){3,}");
        String namn= spelarensnamn;
        String returnType="";
        if (pattern1.matcher(namn).find()){
            returnType="sax";
        }
        else if (pattern.matcher(namn).find()){
            returnType="sten";
        }
        else{
            returnType="påse";
        }
        return returnType;

    }

    @Override
    public void takeTurn() {

    }
}