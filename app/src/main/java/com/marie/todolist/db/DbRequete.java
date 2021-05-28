package com.marie.todolist.db;

public class DbRequete {

    public static final String DB_NAME = "todo_list"; // le nom de la db
    public static final int DB_VERSION = 1; // la version de la db

    public static class TodoSql {
        // La classe static qui contient les infos de la table (le nom des colonnes .. )
        public static final String TABLE_NAME = "todo"; // nom du tableau
        public static final String COLUMN_ID = "_id"; // nom des colonnes
        public static final String COLUMN_NAME = "titre";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_IMPORTANCE = "importance";
        public static final String COLUMN_FINI = "fini";
    }
    // requêtes DDL pour créer le tableau et ses colonnes
    public static final String MES_REQUETES =
            "CREATE TABLE" + TodoSql.TABLE_NAME + " ( "
            + TodoSql.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + TodoSql.COLUMN_NAME + " TEXT, "
            + TodoSql.COLUMN_DATE + " TEXT, "
            + TodoSql.COLUMN_IMPORTANCE + " TEXT, "
            + TodoSql.COLUMN_FINI + " INTEGER "
            + ");";

    public static final String REQUEST_DELETE = "DROP TABLE " + TodoSql.TABLE_NAME + ";";

}
