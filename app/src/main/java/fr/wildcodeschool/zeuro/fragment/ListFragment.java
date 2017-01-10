package fr.wildcodeschool.zeuro.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.zip.Inflater;

import fr.wildcodeschool.zeuro.Custom_Adapt;
import fr.wildcodeschool.zeuro.DetalsActivity;
import fr.wildcodeschool.zeuro.ForfaitObj;
import fr.wildcodeschool.zeuro.MainActivity;
import fr.wildcodeschool.zeuro.ProfilActivity;
import fr.wildcodeschool.zeuro.R;

import static android.R.attr.fragment;


public class ListFragment extends Fragment  {
    private ProfilActivity lol;
    private ListView mListeView;
    final ArrayList<ForfaitObj> listForfait = new ArrayList<>();
    private Button recherche;

    public ListFragment () {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list, container, false);
        recherche = (Button) view.findViewById(R.id.search);
        recherche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ProfilActivity.class);
                startActivity(intent);
            }
        });
        listForfait.add(new ForfaitObj(R.drawable.logo_orange,0,200,500,5,0,(float) 19.99));
        listForfait.add(new ForfaitObj(R.drawable.logo_bouygues,3,0,0,10,24,(float) 24.99));
        listForfait.add(new ForfaitObj(R.drawable.logo_sfr,5,1000,250,5,12,(float) 20.99));
        listForfait.add(new ForfaitObj(R.drawable.logo_free,6,100,0,3,0,(float) 14.99));
        listForfait.add(new ForfaitObj(R.drawable.logo_orange,1,600,100,1,24,(float) 9.99));
        mListeView = (ListView) view.findViewById(R.id.list_itemm);
        final Custom_Adapt listAdap = new Custom_Adapt(getActivity(), listForfait);
        mListeView.setAdapter(listAdap);


        mListeView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), DetalsActivity.class);
                intent.putExtra("MainActivity", listForfait.get(position));
                startActivity(intent);
            }
        });
        return view;
    }
}
