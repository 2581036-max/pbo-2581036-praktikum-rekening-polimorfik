public abstract class Rekening {
    private String nomor;
    private String pemilik;
    protected int saldo;

    public Rekening(String nomor, String pemilik, int saldo) {
        this.nomor = nomor;
        this.pemilik = pemilik;
        this.saldo = saldo;
    }

    // Method abstract: setiap jenis rekening WAJIB menentukan biayanya sendiri
    public abstract int biayaAdminBulanan();

    // Method konkret: memakai method abstract di atas (polimorfisme)
    public int potongBiayaAdmin() {
        int biaya = biayaAdminBulanan();
        saldo -= biaya;
        return biaya;
    }

    public String getNomor() {
        return nomor;
    }

    public String getPemilik() {
        return pemilik;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setor(int jumlah) {
        if (jumlah > 0) {
            saldo += jumlah;
        }
    }

    // Dari Bab 10: tarik biasa (tidak boleh melebihi saldo)
    public boolean tarik(int jumlah) {
        if (jumlah > 0 && jumlah <= saldo) {
            saldo -= jumlah;
            return true;
        }
        return false;
    }

    // Mencetak baris pertama info rekening; subclass menambah baris kedua
    public void tampilkanInfo() {
        System.out.printf("%s | %-6s | %12s%n", nomor, pemilik, formatRupiah(saldo));
    }

    // Helper: 1000000 -> "Rp1.000.000"
    public static String formatRupiah(long angka) {
        String hasil = String.format(java.util.Locale.US, "%,d", Math.abs(angka)).replace(',', '.');
        return (angka < 0 ? "-Rp" : "Rp") + hasil;
    }
}