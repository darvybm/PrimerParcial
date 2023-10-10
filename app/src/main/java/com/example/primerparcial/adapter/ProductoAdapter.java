package com.example.primerparcial.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.primerparcial.R;
import com.example.primerparcial.entidades.Producto;

import java.util.function.Consumer;

public class ProductoAdapter extends ListAdapter<Producto, ProductoAdapter.ViewHolder> {

    Consumer<Producto> productoConsumer;

    public Consumer<Producto> getProductoConsumer() {
        return productoConsumer;
    }

    public void setProductoConsumer(Consumer<Producto> productoConsumer) {
        this.productoConsumer = productoConsumer;
    }

    public ProductoAdapter(@NonNull DiffUtil.ItemCallback<Producto> universidadItemCallBack) {super(universidadItemCallBack);}

    public static class ProductoDiff extends DiffUtil.ItemCallback<Producto> {

        @Override
        public boolean areItemsTheSame(@NonNull Producto oldItem, @NonNull Producto newItem) {
            return false;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Producto oldItem, @NonNull Producto newItem) {
            return false;
        }
    }

    @NonNull
    @Override
    public ProductoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.producto_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoAdapter.ViewHolder holder, int position) {
        Producto producto = getItem(position);
        holder.bind(producto);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView producto_nombre;
        public TextView producto_desc;
        public CardView cardView;
        public ViewHolder(@NonNull View view) {
            super(view);
            producto_nombre = view.findViewById(R.id.product_name);
            producto_desc = view.findViewById(R.id.producto_desc);
            cardView = view.findViewById(R.id.cardView_item);
        }

        public void bind(Producto producto) {
            producto_nombre.setText(producto.getTitle());
            producto_desc.setText(producto.getDescription());
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (productoConsumer != null) {
                        productoConsumer.accept(producto);
                    }
                }
            });
        }
    }
}
