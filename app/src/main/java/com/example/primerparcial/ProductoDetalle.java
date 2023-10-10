package com.example.primerparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.primerparcial.api.APIClient;
import com.example.primerparcial.api.APIInterface;
import com.example.primerparcial.entidades.Producto;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductoDetalle extends AppCompatActivity {

    TextView nombre;
    TextView desc;
    TextView precio;
    RatingBar rating;
    TextView brand;
    TextView categoria;
    ImageView imagen;

    TextView stock;
    TextView discount;
    Producto producto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto_detalle);

        int productoId = getIntent().getIntExtra("productoId", -1);
        APIInterface api = APIClient.getClient().create(APIInterface.class);

        nombre = findViewById(R.id.producto_nombre);
        desc = findViewById(R.id.producto_descripcion);
        precio = findViewById(R.id.producto_precio);
        rating = findViewById(R.id.producto_rating);
        brand = findViewById(R.id.producto_brand);
        categoria = findViewById(R.id.producto_categoria);
        imagen = findViewById(R.id.producto_imagen);
        discount = findViewById(R.id.producto_discount);
        stock = findViewById(R.id.producto_stock);

        api.find(productoId).enqueue(new Callback<Producto>() {
            @Override
            public void onResponse(Call<Producto> call, Response<Producto> response) {
                producto = response.body();
                nombre.setText(producto.getTitle());
                desc.setText(producto.getDescription());
                precio.setText("Precio: " + producto.getPrice());
                rating.setRating(Float.parseFloat(producto.getRating().toString()));
                brand.setText(producto.getBrand());
                categoria.setText(producto.getCategory());
                Picasso.get().load(producto.getThumbnail()).into(imagen);
                discount.setText("Discount: " + producto.getDiscountPercentage().toString());
                stock.setText("Stock: " + producto.getStock());

            }

            @Override
            public void onFailure(Call<Producto> call, Throwable t) {

            }
        });

    }
}