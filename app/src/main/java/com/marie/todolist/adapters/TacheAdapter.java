package com.marie.todolist.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.marie.todolist.R;
import com.marie.todolist.models.Tache;

import java.util.ArrayList;

public class TacheAdapter extends RecyclerView.Adapter<TacheAdapter.ViewHolder> {

    private ArrayList<Tache> taches; // Je crée un tableau avec toutes mes taches
    private Context context; // Le programme dans lequel tu es

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitreItem, tvDateItem, tvImportanceItem;
        private Button btnFiniItem;

        public ViewHolder( View v) { // pour envoyer le visuel à l'adaptateur
            super(v); // Je donne ma vue à son parent

            tvTitreItem = v.findViewById(R.id.todo_item_titre);
            tvDateItem = v.findViewById(R.id.todo_item_date);
            tvImportanceItem = v.findViewById(R.id.todo_item_importance);
            btnFiniItem = v.findViewById(R.id.todo_item_btn_fini);
        }
        // getters and setters
        public TextView getTvTitreItem() { return tvTitreItem; }
        public void setTvTitreItem(TextView tvTitreItem) { this.tvTitreItem = tvTitreItem; }
        public TextView getTvDateItem() { return tvDateItem; }
        public void setTvDateItem(TextView tvDateItem) { this.tvDateItem = tvDateItem; }
        public TextView getTvImportanceItem() { return tvImportanceItem; }
        public void setTvImportanceItem(TextView tvImportanceItem) { this.tvImportanceItem = tvImportanceItem; }
        public Button getBtnFiniItem() { return btnFiniItem; }
        public void setBtnFiniItem(Button btnFiniItem) { this.btnFiniItem = btnFiniItem; }
    }
    private RecyclerView monRecycler; // Je definis la variable pour mon recycler

    // Constructeur pour créer l'adapter avec les données
    public TacheAdapter(ArrayList<Tache> taches) { // je cree
       this.taches = taches; // mon tableau TacheData recupère le tableau mesTaches
    }
    // click droit sur la premiere ligne, implements methode
    // Méthode qui permet de créer les vues contenues dans la liste utilisé par le LayoutManager
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // LayoutInflater : ajoute des elements à la barre d'action si elle est présente
        // LayoutInflater est utilisée pour instancier le fichier de mise en page XML dans les objets de vue correspondants.
        // En d'autres termes, il prend comme entrée un fichier XML et génère l'Affichage des objets
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_item, parent, false);

        // Renvoie la vue crée encapsulée dans un ViewHolder
        return new ViewHolder(v);
    }

    // Méthode qui permet de mettre à jour la vue avec les données utilisé par le layoutManager
    @Override
    public void onBindViewHolder(@NonNull TacheAdapter.ViewHolder holder, int position) {
        // Récupération des données a utiliser. Tableau tache
        Tache cible = taches.get(position); // la position de ma data

        // Mise à jour de la vue via le ViewHolder
        holder.getTvTitreItem().setText(cible.getTitreTache()); //  1. get qui vient de public ViewHolder(R.id.) 2. de mon constructeur
        holder.getTvDateItem().setText(cible.getDateCreation());
       // holder.getTvImportanceItem().setText(cible.getImportance());
    }
    @Override
    public int getItemCount() {
        return taches.size();
    }

}
