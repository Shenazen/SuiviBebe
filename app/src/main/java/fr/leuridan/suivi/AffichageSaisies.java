package fr.leuridan.suivi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import fr.leuridan.suivi.Adapter.LesSaisiesAdapter;
import fr.leuridan.suivi.Modele.AccesLocal;
import fr.leuridan.suivi.Modele.Saisie;

public class AffichageSaisies extends AppCompatActivity {


    //ListView saisieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage_saisies);

        List<Saisie> image_details = getListData();
        final ListView listView = findViewById(R.id.listView);
        listView.setAdapter(new LesSaisiesAdapter(this, image_details));

    }

    private  List<Saisie> getListData() {
        AccesLocal accesLocal = new AccesLocal(this);
        List<Saisie> saisieList = accesLocal.recupSaisies();

        return saisieList;
    }

    public void retourMenu(View view) {
        Intent retourMenu = new Intent(AffichageSaisies.this, MainActivity.class);
        startActivity(retourMenu);
        finish();
    }
}
