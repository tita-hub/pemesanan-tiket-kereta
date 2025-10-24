import java.util.ArrayList;
import java.util.Scanner;

public class Penumpang extends Pengguna {
    private String nik;
    private String noTelepon;
    private ArrayList<RiwayatPemesanan> daftarRiwayatPemesanan = new ArrayList<>();
    
    public Penumpang(String id, String nama, String nik, String noTelepon) {
        super(id, nama);
        this.nik = nik;
        this.noTelepon = noTelepon;
    }
    
    public String getNik() {
        return nik;
    }
    
    public void tambahRiwayat(RiwayatPemesanan riwayat) {
        daftarRiwayatPemesanan.add(riwayat);
        riwayat.setPenumpang(this);
    }
    
    public void lihatRiwayat() {
        System.out.println("Riwayat Pemesanan untuk Penumpang " + nama + ":");
        for (RiwayatPemesanan riwayat : daftarRiwayatPemesanan) {
            riwayat.menyajikanRiwayat();
        }
    }
    
    @Override
    public void tambahData(Scanner scanner) {
        System.out.println("Tambah data Penumpang: ID=" + id + ", Nama=" + nama + ", NIK=" + nik);
    }
    
    @Override
    public void lihatData() {
        System.out.println("Data Penumpang: ID=" + id + ", Nama=" + nama + ", NIK=" + nik + ", Telepon=" + noTelepon);
    }
}