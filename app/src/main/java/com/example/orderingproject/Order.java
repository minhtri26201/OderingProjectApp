package com.example.orderingproject;

import static android.widget.AdapterView.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Order extends AppCompatActivity implements OnItemClickListener {

    private DatePicker datePicker;
    private EditText editTextDate;
    private EditText editP;
    private Button buttonDate;

    private EditText hour;
    private EditText minute;
    private Spinner spnCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        /*Spinner spinner = findViewById(R.id.spn1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.time, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemClickListener(this); */


        this.datePicker = (DatePicker) this.findViewById(R.id.datePicker);
        this.editP = (EditText) this.findViewById(R.id.editP);
        this.buttonDate = (Button) this.findViewById(R.id.buttonDate);

        this.hour = (EditText) this.findViewById(R.id.hour);
        this.minute = (EditText) this.findViewById(R.id.minute);

        editP.setText(
                + this.datePicker.getDayOfMonth()+"/"+ (this.datePicker.getMonth() + 1)+"/"+this.datePicker.getYear()
        );

        spnCategory = (Spinner) findViewById(R.id.spnCategory);
        this.spnCategory = spnCategory;

        List<String> list = new ArrayList<>();
        list.add("AM");
        list.add("PM");

        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spnCategory.setAdapter(adapter);

    }


        public void setDate(View view){
        editP.setText(
                this.datePicker.getDayOfMonth()+"/"+ (this.datePicker.getMonth() + 1)+"/"+this.datePicker.getYear()
        );

        this.datePicker.setVisibility(View.GONE);
        this.buttonDate.setVisibility(View.GONE);
    }

    public int typeDate = 0;
    public void showDate(View view){
        if(typeDate == 0){
            typeDate = 1;
            this.datePicker.setVisibility(View.VISIBLE);
            this.buttonDate.setVisibility(View.VISIBLE);
        } else {
            typeDate = 0;
            this.datePicker.setVisibility(View.GONE);
            this.buttonDate.setVisibility(View.GONE);
        }

        //android studio change text button (show/hidden)
        //android studio datepicker set date
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    public void chooseFoodScreen(View view){
        Intent intent = new Intent(this, Customer.class);
        intent.putExtra("type", this.type);
        intent.putExtra("hour", this.hour.getText().toString());
        intent.putExtra("minute", this.minute.getText().toString());
        intent.putExtra("type_time", this.spnCategory.getSelectedItem().toString());
        startActivity(intent);
    }

    String type;
    public void changeOrder(View view){
        this.type = (String) view.getTag();
    }

}

