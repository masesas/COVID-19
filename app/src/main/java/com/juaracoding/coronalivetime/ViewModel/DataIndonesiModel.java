package com.juaracoding.coronalivetime.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.juaracoding.coronalivetime.model.Indonesium;
import com.juaracoding.coronalivetime.service.APIClient;
import com.juaracoding.coronalivetime.service.APIInterfacesRest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DataIndonesiModel extends ViewModel {

    private MutableLiveData<ArrayList<Indonesium>> mutableLiveData = new MutableLiveData<>();

    public void setCountryData() {

        Retrofit retrofit = APIClient.getClient();
        APIInterfacesRest api =retrofit.create(APIInterfacesRest.class);
        Call<List<Indonesium>> call = api.getIndo();
        call.enqueue(new Callback<List<Indonesium>>() {
            @Override
            public void onResponse(Call<List<Indonesium>> call, Response<List<Indonesium>> response) {
                mutableLiveData.setValue((ArrayList<Indonesium>) response.body());
            }

            @Override
            public void onFailure(Call<List<Indonesium>> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<Indonesium>> getCountryData() {
        return mutableLiveData;
    }
}
