import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class AplikasiPemesananTiket {
    private ArrayList<Petugas> daftarPetugas = new ArrayList<>();
    private ArrayList<Penumpang> daftarPenumpang = new ArrayList<>();
    private ArrayList<Kereta> daftarKereta = new ArrayList<>();
    private ArrayList<Jadwal> daftarJadwal = new ArrayList<>();
    private ArrayList<Pemesanan> daftarPemesanan = new ArrayList<>();
    private Petugas petugasAktif;
    
    public void inisialisasiData() {
        // Data dummy
        daftarPetugas.add(new Petugas("P1", "Admin", "admin", "pass"));
        daftarPenumpang.add(new Penumpang("PNP1", "Tita", "3201011234567890", "081298765432"));
        daftarKereta.add(new Kereta("K1", "Argo Bromo Anggrek", "Eksekutif", 50));
        daftarJadwal.add(new Jadwal("JDW1", daftarKereta.get(0), "Bandung", "Jakarta", "2025-10-19", "06:00", 150000));
    }
    
    public boolean loginPetugas(String username, String password) {
        for (Petugas petugas : daftarPetugas) {
            if (petugas.login(username, password)) {
                petugasAktif = petugas;
                return true;
            }
        }
        return false;
    }
    
    public void mengelolaPetugas(Scanner scanner) {
        System.out.println("Opsi: 1. Tambah Data 2. Lihat Data");
        int opsi = scanner.nextInt();
        scanner.nextLine();
        
        if (opsi == 1) {
            System.out.print("ID: ");
            String id = scanner.nextLine();
            System.out.print("Nama: ");
            String nama = scanner.nextLine();
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
            
            Petugas petugas = new Petugas(id, nama, username, password);
            daftarPetugas.add(petugas);
            petugas.tambahData(scanner);
        } else if (opsi == 2) {
            for (Petugas petugas : daftarPetugas) {
                petugas.lihatData();
            }
        }
    }
    
    public void mengelolaKereta(Scanner scanner) {
        System.out.println("Opsi: 1. Tambah Data 2. Lihat Data");
        int opsi = scanner.nextInt();
        scanner.nextLine();
        
        if (opsi == 1) {
            System.out.print("ID: ");
            String id = scanner.nextLine();
            System.out.print("Nama Kereta: ");
            String namaKereta = scanner.nextLine();
            System.out.print("Kelas: ");
            String kelas = scanner.nextLine();
            System.out.print("Kapasitas Kursi: ");
            int kapasitas = scanner.nextInt();
            
            Kereta kereta = new Kereta(id, namaKereta, kelas, kapasitas);
            daftarKereta.add(kereta);
            kereta.tambahData(scanner);
        } else if (opsi == 2) {
            for (Kereta kereta : daftarKereta) {
                kereta.lihatData();
            }
        }
    }
    
    public void mengelolaPenumpang(Scanner scanner) {
        System.out.println("Opsi: 1. Tambah Data 2. Lihat Data 3. Lihat Riwayat");
        int opsi = scanner.nextInt();
        scanner.nextLine();
        
        if (opsi == 1) {
            System.out.print("ID: ");
            String id = scanner.nextLine();
            System.out.print("Nama: ");
            String nama = scanner.nextLine();
            System.out.print("NIK: ");
            String nik = scanner.nextLine();
            System.out.print("No Telepon: ");
            String noTelepon = scanner.nextLine();
            
            Penumpang penumpang = new Penumpang(id, nama, nik, noTelepon);
            daftarPenumpang.add(penumpang);
            penumpang.tambahData(scanner);
        } else if (opsi == 2) {
            for (Penumpang penumpang : daftarPenumpang) {
                penumpang.lihatData();
            }
        } else if (opsi == 3) {
            System.out.print("ID Penumpang: ");
            String idPnp = scanner.nextLine();
            for (Penumpang pnp : daftarPenumpang) {
                if (pnp.getId().equals(idPnp)) {
                    pnp.lihatRiwayat();
                    break;
                }
            }
        }
    }
    
    public void mengelolaJadwal(Scanner scanner) {
        System.out.println("Opsi: 1. Tambah Data 2. Lihat Data");
        int opsi = scanner.nextInt();
        scanner.nextLine();
        
        if (opsi == 1) {
            System.out.print("ID Jadwal: ");
            String id = scanner.nextLine();
            System.out.print("ID Kereta: ");
            String idKereta = scanner.nextLine();
            
            Kereta selectedKereta = null;
            for (Kereta kereta : daftarKereta) {
                if (kereta.getId().equals(idKereta)) {
                    selectedKereta = kereta;
                    break;
                }
            }
            
            if (selectedKereta != null) {
                System.out.print("Stasiun Asal: ");
                String stasiunAsal = scanner.nextLine();
                System.out.print("Stasiun Tujuan: ");
                String stasiunTujuan = scanner.nextLine();
                System.out.print("Tanggal Keberangkatan (YYYY-MM-DD): ");
                String tanggal = scanner.nextLine();
                System.out.print("Jam Keberangkatan: ");
                String jam = scanner.nextLine();
                System.out.print("Harga: ");
                double harga = scanner.nextDouble();
                
                Jadwal jadwal = new Jadwal(id, selectedKereta, stasiunAsal, stasiunTujuan, tanggal, jam, harga);
                daftarJadwal.add(jadwal);
                jadwal.tambahData(scanner);
            } else {
                System.out.println("Kereta tidak ditemukan.");
            }
        } else if (opsi == 2) {
            for (Jadwal jadwal : daftarJadwal) {
                jadwal.lihatData();
            }
        }
    }
    
    public void mengelolaPemesanan(Scanner scanner) {
        System.out.println("Opsi: 1. Pesan Tiket 2. Lihat Data");
        int opsi = scanner.nextInt();
        scanner.nextLine();
        
        if (opsi == 1) {
            System.out.print("ID Jadwal: ");
            String idJadwal = scanner.nextLine();
            System.out.print("ID Penumpang: ");
            String idPenumpang = scanner.nextLine();
            
            Jadwal selectedJadwal = null;
            for (Jadwal jadwal : daftarJadwal) {
                if (jadwal.getId().equals(idJadwal) && jadwal.getKereta().getKursiTersedia() > 0) {
                    selectedJadwal = jadwal;
                    break;
                }
            }
            
            Penumpang selectedPnp = null;
            for (Penumpang pnp : daftarPenumpang) {
                if (pnp.getId().equals(idPenumpang)) {
                    selectedPnp = pnp;
                    break;
                }
            }
            
            if (selectedJadwal != null && selectedPnp != null) {
                String idPesan = "TIK" + (daftarPemesanan.size() + 1);
                Pemesanan pemesanan = new Pemesanan(idPesan, petugasAktif, selectedJadwal, selectedPnp);
                daftarPemesanan.add(pemesanan);
                
                // Catat riwayat
                RiwayatPemesanan riwayat = new RiwayatPemesanan(idPesan, LocalDate.now().toString(), selectedJadwal.getKereta().getNamaKereta());
                selectedPnp.tambahRiwayat(riwayat);
                
                pemesanan.pesanTiket(idJadwal, idPenumpang);
            } else {
                System.out.println("Jadwal tidak tersedia atau Penumpang tidak ditemukan.");
            }
        } else if (opsi == 2) {
            for (Pemesanan pesan : daftarPemesanan) {
                pesan.lihatData();
            }
        }
    }
}