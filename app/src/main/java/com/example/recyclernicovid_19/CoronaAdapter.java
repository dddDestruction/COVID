package com.example.recyclernicovid_19;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclernicovid_19.modelo.Pais;

import java.util.List;

public class CoronaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int GLOBAL = 1;
    private static final int PUBLICIDAD = 2;
    private static final int PAIS = 3;
    protected List<Pais> paises;
    protected LayoutInflater infalter;
    protected Context context;

    public CoronaAdapter(List<Pais> paises, Context context) {
        this.paises = paises;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        infalter = infalter.from(context);
        switch (viewType){
            case    GLOBAL:
                View itemView1 = infalter.inflate(R.layout.item_global, parent, false);
                return new GlobalHolder(itemView1);
            case  PUBLICIDAD:
                View itemView2 = infalter.inflate(R.layout.publicidad, parent, false);
                return new PublicidadHolder(itemView2);
            case PAIS:
                View itemView3 = infalter.inflate(R.layout.item_pais, parent, false);
                return new PaisHolder(itemView3);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        switch (getItemViewType(position)){
            case GLOBAL:
                GlobalHolder globalHolder = (GlobalHolder) viewHolder;
                globalHolder.contagiados.setText(String.valueOf(paises.get(position).getTotalCasos()));
                globalHolder.muertes.setText(String.valueOf(paises.get(position).getMuertesTotal()));
                break;
            case PUBLICIDAD:
                break;
            case PAIS:
                PaisHolder holder = (PaisHolder) viewHolder;
                holder.pais.setText(paises.get(position).getPais());
                holder.contagiados.setText(String.valueOf(paises.get(position).getTotalCasos()));
                holder.muertes.setText(String.valueOf(paises.get(position).getMuertesTotal()));
                break;
        }

    }

    @Override
    public int getItemCount() {
        return paises.size();
    }

    public class PaisHolder extends RecyclerView.ViewHolder {
        private TextView pais;
        private TextView contagiados;
        private TextView muertes;
        public PaisHolder(@NonNull View itemView) {
            super(itemView);
            this.pais = itemView.findViewById(R.id.pais);
            this.contagiados =itemView.findViewById(R.id.num_contagiados);
            this.muertes =itemView.findViewById(R.id.num_muertes);
        }
    }

    public class GlobalHolder extends RecyclerView.ViewHolder{
        private TextView contagiados;
        private TextView muertes;
        public GlobalHolder(@NonNull View itemView) {
            super(itemView);
            this.contagiados =itemView.findViewById(R.id.num_contagiados);
            this.muertes =itemView.findViewById(R.id.num_muertes);
        }
    }

    public class PublicidadHolder extends RecyclerView.ViewHolder{
        public PublicidadHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            return GLOBAL;
        }else if(position%10 == 0 && position != 0){
            return PUBLICIDAD;
        }
        return PAIS;
    }
}
