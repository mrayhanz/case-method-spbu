public class TransaksiPengisian {
    kendaraan kendaraan;
    BBM bbm;
    double liter;
    double totalBayar;
    public TransaksiPengisian(kendaraan dt, BBM bbm, double ltr){
        kendaraan = dt;
        this.bbm = bbm;
        liter = ltr;
        totalBayar = ltr * this.bbm.hargaPerLiter;
    }

}
