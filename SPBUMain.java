import java.util.Scanner;

public class SPBUMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilihan;
        methodSPBU layananSPBU = new methodSPBU(10);

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
                    layananSPBU.tambahAntrian(inputKendaraan(sc));
                    System.out.println(">>> Kendaraan masuk kedalam antrian");
                    break;
            
                case 2:
                    System.out.println("--- Antrian kendaraan ---");
                    layananSPBU.tampilkanAntrian();
                    break;
                case 3:
                    System.out.println(">>> Jumlah kendaraan dalam antrian : " + layananSPBU.getJumlahAntrian());
                    break;
                case 4:
                    System.out.println("Petugas melayani " + layananSPBU.dataAntrian[layananSPBU.frontAntrian].platNomor);
                    System.out.print("Masukkan jenis BBM : ");
                    String jenis = sc.nextLine();
                    System.out.print("Harga per liter : ");
                    double harga = sc.nextDouble();
                    BBM temp = new BBM(jenis, harga);
                    System.out.print("Masukkan jumlah liter : ");
                    double jumlah = sc.nextDouble();
                    sc.nextLine();
                    layananSPBU.melayani(temp, jumlah);
                    System.out.println(">>> Transaksi berhasil dicatat");
                    break;
                case 5:
                    System.out.println("--- Riwayat transaksi ---");
                    layananSPBU.riwayatTransaksi();
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        } while (pilihan != 0);
    }
    static kendaraan inputKendaraan(Scanner sc){
        System.out.print("Masukkan plat nomor : ");
        String plat = sc.nextLine();
        System.out.print("Masukkan jenis kendaraan : ");
        String jenis = sc.nextLine();
        System.out.print("Masukkan merk : ");
        String merk = sc.nextLine();
        kendaraan data = new kendaraan(plat, jenis, merk);
        return data;
    }
    static void inputTransaksi(Scanner sc){
        System.out.println("Masukkan jenis BBM : ");
        String jenis = sc.nextLine();
        System.out.println("Harga per liter : ");
        double harga = sc.nextDouble();
        System.out.println("Masukkan jumlah liter : ");
        double jumlah = sc.nextDouble();
        sc.nextLine();
        
    }
}
