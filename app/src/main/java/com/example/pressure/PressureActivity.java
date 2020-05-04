package com.example.pressure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pressure.healthClasses.Pressure;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class PressureActivity extends AppCompatActivity {

    private static final String TAG = "PressureClass";

    private EditText topPressure;
    private EditText lowPressure;
    private EditText puls;
    private CheckBox tachycardia;
    private TextView dateText;

    private List<Pressure> pressureList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);

        Init();
    }

    private void Init() {

        topPressure = findViewById(R.id.topPressure);
        lowPressure = findViewById(R.id.lowPressure);
        puls = findViewById(R.id.Puls);
        tachycardia = findViewById(R.id.checkTachycardia);
        dateText = findViewById(R.id.dateText);

        Date currentDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        final String date = dateFormat.format(currentDate);

        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        final String time = timeFormat.format(currentDate);

        dateText.setText(String.format("%s%s\n%s%s", getString(R.string.date), date, getString(R.string.time), time));


        Button saveBtn = findViewById(R.id.saveButton);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i(TAG, "Нажата кнопка сохранить");

                String topPressureStr = topPressure.getText().toString().trim();

                String lowPressureStr = lowPressure.getText().toString().trim();

                String pulsStr = puls.getText().toString().trim();

                boolean tachBool = false;
                if (tachycardia.isChecked()) {
                    tachBool = true;
                }

                String dateStr = date + " " + time;

                try {
                    int topPressureInt = Integer.parseInt(topPressureStr);
                    int lowPressureInt = Integer.parseInt(lowPressureStr);
                    int pulsInt = Integer.parseInt(pulsStr);

                    pressureList.add(new Pressure(topPressureInt, lowPressureInt, pulsInt, tachBool, dateStr));
                    Toast.makeText(PressureActivity.this, R.string.Saved, Toast.LENGTH_LONG).show();

                    Log.i(TAG, "Новый объект добавлен в коллекцию");

                } catch (Exception ex) {
                    Log.e(TAG, "Получено исключение");
                    Toast.makeText(PressureActivity.this, R.string.addCorrect, Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
