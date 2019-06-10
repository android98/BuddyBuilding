package com.example.buddybuilding.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.buddybuilding.R;

public class BMRActivity extends Activity {

    public RadioGroup radioGroupsex, radioGroupFaaliat;
    public RadioButton radioButtonMale, radioButtonFemale, radioButtonSangin, radioButtonZiad, radioButtonMotevaset, radioButtonSabok, radioButtonKam;
    public EditText editTextgad, editTextvazn, editTextsen;
    public TextView textViewNatije, textViewNatijeFaaliat;


    public boolean checked;

    public double Sabet_mardan = 66;
    public double Sabet_zanan = 655;

    public double getSabet_mardan_weight = 13.7;
    public double getSabet_mardan_height = 5;
    public double getSabet_mardan_age = 6.8;


    public double getSabet_zanan_weight = 9.6;
    public double getSabet_zanan_height = 1.8;
    public double getSabet_zanan_age = 4.7;


    public double Sabet_sangin = 1.9;
    public double Sabet_ziad = 1.725;
    public double Sabet_motevaset = 1.55;
    public double Sabet_sabok = 1.375;
    public double Sabet_kam = 1.2;


    public double gadd, vaznn, senn;

    public double m_3, n_3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmr);


        bind();


    }


    private void bind() {
        editTextgad = findViewById(R.id.edtgad);
        editTextvazn = findViewById(R.id.edtvazn);
        editTextsen = findViewById(R.id.edtsen);
        textViewNatije = findViewById(R.id.txtnatije);
        textViewNatijeFaaliat = findViewById(R.id.txtnatijefaaliat);
    }

    public void onRadioButtonClicked(View v) {
        radioGroupsex = findViewById(R.id.radiosex);
        radioGroupFaaliat = findViewById(R.id.radiofaaliat);
        radioButtonMale = findViewById(R.id.radiomale);
        radioButtonFemale = findViewById(R.id.radiofemale);

        checked = ((RadioButton) v).isChecked();

        switch (v.getId()) {
            case R.id.radiomale:
                if (checked) {
                    vaznn = Double.parseDouble(editTextvazn.getText().toString());
                    gadd = Double.parseDouble(editTextgad.getText().toString());
                    senn = Double.parseDouble(editTextsen.getText().toString());
                    double a = vaznn * getSabet_mardan_weight;
                    double b = gadd * getSabet_mardan_height;
                    double c = senn * getSabet_mardan_age;
                    double m_1 = a + b;
                    double m_2 = m_1 - c;
                    m_3 = Sabet_mardan + m_2;
                    Log.d("BMR", "onClick: " + m_3);
                    textViewNatije.setText("" +Math.round( m_3));
                    break;
                }
            case R.id.radiofemale:
                if (checked) {
                    double aa = vaznn * getSabet_zanan_weight;
                    double bb = gadd * getSabet_zanan_height;
                    double cc = senn * getSabet_zanan_age;
                    double n_1 = aa + bb;
                    double n_2 = n_1 - cc;
                    n_3 = Sabet_zanan + n_2;
                    Log.d("BMR", "onClick: " + n_3);
                    textViewNatije.setText("" +Math.round( n_3));
                    break;
                }
        }
    }

    public void onRadioButtonClickedFaaliat(View view) {
        radioButtonSangin = findViewById(R.id.radiovarzeshsanin);
        radioButtonZiad = findViewById(R.id.radiovarzeshziad);
        radioButtonMotevaset = findViewById(R.id.radiovarzeshmotevaset);
        radioButtonSabok = findViewById(R.id.radiovazreshsabok);
        radioButtonKam = findViewById(R.id.radiovarzeshkam);


        boolean checkedd = ((RadioButton) view).isChecked();

        if (radioButtonMale.isChecked()) {

            if (checkedd) {

                switch (view.getId()) {
                    case R.id.radiovarzeshsanin:
                        double az = m_3 * Sabet_sangin;
                        textViewNatijeFaaliat.setText("" + Math.round(az));
                        break;

                    case R.id.radiovarzeshziad:
                        double ax = m_3 * Sabet_ziad;
                        textViewNatijeFaaliat.setText("" +Math.round( ax));

                        break;


                    case R.id.radiovarzeshmotevaset:
                        double ac = m_3 * Sabet_motevaset;
                        textViewNatijeFaaliat.setText("" + Math.round(ac));

                        break;

                    case R.id.radiovazreshsabok:
                        double ab = m_3 * Sabet_sabok;
                        textViewNatijeFaaliat.setText("" + Math.round(ab));


                        break;

                    case R.id.radiovarzeshkam:
                        double an = m_3 * Sabet_kam;
                        textViewNatijeFaaliat.setText("" +Math.round( an));

                        break;
                }
            }
        }
        if (radioButtonFemale.isChecked()) {
            if (checkedd) {
                switch (view.getId()) {
                    case R.id.radiovarzeshsanin:
                        double az = n_3 * Sabet_sangin;
                        textViewNatijeFaaliat.setText("" + Math.round(az));
                        break;

                    case R.id.radiovarzeshziad:
                        double ax = n_3 * Sabet_ziad;
                        textViewNatijeFaaliat.setText("" +Math.round( ax));

                        break;


                    case R.id.radiovarzeshmotevaset:
                        double ac = n_3 * Sabet_motevaset;
                        textViewNatijeFaaliat.setText("" + Math.round(ac));

                        break;

                    case R.id.radiovazreshsabok:
                        double ab = n_3 * Sabet_sabok;
                        textViewNatijeFaaliat.setText("" + Math.round(ab));


                        break;

                    case R.id.radiovarzeshkam:
                        double an = n_3 * Sabet_kam;
                        textViewNatijeFaaliat.setText("" +Math.round( an));

                        break;
                }
            }
        }

    }
}


