package gameplan;

import players.Player;

public final class Move {

    public void makeMove(final Player player, final char typeOfMove) {
        // moves player in the next spot he wants
        if (typeOfMove == 'R') {
           player.setColumnMap(player.getColumnMap() + 1);
        }
        if (typeOfMove == 'L') {
            player.setColumnMap(player.getColumnMap() - 1);
        }
        if (typeOfMove == 'D') {
            player.setLineMap(player.getLineMap() + 1);
        }
        if (typeOfMove == 'U') {
            player.setLineMap(player.getLineMap() - 1);
        }
    }
}
