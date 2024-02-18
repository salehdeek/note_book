package com.mohamedtaofig.notebook.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.mohamedtaofig.notebook.Activities.EditActivity;
import com.mohamedtaofig.notebook.Model.DataModel;
import com.mohamedtaofig.notebook.R;

import java.util.ArrayList;

public class DataListAdapter extends ArrayAdapter<DataModel> {
    private Context mContext;
    private int mResource;
    public DataListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<DataModel> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        convertView = layoutInflater.inflate(R.layout.example_item,parent,false);
        TextView text1 = convertView.findViewById(R.id.textview_line1);
        TextView text2 = convertView.findViewById(R.id.textview_line_2);

        ImageView editBtn = convertView.findViewById(R.id.editBtn);

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = getItem(position).getLine1();
                String date = getItem(position).getLine2();
                Intent intent = new Intent(mContext, EditActivity.class);
                intent.putExtra("text",text);
                intent.putExtra("date",date);
                mContext.startActivity(intent);
            }
        });

        text1.setText(getItem(position).getLine1());
        text2.setText(getItem(position).getLine2());
        return convertView;
    }
}