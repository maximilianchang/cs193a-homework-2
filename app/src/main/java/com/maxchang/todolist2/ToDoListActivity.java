package com.maxchang.todolist2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ToDoListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    private ArrayList<String> toDoList;
    private ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);

        prepareListView();
    }

    private void prepareListView() {
        ListView list = (ListView) findViewById(R.id.toDoList);
        list.setOnItemClickListener(this);
        list.setOnItemLongClickListener(this);

        toDoList = new ArrayList<>();
        adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                toDoList
        );
        list.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Nothing for now
    }

    public void addItem(View view) {
        EditText userInput = (EditText) findViewById(R.id.userInput);
        toDoList.add(userInput.getText().toString());
        userInput.setText("");//reset text when entering input
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        toDoList.remove(position);
        adapter.notifyDataSetChanged();
        return true;
    }
}
