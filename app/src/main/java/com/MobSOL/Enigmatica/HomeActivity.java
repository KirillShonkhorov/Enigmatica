package com.MobSOL.Enigmatica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.View;
import android.widget.TextView;

import com.MobSOL.Enigmatica.Adapters.CryptographyAdapter;
import com.MobSOL.Enigmatica.Models.Cryptography;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    RecyclerView cryptographyRV;
    CryptographyAdapter cryptographyAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        List<Cryptography> cryptographyList = new ArrayList<>();
        cryptographyList.add(new Cryptography(1, "md4",null,getString(R.string.md4_Tittle),"#FF9640","#ffffff", getString(R.string.md4_Description)));
        cryptographyList.add(new Cryptography(2, "md5",null,getString(R.string.md5_Tittle),"#FF9640","#ffffff",getString(R.string.md5_Description)));
        cryptographyList.add(new Cryptography(3, "sha1",null,getString(R.string.sha1_Tittle),"#FF9640","#ffffff",getString(R.string.sha1_Description)));
        cryptographyList.add(new Cryptography(4, "sha2",null,getString(R.string.sha2_Tittle),"#FF9640","#ffffff",getString(R.string.sha2_Description)));
        cryptographyList.add(new Cryptography(5, "streebog",null,getString(R.string.streebog256_Tittle),"#FF9640","#ffffff",getString(R.string.streebog256_Description)));
        cryptographyList.add(new Cryptography(7, "soon","qr",getString(R.string.ToBeContinue_Tittle),"#FF9640","#ffffff",getString(R.string.ToBeContinue_Description)));

        setCryptographyRecycler(cryptographyList);

    }

    private void setCryptographyRecycler(List<Cryptography> cryptographyList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        cryptographyRV = findViewById(R.id.RV_Cryptography);
        cryptographyRV.setLayoutManager(layoutManager);

        cryptographyAdapter = new CryptographyAdapter(this, cryptographyList);
        cryptographyRV.setAdapter(cryptographyAdapter);
    }
}