package com.MobSOL.Enigmatica.Cryptographies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HighwayActivity extends AppCompatActivity {
    private static final Pattern HEXADECIMAL_PATTERN = Pattern.compile("\\p{XDigit}+");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highway);

        CardView outputCArdView = findViewById(R.id.Output_CardView);

        LinearLayout Link_Layout = findViewById(R.id.Link_layout);

        CheckBox checkBox = findViewById(R.id.checkbox);

        EditText InputEditTExt = findViewById(R.id.HashEditText);
        EditText InputKeyTExt = findViewById(R.id.KeyEditText);

        EditText OutputEditText = findViewById(R.id.Output_HashEditText);
        EditText OutputKeyText = findViewById(R.id.Output_KeyEditText);
        EditText OutputLinkText = findViewById(R.id.Output_LinkEditText);

        Button InputHash = findViewById(R.id.HashButton);
        Button CopyHash = findViewById(R.id.Copy_Output_hashButton);
        Button CopyKey = findViewById(R.id.Copy_Output_keyButton);
        Button CopyLink = findViewById(R.id.Copy_Output_linkButton);

        InputHash.setOnClickListener(v -> {
            String url = null;
            boolean HEX_Checker;

            if(!InputKeyTExt.getText().toString().equals("")){
                if(isHexadecimal(String.valueOf(InputKeyTExt.getText())) && (InputKeyTExt.getText().length() == 64)){
                    url = "https://api.hashify.net/hash/highway?key=" + InputKeyTExt.getText() + "&value=" + InputEditTExt.getText();
                    HEX_Checker = true;
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Ключ не является 32-битным HEX-форматом",
                            Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();

                    HEX_Checker = false;
                }
            }
            else{
                url = "https://api.hashify.net/hash/highway?key=random&value=" + InputEditTExt.getText();
                HEX_Checker = true;
            }

            if(HEX_Checker){outputCArdView.setVisibility(View.VISIBLE);}

            if (checkBox.isChecked()){
                if(HEX_Checker){
                    Link_Layout.setVisibility(View.VISIBLE);
                    GetHash(url,OutputLinkText,OutputEditText,OutputKeyText);
                }
            }
            else {
                if(HEX_Checker){
                    Link_Layout.setVisibility(View.GONE);
                    GetHash(url,OutputLinkText,OutputEditText,OutputKeyText);
                    OutputLinkText.setText(null);
                }
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

        CopyKey.setOnClickListener(v -> {
            ClipboardManager clipboard = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
            }
            ClipData clip = ClipData.newPlainText("", OutputKeyText.getText().toString());
            Objects.requireNonNull(clipboard).setPrimaryClip(clip);
        });

        CopyLink.setOnClickListener(v -> {
            ClipboardManager clipboard = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
            }
            ClipData clip = ClipData.newPlainText("", OutputLinkText.getText().toString());
            Objects.requireNonNull(clipboard).setPrimaryClip(clip);
        });
    }

    private boolean isHexadecimal(String input) {
        final Matcher matcher = HEXADECIMAL_PATTERN.matcher(input);
        return matcher.matches();
    }

    private void GetHash(String url,EditText outputLinkText,EditText outputEditText,EditText outputKeyText) {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url(url)
                .method("GET", null)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                HighwayActivity.this.runOnUiThread(() -> {
                });
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if(response.isSuccessful()){
                    final String myResponce = Objects.requireNonNull(response.body()).string();

                    JSONParser jsonParser = new JSONParser();

                    Requests requests = jsonParser.jsonStringToPojo(myResponce);

                    HighwayActivity.this.runOnUiThread(() -> {
                        outputEditText.setText(requests.getDigest());
                        outputKeyText.setText(requests.getKey());
                        outputLinkText.setText(url);
                    });
                }
            }
        });
    }
}