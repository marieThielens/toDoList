package com.marie.todolist.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.marie.todolist.models.Tache;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

public class TodoStructureDB {

    //  l'état actuel de l'application / objet.
    //  Il permet aux objets nouvellement créés de comprendre ce qui s'est passé
    // Il donne accès à des choses telles que les bases de données
    private Context context;
    private SQLiteDatabase db; // la representation Java de la base de données
    private DbHelper dbHelper; // mon fichier DbHelper.java

    // Constructeur
    public TodoStructureDB(Context context){
        this.context = context;
    }

    // Méthode de connexion
    public TodoStructureDB openWritable() {
        dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
        return this;
    }
    public TodoStructureDB openReadable(){
        dbHelper = new DbHelper(context);
        db = dbHelper.getReadableDatabase();
        return this;
    }
    public void close() {
        db.close();
        dbHelper.close();
    }

    // Centraliser nos interaction
    // curseurs : permet de parcourir les lignes de résultat d'une requete SELECT
    private Tache produireCurseur(Cursor c) {
       long id = c.getLong(c.getColumnIndex(DbRequete.TodoSql.COLUMN_ID));
       String titre = c.getString(c.getColumnIndex(DbRequete.TodoSql.COLUMN_TITRE));
       String date = c.getString(c.getColumnIndex(DbRequete.TodoSql.COLUMN_DATE));
       String importance = c.getString(c.getColumnIndex(DbRequete.TodoSql.COLUMN_IMPORTANCE));
       int finit = c.getInt(c.getColumnIndex(DbRequete.TodoSql.COLUMN_FINI));

       return new Tache(id, titre, date, importance, finit);
    }

    // ContentValues permet de récupérer une valeur à partir d'une clé
    // key = nom de la colonne de la db, value = la valeur qui se trouve dans la colonne
    private ContentValues creerCV(Tache tache) {
        ContentValues cv = new ContentValues();
        cv.put(DbRequete.TodoSql.COLUMN_TITRE, tache.getTitreTache()); // tache = constructeur
        cv.put(DbRequete.TodoSql.COLUMN_DATE, tache.getDateCreation());
        cv.put(DbRequete.TodoSql.COLUMN_IMPORTANCE, tache.getImportance());
        cv.put(DbRequete.TodoSql.COLUMN_FINI, tache.getFinit());

        return cv;
    }
    // create
    public long insert(Tache tache){ // tache vient de models (le constructeur )
        ContentValues cv = creerCV(tache); // créerCV(tache)
        return db.insert(DbRequete.TodoSql.TABLE_NAME, null, cv);
    }
    // Read
    public Tache getById(long id) {
        Cursor cursor = db.query(DbRequete.TodoSql.TABLE_NAME,
                null, // Toutes les colonnes
                DbRequete.TodoSql.COLUMN_ID + " = ?",
                new String[]{ String.valueOf(id)},
                null,
                null,
                null
                );
        // S'il n'y a pas de résultat
        if(cursor.getCount() ==0 ){
            return null;
        }
        cursor.moveToFirst(); // place le curseur sur l'élément trouvé
        return produireCurseur(cursor); // Renvoie le produit extrait du curseur
    }

    public List<Tache> getAll(){
        Cursor cursor = db.query(DbRequete.TodoSql.TABLE_NAME, null, null, null, null, null, null);

        List<Tache> taches = new ArrayList<>();
        if(cursor.getCount() == 0) { return taches; }

        cursor.moveToFirst();
        while(! cursor.isAfterLast()) {
            Tache t = produireCurseur(cursor);
            taches.add(t);

            cursor.moveToNext();
        }
        return taches;
    }



    // crer ma db
    public void onCreate(SQLiteDatabase db){
            db.execSQL(DbRequete.TodoSql.MES_REQUETES);
    }

}
