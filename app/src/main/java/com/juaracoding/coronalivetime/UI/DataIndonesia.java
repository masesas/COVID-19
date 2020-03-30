package com.juaracoding.coronalivetime.UI;


import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.FocusFinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.juaracoding.coronalivetime.R;
import com.juaracoding.coronalivetime.ViewModel.DataIndonesiModel;
import com.juaracoding.coronalivetime.model.Indonesium;
import com.juaracoding.coronalivetime.service.APIClient;
import com.juaracoding.coronalivetime.service.APIInterfacesRest;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class DataIndonesia extends Fragment {

    private final String TAG = "DataIndonesia";
    private PieChart pieChart;
    private TextView sembuh, mati, positif;
    private ProgressDialog mProgressApp;

    public DataIndonesia() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_data_indonesia, container, false);
        pieChart = v.findViewById(R.id.indoPie);
        sembuh = v.findViewById(R.id.tvSembuh);
        mati = v.findViewById(R.id.tvMati);
        positif = v.findViewById(R.id.tvPositif);


        DataIndonesiModel viewModel = new ViewModelProvider(this,
                new ViewModelProvider.NewInstanceFactory()).get(DataIndonesiModel.class);
        viewModel.setCountryData();
        viewModel.getCountryData().observe(this, new Observer<ArrayList<Indonesium>>() {
            @Override
            public void onChanged(ArrayList<Indonesium> indonesium) {

                sembuh.setText(indonesium.get(0).getSembuh());
                mati.setText(indonesium.get(0).getMeninggal());
                positif.setText(indonesium.get(0).getPositif());

            }
        });
        return v;
    }

}
