package com.example.orderingproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class OptionFood extends AppCompatActivity {
    Button btnOptionFood;
    RadioGroup option1;
    RadioGroup option2;
    RadioGroup option3;

    String flavor;
    String icing;
    String size;

    public View.OnClickListener changeFlavor(RadioButton view){
        this.flavor = (String)view.getTag();
        return null;
    }

    public View.OnClickListener changeIcing(RadioButton view){
        this.icing = (String)view.getTag();
        return null;

    }

    public View.OnClickListener changeSize(RadioButton view){
        this.size = (String)view.getTag();
        return null;
    }

    public void toPaymentScreen(View view) {
        Intent intent = new Intent(this,Payment.class);
        intent.putExtra("hour", getIntent().getStringExtra("hour"));
        intent.putExtra("minute", getIntent().getStringExtra("minute"));
        intent.putExtra("type_time", getIntent().getStringExtra("type_time"));
        intent.putExtra("type_food", getIntent().getStringExtra("type_food"));
        intent.putExtra("name_food", getIntent().getStringExtra("name"));
        intent.putExtra("description_food", getIntent().getStringExtra("description"));
        intent.putExtra("flavor", this.flavor);
        intent.putExtra("icing", this.icing);
        intent.putExtra("size", this.size);

        intent.putExtra("fullname", getIntent().getStringExtra("fullname"));
        intent.putExtra("email", getIntent().getStringExtra("email"));
        intent.putExtra("phone", getIntent().getStringExtra("phone"));
        intent.putExtra("address",getIntent().getStringExtra("address"));

//        System.out.println("log");
//        System.out.println(this.flavor);

        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_food);
        btnOptionFood = findViewById(R.id.btnOptionFood);


        String name = getIntent().getStringExtra("name");
        String thumbnail = getIntent().getStringExtra("thumbnail");

        ((ImageView) this.findViewById(R.id.thumbnail)).setImageDrawable(
                getResources().getDrawable(
                        getResources().getIdentifier(
                                thumbnail,
                                null,
                                getPackageName()
                        )
                )
        );
        ((TextView) this.findViewById(R.id.name)).setText(String.format("%s", name));


        String flavor = getIntent().getStringExtra("flavor");
        String[] flavors = flavor.split(" ");
        this.option1 = (RadioGroup) this.findViewById(R.id.option1);

        if( flavors.length > 1 ){
            for (int i = 0; i < flavors.length; i++) {
                RadioButton radio = new RadioButton(this);
                radio.setText(flavors[i]);
                radio.setTag(flavors[i]);
                radio.setOnClickListener(this.changeFlavor(radio));
                this.option1.addView(radio);
                this.option1.invalidate();
            }
        }

        String icing = getIntent().getStringExtra("icing");
        String[] icings = icing.split(" ");
        this.option2 = (RadioGroup) this.findViewById(R.id.option2);

        if( icings.length > 1 ) {
            for (int i = 0; i < icings.length; i++) {
                RadioButton radio = new RadioButton(this);
                radio.setText(icings[i]);
                radio.setTag(icings[i]);
                radio.setOnClickListener(this.changeIcing(radio));

                this.option2.addView(radio);
                this.option2.invalidate();
            }
        }

        String size = getIntent().getStringExtra("size");
        String[] sizes = size.split(" ");
        this.option3 = (RadioGroup) this.findViewById(R.id.option3);

        if( sizes.length > 1 ) {
            for (int i = 0; i < sizes.length; i++) {
                RadioButton radio = new RadioButton(this);
                radio.setText(sizes[i]);
                radio.setOnClickListener(this.changeSize(radio));

                this.option3.addView(radio);
                this.option3.invalidate();
            }
        }

//        public void paymentScreen(View view){
//            Intent intent = new Intent(this, Payment.class);
//            startActivity(intent);
//        }

    }
}