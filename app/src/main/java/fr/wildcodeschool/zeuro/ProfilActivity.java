package fr.wildcodeschool.zeuro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.util.Log;
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarFinalValueListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.HashMap;

import fr.wildcodeschool.zeuro.DBHandler.DBHandler;


public class ProfilActivity extends AppCompatActivity {

    private Button buttonreturn;
    private CrystalRangeSeekbar appelSeekbar, prixSeekbar, internetSeekBar, smsSeekbar, mmsSeekbar;
    private DBHandler mDBHandler;
    private TextView timeCall, price, net, sms, mms;
    private int idAppel = 1 ;
    private int idPrix = 2 ;
    private int idInternet = 3 ;
    private int idSms = 4 ;
    private int idMms = 5 ;
    private Switch saveSwitch ;


    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        /* USELESS ?
        ArrayList<Integer[]> savelist = mDBHandler.getsavesseekbar();

        //methode pr recuperer le min de 1ere ligne (appel)
        int a = savelist.get(0)[0];

        //pr changer une valeur l'id ds seekbar
        this.mDBHandler.setValueMinEtMax(1, 1, 5);*/

        saveSwitch = (Switch) findViewById(R.id.SaveButton);
        this.mDBHandler = new DBHandler(this);
        seekbarAppel();
        seekbarPrix();
        seekbarInternet();
        seekbarSMS();
        seekbarMMS();

        saveSwitch.setChecked(FilterSingleton.getInstance().isButtonCheck());
        saveSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    FilterSingleton.getInstance().setButtonCheck(true);
                }else {
                    FilterSingleton.getInstance().setButtonCheck(false);
                }
            }
        });

        buttonreturn = (Button)findViewById(R.id.buttonret);

        buttonreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfilActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
  
    }

    public void seekbarAppel() {
        appelSeekbar = (CrystalRangeSeekbar) findViewById(R.id.idSeekAppel);
        timeCall = (TextView) findViewById(R.id.idAppel);


        final TextView tvMin = (TextView) findViewById(R.id.Appelmin);
        final TextView tvMax = (TextView) findViewById(R.id.Appelmax);

        appelSeekbar.setGap(15);
        appelSeekbar.setMinValue(0).setMaxValue(5);
        appelSeekbar.setMinStartValue(mDBHandler.getsavesseekbar().get(0)[0]).setMaxStartValue(mDBHandler.getsavesseekbar().get(0)[1]).apply();
        // set listener
        appelSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                tvMin.setText(String.valueOf(minValue));
                tvMax.setText(String.valueOf(maxValue));
                if (maxValue.intValue()==5)tvMax.setText("illimité");
            }
        });

// set final value listener
        appelSeekbar.setOnRangeSeekbarFinalValueListener(new OnRangeSeekbarFinalValueListener() {
            @Override
            public void finalValue(Number minValue, Number maxValue) {
                Log.d("CRS=>", String.valueOf(minValue) + " : " + String.valueOf(maxValue));
                if (FilterSingleton.getInstance().isButtonCheck()) {
                    mDBHandler.setValueMinEtMax(idAppel, minValue.intValue(), maxValue.intValue());
                }
                    FilterSingleton.getInstance().setPrixMin(minValue.intValue());
                    FilterSingleton.getInstance().setAppelMax(maxValue.intValue());
            }
        });
    }


    public void seekbarPrix() {
        prixSeekbar = (CrystalRangeSeekbar) findViewById(R.id.idSeekPrix);
        price = (TextView) findViewById(R.id.idPrix);

        final TextView tvMin = (TextView) findViewById(R.id.Pricemin);
        final TextView tvMax = (TextView) findViewById(R.id.Pricemax);

        prixSeekbar.setGap(10);
        prixSeekbar.setMinValue(0).setMaxValue(50).apply();
        prixSeekbar.setMinStartValue(mDBHandler.getsavesseekbar().get(1)[0]).setMaxStartValue(mDBHandler.getsavesseekbar().get(1)[1]).apply();
        // set listener
        prixSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                tvMin.setText(String.valueOf(minValue));
                tvMax.setText(String.valueOf(maxValue));
                if (maxValue.intValue()==50)tvMax.setText("50 +");
            }
        });

// set final value listener
        prixSeekbar.setOnRangeSeekbarFinalValueListener(new OnRangeSeekbarFinalValueListener() {
            @Override
            public void finalValue(Number minValue, Number maxValue) {
                Log.d("CRS=>", String.valueOf(minValue) + " : " + String.valueOf(maxValue));
                if(FilterSingleton.getInstance().isButtonCheck()){
                    mDBHandler.setValueMinEtMax(idPrix, minValue.intValue(), maxValue.intValue());
                }
                FilterSingleton.getInstance().setPrixMin(minValue.intValue());
                FilterSingleton.getInstance().setPrixMax(maxValue.intValue());
            }
        });
    }


    public void seekbarInternet() {
        internetSeekBar = (CrystalRangeSeekbar) findViewById(R.id.idSeekInternet);
        net = (TextView) findViewById(R.id.idInternet);

        final TextView tvMin = (TextView) findViewById(R.id.Internetmin);
        final TextView tvMax = (TextView) findViewById(R.id.Internetmax);

        internetSeekBar.setGap(10);
        internetSeekBar.setMinValue(0).setMaxValue(50).apply();
        internetSeekBar.setMinStartValue(mDBHandler.getsavesseekbar().get(2)[0]).setMaxStartValue(mDBHandler.getsavesseekbar().get(2)[1]).apply();
        // set listener
        internetSeekBar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                tvMin.setText(String.valueOf(minValue));
                tvMax.setText(String.valueOf(maxValue));
                if (maxValue.intValue()==50)tvMax.setText("50 +");
            }
        });

// set final value listener
        internetSeekBar.setOnRangeSeekbarFinalValueListener(new OnRangeSeekbarFinalValueListener() {
            @Override
            public void finalValue(Number minValue, Number maxValue) {
                Log.d("CRS=>", String.valueOf(minValue) + " : " + String.valueOf(maxValue));
                if(FilterSingleton.getInstance().isButtonCheck()) {
                    mDBHandler.setValueMinEtMax(idInternet, minValue.intValue(), maxValue.intValue());
                }
                FilterSingleton.getInstance().setInternetMin(minValue.intValue());
                FilterSingleton.getInstance().setInternetMax(maxValue.intValue());
            }
        });
    }

    public void seekbarSMS() {
        smsSeekbar = (CrystalRangeSeekbar) findViewById(R.id.idSeekSMS);
        sms = (TextView) findViewById(R.id.idSMS);

        final TextView tvMin = (TextView) findViewById(R.id.Smsmin);
        final TextView tvMax = (TextView) findViewById(R.id.Smsmax);

        smsSeekbar.setSteps(20);
        smsSeekbar.setGap(5);
        smsSeekbar.setMinValue(0).setMaxValue(1000).apply();
        smsSeekbar.setMinStartValue(mDBHandler.getsavesseekbar().get(3)[0]).setMaxStartValue(mDBHandler.getsavesseekbar().get(3)[1]).apply();
        // set listener
        smsSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                tvMin.setText(String.valueOf(minValue));
                tvMax.setText(String.valueOf(maxValue));
                if (maxValue.intValue()==1000)tvMax.setText("illimité");
            }
        });

// set final value listener
        smsSeekbar.setOnRangeSeekbarFinalValueListener(new OnRangeSeekbarFinalValueListener() {
            @Override
            public void finalValue(Number minValue, Number maxValue) {
                Log.d("CRS=>", String.valueOf(minValue) + " : " + String.valueOf(maxValue));
                if (FilterSingleton.getInstance().isButtonCheck()){
                    mDBHandler.setValueMinEtMax(idSms, minValue.intValue(), maxValue.intValue());
                }
                FilterSingleton.getInstance().setPrixMin(minValue.intValue());
                FilterSingleton.getInstance().setAppelMax(maxValue.intValue());
            }
        });
    }

    public void seekbarMMS() {
        mmsSeekbar = (CrystalRangeSeekbar) findViewById(R.id.idSeekMMS);
        mms = (TextView) findViewById(R.id.idMMS);

        final TextView tvMin = (TextView) findViewById(R.id.Mmsmin);
        final TextView tvMax = (TextView) findViewById(R.id.Mmsmax);

        mmsSeekbar.setSteps(20);
        mmsSeekbar.setGap(50);
        mmsSeekbar.setMinValue(0).setMaxValue(1000).apply();
        mmsSeekbar.setMinStartValue(mDBHandler.getsavesseekbar().get(4)[0]).setMaxStartValue(mDBHandler.getsavesseekbar().get(4)[1]).apply();
        // set listener
        mmsSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                tvMin.setText(String.valueOf(minValue));
                tvMax.setText(String.valueOf(maxValue));
                if (maxValue.intValue()==1000)tvMax.setText("illimité");
            }
        });

// set final value listener
        mmsSeekbar.setOnRangeSeekbarFinalValueListener(new OnRangeSeekbarFinalValueListener() {
            @Override
            public void finalValue(Number minValue, Number maxValue) {
                Log.d("CRS=>", String.valueOf(minValue) + " : " + String.valueOf(maxValue));
                if (FilterSingleton.getInstance().isButtonCheck()){
                    mDBHandler.setValueMinEtMax(idMms, minValue.intValue(), maxValue.intValue());
                }
                FilterSingleton.getInstance().setPrixMin(minValue.intValue());
                FilterSingleton.getInstance().setAppelMax(maxValue.intValue());
            }
        });
    }


}