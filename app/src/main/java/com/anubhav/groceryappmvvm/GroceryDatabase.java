package com.anubhav.groceryappmvvm;

import android.content.Context;


import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {GroceryItem.class}, version = 1)
public abstract class GroceryDatabase extends RoomDatabase {

    private static GroceryDatabase instance;

    public abstract GroceryDao getGroceryDao();

    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static synchronized GroceryDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder
                    (context.getApplicationContext(), GroceryDatabase.class
                            , "grocery_database")
                    .fallbackToDestructiveMigration()
                    .build();

        }
        return instance;
    }
}