package com.example.macstudent.thunder;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by macstudent on 2018-04-06.
 */

public class DBHelper extends SQLiteOpenHelper {
    private final static String DB_NAME = "ThunderDB";
    private final static String TB_NAME = "UserInfo";

    public DBHelper(Context context) {

        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            String CREATE_TABLE = "CREATE TABLE " + TB_NAME + " (ID INTEGER AUTO_INCREMENT," +
                    "Name VARCHAR(100), Phone VARCHAR(30)," +
                    "Email VARCHAR(100) PRIMARY KEY, " +
                    "Password VARCHAR(30)," +
                    "DOB VARCHAR(10))" ;
            Log.v("On create table : ", CREATE_TABLE);

            db.execSQL(CREATE_TABLE);

        }catch(Exception e){
            Log.e("DBHelper", e.getMessage());

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int olderVersion, int newVersion) {
        try {
            db.execSQL("DROP TABLE IF EXISTS " + TB_NAME);
            onCreate(db);
        }catch (Exception e){
            Log.e("DBHelper", e.getMessage());
        }

    }
}
