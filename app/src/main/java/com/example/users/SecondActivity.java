package com.example.users;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    String EXTRA_Object = "User";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        if (intent.getBooleanExtra("Start", true)){

            Button buttonAdd = findViewById(R.id.buttonAdd);
            final EditText name = findViewById(R.id.fieldName);
            final EditText surname = findViewById(R.id.fieldSurname);
            final EditText age = findViewById(R.id.fieldAge);
            final EditText email = findViewById(R.id.fieldEMAIL);

            buttonAdd.setOnClickListener(new View.OnClickListener() {
                @SuppressLint({"WrongViewCast", "SetTextI18n"})
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(SecondActivity.this, MainActivity.class);
                    i.putExtra("NameUser", String.valueOf(name.getText()));
                    i.putExtra("SurnameUser", String.valueOf(surname.getText()));
                    i.putExtra("AgeUser", String.valueOf(age.getText()));
                    i.putExtra("EMAILUser", String.valueOf(email.getText()));
                    startActivity(i);
                }
            });

        }


    }

}
