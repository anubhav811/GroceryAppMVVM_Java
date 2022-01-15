package com.anubhav.groceryappmvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;



public class MainActivity extends AppCompatActivity {

   private GroceryViewModel groceryViewModel;
   private final GroceryRVAdapter groceryRVAdapter= new GroceryRVAdapter();;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        FloatingActionButton floatingActionButton = findViewById(R.id.addFAB);


        recyclerView.setAdapter(groceryRVAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        groceryViewModel = new ViewModelProvider(this).get(GroceryViewModel.class);
        groceryViewModel.getAllItems().observe(this, groceryItems -> groceryRVAdapter.setGroceryList(groceryItems));


        floatingActionButton.setOnClickListener(v -> openDialog());

        groceryRVAdapter.groceryItemClickInterface = groceryItem -> {
            groceryViewModel.delete(groceryItem);
            groceryRVAdapter.notifyDataSetChanged();
            Log.d("ADsd", groceryItem.itemName + groceryItem.itemQuantity.toString());
        };


    }


    void  openDialog(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.grocery_add_dialog);
        Button cancelBtn = dialog.findViewById(R.id.btnCancel);
        Button addBtn = dialog.findViewById(R.id.btnAdd);
        EditText etItemName = dialog.findViewById(R.id.etItemName);
        EditText etItemPrice = dialog.findViewById(R.id.etItemPrice);
        EditText etItemQuantity = dialog.findViewById(R.id.etItemQuantity);

        cancelBtn.setOnClickListener(v -> dialog.dismiss());

        addBtn.setOnClickListener(v -> {
            String itemName = etItemName.getText().toString();
            String itemPrice = etItemPrice.getText().toString();
            String itemQuantity = etItemQuantity.getText().toString();

            Integer qty = Integer.valueOf(itemQuantity);
            Integer price = Integer.valueOf(itemPrice);

            if(itemName!="" && itemPrice!="" && itemQuantity!=""){
                GroceryItem item = new GroceryItem(itemName,qty,price);
                groceryViewModel.insert(item);
                Toast.makeText(getApplicationContext(),"Item Inserted..",Toast.LENGTH_SHORT).show();
                groceryRVAdapter.notifyDataSetChanged();
                dialog.dismiss();
            }
            else{
                Toast.makeText(getApplicationContext(),"Fill all the fields",Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }

}

