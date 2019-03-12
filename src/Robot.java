import java.util.ArrayList;

/*
     Robot yang akan bertarung. Robot punya senjata, perisai dan skor kesehatan.
 */
public class Robot {
    Senjata oSenjata;
    Perisai oPerisai;
    int kesehatan;
    String nama = "";

    // ArrayList (Collection bukan array(ukuran tdk dapat diubah)) menampung objek
    ArrayList<Senjata> kumpulanSenjata = new ArrayList<>(); // menyimpan senjata
    ArrayList<Perisai> kumpulanPerisai = new ArrayList<>(); // menyimpan perisai

    public int jumlahSenjata(){
        return kumpulanSenjata.size();
    }
    public int jumlahPerisai(){
        return kumpulanPerisai.size();
    }

    public Senjata getSenjata(int i){
        return kumpulanSenjata.get(i);
    }
    public Perisai getPerisai(int i){
        return kumpulanPerisai.get(i);
    }

    //isi senjata milik robot
    public void  tambahSenjata(Senjata s) {
        oSenjata = s;
    }

    public void  tambahPerisai(Perisai p) {

        oPerisai = p;
    }

    // Senjata yang digunakan
    public void tambahKumpulanSenjata(Senjata s){
        kumpulanSenjata.add(s);
    }

    // Perisai yang digunakan
    public void tambahKumpulanPerisai(Perisai p){
        kumpulanPerisai.add(p);
    }

    //print kesehatan dsb
    public void printStatistik() {
        System.out.println("Nama Robot: "+nama);
        System.out.println("Kesehatan:"+kesehatan);
    }

    //constructor
    public Robot(String vNama) {
        nama = vNama;
        kesehatan = 100; //default
    }

    /* menyerang robot lain, skor kesehatan robot lain akan berkurang
    */
    public void serang(Robot rLawan) {
       //skor kesehatan robot lawan akan dikurangi
        if(rLawan.oPerisai.kekuatan - oSenjata.kekuatan < 0){
            rLawan.kesehatan -= (oSenjata.kekuatan - rLawan.oPerisai.kekuatan);
        }
        if(rLawan.kesehatan<0){
            rLawan.kesehatan =0;
        }
//       rLawan.kesehatan =  rLawan.kesehatan - oSenjata.kekuatan;
    }
}
