package com.example.nursahmelis.teknikservis;
import java.io.Serializable;
public class ServisKayit implements Serializable{
    private String isletmeAdi;
    private String cihazAdi;
    private String arizaTanimi;
    private String cihazKodu;
    public ServisKayit() {
    }

    public ServisKayit(String isletmeAdi, String cihazAdi, String arizaTanimi, String cihazKodu) {
        this.isletmeAdi = isletmeAdi;
        this.cihazAdi = cihazAdi;
        this.arizaTanimi = arizaTanimi;
        this.cihazKodu = cihazKodu;
    }

    public String getArizaTanimi() {
        return arizaTanimi;
    }

    public void setArizaTanimi(String arizaTanimi) {
        this.arizaTanimi = arizaTanimi;
    }

    public String getCihazKodu() {
        return cihazKodu;
    }

    public void setCihazKodu(String cihazKodu) {
        this.cihazKodu = cihazKodu;
    }
    public String getIsletmeAdi() {
        return isletmeAdi;
    }
    public void setIsletmeAdi(String isletmeAdi) {
        this.isletmeAdi = isletmeAdi;
    }
    public String getCihazAdi() {
        return cihazAdi;
    }
    public void setCihazAdi(String cihazAdi) {
        this.cihazAdi = cihazAdi;
    }
}