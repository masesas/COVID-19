package com.juaracoding.coronalivetime.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.juaracoding.coronalivetime.R;
import com.juaracoding.coronalivetime.coronalivetime.Provinsi;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class AdapterListSimple extends RecyclerView.Adapter<AdapterListSimple.ViewHolder> {


    ArrayList<Provinsi> data = new ArrayList<>();
    Context context;


    public AdapterListSimple(Context context) {
        this.context = context;
    }


    public ArrayList<Provinsi> getData() {
       return data;
    }

    public void setData(ArrayList<Provinsi> items) {
        if (data != null) {
            if (data.size() > 0) {
                data.clear();
            }
            data.addAll(items);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_provinsi, parent, false);

        return new ViewHolder (view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.provinsi.setText(data.get(position).getAttributes().getProvinsi());
        holder.confirm.setText(data.get(position).getAttributes().getKasusPosi());
        holder.recovered.setText(data.get(position).getAttributes().getKasusSemb());
        holder.death.setText(data.get(position).getAttributes().getKasusMeni());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    // Static inner class to initialize the views of rows
    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView provinsi, death, recovered, confirm;

       ViewHolder(View itemView) {
            super(itemView);
            provinsi = (TextView) itemView.findViewById(R.id.txtProvinsi);
            death = (TextView) itemView.findViewById(R.id.txtDeath);
            recovered = (TextView) itemView.findViewById(R.id.txtRecovered);
            confirm = (TextView) itemView.findViewById(R.id.txtConfirm);
        }
    }
}
