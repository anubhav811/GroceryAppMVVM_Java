package com.anubhav.groceryappmvvm;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GroceryViewHolder extends RecyclerView.ViewHolder{
    TextView nameTv;
    TextView priceTv;
    TextView quantityTv ;
    TextView amountTv ;
    ImageView deleteIv ;
    public GroceryViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTv= itemView.findViewById(R.id.tv_itemName);
        priceTv = itemView.findViewById(R.id.tv_itemPrice);
        quantityTv = itemView.findViewById(R.id.tv_itemQuantity);
        amountTv = itemView.findViewById(R.id.tv_total);
        deleteIv = itemView.findViewById(R.id.iv_delete);
    }
}

