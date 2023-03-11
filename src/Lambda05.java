import java.util.stream.IntStream;

public class Lambda05 {


    public static void main(String[] args) {

        System.out.println(topla(5));
        System.out.println(toplaCincix(5));
        System.out.println(ciftToplm(5));
        System.out.println(ilkPztfCift(4));
        System.out.println(ilkPztfTek(4));
        ikiIlkXKuvveti(4);
        System.out.println();
        istenilenSyninKuvveti(3,4);
        System.out.println();
        istenilenFaktoriyel(2);
    }



    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar (x dahil) tamsayilari toplayan bir program create ediniz.

    //Structured Programming ile
    public static int topla(int x) {
        int toplam = 0;
        for(int i = 0; i<=x; i++){
            toplam = toplam +i;
        } return toplam;

    }

    //Functional Programming

    public static int toplaCincix(int x) {
        return IntStream.//ortada bir list olmadığı için IntStream ınterfaceni kullanıyoruz--int değerlerde bir akış sağlar.
                range(1,x+1). //range(a, b)--> a dan b'ye kadar (b dahil değil) int değerler akışa alındı. Task'de dahil istediği için ve b dahil olmadığı için x+1 yapıyoruz.
                sum(); //toplama işlemini yaptık
    }

    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.

    public static int ciftToplm (int x){
        return IntStream.
                rangeClosed(1, x).
                filter(t->t%2==0).
                sum();
    }

    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.

    public static int ilkPztfCift (int x){
        return IntStream.
                iterate(2,t->t+2).//2'den sonsuza kadar elemanları 2 artırarak akışa alır. ---> 2,4,6,8,...
                limit(x).//x ile sınırlıyorum
                sum();//akıştan gelen değerleri topluyorum
    }


    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.

    public static int ilkPztfTek (int x){
        return IntStream.
                iterate(1, t->t+2).
                limit(x).
                sum();
    }

    //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi  create ediniz.

    public static void ikiIlkXKuvveti (int x) {
        IntStream.
                iterate(2, t->t*2).//iterasyon için şartımızı yazdık
                limit(x). //x değeri ile sınırladık
                forEach(Lambda01::yazdir);//Lambda01 clasındaki yazdır methodunu kullandık
    }

    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.

    public static void istenilenSyninKuvveti (int istenenSayi, int x) {
        IntStream.
                iterate(istenenSayi, t->t*istenenSayi).
                limit(x).
                forEach(Lambda01::yazdir);
    }

    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.

    public static int istenilenFaktoriyel (int x){
        return IntStream.
                rangeClosed(1, x).
                reduce(1, (a, b) -> a * b);
    }
}
