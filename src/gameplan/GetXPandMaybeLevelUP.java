package gameplan;

import constant.Constants;
import players.type.Player;

public final class GetXPandMaybeLevelUP {
    private Constants helper = new Constants();
    // when a player win
    // he receives xp according to the formula below
    public void getXP(final Player winner, final Player loser) {
        winner.setXp(winner.getXp() + max(0, helper.getXpValue()
                 - ((winner.getLevel() - loser.getLevel()) * helper.getXpPerLevelValue())));
    }

    private int max(final int x, final int y) {
        if (x > y) {
            return x;
        } else {
            return y;
        }
    }
    // if his xp exceeds certain limits, he will advance in level
    public void xpLevelUp(final Player winner) {
        while (winner.getXp() >= helper.getLevelUpValue()
                + winner.getLevel() * helper.getLevelUpPerLevelValue()) {
            winner.setLevel(winner.getLevel() + 1);
            if (winner.getType() == 'K') {
                winner.setHp(winner.getMaxHP() + helper.getLevelUpHPKnight());
                winner.setMaxHP(winner.getHp());
            }
            if (winner.getType() == 'P') {
                winner.setHp(winner.getMaxHP() + helper.getLevelUpHpPyromancer());
                winner.setMaxHP(winner.getHp());
            }
            if (winner.getType() == 'R') {
                winner.setHp(winner.getMaxHP() + helper.getLevelUpHPRoque());
                winner.setMaxHP(winner.getHp());
            }
            if (winner.getType() == 'W') {
                winner.setHp(winner.getMaxHP() + helper.getLevelUpHpWizard());
                winner.setMaxHP(winner.getHp());
            }
        }
    }
}
