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

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        user = (User)savedInstanceState.getSerializable(userVariableKey);
        TextView dataView = findViewById(R.id.dataView);
        dataView.setText("Name: " + user.getName() + " Age: " + user.getAge());
    }

    public void saveData(View view) {
        EditText nameBox = findViewById(R.id.nameBox);
        EditText yearBox = findViewById(R.id.yearBox);
        String name = nameBox.getText().toString();
        int age = 0;
        try{
            age = Integer.parseInt(yearBox.getText().toString());
        }
        catch (NumberFormatException ex){}
        user = new User(name, age);
    }
    public void getData(View view) {
        TextView dataView = findViewById(R.id.dataView);
        dataView.setText("Name: " + user.getName() + " Age: " + user.getAge());
    }
}