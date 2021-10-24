package com.example.modul2_kel31;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.Button;
import android.os.Bundle;
import android.widget.Toast;
import android.view.View;
import com.example.modul2_kel31.DataItem;
import com.example.modul2_kel31.ListUserResponse;
import com.example.modul2_kel31.RecycleAdapter;
import com.example.modul2_kel31.R;
import com.example.modul2_kel31.ApiClient;
import android.content.Intent;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvListUser;
    Button button;
    private List<DataItem> listItem;
    private RecycleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });
        rvListUser = findViewById(R.id.rv_list_user);

        ApiClient.getService().getList().enqueue(new Callback<ListUserResponse>() {
            @Override
            public void onResponse(Call<ListUserResponse> call, Response<ListUserResponse> response) {
                if (response.isSuccessful()) {
                    listItem = response.body().getData();

                    adapter = new RecycleAdapter(listItem, MainActivity.this);
                    rvListUser.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    rvListUser.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ListUserResponse> call, Throwable t) {

                Toast.makeText(getApplicationContext(), (CharSequence) t, Toast.LENGTH_LONG).show();
            }
        });
    }
    public void openNewActivity(){
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }
}