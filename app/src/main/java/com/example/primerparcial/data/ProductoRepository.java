package com.example.primerparcial.data;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.primerparcial.api.APIClient;
import com.example.primerparcial.api.APIInterface;
import com.example.primerparcial.dto.ListProducto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductoRepository {

    MutableLiveData<ListProducto> mutableLiveData = new MutableLiveData<>();

    public ProductoRepository(Application application) {
        APIInterface api = APIClient.getClient().create(APIInterface.class);
        api.findAll().enqueue(new Callback<ListProducto>() {
            @Override
            public void onResponse(Call<ListProducto> call, Response<ListProducto> response) {
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ListProducto> call, Throwable t) {

            }
        });
    }

    public MutableLiveData<ListProducto> getMutableLiveData() {
        return mutableLiveData;
    }

    public void setMutableLiveData(MutableLiveData<ListProducto> mutableLiveData) {
        this.mutableLiveData = mutableLiveData;
    }
}
