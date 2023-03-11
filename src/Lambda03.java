import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Lambda03 {

    public static void main(String[] args) {

        List<String> menu = new ArrayList<>(Arrays.asList("trileçe", "havucDilim", "güveç", "kokoreç", "küşleme", "arabAşı", "waffle", "künefe","güveç"));

        alfBykTekrsz(menu);
        System.out.println();
        krktrTersSirali(menu);
        System.out.println();
        krktrKckBykElPrint(menu);
        System.out.println();
        krktrSayisi7denAzKntrl(menu);
        System.out.println();
        wIleBaslayanElKntrl(menu);
        System.out.println();
        xIleBitenElKntrl(menu);
        System.out.println();
        krktrSayisiEnBykEl(menu);
        System.out.println();
        sonHarfeGoreSirala(menu);




    }

    // Task -1 : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.

    //distinct methodu listin içerisinde ne kadar aynı eleman varsa tek eleman şeklinde yazdırıyor

    public static void alfBykTekrsz (List<String> yemek) {
        yemek.
                stream(). // akış başladı
                map(String::toUpperCase). // büyük harf
                sorted(). // doğal sıralama(alfabetik)
                distinct(). // elemanların tekrarsız olmasını sağladı
                forEach(t-> System.out.print(t + " ")); //ekrana yazdırdı
    }

    // Task -2 : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..

    //Comparator.reverseOrder ters şekilde sıralama yapar
    //distinct().//tekrarsiz > bu soru özelinde aynı karakter sayilarina sahip elemanlari tekrar etmez

    public static void krktrTersSirali (List<String> ikram) {
        ikram.
                stream().
                map(t-> t.length()).// akışı güncelledim, kelimelerin uzunluğu olarak. değerler int oldu
                sorted(Comparator.reverseOrder()). //ters sıralı
                distinct(). // tekrarsiz
                forEach(Lambda01::yazdir); // Lambda01 class'ından yazdir methodunu çağırdık int olduğu için
    }

    // Task-3 : List elemanlarini character sayisina gore kckten byk e gore print ediniz..

    public static void krktrKckBykElPrint (List<String> ikram) {
        ikram.
                stream().
                sorted(Comparator.comparing(String::length)).//küçükten büyüğe String olarak sıralamasını yapıyor-----String::length).reversed() bu ise büyükten küçüğe sıralar
                forEach(Lambda01::yazdir);//String şeklinde de yazdir methodu oluşturarak overloading yapıyoruz.
    }


    // ******************************************************************************************
    // *********************** anyMatch() *** allMatch() **** noneMatch() ************************
    //*******************************************************************************************

    //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
    //allMatch() --> tum elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
    //noneMatch()--> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.

    // Task-4 : List elemanlarinin hepsinin karakter sayisinin 7 ve 7 'den az olma durumunu kontrol ediniz.

    public static void krktrSayisi7denAzKntrl(List<String> ikram){
        System.out.println(ikram.
                stream().
                allMatch(t -> t.length() <= 7) ? "List elemanları 7 ve daha az harften oluşuyor" :
                "List elemanları 7 harften büyük");
    }

    // Task-5 : List elelmanlarinin hepsinin "w" ile baslamasını noneMatch() ile kontrol ediniz.

    public static void wIleBaslayanElKntrl(List<String> ikram){
        System.out.println(ikram.
                stream().
                noneMatch(t -> t.startsWith("w")) ? "w ile yemek ismi mi olur" :
                "w ile yemek icat ettik");
    }

    // Task-6 : List elelmanlarinin "x" ile biten en az bir elemanı kontrol ediniz.

    public static void xIleBitenElKntrl(List<String> ikram){
        System.out.println(ikram.
                stream().
                anyMatch(t -> t.endsWith("x")) ? "x ile biten yemek var" :
                "x ile biten yemek yok");
    }

    // Task-7 : Karakter sayisi en buyuk elemani yazdiriniz.

    public static void krktrSayisiEnBykEl (List<String> ikram){
        Stream<String> ilkIsim = ikram.
                stream().
                sorted(Comparator.comparing(String::length).reversed())//karakter sayısına göre tersten sıralandı.
                .limit(1);// limit methodu kullanılarak sadece ilk eleman çağrıldı.
                //limit methodunun dönen değeri Stream<String> yapıdadır.
        System.out.println(Arrays.toString(ilkIsim.toArray()));
        //ilkIsim.toArray() stream olan akış Array'e çevrildi
        //Arrays.toString --> Arrayi string yapıya çeviriyor
    }

    // Task-8 : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.

    //skip methodu atla demektir. ilk elemanı atla demiş olduk.
    public static void sonHarfeGoreSirala (List<String> ikram){
        ikram.
                stream(). // akış sağlandı
                sorted(Comparator.comparing(t->t.charAt(t.length()-1))).//son harfine göre alfabetik sıralandı
                skip(1).forEach(Lambda01::yazdir); // skip methodu akıştaki ilk eleman hariç tutuldu
    }
}
