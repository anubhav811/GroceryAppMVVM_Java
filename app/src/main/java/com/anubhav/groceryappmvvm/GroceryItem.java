package com.anubhav.groceryappmvvm;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.PrimaryKey;

@Entity(tableName = "grocery_items")
public class GroceryItem {


    @ColumnInfo(name = "itemName")
    String itemName;

    @ColumnInfo(name="itemQuantity")
    Integer itemQuantity;

    @ColumnInfo(name="itemPrice")
    Integer itemPrice;

    @PrimaryKey(autoGenerate = true)
    Integer id;


    public GroceryItem(String itemName,Integer itemQuantity,Integer itemPrice){
        this.itemName=itemName;
        this.itemQuantity=itemQuantity;
        this.itemPrice=itemPrice;
    }
}

