public class Weapon extends Item {
    public enum WeaponType {
        SWORD("Blade of Eternal Flame", 14),
        AXE("Skullsplitter", 16),
        BOW("Whisperwind Bow", 11),
        DAGGER("Fang of Shadows", 9),
        HAMMER("Titan’s Grasp", 18),
        SPEAR("Stormpiercer", 13),
        STAFF("Wyrmwood Staff", 10);

        private final String name;
        private final int damage;

        WeaponType(String name, int damage) {
            this.name = name;
            this.damage = damage;
        }

        public String getName() {
            return name;
        }

        public int getDamage() {
            return damage;
        }

    }

    WeaponType weaponType;
    String name;
    int damage;

    Weapon(WeaponType weaponType) {
        super(Item.ItemType.WEAPON, weaponType.getName(), weaponType.getDamage());
        this.weaponType = weaponType;
    }
}
