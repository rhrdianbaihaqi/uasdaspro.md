package controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RestaurantController {
    private Map<String, Integer> menuHarga = new HashMap<>();
    private Map<String, Integer> pesanan = new HashMap<>();
    private int totalHarga = 0;

    public RestaurantController() {
        // Inisialisasi menu dan harga
        menuHarga.put("Nasi Goreng", 25000);
        menuHarga.put("Mie Goreng", 20000);
        menuHarga.put("Ayam Bakar", 35000);
    }

    public void userMenu(Scanner scanner) {
        int userChoice;
        do {
            System.out.println("=== Menu Pengguna ===");
            System.out.println("1. Lihat Menu");
            System.out.println("2. Pesan Menu");
            System.out.println("3. Lihat Pesanan");
            System.out.println("4. Cetak Struk");
            System.out.println("0. Keluar");

            System.out.print("Masukkan pilihan: ");
            userChoice = scanner.nextInt();
            scanner.nextLine(); // Consuming newline character

            switch (userChoice) {
                case 1:
                    lihatMenu();
                    break;
                case 2:
                    pesanMenu(scanner);
                    break;
                case 3:
                    lihatPesanan();
                    break;
                case 4:
                    cetakStruk();
                    break;
                case 0:
                    System.out.println("Keluar dari menu pengguna.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (userChoice != 0);
    }

    
    private void lihatMenu() {
        System.out.println("=== Menu Makanan ===");
        for (Map.Entry<String, Integer> entry : menuHarga.entrySet()) {
            System.out.println(entry.getKey() + "\tRp " + entry.getValue());
        }
    }

    private void pesanMenu(Scanner scanner) {
        System.out.print("Masukkan nama menu yang akan dipesan: ");
        String menuChoice = scanner.nextLine();

        if (menuHarga.containsKey(menuChoice)) {
            System.out.println("Harga " + menuChoice + " adalah Rp " + menuHarga.get(menuChoice));
            System.out.print("Masukkan jumlah yang akan dipesan: ");
            int jumlah = scanner.nextInt();
            scanner.nextLine(); // Consuming newline character

            int harga = menuHarga.get(menuChoice);
            pesanan.put(menuChoice, pesanan.getOrDefault(menuChoice, 0) + jumlah);
            totalHarga += harga * jumlah;

            System.out.println("Pesanan berhasil ditambahkan!");
        } else {
            System.out.println("Menu tidak valid. Silakan coba lagi.");
        }
    }

    private void lihatPesanan() {
        System.out.println("=== Daftar Pesanan ===");
        for (Map.Entry<String, Integer> entry : pesanan.entrySet()) {
            System.out.println(entry.getKey() + "\tJumlah: " + entry.getValue());
        }
        System.out.println("Total Harga: Rp " + totalHarga);
    }

    private void cetakStruk() {
        System.out.println("=== Struk Pembayaran ===");
        lihatPesanan();
        System.out.println("Terima kasih telah memesan!");
        pesanan.clear();
        totalHarga = 0;
    }
}
