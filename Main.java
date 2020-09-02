import java.util.ArrayList;
import java.util.Collections;
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
    return hg;
  }

  public static int cariB(ArrayList<ArrayList<String>> barang, String cari){
    int w = barang.size() - 1;
    int ketemu = 0;
    while(w >= 0 && ketemu == 0){
      if(barang.get(w).get(0) == cari){
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
  public static void tBelSew(ArrayList<ArrayList<String>> barang, ArrayList<ArrayList<String>> belsew, int lok){
    int brg = cariB(belsew,barang.get(lok).get(0));
    if(brg == -2){
      belsew.add(barang.get(lok));
      int brg2 = cariB(belsew,barang.get(lok).get(0));  
      if(belsew.get(brg2).size() == 2){
        belsew.get(brg2).add("1");
      }
    }else{
      int brg2 = cariB(belsew,barang.get(lok).get(0));
      int num = sKeI(belsew.get(brg2).get(2)) + 1;
      belsew.get(brg2).set(2,String.valueOf(num));
    }
    
    

  }

  public static void printTab(ArrayList<ArrayList<String>> beli){
    for (int i = 0; i < beli.size(); i++) { 
        for (int j = 0; j < beli.get(i).size(); j++) { 
            System.out.print(beli.get(i).get(j) + " "); 
        } 
        System.out.println(); 
    }
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
    String cari = "215CZP";
    // int w = barang.size() - 1;
    // int ketemu = 0;
    //String sharga = "";
    // int harga;

    // while(w >= 0 && ketemu == 0){
    //   if(barang.get(w).get(0) == cari){
    //       beli.add(barang.get(w));
    //       ///////////
    //       sharga = barang.get(w).get(0).substring(0,2);
    //       int x = sKeI(barang.get(w).get(0).substring(2,3));
    //       sharga = hBarang(sharga,x);
    //       System.out.println(sharga);
    //       //////////
    //       ketemu = 1;
    //   }else{
    //     w--;
    //   }
    // }
    int lok = cariB(barang,cari);
    tBelSew(barang,belsew,lok);
    printTab(belsew);
    tBelSew(barang,belsew,lok);
    System.out.println(lok);
    lok = cariB(barang,"046AXR");
    tBelSew(barang,belsew,lok);
    printTab(belsew);
  }

  
}