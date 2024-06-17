package com.example.basic_01app;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    public float getBmi(int weight, float height) {
        return weight / (height * height);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText WeightTxt = findViewById(R.id.edt_Weight);
        EditText HeightTxt = findViewById(R.id.edt_Height);
        Button CalculateBtn = findViewById(R.id.btn_calculate);
        TextView resultTxt = findViewById(R.id.txt_BMI);


        CalculateBtn.setOnClickListener(v -> {
            String Weight = WeightTxt.getText().toString();
            String Height = HeightTxt.getText().toString();


            if (Weight.isEmpty() || Height.isEmpty()) {
                resultTxt.setText("Please enter weight and height");
                return;
            }

            if (Float.parseFloat(Height) == 0) {
                resultTxt.setText("Height cannot be zero");
                return;
            }

            if (Float.parseFloat(Weight) == 0) {
                resultTxt.setText("Weight cannot be zero");
                return;
            }

            int weight = Integer.parseInt(Weight);
            float height = Float.parseFloat(Height);
            float result=  getBmi(weight,height);
            resultTxt.setText(String.valueOf(result));
        });
    }

}