import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda04 {

    /*
    TASK :
           fields --> Universite (String)
           bolum (String)
           ogrcSayisi (int)
           notOrt (int)
           olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
     */

    /*
     Pojo(Plain Old Java Object) Class nedir
    1)Variable ları private olan (Encapsulation yapılmış olan)
    2)Bir parametresiz birde parametreli Constructor olan
    3)Getter ve Setter methodlar olan
    4)toString() methodu olan
    Class'lara kısaltma isim olarak Pojo(Plain Old Java Object) Class denir
     */

    public static void main(String[] args) {

    Univercity u01 = new Univercity("Boğaziçi", "Matematik", 571, 93);
    Univercity u02 = new Univercity("İstanbul TK", "Matematik", 600, 81);
    Univercity u03 = new Univercity("İstanbul", "Hukuk", 1400, 71);
    Univercity u04 = new Univercity("Marmara", "Bilg. Müh.", 1080, 77);
    Univercity u05 = new Univercity("Odtu", "Gemi Müh.", 333, 74);

        List<Univercity> unv = new ArrayList<>(Arrays.asList(u01, u02, u03, u04, u05));

        System.out.println("notOrt74denByk(unv) = " + notOrt74denByk(unv));
        System.out.println();
        System.out.println("matematikVarMi(unv) = " + matematikVarMi(unv));
        System.out.println();
        System.out.println("ogrcSayisiBykKckSirala(unv) = " + ogrcSayisiBykKckSirala(unv));
        matBolmleri(unv);
        enBykNtOrtPrint(unv);
        enKckNtOrtPrint(unv);
    }

    //task 01--> bütün universitelerin notOrt'larinin 74' den buyuk oldgunu kontrol eden pr create ediniz.

    public static boolean notOrt74denByk (List<Univercity> unv) {
        return unv.
                stream().// akış sağladık universiteler u01, u02, u03, u04, u05
                allMatch(t->t.getNotOrt()>74); // tüm objelerden not ortalamalarını get methodu ile çağırdık ve 74 büyük olup olmadığını kontrol ettik
    }

    //task 02-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.

    public static boolean matematikVarMi (List<Univercity> unv) {
        return unv.
                stream().
                anyMatch(t->t.getBolum(). //objelerin bölüm isimleri alındı
                        toLowerCase(). // bölüm isimlerindeki karakterler küçük harfe çevrildi
                        contains("matematik")); // mat kelimesi var mı kontrol ediliyor
    }

    //task 03-->universite'leri ogr sayilarina gore b->k siralayiniz.

    public static List<Univercity> ogrcSayisiBykKckSirala (List<Univercity> unv) {
        return unv.
                stream().
                sorted(Comparator.comparing(Univercity::getOgrcSayisi).reversed()).// universiteler öğrenci sayısına göre tersten sıralandı
                        //sebebi büyükten küçüğe sıralama istediği için reversed dedik.
                collect(Collectors.toList());//yukardan gelen stream yapıyı list yapısına döndürüyor
    }


    //task 04-->"matematik" bolumlerinin sayisini  print ediniz.

    public static void matBolmleri (List<Univercity> unv) {
        System.out.println(unv.
                stream().
                filter(t -> t.getBolum().toLowerCase().contains("matematik")).
                count());//terminal operatörüdür. kaç defa işlem yapıldığını sayar.
    }


    //task 05-->Ogrenci sayilari 550'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz.

    public static void enBykNtOrtPrint (List<Univercity> unv) {
        System.out.println(unv.
                stream().
                filter(t -> t.getOgrcSayisi() > 550).
                mapToInt(t -> t.getNotOrt()).
                max());
    }

    //task 06-->Ogrenci sayilari 1050'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.

    public static void enKckNtOrtPrint (List<Univercity>unv) {
        System.out.println(unv.
                stream().
                filter(t -> t.getOgrcSayisi() < 1050).
                mapToInt(t -> t.getNotOrt()).
                min());
    }





}
