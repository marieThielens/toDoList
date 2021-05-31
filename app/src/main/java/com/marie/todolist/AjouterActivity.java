package com.marie.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.marie.todolist.db.DbRequete;
import com.marie.todolist.db.TodoStructureDB;
import com.marie.todolist.models.Tache;

public class AjouterActivity extends AppCompatActivity {

    private Button btnRetourAccueil, btnValiderTache;
    private EditText inputNomTache, inputImportanceTache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter);

        // Liaison
        btnValiderTache = findViewById(R.id.btn_valider_tache);
        inputNomTache = findViewById(R.id.input_nom_ajouter);
        inputImportanceTache = findViewById(R.id.input_priorite_ajouter);


        btnValiderTache.setOnClickListener(v -> {

            Intent intent = new Intent(getApplicationContext(), MainActivity.class);

            finish();
        });


        // Intent annuler et retour page d'accueil ................
        btnRetourAccueil = findViewById(R.id.btn_retour_accueil);
        btnRetourAccueil.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);



        });
    }
}