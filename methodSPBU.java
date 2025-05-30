public class methodSPBU {
    kendaraan dataAntrian[];
    int frontAntrian, rearAntrian, sizeAntrian, max, sizeTransaksi;
    nodeBBM head, tail;
    

    public methodSPBU(int n){
        max = n;
        sizeAntrian = 0;
        frontAntrian = rearAntrian = -1;
    }
    public methodSPBU(){
        head = tail = null;
        sizeTransaksi = 0;
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
    public void tambahAntrian(kendaraan input){
        if (isFullAntrian()) {
            System.out.println("Antrian penuh, tidak dapat menambah mahasiswa.");
            return;
        }
        rearAntrian = (rearAntrian + 1) % max;
        dataAntrian[rearAntrian] = input;
        sizeAntrian ++;
        System.out.println(input.platNomor + " berhasil masuk ke antrian.");
    }
    public void insertAt(TransaksiPengisian input){
        nodeBBM ndInput = new nodeBBM(input);
        if (sizeAntrian == 0) {
            head = ndInput;
            tail = ndInput;
        }else{
            nodeBBM temp = head;
            while (temp != null) {
                temp = temp.next;
            }
            temp.next = ndInput;
        }
    }
    public int getJumlahAntrian(){
        return sizeAntrian;
    }
    public void tampilkanKendaraan(){
        System.out.println("Antrian kendaraan :");
        for(int i = 0; i < sizeAntrian; i++){
            dataAntrian[i].tampilkanInformasi();
        }
    }    
}
