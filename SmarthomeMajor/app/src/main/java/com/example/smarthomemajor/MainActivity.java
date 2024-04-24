package com.example.smarthomemajor;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;

import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    Button on1,on2,on3,on4,off1,off2,off3,off4;
    SeekBar seekBar;
    TextView temprature;

    int seeked;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        on1 = findViewById(R.id.on1);
        on2 = findViewById(R.id.on2);
        on3 = findViewById(R.id.on3);
        on4 = findViewById(R.id.on4);

        off1 = findViewById(R.id.off1);
        off2 = findViewById(R.id.off2);
        off3 = findViewById(R.id.off3);
        off4 = findViewById(R.id.off4);

        seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(4);
        temprature = findViewById(R.id.Temprature);




        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Sensors");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String temp = dataSnapshot.child("Temperature").getValue().toString();
                temprature.setText(temp);

            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });


        // Write a message to the database



        on1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference Appliances =database.getReference("Appliances");
                DatabaseReference specificChildRef = Appliances.child("appliance1");
                specificChildRef.setValue("0");
            }
        });
        on2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference Appliances =database.getReference("Appliances");
                DatabaseReference specificChildRef = Appliances.child("appliance2");
                specificChildRef.setValue("0");
            }
        });
        on3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference Appliances =database.getReference("Appliances");
                DatabaseReference specificChildRef = Appliances.child("appliance3");
                specificChildRef.setValue("0");
            }
        });
        on4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference Appliances =database.getReference("Appliances");
                DatabaseReference specificChildRef = Appliances.child("appliance4");
                specificChildRef.setValue("0");
            }
        });


        off1.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference Appliances =database.getReference("Appliances");
                DatabaseReference specificChildRef = Appliances.child("appliance1");
                specificChildRef.setValue("1");
            }
        });
        off2.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference Appliances =database.getReference("Appliances");
                DatabaseReference specificChildRef = Appliances.child("appliance2");
                specificChildRef.setValue("1");
            }
        });
        off3.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference Appliances =database.getReference("Appliances");
                DatabaseReference specificChildRef = Appliances.child("appliance3");
                specificChildRef.setValue("1");
            }
        });
        off4.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference Appliances =database.getReference("Appliances");
                DatabaseReference specificChildRef = Appliances.child("appliance4");
                specificChildRef.setValue("1");
            }
        });



        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int stepSize = 1;
                seeked =(i/stepSize)*stepSize;
                seekBar.setProgress(seeked);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference Appliances =database.getReference("Appliances");
                DatabaseReference specificChildRef = Appliances.child("fan");
                specificChildRef.setValue(seeked);


            }
        });




    }
}