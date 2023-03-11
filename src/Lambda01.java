import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01 {
    public static void main(String[] args) {

        /*
        1)  Lambda --> mathod create  etme değil mevcut method'ları(library)secip kullanmaktır...
          Lambda'lar sayesinde daha az kod ve hızlı geliştirme sağlanabilmektedir.
      2) "Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
          "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
      3)  "Functional Programming" hiz, code kisaligi, code okunabilirligi
          ve hatasiz code yazma acilarindan cok faydalidir.
      4)  Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak map'lerde kullanılmaz.
         */

        List<Integer> sayi = new ArrayList<>(Arrays.asList(34, 22, 16, 11, 35, 20, 63, 21, 65, 44, 66, 64, 81, 38, 15));

        //TASK  : "Structured Programming" kullanarak list elemanlarını aynı satirda
        // aralarında bosluk olacak sekilde print ediniz.

        printElStructured(sayi);

        //TASK  : "functional Programming" kullanarak list elemanlarını aynı satirda aralarında bosluk olacak sekilde print ediniz.

        System.out.println();


        printElFunctional(sayi);

        System.out.println();

        printElFunctional1(sayi);

        System.out.println();

        printElFunctional2(sayi);

        System.out.println();

        //TASK  : Functional Programming ile list elemanlarinin  cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.

        printCiftElFunctional(sayi);

        System.out.println();

        printCiftElFunctional1(sayi);

        System.out.println();

        //TASK  : Structured Programming ile list elemanlarinin  cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.

        printCiftElStructural(sayi);

        System.out.println();

        //TASK :functional Programming ile list elemanlarinin 34 den kucuk cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.

        printCiftOtzKckFunctional(sayi);

        System.out.println();

        //TASK :structural Programming ile list elemanlarinin 34 den kucuk cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.

        printCiftOtzKckStructural(sayi);

        System.out.println();

        //Task : functional Programming ile list elemanlarinin 34 den buyk veya cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.

        printCiftOtzBykFunctional(sayi);

        System.out.println();

        //Task : structural Programming ile list elemanlarinin 34 den buyk veya cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.

        printCiftOtzBykStructural(sayi);

    }

    public static void printElStructured(List<Integer> sayi){
        for(Integer w: sayi){
            System.out.print(w + " ");
        }

    }

    public static void printElFunctional(List<Integer> sayi){
        sayi.stream().forEach((w)-> System.out.print(w + " "));//lambda expression
    }

    public static void printElFunctional1(List<Integer> sayi){
        sayi.stream().forEach(System.out::print);//method referance
    }

    // ---> kendimiz bir method oluşturalım

    public static void yazdir(int a){
        System.out.print(a + " ");
    }
    public static void yazdir(String a){
        System.out.print(a + " ");
    }
    public static void printElFunctional2(List<Integer> sayi){
        sayi.stream().forEach(Lambda01::yazdir);//method referance
    }

    public static void printCiftElFunctional(List<Integer> sayi){
        sayi.stream().filter(w -> w % 2==0).forEach(Lambda01::yazdir);//method referance
    }

    //yukarıdaki task'i filter() kısmını method referance ile yapalım

    public static boolean ciftBul(int a){
        return a % 2 ==0;
    }

    public static void printCiftElFunctional1(List<Integer> sayi){
        sayi.stream().filter(Lambda01::ciftBul).forEach(Lambda01::yazdir);//method referance
    }



    public static void printCiftElStructural(List<Integer> sayi){
        for(Integer w: sayi){
            if(w % 2==0){
                System.out.print(w + " ");//lambda expression
            }
        }
    }

    public static void printCiftOtzKckFunctional(List<Integer> sayi){
        sayi.stream().filter(w -> w < 34 && w % 2 == 0).forEach(Lambda01::yazdir);
    }

    public static void printCiftOtzKckStructural(List<Integer> sayi){
        for(Integer w: sayi){
            if(w<34 && w % 2 == 0){
                System.out.print(w + " ");
            }
        }
    }

    public static void printCiftOtzBykFunctional(List<Integer> sayi){
        sayi.stream().filter(w->w > 34 || w % 2 == 0).forEach(Lambda01::yazdir);
    }

    public static void printCiftOtzBykStructural(List<Integer> sayi){
        for(Integer w: sayi){
            if(w>34 || w % 2 == 0){
                System.out.print(w + " ");
            }
        }
    }


}
