import java.util.Date;

public class Pemesanan {
    private String id;
    private Date tanggalPesan;
    private String status;
    private Petugas petugas;
    private Jadwal jadwal;
    private Penumpang penumpang;
    
    public Pemesanan(String id, Petugas petugas, Jadwal jadwal, Penumpang penumpang) {
        this.id = id;
        this.petugas = petugas;
        this.jadwal = jadwal;
        this.penumpang = penumpang;
        this.tanggalPesan = new Date();
        this.status = "Berhasil";
        this.jadwal.getKereta().kurangiKursi();
    }
    
    public void pesanTiket(String idJadwal, String idPenumpang) {
        System.out.println("Pemesanan berhasil: ID=" + id + ", Penumpang=" + penumpang.getNama() + ", Kereta=" + jadwal.getKereta().getNamaKereta() + ", Petugas=" + petugas.getNama());
    }
    
    public void lihatData() {
        System.out.println("Data Pemesanan: ID=" + id + ", Tanggal Pesan=" + tanggalPesan + ", Status=" + status);
    }
}