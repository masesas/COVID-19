package com.juaracoding.coronalivetime.UI;


import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.juaracoding.coronalivetime.R;
import com.juaracoding.coronalivetime.ViewModel.DataProvinsiModel;
import com.juaracoding.coronalivetime.adapter.AdapterListSimple;
import com.juaracoding.coronalivetime.coronalivetime.Provinsi;
import com.juaracoding.coronalivetime.model.Indonesium;
import com.juaracoding.coronalivetime.service.APIClient;
import com.juaracoding.coronalivetime.service.APIInterfacesRest;

import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class DataProvinsi extends Fragment {


    AdapterListSimple adapter;
    RecyclerView rcv;

    private ProgressDialog mProgressApp;

    public DataProvinsi() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_riwayat, container, false);
        rcv = v.findViewById(R.id.rcv);

        mProgressApp = new ProgressDialog(getActivity());
        mProgressApp.setTitle("Mohon tunggu");
        mProgressApp.setCancelable(false);
        mProgressApp.setMessage("Sedang menampilkan data...");

        adapter = new AdapterListSimple(getContext());
        rcv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rcv.setAdapter(adapter);
        loadListData();
        return v;

    }
    private void loadListData() {
        DataProvinsiModel viewModel = new ViewModelProvider(this,
                new ViewModelProvider.NewInstanceFactory()).get(DataProvinsiModel.class);
        viewModel.setTodayData();
        mProgressApp.show();
        viewModel.getTodayListData().observe(this, new Observer<ArrayList<Provinsi>>() {
            @Override
            public void onChanged(ArrayList<Provinsi> provinsi) {
                adapter.setData(provinsi);
                mProgressApp.dismiss();
            }
        });
    }

}
