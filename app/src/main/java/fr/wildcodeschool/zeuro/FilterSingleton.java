package fr.wildcodeschool.zeuro;


import android.content.Context;

import java.util.ArrayList;

import fr.wildcodeschool.zeuro.DBHandler.DBHandler;

public class FilterSingleton {
    private static FilterSingleton INSTANCE = new FilterSingleton();

    private float prixMin, prixMax;
    private int appelMin, appelMax, smsMin, smsMax, mmsMin, mmsMax, internetMin, internetMax;
    private boolean isButtonCheck;
    private ArrayList<ForfaitModel> tampon;

    private FilterSingleton() {
        this.prixMin = 0;
        this.prixMax = 50;
        this.appelMin = 0;
        this.appelMax = 5;
        this.smsMin = 0;
        this.smsMax = 1000;
        this.mmsMin = 0;
        this.mmsMax = 1000;
        this.internetMin = 0;
        this.internetMax = 50000;
        this.isButtonCheck = true;
        this.tampon = new ArrayList<>();
    }

    public ArrayList<ForfaitModel> getTampon() {
        return tampon;
    }

    public void setTampon(ArrayList<ForfaitModel> tampon) {
        this.tampon = tampon;
    }

    public void addtoTampon(ForfaitModel forfaits) {
        this.tampon.add(forfaits);
    }

    public boolean isButtonCheck() {
        return isButtonCheck;
    }

    public void setButtonCheck(boolean buttonCheck) {
        isButtonCheck = buttonCheck;
    }

    public float getPrixMin() {
        return prixMin;
    }

    public void setPrixMin(float prixMin) {
        this.prixMin = prixMin;
    }

    public float getPrixMax() {
        return prixMax;
    }

    public void setPrixMax(float prixMax) {
        this.prixMax = prixMax;
    }

    public int getAppelMin() {
        return appelMin;
    }

    public void setAppelMin(int appelMin) {
        this.appelMin = appelMin;
    }

    public int getAppelMax() {
        return appelMax;
    }

    public void setAppelMax(int appelMax) {
        this.appelMax = appelMax;
    }

    public int getSmsMin() {
        return smsMin;
    }

    public void setSmsMin(int smsMin) {
        this.smsMin = smsMin;
    }

    public int getSmsMax() {
        return smsMax;
    }

    public void setSmsMax(int smsMax) {
        this.smsMax = smsMax;
    }

    public int getMmsMin() {
        return mmsMin;
    }

    public void setMmsMin(int mmsMin) {
        this.mmsMin = mmsMin;
    }

    public int getMmsMax() {
        return mmsMax;
    }

    public void setMmsMax(int mmsMax) {
        this.mmsMax = mmsMax;
    }

    public int getInternetMin() {
        return internetMin;
    }

    public void setInternetMin(int internetMin) {
        this.internetMin = internetMin;
    }

    public int getInternetMax() {
        return internetMax;
    }

    public void setInternetMax(int internetMax) {
        this.internetMax = internetMax;
    }

    public static synchronized FilterSingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FilterSingleton();
        }

        return INSTANCE;
    }

}