public class BankPolimorfik {
    public static void main(String[] args) {
        // Tiga object, masing-masing di variabelnya sendiri
        Tabungan ani = new Tabungan("101", "Ani", 1000000, 2.5);
        Tabungan citra = new Tabungan("102", "Citra", 300000, 2.0);
        Giro budi = new Giro("201", "Budi", 200000, 500000);

        // Array 1: semua rekening. Array 2: hanya yang berbunga (Giro tidak masuk)
        Rekening[] semua = { ani, citra, budi };
        BerBunga[] berbunga = { ani, citra };

        // Langkah 8 (dicoba lalu dihapus):
        //Rekening r = new Rekening("999", "Eko", 0);
        // Error: Rekening is abstract; cannot be instantiated

        System.out.println("========== REKENING AWAL ==========");
        for (Rekening r : semua) {
            r.tampilkanInfo();
        }

        System.out.println();
        System.out.println("========== AKHIR BULAN ============");
        // Loop atas semua: potong biaya admin dulu
        for (Rekening r : semua) {
            int biaya = r.potongBiayaAdmin();
            System.out.println(r.getNomor() + " biaya admin  : " + Rekening.formatRupiah(biaya));
        }
        // Loop atas berbunga: baru tambah bunga
        for (BerBunga b : berbunga) {
            int bunga = b.tambahBunga();
            System.out.println(b.getNomor() + " bunga        : " + Rekening.formatRupiah(bunga));
        }

        System.out.println();
        System.out.println("========== REKENING AKHIR =========");
        int total = 0;
        for (Rekening r : semua) {
            r.tampilkanInfo();
            total += r.getSaldo();
        }
        System.out.println("----------------------------------");
        System.out.println("Total dana bank : " + Rekening.formatRupiah(total));
    }
}