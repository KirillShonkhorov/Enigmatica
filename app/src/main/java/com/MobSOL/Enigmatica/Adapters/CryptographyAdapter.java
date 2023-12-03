package com.MobSOL.Enigmatica.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
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

        holder.cryptographyTittle.setText(cryptographies.get(position).getTittle());
        holder.cryptographyDescription.setText(cryptographies.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return cryptographies.size();
    }

    public static final class CryptographyViewHolder extends RecyclerView.ViewHolder{

        CardView cryptographyBg;
        ImageView cryptographyImage;
        TextView cryptographyTittle, cryptographyDescription;
        public CryptographyViewHolder(@NonNull View itemView) {
            super(itemView);

            cryptographyBg = itemView.findViewById(R.id.card_view);
            cryptographyImage = itemView.findViewById(R.id.Image);
            cryptographyTittle = itemView.findViewById(R.id.Tittle);
            cryptographyDescription = itemView.findViewById(R.id.Description);
        }
    }
}
