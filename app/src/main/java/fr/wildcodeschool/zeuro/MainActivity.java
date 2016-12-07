package fr.wildcodeschool.zeuro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class MainActivity extends AppCompatActivity {
    private Button result;
    private  ListView mListeView;
    static protected String FORFAIT = "fr.wildcodeschool.zeuro.FORFAIT";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListeView = (ListView) findViewById(R.id.list_itemm);
        final ArrayList<ForfaitObj> listForfait = new ArrayList<>();
        listForfait.add(new ForfaitObj(R.drawable.logo_orange,0,200,500,5,0,(float) 19.99));
        listForfait.add(new ForfaitObj(R.drawable.logo_bouygues,3,0,0,10,24,(float) 24.99));
        listForfait.add(new ForfaitObj(R.drawable.logo_sfr,5,1000,250,5,12,(float) 20.99));
        listForfait.add(new ForfaitObj(R.drawable.logo_free,6,100,0,3,0,(float) 14.99));
        listForfait.add(new ForfaitObj(R.drawable.logo_orange,1,600,100,1,24,(float) 9.99));
        result = (Button) findViewById(R.id.rechercheButton);
        final ListAdapter listAdap = new Custom_Adapt(this, listForfait);
        mListeView.setAdapter(listAdap);
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(listForfait, new Comparator<ForfaitObj>() {
                    @Override
                    public int compare(ForfaitObj tc1, ForfaitObj tc2) {
                        return (int) (tc1.getPrix() - tc2.getPrix());
                    }
                });
                listAdap.notif();
            }
        });
        mListeView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick (AdapterView<?> parent, View v, int posisition, long id) {
                        Intent intent = new Intent(MainActivity.this, DetalsActivity.class);
                        intent.putExtra("MainActivity", listForfait.get(posisition));
                        startActivity(intent);
                    }});


    }

}
