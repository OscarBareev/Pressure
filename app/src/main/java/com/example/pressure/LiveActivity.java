package com.example.pressure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pressure.healthClasses.Live;

import java.util.ArrayList;
import java.util.List;


public class LiveActivity extends AppCompatActivity {

    private static final String TAG = "LiveClass";

    private EditText weight;
    private EditText stepsNumber;

    private List<Live> liveList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live);

        weight = findViewById(R.id.weight);
        stepsNumber = findViewById(R.id.steps);

        Button saveBtn = findViewById(R.id.saveButton);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i(TAG, "Нажата кнопка сохранить");

                String weightStr = weight.getText().toString().trim();
                String stepsStr = stepsNumber.getText().toString().trim();

                if (weightStr.isEmpty() || stepsStr.isEmpty()) {
                    Toast.makeText(LiveActivity.this, R.string.needData, Toast.LENGTH_LONG).show();
                } else {
                    try {
                        Double weightDouble = Double.parseDouble(weightStr);
                        int stepsInt = Integer.parseInt(stepsStr);
                        liveList.add(new Live(weightDouble, stepsInt));
                        Toast.makeText(LiveActivity.this, R.string.Saved, Toast.LENGTH_LONG).show();
                        Log.i(TAG, "Новый объект добавлен в коллекцию");

                    } catch (Exception ex) {
                        Log.e(TAG, "Получено исключение");
                        Toast.makeText(LiveActivity.this, R.string.addCorrect, Toast.LENGTH_LONG).show();
                    }
                }

            }
        });


    }
}
