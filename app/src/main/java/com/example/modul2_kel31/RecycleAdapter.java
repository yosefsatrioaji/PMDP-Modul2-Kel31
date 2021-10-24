package com.example.modul2_kel31;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.modul2_kel31.DetailActivity;
import com.example.modul2_kel31.R;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
    private List<DataItem> dataUser;
    private Context mContext;


    public RecycleAdapter(List<DataItem> dataUser, Context mContext) {
        this.dataUser = dataUser;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_rv_list_user, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.tvFirstName.setText(dataUser.get(i).getFirstName());
        viewHolder.tvLastName.setText(dataUser.get(i).getLastName());
        viewHolder.tvEmail.setText(String.format("Email : %s", dataUser.get(i).getEmail()));
        Glide.with(mContext).load(dataUser.get(i).getAvatar()).into(viewHolder.imgPhotoUser);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra("name", dataUser.get(i).getFirstName());
                intent.putExtra("lastName",dataUser.get(i).getLastName());
                intent.putExtra("email",dataUser.get(i).getEmail());
                intent.putExtra("avatar",dataUser.get(i).getAvatar());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataUser.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgPhotoUser;
        private TextView tvFirstName, tvLastName, tvEmail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhotoUser = itemView.findViewById(R.id.img_photo_user);
            tvFirstName = itemView.findViewById(R.id.tv_item_first_name);
            tvLastName = itemView.findViewById(R.id.tv_item_last_name);
            tvEmail = itemView.findViewById(R.id.tv_item_email);
        }
    }
}