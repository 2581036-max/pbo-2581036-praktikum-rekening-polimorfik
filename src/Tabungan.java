public class Tabungan extends Rekening implements BerBunga {
    private double bungaPersen;

    public Tabungan(String nomor, String pemilik, int saldo, double bungaPersen) {
        super(nomor, pemilik, saldo);
        this.bungaPersen = bungaPersen;
    }

    @Override
    public int biayaAdminBulanan() {
        // Gratis kalau saldo minimal 1.000.000, selain itu Rp5.000
        return saldo >= 1000000 ? 0 : 5000;
    }

    @Override
    public int tambahBunga() {
        int bunga = (int) Math.round(saldo * bungaPersen / 100);
        saldo += bunga;
        return bunga;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.printf("      Tabungan, bunga %.1f%% per bulan%n", bungaPersen);
    }
}