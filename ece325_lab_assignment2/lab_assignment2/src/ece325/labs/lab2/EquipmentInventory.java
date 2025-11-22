package ece325.labs.lab2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Keeps track of all the equipment in your inventory.
 * Stores each equipment object and counts how many of each type exist.
 */
public class EquipmentInventory {

    /** List of all equipment objects in the inventory */
    ArrayList<Equipment> inventory;

    /** Counts how many objects of each type exist (type name -> count) */
    HashMap<String, Integer> inventoryCount;

    /** 
     * Constructor: initializes the inventory list and inventoryCount map.
     */
    public EquipmentInventory() {
        inventory = new ArrayList<>();
        inventoryCount = new HashMap<>();
    }

    /**
     * Adds a piece of equipment to the inventory.
     * If the object is already in the inventory, it is not added again.
     * Updates the count of that equipment type in inventoryCount.
     * @param e Equipment to add
     */
    public void add(Equipment e) {
        if (!inventory.contains(e)) {
            inventory.add(e);           // Add the object to the list
            increaseInventoryCount(e);  // Update the count in the map
        }
        // If already in inventory, do nothing
    }

    /**
     * Removes a piece of equipment from the inventory.
     * Updates the count of that equipment type in inventoryCount.
     * Does nothing if the object is not in the inventory.
     * @param e Equipment to remove
     */
    public void remove(Equipment e) {
        if (inventory.contains(e)) {
            inventory.remove(e);        // Remove from the list
            decreaseInventoryCount(e);  // Update the count in the map
        }
    }

    /**
     * Increases the count for the given equipment type by 1.
     * If the type does not exist yet, adds it to the map with count 1.
     * This method is protected to allow unit tests.
     * @param e Equipment whose type count to increase
     */
    protected void increaseInventoryCount(Equipment e) {
        String type = e.toString();

        if (inventoryCount.containsKey(type)) {
            inventoryCount.put(type, inventoryCount.get(type) + 1);
        } else {
            inventoryCount.put(type, 1);
        }
    }

    /**
     * Decreases the count for the given equipment type by 1.
     * If the count reaches 0, removes the type from the map.
     * Does nothing if the type does not exist in the map.
     * This method is protected to allow unit tests.
     * @param e Equipment whose type count to decrease
     */
    protected void decreaseInventoryCount(Equipment e) {
        String type = e.toString();

        if (inventoryCount.containsKey(type)) {
            int count = inventoryCount.get(type) - 1;

            if (count <= 0) {
                inventoryCount.remove(type); // Remove if count reaches 0
            } else {
                inventoryCount.put(type, count); // Update count
            }
        }
    }

    /**
     * Returns how many times a type of equipment exists in the inventory.
     * Returns -1 if the type is not found.
     * @param e Equipment to check
     * @return Count of this equipment type, or -1 if not found
     */
    public Integer getInventoryCount(Equipment e) {
        String type = e.toString();

        if (inventoryCount.containsKey(type)) {
            return inventoryCount.get(type);
        } else {
            return -1;
        }
    }

    /**
     * Returns a String representing the inventory.
     * Format: [EquipmentInventory: Type1: count1, Type2: count2, ...]
     * The order of types may vary.
     * @return String representation of the inventory
     */
    @Override
    public String toString() {
        String inventoryStr = "";
        boolean first = true;

        for (Map.Entry<String, Integer> entry : inventoryCount.entrySet()) {
            if (!first) {
                inventoryStr += ", ";
            }
            inventoryStr += entry.getKey() + ": " + entry.getValue();
            first = false;
        }

        return "[EquipmentInventory: " + inventoryStr + "]";
    }

    /** 
     * Test run: adds and removes equipment, then prints the inventory.
     */
    public static void main(String[] args) {
        Keyboard k1 = new Keyboard();
        Keyboard k2 = new Keyboard();
        Stool s1 = new Stool();
        Stool s2 = new Stool();
        Stool s3 = new Stool();
        Chair c1 = new Chair();
        Guitar g1 = new Guitar();
        Guitar g2 = new Guitar();
        Guitar g3 = new Guitar();

        EquipmentInventory myInventory = new EquipmentInventory();
        myInventory.add(g1);
        myInventory.add(g2);
        myInventory.add(g3);
        myInventory.add(k1);
        myInventory.add(k2);
        myInventory.add(s1);
        myInventory.add(s2);
        myInventory.add(s3);
        myInventory.add(c1);

        System.out.println(myInventory);

        // Remove one keyboard and one stool
        myInventory.remove(k1);
        myInventory.remove(s1);

        System.out.println(myInventory);
    }
}
