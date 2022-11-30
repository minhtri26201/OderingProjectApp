package com.example.orderingproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Customer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
    }

    public void toChooseFood(View view){
        EditText fullname = this.findViewById(R.id.cus_name);
        EditText email = this.findViewById(R.id.cus_email);
        EditText phone = this.findViewById(R.id.cus_phoneNO);
        EditText address = this.findViewById(R.id.del_address);


        Intent intent = new Intent(this, ChooseFood.class);
        intent.putExtra("type", getIntent().getStringExtra("type"));
        intent.putExtra("hour", getIntent().getStringExtra("hour"));
        intent.putExtra("minute", getIntent().getStringExtra("minute"));
        intent.putExtra("fullname", fullname.getText().toString());
        intent.putExtra("email", email.getText().toString());
        intent.putExtra("phone", phone.getText().toString());
        intent.putExtra("address", address.getText().toString());

        startActivity(intent);
    }
}