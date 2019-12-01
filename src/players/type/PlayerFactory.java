package players.type;

public class PlayerFactory {
    public Player createPlayer(final char type) {
        if (type == 'K') {
            return new Knight('K');
        }
        if (type == 'P'){
            return new Pyromancer('P');
        }
        if (type == 'R'){
            return  new Rogue('R');
        }
        if (type == 'W'){
            return new Wizard('W');
        }
        return null;
    }
}
