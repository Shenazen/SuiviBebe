package fr.leuridan.suivi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import fr.leuridan.suivi.Modele.Saisie;
import fr.leuridan.suivi.R;

public class LesSaisiesAdapter extends BaseAdapter {

    private Context context;
    private List<Saisie> saisieList;
    private LayoutInflater inflater;

    public LesSaisiesAdapter(Context context, List<Saisie> saisieList) {
        this.context = context;
        this.saisieList = saisieList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return saisieList.size();
    }

    @Override
    public Object getItem(int position) {
        return saisieList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.adapter_item, null);
            holder = new ViewHolder();
            holder.quantite = convertView.findViewById(R.id.item_qte);
            holder.dateHeure = convertView.findViewById(R.id.item_date_heure);
            holder.selles = convertView.findViewById(R.id.item_selles);
            holder.urine = convertView.findViewById(R.id.item_urine);
            holder.duree = convertView.findViewById(R.id.item_duree);
            holder.observation = convertView.findViewById(R.id.item_observation);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Saisie saisie = this.saisieList.get(position);
        holder.quantite.setText("Quantité (ml) : "+ saisie.getQuantite());
        holder.dateHeure.setText(saisie.getDate() + " à " + saisie.getHeure());
        holder.selles.setText("Selles : "+ saisie.getSelles());
        holder.urine.setText("Urine : "+ saisie.getUrine());
        holder.duree.setText("Durée (min) : "+ saisie.getDuree());
        holder.observation.setText("Observation : "+ saisie.getObservation());
        return convertView;

    }

    static class ViewHolder {
        TextView quantite;
        TextView dateHeure;
        TextView selles;
        TextView urine;
        TextView duree;
        TextView observation;
    }
}
