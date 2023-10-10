package com.example.primerparcial.data;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.primerparcial.dto.ListProducto;

public class ProductoViewModel extends AndroidViewModel {

    private ProductoRepository productoRepository;
    private MutableLiveData<ListProducto> mutableLiveData;
    public ProductoViewModel(@NonNull Application application) {
        super(application);
        productoRepository = new ProductoRepository(application);
        mutableLiveData = productoRepository.getMutableLiveData();
    }

    public MutableLiveData<ListProducto> getAllProductos() {
        return mutableLiveData;
    }
}
