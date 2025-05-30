import java.util.Scanner;

public class SPBUMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        methodSPBU spbu = new methodSPBU(5);
        int pilihan;

        do {
            System.out.println("\n--- Menu SPBU ---");
            System.out.println("1. Tambah Antrian Kendaraan");
            System.out.println("2. Tampilkan Antrian");
            System.out.println("3. Cek Jumlah Antrian Kendaraan");
            System.out.println("4. Layani Kendaraan");
            System.out.println("5. Tampilkan Riwayat Transaksi");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Plat Nomor Kendaraan: ");
                    String platNomor = sc.nextLine();
                    System.out.print("Masukkan Tipe Kendaraan: ");
                    String tipe = sc.nextLine();
                    System.out.print("Masukkan Merk Kendaraan: ");
                    String merk = sc.nextLine();
                    kendaraan kendaraanInput = new kendaraan(platNomor, tipe, merk);
                    spbu.tambahAntrian(kendaraanInput);
                    break;
            
                case 2:
                    System.out.println("--- Antrian kendaraan ---");
                    spbu.tampilkanAntrian();
                    break;
                case 3:
                    int jumlahAntrian = spbu.getJumlahAntrian();
                    System.out.println(">> Jumlah kendaraan dalam antrian: " + jumlahAntrian);
                    break;
                case 4:
                        System.out.println("Petugas Melayani " + spbu.dataAntrian[spbu.frontAntrian].platNomor);
                        System.out.print("Masukkan Jenis BBM: ");
                        String jenisBBM = sc.nextLine();
                        System.out.println("Masukkan Harga per Liter: ");
                        double hargaPerLiter = sc.nextDouble();
                        System.out.print("Masukkan Jumlah Liter: ");
                        double liter = sc.nextDouble();
                        BBM bbm = new BBM(jenisBBM, hargaPerLiter);
                        spbu.melayani(bbm, liter);
                        System.out.println(">> Transaksi Berhasil dicatat.");
                    break;
                case 5:
                    System.out.println("--- Riwayat transaksi ---");
                    spbu.riwayatTransaksi();
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        } while (pilihan != 0);
        sc.close();
    }
}
