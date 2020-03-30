package com.juaracoding.coronalivetime.service;

/**
 * Created by user on 1/10/2018.
 */



import com.juaracoding.coronalivetime.UI.DataIndonesia;
import com.juaracoding.coronalivetime.coronalivetime.Provinsi;
import com.juaracoding.coronalivetime.model.Indonesium;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

 public interface APIInterfacesRest {

    @GET("indonesia/provinsi")
    Call<List<Provinsi>> getProvinsi();


    @GET("indonesia")
    Call<List<Indonesium>> getIndo();
}

