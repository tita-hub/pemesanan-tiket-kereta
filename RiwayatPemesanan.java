public class RiwayatPemesanan {
    private String idPemesanan;
    private String tanggalPesan;
    private String namaKereta;
    private Penumpang penumpang;
    
    public RiwayatPemesanan(String idPemesanan, String tanggalPesan, String namaKereta) {
        this.idPemesanan = idPemesanan;
        this.tanggalPesan = tanggalPesan;
        this.namaKereta = namaKereta;
    }
    
    public void setPenumpang(Penumpang penumpang) {
        this.penumpang = penumpang;
    }
    
    public void menyajikanRiwayat() {
        System.out.println("Riwayat: ID Pemesanan=" + idPemesanan + ", Nama Penumpang=" + penumpang.getNama() + ", Tanggal Pesan=" + tanggalPesan + ", Kereta=" + namaKereta);
    }
}