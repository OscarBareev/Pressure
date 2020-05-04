package com.example.pressure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pressure.healthClasses.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainClass";

    private EditText nameField;
    private EditText ageField;
    private List<User> userList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Init();
    }

    private void Init() {
        nameField = findViewById(R.id.nameField);
        ageField = findViewById(R.id.ageField);

        Button saveBtn = findViewById(R.id.saveButton);
        Button pressureBtn = findViewById(R.id.pressureButton);
        Button liveBtn = findViewById(R.id.liveButton);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i(TAG, "Нажата кнопка сохранить");

                String name = nameField.getText().toString();
                String ageStr = ageField.getText().toString();

                if (name.isEmpty() || ageStr.isEmpty()) {
                    Toast.makeText(MainActivity.this, R.string.needData, Toast.LENGTH_LONG).show();
                } else {

                    try {
                        int age = Integer.parseInt(ageStr);
                        userList.add(new User(name, age));
                        Log.i(TAG, "Новый объект добавлен в коллекцию");

                    } catch (Exception ex) {
                        Log.e(TAG, "Получено исключение");
                        Toast.makeText(MainActivity.this, R.string.addCorrect, Toast.LENGTH_LONG).show();
                    }
                }
            }

        });

        pressureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i(TAG, "Нажата кнопка Давление");

                Intent intent = new Intent(MainActivity.this, PressureActivity.class);
                startActivity(intent);
            }
        });

        liveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Нажата кнопка Жизненные показатели");

                Intent intent = new Intent(MainActivity.this, LiveActivity.class);
                startActivity(intent);
            }
        });
    }
}
