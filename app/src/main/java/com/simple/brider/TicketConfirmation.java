package com.simple.brider;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

public class TicketConfirmation extends AppCompatActivity {
    private ImageButton bkashBtn,onecardBtn, tcToHomePage,ticketView,ticketConfirmationToUserProfile;
    private TextView price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_confirmation);

        tcToHomePage = findViewById(R.id.TChpToHomePageID);
        price = findViewById(R.id.priceID);
        ticketView = findViewById(R.id.ticketViewID);
        ticketConfirmationToUserProfile = findViewById(R.id.ticketConfirmationToUserProfileID);

        Bundle bundle=getIntent().getExtras();
        int viewtext = bundle.getInt("price");
        price.setText("Total Cost "+viewtext+" Taka");
        String seatNo = bundle.getString("seat_no");
        String routeNo = bundle.getString("Ex_Route");
        String timeNo = bundle.getString("Ex_Time");

        bkashBtn = findViewById(R.id.bkashButtonID);
        onecardBtn = findViewById(R.id.oneButtonID);

        tcToHomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TicketConfirmation.this,HomePage.class));
            }
        });

        bkashBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuffer buffer = new StringBuffer();
                buffer.append("            "+viewtext+" taka has been deducted!\n             Your Ticket has confirmed!");

                AlertDialog.Builder builder = new AlertDialog.Builder(TicketConfirmation.this);
                builder.setCancelable(true);
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
        onecardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuffer buffer = new StringBuffer();
                buffer.append("            "+viewtext+" taka has been deducted!\n             Your Ticket has confirmed!");

                AlertDialog.Builder builder = new AlertDialog.Builder(TicketConfirmation.this);
                builder.setCancelable(true);
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
        ticketView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TicketConfirmation.this,TicketPage.class);
                intent.putExtra("Ex_Route",routeNo);
                intent.putExtra("Ex_Time",timeNo);
                intent.putExtra("seat_no",seatNo);
                startActivity(intent);
            }
        });
        ticketConfirmationToUserProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TicketConfirmation.this,UserProfile.class));
            }
        });
    }
}