public class Enemy {
    public enum Race {
        WOLF("Wolf"),
        GOBLIN("Goblin"),
        BANDIT("Bandit");

        private final String displayName;

        Race(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    private int dmg;
    private int hp;
    private Race race;

    public Enemy(int damage, int hp, Race race) {
        this.dmg = damage;
        this.race = race;
        this.hp = hp;
    }

    public int getDmg() {
        return dmg;
    }

    public Race getRace() {
        return race;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
    
    public int getHp() {
        return hp;
    }

    @Override
    public String toString() {
        return race.getDisplayName() + " (DMG: " + dmg + ")";
    }
}
