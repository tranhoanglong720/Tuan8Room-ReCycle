package com.example.tuan8;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {User.class}, version = 1)
public abstract class UserDataBase extends RoomDatabase {
    private static final String DaTaBaSe_Name="user_db";
    private static UserDataBase instance;
    public static synchronized UserDataBase getInstance(Context context)
    {
        if(instance ==null)
        {
            instance= Room.databaseBuilder(context.getApplicationContext(),UserDataBase.class,DaTaBaSe_Name).allowMainThreadQueries().build();


        }
        return  instance;
    }
   public abstract UserDao userDao();
}
