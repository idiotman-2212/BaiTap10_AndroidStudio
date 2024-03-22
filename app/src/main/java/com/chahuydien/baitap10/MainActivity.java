package com.chahuydien.baitap10;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.chahuydien.baitap10.UsersModel.Users;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.lv_list);
        progressBar = findViewById(R.id.pb_loading);
        progressBar.setVisibility(View.VISIBLE);
        fetchUsers();
    }
    private void fetchUsers() {
        String url = "https://api.github.com/users";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("Error", "Lỗi lấy dữ liệu người dùng");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.GONE);
                    }
                });
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                parseUsers(json);
            }
        });
    }
    private void parseUsers(String json) throws IOException {
        // Sử dụng Moshi hoặc Gson để phân tích JSON thành List<Users>
        Moshi moshi = new Moshi.Builder().build();
        Type usersType = Types.newParameterizedType(List.class, Users.class);
        final JsonAdapter<List<Users>> jsonAdapter = moshi.adapter(usersType);

        List<Users> users = jsonAdapter.fromJson(json);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
            }
        });
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                updateListView(users);
            }
        });
    }
    private void updateListView(List<Users> users) {
        UserAdapter adapter = new UserAdapter(users, this);
        listView.setAdapter(adapter);
    }
}

