package com.MobSOL.Enigmatica.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.MobSOL.Enigmatica.Models.Cryptography;
import com.MobSOL.Enigmatica.R;

import java.util.List;
import java.util.Objects;

public class CryptographyAdapter extends RecyclerView.Adapter<CryptographyAdapter.CryptographyViewHolder> {
    Context context;
    List<Cryptography> cryptographies;

    public CryptographyAdapter(Context context, List<Cryptography> cryptographies) {
        this.context = context;
        this.cryptographies = cryptographies;
    }

    @NonNull
    @Override
    public CryptographyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cryptographyItems = LayoutInflater.from(context).inflate(R.layout.cryptography_layout, parent, false);
        return new CryptographyAdapter.CryptographyViewHolder(cryptographyItems);
    }

    @Override
    public void onBindViewHolder(@NonNull CryptographyViewHolder holder, int position) {
        holder.cryptographyBg.setCardBackgroundColor(Color.parseColor(cryptographies.get(position).getBgColor()));
        holder.cryptographyImage.setBackgroundColor(Color.parseColor(cryptographies.get(position).getImageColor()));
        @SuppressLint("DiscouragedApi") int imageID = context.getResources().getIdentifier(cryptographies.get(position).getImage(), "drawable", context.getPackageName());
        holder.cryptographyImage.setImageResource(imageID);

        if (Objects.equals(cryptographies.get(position).getQR(), "qr")){
            @SuppressLint("DiscouragedApi") int QR_ID = context.getResources().getIdentifier(cryptographies.get(position).getQR(), "drawable", context.getPackageName());
            @SuppressLint("DiscouragedApi") Drawable QR_Drawable = context.getResources().getDrawable(QR_ID);
            holder.cryptographyQR.setForeground(QR_Drawable);
        }
        else  holder.cryptographyQR.setForeground(null);

        holder.cryptographyTittle.setText(cryptographies.get(position).getTittle());
        holder.cryptographyTittle.setMovementMethod(LinkMovementMethod.getInstance());
        holder.cryptographyDescription.setText(cryptographies.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return cryptographies.size();
    }

    public static final class CryptographyViewHolder extends RecyclerView.ViewHolder{

        CardView cryptographyBg, cryptographyQR;
        ImageView cryptographyImage;
        TextView cryptographyTittle, cryptographyDescription;
        public CryptographyViewHolder(@NonNull View itemView) {
            super(itemView);

            cryptographyBg = itemView.findViewById(R.id.card_view);
            cryptographyImage = itemView.findViewById(R.id.Image);
            cryptographyQR = itemView.findViewById(R.id.QR_CardView);
            cryptographyTittle = itemView.findViewById(R.id.Tittle);
            cryptographyDescription = itemView.findViewById(R.id.Description);
        }
    }
}
