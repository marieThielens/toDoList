package com.marie.todolist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;

import com.marie.todolist.adapters.TacheAdapter;
import com.marie.todolist.db.DbHelper;
import com.marie.todolist.db.DbRequete;
import com.marie.todolist.db.TodoStructureDB;
import com.marie.todolist.models.Tache;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView monRecycler;
    private Button btnAjouterActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Partie recycler et data ............................

        // Créer mon tableau copie de tache
        ArrayList<Tache> taches = new ArrayList<>();

        // Insérer des data dans mon tableau
        taches.add(new Tache(1,"Faire les courses","26/09/1982", "IMPORTANT", 2));
        taches.add(new Tache(2,"Aller courir","25/09/1982", "Faible", 1));

        TodoStructureDB t = new TodoStructureDB(this); // gestionnaire de la table Tache
        t.openReadable();
        t.openWritable();
        t.getAll();



        // insertion.
       //  t.insert(new Tache(0,"Faire les courses","26/09/1982", "IMPORTANT", 2));




        // Liaison avec le Layout
        monRecycler = findViewById(R.id.rv_toDo); // id de mon recycler dans activity_main
        monRecycler.setHasFixedSize(false); // Si des éléments sont rajouté ou enlevé, la modification du contenu de l'adapteur ne modifie ni sa hauteur ni sa largeur

        // Creation du type de layout que le RecyclerView utilise (Linear/Grid/StraggeredGrid)
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        // va permettre de définir le type de layout de mon recycler
        monRecycler.setLayoutManager(layoutManager);

        TacheAdapter adapter = new TacheAdapter(taches); // le tableau ma tache défini plus haut
        monRecycler.setAdapter(adapter);

        // Partie Activity .................................

        btnAjouterActivity = findViewById(R.id.btn_ajout); // liaison avec le layout
        btnAjouterActivity.setOnClickListener(v -> { // au clique
            Intent intent = new Intent(getApplicationContext(), AjouterActivity.class );
            startActivity(intent);
        });


    }

}