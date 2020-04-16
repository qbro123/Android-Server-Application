package com.example.drugbank.dbClient;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbSQLite extends SQLiteOpenHelper {

    public dbSQLite(@Nullable Context context, @Nullable String name, int version) {
        super(context, "Assignment", null, 1);
    }

        @Override
        public void onCreate(SQLiteDatabase db) {

    }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }
