package fr.wildcodeschool.zeuro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;


public class ProfilActivity extends AppCompatActivity {

    private Button button;
    private SeekBar appelSeekbar, prixSeekbar, internetSeekBar, smsSeekbar;
    private TextView timeCall, price, net, sms, mms;
    private int max = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        seekbarAppel();
        seekbarPrix();
        seekbarInternet();
        seekbarSMS();

        button = (Button) findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void seekbarAppel() {
        appelSeekbar = (SeekBar) findViewById(R.id.idSeekAppel);
        timeCall = (TextView) findViewById(R.id.idAppel);
        appelSeekbar.setProgress(1);
        appelSeekbar.incrementProgressBy(1);
        appelSeekbar.setMax(this.max);


        appelSeekbar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    int progress_value;

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        progress_value = progress;
                        if(progress == max){
                            timeCall.setText("Durée d'appel : illimité");
                        }else{
                            timeCall.setText("Durée d'appel : " + progress + "  h");
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );

    }

    public void seekbarPrix() {
        prixSeekbar = (SeekBar) findViewById(R.id.idSeekPrix);
        price = (TextView) findViewById(R.id.idPrix);
        prixSeekbar.setProgress(2);
        prixSeekbar.setMax(30);

        prixSeekbar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    int progress_value;

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        progress_value = progress;
                        price.setText("Prix : " + progress + "  €");
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );

    }

    public void seekbarInternet() {
        internetSeekBar = (SeekBar) findViewById(R.id.idSeekInternet);
        net = (TextView) findViewById(R.id.idInternet);
        internetSeekBar.setProgress(50);
        internetSeekBar.setMax(100);

        internetSeekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    int progress_value;

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                        progress_value = progress * 50;
                        net.setText("internet : " + progress_value + "  mo");
                        if(progress >= 1000){
                            net.setText("internet : " + progress_value + "  go");
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );

    }

    public void seekbarSMS() {
        smsSeekbar = (SeekBar) findViewById(R.id.idSeekSMS );
        sms = (TextView) findViewById(R.id.idSMS);
        smsSeekbar.setProgress(100);
        smsSeekbar.setMax(5);

        smsSeekbar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    int minimumValue = 100;
                    int progressChanged = minimumValue;
                    int progress_value;

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        progress_value = progress * 100;
                        sms.setText("SMS : " + progress_value + "  ");
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );

    }

}
