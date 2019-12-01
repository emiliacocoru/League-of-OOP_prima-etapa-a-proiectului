package players.type;

public abstract class Player {
    private char type;
    private int hp;
    private int xp = 0;
    private int level = 0;
    private int MaxHP;
    private int lineMap;
    private int columnMap;
    private int damageExtra = 0;
    private int extraRounds = 0;
    private int damageThisRound = 0;
    private double receivedDamage = 0;
    private int incapacityOfMovement = 0;
    private int wasFighting = 0;
    private int dead = 0;

    public Player(char type){
        this.type = type;
    }
    public Player() {

    }

    public char getType() {
        return type;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setType(char type) {
        this.type = type;
    }

    public int getLineMap() {
        return lineMap;
    }

    public int getColumnMap() {
        return columnMap;
    }

    public void setLineMap(int lineMap) {
        this.lineMap = lineMap;
    }

    public void setColumnMap(int columnMap) {
        this.columnMap = columnMap;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMaxHP() {
        return MaxHP;
    }

    public void setMaxHP(int maxHP) {
        MaxHP = maxHP;
    }

    public abstract void accept(PlayerVisitor player);

    public void ExtraD(Player player) {
        if (player.getExtraRounds() > 0) {
            player.setHp(player.getHp() - player.getDamageExtra());
            player.setExtraRounds(player.getExtraRounds() - 1);
        }
    }

    public int getDamageExtra() {
        return damageExtra;
    }

    public void setDamageExtra(int damageExtra) {
        this.damageExtra = damageExtra;
    }

    public int getExtraRounds() {
        return extraRounds;
    }

    public void setExtraRounds(int extraRounds) {
        this.extraRounds = extraRounds;
    }

    public int getDamageThisRound() {
        return damageThisRound;
    }

    public void setDamageThisRound(int damageThisRound) {
        this.damageThisRound = damageThisRound;
    }

    public double getReceivedDamage() {
        return receivedDamage;
    }

    public void setReceivedDamage(double receivedDamage) {
        this.receivedDamage = receivedDamage;
    }

    public int getIncapacityOfMovement() {
        return incapacityOfMovement;
    }

    public void setIncapacityOfMovement(int incapacityOfMovement) {
        this.incapacityOfMovement = incapacityOfMovement;
    }

    public int getWasFighting() {
        return wasFighting;
    }

    public void setWasFighting(int wasFighting) {
        this.wasFighting = wasFighting;
    }

    public int getDead() {
        return dead;
    }

    public void setDead(int dead) {
        this.dead = dead;
    }
}
