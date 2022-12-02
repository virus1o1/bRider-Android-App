package com.simple.brider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {

    private ImageButton profileImageBtn,homeToTicketPage;
    private EditText seatNumber;
    private Button nextToTicketConfirmation;
    String[] routes = {"DSC-Dhanmondi","Dhanmondi-DSC","DSC-Uttara","Uttara-DSC","DSC-Mirpur","Mirpur-DSC","DSC-Savar","Savar-DSC"};
    String[] times = {"7:30 AM","10:30 AM","01:30 PM","04:30 PM"};
    AutoCompleteTextView dropDownList;
    AutoCompleteTextView dropDownTimeList;
    ArrayAdapter<String> adapterItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        homeToTicketPage = findViewById(R.id.homeToTicketPageID);
        seatNumber = findViewById(R.id.seatNumberID);
        profileImageBtn = findViewById(R.id.profileImageBtnID);
        dropDownTimeList = findViewById(R.id.dropDownListTimeID);
        dropDownList = findViewById(R.id.dropDownListID);
        nextToTicketConfirmation = findViewById(R.id.nextToTicketConfirmationID);

        final String[] time = new String[1];
        final String[] route = new String[1];

        profileImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomePage.this,UserProfile.class));
            }
        });

        adapterItems = new ArrayAdapter<String>(this,R.layout.dropdown_routes,routes);
        dropDownList.setAdapter(adapterItems);
        dropDownList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                route[0] = item;
                Toast.makeText(getApplicationContext(),"Item:"+item,Toast.LENGTH_SHORT).show();
            }
        });

        adapterItems = new ArrayAdapter<String>(this,R.layout.dropdown_times,times);
        dropDownTimeList.setAdapter(adapterItems);
        dropDownTimeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                time[0] =item;
                Toast.makeText(getApplicationContext(),"Item:"+item,Toast.LENGTH_SHORT).show();
            }
        });

        nextToTicketConfirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String seat_no = seatNumber.getText().toString();
                String Ex_Route = route[0];
                String Ex_Time = time[0];

                int price = Integer.parseInt(seat_no);
                price *= 25;
                Intent intent = new Intent(HomePage.this, TicketConfirmation.class);
                intent.putExtra("price", price);
                intent.putExtra("Ex_Route", Ex_Route);
                intent.putExtra("Ex_Time", Ex_Time);
                intent.putExtra("seat_no", seat_no);
                startActivity(intent);
            }
        });
        homeToTicketPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String seat_no = seatNumber.getText().toString();
                String Ex_Route = route[0];
                String Ex_Time = time[0];

                Intent intent = new Intent(HomePage.this,TicketPage.class);
                intent.putExtra("Ex_Route",Ex_Route);
                intent.putExtra("Ex_Time",Ex_Time);
                intent.putExtra("seat_no",seat_no);
                startActivity(intent);
            }
        });
    }
}