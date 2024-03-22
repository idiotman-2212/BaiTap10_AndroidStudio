package com.chahuydien.baitap10;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.chahuydien.baitap10.UsersModel.Users;
import com.squareup.picasso.Picasso;

public class UserDetailActivity extends AppCompatActivity {

    private ImageView iv_avatar;
    private TextView tv_login, tv_id, tv_url,tv_html_url, tv_followers_url, tv_following_url;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_details);

        iv_avatar = findViewById(R.id.iv_avatar);
        tv_id = findViewById(R.id.tv_id);
        tv_url = findViewById(R.id.tv_url);
        tv_html_url = findViewById(R.id.tv_html_url);
        tv_followers_url = findViewById(R.id.tv_followers_url);
        tv_following_url = findViewById(R.id.tv_following_url);

        Intent intent = getIntent();
        if (intent != null) {
            Users user = (Users) intent.getSerializableExtra("user");
            if (user != null) {
                tv_id.setText(String.valueOf(user.getId()));
                tv_url.setText(user.getUrl());
                tv_html_url.setText(user.getHtml_url());
                tv_followers_url.setText(user.getFollowers_url());
                tv_following_url.setText(user.getFollowing_url());

                Picasso.get().load(user.getAvatar_url()).into(iv_avatar);
            }
        }
    }
}
