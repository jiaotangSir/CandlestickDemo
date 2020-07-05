package com.hangtian.candlestickdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonActivity extends AppCompatActivity {

    private TextView tvUserInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

        tvUserInfo = findViewById(R.id.tvUserInfo);


//        String result = "{\"name\":\"张三\",\"age\":12}";
//
//        try {
//            JSONObject object = new JSONObject(result);
//            String name = object.getString("name");
//            int age = object.getInt("age");
//            User mUser = new User();
//            mUser.setName(name);
//            mUser.setAge(age);
//
//            tvUserInfo.setText(mUser.name);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

        initArray();
    }

    private void initArray() {
        ArrayList<User> mUserList = new ArrayList<>();

        String result = "[{\"name\":\"张三\",\"age\":12},{\"name\":\"李四\",\"age\":15}]";
        try {
            JSONArray array = new JSONArray(result);
            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                String name = object.getString("name");
                int age = object.getInt("age");
                User mUser = new User();
                mUser.setName(name);
                mUser.setAge(age);
                mUserList.add(mUser);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String names = mUserList.get(0).name +","+ mUserList.get(1).name;
        tvUserInfo.setText(names);

    }


    class User {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
