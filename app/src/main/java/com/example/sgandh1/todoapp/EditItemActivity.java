package com.example.sgandh1.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    EditText etItem;
    int position;
    String originalTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        etItem = (EditText) findViewById(R.id.etItem);

        Intent intent = getIntent();
        String itemName = intent.getStringExtra("editItem");
        originalTodo = itemName;
        position = intent.getIntExtra("position", 0);
        etItem.setText(itemName);
    }

    public void onSaveItem(View view) {
        String newTodo = etItem.getText().toString();

        Intent data = new Intent();
        if ("".equals(newTodo) || newTodo.equals(originalTodo)) {
            setResult(RESULT_CANCELED, data);
        } else {
            data.putExtra("editItem", newTodo);
            data.putExtra("position", position);
            setResult(RESULT_OK, data);
        }
        finish();
    }
}
