package fr.leuridan.suivi;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;
import fr.leuridan.suivi.Modele.AccesLocal;
import fr.leuridan.suivi.Modele.Saisie;

public class AjoutAction extends AppCompatActivity {

    private static AccesLocal accesLocal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_action);

        TimePicker timePicker = findViewById(R.id.timePicker1);
        timePicker.setIs24HourView(true);
    }

    public void enregistrementSaisie(View view) {
        //Récupération des données
        EditText quantite = findViewById(R.id.editTextQte);
        DatePicker date = findViewById(R.id.datePicker);
        TimePicker horaire = findViewById(R.id.timePicker1);
        EditText duree = findViewById(R.id.editTextDuree);
        EditText observation = findViewById(R.id.editTextObs);
        Spinner dropDownMecoSelles = findViewById(R.id.meco_selles_spinner);
        Spinner dropDownUrine = findViewById(R.id.urine_spinner);


        String laQuantite = quantite.getText().toString();
        String laDuree = duree.getText().toString();

        String selles = dropDownMecoSelles.getSelectedItem().toString();
        String urine = dropDownUrine.getSelectedItem().toString();
        System.out.println(selles+" "+urine);

        if(laQuantite.matches("")){
            laQuantite = "0";
        }
        if(laDuree.matches("")){
            laDuree = "0";
        }

        accesLocal = new AccesLocal(this);
        Saisie newSaisie = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            newSaisie = new Saisie(Integer.parseInt(laQuantite), date.getDayOfMonth()+"/"+(date.getMonth()+1)+"/"+date.getYear(), horaire.getHour()+"h "+horaire.getMinute()+"min", dropDownMecoSelles.getSelectedItem().toString(), dropDownUrine.getSelectedItem().toString(), Integer.parseInt(laDuree), String.valueOf(observation.getText()));
        }
        accesLocal.ajout(newSaisie);

        Toast.makeText(getApplicationContext(), "Ajout effectué", Toast.LENGTH_SHORT).show();

        Intent retourMenu = new Intent(AjoutAction.this, MainActivity.class);
        startActivity(retourMenu);
    }

    public void annuleSaisie(View view) {
        Toast.makeText(getApplicationContext(), "Saisie Annulée", Toast.LENGTH_SHORT).show();

        Intent retourMenu = new Intent(AjoutAction.this, MainActivity.class);
        startActivity(retourMenu);
    }
}
