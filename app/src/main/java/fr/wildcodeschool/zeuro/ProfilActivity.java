package fr.wildcodeschool.zeuro;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.util.Log;
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarFinalValueListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.HashMap;


public class ProfilActivity extends AppCompatActivity {

    private CrystalRangeSeekbar appelSeekbar, prixSeekbar, internetSeekBar, smsSeekbar;
    private TextView timeCall, price, net, sms, mms;
    private int max = 5;
    private Button sendData;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public static HashMap<String, Float> dataFilter = new HashMap<>();
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        seekbarAppel();
        seekbarPrix();
        seekbarInternet();
        seekbarSMS();
        sendData = (Button) findViewById(R.id.button2);
        sendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfilActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public void seekbarAppel() {
        appelSeekbar = (CrystalRangeSeekbar) findViewById(R.id.idSeekAppel);
        timeCall = (TextView) findViewById(R.id.idAppel);

        final TextView tvMin = (TextView) findViewById(R.id.Appelmin);
        final TextView tvMax = (TextView) findViewById(R.id.Appelmax);

        // set listener
        appelSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                tvMin.setText(String.valueOf(minValue));
                tvMax.setText(String.valueOf(maxValue));
            }
        });

// set final value listener
        appelSeekbar.setOnRangeSeekbarFinalValueListener(new OnRangeSeekbarFinalValueListener() {
            @Override
            public void finalValue(Number minValue, Number maxValue) {
                Log.d("CRS=>", String.valueOf(minValue) + " : " + String.valueOf(maxValue));
                dataFilter.put("ApelleMin", minValue.floatValue());
                dataFilter.put("ApelleMax", maxValue.floatValue());
            }
        });
    }


    public void seekbarPrix() {
        prixSeekbar = (CrystalRangeSeekbar) findViewById(R.id.idSeekPrix);
        price = (TextView) findViewById(R.id.idPrix);

        final TextView tvMin = (TextView) findViewById(R.id.Pricemin);
        final TextView tvMax = (TextView) findViewById(R.id.Pricemax);

        // set listener
        prixSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                tvMin.setText(String.valueOf(minValue));
                tvMax.setText(String.valueOf(maxValue));
            }
        });

        // set final value listener
        prixSeekbar.setOnRangeSeekbarFinalValueListener(new OnRangeSeekbarFinalValueListener() {
            @Override
            public void finalValue(Number minValue, Number maxValue) {
                Log.d("CRS=>", String.valueOf(minValue) + " : " + String.valueOf(maxValue));
                dataFilter.put("PrixMin", minValue.floatValue());
                dataFilter.put("PrixMax", maxValue.floatValue());
            }
        });
    }


    public void seekbarInternet() {
        internetSeekBar = (CrystalRangeSeekbar) findViewById(R.id.idSeekInternet);
        net = (TextView) findViewById(R.id.idInternet);

        final TextView tvMin = (TextView) findViewById(R.id.Internetmin);
        final TextView tvMax = (TextView) findViewById(R.id.Internetmax);

        // set listener
        internetSeekBar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                tvMin.setText(String.valueOf(minValue));
                tvMax.setText(String.valueOf(maxValue));

            }
        });

// set final value listener
        internetSeekBar.setOnRangeSeekbarFinalValueListener(new OnRangeSeekbarFinalValueListener() {
            @Override
            public void finalValue(Number minValue, Number maxValue) {
                Log.d("CRS=>", String.valueOf(minValue) + " : " + String.valueOf(maxValue));
                dataFilter.put("DataMin", minValue.floatValue());
                dataFilter.put("DataMax", maxValue.floatValue());
            }
        });
    }

    public void seekbarSMS() {
        smsSeekbar = (CrystalRangeSeekbar) findViewById(R.id.idSeekSMS);
        sms = (TextView) findViewById(R.id.idSMS);
        final TextView tvMin = (TextView) findViewById(R.id.Smsmin);
        final TextView tvMax = (TextView) findViewById(R.id.Smsmax);

        // set listener
        smsSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                tvMin.setText(String.valueOf(minValue));
                tvMax.setText(String.valueOf(maxValue));

            }
        });

// set final value listener
        smsSeekbar.setOnRangeSeekbarFinalValueListener(new OnRangeSeekbarFinalValueListener() {
            @Override
            public void finalValue(Number minValue, Number maxValue) {
                Log.d("CRS=>", String.valueOf(minValue) + " : " + String.valueOf(maxValue));
                dataFilter.put("SmsMin", minValue.floatValue());
                dataFilter.put("SmsMax", maxValue.floatValue());
            }
        });
    }
    public HashMap hashMapReturn(){
        return dataFilter;
    }
}


