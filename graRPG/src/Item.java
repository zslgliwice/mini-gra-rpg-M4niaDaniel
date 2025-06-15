public class Item {
    public enum ItemType {
        WEAPON,
        ARMOR,
        FOOD
    }

    private ItemType itemType;
    private String name;
    private int damage;

    Item(ItemType itemType, String name, int damage) {
        this.itemType = itemType;
        this.name = name;
        this.damage = damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public String getName() {
        return name;
    }
}
