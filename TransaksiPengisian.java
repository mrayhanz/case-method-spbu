public class TransaksiPengisian {
    kendaraan dataAntrian[];
    int front, rear, size, max;
    nodeBBM head, tail;
    

    public TransaksiPengisian(int n){
        max = n;
        size = 0;
        front = rear = -1;
    }
    public TransaksiPengisian(){
        head = tail = null;
    }
    
}
