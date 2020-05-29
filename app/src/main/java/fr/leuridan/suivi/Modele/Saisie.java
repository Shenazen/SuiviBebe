package fr.leuridan.suivi.Modele;

import java.io.Serializable;

public class Saisie implements Serializable {
    private Integer quantite;
    private String date;
    private String heure;
    private String selles;
    private String urine;
    private Integer duree;
    private String observation;

    public Saisie(Integer quantite, String date, String heure, String selles, String urine, Integer duree, String observation) {
        this.quantite = quantite;
        this.date = date;
        this.heure = heure;
        this.selles = selles;
        this.urine = urine;
        this.duree = duree;
        this.observation = observation;
    }

    public String getSelles() { return selles; }

    public String getUrine() { return urine; }

    public String getDate() {
        return date;
    }

    public String getHeure() {
        return heure;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public Integer getDuree() {
        return duree;
    }

    public String getObservation() {
        return observation;
    }
}
