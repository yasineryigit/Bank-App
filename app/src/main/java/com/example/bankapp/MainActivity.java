package com.example.bankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView titlepage,subtitlepage, completeName, userName;
    Button btnSave,btnCancel;
    SharedPreferences sp1, sp2;
    SharedPreferences.Editor editor1, editor2;

    String SHARED_PREFS="sharedPrefs";
    String SHARED_PREFS2="sharedPrefs2";
    String userCompleteName="";
    String getUserCompleteName;
    String userUserName;
    String getuserUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Componentleri tanımladık
        titlepage = findViewById(R.id.textView);
        subtitlepage = findViewById(R.id.textView2);
        completeName = findViewById(R.id.editText2);
        userName = findViewById(R.id.editText1);

        btnSave=findViewById(R.id.button1);
        btnCancel=findViewById(R.id.button2);




        //Import fonts
        Typeface MLight = Typeface.createFromAsset(getAssets(),"fonts/MLight.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(),"fonts/MMedium.ttf");
        Typeface MRegular = Typeface.createFromAsset(getAssets(),"fonts/MRegular.ttf");

        //fontları ata
        titlepage.setTypeface(MRegular);
        subtitlepage.setTypeface(MLight);
        completeName.setTypeface(MRegular);
        userName.setTypeface(MRegular);

        btnSave.setTypeface(MMedium);
        btnCancel.setTypeface(MLight);


        //tekrar yükleme fonksiyonları
        loadData();
        updateData();


    }

    public void save(View v){
        //shared preferences ile kullanıcı adını sakladık
        //bu veriler artık sisteme keyleriyle birlikte gömüldü
        sp1=getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        editor1 = sp1.edit();
        editor1.putString(userCompleteName,completeName.getText().toString()).apply();

        sp2=getSharedPreferences(SHARED_PREFS2,MODE_PRIVATE);
        editor2 = sp2.edit();
        editor2.putString(userUserName,userName.getText().toString()).apply();


        Intent i1 = new Intent (MainActivity.this,BankAct.class);
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
