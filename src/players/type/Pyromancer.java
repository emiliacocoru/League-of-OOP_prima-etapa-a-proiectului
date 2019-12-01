package players.type;

import constant.Constants;
import gameplan.TypeOfLand;
import players.Player;
import players.visitor.PlayerVisitor;

public final class Pyromancer extends Player {
    private Constants helper = new Constants();
    private double landAmplifier = 1.0;
    public Pyromancer(final char type) {
        super(type);
        setMaxHP(helper.getHpInitialPyromancer());
        setHp(helper.getHpInitialPyromancer());
    }

    private TypeOfLand land = new TypeOfLand();
    private char[][] gameMap = land.getMap();

    // check if is a land amplifier or not
    public void landAmplifier() {
        if (gameMap[getLineMap()][getColumnMap()] == 'V') {
            landAmplifier = helper.getLandAmplifierP();
        }
    }

    @Override
    public void accept(final PlayerVisitor player) {
        player.visit(this);
    }
    // first power
    public final class FireBlast implements PlayerVisitor {
        private int damageInitial = helper.getFireBlastBaseDamage()
                + helper.getGetFireBlastBaseDamagePerLevel() * getLevel();
        private int fireBlast = 0;

        @Override
        public void visit(final Knight player) {
            landAmplifier();
            fireBlast = (int) Math.round(damageInitial
                    * helper.getFireBlastAmplifierPK() * landAmplifier);
            player.setReceivedDamageWRA(damageInitial * landAmplifier);
            player.setDamageThisRound(fireBlast);
        }

        @Override
        public void visit(final Pyromancer player) {
            landAmplifier();
            fireBlast = (int) Math.round(damageInitial
                    * helper.getFireBlastAmplifierPP() * landAmplifier);
            player.setReceivedDamageWRA(damageInitial * landAmplifier);
            player.setDamageThisRound(fireBlast);

        }

        @Override
        public void visit(final Rogue player) {
            player.setDamageThisRound(0);
            landAmplifier();
            fireBlast = (int) Math.round(damageInitial
                    * helper.getFireBlastAmplifierPR() * landAmplifier);
            player.setReceivedDamageWRA((int) Math.round(damageInitial * landAmplifier));
            player.setDamageThisRound(fireBlast);

        }

        @Override
        public void visit(final Wizard player) {
            landAmplifier();
            fireBlast = (int) Math.round(damageInitial
                    * helper.getFireBlastAmplifierPW() * landAmplifier);
            player.setReceivedDamageWRA(damageInitial * landAmplifier);
            player.setDamageThisRound(fireBlast);

        }
    }
    // second power
    public final class Ignite implements PlayerVisitor {
        private int baseDamage = helper.getIgniteDamage()
                + helper.getIgniteDamagePerLevel() * getLevel();
        private int ignite = 0;

        public void damageNextRounds(final Player player) {
            landAmplifier();
            player.setExtraRounds(2);
            player.setDamageExtra(helper.getDamageExtraPyromancer()
                    + helper.getDamageExtraPyromancerPerLevel() * player.getLevel());
            player.setDamageExtra((int) Math.round(player.getDamageExtra() * landAmplifier));
        }
        @Override
        public void visit(final Knight player) {
            landAmplifier();
            damageNextRounds(player);
            ignite = (int) Math.round((baseDamage)
                   * helper.getIgniteAmplifierPK() * landAmplifier);
            player.setDamageExtra((int) Math.round(player.getDamageExtra()
                    * helper.getIgniteAmplifierPK() * landAmplifier));
            player.setReceivedDamageWRA(player.getReceivedDamageWRA()
                    + (int) Math.round(baseDamage * landAmplifier));
            player.setDamageThisRound(player.getDamageThisRound() + ignite);

        }

        @Override
        public void visit(final Pyromancer player) {
            landAmplifier();
            damageNextRounds(player);
            ignite = (int) Math.round((baseDamage)
                    * helper.getFireBlastAmplifierPP() * landAmplifier);
            player.setDamageExtra((int) Math.round(player.getDamageExtra()
                    * helper.getFireBlastAmplifierPP() * landAmplifier));
            player.setReceivedDamageWRA(player.getReceivedDamageWRA()
                    + (int) Math.round(baseDamage * landAmplifier));
            player.setDamageThisRound(player.getDamageThisRound() + ignite);
        }

        @Override
        public void visit(final Rogue player) {
            landAmplifier();
            damageNextRounds(player);
            ignite = (int) Math.round(baseDamage * helper.getIgniteAmplifierPR() * landAmplifier);
            player.setDamageExtra((int) Math.round(player.getDamageExtra()
                     * helper.getIgniteAmplifierPR() * landAmplifier));
            player.setReceivedDamageWRA(player.getReceivedDamageWRA()
                    + (int) Math.round(baseDamage * landAmplifier));
            player.setDamageThisRound(player.getDamageThisRound() + ignite);
        }

        @Override
        public void visit(final Wizard player) {
            landAmplifier();
            damageNextRounds(player);
            ignite = (int) Math.round(baseDamage * helper.getIgniteAmplifierPW() * landAmplifier);
            player.setDamageExtra((int) Math.round(player.getDamageExtra()
                    * helper.getFireBlastAmplifierPW() * landAmplifier));
            player.setReceivedDamageWRA(player.getReceivedDamageWRA()
                    + (int) Math.round(baseDamage * landAmplifier));
            player.setDamageThisRound(player.getDamageThisRound() + ignite);
        }
    }
}

