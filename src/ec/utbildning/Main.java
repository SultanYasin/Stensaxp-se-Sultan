package ec.utbildning;
import java.time.LocalDateTime;
import java.util.*;


public class Main {

    static String name;
    static Map<String,Integer> myMap = new HashMap<String,Integer>();


    static String start(String val1, String val2,String spelare1,String spelare2){

        String returnSting="";
        if ("STEN".equals(val1.toUpperCase())) {
            switch (val2.toUpperCase()) {
                case "STEN" -> returnSting = "ingen vinnare ";
                case "SAX" -> returnSting = spelare1;
                case "PÅSE" -> returnSting = spelare2;
                default -> {
                }
            }
        } else if ("SAX".equals(val1.toUpperCase())) {
            switch (val2.toUpperCase()) {
                case "STEN" -> returnSting = spelare1;
                case "SAX" -> returnSting = "ingen vinner";
                case "PÅSE" -> returnSting = spelare2;
                default -> {
                }
            }
        } else if ("PÅSE".equals(val1.toUpperCase())) {
            switch (val2.toUpperCase()) {
                case "STEN" -> returnSting = spelare1;
                case "SAX" -> returnSting = spelare2;
                case "PÅSE" -> returnSting = "ingen vinner";
                default -> {
                }
            }
        }
        return returnSting;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PlayerFactory playerFactory = new PlayerFactory();


        // Här använder jag factory pattern för att inte instansiera klasserna på den vanligaste sättet
        Players Vokalis = playerFactory.getPlayer("Vokalis");
        Vokalis.takeTurn();

        Players Klockis = playerFactory.getPlayer("Klockis");
        Klockis.takeTurn();

        Players user = playerFactory.getPlayer("User");
        user.takeTurn();
        Players Slumpis = playerFactory.getPlayer("Slumpis");
        Slumpis.takeTurn();

     //   Players History = playerFactory.getPlayer("History");
     //   History.takeTurn();


        //----------------------------------------------------------------------------

        History h1 = new History();


        System.out.println("Välj ditt namn");


        name= scanner.nextLine();
        System.out.println("Välkommen " + name);
        System.out.println("----------");
        boolean game= true;
        while (game) {
            myMap.clear();
            System.out.println("Huvud meny :");
            System.out.println("1-Spela turning \n2-Visa history \n3-Avsluta");
            int theAnswer = scanner.nextInt();
            String vinnaren;
            switch (theAnswer) {

                case 1:
                    myMap.put("Vokalis",0);
                    myMap.put("Slumpis",0);
                    myMap.put("Klockis",0);
                    myMap.put(name,0);
                    System.out.println("match 1");
                    String val1 = new Vokalis().voklaisVal("Slumpis");
                    String val2 = new Slumpis().slumpisVal();
                    vinnaren = (start(val1, val2,new Vokalis().getNamn(), new Slumpis().getNamn()));
                    System.out.println("vinnaren är : " + vinnaren);
                    gePoäng(vinnaren);

                    System.out.println("match 2");
                    // match2
                    val1 = new Slumpis().slumpisVal();
                    val2 = User.UserVal();              //ch
                    vinnaren = (start(val1, val2,new Slumpis().getNamn(),name));
                    System.out.println("vinnaren är : " + vinnaren);
                    gePoäng(vinnaren);
                    // match3
                    System.out.println("match 3");
                    val1 = new Vokalis().voklaisVal(name);
                    val2 = User.UserVal();
                    vinnaren = (start(val1, val2,new Vokalis().getNamn(),name));
                    System.out.println("vinnaren är : " + vinnaren);
                    gePoäng(vinnaren);

                    // match4

                    System.out.println("match 4");
                    val1 = new Slumpis().slumpisVal();
                    val2 = new Klockis().min();
                    vinnaren = (start(val1, val2,new Slumpis().getNamn(),new Klockis().getNamn()));
                    System.out.println("vinnaren är : " + vinnaren);
                    gePoäng(vinnaren);
                    // match5
                    System.out.println("match 5");
                    val1 = new Klockis().min();
                    val2 = User.UserVal();
                    vinnaren = (start(val1, val2,new Klockis().getNamn(),name));
                    System.out.println("vinnaren är : " + vinnaren);
                    gePoäng(vinnaren);
                    // match6
                    System.out.println("match 6");
                    val1 = new Klockis().min();
                    val2 = new Vokalis().voklaisVal("Klockis");
                    vinnaren = (start(val1, val2,new Klockis().getNamn(),new Vokalis().getNamn()));
                    for(Map.Entry<String, Integer> entry : myMap.entrySet()) {
                        String key = entry.getKey();
                        Integer value = entry.getValue();
                        System.out.println(key + " " + value);

                        LocalDateTime now = LocalDateTime.now();
                        h1.setMap(key , value);




                    }
                    break;
                case 2:
                    System.out.println(h1.getMap());
                    break;
                case 3:
                    game=false;
                    break;
                default:
            }
        }
    }

    private static void gePoäng(String vinnaren) {

        switch (vinnaren){
            case "Klockis":
                myMap.put("Klockis",myMap.get("Klockis")+1);
                break;
            case "Slumpis":
                myMap.put("Slumpis",myMap.get("Slumpis")+1);
                break;
            case "Vokalis":
                myMap.put("Vokalis",myMap.get("Vokalis")+1);
                break;
            case "ingen vinner":
                break;
            default:
                myMap.put(name, myMap.get(name)+1);
        }
    }









 }

