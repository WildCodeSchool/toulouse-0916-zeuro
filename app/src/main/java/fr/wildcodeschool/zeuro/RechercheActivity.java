package fr.wildcodeschool.zeuro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.io.Serializable;

public class RechercheActivity extends AppCompatActivity {
    public static final String FORFAIT = "fr.wildcodeschool.zeuro.FORFAIT";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recherche_activity);
        ForfaitObj orange1 = new ForfaitObj(R.drawable.logo_orange,0,200,500,5,0,(float) 19.99);
        ForfaitObj orange2 = new ForfaitObj(R.drawable.logo_bouygues,3,0,0,10,24,(float) 24.99);
        ForfaitObj orange3 = new ForfaitObj(R.drawable.logo_sfr,5,1000,250,5,12,(float) 20.99);
        ForfaitObj orange4 = new ForfaitObj(R.drawable.logo_free,6,100,0,3,0,(float) 14.99);
        ForfaitObj orange5 = new ForfaitObj(R.drawable.logo_orange,1,600,100,1,24,(float) 9.99);
        final ForfaitObj[] myForfait = {orange1, orange2, orange3, orange4, orange5};
        ListAdapter listAdap = new Custom_Adapt(this, myForfait);
        final ListView mListeView = (ListView) findViewById(R.id.offerList);
        mListeView.setAdapter(listAdap);

        mListeView.setOnItemClickListener(


                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick (AdapterView<?> parent, View v, int posisition, long id) {
                        Intent intent = new Intent(RechercheActivity.this, DetalsActivity.class);

                        Bundle myBundle = new Bundle();
                        myBundle.putSerializable(FORFAIT, (Serializable) myForfait[posisition]);
                        intent.putExtras(myBundle);
                        startActivity(intent);
                    }});
    }
}
