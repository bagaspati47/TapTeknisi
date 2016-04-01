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

public class Adapter extends RecyclerView.Adapter<Adapter.StockViewHolder>{

    List<Stock> stocks;

    public Adapter(List<Stock> stocks){
        this.stocks = stocks;
    }

    @Override
    public StockViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        StockViewHolder pvh = new StockViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(StockViewHolder holder, int position) {
        holder.stockName.setText(stocks.get(position).getName());
        holder.stockNumber.setText(stocks.get(position).getNumber());
        Ion.with(holder.stockPhoto).error(R.mipmap.ic_launcher).load(stocks.get(position).getPhotoId());
        holder.stockReputasi.setText(stocks.get(position).getReputasi());
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
        CardView cv;
        TextView stockName;
        TextView stockNumber;
        ImageView stockPhoto;
        TextView stockReputasi;

        StockViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            stockName = (TextView)itemView.findViewById(R.id.person_name);
            stockNumber = (TextView)itemView.findViewById(R.id.person_number);
            stockPhoto = (ImageView)itemView.findViewById(R.id.person_photo);
            stockReputasi = (TextView)itemView.findViewById(R.id.person_reputasi);
        }
    }

}
