package fr.wildcodeschool.zeuro;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Custom_Adapt extends ArrayAdapter<ForfaitModel> {
    private final Activity context;
    private final ArrayList<ForfaitModel> listForfait;
    private ProfilActivity profileActivity;

    public Custom_Adapt(Activity context, ArrayList<ForfaitModel> listForfait) {
        super(context, R.layout.list, listForfait);
        this.context = context;
        this.listForfait = listForfait;
    }

    public View getView(int posisition, View View, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list, parent, false );

        ForfaitModel m = getItem(posisition);

            TextView ptiText = (TextView) rowView.findViewById(R.id.internet);
            ImageView element = (ImageView) rowView.findViewById(R.id.icon);
            TextView apelle = (TextView) rowView.findViewById(R.id.appel);
            TextView prix   = (TextView) rowView.findViewById(R.id.prix);
            ImageView promo = (ImageView)rowView.findViewById(R.id.idPromo);

            if(m.getAppels() >= 5){
                apelle.setText("Illimité");
            }
            else {
                apelle.setText(m.getAppels().toString() + " H");
            }

            prix.setText(m.getPrix() + " €");
            if (m.getInternet() < 1000 && m.getInternet() >=0){
                ptiText.setText(m.getInternet() + " Mo");
            }
            else if (m.getInternet() >= 1000){
                int calcul = ((int) m.getInternet()) / 1000;
                ptiText.setText(calcul + " Go");
            }

            element.setImageResource(m.setPictureLogo(m.getOperateur()));

            if (m.getPromo() == 1){
                promo.setImageResource(R.drawable.promo);
            }



        return  rowView;
    }

}