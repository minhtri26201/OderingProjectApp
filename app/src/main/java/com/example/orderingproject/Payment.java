package com.example.orderingproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class Payment extends AppCompatActivity {
    public Spinner spin;
    public EditText message;
    public EditText information;
    public String eventType;

    //Public, Protect, Private
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        

        Spinner spinner = (Spinner) findViewById(R.id.planets_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
        R.array.method_payment, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        this.spin = spinner;

        this.message = this.findViewById(R.id.message);
        this.information = this.findViewById(R.id.information);
    }
    
    public void toDone(View view){
        String payment = this.spin.getSelectedItem().toString();
        String message = this.message.getText().toString();
        String information = this.information.getText().toString();

        //this.eventType
        Intent intent = new Intent(this, Report.class);
        intent.putExtra("hour", getIntent().getStringExtra("hour"));
        intent.putExtra("minute", getIntent().getStringExtra("minute"));
        intent.putExtra("type_time", getIntent().getStringExtra("type_time"));
        intent.putExtra("type_food", getIntent().getStringExtra("type_food"));
        intent.putExtra("name_food", getIntent().getStringExtra("name_food"));
        intent.putExtra("description_food", getIntent().getStringExtra("description_food"));
        intent.putExtra("flavor", getIntent().getStringExtra("flavor"));
        intent.putExtra("icing", getIntent().getStringExtra("icing"));
        intent.putExtra("size", getIntent().getStringExtra("size"));
        intent.putExtra("payment", payment);
        intent.putExtra("message", message);
        intent.putExtra("information", information);
        intent.putExtra("event_type", this.eventType);

        intent.putExtra("fullname", getIntent().getStringExtra("fullname"));
        intent.putExtra("email", getIntent().getStringExtra("email"));
        intent.putExtra("phone", getIntent().getStringExtra("phone"));
        intent.putExtra("address",getIntent().getStringExtra("address"));

        startActivity(intent);
    }

    public void changeEventType(View view){
        this.eventType = (String)view.getTag();
    }
}