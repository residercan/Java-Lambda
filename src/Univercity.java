public class Univercity {

        /*
        TASK :
        fields --> Universite (String)
           bolum (String)
           ogrcSayisi (int)
           notOrt (int)
           olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
        */

    private String univercity;
    private String bolum;
    private int ogrcSayisi;
    private int notOrt;

    // parametresiz constructor..
    public Univercity() {
    }

    // parametreli constructor
    public Univercity(String univercity, String bolum, int ogrcSayisi, int notOrt) {
        this.univercity = univercity;
        this.bolum = bolum;
        this.ogrcSayisi = ogrcSayisi;
        this.notOrt = notOrt;
    }

    //----------------GETTER SETTER --------------------------------
    // getter methodu
    public String getUnivercity() {
        return univercity;
    }

    // setter methodu
    public void setUnivercity(String univercity) {
        this.univercity = univercity;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public int getOgrcSayisi() {
        return ogrcSayisi;
    }

    public void setOgrcSayisi(int ogrcSayisi) {
        this.ogrcSayisi = ogrcSayisi;
    }

    public int getNotOrt() {
        return notOrt;
    }

    public void setNotOrt(int notOrt) {
        this.notOrt = notOrt;
    }


    //----------------TO STRING----------------
    @Override
    public String toString() {
        return "Universite{" +
                "univercity='" + univercity + '\'' +
                ", bolum='" + bolum + '\'' +
                ", ogrcSayisi=" + ogrcSayisi +
                ", notOrt=" + notOrt +
                '}';
    }
}
