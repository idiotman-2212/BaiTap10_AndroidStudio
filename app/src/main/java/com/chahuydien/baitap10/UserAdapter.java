package com.chahuydien.baitap10;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import com.chahuydien.baitap10.UsersModel.Users;

import java.util.List;

public class UserAdapter extends BaseAdapter {

    private List<Users> users;
    private Context context;

    public UserAdapter(List<Users> users, Context context) {
        this.users = users;
        this.context = context;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.user_list_item, parent, false);
        }

        TextView tvLogin = convertView.findViewById(R.id.tv_login);
        TextView tvId = convertView.findViewById(R.id.tv_id);
        TextView tvUrl = convertView.findViewById(R.id.tv_url);
        ImageView ivAvatar = convertView.findViewById(R.id.iv_avatar);

        final Users user = users.get(position);
        tvLogin.setText(user.getLogin());
        tvId.setText(String.valueOf(user.getId()));
        tvUrl.setText(user.getUrl());

        Picasso.get()
                .load(user.getAvatar_url())
                .into(ivAvatar);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UserDetailActivity.class);
                intent.putExtra("user", user);
                context.startActivity(intent);
            }
        });
        return convertView;
    }
}

