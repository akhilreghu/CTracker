package com.akhilinteractive.ctracker;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Blog extends AppCompatActivity {

    int x = 0;
    int y = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();

        String[] v={"One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
        final TextView[] rv={
                findViewById(R.id.tone),
                findViewById(R.id.ttwo),
                findViewById(R.id.tthree),
                findViewById(R.id.tfour),
                findViewById(R.id.tfive),
                findViewById(R.id.tsix),
                findViewById(R.id.tseven),
                findViewById(R.id.teight),
                findViewById(R.id.tnine),
        };
        final TextView[] rvc={
                findViewById(R.id.c1),
                findViewById(R.id.c2),
                findViewById(R.id.c3),
                findViewById(R.id.c4),
                findViewById(R.id.c5),
                findViewById(R.id.c6),
                findViewById(R.id.c7),
                findViewById(R.id.c8),
                findViewById(R.id.c9)
        };


        for(int i =0;i<v.length;i++){
            DatabaseReference d = mDatabase.getReference("Blog/"+v[i]+"/Title");
            d.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);
                    System.out.println(value);
                    rv[x].setText(value);
                    x++;
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    Log.w("sads", "Failed to read value.", error.toException());
                }
            });
            DatabaseReference e = mDatabase.getReference("Blog/"+v[i]+"/Content");
            e.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value1 = dataSnapshot.getValue(String.class);
                    System.out.println(value1+"++++++++++++++++++++++");
                    rvc[y].setText(value1);
                    y++;
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    Log.w("sads", "Failed to read value.", error.toException());
                }
            });

        }
    }
    public void home(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
    public void calculator(View view){
        Intent intent = new Intent(getApplicationContext(),Converter.class);
        startActivity(intent);
    }
    public void blog(View view){
        Intent intent = new Intent(getApplicationContext(), Blog.class);
        startActivity(intent);
    }
    public void contact(View view){
        Intent intent = new Intent(getApplicationContext(), Contact.class);
        startActivity(intent);
    }
    public void info(View view){
        Intent intent = new Intent(getApplicationContext(), Info.class);
        startActivity(intent);
    }
}
