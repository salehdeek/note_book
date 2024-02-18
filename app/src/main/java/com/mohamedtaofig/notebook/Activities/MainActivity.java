package com.mohamedtaofig.notebook.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mohamedtaofig.notebook.Adapters.DataAdapter;
import com.mohamedtaofig.notebook.Adapters.DataListAdapter;
import com.mohamedtaofig.notebook.Model.DataModel;
import com.mohamedtaofig.notebook.R;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<DataModel> mExampleList;
//    private RecyclerView mRecyclerView;
//    private DataAdapter mAdapter;
//    private RecyclerView.LayoutManager mLayoutManager;
    ListView dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        loadData();
        buildListView();
        setInsertButton();
        dataList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = mExampleList.get(position).getLine1();
                String date = mExampleList.get(position).getLine2();
                Intent intent = new Intent(MainActivity.this,ShowActivity.class);
                intent.putExtra("text",text);
                intent.putExtra("date",date);
                startActivity(intent);
            }
        });
        Button buttonSave = findViewById(R.id.button_save);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
    }

    {//    private void saveData() {
//        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        Gson gson = new Gson();
//        String json = gson.toJson(mExampleList);
//        editor.putString("task list", json);
//        editor.apply();
//    }

//    private void loadData() {
//        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
//        Gson gson = new Gson();
//        String json = sharedPreferences.getString("task list", null);
//        Type type = new TypeToken<ArrayList<DataModel>>() {}.getType();
//        mExampleList = gson.fromJson(json, type);
//
//        if (mExampleList == null) {
//            mExampleList = new ArrayList<>();
//        }
//    }
        //    private void buildRecyclerView() {
//        mRecyclerView = findViewById(R.id.recyclerview);
//        mRecyclerView.setHasFixedSize(true);
//        mLayoutManager = new LinearLayoutManager(this);
//        mAdapter = new DataAdapter(mExampleList,this);
//
//        mRecyclerView.setLayoutManager(mLayoutManager);
//        mRecyclerView.setAdapter(mAdapter);
//    }
   }

    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(mExampleList);
        editor.putString("task list", json);
        editor.apply();
        Toast.makeText(this, "data saved successfully!", Toast.LENGTH_SHORT).show();
    }

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task list", null);
        Type type = new TypeToken<ArrayList<DataModel>>() {}.getType();
        mExampleList = gson.fromJson(json, type);

        if (mExampleList == null) {
            mExampleList = new ArrayList<>();
        }
    }

    private void buildListView() {
        dataList = findViewById(R.id.listView);
        DataListAdapter listAdapter = new DataListAdapter(this,R.layout.example_item,mExampleList);
        dataList.setAdapter(listAdapter);
    }





    private void setInsertButton() {
        Button buttonInsert = findViewById(R.id.button_insert);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText line1 = findViewById(R.id.edittext_line_1);
                EditText line2 = findViewById(R.id.edittext_line_2);
                insertItem(line1.getText().toString(), line2.getText().toString());
            }
        });
    }

    private void insertItem(String line1, String line2) {
        mExampleList.add(new DataModel(line1, line2));
//        mAdapter.notifyItemInserted(mExampleList.size());

    }

}