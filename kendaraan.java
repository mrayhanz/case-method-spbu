public class kendaraan {
    String platNomor, tipe, merk;

    public kendaraan(String platNomor, String tipe, String merk) {
        this.platNomor = platNomor;
        this.tipe = tipe;
        this.merk = merk;    
    }
    public void tampilkanInformasi() {
        System.out.println("Plat Nomor : " + platNomor);
        System.out.println("Tipe       : " + tipe);
        System.out.println("Merk       : " + merk);
    }
}