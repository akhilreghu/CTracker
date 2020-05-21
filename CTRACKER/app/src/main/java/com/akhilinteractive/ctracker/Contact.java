package com.akhilinteractive.ctracker;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Contact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


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
