package com.example.nursahmelis.teknikservis;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class ServisKayitAdapter extends RecyclerView.Adapter<ServisKayitAdapter.MyViewHolder> {
    public ServisKayitAdapter(List<ServisKayit> kayitlar) {
        this.kayitlar = kayitlar;
    }
    private List<ServisKayit> kayitlar;
    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView isletmeAdi, cihazAdi, cihazKodu, arizaTanimi;
        public MyViewHolder(View itemView) {
            super(itemView);
            isletmeAdi = (TextView) itemView.findViewById(R.id.tvIsletmeAdi);
            cihazAdi = (TextView) itemView.findViewById(R.id.tvCihazAdi);
            cihazKodu = (TextView) itemView.findViewById(R.id.tvCihazKodu);
            arizaTanimi= (TextView) itemView.findViewById(R.id.tvArizaTanimi);
        }
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.kayit_satir, parent, false);
        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ServisKayit kayit = kayitlar.get(position);
        holder.cihazAdi.setText(kayit.getCihazAdi());
        holder.isletmeAdi.setText(kayit.getIsletmeAdi());
        holder.cihazKodu.setText(kayit.getCihazKodu());
        holder.arizaTanimi.setText(kayit.getArizaTanimi());
    }
    @Override
    public int getItemCount() {
        return kayitlar.size();
    }
}