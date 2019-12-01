package players.type;

import constant.Constants;
import gameplan.TypeOfLand;

public final class Pyromancer extends Player {
    private Constants helper = new Constants();
    private double landAmplifier = 1.0;
    public Pyromancer(char type) {
        super(type);
        setMaxHP(helper.getHpInitialPyromancer());
        setHp(helper.getHpInitialPyromancer());
    }

    private TypeOfLand land = new TypeOfLand();
    private char[][] game_map = land.getMap();

    public void LandAmplifier() {
        if (game_map[getLineMap()][getColumnMap()] == 'V') {
            landAmplifier = helper.getLandAmplifierP();
        }
    }

    @Override
    public void accept(PlayerVisitor player){
        player.visit(this);
    }

    public class FireBlast implements PlayerVisitor{
        private int damageInitial = helper.getFireBlastBaseDamage()
                + helper.getGetFireBlastBaseDamagePerLevel() * getLevel();
        private int fireBlast = 0;

        @Override
        public void visit(final Knight player) {
            LandAmplifier();
            fireBlast = (int) Math.round(damageInitial *
                    helper.getFireBlastAmplifierPK() * landAmplifier);
            player.setReceivedDamage(damageInitial * landAmplifier);
            player.setDamageThisRound(fireBlast);
        }

        @Override
        public void visit(final Pyromancer player) {
            LandAmplifier();
            fireBlast = (int) Math.round(damageInitial
                    * helper.getFireBlastAmplifierPP() * landAmplifier);
            player.setReceivedDamage(damageInitial * landAmplifier);
            player.setDamageThisRound(fireBlast);

        }

        @Override
        public void visit(final Rogue player) {
            player.setDamageThisRound(0);
            LandAmplifier();
            fireBlast = (int) Math.round(damageInitial
                    * helper.getFireBlastAmplifierPR() * landAmplifier);
            player.setReceivedDamage((int) Math.round(damageInitial * landAmplifier));
            player.setDamageThisRound(fireBlast);

        }

        @Override
        public void visit(final Wizard player) {
            LandAmplifier();
            fireBlast = (int) Math.round(damageInitial
                    * helper.getFireBlastAmplifierPW() * landAmplifier);
            player.setReceivedDamage(damageInitial * landAmplifier);
            player.setDamageThisRound(fireBlast);

        }
    }

    public class Ignite implements PlayerVisitor{
        private int baseDamage = 150 + 20 * getLevel();
        private int ignite = 0;

        public void  damage_next_rounds(final Player player){
            LandAmplifier();
            player.setExtraRounds(2);
            player.setDamageExtra(50 + 30 * player.getLevel());
            player.setDamageExtra((int) Math.round(player.getDamageExtra() * landAmplifier));
        }
        @Override
        public void visit(final Knight player) {
            LandAmplifier();
            damage_next_rounds(player);
            ignite = (int) Math.round(baseDamage *
                    helper.getIgniteAmplifierPK() * landAmplifier);
            player.setDamageExtra((int) Math.round(player.getDamageExtra()
                    * helper.getIgniteAmplifierPK() * landAmplifier));
            player.setReceivedDamage(player.getReceivedDamage()
                    + (int) Math.round(baseDamage * landAmplifier));
            player.setDamageThisRound(player.getDamageThisRound() + ignite);

        }

        @Override
        public void visit(final Pyromancer player) {
            LandAmplifier();
            damage_next_rounds(player);
            ignite = (int) Math.round(baseDamage *
                    helper.getFireBlastAmplifierPP() * landAmplifier);
            player.setDamageExtra((int) Math.round(player.getDamageExtra()
                    * helper.getFireBlastAmplifierPP() * landAmplifier));
            player.setReceivedDamage(player.getReceivedDamage()
                    + (int)Math.round(baseDamage * landAmplifier));
            player.setDamageThisRound(player.getDamageThisRound() + ignite);
        }

        @Override
        public void visit(final Rogue player) {
            LandAmplifier();
            damage_next_rounds(player);
            ignite = (int) Math.round(baseDamage * helper.getIgniteAmplifierPR() * landAmplifier);
            player.setDamageExtra((int) Math.round(player.getDamageExtra()
                     * helper.getIgniteAmplifierPR() * landAmplifier));
            player.setReceivedDamage(player.getReceivedDamage()
                    + (int) Math.round(baseDamage * landAmplifier));
            player.setDamageThisRound(player.getDamageThisRound() + ignite);
        }

        @Override
        public void visit(final Wizard player) {
            LandAmplifier();
            damage_next_rounds(player);
            ignite = (int) Math.round(baseDamage * helper.getIgniteAmplifierPW() * landAmplifier);
            player.setDamageExtra((int) Math.round(player.getDamageExtra()
                    * helper.getFireBlastAmplifierPW() * landAmplifier));
            player.setReceivedDamage(player.getReceivedDamage()
                    + (int) Math.round(baseDamage * landAmplifier));
            player.setDamageThisRound(player.getDamageThisRound() + ignite);
        }
    }
}

