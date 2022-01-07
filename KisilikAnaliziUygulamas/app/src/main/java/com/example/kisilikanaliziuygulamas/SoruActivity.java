package com.example.kisilikanaliziuygulamas;

public class SoruActivity {

    private String soru;
    private String secenek1;
    private String secenek2;
    private String secenek3;
    private String secenek4;
    private String cevap1;
    private String cevap2;
    private String cevap3;
    private String cevap4;

    public SoruActivity(String soru, String secenek1, String secenek2, String secenek3, String secenek4, String cevap1, String cevap2,String cevap3,String cevap4) {
        this.soru = soru;
        this.secenek1 = secenek1;
        this.secenek2 = secenek2;
        this.secenek3 = secenek3;
        this.secenek4 = secenek4;
        this.cevap1 = cevap1;
        this.cevap2 = cevap2;
        this.cevap3 = cevap3;
        this.cevap4 = cevap4;
    }

    public String getSoru() { return soru;}

    public void setSoru(String soru) {
        this.soru = soru;
    }

    public String getSecenek1() {
        return secenek1;
    }

    public void setSecenek1(String Secenek1) {
        this.secenek1 = secenek1;
    }

    public String getSecenek2() {
        return secenek2;
    }

    public void setSecenek2(String secenek2) {
        this.secenek2 = secenek2;
    }

    public String getSecenek3() {
        return secenek3;
    }

    public void setSecenek3(String secenek3) {
        this.secenek3 = secenek3;
    }

    public String getSecenek4() {
        return secenek4;
    }

    public void setSecenek4(String secenek4){this.secenek4 = secenek4;}

    public String getCevap1() {
        return cevap1;
    }

    public void setCevap1(String cevap1) {
        this.cevap1 = cevap1;
    }

    public String getCevap2() {
        return cevap2;
    }

    public void setCevap2(String cevap2) {
        this.cevap2 = cevap2;
    }

    public String getCevap3() {
        return cevap3;
    }

    public void setCevap3(String cevap3) {this.cevap3 = cevap3;}

    public String getCevap4() {
        return cevap4;
    }

    public void setCevap4(String cevap2) {
        this.cevap4 = cevap4;
    }
}
