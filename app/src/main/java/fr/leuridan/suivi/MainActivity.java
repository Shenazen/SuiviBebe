package fr.leuridan.suivi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import fr.leuridan.suivi.Modele.AccesLocal;
import fr.leuridan.suivi.Modele.Saisie;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openViewAjout(View view) {
        Intent addSaisieActivity = new Intent(MainActivity.this, AjoutAction.class);
        startActivity(addSaisieActivity);
    }

    public void openViewSaisie(View view) {
        Intent listeSaisie = new Intent(MainActivity.this, AffichageSaisies.class);
        startActivity(listeSaisie);
    }

}
