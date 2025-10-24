import java.util.Scanner;

public class Jadwal {
    private String id;
    private Kereta kereta;
    private String stasiunAsal;
    private String stasiunTujuan;
    private String tanggalKeberangkatan;
    private String jamKeberangkatan;
    private double harga;
    
    public Jadwal(String id, Kereta kereta, String stasiunAsal, String stasiunTujuan, String tanggalKeberangkatan, String jamKeberangkatan, double harga) {
        this.id = id;
        this.kereta = kereta;
        this.stasiunAsal = stasiunAsal;
        this.stasiunTujuan = stasiunTujuan;
        this.tanggalKeberangkatan = tanggalKeberangkatan;
        this.jamKeberangkatan = jamKeberangkatan;
        this.harga = harga;
    }
    
    public String getId() {
        return id;
    }
    
    public Kereta getKereta() {
        return kereta;
    }
    
    public void tambahData(Scanner scanner) {
        System.out.println("Tambah data Jadwal: ID=" + id + ", Kereta=" + kereta.getNamaKereta() + ", Rute=" + stasiunAsal + "-" + stasiunTujuan);
    }
    
    public void lihatData() {
        System.out.println("Data Jadwal: ID=" + id + ", Kereta=" + kereta.getNamaKereta() + ", Rute=" + stasiunAsal + "-" + stasiunTujuan + ", Tanggal=" + tanggalKeberangkatan + ", Jam=" + jamKeberangkatan + ", Harga=" + harga);
    }
}