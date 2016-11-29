package fr.wildcodeschool.zeuro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView sampleList;
    private ImageView logo;
    private Button  recherche, profil;
    private Switch notif;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setSubtitle("Using ToolBar");

        /*
        title = (TextView) findViewById(R.id.slogan);
        logo = (ImageView) findViewById(R.id.image_logo);
        notif = (Switch) findViewById(R.id.switch1);
        recherche = (Button) findViewById(R.id.rechercheButton);
        profil = (Button) findViewById(R.id.profilButton);

        recherche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rechercheIntent = new Intent(MainActivity.this, RechercheActivity.class);
                startActivity(rechercheIntent);
            }
        });
        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profilIntent = new Intent(MainActivity.this, ProfilActivity.class);
                startActivity(profilIntent);
            }
        }); **/
    }
}
