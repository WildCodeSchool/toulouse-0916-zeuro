package fr.wildcodeschool.zeuro;


import android.app.ListFragment;
import android.os.Parcelable;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class ForfaitModel implements Serializable {
    private Integer apelle, sms, mms, internet, engagement;
    private String imgoperateur;
    private float prix;

    int imglogo;
    public ForfaitModel() {
    }

    public ForfaitModel(String imgoperateur, Integer apelle, Integer sms, Integer mms, Integer internet, Integer engagement, Float prix) {
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

    public String getImgoperateur() {
        return imgoperateur;
    }

    public void setImgoperateur(String imgoperateur) {
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

    public int setPictureLogo(String imgoperateur){
        switch(imgoperateur) {
            case "sfr":
                imglogo = R.drawable.logo_sfr;
                break;
            case "orange":
                imglogo = R.drawable.logo_orange;
                break;
            case "bouygues":
                imglogo = R.drawable.logo_bouygues;
                break;
            case "reglo":
                imglogo = R.drawable.logo_reglo;
                break;
            case "nrj":
                imglogo = R.drawable.logo_nrj;
                break;
            case "lyca":
                imglogo = R.drawable.logo_lyca;
                break;
            case "numericable":
                imglogo = R.drawable.logo_numericable;
                break;
            case "red":
                imglogo = R.drawable.logo_red;
                break;
            case "sosh":
                imglogo = R.drawable.logo_sosh;
                break;
            case "free":
                imglogo = R.drawable.logo_free;
                break;
            case "beyou":
                imglogo = R.drawable.logo_beyou;
                break;
            case "afone":
                imglogo = R.drawable.logo_afone;
                break;
            case "auchan":
                imglogo = R.drawable.logo_auchan;
                break;
            case "budget":
                imglogo = R.drawable.logo_budget;
                break;
            case "cofidis":
                imglogo = R.drawable.logo_cofidis;
                break;
            case "carrefour":
                imglogo = R.drawable.logo_carrefour;
                break;
            case "cic":
                imglogo = R.drawable.logo_cic;
                break;
            case "coriolis":
                imglogo = R.drawable.logo_coriolis;
                break;
            case "credit":
                imglogo = R.drawable.logo_credit;
                break;
            case "laposte":
                imglogo = R.drawable.logo_laposte;
                break;
            case "m6":
                imglogo = R.drawable.logo_m6;
                break;
            case "prixtel":
                imglogo = R.drawable.logo_prixtel;
                break;
            case "simplus":
                imglogo = R.drawable.logo_simplus;
                break;
            case "syma":
                imglogo = R.drawable.logo_syma;
                break;
            case "lebara":
                imglogo = R.drawable.logo_lebara;
                break;
            default:
                imglogo = R.drawable.logo_tel;
        }
        return  imglogo;
    }
}