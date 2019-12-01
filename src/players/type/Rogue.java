package players.type;

import constant.Constants;
import gameplan.TypeOfLand;
import players.Player;
import players.visitor.PlayerVisitor;


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

    // check if is a land amplifier or not
    // and if there are 3 or 6 overtime damage rounds
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
     // first power
     public final class BackStab implements PlayerVisitor {
        private int damageInitial = helper.getBachStabBaseDamage()
                 + helper.getBacKStabBaseDamagePerLevel() * getLevel();
        private int backStabDamage = 0;
        private double percent = 1.0;


        public void backStabWithBonus() {
            if (numberOfHits % helper.getHitsNumber() == 0) {
                if (gameMap[getLineMap()][getColumnMap()] == 'W') {
                    percent = helper.getPercentBonusRogue();
                } else {
                    percent = 1;
                }
            } else {
                percent = 1;
            }
            numberOfHits++;
        }
         @Override
         public void visit(final Knight player) {
             extra();
             backStabWithBonus();
             backStabDamage = (int) Math.round(damageInitial * percent
                      * helper.getBackStabAmplifierRK() * landAmplifier);
             player.setReceivedDamageWRA((int) Math.round(damageInitial * landAmplifier));
             player.setDamageThisRound(backStabDamage);
         }

         @Override
         public void visit(final Pyromancer player) {
             extra();
             backStabWithBonus();
             backStabDamage = (int) Math.round(damageInitial * percent
                     * helper.getBackStabAmplifierRP() * landAmplifier);
             player.setReceivedDamageWRA((int) Math.round(damageInitial * percent * landAmplifier));
             player.setDamageThisRound(backStabDamage);
         }

         @Override
         public void visit(final Rogue player) {
             extra();
             backStabWithBonus();
             backStabDamage = (int) Math.round(damageInitial * percent
                     * helper.getBackStabAmplifierRR() * landAmplifier);
             player.setReceivedDamageWRA((int) Math.round(damageInitial * percent * landAmplifier));
             player.setDamageThisRound(backStabDamage);
         }

         @Override
         public void visit(final Wizard player) {
             extra();
             backStabWithBonus();
             backStabDamage = (int) Math.round(damageInitial * percent
                     * helper.getBackStabAmplifierRW() * landAmplifier);
             player.setReceivedDamageWRA((int) Math.round(damageInitial * percent * landAmplifier));
             player.setDamageThisRound(backStabDamage);
         }
     }
     // second power
     public final class Paralysis implements PlayerVisitor {
         private int damageInitial = (helper.getParalysisDamage())
                 + helper.getParalysisDamagePerLevel() * getLevel();
         private int damageParalysis = 0;

         @Override
         public void visit(final Knight player) {
             extra();
             damageParalysis = (int) Math.round(damageInitial
                     * helper.getParalysisAmplifierRK() * landAmplifier);
             player.setReceivedDamageWRA(player.getReceivedDamageWRA()
                     + (int) Math.round(damageInitial * landAmplifier));
             player.setDamageExtra(damageParalysis);
             player.setExtraRounds(landExtraRounds);
             player.setDamageThisRound(player.getDamageThisRound() + damageParalysis);
             player.setIncapacityOfMovement(landExtraRounds);
         }

         @Override
         public void visit(final Pyromancer player) {
             extra();
             damageParalysis = (int) Math.round(damageInitial
                     * helper.getParalysisAmplifierRP() * landAmplifier);
             player.setDamageExtra(damageParalysis);
             player.setExtraRounds(landExtraRounds);
             player.setReceivedDamageWRA((player.getReceivedDamageWRA())
                     + (int) Math.round(damageInitial * landAmplifier));
             player.setDamageThisRound(player.getDamageThisRound() + damageParalysis);
             player.setIncapacityOfMovement(landExtraRounds);
         }

         @Override
         public void visit(final Rogue player) {
             extra();
             damageParalysis = (int) Math.round(damageInitial
                     * helper.getParalysisAmplifierRR() * landAmplifier);
             player.setDamageExtra(damageParalysis);
             player.setExtraRounds(landExtraRounds);
             player.setReceivedDamageWRA((player.getReceivedDamageWRA())
                     + (int) Math.round(damageInitial * landAmplifier));
             player.setDamageThisRound(player.getDamageThisRound() + damageParalysis);
             player.setIncapacityOfMovement(landExtraRounds);

         }

         @Override
         public void visit(final Wizard player) {
             extra();
             damageParalysis = (int) Math.round(damageInitial
                    * helper.getBackStabAmplifierRW() * landAmplifier);
             player.setDamageExtra(damageParalysis);
             player.setExtraRounds(landExtraRounds);
             player.setReceivedDamageWRA((player.getReceivedDamageWRA())
                     + (int) Math.round(damageInitial * landAmplifier));
             player.setDamageThisRound(player.getDamageThisRound() + damageParalysis);
             player.setIncapacityOfMovement(landExtraRounds);
         }
     }
}
