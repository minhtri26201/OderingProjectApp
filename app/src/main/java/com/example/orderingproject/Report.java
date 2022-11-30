package com.example.orderingproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Report extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        ( (TextView) this.findViewById(R.id.type_food) ).setText("Type: " + getIntent().getStringExtra("type_food"));
        ( (TextView) this.findViewById(R.id.hour) ).setText("Hour: " + getIntent().getStringExtra("hour"));
        ( (TextView) this.findViewById(R.id.minute) ).setText("Minute: " + getIntent().getStringExtra("minute"));
        ( (TextView) this.findViewById(R.id.name_food)).setText("Name: " + getIntent().getStringExtra("name_food"));
        ( (TextView) this.findViewById(R.id.description_food)).setText("Description: " + getIntent().getStringExtra("description_food"));
        ( (TextView) this.findViewById(R.id.flavor)).setText("Flavor: " + getIntent().getStringExtra("flavor"));
        ( (TextView) this.findViewById(R.id.icing)).setText("Icing: " + getIntent().getStringExtra("icing"));
        ( (TextView) this.findViewById(R.id.size)).setText("Size: " + getIntent().getStringExtra("size"));
        ( (TextView) this.findViewById(R.id.payment)).setText("Payment Type: " + getIntent().getStringExtra("payment"));
        ( (TextView) this.findViewById(R.id.message)).setText("Customer Message: " + getIntent().getStringExtra("message"));
        ( (TextView) this.findViewById(R.id.information)).setText("Customer Information: " + getIntent().getStringExtra("information"));
        ( (TextView) this.findViewById(R.id.event_type)).setText("Event Type: " + getIntent().getStringExtra("event_type"));

        ( (TextView) this.findViewById(R.id.fulln)).setText("Customer Name: " + getIntent().getStringExtra("fullname"));
        ( (TextView) this.findViewById(R.id.phone)).setText("Phone Number : " + getIntent().getStringExtra("phone"));
        ( (TextView) this.findViewById(R.id.address)).setText("Address: " + getIntent().getStringExtra("address"));

    }
}