package com.marie.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.marie.todolist.db.DbRequete;
import com.marie.todolist.db.TodoStructureDB;
import com.marie.todolist.enums.PrioriteEnum;
import com.marie.todolist.models.Tache;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class AjouterActivity extends AppCompatActivity {

    private Button btnRetourAccueil, btnValiderTache;
    private EditText inputNomTache, inputImportanceTache, inputAjouterDate;
    private ImageView btnCalendar;
    private LocalDate dateLimite = null;
    Spinner spPriorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter);

        // Liaison
        btnValiderTache = findViewById(R.id.btn_valider_tache);
        inputNomTache = findViewById(R.id.input_nom_ajouter);
        inputImportanceTache = findViewById(R.id.input_priorite_ajouter);
        inputAjouterDate = findViewById(R.id.editText_date_limite);
        btnCalendar = findViewById(R.id.btn_calendrier);
       // spPriorite = findViewById(R.id.spinner_priorite_ajouter);


        // le calendrier  ..............
        // Désactivation de la saisie via le clavier
        inputAjouterDate.setInputType(InputType.TYPE_NULL);

        Calendar calendar = Calendar.getInstance();
        int jour = calendar.get(Calendar.DAY_OF_MONTH);
        int mois = calendar.get(Calendar.MONTH);
        int annee = calendar.get(Calendar.YEAR);

        btnCalendar.setOnClickListener(v -> {
            DatePickerDialog picker = new DatePickerDialog(AjouterActivity.this,
                    new DatePickerDialog.OnDateSetListener() { // l'utilisateur à cliqué sur une date
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                            // je récupère le contexte de l'pp > puis les ressources > la configuration > locale (langue utilisé) > la 1ere
                            Locale locale = AjouterActivity.this.getResources().getConfiguration().getLocales().get(0) ;

                            dateLimite = LocalDate.of(year, month + 1, dayOfMonth);
                            String date = dateLimite.format(DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.FRENCH));
                            inputAjouterDate.setText(date);

                            //inputAjouterDate.setText(String.format("´%s %s %S" , jour ,  mois , annee ));
                        }
                    },
                    annee, mois, jour );

            picker.show();
        });


        btnValiderTache.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            finish();
        });

        // Intent annuler et retour page d'accueil ................
        btnRetourAccueil = findViewById(R.id.btn_retour_accueil);
        btnRetourAccueil.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);

        // Spinner des priorités
//            List<String> priorites = new ArrayList<>();
//            // boucle
//            for(PrioriteEnum prioriteEnum : PrioriteEnum.values()){
//                priorites.add(prioriteEnum.getNom(getApplicationContext()));
//            }

        });
    }
}