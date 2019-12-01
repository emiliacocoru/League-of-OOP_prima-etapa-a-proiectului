package players.type;

import constant.Constants;
import gameplan.TypeOfLand;


public final class Rogue extends Player {
    private Constants helper = new Constants();
    private double landAmplifier = 1;
    private int landExtraRounds = helper.getNumberOfRoundsWithoutAmplifier();
    private int numberOfHits = 0;

    private  TypeOfLand land = new TypeOfLand();
    private char[][] gameMap = land.getMap();
    public Rogue(final char type) {
        super(type);
        setMaxHP(helper.getHpInitialRogue());
        setHp(helper.getHpInitialRogue());
    }

    public void extra() {
        if (gameMap[getLineMap()][getColumnMap()] == 'W') {
            landAmplifier = helper.getLandAmplifierR();
            landExtraRounds = helper.getNumberOfRoundsWithAmplifier();
        }
        if (gameMap[getLineMap()][getColumnMap()] == 'D') {
            landAmplifier = 1;
            landExtraRounds = helper.getNumberOfRoundsWithoutAmplifier();
        }
        if (gameMap[getLineMap()][getColumnMap()] == 'V') {
            landAmplifier = 1;
            landExtraRounds = helper.getNumberOfRoundsWithoutAmplifier();
        }
        if (gameMap[getLineMap()][getColumnMap()] == 'L') {
            landAmplifier = 1;
            landExtraRounds = helper.getNumberOfRoundsWithoutAmplifier();
        }
    }

    @Override
    public void accept(final PlayerVisitor player) {
        player.visit(this);
    }

     public class BackStab implements PlayerVisitor {
        private int baseDamageInitial = helper.getBachStabBaseDamage()
                 + helper.getBacKStabBaseDamagePerLevel() * getLevel();
        private int backStabDamage = 0;
        private double percent = 1.0;

        public double backStabWithBonus(double percent) {
            if (numberOfHits % helper.getHitsNumber() == 0) {
                if (gameMap[getLineMap()][getColumnMap()] == 'W') {
                    percent = helper.getPercentBonusRogue();
                }
            }
            numberOfHits++;
            return percent;
        }
         @Override
         public void visit(final Knight player) {
             extra();
             percent = backStabWithBonus(percent);
             backStabDamage = (int) Math.round(baseDamageInitial * percent
                      * helper.getBackStabAmplifierRK()* landAmplifier);
             player.setReceivedDamage((int) Math.round(baseDamageInitial * landAmplifier));
             player.setDamageThisRound(backStabDamage);
         }

         @Override
         public void visit(final Pyromancer player) {
             extra();
             percent = backStabWithBonus(percent);
             backStabDamage = (int) Math.round(baseDamageInitial * percent
                     * helper.getBackStabAmplifierRP()* landAmplifier);
             player.setReceivedDamage((int) Math.round(baseDamageInitial * percent * landAmplifier));
             player.setDamageThisRound(backStabDamage);
         }

         @Override
         public void visit(final Rogue player) {
             extra();
             percent = backStabWithBonus(percent);
             backStabDamage = (int) Math.round(baseDamageInitial * percent
                     * helper.getBackStabAmplifierRR()* landAmplifier);
             player.setReceivedDamage((int) Math.round(baseDamageInitial * percent * landAmplifier));
             player.setDamageThisRound(backStabDamage);
         }

         @Override
         public void visit(final Wizard player) {
             extra();
             percent = backStabWithBonus(percent);
             backStabDamage = (int) Math.round(baseDamageInitial * percent
                     * helper.getBackStabAmplifierRW()* landAmplifier);
             player.setReceivedDamage((int) Math.round(baseDamageInitial * percent * landAmplifier));
             player.setDamageThisRound(backStabDamage);
         }
     }

     public class Paralysis implements PlayerVisitor{
         private int damage_initial = helper.getParalysisDamage() + helper.getParalysisDamagePerLevel() * getLevel();
         private int damageParalysis = 0;

         @Override
         public void visit(final Knight player) {
             extra();
             damageParalysis = (int) Math.round(damage_initial *
                     helper.getParalysisAmplifierRK() * landAmplifier);
             player.setReceivedDamage(player.getReceivedDamage() + (int)Math.round(damage_initial * landAmplifier));
             player.setDamageExtra(damageParalysis);
             player.setExtraRounds(landExtraRounds);
             player.setDamageThisRound(player.getDamageThisRound() + damageParalysis);
             player.setIncapacityOfMovement(landExtraRounds);
         }

         @Override
         public void visit(final Pyromancer player) {
             extra();
             damageParalysis = (int) Math.round(damage_initial *
                     helper.getParalysisAmplifierRP() * landAmplifier);
             player.setDamageExtra(damageParalysis);
             player.setExtraRounds(landExtraRounds);
             player.setReceivedDamage(player.getReceivedDamage() + (int) Math.round(damage_initial * landAmplifier));
             player.setDamageThisRound(player.getDamageThisRound() + damageParalysis);
             player.setIncapacityOfMovement(landExtraRounds);
         }

         @Override
         public void visit(final Rogue player) {
             extra();
             damageParalysis = (int) Math.round(damage_initial *
                     helper.getParalysisAmplifierRR() * landAmplifier);
             player.setDamageExtra(damageParalysis);
             player.setExtraRounds(landExtraRounds);
             player.setReceivedDamage(player.getReceivedDamage() + (int) Math.round(damage_initial * landAmplifier));
             player.setDamageThisRound(player.getDamageThisRound() + damageParalysis);
             player.setIncapacityOfMovement(landExtraRounds);

         }

         @Override
         public void visit(final Wizard player) {
             extra();
             damageParalysis = (int) Math.round(damage_initial *
                     helper.getBackStabAmplifierRW() * landAmplifier);
             player.setDamageExtra(damageParalysis);
             player.setExtraRounds(landExtraRounds);
             player.setReceivedDamage(player.getReceivedDamage() + (int) Math.round(damage_initial * landAmplifier));
             player.setDamageThisRound(player.getDamageThisRound() + damageParalysis);
             player.setIncapacityOfMovement(landExtraRounds);
         }
     }
}
