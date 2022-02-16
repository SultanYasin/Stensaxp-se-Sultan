package ec.utbildning;

public class PlayerFactory {

    public Players getPlayer(String PlayerType){
        if (PlayerType == null)
            return null;

        if (PlayerType.equalsIgnoreCase("Slumpis")){return new Slumpis();}
        if (PlayerType.equalsIgnoreCase("Klockis")){return new Klockis();}
        if (PlayerType.equalsIgnoreCase("Vokalis")){return new Vokalis();}
        if (PlayerType.equalsIgnoreCase("User")){return new User();}
        if (PlayerType.equalsIgnoreCase("History")){return new History();}
        return null;
    }

}
