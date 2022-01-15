package com.anubhav.groceryappmvvm;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class GroceryRVAdapter extends RecyclerView.Adapter<GroceryViewHolder> {

    List<GroceryItem> groceryList = new ArrayList<>();
    GroceryItemClickInterface groceryItemClickInterface;
    public void setGroceryList(List<GroceryItem> groceryList) {
        this.groceryList = groceryList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public GroceryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.grocery_item,parent,false);
        GroceryViewHolder groceryViewHolder = new GroceryViewHolder(view);
        return groceryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GroceryViewHolder holder, int position) {
        GroceryItem currentItem = groceryList.get(holder.getAdapterPosition());
        holder.nameTv.setText(currentItem.itemPrice);
        holder.priceTv.setText("Rs. " + currentItem.itemPrice);
        holder.quantityTv.setText(currentItem.itemQuantity.toString());

        Integer itemTotal = currentItem.itemPrice * currentItem.itemPrice;
        holder.amountTv.setText("Rs. " + itemTotal.toString());

        holder.deleteIv.setOnClickListener(v -> {
            try {
                groceryItemClickInterface.onItemClick(currentItem);
            }catch (Exception e){
                Log.d("deleted",e.toString());
            }
            });
    }

    @Override
    public int getItemCount() {
        return groceryList.size();
    }


    public interface GroceryItemClickInterface{
        void onItemClick(GroceryItem groceryItem);
    }

}


