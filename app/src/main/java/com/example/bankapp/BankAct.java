package com.example.bankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BankAct extends AppCompatActivity {

    Intent i1;
    TextView titlepage,subtitlepage, completeName, userName,bankone,expired;
    Button editButton;

    String SHARED_PREFS="sharedPrefs";
    String SHARED_PREFS2="sharedPrefs2";
    String userCompleteName="";
    String getUserCompleteName;
    String userUserName;
    String getuserUserName;

    SharedPreferences sp1,sp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank);

        //Componentleri tanımladık
        completeName = findViewById(R.id.completeName);
        titlepage=findViewById(R.id.textView1);
        bankone=findViewById(R.id.bankone);
        expired=findViewById(R.id.expired);
        subtitlepage=findViewById(R.id.textView2);
        userName = findViewById(R.id.userName);
        editButton = findViewById(R.id.button1);





        //Import fonts
        Typeface MLight = Typeface.createFromAsset(getAssets(),"fonts/MLight.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(),"fonts/MMedium.ttf");
        Typeface MRegular = Typeface.createFromAsset(getAssets(),"fonts/MRegular.ttf");

        //fontları atıyoruz
        titlepage.setTypeface(MRegular);
        subtitlepage.setTypeface(MLight);
        completeName.setTypeface(MRegular);
        userName.setTypeface(MRegular);

        bankone.setTypeface(MMedium);
        expired.setTypeface(MLight);

        editButton.setTypeface(MMedium);



        loadData();
        updateData();
    }
    public void edit(View v){
        i1 = new Intent(BankAct.this,MainActivity.class);
        startActivity(i1);
    }

    public void loadData(){
        //sp ile sakladığımız veriyi aldık
        sp1 = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        getUserCompleteName=sp1.getString(userCompleteName,"");

        sp2 = getSharedPreferences(SHARED_PREFS2,MODE_PRIVATE);
        getuserUserName=sp2.getString(userUserName,"");



    }

    public void updateData(){

        completeName.setText(getUserCompleteName);
        userName.setText(getuserUserName);
    }



}
