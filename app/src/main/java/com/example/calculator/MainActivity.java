package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,badd,bdiff,bproduct,bmod,bdiv,bdot,b00,bac,bequal,bspace;
    TextView tv;
    int k=0;
    String op1,op2,op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.tv_disp);
        b1=findViewById(R.id.button_1);
        b2=findViewById(R.id.button_2);
        b3=findViewById(R.id.button_3);
        b4=findViewById(R.id.button_4);
        b5=findViewById(R.id.button_5);
        b6=findViewById(R.id.button_6);
        b7=findViewById(R.id.button_7);
        b8=findViewById(R.id.button_8);
        b9=findViewById(R.id.button_9);
        b0=findViewById(R.id.button_0);
        b00=findViewById(R.id.button_00);
        bdot=findViewById(R.id.button_dot);
        bspace=findViewById(R.id.btn_backspace);
        bac=findViewById(R.id.button_ac);
        bequal=findViewById(R.id.button_equal);
        badd=findViewById(R.id.button_add);
        bdiff=findViewById(R.id.button_diff);
        bproduct=findViewById(R.id.button_product);
        bmod=findViewById(R.id.button_mod);
        bdiv=findViewById(R.id.button_div);
        b00.setOnClickListener(this);
        b0.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        bdot.setOnClickListener(this);
        badd.setOnClickListener(this);
        bdiv.setOnClickListener(this);
        bproduct.setOnClickListener(this);
        bdiff.setOnClickListener(this);
        bequal.setOnClickListener(this);
        bmod.setOnClickListener(this);
        bspace.setOnClickListener(this);
        bdot.setOnClickListener(this);
        bac.setOnClickListener(this);



    }
    void calc()
    {
        float x,y,z;
        x=Float.parseFloat(op1);
        y=Float.parseFloat(op2);
        if(op.equals("+"))
            z=x+y;
        else if (op.equals("-"))
            z=x-y;
        else if (op.equals("*"))
            z=x*y;
        else if (op.equals("/"))
            z=x/y;
        else
            z=x%y;

        tv.setText(""+z);


    }


    @Override
    public void onClick(View view) {
        Button b=(Button)view;
        try {
            if(b==b0||b==b1||b==b2||b==b3||b==b4||b==b5||b==b6||b==b7||b==b8|b==b9||b==b00)
            {
                if(k==0)
                {
                    tv.setText(b.getText().toString());
                    k=1;
                }
                else {
                    tv.setText(tv.getText().toString()+b.getText().toString());
                }

            }
            if(b==badd||b==bmod||b==bdiff||b==bproduct||b==bdiv)
            {
                op1=tv.getText().toString();
                op=b.getText().toString();
                k=0;
                tv.setText("");

            }

            if(b==bequal)
            {

                op2=tv.getText().toString();
                calc();
            }
            if(b==bac) {
                tv.setText("0");
                k=0;
            }
            if(b==bspace)
            {
                String s1;
                s1=tv.getText().toString();
                int n=s1.length();
                tv.setText(s1.substring(0,n-1));

            }
        }
        catch (Exception e)
        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }



    }
}