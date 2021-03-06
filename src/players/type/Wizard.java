package players.type;

import constant.Constants;
import gameplan.Map;
import players.Player;
import players.visitor.PlayerVisitor;

public final class Wizard extends Player {
    private Constants helper = new Constants();
    private Map land = new Map();
    private char[][] gameMap = land.getMap();
    private double landAmplifier = 1.0;
    public Wizard(final char type) {
        super(type);
        setMaxHP(helper.getHpInitialWizard());
        setHp(helper.getHpInitialWizard());
    }

    @Override
    public void accept(final PlayerVisitor player) {
        player.visit(this);
    }
    // check if it is a land amplifier or not
    public void landAmplifier() {
        if (gameMap[getLineMap()][getColumnMap()] == 'D') {
            landAmplifier = helper.getLandAmplifierW();
        }
    }
    // first power
    public final class Drain implements PlayerVisitor {
        private double baseHP =  0;
        private int damageDrain = 0;
        private double damageInitial = helper.getDrainDamage()
                + getLevel() * helper.getDrainDamagePerLevel();
        public void baseHP(final Player player) {
            baseHP = Math.min(helper.getDrainPercent() * player.getMaxHP(), player.getHp());
        }

        @Override
        public void visit(final Knight player) {
            baseHP(player);
            landAmplifier();
            damageDrain = (int) Math.round(landAmplifier * baseHP
                    * damageInitial * helper.getDrainAmplifierWK());
            player.setReceivedDamageWRA((int) Math.round(landAmplifier * baseHP));
            player.setDamageThisRound(damageDrain);
        }

        @Override
        public void visit(final Pyromancer player) {
            landAmplifier();
            baseHP(player);
            damageDrain = (int) Math.round(landAmplifier * baseHP
                    * damageInitial * helper.getDrainAmplifierWP());
            player.setReceivedDamageWRA((int) Math.round(landAmplifier * baseHP));
            player.setDamageThisRound(damageDrain);
        }

        @Override
        public void visit(final Rogue player) {
            baseHP(player);
            System.out.println(baseHP);
            landAmplifier();
            damageDrain = (int) Math.round(landAmplifier
                    * baseHP * damageInitial * helper.getDrainAmplifierWR());
            player.setReceivedDamageWRA((int) Math.round(landAmplifier * baseHP));
            player.setDamageThisRound(damageDrain);
        }

        @Override
        public void visit(final Wizard player) {
            baseHP(player);
            landAmplifier();
            damageDrain = (int) Math.round(landAmplifier
                    * baseHP * damageInitial * helper.getDrainAmplifierWW());
            player.setReceivedDamageWRA((int) Math.round(landAmplifier * baseHP));
            player.setDamageThisRound(damageDrain);

        }
    }
    // second power
    public final class Deflect implements PlayerVisitor {
        private double percentDamage = helper.getDeflectPercent()
                 + helper.getDeflectPercentPerLevel() * getLevel();

        private int deflect = 0;

        public void calculatePercent(final Player player) {
            if (percentDamage > helper.getDeflectPercentMaxim()) {
                percentDamage = helper.getDeflectPercentMaxim();
            }
        }
        @Override
        public void visit(final Knight player) {
            calculatePercent(player);
            landAmplifier();
            player.setExtraRounds(0);
            deflect = (int) Math.round(percentDamage
                    * helper.getDeflectAmplifierWK() * getReceivedDamageWRA() * landAmplifier);
            player.setDamageThisRound(player.getDamageThisRound() + deflect);

        }
        @Override
        public void visit(final Pyromancer player) {
            calculatePercent(player);
            landAmplifier();
            player.setExtraRounds(0);
            deflect = (int) Math.round(percentDamage
                    * helper.getDeflectAmplifierWP() * getReceivedDamageWRA() * landAmplifier);
            player.setDamageThisRound(player.getDamageThisRound() + deflect);
        }

        @Override
        public void visit(final Rogue player) {
            calculatePercent(player);
            landAmplifier();
            player.setExtraRounds(0);
            deflect = (int) Math.round(percentDamage
                    * helper.getDeflectAmplifierWR() * getReceivedDamageWRA() * landAmplifier);
            player.setDamageThisRound(player.getDamageThisRound() + deflect);
        }

        @Override
        public void visit(final Wizard player) {
            calculatePercent(player);
            landAmplifier();
            player.setExtraRounds(0);
            player.setDamageThisRound(player.getDamageThisRound());
        }
    }
}

