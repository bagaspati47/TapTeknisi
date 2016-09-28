package com.projekhalamanlangitblogspot.dokterpc2;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.koushikdutta.ion.Ion;

import java.util.List;

public class AdapterPenjual extends RecyclerView.Adapter<AdapterPenjual.StockViewHolder>{

    List<Stock2> stocks;

    public AdapterPenjual(List<Stock2> stocks){
        this.stocks = stocks;
    }

    @Override
    public StockViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layoutpenjual, parent, false);
        StockViewHolder pvh = new StockViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(StockViewHolder holder, int position) {
        holder.stockNama.setText(stocks.get(position).getNama());
        holder.stockLink.setText(stocks.get(position).getLink());
        holder.stockSts.setText(stocks.get(position).getSts());
    }

    @Override
    public int getItemCount() {
        return stocks.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class StockViewHolder extends RecyclerView.ViewHolder {
        TextView stockNama;
        TextView stockLink;
        TextView stockSts;

        StockViewHolder(View itemView) {
            super(itemView);
            stockNama = (TextView)itemView.findViewById(R.id.namatoko);
            stockLink = (TextView)itemView.findViewById(R.id.linkweb);
            stockSts = (TextView)itemView.findViewById(R.id.statuson);
        }
    }

}
