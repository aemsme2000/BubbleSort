package bubblesortlearn;

import java.util.Random;
import java.util.Scanner;

public class BubbleSortLearn {

    void BubbleSortNedir() {

        System.out.println(" Bubble Sort Nedir ?  \n"
                + "*************************************\n"
                + " \033[0;31m Bubble Sort \033[0m : Turkcesi \033[0;31m Kabarcik Siralamasidir. \033[0m  Bir diziden Bastan baslayarak pes pese olan iki eleman\n "
                + "siralanir buyuk olan sağa, kucuk olan sola yazilir. Amacimiz karsilastirilan iki sayida buyuk \n"
                + "sayilari sağ tarafa, kucuk sayilari sol tarafa oteleyip sayilari kucukten buyuye doğru siralamaktir \n"
                + "*************************************"
                + "\nNasil Calisir ? \n"
                + "Mesela elimizde dizi[42"
                + "]={5,1,-5,30} elemanlari bulunan bir dizimiz olsun "
                + "Bunlar su sekilde islem gorerek siralanir\n"
                + "  [5  1]  -5  30 --> [1 5]  -5  30 \n "
                + " 1  [5  -5 ] 30 -->  1  [-5  5] 30 ... \n"
                + "gibi gibi  devam eder  en sonunda da : -5  1  5  30  olarak siralanir  ");
    }

    void OrnekSiralama() {
        Random random = new Random();
        int uzunluk = 4;
        int j, i, m;
        int[] arr = new int[4];
        for (i = 0; i < uzunluk - 1; i++) {
            arr[i] = random.nextInt(50);   // Dizimizin her elemanina 0-50 arasi random sayi atanir 
            for (j = 0; j < i; j++) {

                while (arr[j] == arr[i]) {
                    arr[i] = (int) (Math.random() * 9); //random.nextInt(50);  Eğer random atilan sayimiz 
                    //onceki bir sayi ile esit olursa sayimiz değistirilir 
                    j -= j;
                }
            }
        }

        System.out.println("Ornek dizimiz :  dizi[ornek]");

        for (i = 0; i < uzunluk - 1; i++) {
            for (j = 0; j < uzunluk - 1 - i; j++) {
                String islemKontrol = "islem yapilmadi";   // eğer asağidaki if de islem gerceklesirse yazmak icin kullanilir yoksa 
                //ayni dizi tekrardan girileceği icin bosuna yazdirmasin diye kullandim
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    islemKontrol = "islem yapildi";
                }

                if (islemKontrol.equals("islem yapildi")) {
                    for (m = 0; m < uzunluk; m++) {
                        System.out.print(arr[m] + " ");
                    }
                    System.out.print(" ->  karsilastirilan sayilar [ " + arr[j + 1] + " " + arr[j] + " ]  \033[0;32m Duzeltilmis hali  "
                            + "-->[ " + arr[j] + " " + arr[j + 1] + " ] \033[0m");    // \033[0;32m gibi degisik seyler renk kodlari 
                    System.out.println();
                } else {
                    for (m = 0; m < uzunluk; m++) {
                        System.out.print(arr[m] + " ");
                    }
                    System.out.print(" ->  karsilastirilan sayilar [ " + arr[j] + " " + arr[j + 1] + " ] ");
                    System.out.println();
                }

            }
        }
    }

    void OrnekCoz(int uzunluk) {
        Scanner scanner = new Scanner(System.in);
        int i, j, m;

        Random random = new Random();
        int[] arr = new int[uzunluk];
        for (i = 0; i < uzunluk - 1; i++) {
            arr[i] = random.nextInt(50);;
            for (j = 0; j < i; j++) {              // Program hata verirse bunu while yaz 

                while (arr[j] == arr[i]) {
                    arr[i] = random.nextInt(50);
                    j -= j;
                }
            }
        }

        System.out.println("Siralanacak dizi: ");
        System.out.print("[ ");
        for (i = 0; i < uzunluk; i++) {
            System.out.print(" " + arr[i] + " ");
        }
        System.out.print(" ]");
        System.out.println("Şimdi bu dizide ornekteki gibi karsilastirilan iki sayiyi yaziniz ");

        for (i = 0; i < uzunluk - 1; i++) {
            for (j = 0; j < uzunluk - 1 - i; j++) {

                System.out.print("[ ");
                for (m = 0; m < uzunluk; m++) {
                    System.out.print(arr[m] + " ");
                }
                System.out.println(" ]");
                {
                    System.out.print("Siradaki iki sayiyi karsilastirilip doğrusunu yaziniz : ");
                    System.out.print("");

                    int cevap1 = scanner.nextInt();
                    int cevap2 = scanner.nextInt();
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                    if (cevap1 == arr[j] && cevap2 == arr[j + 1]) {
                        System.out.println(" \033[0;36m ✓ \033[0m");
                    } else {
                        java.awt.Toolkit.getDefaultToolkit().beep();     //Hata yapildiğinda bip sesi cikarmasini saglar
                        System.out.println("\033[0;31m" + "Malesef hata yaptiniz !!!" + "\033[0;32m" + "  Doğrusu : " + "[ \033[0;34m " + arr[j] + " " + arr[j + 1] + "  \033[0;32m ]" + "\033[0m");

                        System.out.println(" ]");
                        System.out.println();
                    }

                }
            }
        }
        System.out.print("\033[0;35m  ✓ ✓ ✓  Dizimiz tamamlandi ✓ ✓ ✓  \033[0m ");
        System.out.print(" \033[0;34m Dizimizin Siralanmis hali [ ");
        for (m = 0; m < uzunluk; m++) {
            System.out.print(arr[m] + " ");
        }
        System.out.println(" ]");
        System.out.println("                            \033[0;31m  ... Tebrikler  \033[0m ");
    }

    public static void main(String[] args) {
        //public static final String BLUE = "\033[0;34m";    // BLUE
        System.out.println("\033[0;34m" + " Merhaba" + "\033[0m");

        int[] kkk = new int[5];

        BubbleSortLearn calisma = new BubbleSortLearn();
        Scanner scanner = new Scanner(System.in);
        System.out.println("!!! *** Oncelikle Programa hosgeldiniz *** !!!");
        String Secenekler = "1-) Nedir bu BubbleSort? Ne ise yarar\n"
                + "2-) Ornek Cozum\n"
                + "3-) Soru Cozumu\n";
        String islemSec = null;
        while (islemSec != "cikis") {
            System.out.println(Secenekler);

            System.out.println("Yukaridakilerden islemlerden hangisini istiyorsaniz lutfen onun numarasini giriniz.\n"
                    + "Not : Cikis icin cikis yaziniz ");

            islemSec = scanner.nextLine();
            switch (islemSec) {
                case "1":
                    calisma.BubbleSortNedir();
                    break;

                case "2":
                    calisma.OrnekSiralama();
                    break;

                case "3":
                    System.out.println("Dizi uzunluğunu giriniz ");
                    int uzunluk = scanner.nextInt();
                    scanner.nextLine(); //Dummy code

                    calisma.OrnekCoz(uzunluk);
                    break;
                default:
                    System.out.println("Bilinmeyen islem lutfen tekrar deneyin");

            }

        }
    }

}
