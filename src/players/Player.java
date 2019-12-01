package players;

import players.visitor.PlayerVisitor;

public abstract class Player {
    private char type;
    private int hp;
    private int xp = 0;
    private int level = 0;
    private int maxHP;
    // depending on the level, maxHP is the greatest hp a player can have
    private int lineMap;
    private int columnMap;
    // lineMap and columnMap are the coordinates of the player
    private int damageExtra = 0;
    private int extraRounds = 0;
    // damageExtra and extraRounds are for overtime damage
    private int damageThisRound = 0;
    // damageThisRound = all the damage a player receive
    // with land amplifier, bonus damage, race amplifier and so on
    private double receivedDamageWRA = 0;
    // receivedDamage = the damage a player receive without race amplifier
    private int incapacityOfMovement = 0;
    private int wasFighting = 0;
    private int dead = 0;
    // dead = 0 --> the player is still in the game
    // dead = 1 --> the player was eliminated

    public Player(final char type) {
        this.type = type;
    }

    public Player() {

    }
    public abstract void accept(PlayerVisitor player);
    public final void poisonDamage(final Player player) {
        if (player.getExtraRounds() > 0) {
            player.setHp(player.getHp() - player.getDamageExtra());
            player.setExtraRounds(player.getExtraRounds() - 1);
        }
    }

    public final char getType() {
        return type;
    }

    public final int getHp() {
        return hp;
    }

    public final void setHp(final int hp) {
        this.hp = hp;
    }

    public final void setType(final char type) {
        this.type = type;
    }

    public final int getLineMap() {
        return lineMap;
    }

    public final int getColumnMap() {
        return columnMap;
    }

    public final void setLineMap(final int lineMap) {
        this.lineMap = lineMap;
    }

    public final void setColumnMap(final int columnMap) {
        this.columnMap = columnMap;
    }

    public final int getXp() {
        return xp;
    }

    public final void setXp(final int xp) {
        this.xp = xp;
    }

    public final int getLevel() {
        return level;
    }

    public final void setLevel(final int level) {
        this.level = level;
    }

    public final int getMaxHP() {
        return maxHP;
    }

    public final void setMaxHP(final int maxHP) {
        this.maxHP = maxHP;
    }


    public final int getDamageExtra() {
        return damageExtra;
    }

    public final void setDamageExtra(final int damageExtra) {
        this.damageExtra = damageExtra;
    }

    public final int getExtraRounds() {
        return extraRounds;
    }

    public final void setExtraRounds(final int extraRounds) {
        this.extraRounds = extraRounds;
    }

    public final  int getDamageThisRound() {
        return damageThisRound;
    }

    public final void setDamageThisRound(final int damageThisRound) {
        this.damageThisRound = damageThisRound;
    }

    public final double getReceivedDamageWRA() {
        return receivedDamageWRA;
    }

    public final void setReceivedDamageWRA(final double receivedDamageWRA) {
        this.receivedDamageWRA = receivedDamageWRA;
    }

    public final int getIncapacityOfMovement() {
        return incapacityOfMovement;
    }

    public final void setIncapacityOfMovement(final int incapacityOfMovement) {
        this.incapacityOfMovement = incapacityOfMovement;
    }

    public final int getWasFighting() {
        return wasFighting;
    }

    public final void setWasFighting(final int wasFighting) {
        this.wasFighting = wasFighting;
    }

    public final int getDead() {
        return dead;
    }

    public final void setDead(final int dead) {
        this.dead = dead;
    }
}
