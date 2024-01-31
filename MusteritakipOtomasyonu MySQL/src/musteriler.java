
public class musteriler {

    private String musteriIsmi;
    private String urunIsmi;
    private int urunAdedi;
    private int urunBirimFiyati;
    private int musteriBorcu;
    private int gun;
    private int ay;
    private int yil;

    public musteriler(String musteriIsmi, String urunIsmi, int urunAdedi, int urunBirimFiyati, int musteriBorcu, int gun, int ay, int yil) {
        this.musteriIsmi = musteriIsmi;
        this.urunIsmi = urunIsmi;
        this.urunAdedi = urunAdedi;
        this.urunBirimFiyati = urunBirimFiyati;
        this.musteriBorcu = musteriBorcu;
        this.gun = gun;
        this.ay = ay;
        this.yil = yil;
    }

    public String getMusteriIsmi() {
        return musteriIsmi;
    }

    public void setMusteriIsmi(String musteriIsmi) {
        this.musteriIsmi = musteriIsmi;
    }

    public String getUrunIsmi() {
        return urunIsmi;
    }

    public void setUrunIsmi(String urunIsmi) {
        this.urunIsmi = urunIsmi;
    }

    public int getUrunAdedi() {
        return urunAdedi;
    }

    public void setUrunAdedi(int urunAdedi) {
        this.urunAdedi = urunAdedi;
    }

    public int getUrunBirimFiyati() {
        return urunBirimFiyati;
    }

    public void setUrunBirimFiyati(int urunBirimFiyati) {
        this.urunBirimFiyati = urunBirimFiyati;
    }

    public int getMusteriBorcu() {
        return musteriBorcu;
    }

    public void setMusteriBorcu(int musteriBorcu) {
        this.musteriBorcu = musteriBorcu;
    }

    public int getGun() {
        return gun;
    }

    public void setGun(int gun) {
        this.gun = gun;
    }

    public int getAy() {
        return ay;
    }

    public void setAy(int ay) {
        this.ay = ay;
    }

    public int getYil() {
        return yil;
    }

    public void setYil(int yil) {
        this.yil = yil;
    }




}
