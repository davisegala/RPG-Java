package Entity;

import Itens.Item;
import java.util.ArrayList;

import NPC.Npc;
import UtilMethods.Input;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private ArrayList<Item> inventory = new ArrayList<>();
    private int coins = 0;
    private Input input = new Input();

    private ArrayList<Item> lastDisplayedItems = new ArrayList<>();

    private void print() {
        System.out.println("\n============= Inventory =============");
        Map<Item, Integer> count = getInventory();

        for (int i = 0; i < lastDisplayedItems.size(); i++) {
            Item item = lastDisplayedItems.get(i);

            int quantity = count.getOrDefault(item, 0);

            if (quantity > 0) {
                System.out.println("--> [" + (i + 1) + "] " + item.getName() + " - " + quantity + "x - " + item.display());
            }
        }
    }

    private void printNpc(Npc npc) {
        System.out.println("\n============= " + npc.getName() + " =============");
        Map<Item, Integer> count = getInventory();

        for (int i = 0; i < lastDisplayedItems.size(); i++) {
            Item item = lastDisplayedItems.get(i);

            int quantity = count.getOrDefault(item, 0);

            if (quantity > 0) {
                System.out.println("--> [" + (i + 1) + "] " + item.getPrice() + " " + item.getName() + " - " + quantity + "x - " + item.display());
            }
        }
    }

    public void openStore(Npc npc, Entity customer) {
        while (true) {
            System.out.println("\n============= Store =============");
            System.out.println("[1] Buy");
            System.out.println("[2] Sell");
            System.out.println("[0] Exit");

            int option = input.inputInt();

            switch (option) {
                case 1 -> buyItem(npc, customer);
                case 2 -> sellItem(customer);
                case 0 -> {
                    return;
                }
            }
        }
    }

    private void buyItem(Npc npc, Entity customer) {
        printNpc(npc);
        System.out.println("\n[0] Cancel");
        System.out.print("Select an item: ");

        int num = input.inputInt();
        if (num == 0) return;

        if (num > 0 && num <= lastDisplayedItems.size()) {
            Item item = lastDisplayedItems.get(num - 1);

            System.out.print("Quantity: ");

            int quantity = input.inputInt();
            int totalPrice = item.getPrice() * quantity;

            if (customer.getInventory().getCoins() >= totalPrice) {
                customer.getInventory().addItem(item, quantity);
                this.removeItem(item, quantity);

                customer.getInventory().setCoins(customer.getInventory().getCoins() - totalPrice);
                this.setCoins(this.getCoins() + totalPrice);

                System.out.println("Purchase completed!");
            } else {
                System.out.println("You don't have enough coins");
            }
        }
    }

    private void sellItem(Entity customer) {
        customer.getInventory().printSellPrices();

        System.out.println("\n[0] Cancel");
        System.out.print("Select an item: ");

        int num = input.inputInt();

        if (num == 0) return;

        if (num > 0 && num <= customer.getInventory().lastDisplayedItems.size()) {
            Item item = customer.getInventory().lastDisplayedItems.get(num - 1);

            System.out.print("Quantity: ");
            int quantity = input.inputInt();
            int sellPrice = (item.getPrice() / 2) * quantity;

            customer.getInventory().removeItem(item, quantity);
            this.addItem(item, quantity);

            customer.getInventory().setCoins(customer.getInventory().getCoins() + sellPrice);
            this.setCoins(this.getCoins() - sellPrice);

            System.out.println("Items sold!");
        }
    }

    public void printSellPrices() {
        System.out.println("\n============= Inventory =============");
        Map<Item, Integer> count = getInventory();

        for (int i = 0; i < lastDisplayedItems.size(); i++) {
            Item item = lastDisplayedItems.get(i);
            int quantity = count.getOrDefault(item, 0);

            if (quantity > 0) {
                int sellPrice = item.getPrice() / 2;
                System.out.println(
                        "--> [" + (i + 1) + "] "
                                + sellPrice + " coins - "
                                + item.getName()
                                + " - " + quantity + "x - "
                                + item.display()
                );
            }
        }
    }

    public void open(Entity target){
        print();

        System.out.println("\n[0] To end turn");
        System.out.print("\nSelect an item: ");

        int num = input.inputInt();
        if (num == 0) return;

        if (num > 0 && num <= lastDisplayedItems.size()){
            Item item = lastDisplayedItems.get(num - 1);

            if (item.getIsEquipment() && target.isPlayer()) {
                item.equip(target);
                this.inventory.remove(item);
            } else if (!item.getIsEquipment()){
                useItem(item, target);
            }
        } else {
            System.out.println("Invalid selection!");
        }
    }

    private Map<Item, Integer> getInventory() {
        Map<Item, Integer> count = new HashMap<>();
        lastDisplayedItems.clear();

        for (Item item : inventory) {
            if (!count.containsKey(item)) {
                lastDisplayedItems.add(item);
            }
            count.put(item, count.getOrDefault(item, 0) + 1);
        }

        return count;
    }

    public void addItem(Item item){
        this.inventory.add(item);
    }

    public void addItem(Item item, int quantity){
        for (int i = 0; i < quantity; i++) {
            this.inventory.add(item);
        }
    }

    public void removeItem(Item item){
        this.inventory.remove(item);
    }

    public void removeItem(Item item, int quantity){
        for (int i = 0; i < quantity; i++) {
            this.inventory.remove(item);
        }
    }

    public void useItem(Item item, Entity target){
        item.use(target);
        this.inventory.remove(item);
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }
}