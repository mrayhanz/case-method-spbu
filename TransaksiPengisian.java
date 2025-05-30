public class TransaksiPengisian {
    Kendaraan kendaraan;
    BBM bbm;
    double liter;
    double totalBayar;
    public TransaksiPengisian(Kendaraan dt, BBM bbm, double ltr){
        kendaraan = dt;
        this.bbm = bbm;
        liter = ltr;
        totalBayar = ltr * this.bbm.hargaPerLiter;
    }

}
