package com.example.android_laboratorna3;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String name ="undefined";
    final static String nameVariableKey = "NAME_VARIABLE";
    TextView nameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameView = findViewById(R.id.nameView);
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putString(nameVariableKey, name);
        super.onSaveInstanceState(outState);
    }

    // получение ранее сохраненного состояния
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        name = savedInstanceState.getString(nameVariableKey);
        nameView.setText(name);
    }

    public void saveName(View view) {

        // получаем введенное имя
        EditText nameBox = findViewById(R.id.nameBox);
        name = nameBox.getText().toString();
    }
    public void getName(View view) {

        // получаем сохраненное имя
        TextView nameView = findViewById(R.id.nameView);
        nameView.setText(name);
    }
}