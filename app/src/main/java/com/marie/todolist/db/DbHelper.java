package com.marie.todolist.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    // Appelle le constructeur parent avec toutes les infos nécessaire
    public DbHelper(Context context) {
        super(context, DbRequete.DB_NAME, null, DbRequete.DB_VERSION);
    }
    // Méthode appelée automatiquement si l'app ne contient pas la base de donnée
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DbRequete.TodoSql.MES_REQUETES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
