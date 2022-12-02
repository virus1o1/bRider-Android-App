package com.simple.brider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button signIn, signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signIn = findViewById(R.id.signInBtnID);
        signUp = findViewById(R.id.signUpBtnID);

        signIn.setOnClickListener(this);
        signUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.signInBtnID)
            {
                openSignin();
            }
        if(view.getId()==R.id.signUpBtnID)
        {
            openSignup();
        }

    }
    public void openSignin(){
        Intent intent = new Intent(this,SignIn.class);
        startActivity(intent);
    }

    public void openSignup(){
        Intent intent = new Intent(this,Sign_up.class);
        startActivity(intent);
    }
}