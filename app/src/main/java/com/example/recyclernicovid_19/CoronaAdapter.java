package com.example.recyclernicovid_19;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclernicovid_19.modelo.Pais;

import java.util.List;

public class CoronaAdapter extends RecyclerView.Adapter<CoronaAdapter.ViewHolder> {

    protected List<Pais> paises;
    protected LayoutInflater infalter;
    protected Context context;

    public CoronaAdapter(List<Pais> paises, Context context) {
        this.paises = paises;
        this.context = context;
    }

    @NonNull
    @Override
    public CoronaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        infalter = infalter.from(context);
        View itemView = infalter.inflate(R.layout.item_pais, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CoronaAdapter.ViewHolder holder, int position) {
        holder.pais.setText(paises.get(position).getPais());
        holder.contagiados.setText(paises.get(position).getTotalCasos());
        holder.muertes.setText(paises.get(position).getMuertesTotal());
    }

    @Override
    public int getItemCount() {
        return paises.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView pais;
        private TextView contagiados;
        private TextView muertes;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.pais = itemView.findViewById(R.id.pais);
            this.contagiados =itemView.findViewById(R.id.num_contagiados);
            this.muertes =itemView.findViewById(R.id.num_muertes);
        }
    }
}
