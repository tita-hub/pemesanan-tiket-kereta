import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AplikasiPemesananTiket app = new AplikasiPemesananTiket();
        
        // Inisialisasi data
        app.inisialisasiData();
        
        // Login
        boolean loginSuccess = false;
        while (!loginSuccess) {
            System.out.println("Login Aplikasi");
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
            
            if (app.loginPetugas(username, password)) {
                loginSuccess = true;
                System.out.println("Login berhasil!");
            } else {
                System.out.println("Username atau password salah. Coba lagi.");
            }
        }
        
        // Tampil Menu Utama
        boolean running = true;
        while (running) {
            System.out.println("\nMenu Aplikasi");
            System.out.println("1. Petugas");
            System.out.println("2. Kereta");
            System.out.println("3. Penumpang");
            System.out.println("4. Jadwal");
            System.out.println("5. Pemesanan");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();
            
            switch (pilihan) {
                case 1:
                    app.mengelolaPetugas(scanner);
                    break;
                case 2:
                    app.mengelolaKereta(scanner);
                    break;
                case 3:
                    app.mengelolaPenumpang(scanner);
                    break;
                case 4:
                    app.mengelolaJadwal(scanner);
                    break;
                case 5:
                    app.mengelolaPemesanan(scanner);
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
        scanner.close();
    }
}