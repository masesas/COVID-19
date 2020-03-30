package com.juaracoding.coronalivetime.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.juaracoding.coronalivetime.coronalivetime.Provinsi;
import com.juaracoding.coronalivetime.service.APIClient;
import com.juaracoding.coronalivetime.service.APIInterfacesRest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DataProvinsiModel extends ViewModel {

    private MutableLiveData<ArrayList<Provinsi>> mutableLiveData = new MutableLiveData<>();

    public void setTodayData() {
        Retrofit retrofit = APIClient.getClient();
        APIInterfacesRest apiEndpoint = retrofit.create(APIInterfacesRest.class);

        Call<List<Provinsi>> call = apiEndpoint.getProvinsi();
        call.enqueue(new Callback<List<Provinsi>>() {
            @Override
            public void onResponse(Call<List<Provinsi>> call, Response<List<Provinsi>> response) {
                mutableLiveData.setValue((ArrayList<Provinsi>) response.body());
            }

            @Override
            public void onFailure(Call<List<Provinsi>> call, Throwable t) {

            }
        });
    }

    private String getFormattedDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy", Locale.getDefault());
        return simpleDateFormat.format(yesterday());
    }

    // fetch hari kemarin
    private Date yesterday() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }

    public LiveData<ArrayList<Provinsi>> getTodayListData() {
        return mutableLiveData;
    }
}
