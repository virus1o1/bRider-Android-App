package com.simple.brider;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class UserProfile extends AppCompatActivity {

    private TextView profileFullName,profileEmail;
    private ImageButton userProfileToHome;
    private Button editProfileBtn;
    SignUpHelper signUpHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        profileFullName = findViewById(R.id.profileFullNameID);
        profileEmail = findViewById(R.id.profileEmailID);
        userProfileToHome = findViewById(R.id.userProfileToHomeID);
        editProfileBtn = findViewById(R.id.editProfileBtnID);

        signUpHelper = new SignUpHelper(this);
        SQLiteDatabase sqLiteDatabase = signUpHelper.getWritableDatabase();

        Cursor res = signUpHelper.getdata();
        if(res.getCount()==0){
            Toast.makeText(UserProfile.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
            return;
        }
        String fname,mail = new String();
        fname = "";
        mail = "";
        while(res.moveToNext()){
            fname = res.getString(0)+" ";
            fname += res.getString(1);
            mail = res.getString(2);
        }
        profileFullName.setText(""+fname);
        profileEmail.setText(""+mail);

        userProfileToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserProfile.this,HomePage.class));
            }
        });
        editProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserProfile.this,UpdateProfile.class));
            }
        });

    }
}