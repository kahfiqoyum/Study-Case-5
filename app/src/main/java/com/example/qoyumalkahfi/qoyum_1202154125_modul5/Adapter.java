package com.example.qoyumalkahfi.qoyum_1202154125_modul5;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.holder>{

    private Context mcontex;
    private List<AddData> list;
    int color;
    //berisi variabel yang digunakan

    public Adapter(Context cntx, List<AddData> list, int color){
        this.mcontex=cntx;
        this.list=list;
        this.color=color;
        //inisialisasi variabel yang digunakan
    }

    @Override
    public holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontex).inflate(R.layout.cardview, parent, false);
        //membuat view baru
        holder hldr = new holder(view);
        return hldr;
        //menentukan viewholder pada recyclerview
    }

    @Override
    public void onBindViewHolder(holder holder, int position) {
        AddData data = list.get(position);
        holder.ToDo.setText(data.getTodo());
        holder.Desc.setText(data.getDesc());
        holder.Priority.setText(data.getPrior());
        holder.card_view.setCardBackgroundColor(mcontex.getResources().getColor(this.color));
    }//menentukan nilai yang didapatkan pada viewholder

    @Override
    public int getItemCount() {
        return list.size();
    }
    //menghitung jumlah data

    public AddData getData(int position){
        return list.get(position);
    }
    //menambah data baru

    public void deleteData(int i){
        list.remove(i);
        //menghapus data
        notifyItemRemoved(i);
        notifyItemRangeChanged(i, list.size());
        //memberi pemberitahuan bahwa item dihapus
    }

    class holder extends RecyclerView.ViewHolder{
        public TextView ToDo, Desc, Priority;
        public CardView card_view;
        public holder(View itemView){super(itemView);
            //berisi variabel yang digunakan

            ToDo = itemView.findViewById(R.id.todo);
            Desc = itemView.findViewById(R.id.description);
            Priority = itemView.findViewById(R.id.number);
            card_view = itemView.findViewById(R.id.cardview);
            //inisialisasi variabel yang digunakan
        }
    }
}
