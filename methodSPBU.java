public class MethodSPBU {
    Kendaraan dataAntrian[];
    int frontAntrian, rearAntrian, sizeAntrian, max;
    NodeBBM head, tail;
    
    public MethodSPBU(int n){
        max = n;
        sizeAntrian = 0;
        frontAntrian = rearAntrian = -1;
    }
    public boolean isEmptyTransaksi(){
        return head == null;
    }
    public boolean isEmptyAntrian(){
        return sizeAntrian == 0;
    }
    public boolean isFullAntrian(){
        return sizeAntrian == max;
    }
    public void tambahAntrian(Kendaraan input){
        if (isFullAntrian()) {
            System.out.println("Antrian penuh, tidak dapat menambah kendaraan.");
            return;
        }
        rearAntrian = (rearAntrian + 1) % max;
        dataAntrian[rearAntrian] = input;
        sizeAntrian ++;
        System.out.println( ">>" + input.platNomor + " berhasil masuk ke antrian.");
    }
    public void melayani(BBM bbm, double liter){
        TransaksiPengisian dtInput = new TransaksiPengisian(dataAntrian[frontAntrian], bbm, liter);
        frontAntrian = (frontAntrian + 1) % max;
        sizeAntrian --;
        NodeBBM ndInput = new NodeBBM(dtInput);
        if (!isEmptyTransaksi()) {
            head = ndInput;
            tail = ndInput;
        }else{
            NodeBBM temp = head;
            while (temp != null) {
                temp = temp.next;
            }
            temp = ndInput;
        }
    }
    public int getJumlahAntrian(){
        return sizeAntrian;
    }
    public void tampilkanAntrian(){
        System.out.println("Antrian kendaraan :");
        for(int i = 0; i < sizeAntrian; i++){
            dataAntrian[i].tampilkanInformasi();
        }
    }
    public void riwayatTransaksi(){
        NodeBBM temp = head;
        while (temp != null) {
            System.out.println(temp.data.kendaraan.platNomor + " : Rp." + temp.data.totalBayar);
        }
    }
}
