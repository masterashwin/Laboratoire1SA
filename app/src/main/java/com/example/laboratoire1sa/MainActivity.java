package com.example.laboratoire1sa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.text.SpannableString;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private static final Pattern SPECIFICATION_MOT_PASSE =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +
                    "(?=.*[a-z])" +
                    "(?=.*[A-Z])" +
                    "(?=.*[@#$%^&+=])" +
                    ".{10,}" +
                    "$");


    //@ # $ % & ( ) [ ] {
   // } _ = < > + - ! ? *
       //    / | : ; . , ‘ " ~ ^

    EditText et_motPasse;
    CheckBox chk_affichageMotPasse;
    TextView tv_messageValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_messageValidation = (TextView) findViewById(R.id.tv_messageValidation);
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
        String motPasse = et_motPasse.getText().toString().trim();
        if(SPECIFICATION_MOT_PASSE.matcher(motPasse).matches()){
            tv_messageValidation.setText(getResources().getText(R.string.motPasse1));
            tv_messageValidation.setTextColor(getResources().getColor(R.color.vert));
            //tv_messageValidation.setTextColor(Color.rgb(0,255,0));
        }else{
            tv_messageValidation.setText(getResources().getText(R.string.motPasse2));
            tv_messageValidation.setTextColor(getResources().getColor(R.color.rouge));
            //tv_messageValidation.setTextColor(Color.rgb(255,0,0));

        }



    }
}