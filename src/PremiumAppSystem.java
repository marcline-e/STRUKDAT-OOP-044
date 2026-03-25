import java.util.Scanner;

abstract class Produk {
    private String namaApp;
    private double harga;

    public Produk(String namaApp, double harga) {
        this.namaApp = namaApp;
        this.harga = harga;
    }

    public String getNamaApp() { return namaApp; }
    public double getHarga() { return harga; }

    public abstract void tampilkanDetail();
}

class Berlangganan extends Produk {
    private int durasiBulan;

    public Berlangganan(String namaApp, double harga, int durasiBulan) {
        super(namaApp, harga);
        this.durasiBulan = durasiBulan;
    }

    @Override
    public void tampilkanDetail() {
        System.out.println("Aplikasi: " + getNamaApp());
        System.out.println("Durasi: " + durasiBulan + " Bulan");
        System.out.println("Total Harga: Rp" + (getHarga() * durasiBulan));
    }
}

class Agen {
    private String namaAgen;

    public Agen(String namaAgen) {
        this.namaAgen = namaAgen;
    }

    public void prosesTransaksi(Produk produk) {
        System.out.println("\n--- Resi Transaksi Agen: " + namaAgen + " ---");
        produk.tampilkanDetail();
        System.out.println("Status: Pembayaran Berhasil!");
        System.out.println("--------------------------------------");
    }
}


public class PremiumAppSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Agen agenBaru = new Agen("Global Digital");

        System.out.println("=== Beli Aplikasi Premium ===");
        System.out.print("Masukkan Nama Aplikasi: ");
        String nama = input.nextLine();
        System.out.print("Harga per Bulan: ");
        double harga = input.nextDouble();
        System.out.print("Durasi (Bulan): ");
        int durasi = input.nextInt();

        // Objek Polimorfisme: Tipe Produk, Instansiasi Berlangganan
        Produk pembelian = new Berlangganan(nama, harga, durasi);
        
        agenBaru.prosesTransaksi(pembelian);
    }
}