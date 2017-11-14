package com.example.katherine.postconsumo;
import retrofit2.Call;

import java.util.List;

import retrofit2.http.GET;

/**
 * Created by katherine on 7/11/17.
 */

public interface SitiosService {
    @GET("bfv8-smrz.json")
    Call<List<Punto>> obtenerListadeSitios();

}
