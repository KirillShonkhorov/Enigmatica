package com.MobSOL.Enigmatica.Cryptographies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.MobSOL.Enigmatica.Adapters.JSONParser;
import com.MobSOL.Enigmatica.Models.Requests;
import com.MobSOL.Enigmatica.R;

import java.io.IOException;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MD4Activity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_md4);

        CardView outputCArdView = findViewById(R.id.Output_CardView);

        LinearLayout Link_Layout = findViewById(R.id.Link_layout);

        CheckBox checkBox = findViewById(R.id.checkbox);

        EditText InputEditTExt = findViewById(R.id.HashEditText);
        EditText OutputEditText = findViewById(R.id.Output_HashEditText);
        EditText OutputLink = findViewById(R.id.Output_Link);

        Button InputHash = findViewById(R.id.Hash_button);
        Button CopyHash = findViewById(R.id.Copy_Output_hash_button);
        Button CopyLink = findViewById(R.id.Copy_Output_link_button);

        InputHash.setOnClickListener(v -> {
            String url = "https://api.hashify.net/hash/md4/hex?value=" + InputEditTExt.getText();

            outputCArdView.setVisibility(View.VISIBLE);

            if (checkBox.isChecked()){
                Link_Layout.setVisibility(View.VISIBLE);
                GetHash(url,OutputLink,OutputEditText);
            }
            else {
                Link_Layout.setVisibility(View.GONE);
                GetHash(url,OutputLink,OutputEditText);
                OutputLink.setText(null);
            }
        });

        CopyHash.setOnClickListener(v -> {
            ClipboardManager clipboard = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
            }
            ClipData clip = ClipData.newPlainText("", OutputEditText.getText().toString());
            Objects.requireNonNull(clipboard).setPrimaryClip(clip);
        });

        CopyLink.setOnClickListener(v -> {
            ClipboardManager clipboard = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
            }
            ClipData clip = ClipData.newPlainText("", OutputLink.getText().toString());
            if (clipboard != null) {
                clipboard.setPrimaryClip(clip);
            }
        });
    }
    
    private void GetHash(String url,EditText outputLink,EditText outputEditText) {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url(url)
                .method("GET", null)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                MD4Activity.this.runOnUiThread(() -> {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            R.string.Out_Connection,
                            Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    e.printStackTrace();
                });
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if(response.isSuccessful()){
                    final String myResponce = Objects.requireNonNull(response.body()).string();

                    JSONParser jsonParser = new JSONParser();

                    Requests requests = jsonParser.jsonStringToPojo(myResponce);

                    MD4Activity.this.runOnUiThread(() -> {
                        outputEditText.setText(requests.getDigest());
                        outputLink.setText(url);
                    });
                }
            }
        });
    }
}