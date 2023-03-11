import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda02 {

    /*
     * Yazili Olmayan Kural *
     * Lambda kullanirken mumkun mertebe "lambda expression"dan kacinilmasi önerilir.
     * Eger mumkunse "method referance" kullanilmasi tavsiye edilir.

     * */

    public static void main(String[] args) {

        List<Integer> sayi = new ArrayList<>(Arrays.asList(4, 2, 6, 11, -5, 7, 3, 15));

        ciftElKarePrint(sayi); //Task 1

        System.out.println();

        tekElKupPrint(sayi); // Task 2

        System.out.println();

        cifElKareKokPrint(sayi); //Task 3

        System.out.println();

        enBuyukElPrint(sayi); //Task 4

        System.out.println();

        enBuyukElPrintStructural(sayi); //Task 5

        System.out.println();

        ciftElKareEnBykPrint(sayi); //Task 6

        System.out.println();

        elToplam(sayi); //Task 7

        System.out.println();

        ciftElCarpim(sayi); //Task 8

        System.out.println();

        minBul(sayi); //Task 9

        System.out.println();

        bestenBykEnKckTekElPring(sayi); //Task 10

        System.out.println();

        ciftElKareKckBykSrlPrint(sayi); //Task 11

    }

    // Task-1 : Functional Programming ile listin cift elemanlarinin  karelerini
    // ayni satirda aralarina bosluk bırakarak print ediniz

    public static void ciftElKarePrint(List<Integer> sayi) {
        sayi.
                stream().
                filter(Lambda01::ciftBul).//akışdaki çift sayıları filtreledim
                map(w -> w * w).// map methodu ile karelerini aldık--Stream içerisindeki elemanları başka değerlere dönüştürüyor.
                forEach(Lambda01::yazdir);//Lambda01 class'ındaki yazdir methodunu kullanarak forEach içerisinde işlem yaptık
    }

    // Task : Functional Programming ile listin tek elemanlarinin  kuplerinin bir fazlasini
    // ayni satirda aralarina bosluk birakarak print ediniz

    public static void tekElKupPrint(List<Integer> sayi) {
        sayi.
                stream().
                filter(w -> w % 2 != 0).
                map(w -> (w * w * w) + 1).
                forEach(Lambda01::yazdir);
    }

    // Task-3 : Functional Programming ile listin cift elemanlarinin
    // karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz

    public static void cifElKareKokPrint(List<Integer> sayi) {
        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(Math::sqrt).
                forEach(w -> System.out.print(w + " "));
    }

    // Task-4 : list'in en buyuk elemanini yazdiriniz

    public static void enBuyukElPrint(List<Integer> sayi) {
        Optional<Integer> maxSayi = sayi.
                stream().
                reduce(Math::max);//Eğer benim resultım tek bir değer ise o zaman reduce terminal operatörünü kullanır.
        System.out.println(maxSayi);
    }

    // Task-5 : Structural yapı ile list'in en buyuk elemanini yazdiriniz

    public static void enBuyukElPrintStructural(List<Integer> sayi) {
        int max = Integer.MIN_VALUE;
        System.out.println("max = " + max);// max.soutv
        for (int i = 0; i < sayi.size(); i++) {
            if (sayi.get(i) > max) {
                max = sayi.get(i);
            }
        }
        System.out.print("en büyük sayı : " + max);

    }

    // Task-6 : List'in cift elemanlarin karelerinin en buyugunu print ediniz

    public static void ciftElKareEnBykPrint(List<Integer> sayi) {
        System.out.println(sayi.//çıktıyı her halükarda optional olarak veriyor atama yapsak da yapmasak da
                stream().
                filter(Lambda01::ciftBul).
                map(w -> w * w).
                reduce(Integer::max)); // Math::max'a göre daha hızlı çalışır..

    }

    // Task-7: List'teki tum elemanlarin toplamini yazdiriniz.Lambda Expression...

    public static void elToplam (List<Integer> sayi){
        System.out.println(sayi.stream().reduce(0,(a,b) -> a + b)); // Integer::sum yapsak da olurdu Lambda Expression istenildiği için böyle yapıldı

        /*
    * a ilk degerini her zaman atanan degerden (ilk parametre) alır,
    bu örnekte 0 oluyor
    * b degerini her zamana  stream()'dan akısdan alır
    * a ilk degerinden sonraki her değeri action(işlem)'dan alır
        */

    }

    // Task-8 : List'teki cift elemanlarin carpimini  yazdiriniz.

    public static void ciftElCarpim (List<Integer> sayi){
        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                reduce(1, (a, b) -> a * b));//Math::multiplyExact yazarak da yapabilirdik
    }

    // Task-9 : List'teki elemanlardan en kucugunu print ediniz

    public static void minBul (List<Integer> sayi){
        //1.Yol :
        System.out.println(sayi.
                stream().
                reduce(Integer::min)); // Math::min ile de yapabiliriz. Ama listimiz Integer olduğu için daha hızlı çalışması için Integer ile kullandık
        //2.Yol :
        System.out.println(sayi.
                stream().
                reduce(Lambda02::byMiracMin));
        //3.Yol olarak da Math::min yapabiliriz.
    }

    public static int byMiracMin (int a, int b){
        return a<b ? a : b ;//Kendi methodumuzu oluşturarak reduce içerisinde kullanıp çözüme ulaşabiliriz.
    }

    //Task - 10 : List'teki 5'ten büyük en küçük tek sayiyi print ediniz.

    public static void bestenBykEnKckTekElPring (List<Integer> sayi){
        System.out.println(sayi.
                stream().
                filter(w -> (w > 5) && (w % 2 != 0)).
                reduce(Integer::min));
    }

    //Task - 11 : List'in çift elemanlarinin karelerini kucukten büyüğe print ediniz.

    public static void ciftElKareKckBykSrlPrint (List<Integer> sayi){
        sayi.
                stream().//akışı başlattık
                filter(Lambda01::ciftBul).//akış içindeki çift sayıları aldım
                map(w-> w*w).//sayıların karesi ile yeni bir akış oluşturdum
                sorted().//akış içindeki sayıları natural-order olarak sıraladım
                forEach(Lambda01::yazdir);//akışdaki sayıları ekrana yazdım
    }

}
