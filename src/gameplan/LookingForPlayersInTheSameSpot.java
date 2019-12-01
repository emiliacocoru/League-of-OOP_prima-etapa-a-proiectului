package gameplan;

import players.Player;

import java.util.ArrayList;

public final class LookingForPlayersInTheSameSpot {
    public void lookingForPlayersInTheSameSpot(final ArrayList<Player> players) {
        Fight battle = new Fight();
        Player firstPlayer = null;
        Player secondPlayer = null;
        GetXPandMaybeLevelUP lv = new GetXPandMaybeLevelUP();
        // finds two players in the same place on the map
        // if the players are alive and they didn't fight
        // they will face each other
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
                                // if the first player is a wizard
                                // the second player "will attack" first
                                if (firstPlayer.getType() == 'W') {
                                    battle.fight(secondPlayer, firstPlayer);
                                    battle.fight(firstPlayer, secondPlayer);
                                } else {
                                    battle.fight(firstPlayer, secondPlayer);
                                    battle.fight(secondPlayer, firstPlayer);
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
                                // if one manages to kill the other,
                                // he receives xp and is able to level up
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
