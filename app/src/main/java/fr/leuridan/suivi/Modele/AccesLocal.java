package fr.leuridan.suivi.Modele;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

import fr.leuridan.suivi.Outils.MySQLiteOpenHelper;

public class AccesLocal {

    //Propriétés
    private String nomBase = "bdSuiviBaby";
    private Integer versionBase = 2;
    private MySQLiteOpenHelper accesBD;
    private SQLiteDatabase bd;

    /**
     * Constructeur
     * @param context
     */
    public AccesLocal(Context context){
        accesBD = new MySQLiteOpenHelper(context, nomBase, null, versionBase);
    }

    /**
     * Ajout d'une saisie dans la BD
     * @param saisie
     */
    public void ajout(Saisie saisie){
        bd = accesBD.getWritableDatabase();
        String req = "INSERT INTO saisie(id, quantite, date, heure, selles, urine, duree, observation) VALUES ";
        req += "(NULL, "+saisie.getQuantite()+", '"+saisie.getDate()+"', '"+saisie.getHeure()+"', '"+saisie.getSelles()+"', '"+saisie.getUrine()+"', "+saisie.getDuree()+", '"+saisie.getObservation()+"');";
        bd.execSQL(req);
    }

    /**
     * Recupération des saisies effectuées
     * @return
     */
    public List<Saisie> recupSaisies(){

        List<Saisie> items = new ArrayList<Saisie>();
        bd = accesBD.getReadableDatabase();
        String req = "SELECT * FROM saisie ORDER BY id DESC";
        Cursor cursor = bd.rawQuery(req, null);

        while (cursor.moveToNext()){
            Integer quantite = cursor.getInt(1);
            String date = cursor.getString(2);
            String heure = cursor.getString(3);
            String selles = cursor.getString(4);
            String urine = cursor.getString(5);
            Integer duree = cursor.getInt(6);
            String observation = cursor.getString(7);
            Saisie saisie = new Saisie(quantite, date, heure, selles, urine, duree, observation);
            items.add(saisie);
        }

        cursor.close();
        return items;
    }

}
