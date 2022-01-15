package com.anubhav.groceryappmvvm;


import android.app.Application;


import androidx.lifecycle.LiveData;

import java.util.List;

public class GroceryRepository {

    private LiveData<List<GroceryItem>> itemList;
    private GroceryDao groceryDao;

    public GroceryRepository(Application application) {
        GroceryDatabase groceryDb = GroceryDatabase.getInstance(application);
        groceryDao = groceryDb.getGroceryDao();
        itemList = groceryDb.getGroceryDao().getAllItems();
    }

    void insert(GroceryItem item) {
        GroceryDatabase.databaseWriteExecutor.execute(() -> {
            groceryDao.insert(item);
        });
    }

    void delete(GroceryItem item) {
        GroceryDatabase.databaseWriteExecutor.execute(() -> {
            groceryDao.delete(item);
        });
    }

    LiveData<List<GroceryItem>> getAllItems() {
        return itemList;
    }

}
