import java.util.Random;
import java.util.Scanner;

public class Event {
    public enum EventType {
        ENEMY,
        TREASURE,
        CAMP,
        THE_END
    }

    private EventType eventType;
    private Random rand = new Random();

    public Event(EventType eventType) {
        this.eventType = eventType;
    }

    public EventType getEventType() {
        return eventType;
    }

    public boolean startEvent(Player player, Scanner scanner) {
        switch (eventType) {
            case ENEMY:
                Enemy.Race[] enemyRaces = Enemy.Race.values();
                Enemy enemy = new Enemy(rand.nextInt(11) + 5, rand.nextInt(11) + 20,
                        enemyRaces[rand.nextInt(enemyRaces.length)]);
                int maxHP = enemy.getHp();
                System.out.println("You have encountered a " + enemy.getRace().getDisplayName() +
                        " with " + enemy.getHp() + " HP and " + enemy.getDmg()
                        + " strength. FIGHT OR FLIGHT (fight/run)");

                while (enemy.getHp() > 0) {
                    System.out.print("> ");
                    String inputE = scanner.nextLine().trim();

                    if (inputE.equalsIgnoreCase("fight")) {
                        System.out.println(player.getDamage());
                        int damage = rand.nextInt(player.getDamage()  / 2) + player.getDamage() / 2;
                        enemy.setHp(enemy.getHp() - damage);
                        System.out.println(
                                "You hit the " + enemy.getRace().getDisplayName() + " for " + damage + " damage.");
                        if (enemy.getHp() <= 0) {
                            System.out.println("You've killed the " + enemy.getRace().getDisplayName());
                            return true;
                        }

                        player.setHp(player.getHp() - rand.nextInt(enemy.getDmg()));
                        System.out.println("You've suffered " + (enemy.getDmg() / 2) + " damage fighting.");
                        System.out.println(
                                "Your Health: " + player.getHp() + "% Enemy health: " + enemy.getHp() * 100 / maxHP
                                        + "%");

                        if (player.getHp() <= 0) {
                            System.out.println("You have been defeated!");
                            return false;
                        }

                    } else if (inputE.equalsIgnoreCase("run")) {
                        if (rand.nextInt(2) != 0) {
                            player.setHp(player.getHp() - enemy.getDmg());
                            System.out.println("You've suffered " + enemy.getDmg() + " damage while running away.");
                                                                                                                    
                            if (player.getHp() <= 0) {
                                System.out.println("You have been defeated!");
                                return false;
                            }
                        } else {
                            System.out.println("You've successfully escaped!");
                            return true;
                        }
                    } else {
                        System.out.println("Invalid choice! Please type 'fight' or 'run'.");
                    }
                }
                return true;

            case TREASURE:
                System.out.println("It's your lucky day, you've found a treasure!");
                switch (rand.nextInt(3)) {
                    case 0:
                        System.out.println("Oh, the treasure was empty");
                        return true;
                    case 1:
                        int gold = rand.nextInt(11) + 5;
                        player.setGold(player.getGold() + gold);
                        System.out.println("You've found " + gold + " gold!");
                        return true;
                    case 2:
                        System.out.println("It's a trap!");
                        int damage = rand.nextInt(11) + 5;
                        player.setHp(player.getHp() - damage);
                        System.out.println("You've suffered " + damage + " damage from the trap.");
                        if (player.getHp() <= 0) {
                            System.out.println("You have been defeated!");
                            return false;
                        }
                        return true;
                    case 3:
                        System.out.println("You've found an item!");
                        Item.ItemType[] itemTypes = Item.ItemType.values();
                        Item.ItemType itemType = itemTypes[rand.nextInt(itemTypes.length)];
                        switch (itemType) {
                            case WEAPON:
                                System.out.println("You've found a weapon!");
                                Weapon.WeaponType[] weaponTypes = Weapon.WeaponType.values();
                                Weapon.WeaponType weaponType = weaponTypes[rand.nextInt(weaponTypes.length)];

                                Weapon weapon = new Weapon(weaponType);
                                player.setMultiplier(weapon.weaponType.getDamage());
                                return true;
                            case ARMOR:
                                System.out.println("You've found an armor!");
                                Armor.ArmorType[] armorTypes = Armor.ArmorType.values();
                                Armor.ArmorType armorType = armorTypes[rand.nextInt(armorTypes.length)];
                                Armor armor = new Armor(armorType);
                                player.setMaxHp(player.getMaxHp() + armor.getDamage());
                                return true;
                            case FOOD:
                                System.out.println("You've found some food!");
                                int hp = rand.nextInt(11) + 5;
                                player.setHp(player.getHp() + hp);
                                System.out.println("You've restored " + hp + " health.");
                                return true;
                            default:
                                return true;
                        }
                    default:
                        return true;
                }
            case CAMP:
                int price = rand.nextInt(4) + 3;

                while (true) {
                    System.out.println(
                            "You have arrived at a Camp, would you like to rest for " + price + " gold? (y/n)");
                    System.out.print("> ");
                    String inputC = scanner.nextLine().trim();

                    if (inputC.equalsIgnoreCase("y")) {
                        if (player.getGold() < price) {
                            System.out.println("You don't have enough gold!");
                        } else {
                            int hp = rand.nextInt(11) + 20;
                            player.setGold(player.getGold() - price);
                            player.setHp(player.getHp() + hp);
                            System.out.println("You have slept and restored " + hp + " health");
                            return true;
                        }
                    } else if (inputC.equalsIgnoreCase("n")) {
                        return true;
                    } else {
                        System.out.println("Invalid choice! Please type 'y' or 'n'.");
                    }
                }

            case THE_END:
                System.out.println("Congratulations! You've found your way out the Forest!");
                return false;

            default:
                return true;
        }
    }

    public static EventType randomType() {
        int enemyWeight = 35;
        int treasureWeight = 30;
        int campWeight = 30;
        int endWeight = 5;

        int totalWeight = enemyWeight + treasureWeight + campWeight + endWeight;
        int randomNum = new Random().nextInt(totalWeight);

        if (randomNum < enemyWeight) {
            return EventType.ENEMY;
        } else if (randomNum < enemyWeight + treasureWeight) {
            return EventType.TREASURE;
        } else if (randomNum < enemyWeight + treasureWeight + campWeight) {
            return EventType.CAMP;
        } else {
            return EventType.THE_END;
        }
    }
}
