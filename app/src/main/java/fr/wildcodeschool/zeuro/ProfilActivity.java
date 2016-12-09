package fr.wildcodeschool.zeuro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;

public class ProfilActivity extends AppCompatActivity {
    private SeekBar test;
    private TextView testText;

    private int[] prixForfait;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        seekbarPrix();
    }



    public void seekbarPrix() {
        test = (SeekBar) findViewById(R.id.test);
        testText = (TextView) findViewById(R.id.testText);
        ArrayList<ForfaitObj> m = (ArrayList<ForfaitObj>) getIntent().getSerializableExtra(MainActivity.FORFAIT);
        for (int i = 0; i < m.size(); i++) {
            prixForfait[i] = (Math.round(m.get(i).getPrix()));
            test.setMax(prixForfait[i]);

        }

        test.setOnSeekBarChangeListener(

                new SeekBar.OnSeekBarChangeListener() {

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                        testText.setText("prix " + progress + " €");
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
    }
}


