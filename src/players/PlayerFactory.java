package players;

import players.type.Knight;
import players.type.Pyromancer;
import players.type.Rogue;
import players.type.Wizard;

public final class PlayerFactory {
    // creates the player according to his type
    public Player createPlayer(final char type) {
        if (type == 'K') {
            return new Knight('K');
        }
        if (type == 'P') {
            return new Pyromancer('P');
        }
        if (type == 'R') {
            return  new Rogue('R');
        }
        if (type == 'W') {
            return new Wizard('W');
        }
        return null;
    }
}
