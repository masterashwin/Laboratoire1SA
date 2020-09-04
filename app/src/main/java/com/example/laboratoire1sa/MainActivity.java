package com.example.laboratoire1sa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private static final Pattern SPECIFICATION_MOT_PASSE =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +         //at least 1 digit
                    "(?=.*[a-z])" +         //at least 1 lower case letter
                    "(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    ".{10,}" +               //at least 4 characters
                    "$");


 //   @ # $ % & ( ) [ ] {
  //  } _ = < > + - ! ? *
   //         / | : ; . , ‘ " ~ ^

    EditText et_motPasse;
    CheckBox chk_affichageMotPasse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        et_motPasse = (EditText) findViewById(R.id.et_motPasse);
        chk_affichageMotPasse = (CheckBox) findViewById(R.id.chk_affichageMotPasse);

        chk_affichageMotPasse.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    et_motPasse.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                }else{
                    et_motPasse.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });
    }

    public void onClick_btn_validerMotPasse(View view) {


    }
}