package gameplan;

import players.type.Player;

public final class Move {

    public void move(final Player player, final char typeOfMove) {
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
