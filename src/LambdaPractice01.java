import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaPractice01 {


    /*
reduce()-->azaltmak ... bir cok datayi tek bir dataya(max min carp top vs islemlerde) cevirmek icin kullanilir.
kullanımı yaygındır pratiktir.
Bir Stream içerisindeki verilerin teker teker işlenmesidir. Teker teker işleme sürecinde, bir önceki adımda elde edilen sonuç
bir sonraki adıma girdi olarak sunulmaktadır. Bu sayede yığılmlı bir hesaplama süreci elde edilmiş olmaktadır.
reduce metodu ilk parametrede identity değeri, ikinci parametrede ise BinaryOperator türünden bir obj kullanılır.
reduce işleminde bir önceki hesaplanmış değer ile sıradaki değer bir işleme tabi tutulmaktadır.
İşleme başlarken bir önceki değer olmadığı için bu değer identity parametresinde tanımlanmaktadır.

    */

        public static void main(String[] args) {

            List<Integer> list = new ArrayList<>(Arrays.asList(-5, -8, -2, -12, 0, 1, 12, 5, 5, 6, 9, 15, 8));

            hepsiniYazdir(list);
            System.out.println();
            negatifYaz(list);
            System.out.println();
            ciftYaz(list);
            System.out.println();
            pozVeCift(list);
            System.out.println();
            pozVeyaCiftYaz(list);
            System.out.println();
            kareYazdir(list);
            System.out.println();
            ciftKupYazdir(list);
            System.out.println();
            kareTekrarsiz(list);
            System.out.println();
            elSirala(list);
            System.out.println();
            elTersSirala(list);
            System.out.println();
            System.out.println("pozKup5List(list) = " + pozKup5List(list));
            System.out.println();
            elPztfKarePrint(list);
            System.out.println();
            elToplam(list);
            System.out.println();
            elToplam1(list);
            System.out.println();
            System.out.println(elToplam2(list));
            System.out.println();
            elPztfToplam(list);

        }


        // S1:listi aralarinda bosluk birakarak yazdiriniz

        public static void hepsiniYazdir(List<Integer> l) {

            l.stream().forEach(t -> System.out.print(t + " "));
        }

        //S2: sadece negatif olanlari yazdir
        public static void negatifYaz(List<Integer> l) {

            l.stream().filter(t -> t < 0).forEach(t -> System.out.print(t + " "));
        }

        //S3: cift olanlardan yeni bir liste olustur
        public static void ciftYaz(List<Integer> l) {

            l.stream().filter(t -> t % 2 == 0).forEach(t -> System.out.print(t + " "));


        }

        //S4:pozitif ve çift olanları yazdırın

        public static void pozVeCift(List<Integer> l) {

            l.stream().filter(t -> t % 2 == 0 && t > 0).forEach(t -> System.out.print(t + " "));
        }

        //S5:pozitif veya çift olanları yazdırın

        public static void pozVeyaCiftYaz(List<Integer> l) {
            l.stream().filter(t -> t % 2 == 0 || t > 0).forEach(t -> System.out.print(t + " "));
        }

        // S6: list in elemanlarin karelerini aynı satırda bır bosluklu yazdıralım

        //map():stream den gelen elemanları baska ttıplere donusturmek veya uzerlerınde
        //ıslem yapmak ıcın (update) kullanılır

        public static void kareYazdir(List<Integer> l) {
            l.stream().map(t -> t * t).forEach(t -> System.out.print(t + " "));
        }

        //S7: Listin cift elemanlarının kuplerini  aynı satırda bır bosluklu yazdıralım
        public static void ciftKupYazdir(List<Integer> l) {

            l.stream().filter(t -> t % 2 == 0).map(t -> t * t * t).forEach(t -> System.out.print(t + " "));
        }

        //S8 : list in elemanlarin karelerini tekrarsiz yazdıralım
        public static void kareTekrarsiz(List<Integer> l) {

            l.stream().map(t -> t * t).distinct().forEach(t -> System.out.print(t + " "));


            //distinct() => Bu method tekrarlı elemanları sadece bir kere akısa sokar.
            // Bu akışın farklı elemanlarından (Object.equals (Object) 'e göre) oluşan bir akış döndürür.
            // Sıralı akışlar için, farklı elemanın seçimi sabittir
            // (yinelenen öğeler için, karşılaşma sırasında ilk görünen öğe korunur.)
            // Sırasız akışlar için, herhangi bir kararlılık garantisi verilmez. Stream return eder.
        }

        //S9: listin elemanlarini kucukten buyuge siralayalim

        public static void elSirala(List<Integer> l) {
            l.stream().sorted().forEach(t -> System.out.print(t + " "));
        }

        //S10: listin elemanlarini buyukten kucuge siralayalim
        public static void elTersSirala(List<Integer> l) {
            l.stream().sorted(Comparator.reverseOrder()).forEach(t -> System.out.print(t + " "));
        }

        // S11: list pozitif elemanlari icn kuplerini bulup birler basamagi 5 olanlardan yeni bir list olusturalim
        public static List<Integer> pozKup5List(List<Integer> l) {
            return l.stream().filter(t -> t > 0).map(t -> t * t * t).filter(t -> t % 10 == 5).collect(Collectors.toList());
        }

        //S12: list pozitif elemanlari icn karelerini bulup birler basamagi 5 olmayanlardan yeni bir list olusturalim

        public static void elPztfKarePrint (List<Integer> l) {
            System.out.println(l.
                    stream().
                    filter(t -> t > 0).
                    map(t -> t * t).
                    filter(t -> t % 10 != 5).
                    collect(Collectors.toList()));
        }

        // S13 :list elemanlarini toplamini bulalim

        public static void elToplam (List<Integer> l) {
            System.out.println(l.stream().reduce(0, (a, b) -> a + b));
        }

        public static void elToplam1 (List<Integer> l) {
            System.out.println(l.stream().reduce(Math::addExact));
        }

        public static int elToplam2 (List<Integer> l) {
            int i = l.stream().reduce(0, Integer::sum);
            return i;
        }

        //S14 : Listin pozitif elemanları toplamını bulalım

        public static void elPztfToplam (List<Integer> l) {
            System.out.println(l.stream().filter(t -> t > 0).reduce(Math::addExact));
        }

}


