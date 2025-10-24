import java.util.Scanner;

public class Kereta {
    private String id;
    private String namaKereta;
    private String kelas;
    private int kapasitasKursi;
    private int kursiTersedia;
    
    public Kereta(String id, String namaKereta, String kelas, int kapasitasKursi) {
        this.id = id;
        this.namaKereta = namaKereta;
        this.kelas = kelas;
        this.kapasitasKursi = kapasitasKursi;
        this.kursiTersedia = kapasitasKursi;
    }
    
    public String getId() {
        return id;
    }
    
    public String getNamaKereta() {
        return namaKereta;
    }
    
    public int getKursiTersedia() {
        return kursiTersedia;
    }
    
    public void kurangiKursi() {
        if (kursiTersedia > 0) kursiTersedia--;
    }
    
    public void tambahData(Scanner scanner) {
        System.out.println("Tambah data Kereta: ID=" + id + ", Nama=" + namaKereta + ", Kelas=" + kelas + ", Kapasitas=" + kapasitasKursi);
    }
    
    public void lihatData() {
        System.out.println("Data Kereta: ID=" + id + ", Nama=" + namaKereta + ", Kelas=" + kelas + ", Kapasitas=" + kapasitasKursi + ", Kursi Tersedia=" + kursiTersedia);
    }
}