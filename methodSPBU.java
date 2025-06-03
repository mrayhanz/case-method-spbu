public class MethodSPBU {
    Kendaraan dataAntrian[];
    int frontAntrian, rearAntrian, sizeAntrian, max;
    NodeBBM head;
    
    public MethodSPBU(int n){
        head = null;
        max = n;
        dataAntrian = new Kendaraan[max];
        sizeAntrian = 0;
        frontAntrian = 0;
        rearAntrian = -1;
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
        if (!isEmptyAntrian()) {
            TransaksiPengisian dtInput = new TransaksiPengisian(dataAntrian[frontAntrian], bbm, liter);
            frontAntrian = (frontAntrian + 1) % max;
            sizeAntrian --;
            NodeBBM ndInput = new NodeBBM(dtInput);
            if (isEmptyTransaksi()) {
                head = ndInput;
            }else{
                NodeBBM temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = ndInput;
            }
    }else{
        System.out.println("Antrian masih kosong");
    }
    }
    public int getJumlahAntrian(){
        return sizeAntrian;
    }
    public void tampilkanAntrian(){
        if (!isEmptyAntrian()) {
            System.out.println("Antrian kendaraan :");
            int index = frontAntrian, tempSize = 0;
            while (true) {
                dataAntrian[index].tampilkanInformasi(); 
                tempSize++;
                index = (index + 1) % max;
                if (tempSize == sizeAntrian) {
                    break;
                }
            }
        }else{
            System.out.println("Antrian masih kosong");
        }
    }
    public void riwayatTransaksi(){
        NodeBBM temp = head;
        if (!isEmptyTransaksi()) {
            while (temp != null) {
                System.out.printf("%s : Rp.%,.2f%n", temp.data.kendaraan.platNomor, temp.data.totalBayar);
                temp = temp.next;
            }
        }else{
            System.out.println("Transaksi masih kosong");
        }
    }
}