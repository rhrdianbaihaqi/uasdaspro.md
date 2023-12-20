import java.util.Scanner;


import controller.RestaurantController;

public class RestaurantApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RestaurantController restaurantController = new RestaurantController();

        // Logika untuk login admin atau user (belum diimplementasikan sepenuhnya)
        // Untuk sementara, kita langsung menuju ke menu user
        restaurantController.userMenu(scanner);

        // Tutup scanner setelah selesai
        scanner.close();
    }
}
