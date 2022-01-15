package com.anubhav.groceryappmvvm;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class GroceryViewModel extends AndroidViewModel {
    private GroceryRepository repository;
    private LiveData<List<GroceryItem>> groceryItems;

    public GroceryViewModel(Application application) {
        super(application);
        repository= new GroceryRepository(application);
        groceryItems = repository.getAllItems();
    }


    void insert(GroceryItem item){
        repository.insert(item);
    }
    void delete(GroceryItem item){
        repository.delete(item);
    }
    LiveData<List<GroceryItem>> getAllItems() {
        return repository.getAllItems();
    }
}
