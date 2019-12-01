package players.type;

import gameplan.TypeOfLand;
import constant.Constants;

public final  class Knight extends Player {
    Constants helper = new Constants();
    private double landAmplifier = 1.0;
    public Knight(){
        super();

    }
    public Knight(final char type) {
        super(type);
        setMaxHP(helper.getHpInitialKnight());
        setHp(helper.getHpInitialKnight());
    }

    @Override
    public void accept(PlayerVisitor player){
        player.visit(this);
    }

    private TypeOfLand land = new TypeOfLand();
    private char[][] game_map = land.getMap();

    public void LandAmplifier() {
        if (game_map[getLineMap()][getColumnMap()] == 'L') {
            landAmplifier = helper.getLandAmplifierK();
        }
    }

    public class Execute implements PlayerVisitor {
        private int damageExecuteInitial = 200 + 30 * getLevel();
        private int execute = 0;
        private int HPLimit = 0;
        public void findHPLimit(final Player player) {
            if (helper.getExecutePercentPerLevel()
                    * player.getLevel() > helper.getExecutePercent()) {
                HPLimit = (int) Math.round(helper.getExecuteMaxPercent()*(player.getMaxHP()));
            } else {
                HPLimit = (int) Math.round((helper.getExecutePercent()
                        + helper.getExecutePercentPerLevel() * player.getLevel()) * (player.getMaxHP()));
            }
        }
        @Override
        public void visit(final Knight player) {
            LandAmplifier();
            findHPLimit(player);
            if (player.getHp() < HPLimit) {
                execute = player.getHp();
                player.setReceivedDamage(execute);
            } else {
                execute = (int) Math.round(damageExecuteInitial * landAmplifier
                         * helper.getExecuteAmplifierKK());
                player.setReceivedDamage((int) Math.round(damageExecuteInitial * landAmplifier));
            }
            player.setDamageThisRound(execute);
        }

        @Override
        public void visit(final Pyromancer player) {
            LandAmplifier();
            findHPLimit(player);
            if (player.getHp() < HPLimit) {
                execute = player.getHp();
                player.setReceivedDamage(execute);
            } else {
                execute = (int) Math.round(damageExecuteInitial
                        * landAmplifier * helper.getExecuteAmplifierKP());
                player.setReceivedDamage((int) Math.round(damageExecuteInitial * landAmplifier));
            }
            player.setDamageThisRound(execute);
        }

        @Override
        public void visit(final Rogue player) {
            LandAmplifier();
            findHPLimit(player);
            if (player.getHp() < HPLimit) {
                execute = player.getHp();
                player.setReceivedDamage(execute);
            } else {
                execute = (int) Math.round(damageExecuteInitial * landAmplifier
                        * helper.getExecuteAmplifierKR());
                player.setReceivedDamage((int) Math.round( damageExecuteInitial * landAmplifier));
            }
            player.setDamageThisRound(execute);
        }

        @Override
        public void visit(final Wizard player) {
            LandAmplifier();
            findHPLimit(player);
            if (player.getHp() < HPLimit) {
                execute = player.getHp();
                player.setReceivedDamage(execute);
            } else {
                execute = (int) Math.round(damageExecuteInitial * landAmplifier
                        * helper.getExecuteAmplifierKW());
                player.setReceivedDamage(damageExecuteInitial * landAmplifier);
            }
            player.setDamageThisRound(execute);

        }
    }

    public class Slam implements PlayerVisitor{
        private int base_damage = 100 + 40 * getLevel();
        private int slam = 0;
        @Override
        public void visit(final Knight player) {
            LandAmplifier();
            slam = (int) Math.round(base_damage * helper.getSlamAmplifierKK() * landAmplifier);
            player.setReceivedDamage(player.getReceivedDamage() + (int) Math.round(base_damage * landAmplifier));
            player.setDamageThisRound(player.getDamageThisRound() + slam);
            player.setExtraRounds(0);
            player.setIncapacityOfMovement(1);

        }

        @Override
        public void visit(final Pyromancer player) {
            LandAmplifier();
            slam = (int) Math.round(base_damage * helper.getSlamAmplifierKP() * landAmplifier);
            player.setReceivedDamage(player.getReceivedDamage() + (int) Math.round(base_damage * landAmplifier));
            player.setDamageThisRound(player.getDamageThisRound() + slam);
            player.setExtraRounds(0);
            player.setIncapacityOfMovement(1);

        }

        @Override
        public void visit(final Rogue player) {
            LandAmplifier();
            slam = (int) Math.round(base_damage * helper.getSlamAmplifierKR() * landAmplifier);
            player.setReceivedDamage(player.getReceivedDamage() + (int) Math.round(base_damage * landAmplifier));
            player.setDamageThisRound(player.getDamageThisRound() + slam);
            player.setExtraRounds(0);
            player.setIncapacityOfMovement(1);

        }

        @Override
        public void visit(final Wizard player) {
            LandAmplifier();
            slam = (int) Math.round(base_damage * helper.getSlamAmplifierKW() * landAmplifier);
            player.setReceivedDamage(player.getReceivedDamage() + (int) Math.round(base_damage*landAmplifier));
            player.setDamageThisRound(player.getDamageThisRound() + slam);
            player.setExtraRounds(0);
            player.setIncapacityOfMovement(1);
        }
    }
}
