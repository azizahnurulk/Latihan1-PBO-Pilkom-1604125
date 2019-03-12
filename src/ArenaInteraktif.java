/*
     Menjalankan pertarungan antar dua robot

 */
import java.util.Scanner;

public class ArenaInteraktif extends Arena {
    private Robot robot1;
    private Robot robot2;

    public void tambahRobot(Robot r1,Robot r2) {
        robot1 = r1;
        robot2 = r2;
    }

    public void bertanding() {
        //UI sederhana untuk pertandingan

        //loop sampai salah satu robot habis skor kesehatannya
        boolean isSelesai = false;

        //LENGKAPI dengan NIM dan NAMA
        System.out.println("Saya berjanji tdk berbuat curang dan/atau membantu orang lain berbuat curang");
        System.out.println(" Quiz 1 27 Feb ");
        System.out.println(" NIM  : 1604125 ");
        System.out.println(" NAMA : Azizah Nurul K ");

        System.out.print("===== Pertandingan dimulai =====\n");

        //player
        Robot robotAktif = robot1;
        Robot robotPasif = robot2;

        while (!isSelesai) {
            System.out.println("");
            System.out.println("Giliran robot:"+robotAktif.nama);
            //
            Scanner in = new Scanner(System.in);

            // menampilkan senjata
            System.out.println("\nList Senjata " + robotAktif.nama +":");
            for (int i = 0; i < robotAktif.jumlahSenjata(); i++){
                System.out.println((i+1)+ " Senjata " + robotAktif.kumpulanSenjata.get(i).namaSenjata);
            }
            System.out.println("\nPilih Senjata Untuk " + robotAktif.nama +":");
            int pilihSenjata = in.nextInt();
            robotAktif.oSenjata = robotAktif.kumpulanSenjata.get(pilihSenjata-1);

            // menampilkan perisai
            System.out.println("\nList Perisai " + robotAktif.nama +":");
            for (int i = 0; i < robotAktif.jumlahPerisai(); i++){
                System.out.println((i+1)+ " Perisai " + robotAktif.kumpulanPerisai.get(i).namaPerisai);
            }
            System.out.println("\nPilih Perisai " + robotPasif.nama +":");
            int pilihPerisai = in.nextInt();
            robotPasif.oPerisai = robotPasif.kumpulanPerisai.get(pilihPerisai-1);

            System.out.println("Robot menyerang dengan senjata "+robotAktif.oSenjata.namaSenjata);
            System.out.println("Robot menggunakan "+robotAktif.oPerisai.namaPerisai);
            robotAktif.serang(robotPasif);
            //print kesehatan
            robot1.printStatistik();
            robot2.printStatistik();
            //tukar peran
            Robot temp = robotAktif; //supaya tdk tertimpa
            robotAktif = robotPasif;
            robotPasif = temp;

            //stop jika salah satu robot skor kesehatanya nol
            isSelesai = (robotAktif.kesehatan<=0 || robotPasif.kesehatan<=0);
        }
        System.out.println("Pertandingan Selesai");

        // No. 2 (Cek Pemenang)
        if(robot1.kesehatan <=0 && robot2.kesehatan <=0){
            System.out.println("DRAW");
        }else if(robotAktif.kesehatan>0){
            System.out.println("\nPemenangnya adalah "+robotAktif.nama);
        }else{
            System.out.println("\nPemenangnya adalah "+robotPasif.nama);
        }


    }


    public static void main(String [] args) {
        //buat arena
        ArenaInteraktif oArena = new ArenaInteraktif();

        //siapkan robot
        Robot robot1 = new Robot("Robot pertama");
        Robot robot2 = new Robot("Robot kedua");

        // No. 4 (tambahkan Senjata Robot1)
        Senjata oSenjataKilat1 = new SenjataKilat();
        robot1.addSenjata(oSenjataKilat1);

        // tambahkan Senjata Robot2
        Senjata oSenjataKilat2 = new SenjataKilat();
        robot2.addSenjata(oSenjataKilat2);

        // tambahkan Perisai ke Robot1
        Perisai oRedShield1 = new RedShield();
        Perisai oBlueShield1 = new BlueShield();
        robot1.addPerisai(oRedShield1);
        robot1.addPerisai(oBlueShield1);

        // tambahkan Perisai ke Robot2
        Perisai oRedShield2 = new RedShield();
        Perisai oBlueShield2 = new BlueShield();
        robot2.addPerisai(oRedShield1);
        robot2.addPerisai(oBlueShield2);

        //tambahkan robot ke arena
        oArena.tambahRobot(robot1,robot2);

        //mainkan
        oArena.bertanding();

    }

}
