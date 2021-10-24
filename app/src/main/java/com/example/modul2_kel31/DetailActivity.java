package com.example.modul2_kel31;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.modul2_kel31.R;

public class DetailActivity extends AppCompatActivity {

    private TextView tvNama,tvNama2,tvEmail;
    private ImageView imgPhotoUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        imgPhotoUser = findViewById(R.id.img_photo_user);
        tvNama = findViewById(R.id.tv_first_name);
        tvNama2 = findViewById(R.id.tv_last_name);
        tvEmail = findViewById(R.id.email);


        if (getIntent().hasExtra("name")) {

            String nama = getIntent().getStringExtra("name");
            String nama2 = getIntent().getStringExtra("lastName");
            String email = getIntent().getStringExtra("email");
            String avatar = getIntent().getStringExtra("avatar");
            tvNama.setText(nama);
            tvNama2.setText(nama2);
            tvEmail.setText(email);
            Glide.with(this).load(avatar).into(imgPhotoUser);

        }
    }
}