package com.example.android_laboratorna3;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    User user = new User("undefined", 0);
    String name ="undefined";
    final static String userVariableKey = "NAME_VARIABLE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putSerializable(userVariableKey, user);
        super.onSaveInstanceState(outState);
    }

    // получение ранее сохраненного состояния
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // получаем объект User в переменную
        user = (User)savedInstanceState.getSerializable(userVariableKey);
        TextView dataView = findViewById(R.id.dataView);
        dataView.setText("Name: " + user.getName() + " Age: " + user.getAge());
    }

    public void saveName(View view) {

        // получаем введенное имя
        EditText nameBox = findViewById(R.id.nameBox);
        name = nameBox.getText().toString();
    }
    public void getName(View view) {

        // получаем сохраненное имя
        nameView.setText(name);
    }
}