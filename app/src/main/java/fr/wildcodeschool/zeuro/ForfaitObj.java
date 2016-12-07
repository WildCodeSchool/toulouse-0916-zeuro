package fr.wildcodeschool.zeuro;

/**
 * Created by apprenti on 25/11/16.
 */
import android.os.Parcelable;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.ArrayList;
public class ForfaitObj implements Serializable {
    private Integer  imgoperateur, apelle, sms, mms, internet, engagement;
    private float prix;
    public ForfaitObj( Integer imgoperateur, Integer apelle, Integer sms, Integer mms, Integer internet, Integer engagement, Float prix){
        this.imgoperateur = imgoperateur;
        this.apelle = apelle;
        this.sms = sms;
        this.mms = mms;
        this.internet = internet;
        this.engagement = engagement;
        this.prix = prix;
    }
    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public Integer getImgoperateur() {
        return imgoperateur;
    }

    public void setImgoperateur(Integer imgoperateur) {
        this.imgoperateur = imgoperateur;
    }

    public Integer getApelle() {
        return apelle;
    }

    public void setApelle(Integer apelle) {
        this.apelle = apelle;
    }

    public Integer getSms() {
        return sms;
    }

    public void setSms(Integer sms) {
        this.sms = sms;
    }

    public Integer getMms() {
        return mms;
    }

    public void setMms(Integer mms) {
        this.mms = mms;
    }

    public Integer getInternet() {
        return internet;
    }

    public void setInternet(Integer internet) {
        this.internet = internet;
    }

    public Integer getEngagement() {
        return engagement;
    }

    public void setEngagement(Integer engagement) {
        this.engagement = engagement;
    }


}
