package com.marie.todolist.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DbRequete {

    public static final String DB_NAME = "todo_list"; // le nom de la db
    public static final int DB_VERSION = 1; // la version de la db

    public static class Tache {
        // La classe static qui contient les infos de la table (le nom des colonnes .. )
        public static final String TABLE_NAME = "todo"; // nom du tableau
        public static final String COLUMN_ID = "_id"; // nom des colonnes
        public static final String COLUMN_TITRE = "titre";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_IMPORTANCE = "importance";
        public static final String COLUMN_FINI = "fini";

    // requêtes DDL pour créer le tableau et ses colonnes
    public static final String MES_REQUETES =
            "CREATE TABLE " + Tache.TABLE_NAME + " ( "
            + Tache.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + Tache.COLUMN_TITRE + " TEXT, "
            + Tache.COLUMN_DATE + " TEXT, "
            + Tache.COLUMN_IMPORTANCE + " TEXT, "
            + Tache.COLUMN_FINI + " INTEGER "
            + ");";

    public static final String REQUEST_DELETE = "DROP TABLE " + Tache.TABLE_NAME + ";";

        private DbHelper dbHelper;
        private Context context;
        private SQLiteDatabase db;
    }
}

