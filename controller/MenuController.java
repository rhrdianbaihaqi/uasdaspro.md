package controller;

import model.Menu;

import java.util.ArrayList;

public class MenuController {
    private ArrayList<Menu> menuList;

    public MenuController(ArrayList<Menu> menuList) {
        this.menuList = menuList;
    }

    public static ArrayList<Menu> initMenu() {
        ArrayList<Menu> menuList = new ArrayList<>();
        menuList.add(new Menu("Bakso Malang", 25000));
        menuList.add(new Menu("Mie Kocok Bandung", 20000));
        menuList.add(new Menu("Bebek Bakar Madura", 25000));
        menuList.add(new Menu("Nasi Pecel Madiun", 15000));
        menuList.add(new Menu("Sate Sapi Padang", 35000));
        menuList.add(new Menu("Gudeg Jogjakarta", 20000));
        return menuList;
    }

    public void displayMenu() {
        System.out.println("\n==== Daftar Menu ====");
        System.out.printf("%-5s%-20s%-10s\n", "No", "Nama Menu", "Harga");
        for (int i = 0; i < menuList.size(); i++) {
            Menu menu = menuList.get(i);
            System.out.printf("%-5s%-20sRp%-10s\n", (i + 1), menu.getName(), menu.getPrice());
        }
    }

    public Menu getMenu(int menuNumber) {
        if (menuNumber >= 1 && menuNumber <= menuList.size()) {
            return menuList.get(menuNumber - 1);
        } else {
            System.out.println("Nomor menu tidak valid.");
            return null;
        }
    }

    public ArrayList<Menu> getMenuList() {
        return menuList;
    }
}
