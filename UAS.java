package UAS_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UAS {
        public static void main(String[] args) {
            Inventory inventory = new Inventory();

            // Menambahkan item ke inventory
            inventory.addItem(new Item("Laptop"));
            inventory.addItem(new Item("Mouse"));
            inventory.addItem(new Item("Keyboard"));
            inventory.addItem(new Item("Monitor"));
            inventory.addItem(new Item("Headphones"));

            // Menampilkan inventory sebelum diurutkan
            System.out.println("Inventory sebelum diurutkan:");
            inventory.displayInventory();

            // Mengurutkan inventory berdasarkan nama menggunakan selection sort
            inventory.sortInventoryByName();

            // Menampilkan inventory setelah diurutkan
            System.out.println("\nInventory setelah diurutkan berdasarkan nama:");
            inventory.displayInventory();

            // Mencari barang berdasarkan "Nama Barang" melalui inputan pengguna
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nMasukkan nama barang yang ingin dicari: ");
            String keyword = scanner.nextLine();
            List<Item> searchResults = inventory.searchByName(keyword);
            System.out.println("\nHasil pencarian berdasarkan \"" + keyword + "\":");
            if (searchResults.isEmpty()) {
                System.out.println("Barang tidak ditemukan.");
            } else {
                for (Item item : searchResults) {
                    System.out.println(item);
                }
            }
        }
    }

    class Inventory {
        private List<Item> items;

        public Inventory() {
            items = new ArrayList<>();
        }

        public void addItem(Item item) {
            items.add(item);
        }

        public void displayInventory() {
            for (Item item : items) {
                System.out.println(item);
            }
        }

        public void sortInventoryByName() {
            int n = items.size();

            for (int i = 0; i < n - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < n; j++) {
                    if (items.get(j).getName().compareTo(items.get(minIndex).getName()) < 0) {
                        minIndex = j;
                    }
                }

                if (minIndex != i) {
                    swapItems(i, minIndex);
                }
            }
        }

        private void swapItems(int i, int j) {
            Item temp = items.get(i);
            items.set(i, items.get(j));
            items.set(j, temp);
        }

        public List<Item> searchByName(String keyword) {
            List<Item> searchResults = new ArrayList<>();

            for (Item item : items) {
                if (item.getName().toLowerCase().contains(keyword.toLowerCase())) {
                    searchResults.add(item);
                }
            }

            return searchResults;
        }
    }

    class Item {
        private String name;

        public Item(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
