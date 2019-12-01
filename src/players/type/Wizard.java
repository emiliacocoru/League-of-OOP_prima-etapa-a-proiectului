package players.type;

import constant.Constants;
import gameplan.TypeOfLand;

public final class Wizard extends Player {
    private Constants helper = new Constants();
    private TypeOfLand land = new TypeOfLand();
    private char[][] game_map = land.getMap();
    private double landAmplifier = 1.0;
    public Wizard(char type) {
        super(type);
        setMaxHP(helper.getHpInitialWizard());
        setHp(helper.getHpInitialWizard());
    }

    @Override
    public void accept(PlayerVisitor player) {
        player.visit(this);
    }
    public void LandAmplifier() {
        if (game_map[getLineMap()][getColumnMap()] == 'D') {
            landAmplifier = helper.getLandAmplifierW();
        }
    }
    public class Drain implements PlayerVisitor {
        private double base_HP =  0;
        private int damage_drain = 0;
        private double damage_initial = helper.getDrainDamage()
                + getLevel() * helper.getDrainDamagePerLevel();
        public void baseHP(Player player) {
            base_HP = Math.min(helper.getDrainPercent() * player.getMaxHP(), player.getHp());
            System.out.println(base_HP);

        }

        @Override
        public void visit(Knight player) {
            baseHP(player);
            LandAmplifier();
            damage_drain = (int) Math.round(landAmplifier * base_HP
                    * damage_initial * helper.getDrainAmplifierWK());
            player.setReceivedDamage((int) Math.round(landAmplifier * base_HP));
            player.setDamageThisRound(damage_drain);
        }

        @Override
        public void visit(Pyromancer player) {
            LandAmplifier();
            baseHP(player);
            damage_drain = (int) Math.round(landAmplifier * base_HP
                    * damage_initial * helper.getDrainAmplifierWP());
            player.setReceivedDamage((int) Math.round(landAmplifier * base_HP));
            player.setDamageThisRound(damage_drain);
        }

        @Override
        public void visit(Rogue player) {
            baseHP(player);
            System.out.println(base_HP);
            LandAmplifier();
            damage_drain = (int) Math.round(landAmplifier
                    * base_HP * damage_initial * helper.getDrainAmplifierWR());
            player.setReceivedDamage((int) Math.round(landAmplifier * base_HP));
            player.setDamageThisRound(damage_drain);
        }

        @Override
        public void visit(Wizard player) {
            baseHP(player);
            LandAmplifier();
            damage_drain = (int) Math.round(landAmplifier
                    * base_HP * damage_initial * helper.getDrainAmplifierWW());
            player.setReceivedDamage((int) Math.round(landAmplifier * base_HP));
            player.setDamageThisRound(damage_drain);

        }
    }

    public class Deflect implements PlayerVisitor{
        private double percentDamage = helper.getDeflectPercent()
                 + helper.getDeflectPercentPerLevel() * getLevel();

        private int deflect = 0;

        public void calculatePercent(Player player){
            if (percentDamage > helper.getDeflectPercentMaxim()) {
                percentDamage = helper.getDeflectPercentMaxim();
            }
        }
        @Override
        public void visit(Knight player) {
            calculatePercent(player);
            LandAmplifier();
            player.setExtraRounds(0);
            deflect = (int) Math.round(percentDamage
                    * helper.getDeflectAmplifierWK() * getReceivedDamage() * landAmplifier);
            player.setDamageThisRound(player.getDamageThisRound() + deflect);

        }
        @Override
        public void visit(Pyromancer player) {
            calculatePercent(player);
            LandAmplifier();
            player.setExtraRounds(0);
            deflect = (int) Math.round(percentDamage
                    * helper.getDeflectAmplifierWP() * getReceivedDamage() * landAmplifier);
            player.setDamageThisRound(player.getDamageThisRound() + deflect);
        }

        @Override
        public void visit(Rogue player) {
            calculatePercent(player);
            LandAmplifier();
            player.setExtraRounds(0);
            deflect = (int) Math.round(percentDamage
                    * helper.getDeflectAmplifierWR() * getReceivedDamage() * landAmplifier);
            player.setDamageThisRound(player.getDamageThisRound() + deflect);
        }

        @Override
        public void visit(Wizard player) {
            calculatePercent(player);
            LandAmplifier();
            player.setExtraRounds(0);
            player.setDamageThisRound(player.getDamageThisRound() + 0);
        }
    }
}

