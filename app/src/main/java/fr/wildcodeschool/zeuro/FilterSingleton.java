package fr.wildcodeschool.zeuro;


public class FilterSingleton {
    private static FilterSingleton INSTANCE = new FilterSingleton();

    private float prixMin, prixMax;
    private int appelMin, appelMax, smsMin, smsMax, mmsMin, mmsMax, internetMin, internetMax;
    private boolean isButtonCheck;

    private FilterSingleton() {

        this.prixMin = prixMin;
        this.prixMax = prixMax;
        this.appelMin = appelMin;
        this.appelMax = appelMax;
        this.smsMin = smsMin;
        this.smsMax = smsMax;
        this.mmsMin = mmsMin;
        this.mmsMax = mmsMax;
        this.internetMin = internetMin;
        this.internetMax = internetMax;
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