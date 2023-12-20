import java.util.Scanner;
import controller.MenuController;
import controller.OrderController;
import model.Menu;

public class RestaurantApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inisialisasi menu
        MenuController menuController = new MenuController(MenuController.initMenu());
        OrderController orderController = new OrderController(menuController.getMenuList());

        // Ucapan Menu
        System.out.print("\n===SELAMAT DATANG DI RESTOERAN NOESANTARA== ");

        // Pilih peran (admin/user)
        System.out.print("Masukkan login sebagai (admin/user): ");
        String role = scanner.nextLine();

        if (role.equalsIgnoreCase("admin")) {
            adminLogin(scanner, menuController);
        } else if (role.equalsIgnoreCase("user")) {
            userLogin(menuController, orderController, scanner);
        } else {
            System.out.println("Login tidak valid.");
        }

        scanner.close();
    }

    public static void adminLogin(Scanner scanner, MenuController menuController) {
        System.out.print("Masukkan username: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        // Proses autentikasi admin (dengan username dan password sederhana)
        if (username.equals("admin") && password.equals("admin123")) {
            adminMenu(menuController, scanner);
        } else {
            System.out.println("Autentikasi gagal. login tidak valid.");
        }
    }

    public static void adminMenu(MenuController menuController, Scanner scanner) {
        int choice;
        do {
            System.out.println("\n=== Selamat Datang, Admin ===");
            System.out.println("1. Lihat Menu");
            System.out.println("2. Tambah Menu");
            System.out.println("3. Hapus Menu");
            System.out.println("0. Keluar");

            System.out.print("Masukkan pilihan: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consuming newline character

            switch (choice) {
                case 1:
                    menuController.displayMenu();
                    break;
                case 2:
                    // Tambahkan logika untuk menambah menu (bisa menggunakan menuController)
                    break;
                case 3:
                    // Tambahkan logika untuk menghapus menu (bisa menggunakan menuController)
                    break;
                case 0:
                    System.out.println("Terima kasih, Admin.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (choice != 0);
    }

    public static void userLogin(MenuController menuController, OrderController orderController, Scanner scanner) {
        System.out.print("Masukkan nama Anda: ");
        String customerName = scanner.nextLine();

        int userChoice;
        do {
            System.out.println("\n=== Selamat Datang, " + customerName + " ===");
            System.out.println("1. Lihat Menu");
            System.out.println("2. Pesan Menu");
            System.out.println("3. Lihat Pesanan");
            System.out.println("4. Lihat Total Harga");
            System.out.println("5. Cetak Struk");
            System.out.println("0. Keluar");

            System.out.print("Masukkan pilihan: ");
            userChoice = scanner.nextInt();
            scanner.nextLine(); // Consuming newline character

            switch (userChoice) {
                case 1:
                    menuController.displayMenu();
                    break;
                case 2:
                    placeOrder(customerName, menuController, orderController, scanner);
                    break;
                case 3:
                    orderController.displayOrders(customerName);
                    break;
                case 4:
                    displayTotalOrderPrice(customerName, orderController);
                    break;
                case 5:
                    orderController.printReceipt(customerName);
                    break;
                case 0:
                    System.out.println("Terima kasih, " + customerName + ".");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (userChoice != 0);
    }

    public static void placeOrder(String customerName, MenuController menuController,
                                  OrderController orderController, Scanner scanner) {
        // Tampilkan menu
        menuController.displayMenu();

        // Pilih menu
        System.out.print("Masukkan nomor menu yang ingin dipesan: ");
        int menuNumber = scanner.nextInt();
        scanner.nextLine(); // Consuming newline character

        // Pilih jumlah
        System.out.print("Masukkan jumlah pesanan: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consuming newline character

        // Proses pemesanan
        orderController.placeOrder(customerName, menuNumber, quantity);
    }

    public static void displayTotalOrderPrice(String customerName, OrderController orderController) {
        int total = orderController.getTotalOrderPrice(customerName);
        System.out.println("Total harga pesanan untuk " + customerName + ": Rp " + total);
    }
}
