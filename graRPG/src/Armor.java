public class Armor extends Item {
    public enum ArmorType {
        LIGHT("light armor", "Shadowcloak", 8),
        MEDIUM("medium armor", "Ironhide Jerkin", 12),
        HEAVY("heavy armor", "Dragonplate", 18),
        MAGICAL("enchanted armor", "Aegis of the Ancients", 15);

        private final String category;
        private final String name;
        private final int defense;

        ArmorType(String category, String name, int defense) {
            this.category = category;
            this.name = name;
            this.defense = defense;
        }

        public String getCategory() {
            return category;
        }

        public String getName() {
            return name;
        }

        public int getDefense() {
            return defense;
        }

        public static void listArmors() {
            for (ArmorType at : ArmorType.values()) {
                System.out.println("You've found " + at.getCategory() +
                    " called \"" + at.getName() + "\" (Defense: " + at.getDefense() + ")");
            }
        }
    }

    private ArmorType armorType;

    public Armor(ArmorType armorType) {
        super(Item.ItemType.ARMOR, armorType.getName(), armorType.getDefense());
        this.armorType = armorType;
    }

    public ArmorType getArmorType() {
        return armorType;
    }

    public void setArmorType(ArmorType armorType) {
        this.armorType = armorType;
        this.setName(armorType.getName());
        this.setDamage(armorType.getDefense());
    }

    public String getCategory() {
        return armorType.getCategory();
    }
}
