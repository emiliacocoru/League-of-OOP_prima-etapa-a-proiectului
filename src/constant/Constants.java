package constant;

public final class Constants {
    public Constants() {
    }

    private final int hpInitialKnight = 900;
    private final int hpInitialRogue = 600;
    private final int hpInitialPyromancer = 500;
    private final int hpInitialWizard = 400;

    private final double fireBlastAmplifierPR = 0.8;
    private final double fireBlastAmplifierPK = 1.2;
    private final double fireBlastAmplifierPP = 0.9;
    private final double fireBlastAmplifierPW = 1.05;

    private final double igniteAmplifierPR = 0.8;
    private final double igniteAmplifierPK = 1.2;
    private final double igniteAmplifierPP = 0.9;
    private final double igniteAmplifierPW = 1.05;

    private final double executeAmplifierKR = 1.15;
    private final double executeAmplifierKK = 1;
    private final double executeAmplifierKP = 1.1;
    private final double executeAmplifierKW = 0.8;

    private final double slamAmplifierKR = 0.8;
    private final double slamAmplifierKK = 1.2;
    private final double slamAmplifierKP = 0.9;
    private final double slamAmplifierKW = 1.05;

    private final double drainAmplifierWR = 0.8;
    private final double drainAmplifierWK = 1.2;
    private final double drainAmplifierWP = 0.9;
    private final double drainAmplifierWW = 1.05;

    private final double deflectAmplifierWR = 1.2;
    private final double deflectAmplifierWK = 1.4;
    private final double deflectAmplifierWP = 1.3;

    private final double backStabAmplifierRR = 1.2;
    private final double backStabAmplifierRK = 0.9;
    private final double backStabAmplifierRP = 1.25;
    private final double backStabAmplifierRW = 1.25;

    private final double paralysisAmplifierRR = 0.9;
    private final double paralysisAmplifierRK = 0.8;
    private final double paralysisAmplifierRP = 1.2;
    private final double paralysisAmplifierRW = 1.25;


    private final int levelUpHPKnight = 80;
    private final int levelUpHPRoque =  40;
    private final int levelUpHpPyromancer = 50;
    private final int levelUpHpWizard = 30;
    private final int xpValue = 200;
    private final int xpPerLevelValue = 40;
    private final int levelUpValue = 250;
    private final int levelUpPerLevelValue = 50;

    private final double landAmplifierR = 1.15;
    private final int numberOfRoundsWithoutAmplifier = 3;
    private final int numberOfRoundsWithAmplifier = 6;
    private final int hitsNumber = 3;
    private final double percentBonusRogue = 1.5;

    private final int bachStabBaseDamage = 200;
    private final int bacKStabBaseDamagePerLevel = 20;

    private final int fireBlastBaseDamage = 350;
    private final int getFireBlastBaseDamagePerLevel = 50;

    private final double landAmplifierP = 1.25;

    private final double landAmplifierW = 1.1;

    private final double deflectPercent = 0.35;
    private final double deflectPercentPerLevel = 0.02;
    private final double deflectPercentMaxim = 0.7;

    private  final double drainDamage = 0.20;
    private final double drainDamagePerLevel = 0.05;
    private final double drainPercent = 0.3;

    private final double landAmplifierK = 1.15;
    private final double executePercentPerLevel = 0.01;
    private final double executePercent = 0.2;
    private final double executeMaxPercent = 0.4;

    private final int paralysisDamage = 40;
    private final int ParalysisDamagePerLevel = 10 ;


    public int getParalysisDamage() {
        return paralysisDamage;
    }

    public int getParalysisDamagePerLevel() {
        return ParalysisDamagePerLevel;
    }

    public double getExecutePercentPerLevel() {
        return executePercentPerLevel;
    }

    public double getExecutePercent() {
        return executePercent;
    }

    public double getExecuteMaxPercent() {
        return executeMaxPercent;
    }

    public double getLandAmplifierK() {
        return landAmplifierK;
    }

    public int getHpInitialKnight() {
        return hpInitialKnight;
    }

    public int getHpInitialRogue() {
        return hpInitialRogue;
    }

    public int getHpInitialPyromancer() {
        return hpInitialPyromancer;
    }

    public int getHpInitialWizard() {
        return hpInitialWizard;
    }

    public double getDrainPercent() {
        return drainPercent;
    }

    public double getDrainDamage() {
        return drainDamage;
    }

    public double getDrainDamagePerLevel() {
        return drainDamagePerLevel;
    }

    public double getDeflectPercentMaxim() {
        return deflectPercentMaxim;
    }

    public double getDeflectPercent() {
        return deflectPercent;
    }

    public double getDeflectPercentPerLevel() {
        return deflectPercentPerLevel;
    }

    public double getLandAmplifierW() {
        return landAmplifierW;
    }

    public double getLandAmplifierP() {
        return landAmplifierP;
    }

    public int getFireBlastBaseDamage() {
        return fireBlastBaseDamage;
    }

    public int getGetFireBlastBaseDamagePerLevel() {
        return getFireBlastBaseDamagePerLevel;
    }

    public int getBachStabBaseDamage() {
        return bachStabBaseDamage;
    }

    public int getBacKStabBaseDamagePerLevel() {
        return bacKStabBaseDamagePerLevel;
    }

    public double getPercentBonusRogue() {
        return percentBonusRogue;
    }

    public int getHitsNumber() {
        return hitsNumber;
    }

    public double getLandAmplifierR() {
        return landAmplifierR;
    }

    public int getNumberOfRoundsWithoutAmplifier() {
        return numberOfRoundsWithoutAmplifier;
    }

    public int getNumberOfRoundsWithAmplifier() {
        return numberOfRoundsWithAmplifier;
    }

    public int getXpPerLevelValue() {
        return xpPerLevelValue;
    }

    public int getLevelUpValue() {
        return levelUpValue;
    }

    public int getLevelUpPerLevelValue() {
        return levelUpPerLevelValue;
    }

    public int getXpValue() {
        return xpValue;
    }

    public int getLevelUpHPKnight() {
        return levelUpHPKnight;
    }

    public int getLevelUpHPRoque() {
        return levelUpHPRoque;
    }

    public int getLevelUpHpPyromancer() {
        return levelUpHpPyromancer;
    }

    public int getLevelUpHpWizard() {
        return levelUpHpWizard;
    }

    public double getFireBlastAmplifierPR() {
        return fireBlastAmplifierPR;
    }

    public double getFireBlastAmplifierPK() {
        return fireBlastAmplifierPK;
    }

    public double getFireBlastAmplifierPP() {
        return fireBlastAmplifierPP;
    }

    public double getFireBlastAmplifierPW() {
        return fireBlastAmplifierPW;
    }

    public double getIgniteAmplifierPR() {
        return igniteAmplifierPR;
    }

    public double getIgniteAmplifierPK() {
        return igniteAmplifierPK;
    }

    public double getIgniteAmplifierPP() {
        return igniteAmplifierPP;
    }

    public double getIgniteAmplifierPW() {
        return igniteAmplifierPW;
    }

    public double getExecuteAmplifierKR() {
        return executeAmplifierKR;
    }

    public double getExecuteAmplifierKK() {
        return executeAmplifierKK;
    }

    public double getExecuteAmplifierKP() {
        return executeAmplifierKP;
    }

    public double getExecuteAmplifierKW() {
        return executeAmplifierKW;
    }

    public double getSlamAmplifierKR() {
        return slamAmplifierKR;
    }

    public double getSlamAmplifierKK() {
        return slamAmplifierKK;
    }

    public double getSlamAmplifierKP() {
        return slamAmplifierKP;
    }

    public double getSlamAmplifierKW() {
        return slamAmplifierKW;
    }

    public double getDrainAmplifierWR() {
        return drainAmplifierWR;
    }

    public double getDrainAmplifierWK() {
        return drainAmplifierWK;
    }

    public double getDrainAmplifierWP() {
        return drainAmplifierWP;
    }

    public double getDrainAmplifierWW() {
        return drainAmplifierWW;
    }

    public double getDeflectAmplifierWR() {
        return deflectAmplifierWR;
    }

    public double getDeflectAmplifierWK() {
        return deflectAmplifierWK;
    }

    public double getDeflectAmplifierWP() {
        return deflectAmplifierWP;
    }

    public double getBackStabAmplifierRR() {
        return backStabAmplifierRR;
    }

    public double getBackStabAmplifierRK() {
        return backStabAmplifierRK;
    }

    public double getBackStabAmplifierRP() {
        return backStabAmplifierRP;
    }

    public double getBackStabAmplifierRW() {
        return backStabAmplifierRW;
    }

    public double getParalysisAmplifierRR() {
        return paralysisAmplifierRR;
    }

    public double getParalysisAmplifierRK() {
        return paralysisAmplifierRK;
    }

    public double getParalysisAmplifierRP() {
        return paralysisAmplifierRP;
    }

    public double getParalysisAmplifierRW() {
        return paralysisAmplifierRW;
    }
}
