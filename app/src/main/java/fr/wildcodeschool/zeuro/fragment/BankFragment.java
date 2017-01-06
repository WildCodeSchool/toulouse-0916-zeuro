package fr.wildcodeschool.zeuro.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.wildcodeschool.zeuro.R;


public class BankFragment extends Fragment {

    public BankFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {

        return inflater.inflate(R.layout.fragment_bank, container, false);
    }
}
