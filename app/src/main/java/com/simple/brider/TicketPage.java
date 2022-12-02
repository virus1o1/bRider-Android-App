package com.simple.brider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class TicketPage extends AppCompatActivity {

    private TextView ticketRoute,ticketTime,ticketSeatNo;
    private ImageButton ticketToHomepage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_page);
        ticketRoute =  findViewById(R.id.ticketRouteID);
        ticketTime = findViewById(R.id.ticketTimeID);
        ticketSeatNo = findViewById(R.id.ticketSeatNoID);
        ticketToHomepage = findViewById(R.id.ticketToHomepageID);

        Bundle bundle=getIntent().getExtras();
        String seatNo = bundle.getString("seat_no");
        ticketSeatNo.setText(seatNo);
        String routeNo = bundle.getString("Ex_Route");
        ticketRoute.setText(routeNo);
        String timeNo = bundle.getString("Ex_Time");
        ticketTime.setText(timeNo);

        ticketToHomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TicketPage.this,HomePage.class));
            }
        });
    }
}