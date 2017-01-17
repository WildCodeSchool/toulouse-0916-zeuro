package fr.wildcodeschool.zeuro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalsActivity extends AppCompatActivity {

    private Button Retour;
    private ImageView logo;
    private TextView montantPrix, resultHeure, SMS, MMS, internet, periode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detals);
        ForfaitModel aplForfait = (ForfaitModel) getIntent().getSerializableExtra("MainActivity");
        Button Retour = (Button) findViewById(R.id.idReturn);
        Retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetalsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        logo = (ImageView) findViewById(R.id.idLogo);
        logo.setImageResource(aplForfait.setPictureLogo(aplForfait.getImgoperateur()));

        montantPrix = (TextView) findViewById(R.id.montant);
        montantPrix.setText(aplForfait.getPrix().toString() + " €");


        resultHeure = (TextView) findViewById(R.id.idHeure);
        if(aplForfait.getApelle() <= 0) {
            resultHeure.setText("Illimité");
        }
        else if(aplForfait.getApelle() > 0){
            resultHeure.setText(aplForfait.getApelle().toString() + " H");
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
        internet.setText(aplForfait.getInternet().toString() + " GO");
        periode = (TextView) findViewById(R.id.Result);
        if (aplForfait.getEngagement() <= 0){
            periode.setText("Sans engagement");
        }
        else if(aplForfait.getEngagement() > 0){
            periode.setText(aplForfait.getEngagement().toString() + " mois");
        }



    }
}