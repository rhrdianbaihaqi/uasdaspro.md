// File: controller/OrderController.java
package controller;

import model.Menu;
import model.Order;

import java.util.ArrayList;

public class OrderController {
    private ArrayList<Menu> menuList;
    private ArrayList<Order> orders;

    public OrderController(ArrayList<Menu> menuList) {
        this.menuList = menuList;
        this.orders = new ArrayList<>();
    }

    public void displayOrders(String customerName) {
        System.out.println("\n==== Daftar Pesanan ====");
        System.out.printf("%-20s%-10s%-15s\n", "Nama Menu", "Jumlah", "Total Harga");
        for (Order order : orders) {
            if (order.getCustomerName().equals(customerName)) {
                System.out.printf("%-20s%-10sRp%-15s\n",
                        order.getMenuName(), order.getQuantity(), order.getTotalPrice());
            }
        }
    }

    public void placeOrder(String customerName, int menuNumber, int quantity) {
        Menu selectedMenu = menuList.get(menuNumber - 1);
        Order order = new Order(customerName, selectedMenu.getName(), quantity, selectedMenu.getPrice());
        orders.add(order);
        System.out.println("Pesanan berhasil ditambahkan.");
    }

    public int getTotalOrderPrice(String customerName) {
        int total = 0;
        for (Order order : orders) {
            if (order.getCustomerName().equals(customerName)) {
                total += order.getTotalPrice();
            }
        }
        return total;
    }

    public void printReceipt(String customerName) {
        System.out.println("\n==== Struk Pembayaran ====");
        System.out.printf("%-20s%-10s%-15s\n", "Nama Menu", "Jumlah", "Total Harga");
        for (Order order : orders) {
            if (order.getCustomerName().equals(customerName)) {
                System.out.printf("%-20s%-10sRp%-15s\n",
                        order.getMenuName(), order.getQuantity(), order.getTotalPrice());
            }
        }
        System.out.println("Total Pembelian: Rp " + getTotalOrderPrice(customerName));
        System.out.println("=========================");
    }
}
