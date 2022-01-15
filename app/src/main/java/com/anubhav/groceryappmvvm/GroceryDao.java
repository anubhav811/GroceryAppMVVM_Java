package com.anubhav.groceryappmvvm;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface GroceryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(GroceryItem item);

    @Delete
    void delete(GroceryItem item);

    @Query("SELECT * FROM grocery_items")
    LiveData<List<GroceryItem>> getAllItems();

}
