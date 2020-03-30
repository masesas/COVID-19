package com.juaracoding.coronalivetime.UI;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juaracoding.coronalivetime.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DataDunia extends Fragment {


    public DataDunia() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_data_dunia, container, false);
        return v;
    }

}
