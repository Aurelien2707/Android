package com.example.pullmoch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pullmoch.modele.Pull;

import java.text.BreakIterator;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView nomPull;
    private Button bPrecedent;
    private Button bSuivant;
    private ArrayList<Pull> modele = new ArrayList<>();
    private int noPullCourant;
    private ImageView image_pull;
    private ImageView image_pull2;
    private TextView titre;
    private TextView description;
    private TextView prix;
    private ImageButton panier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState != null) {
            this.noPullCourant = savedInstanceState.getInt("noPull");
            this.modele = (ArrayList<Pull>) savedInstanceState.getSerializable("liste");
        } else {
//Création des 5 pulls dans la liste
            Pull p0 = new Pull("A Noël c\'est moi qui tient les rennes", "Un pull de rennes qui ravira les petits et les grands. Tricoté par d\'authentiques grand-meres Australiennes, en laine 100% coton naturel issue d\'une filière agriculture durable certifiée ISO-2560.", 19.5, "pull_renne");
            Pull p1 = new Pull("A Noël c\'est moi qui tient les chiens", "Un pull de chien qui ravira les petits et les grands. Tricoté par d\'authentiques grand-meres Australiennes, en laine 100% coton naturel issue d\'une filière agriculture durable certifiée ISO-2560.", 25, "pere_noel");
            Pull p2 = new Pull("A Noël c\'est nous qui tennons les rennes", "Un pull doublement plus moche qui ravira les petits et les grands. Tricoté par d\'authentiques grand-meres Australiennes, en laine 100% coton naturel issue d\'une filière agriculture durable certifiée ISO-2560.", 30, "pull_lutin");
            Pull p3 = new Pull("A Noël c\'est moi qui tient les lamas", "Un pull de lama qui ravira les petits et les grands. Tricoté par d\'authentiques grand-meres Australiennes, en laine 100% coton naturel issue d\'une filière agriculture durable certifiée ISO-2560.", 2, "pull_ours");
            Pull p4 = new Pull("A Noël c\'est moi qui tient les sapins", "Un pull de sapin qui ravira les petits et les grands. Tricoté par d\'authentiques grand-meres Australiennes, en laine 100% coton naturel issue d\'une filière agriculture durable certifiée ISO-2560.", 10.3, "pull_pinguin");


            modele.add(p0);
            modele.add(p1);
            modele.add(p2);
            modele.add(p3);
            modele.add(p4);

            noPullCourant = 0;

        }
    }

    public void changement(Context context){
        // Changement img
        int id = context.getResources().getIdentifier(
            this.modele.get(noPullCourant).getImage(),
            "drawable",
            context.getPackageName());
        this.image_pull.setImageResource(id);
        this.image_pull2.setImageResource(id);
        // Changement titre
        this.titre.setText(this.modele.get(noPullCourant).getTitre());
        // Changement desc
        this.description.setText(this.modele.get(noPullCourant).getDescription());
        // Changement prix
        this.prix.setText(String.valueOf(this.modele.get(noPullCourant).getTarif()));
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("noPull", this.noPullCourant);
        outState.putSerializable("liste", this.modele);
    }

    public void displayMsg(int str) {
        Toast.makeText(this, "Le pull N°" + String.valueOf(str)+" a été ajouter au panier", Toast.LENGTH_SHORT).show();
    }


    public void onStart() {
        super.onStart();
        this.bPrecedent = this.findViewById(R.id.btnPrec);
        this.bSuivant = this.findViewById(R.id.btnSuiv);
        this.nomPull = this.findViewById(R.id.txt_nomPull);
        this.image_pull=this.findViewById(R.id.PhotoArticle);
        this.image_pull2=this.findViewById(R.id.PhotoArticle2);
        this.titre=this.findViewById(R.id.txt_nomPull);
        this.description=this.findViewById(R.id.description);
        this.prix=this.findViewById(R.id.PrixPull);
        this.panier=this.findViewById(R.id.imagePanier);
        changement(this.getApplicationContext());
    }

    public void onClickPrec(View v) {

        if (noPullCourant>0){
            noPullCourant--;
            this.changement(v.getContext());
        }
    }

    public void onClickSuiv(View v) {
        if (noPullCourant<this.modele.size()-1){
            noPullCourant++;
            this.changement(v.getContext());
        }

    }

    public void onClickPanier(View v) {
        displayMsg(noPullCourant+1);

    }
    public void onClickImage(View v) {
        this.image_pull2.setVisibility(View.VISIBLE);
        this.image_pull2.bringToFront();

    }
    public void onClickImage2(View v) {
        this.image_pull2.setVisibility(View.INVISIBLE);
        this.image_pull2.bringToFront();

    }

}
