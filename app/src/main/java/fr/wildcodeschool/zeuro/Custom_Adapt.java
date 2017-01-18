package fr.wildcodeschool.zeuro;

import android.app.Activity;
import android.provider.SyncStateContract;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Custom_Adapt extends ArrayAdapter<ForfaitModel> {
    private final static String TAG = "CUSTOM_ADAPT";

    private final Activity context;
    private ArrayList<ForfaitModel> listForfait;
    private ProfilActivity profileActivity;
    private ArrayList<ForfaitModel> Backup;

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

    @Override
    public @NonNull Filter getFilter() {
        return new Filter() {
            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                Log.d(TAG, "**** PUBLISHING RESULTS for: " + constraint);
                listForfait = (ArrayList<ForfaitModel>) results.values;
                Custom_Adapt.this.notifyDataSetChanged();
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                Log.d(TAG, "**** PERFORM FILTERING for: " + constraint);
                ArrayList<ForfaitModel> filteredResults = new ArrayList<ForfaitModel>();
                FilterSingleton filters = FilterSingleton.getInstance();

                for (ForfaitModel forfait : Custom_Adapt.this.listForfait ) {
                    if (forfait.getAppels() >= filters.getAppelMin() && forfait.getAppels() <= filters.getAppelMax()
                            && forfait.getPrix() >= filters.getPrixMin() && forfait.getPrix() <= filters.getPrixMax()
                            && forfait.getInternet() >= filters.getInternetMin() && forfait.getInternet() <= filters.getInternetMax()
                            && forfait.getSms() >= filters.getSmsMin() && forfait.getSms() <= filters.getSmsMax()
                            && forfait.getMms() >= filters.getMmsMin() && forfait.getMms() <= filters.getMmsMax()){
                        filteredResults.add(forfait);
                    }
                }

                FilterResults results = new FilterResults();
                results.values = filteredResults;

                return results;
            }
        };
    }

}