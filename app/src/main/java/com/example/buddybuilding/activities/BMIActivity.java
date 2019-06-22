package com.example.buddybuilding.activities;

import android.app.Dialog;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.buddybuilding.R;

public class BMIActivity extends AppCompatActivity {

    public EditText editTextgad, editTextvazn;
    public Button buttonmohasebe;
    public TextView textViewnatije, textViewnumnatije, textViewtoziatnatije;

    public double qad;
    public double vazn;
    public Dialog d;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        bind();


        d = new BottomSheetDialog(this);
        d.setContentView(R.layout.layout_bmi_bottom_sheet_dialog);
        d.setCancelable(true);
        d.show();


        textViewnumnatije.setEnabled(false);
        textViewtoziatnatije.setEnabled(false);

        buttonmohasebe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Mohasebe();
                textViewnumnatije.setEnabled(true);
                textViewtoziatnatije.setEnabled(true);

            }
        });

    }

    private void Mohasebe() {
        vazn = Double.parseDouble(editTextvazn.getText().toString());
        double qad_a = Double.parseDouble(editTextgad.getText().toString());
        qad = qad_a * qad_a;
        double kol = vazn / qad;
        Log.d("BMI", "Mohasebe: " + kol);

        if (kol < 16.5) {
            textViewnumnatije.setText((int) Math.round( kol));
            textViewtoziatnatije.setText("کمبود وزن شدید");
        }
        if (kol > 16.5 && kol < 18.5) {
            textViewnumnatije.setText("" + Math.round( kol));
            textViewtoziatnatije.setText("کمبود وزن");
        }
        if (kol > 18.5 && kol < 25) {
            textViewnumnatije.setText("" + Math.round( kol));
            textViewtoziatnatije.setText("معمولی");
        }
        if (kol > 25 && kol < 30) {
            textViewnumnatije.setText("" + Math.round( kol));
            textViewtoziatnatije.setText("اضافه وزن");
        }
        if (kol > 30 && kol < 35) {
            textViewnumnatije.setText("" + Math.round( kol));
            textViewtoziatnatije.setText("چاقی کلاس ۱");
        }
        if (kol > 35 && kol < 40) {
            textViewnumnatije.setText("" + Math.round( kol));
            textViewtoziatnatije.setText("چاقی کلاس ۲");
        }
        if (kol > 40) {
            textViewnumnatije.setText("" +Math.round( kol));
            textViewtoziatnatije.setText("چاقی کلاس ۳");
        }


    }

    private void bind() {
        editTextgad = findViewById(R.id.edtgad);
        editTextvazn = findViewById(R.id.edtvazn);
        textViewnatije = findViewById(R.id.txtnatije);
        buttonmohasebe = findViewById(R.id.btnmohasebe);
        textViewnumnatije = findViewById(R.id.txtnumnatije);
        textViewtoziatnatije = findViewById(R.id.txttozihnatije);
    }

    public void onClick(View view) {
     d.cancel();
    }
}
