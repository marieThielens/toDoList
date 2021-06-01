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
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView monRecycler;
    private Button btnAjouterActivity, btnToutSupprimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Base de donnée .......................
        // Initialisation du DAO pour travailler avec des produits
        TodoStructureDB todoDAO = new TodoStructureDB(getApplicationContext());

        // Création d'une tache. tache vient de models
        Tache t1 = new Tache("Faire les courses","26/09/1982", "IMPORTANT", 2);

        // Ouvrir en ecriture
        todoDAO.openWritable();
        long id = todoDAO.insert(t1);
        todoDAO.close();

        // Lecture de la db
        todoDAO.openReadable();
        List<Tache> taches =  todoDAO.getAll();
        todoDAO.close();

        // Lecture du produit avec l'id de valeur 1
        todoDAO.openReadable(); // méthode crée dans TodoStructure
        Tache t2 = todoDAO.getById(1);
        todoDAO.close();

        // RecyclerView ....................................
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
            fermerApplication(); // Sortir de l'app si l'user clique sur la fleche dans l'acitvité suivante
        });

        btnToutSupprimer = findViewById(R.id.btn_supprimer);
        btnToutSupprimer.setOnClickListener(v -> {
            // todoDAO.delete();
        });


    }
    private void fermerApplication() {
        // TODO à finir
    }

}