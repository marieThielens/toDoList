package com.marie.todolist.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    // Appelle le constructeur parent avec toutes les infos nécessaire
    public DbHelper(Context context) {
        // super(context, baseDeDonne.nom, , version )
        super(context, DbRequete.DB_NAME, null, DbRequete.DB_VERSION);
    }
    // C'est là où vous devez écrire créer des instructions de table.
    // C'est ce qu'on appelle lorsque la base de données est créée
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Le script pour créer la table
        db.execSQL(DbRequete.Tache.MES_REQUETES); // Dbrequete est le fichier ou il y a mes requetes sql
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Si la version est vielle je delete ma base et je la recée ensuite
        db.execSQL((DbRequete.Tache.REQUEST_DELETE));
        onCreate(db);
    }
}
