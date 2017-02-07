package fr.wildcodeschool.zeuro;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalsActivity extends AppCompatActivity {

    private Button Retour;
    private ImageView logo, promo;
    private TextView montantPrix, resultHeure, SMS, MMS, internet, periode, datefin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detals);
        final ForfaitModel aplForfait = (ForfaitModel) getIntent().getSerializableExtra("MainActivity");
        Button Retour = (Button) findViewById(R.id.idReturn);
        Button buttonlien = (Button) findViewById(R.id.buttonlien);
        Retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetalsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        logo = (ImageView) findViewById(R.id.idLogo);
        logo.setImageResource(aplForfait.setPictureLogo(aplForfait.getOperateur()));

        montantPrix = (TextView) findViewById(R.id.montant);
        montantPrix.setText(aplForfait.getPrix() + " €");

        buttonlien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!aplForfait.getLien().isEmpty()){
                    Uri adress = Uri.parse(aplForfait.getLien());
                    Intent intent = new Intent(Intent.ACTION_VIEW, adress);
                    startActivity(intent);
                }
            }
        });

        resultHeure = (TextView) findViewById(R.id.idHeure);
        if(aplForfait.getAppels() <= 0) {
            resultHeure.setText("Illimité");
        }
        else if(aplForfait.getAppels() > 0){
            resultHeure.setText(aplForfait.getAppels().toString() + " H");
        }
        SMS = (TextView) findViewById(R.id.idNumberSMS);
        if(aplForfait.getSms() <= 0) {
            SMS.setText("Illimité");
        }
        else if(aplForfait.getSms() > 0){
            SMS.setText(aplForfait.getSms().toString());
        }


        MMS = (TextView) findViewById(R.id.resultMMS);
        if(aplForfait.getMms() <= 0) {
            MMS.setText("Illimité");
        }
        else if (aplForfait.getMms() > 0){
            MMS.setText(aplForfait.getMms().toString());
        }

        internet = (TextView) findViewById(R.id.montantInternet);
        if (aplForfait.getInternet() < 1000 && aplForfait.getInternet() >=0){
            internet.setText(aplForfait.getInternet() + " Mo");
        }
        else if (aplForfait.getInternet() >= 1000){
            int calcul = ((int) aplForfait.getInternet()) / 1000;
            internet.setText(calcul + " Go");
        }
        periode = (TextView) findViewById(R.id.Result);
        if (aplForfait.getEngagement() <= 0){
            periode.setText("Sans engagement");
        }
        else if(aplForfait.getEngagement() > 0){
            periode.setText(aplForfait.getEngagement().toString() + " mois");
        }

        promo = (ImageView) findViewById(R.id.idPromo);
        if (aplForfait.getPromo() == 1){
            promo.setImageResource(R.drawable.promo);
        }

        datefin = (TextView) findViewById(R.id.idDatefin);
        datefin.setText(aplForfait.getFin());
    }
}