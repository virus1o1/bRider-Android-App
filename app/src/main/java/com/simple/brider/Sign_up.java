package com.simple.brider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Sign_up extends AppCompatActivity {
    private EditText firstNameTxt,lastNameTxt,emailTxt,passwordTxt,confirmPasswordTxt;
    private Button eyeBtn1,eyeBtn2,signUpBtn,loginGoogleBtn,loginFbBtn;
    SignUpHelper signUpHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        firstNameTxt = findViewById(R.id.firstNameID);
        lastNameTxt = findViewById(R.id.lastNameID);
        emailTxt = findViewById(R.id.emailTxtID);
        passwordTxt = findViewById(R.id.passwordID);
        confirmPasswordTxt = findViewById(R.id.confirmPasswordID);

        signUpBtn = findViewById(R.id.signUpBtn2ID);
        loginGoogleBtn = findViewById(R.id.signInGoogleBtnID);
        loginFbBtn = findViewById(R.id.signInFbBtnID);

        signUpHelper = new SignUpHelper(this);
        SQLiteDatabase sqLiteDatabase = signUpHelper.getWritableDatabase();

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstName = firstNameTxt.getText().toString();
                String LastName = lastNameTxt.getText().toString();
                String emailText = emailTxt.getText().toString();
                String password = passwordTxt.getText().toString();
                String confirmPassword = confirmPasswordTxt.getText().toString();

                Boolean checkInsertData = signUpHelper.insertData(firstName,LastName,emailText,password,confirmPassword);
                if(checkInsertData==true){
                    Toast.makeText(Sign_up.this,"Data inserted!",Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(Sign_up.this,"Data not inserted!",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Sign_up.this,HomePage.class));
            }
        });

    }

}