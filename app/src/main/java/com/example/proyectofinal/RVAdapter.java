package com.example.proyectofinal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ProductViewHolder> implements View.OnClickListener
{
    List<Products> products;
    Context context;

    private View.OnClickListener listener;

    public RVAdapter(List<Products> products, Context context){
        this.products = products;
        this.context = context;
    }


    @Override
    public void onClick(View view) {
        if( listener != null)
        {
            listener.onClick(view);
        }
    }

    @NonNull
    @Override
    public RVAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                . inflate(R.layout.product_item_layout,parent,false);

        view.setOnClickListener(this);
        //PersonaViewHolder pvh = new PersonaViewHolder(view);


        return new ProductViewHolder (view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVAdapter.ProductViewHolder holder, int position) {
        holder.txtProductName.setText(products.get(position).pname);
        holder.txtProductDescription.setText(products.get(position).description);
        //price, image, category, pid, date, time;
        holder.txtProductPrice.setText(products.get(position).price);

        Drawable original = context
                .getResources()
                .getDrawable(products.get(position).image
                        ,null);

        Bitmap originalBitmap = ((BitmapDrawable) original).getBitmap();

        RoundedBitmapDrawable roundedDrawable =
                RoundedBitmapDrawableFactory.create(context.getResources()
                        , originalBitmap);

        roundedDrawable.setCornerRadius(originalBitmap.getHeight());

        holder.imageView.setImageDrawable(roundedDrawable);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public void setOnClickListener(View.OnClickListener listener)
    {
        this.listener = listener;
    }


    public static class ProductViewHolder extends RecyclerView.ViewHolder{

        public  TextView txtProductName, txtProductDescription, txtProductPrice;
        public  ImageView imageView;

        ProductViewHolder(View itemView){
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.product_image);
            txtProductName = (TextView) itemView.findViewById(R.id.product_name);
            txtProductDescription = (TextView) itemView.findViewById(R.id.product_description);
            txtProductPrice = (TextView) itemView.findViewById(R.id.product_price);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView){
        super.onAttachedToRecyclerView(recyclerView);
    }
}
