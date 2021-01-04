package com.example.maya.tabtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.twitter.sdk.android.core.DefaultLogger;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterConfig;
import com.twitter.sdk.android.core.TwitterCore;




public class FirstActivity extends AppCompatActivity
{




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        //KeySet
        String consumerKey = getResources().getString(R.string.consumer_key);
        String consumerSecretKey = getResources().getString(R.string.consumer_secret);
        //Twitter初期化
        TwitterConfig config = new TwitterConfig.Builder(this)
                .logger(new DefaultLogger(Log.DEBUG))
                .twitterAuthConfig(new TwitterAuthConfig(consumerKey, consumerSecretKey))
                .debug(true)
                .build();
        Twitter.initialize(config);


        //Login判定
        if (TwitterCore.getInstance().getSessionManager().getActiveSession() == null)
        {
            Intent intent = new Intent(FirstActivity.this, LoginActivity.class);
            startActivity(intent);

            finish();
        }
        else
        {
            //Toast toast = Toast.makeText(FirstActivity.this, "ログイン中", Toast.LENGTH_LONG);
            //toast.show();

            Intent intent = new Intent(FirstActivity.this, MainActivity.class);
            startActivity(intent);

            finish();
        }

/*

        if (check == 1)
        {
            Intent intent = new Intent (FirstActivity.this , MainActivity.class);
            startActivity(intent);

            finish();

        }
        else
        {
            Intent intent = new Intent(FirstActivity.this, LoginActivity.class);
            startActivity(intent);

            finish();

        }*/


    }




}
