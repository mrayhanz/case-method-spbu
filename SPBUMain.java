import java.util.Scanner;

public class SPBUMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        methodSPBU spbu = new methodSPBU(5);
        int pilihan;

        do {
            System.out.println("--- Menu SPBU ---");
            System.out.println("1. Tambah Antrian Kendaraan");
            System.out.println("2. Tampilkan Antrian");
            System.out.println("3. Cek Jumlah Antrian Kendaraan");
            System.out.println("4. Layani Kendaraan");
            System.out.println("5. Tampilkan Riwayat Transaksi");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilihan = sc.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Plat Nomor Kendaraan: ");
                    String platNomor = sc.next();
                    System.out.print("Masukkan Tipe Kendaraan: ");
                    String tipe = sc.next();
                    System.out.print("Masukkan Merk Kendaraan: ");
                    String merk = sc.next();
                    kendaraan kendaraanInput = new kendaraan(platNomor, tipe, merk);
                    spbu.tambahAntrian(kendaraanInput);
                    break;
            
                case 2:
                    spbu.tampilkanAntrian();
                    break;
                case 3:
                    int jumlahAntrian = spbu.getJumlahAntrian();
                    System.out.println(">> Jumlah kendaraan dalam antrian: " + jumlahAntrian);
                    break;
                case 4:
                    methodSPBU dilayani = spbu;
                    if (dilayani != null) {
                        System.out.println("Petugas Melayani " + dilayani.dataAntrian[dilayani.frontAntrian].platNomor);
                        System.out.print("Masukkan Jenis BBM: ");
                        String jenisBBM = sc.next();
                        System.out.println("Masukkan Harga per Liter: ");
                        double hargaPerLiter = sc.nextDouble();
                        System.out.print("Masukkan Jumlah Liter: ");
                        double liter = sc.nextDouble();
                        BBM bbm = new BBM(jenisBBM, hargaPerLiter);
                        dilayani.melayani(bbm, liter);
                        System.out.println(">> Transaksi Berhasil dicatat.");
                    }
                    break;
                case 5:
                    spbu.riwayatTransaksi();
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        } while (pilihan != 0);
    }
}
