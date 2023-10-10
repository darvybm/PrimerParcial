package com.example.primerparcial.dto;

import com.example.primerparcial.entidades.Producto;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ListProducto implements Serializable {

    @SerializedName("products")
    List<Producto> productos;

    @SerializedName("total")
    int total;

    @SerializedName("limit")
    int limit;

    public ListProducto(List<Producto> productos, int total, int limit) {
        this.productos = productos;
        this.total = total;
        this.limit = limit;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
