package gameplan;

import players.type.Player;

import java.util.ArrayList;

public final class LookingForPlayersInTheSameSpot {
    public void lookingForPlayersInTheSameSpot(final ArrayList<Player> players) {
        Fight fight = new Fight();
        Player firstPlayer = null;
        Player secondPlayer = null;
        GetXPandMAXLEVEL lv = new GetXPandMAXLEVEL();

        for (int p = 0; p < players.size(); p++) {
            firstPlayer = players.get(p);
            if (firstPlayer.getWasFighting() == 0 && firstPlayer.getDead() == 0) {
                for (int q = players.size() - 1; q >= 0; q--) {
                    secondPlayer = players.get(q);
                    if ((secondPlayer.getWasFighting() == 0)
                            && secondPlayer.getDead() == 0 && p != q) {
                        if (firstPlayer.getLineMap() == secondPlayer.getLineMap()) {
                            if (firstPlayer.getColumnMap() == secondPlayer.getColumnMap()) {
                                secondPlayer.setWasFighting(1);
                                firstPlayer.setWasFighting(1);
                                if (firstPlayer.getType() == 'W') {
                                    fight.fight(secondPlayer, firstPlayer);
                                    fight.fight(firstPlayer, secondPlayer);
                                } else {
                                    fight.fight(firstPlayer, secondPlayer);
                                    fight.fight(secondPlayer, firstPlayer);
                                }
                                firstPlayer.setHp(firstPlayer.getHp()
                                        - firstPlayer.getDamageThisRound());
                                secondPlayer.setHp(secondPlayer.getHp()
                                        - secondPlayer.getDamageThisRound());
                                if (secondPlayer.getHp() < 0) {
                                    secondPlayer.setDead(1);
                                }
                                if (firstPlayer.getHp() < 0) {
                                    firstPlayer.setDead(1);
                                }
                                if (firstPlayer.getDead() == 0 && secondPlayer.getDead() == 1) {
                                    lv.getXP(firstPlayer, secondPlayer);
                                    lv.xpLevelUp(firstPlayer);
                                }
                                if (secondPlayer.getDead() == 0 && firstPlayer.getDead() == 1) {
                                    lv.getXP(secondPlayer, firstPlayer);
                                    lv.xpLevelUp(secondPlayer);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
