package fr.leuridan.suivi.Outils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    //Propriétés
    private String delete = "DROP TABLE IF EXISTS saisie;";
    private String creation = "CREATE TABLE saisie(" +
                                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                "quantite INTEGER," +
                                "date TEXT," +
                                "heure TEXT," +
                                "selles TEXT," +
                                "urine TEXT," +
                                "duree INTEGER," +
                                "observation TEXT);";

    /**
     * Constructeur
     * @param context
     * @param name
     * @param factory
     * @param version
     */
    public MySQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * Si changement de BDD
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(delete);
        db.execSQL(creation);
    }

    /**
     * Si changement de version
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
