package fr.wildcodeschool.zeuro;

import android.app.Activity;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Custom_Adapt extends ArrayAdapter<ForfaitObj> {
    private final Activity context;
    private final ArrayList<ForfaitObj> listForfait;
    private ProfilActivity profileActivity;

    public Custom_Adapt(Activity context, ArrayList<ForfaitObj> listForfait) {
        super(context, R.layout.list, listForfait);
        this.context = context;
        this.listForfait = listForfait;
    }

    public View getView(int posisition, View View, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list, parent, false );

        ForfaitObj m = getItem(posisition);
        HashMap filters = ((ProfilActivity) context).hashMapReturn();
        Float ApelleMin = (Float) filters.get("ApelleMin");
        Float ApelleMax = (Float) filters.get("ApelleMax");
        Float PrixMin = (Float) filters.get("PrixMin");
        Float PrixMax = (Float) filters.get("PrixMax");
        Float DataMin = (Float) filters.get("DataMin");
        Float DataMax = (Float) filters.get("DataMax");
        Float SmsMin = (Float) filters.get("SmsMin");
        Float SmsMax = (Float) filters.get("SmsMax");

            if(ApelleMin == null|| ApelleMax == null|| PrixMin == null|| PrixMax == null|| DataMin == null|| DataMax == null|| SmsMin == null|| SmsMax == null){
                    TextView ptiText = (TextView) rowView.findViewById(R.id.internet);
                    ImageView element = (ImageView) rowView.findViewById(R.id.icon);
                    TextView apelle = (TextView) rowView.findViewById(R.id.apelle);
                    TextView prix   = (TextView) rowView.findViewById(R.id.prix);
                    if(m.getApelle() == 0){
                        apelle.setText("Illimité");
                    }
                    else if(m.getApelle() != 0){
                        apelle.setText(m.getApelle().toString() + " H");
                    }

                    prix.setText(m.getPrix().toString() + " €");
                    ptiText.setText(m.getInternet().toString() + " Go");
                    element.setImageResource(m.getImgoperateur());

                }
            else if (ApelleMin <= m.getApelle() && ApelleMax >= m.getApelle() && PrixMin <= m.getPrix() && PrixMax >= m.getPrix() && DataMin <= m.getInternet() && DataMax >= m.getInternet() && SmsMin <= m.getSms() && SmsMax >= m.getSms()){
                TextView ptiText = (TextView) rowView.findViewById(R.id.internet);
                ImageView element = (ImageView) rowView.findViewById(R.id.icon);
                TextView apelle = (TextView) rowView.findViewById(R.id.apelle);
                TextView prix   = (TextView) rowView.findViewById(R.id.prix);
                if(m.getApelle() == 0){
                    apelle.setText("Illimité");
                }
                else if(m.getApelle() != 0){
                    apelle.setText(m.getApelle().toString() + " H");
                }

                prix.setText(m.getPrix().toString() + " €");
                ptiText.setText(m.getInternet().toString() + " Go");
                element.setImageResource(m.getImgoperateur());

            }
        return  rowView;

    }

}


