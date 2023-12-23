package com.MobSOL.Enigmatica.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.MobSOL.Enigmatica.Adapters.CryptographyAdapter;
import com.MobSOL.Enigmatica.Cryptographies.HighwayActivity;
import com.MobSOL.Enigmatica.Cryptographies.MD4Activity;
import com.MobSOL.Enigmatica.Cryptographies.MD5Activity;
import com.MobSOL.Enigmatica.Cryptographies.SHA1Activity;
import com.MobSOL.Enigmatica.Cryptographies.SHA2Activity;
import com.MobSOL.Enigmatica.Models.Cryptography;
import com.MobSOL.Enigmatica.R;

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
        cryptographyList.add(new Cryptography(1, "md4",null,getString(R.string.md4_Tittle),"#706DBAE2","#708BC9FF","#010A44","#010A44", getString(R.string.md4_Description),true, MD4Activity.class));
        cryptographyList.add(new Cryptography(2, "md5",null,getString(R.string.md5_Tittle),"#70BF3730","#ffffff","#F7FF8B","#F7FF8B",getString(R.string.md5_Description),true, MD5Activity.class));
        cryptographyList.add(new Cryptography(3, "sha1",null,getString(R.string.sha1_Tittle),"#7086B32D","#70C9F76F","#000000","#000000",getString(R.string.sha1_Description),true, SHA1Activity.class));
        cryptographyList.add(new Cryptography(4, "sha2",null,getString(R.string.sha2_Tittle),"#70B537F8","#ffffff","#BBFFEF","#BBFFEF",getString(R.string.sha2_Description),true, SHA2Activity.class));
        cryptographyList.add(new Cryptography(5, "highway",null,getString(R.string.highway_Tittle),"#70FF9640","#70FFB87E","#542309","#542309",getString(R.string.highway_Description),true, HighwayActivity.class));
        cryptographyList.add(new Cryptography(7, "soon","qr",getString(R.string.ToBeContinue_Tittle),"#70B9AE92","#70E9C4AA","#ffffffff","#ffffff",getString(R.string.ToBeContinue_Description),false, null));

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