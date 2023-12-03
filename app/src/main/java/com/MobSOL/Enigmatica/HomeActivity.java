package com.MobSOL.Enigmatica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.MobSOL.Enigmatica.Adapters.CryptographyAdapter;
import com.MobSOL.Enigmatica.Models.Cryptography;

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
        cryptographyList.add(new Cryptography(1, "md4","MD4","#FF9640","#ffffff","MD4\nMD4MD4MD4MD4MD4MD4MD4MD4MD4MD4MD4MD4MD4MD4MD4MD4MD4MD4\nMD4\nMD4\nMD4\nMD4\nMD4\nMD4\nMD4\nMD4\n"));
        cryptographyList.add(new Cryptography(2, "md4","MD5","#FF9640","#ffffff","MD4\nMD4MD4MD4MD4MD4MD4MD4MD4MD4MD4MD4MD4MD4MD4MD4MD4MD4MD4\nMD4\nMD4\nMD4\nMD4\nMD4\nMD4\nMD4\nMD4\nMD4\nMD4\nMD4\nMD4\nMD4\nMD4\nMD4\nMD4\nMD4\n"));
        cryptographyList.add(new Cryptography(3, "md4","SHA1","#FF9640","#ffffff","MD4\nMD4MD4MD4MD4MD4MD4MD4MD4MD4MD4MD4MD4MD4MD4MD4MD4MD4MD4\nMD4\nMD4\nMD4\nMD4\nMD4\nMD4\nMD4\nMD4\nMD4\nMD4\nMD4\nMD4\nMD4\n"));
        cryptographyList.add(new Cryptography(4, "md4","SHA2","#FF9640","#ffffff","MD4\nMD4MD4MD4MD4MD4MD4MD4MD4MD4MD4MD4MD4MD4MD4MD4MD4MD4MD4\nMD4\nMD4\nMD4\nMD4\nMD4"));
        cryptographyList.add(new Cryptography(5, "md4","STREEBOG","#FF9640","#ffffff","MD4\nMD4MD4MD4MD4MD4MD4MD4MD4MD4MD4MD4MD4MD4MD4MD4MD4MD4MD4\nMD4\nMD4"));
        cryptographyList.add(new Cryptography(9, "md4","To be continue...","#FF9640","#ffffff","To be continue..."));

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