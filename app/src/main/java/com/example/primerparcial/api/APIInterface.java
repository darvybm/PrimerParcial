package com.example.primerparcial.api;

import com.example.primerparcial.dto.ListProducto;
import com.example.primerparcial.entidades.Producto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIInterface {
    @GET("products")
    Call<ListProducto> findAll();

    @GET("products/{id}")
    Call<Producto> find(@Path("id") int id);

    @GET("products/search?q={text}")
    Call<ListProducto> search(@Path("text") String text);
}
