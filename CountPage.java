package com.example.myfragment;

import static com.example.myfragment.ListDataSource.countPage;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CountPage extends AppCompatActivity {
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.count);

        String [] key = {"ビール","日本酒","ハイボール","ワイン","唐揚げ"};
        int [] prices = {100,200,300,400,500};
        int totalPrice = 0;
        String setName = new String();
        String setCount = new String();

        for (int i = 0 ; i< key.length;i++){
            if (Integer.parseInt(countPage.get(key[i]))>0){
                setName += String.format("%s(%d円)\n", key[i] ,prices[i]);
                setCount += String.format("%s個\n",countPage.get(key[i]));
            }
            totalPrice += prices[i]*Integer.parseInt(countPage.get(key[i]));
        }

        TextView name = findViewById(R.id.textView4);
        name.setText(setName);

        TextView count = findViewById(R.id.textView5);
        count.setText(setCount);

        TextView textView = findViewById(R.id.totalPrice);
        textView.setText(String.valueOf(totalPrice));

        Button sumbtn = findViewById(R.id.button2);
        sumbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText money = findViewById(R.id.editTextText);
                int m = Integer.parseInt(money.getText().toString());
                m -= Integer.parseInt(textView.getText().toString());

                TextView retrunMoney = findViewById(R.id.textView10);
                retrunMoney.setText(String.valueOf(m));
            }
        });

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });
    }
}
