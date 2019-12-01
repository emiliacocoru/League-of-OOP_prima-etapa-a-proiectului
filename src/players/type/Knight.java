package players.type;

import gameplan.TypeOfLand;
import constant.Constants;

public final  class Knight extends Player {
    private Constants helper = new Constants();
    private double landAmplifier = 1.0;
    public Knight() {
        super();
    }
    public Knight(final char type) {
        super(type);
        setMaxHP(helper.getHpInitialKnight());
        setHp(helper.getHpInitialKnight());
    }

    @Override
    public void accept(final PlayerVisitor player) {
        player.visit(this);
    }

    private TypeOfLand land = new TypeOfLand();
    private char[][] gameMap = land.getMap();

    public void landAmplifier() {
        if (gameMap[getLineMap()][getColumnMap()] == 'L') {
            landAmplifier = helper.getLandAmplifierK();
        }
    }

    public final class Execute implements PlayerVisitor {
        private int damageExecuteInitial = helper.getExecuteDamage()
                + helper.getExecuteDamagePerLevel() * getLevel();
        private int execute = 0;
        private int hpLimit = 0;
        public void findHPLimit(final Player player) {
            if (helper.getExecutePercentPerLevel()
                    * player.getLevel() > helper.getExecutePercent()) {
                hpLimit = (int) Math.round(helper.getExecuteMaxPercent() * (player.getMaxHP()));
            } else {
                hpLimit = (int) Math.round((helper.getExecutePercent()
                        + helper.getExecutePercentPerLevel()
                        * player.getLevel()) * (player.getMaxHP()));
            }
        }
        @Override
        public void visit(final Knight player) {
            landAmplifier();
            findHPLimit(player);
            if (player.getHp() < hpLimit) {
                execute = player.getHp();
                player.setReceivedDamageWRA(execute);
            } else {
                execute = (int) Math.round(damageExecuteInitial * landAmplifier
                         * helper.getExecuteAmplifierKK());
                player.setReceivedDamageWRA((int) Math.round(damageExecuteInitial * landAmplifier));
            }
            player.setDamageThisRound(execute);
        }

        @Override
        public void visit(final Pyromancer player) {
            landAmplifier();
            findHPLimit(player);
            if (player.getHp() < hpLimit) {
                execute = player.getHp();
                player.setReceivedDamageWRA(execute);
            } else {
                execute = (int) Math.round(damageExecuteInitial
                        * landAmplifier * helper.getExecuteAmplifierKP());
                player.setReceivedDamageWRA((int) Math.round(damageExecuteInitial * landAmplifier));
            }
            player.setDamageThisRound(execute);
        }

        @Override
        public void visit(final Rogue player) {
            landAmplifier();
            findHPLimit(player);
            if (player.getHp() < hpLimit) {
                execute = player.getHp();
                player.setReceivedDamageWRA(execute);
            } else {
                execute = (int) Math.round(damageExecuteInitial * landAmplifier
                        * helper.getExecuteAmplifierKR());
                player.setReceivedDamageWRA((int) Math.round(damageExecuteInitial * landAmplifier));
            }
            player.setDamageThisRound(execute);
        }

        @Override
        public void visit(final Wizard player) {
            landAmplifier();
            findHPLimit(player);
            if (player.getHp() < hpLimit) {
                execute = player.getHp();
                player.setReceivedDamageWRA(execute);
            } else {
                execute = (int) Math.round(damageExecuteInitial * landAmplifier
                        * helper.getExecuteAmplifierKW());
                player.setReceivedDamageWRA(damageExecuteInitial * landAmplifier);
            }
            player.setDamageThisRound(execute);

        }
    }

    public final class Slam implements PlayerVisitor {
        private int baseDamage = helper.getSlamDamage()
                + helper.getSlamDamagePerLevel() * getLevel();
        private int slam = 0;
        @Override
        public void visit(final Knight player) {
            landAmplifier();
            slam = (int) Math.round(baseDamage * helper.getSlamAmplifierKK() * landAmplifier);
            player.setReceivedDamageWRA((player.getReceivedDamageWRA())
                    + (int) Math.round(baseDamage * landAmplifier));
            player.setDamageThisRound(player.getDamageThisRound() + slam);
            player.setExtraRounds(0);
            player.setIncapacityOfMovement(1);

        }

        @Override
        public void visit(final Pyromancer player) {
            landAmplifier();
            slam = (int) Math.round(baseDamage * helper.getSlamAmplifierKP() * landAmplifier);
            player.setReceivedDamageWRA((player.getReceivedDamageWRA())
                    + (int) Math.round(baseDamage * landAmplifier));
            player.setDamageThisRound(player.getDamageThisRound() + slam);
            player.setExtraRounds(0);
            player.setIncapacityOfMovement(1);

        }

        @Override
        public void visit(final Rogue player) {
            landAmplifier();
            slam = (int) Math.round(baseDamage * helper.getSlamAmplifierKR() * landAmplifier);
            player.setReceivedDamageWRA(player.getReceivedDamageWRA()
                    + (int) Math.round(baseDamage * landAmplifier));
            player.setDamageThisRound(player.getDamageThisRound() + slam);
            player.setExtraRounds(0);
            player.setIncapacityOfMovement(1);

        }

        @Override
        public void visit(final Wizard player) {
            landAmplifier();
            slam = (int) Math.round(baseDamage * helper.getSlamAmplifierKW() * landAmplifier);
            player.setReceivedDamageWRA((player.getReceivedDamageWRA())
                    + (int) Math.round(baseDamage * landAmplifier));
            player.setDamageThisRound(player.getDamageThisRound() + slam);
            player.setExtraRounds(0);
            player.setIncapacityOfMovement(1);
        }
    }
}
