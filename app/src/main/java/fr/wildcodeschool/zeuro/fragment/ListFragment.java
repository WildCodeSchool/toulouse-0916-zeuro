package fr.wildcodeschool.zeuro.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import fr.wildcodeschool.zeuro.Custom_Adapt;
import fr.wildcodeschool.zeuro.DetalsActivity;
import fr.wildcodeschool.zeuro.FilterSingleton;
import fr.wildcodeschool.zeuro.ForfaitModel;
import fr.wildcodeschool.zeuro.ProfilActivity;
import fr.wildcodeschool.zeuro.R;


public class ListFragment extends Fragment  {
    private final String TAG = "result";
    private ListView mListeView;
    private ArrayList<ForfaitModel> listForfait = new ArrayList<>();
    private Number appelmin = FilterSingleton.getInstance().getAppelMin();
    private Number appelmax = FilterSingleton.getInstance().getAppelMax();
    private Number prixmin = FilterSingleton.getInstance().getPrixMin();
    private Number prixmax = FilterSingleton.getInstance().getPrixMax();
    private Number smsmin = FilterSingleton.getInstance().getSmsMin();
    private Number smsmax = FilterSingleton.getInstance().getSmsMax();
    private Number mmsmin = FilterSingleton.getInstance().getMmsMin();
    private Number mmsmax = FilterSingleton.getInstance().getMmsMax();
    private Number internetmin = FilterSingleton.getInstance().getInternetMin();
    private Number internetmax = FilterSingleton.getInstance().getInternetMax();


    // Write a message to the database
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    DatabaseReference myRef = database.child("forfaits");

    public ListFragment () {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list, container, false);
        mListeView = (ListView) view.findViewById(R.id.list_itemm);
        // Read from the database
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {
                Log.d(TAG, "onChildAdded:" + dataSnapshot.getKey());

                ForfaitModel forfait = dataSnapshot.getValue(ForfaitModel.class);


                if (forfait.getAppels() >= appelmin.intValue() && forfait.getAppels() <= appelmax.intValue()
                        && forfait.getPrix() >= prixmin.intValue() && forfait.getPrix() <= prixmax.intValue()
                        && forfait.getInternet() >= internetmin.intValue() && forfait.getInternet() <= internetmax.intValue()
                        && forfait.getSms() >= smsmin.intValue() && forfait.getSms() <= smsmax.intValue()
                        && forfait.getMms() >= mmsmin.intValue() && forfait.getMms() <= mmsmax.intValue()) {
                    listForfait.add(forfait);
                }
                final Custom_Adapt listAdap = new Custom_Adapt(getActivity(), listForfait);
                Collections.sort(listForfait, new Comparator<ForfaitModel>() {
                    @Override
                    public int compare(ForfaitModel o1, ForfaitModel o2) {
                        float a =  o1.getPrix() * 100;
                        float b =  o2.getPrix() * 100;
                        return (int)( a - b);
                    }
                });


                mListeView.setAdapter(listAdap);

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String previousChildName) {
                Log.d(TAG, "onChildChanged:" + dataSnapshot.getKey());

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Log.d(TAG, "onChildRemoved:" + dataSnapshot.getKey());

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String previousChildName) {
                Log.d(TAG, "onChildMoved:" + dataSnapshot.getKey());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "postComments:onCancelled", databaseError.toException());
                Toast.makeText(getActivity(), "Failed to load forfaits.",
                        Toast.LENGTH_SHORT).show();
            }
        });




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