package com.example.primerparcial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.primerparcial.adapter.ProductoAdapter;
import com.example.primerparcial.data.ProductoViewModel;
import com.example.primerparcial.entidades.Producto;

import java.util.function.Consumer;

public class MainActivity extends AppCompatActivity {

    private ProductoViewModel productoViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productoViewModel = new ViewModelProvider(this).get(ProductoViewModel.class);

        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 1));

        ProductoAdapter productoAdapter = new ProductoAdapter(new ProductoAdapter.ProductoDiff());

        recyclerView.setAdapter(productoAdapter);
        productoViewModel.getAllProductos().observe(this, listProducto -> {
            productoAdapter.submitList(listProducto.getProductos());
        });

        productoAdapter.setProductoConsumer(new Consumer<Producto>() {
            @Override
            public void accept(Producto producto) {
                Intent intent = new Intent(MainActivity.this, ProductoDetalle.class);
                intent.putExtra("productoId", producto.getId());
                startActivity(intent);
            }
        });

    }


}