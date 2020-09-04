import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
//import java.util.Collections;
class Main {
    //fungsi merubah string menjadi angka dengan masukan string yang akan
    //dibuat menjadi Integer. jika sumber adalah string angka maka akan
    //return angka sesuai string angka tsb. jika tidak return angka 0
    public static int sKeI(String sumber){
        int angka;
        try {
            return angka = Integer.parseInt(sumber);
        }
        catch (NumberFormatException e)
        {
            return angka = 0;
        }
    }
    //fungsi yang mengembaliakan harga string dari kode barang
    public static String hBarang(String hag, int x){
        String hg = hag;
        for(int i = 0; i < x ; i++){
            hg += "0";
        }
        hg = String.valueOf(sKeI(hg));
        return hg;
    }

    public static int cariB(ArrayList<ArrayList<String>> barang, String cari){
        int w = barang.size() - 1;
        int ketemu = 0;
        while(w >= 0 && ketemu == 0){
            if(barang.get(w).get(0).equals(cari)){
                ketemu = 1;
            }else{
                w--;
            }
        }
        if(ketemu == 1){
            return w;
        }else{
            return -2;
        }
    }
    public static void tambahBeli(ArrayList<ArrayList<String>> barang, ArrayList<ArrayList<String>> belsew, int lok){
        int brg = cariB(belsew,barang.get(lok).get(0));
        if(brg == -2){
            belsew.add(barang.get(lok));
            int brg2 = cariB(belsew,barang.get(lok).get(0));
            if(belsew.get(brg2).size() == 2){
                belsew.get(brg2).add("1");
                String sharga = barang.get(lok).get(0).substring(0,2);
                int x = sKeI(barang.get(lok).get(0).substring(2,3));
                sharga = hBarang(sharga,x);
                //harga item
                belsew.get(brg2).add(sharga);
                //harga total item
                belsew.get(brg2).add(sharga);
            }

        }else{
            int brg2 = cariB(belsew,barang.get(lok).get(0));
            int num = sKeI(belsew.get(brg2).get(2)) + 1;
            belsew.get(brg2).set(2,String.valueOf(num));
            belsew.get(brg2).set(4,String.valueOf(sKeI(belsew.get(brg2).get(2)) * sKeI(belsew.get(brg2).get(3))));
        }
    }

    public static void tambahSewa(ArrayList<ArrayList<String>> barang, ArrayList<ArrayList<String>> belsew, int lok){
        int brg = cariB(belsew,barang.get(lok).get(0));
        if(brg == -2){
            belsew.add(barang.get(lok));
            int brg2 = cariB(belsew,barang.get(lok).get(0));
            if(belsew.get(brg2).size() == 2){
                belsew.get(brg2).add("1");
                String sharga = barang.get(lok).get(0).substring(0,2);
                int x = sKeI(barang.get(lok).get(0).substring(2,3));
                sharga = hBarang(sharga,x);
                //harga item
                belsew.get(brg2).add(sharga);
                //harga total iteM
                if (barang.get(lok).get(0).substring(4,5) == "X"){
                    belsew.get(brg2).add(String.valueOf((int)((sKeI(belsew.get(brg2).get(2)) * 0.4) * sKeI(belsew.get(brg2).get(3)))));
                }else if(barang.get(lok).get(0).substring(4,5) == "Y"){
                    belsew.get(brg2).add(String.valueOf((int)((sKeI(belsew.get(brg2).get(2)) * 0.6) * sKeI(belsew.get(brg2).get(3)))));
                }else{
                    belsew.get(brg2).add(String.valueOf((int)((sKeI(belsew.get(brg2).get(2)) * 0.8) * sKeI(belsew.get(brg2).get(3)))));
                }

                belsew.get(brg2).add(sharga);
            }

        }else{
            int brg2 = cariB(belsew,barang.get(lok).get(0));
            int num = sKeI(belsew.get(brg2).get(2)) + 1;
            belsew.get(brg2).set(2,String.valueOf(num));

            if (barang.get(lok).get(0).substring(4,5) == "X"){
                belsew.get(brg2).set(4,String.valueOf((int)((sKeI(belsew.get(brg2).get(2)) * 0.4) * sKeI(belsew.get(brg2).get(3)))));
            }else if(barang.get(lok).get(0).substring(4,5) == "Y"){
                belsew.get(brg2).set(4,String.valueOf((int)((sKeI(belsew.get(brg2).get(2)) * 0.6) * sKeI(belsew.get(brg2).get(3)))));
            }else{
                belsew.get(brg2).set(4,String.valueOf((int)((sKeI(belsew.get(brg2).get(2)) * 0.8) * sKeI(belsew.get(brg2).get(3)))));
            }
        }
    }

    public static int gTotalAwal(ArrayList<ArrayList<String>> barang){
        int gTotal = 0;
        for(int i = 0; i < barang.size(); i++){
            gTotal += sKeI(barang.get(i).get(4));
        }
        return gTotal;
    }

    public static int diskonBeli(ArrayList<ArrayList<String>> beli){
        int gTotal = gTotalAwal(beli);
          if(gTotal >= 5000000){
            int kDiskon = 0;
            for(int t = 0; t < beli.size(); t++){
                String kunciDiskon = beli.get(t).get(0).substring(3,4);
                double hargaperitem = sKeI(beli.get(t).get(3));
                if( kunciDiskon == "A"){
                    kDiskon = (int)(hargaperitem * 0.025);
                    beli.get(t).set(3,String.valueOf(sKeI(beli.get(t).get(3)) - kDiskon ));
                    beli.get(t).set(4,String.valueOf(sKeI(beli.get(t).get(2)) * sKeI(beli.get(t).get(3))));
                }else if(kunciDiskon == "B"){
                    kDiskon = (int)(hargaperitem * 0.05);
                    beli.get(t).set(3,String.valueOf(sKeI(beli.get(t).get(3)) - kDiskon ));
                    beli.get(t).set(4,String.valueOf(sKeI(beli.get(t).get(2)) * sKeI(beli.get(t).get(3))));
                }else{
                    kDiskon = (int)(hargaperitem * 0.1);
                    beli.get(t).set(3,String.valueOf(sKeI(beli.get(t).get(3)) - kDiskon ));
                    beli.get(t).set(4,String.valueOf(sKeI(beli.get(t).get(2)) * sKeI(beli.get(t).get(3))));
                }
            }
              int gtotaldiskon = gTotalAwal(beli);
              return gtotaldiskon;
          }else{
            return gTotal;
          }
    }

    public static void printTab(ArrayList<ArrayList<String>> beli){
        //cek diskon
        int grandtotal = diskonBeli(beli);
        //start header
        System.out.println("Barang yang sudah dibeli adalah");
        System.out.print("   Kode -");
        System.out.print("                 Item -");
        System.out.print(" Banyak -");
        System.out.print("           Harga -");
        System.out.print("           Total");
        System.out.println();
        String formatkode = "%7s -";
        String formatitem = "%21s -";
        String formatbanyak = "%7s -";
        String formatharga = "%13s.00 -";
        String formattotal = "%13s.00";
        String formatgtotal = "Total transaksi %56s.00";
        //end of header
        for (int i = 0; i < beli.size(); i++) {
            System.out.format(formatkode,beli.get(i).get(0));
            System.out.format(formatitem,beli.get(i).get(1));
            System.out.format(formatbanyak,beli.get(i).get(2));
            System.out.format(formatharga,beli.get(i).get(3));
            System.out.format(formattotal,beli.get(i).get(4));
            System.out.println();
        }
        System.out.format(formatgtotal, grandtotal );
        System.out.println();
    }

    public static void printTabSewa(ArrayList<ArrayList<String>> beli){
        int lamaSewa = 0;
        int angka = 0;
        for(int o = 0 ; o < beli.size() ; o++){
            String harsew = beli.get(o).get(0).substring(5,6);

            if(harsew.equals("P")){
                angka = 1;
            }else if(harsew.equals("Q")){
                angka = 3;
            }else if(harsew.equals("R")) {
                angka = 5;
            }

            if(lamaSewa < angka){
                lamaSewa = angka;
            }
        }
        //start header
        System.out.println("Barang yang sudah disewa adalah");
        System.out.print("   Kode -");
        System.out.print("                 Item -");
        System.out.print(" Banyak -");
        System.out.print("           Harga -");
        System.out.print("           Total");
        System.out.println();
        String formatkode = "%7s -";
        String formatitem = "%21s -";
        String formatbanyak = "%7s -";
        String formatharga = "%13s.00 -";
        String formattotal = "%13s.00";
        String formatgtotal = "Total transaksi %56s.00";
        String lamsew = "Lama sewa %65s Hari";
        //end of header
        for (int i = 0; i < beli.size(); i++) {
            System.out.format(formatkode,beli.get(i).get(0));
            System.out.format(formatitem,beli.get(i).get(1));
            System.out.format(formatbanyak,beli.get(i).get(2));
            System.out.format(formatharga,beli.get(i).get(3));
            System.out.format(formattotal,beli.get(i).get(4));
            System.out.println();
        }
        System.out.format(formatgtotal, gTotalAwal(beli) );
        System.out.println();
        System.out.format(lamsew, lamaSewa );
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 7;
        //Inisialisasi koleksi barang
        ArrayList<ArrayList<String>> barang = new ArrayList<ArrayList<String>>(n);
        //buat list satu per satu tiap barang kemudian dimmasukan kedalam list barang (ArrayList of ArrayList)
        ArrayList<String> b1 = new ArrayList<String>();
        ArrayList<String> b2 = new ArrayList<String>();
        ArrayList<String> b3 = new ArrayList<String>();
        ArrayList<String> b4 = new ArrayList<String>();
        ArrayList<String> b5 = new ArrayList<String>();
        ArrayList<String> b6 = new ArrayList<String>();
        ArrayList<String> b7 = new ArrayList<String>();

        b1.add("294BYP");
        b1.add("Kacamata renang");
        b2.add("055CXP");
        b2.add("Kaki katak");
        b3.add("993BYP");
        b3.add("Topi renang");
        b4.add("134BYP");
        b4.add("Celana renang panjang");
        b5.add("215CZP");
        b5.add("Baju renang full");
        b6.add("384BZP");
        b6.add("Snorkel");
        b7.add("046AXR");
        b7.add("Tabung selam");
        //masukin ArrayList(n) ke ArrayList barang
        barang.add(b1);
        barang.add(b2);
        barang.add(b3);
        barang.add(b4);
        barang.add(b5);
        barang.add(b6);
        barang.add(b7);

        ArrayList<ArrayList<String>> belsew = new ArrayList<ArrayList<String>>(10);

        ////Menu Awal////
        System.out.println("Selamat Datang Di Toko Safe Trench Dive");
        System.out.println("Silahkan Pilih Transaksi :");
        System.out.println(" 1. Penjualan");
        System.out.println(" 2. Penyewaan");


        Scanner scan = new Scanner(System.in);
        Scanner kodebarang = new Scanner(System.in);
        int number = 0;
        int lok = 0;
        String kode = "";
        System.out.print("Masukan Pilihan Menu : ");
        try{
            number = scan.nextInt();

        }catch(InputMismatchException e){
            System.out.println("Input harus angka. ");
        }
        //switch ke kode pilihan di menu
        switch (number) {
            case 1:
                //menu penjualan
                while(!kode.equals("000")){

                    System.out.print("Masukan Kode Barang : ");
                    try{
                        kode = kodebarang.nextLine();

                    }catch(InputMismatchException e){
                        System.out.println("Ups");
                    }
                    if(!kode.equals("000")){
                        lok = cariB(barang,kode);
                        tambahBeli(barang,belsew,lok);
                        printTab(belsew);
                    }else{
                        System.out.println("===========================Pancatatan Selesai==============================");
                    }

                }

                break;
            case 2:
                //menu sewa
                while(!kode.equals("000")){

                    System.out.print("Masukan Kode Barang : ");
                    try{
                        kode = kodebarang.nextLine();

                    }catch(InputMismatchException e){
                        System.out.println("Ups");
                    }
                    if(!kode.equals("000")){
                        lok = cariB(barang,kode);
                        tambahSewa(barang,belsew,lok);
                        printTabSewa(belsew);
                    }else{
                        System.out.println("===========================Pancatatan Selesai==============================");
                    }

                }
                break;
            default: System.out.println("Pilihan Salah");
        }
        /////Akhir Kode Menu/////


    }
}