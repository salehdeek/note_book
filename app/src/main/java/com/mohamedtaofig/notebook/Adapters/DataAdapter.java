package com.mohamedtaofig.notebook.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mohamedtaofig.notebook.Model.DataModel;
import com.mohamedtaofig.notebook.R;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {

    ArrayList<DataModel> dataList;
    Context context;

    public DataAdapter(ArrayList<DataModel> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DataViewHolder(LayoutInflater.from(context).inflate(R.layout.example_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        DataModel data = dataList.get(position);
        holder.textLine1.setText(data.getLine1());
        holder.textLine2.setText(data.getLine2());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    public class DataViewHolder extends RecyclerView.ViewHolder{
        TextView textLine1,textLine2;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            textLine1 =itemView.findViewById(R.id.textview_line1);
            textLine2 = itemView.findViewById(R.id.textview_line_2);
        }
    }
}
