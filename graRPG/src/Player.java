public class Player {
    private int maxHp;
    private int hp;
    private int gold;
    private int baseA;
    private int multiplier;

    public Player(int maxHp, int gold, int baseAttack) {
        this.maxHp = maxHp;
        this.hp = maxHp; // Start at full health
        this.gold = gold;
        this.baseA = baseAttack;
    }

    public void setBaseA(int baseAtt) {
        this.baseA = baseAtt;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setHp(int hp) {
        if (hp > maxHp) {
            this.hp = maxHp;
        } else if (hp < 0) {
            this.hp = 0;
        } else {
            this.hp = hp;
        }
    }

    public int getDamage() {
        return baseA*multiplier;
    }

    public int getGold() {
        return gold;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }
}
