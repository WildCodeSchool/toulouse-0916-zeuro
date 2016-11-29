package fr.wildcodeschool.zeuro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button  recherche;
    private Switch notif;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        title = (TextView) findViewById(R.id.slogan);
        notif = (Switch) findViewById(R.id.switch1);
        recherche = (Button) findViewById(R.id.rechercheButton);
        ImageButton iconeuser = (ImageButton) findViewById(R.id.imageButton);

        iconeuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rechercheIntent = new Intent(MainActivity.this, ProfilActivity.class);
                startActivity(rechercheIntent);
            }
        });
        recherche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rechercheIntent = new Intent(MainActivity.this, RechercheActivity.class);
                startActivity(rechercheIntent);
            }
        });

    }
}
