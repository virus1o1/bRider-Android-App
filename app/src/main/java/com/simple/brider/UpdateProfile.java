package com.simple.brider;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateProfile extends AppCompatActivity {
    SignUpHelper signUpHelper;
    private TextView firstName2,lastName2,emailTxt2,password2,confirmPassword2;
    private Button updateProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        signUpHelper = new SignUpHelper(this);

        setContentView(R.layout.activity_update_profile);

        firstName2 = findViewById(R.id.firstName2ID);
        lastName2 = findViewById(R.id.lastName2ID);
        emailTxt2 = findViewById(R.id.emailTxt2ID);
        password2 = findViewById(R.id.password2ID);
        confirmPassword2 = findViewById(R.id.confirmPassword2ID);
        updateProfile = findViewById(R.id.updateProfileID);

        updateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fname = firstName2.getText().toString();
                String lname = lastName2.getText().toString();
                String email = emailTxt2.getText().toString();
                String pass = password2.getText().toString();
                String cpass = confirmPassword2.getText().toString();



                Boolean checkupdatedata = signUpHelper.updateuserdata(fname,lname,email,pass,cpass);
                if(checkupdatedata==true)
                    Toast.makeText(UpdateProfile.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(UpdateProfile.this, "New Entry Not Updated", Toast.LENGTH_SHORT).show();

            }
        });
    }
}

