package com.example.orderingproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Person;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;

public class ChooseFood extends AppCompatActivity {
    ListView listViewProduct;
    ArrayList<Product> listProduct;
    ProductListViewAdapter productListViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_food);


        listProduct = new ArrayList<>();

        listProduct.add(
                new Product(
                        1,
                        "Cupcakes",
                        "2RM",
                        "drawable/icon_cupcake",
                        getResources().getDrawable(
                                getResources().getIdentifier(
                                        "@drawable/icon_cupcake",
                                        null,
                                        getPackageName()
                                )
                        ),
                        new String[]{
                                "Chocolate",
                                "Mocha",
                                "Marble",
                                "Double",
                                "Dutch"
                        },
                        new String[]{
                                "Chocolate",
                                "Caramel",
                                "Strawberry",
                                "Vanilla"

                        },
                        new String[]{

                        }
                )
        );

        listProduct.add(
                new Product(
                        2,
                        "Cookies",
                        "Small 2RM | Big 4RM",
                        "drawable/icon_cookies",
                        getResources().getDrawable(
                                getResources().getIdentifier(
                                        "@drawable/icon_cookies",
                                        null,
                                        getPackageName()
                                )
                        ),
                        new String[]{
                                "Chocolate",
                                "Mocha",
                                "Marble",
                                "Double",
                                "Dutch"
                        },
                        new String[]{
                                "Chocolate",
                                "Caramel",
                                "Strawberry",
                                "Vanilla"

                        },
                        new String[]{
                                "Small",
                                "Big"

                        }

                )
        );
        listProduct.add(
                new Product(
                        3,
                        "Doughnuts",
                        "1RM",
                        "drawable/icon_doughnut",
                        getResources().getDrawable(
                                getResources().getIdentifier(
                                        "@drawable/icon_doughnut",
                                        null,
                                        getPackageName()
                                )
                        ),
                        new String[]{
                                "Chocolate",
                                "Mocha",
                                "Marble",
                                "Double",
                                "Dutch"
                        },
                        new String[]{
                                "Chocolate",
                                "Caramel",
                                "Strawberry",
                                "Vanilla"

                        },
                        new String[]{

                        }

                )
        );
        listProduct.add(
                new Product(
                        4,
                        "Rolls",
                        "1.5RM",
                        "drawable/icon_roll",
                        getResources().getDrawable(
                                getResources().getIdentifier(
                                        "@drawable/icon_roll",
                                        null,
                                        getPackageName()
                                )
                        ),
                        new String[]{
                                "Gralic",
                                "Cheese",
                                "Plain"

                        },
                        new String[]{},
                        new String[]{}

                )
        );
        listProduct.add(
                new Product(
                        5,
                        "Bread",
                        "3.5RM",
                        "drawable/icon_bread",
                        getResources().getDrawable(
                                getResources().getIdentifier(
                                        "@drawable/icon_bread",
                                        null,
                                        getPackageName()
                                )
                        ),
                        new String[]{
                                "Gralic",
                                "Cheese",
                                "Plain"
                        },
                        new String[]{},
                        new String[]{}

                )
        );
        listProduct.add(
                new Product(
                        6,
                        "Cakes",
                        "Small 35RM | Big 50RM",
                        "drawable/icon_cakes",
                        getResources().getDrawable(
                                getResources().getIdentifier(
                                        "@drawable/icon_cakes",
                                        null,
                                        getPackageName()
                                )
                        ),
                        new String[]{
                                "Chocolate",
                                "Mocha",
                                "Marble",
                                "Double",
                                "Dutch"
                        },
                        new String[]{
                                "Chocolate",
                                "Caramel",
                                "Strawberry",
                                "Vanilla"

                        },
                        new String[]{
                                "Small",
                                "Big"

                        }


                )
        );

        productListViewAdapter = new ProductListViewAdapter(listProduct);

        listViewProduct = findViewById(R.id.listproduct);
        listViewProduct.setAdapter(productListViewAdapter);

    }

    public void optionFoodScreen(View view){

        Product t = (Product) view.getTag();

        System.out.println("Hello");
        System.out.println(
                t.thumbnail
        );
        System.out.println("End hello");
        //System.out.println(String.join(" ", t.flavor));

        Intent intent = new Intent(this, OptionFood.class);
        intent.putExtra("thumbnail", t.thumbnail);
        intent.putExtra("name", t.name);
        intent.putExtra("description", t.description);
        intent.putExtra("flavor", String.join(" ", t.flavor));
        intent.putExtra("icing", String.join(" ", t.icing));
        intent.putExtra("size", String.join(" ", t.size));
        intent.putExtra("type_food", getIntent().getStringExtra("type"));
        intent.putExtra("hour", getIntent().getStringExtra("hour"));
        intent.putExtra("type", getIntent().getStringExtra("type"));
        intent.putExtra("minute", getIntent().getStringExtra("minute"));
        intent.putExtra("type_time", getIntent().getStringExtra("type_time"));
        intent.putExtra("fullname", getIntent().getStringExtra("fullname"));
        intent.putExtra("email", getIntent().getStringExtra("email"));
        intent.putExtra("phone", getIntent().getStringExtra("phone"));
        intent.putExtra("address",getIntent().getStringExtra("address"));

        startActivity(intent);
    }
}


class Product {
    String name;
    String description;
    int productID;
    String thumbnail;
    Context context;
    Drawable img;
    String[] flavor;
    String[] icing;
    String[] size;

    public Product(int productID, String name, String description, String thumbnail, Drawable img, String[] flavor, String[] icing, String[] size) {
        this.name = name;
        this.description = description;
        this.productID = productID;
        this.thumbnail = thumbnail;
        this.img = img;
        this.flavor = flavor;
        this.icing = icing;
        this.size = size;
    }
}

class ProductListViewAdapter extends BaseAdapter {

    final ArrayList<Product> listProduct;

    ProductListViewAdapter(ArrayList<Product> listProduct) {
        this.listProduct = listProduct;
    }

    @Override
    public int getCount() {

        return listProduct.size();
    }

    @Override
    public Object getItem(int position) {

        return listProduct.get(position);
    }

    @Override
    public long getItemId(int position) {

        return listProduct.get(position).productID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent ) {


        View viewProduct;
        if (convertView == null) {
            viewProduct = View.inflate(parent.getContext(), R.layout.product_view, null);
        } else viewProduct = convertView;


        Product product = (Product) getItem(position);


        ((TextView) viewProduct.findViewById(R.id.nameproduct)).setText(String.format("Name : %s", product.name));
        ((TextView) viewProduct.findViewById(R.id.priceproduct)).setText(String.format("Price %s", product.description));
        ((ImageView) viewProduct.findViewById(R.id.thumb)).setImageDrawable(
                product.img
        );
        ((LinearLayout) viewProduct.findViewById(R.id.produce)).setTag(product);

        return viewProduct;
    }
}

