public class Player {
    private int maxHp;
    private int hp;
    private int gold;
    private int baseA;
    private int multiplier;

    public Player(int maxHp, int gold, int baseAttack) {
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.gold = gold;
        this.baseA = baseAttack;
        this.multiplier = 1;
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
    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }
    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }
}
