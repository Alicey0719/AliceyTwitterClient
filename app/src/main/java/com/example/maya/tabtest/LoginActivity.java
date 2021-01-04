package com.example.maya.tabtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.DefaultLogger;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterConfig;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;


public class LoginActivity extends AppCompatActivity
{


    private TwitterLoginButton mLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        mLoginButton = (TwitterLoginButton)findViewById(R.id.login_button);
        mLoginButton.setEnabled(true);
        mLoginButton.setCallback(new Callback<TwitterSession>()
        {
            @Override
            public void success(Result<TwitterSession> result)
            {
                Toast toast = Toast.makeText(LoginActivity.this, "ログイン成功", Toast.LENGTH_LONG);
                toast.show();

                showTimeLine();

                finish();
            }

            @Override
            public void failure(TwitterException exception)
            {
                Toast toast = Toast.makeText(LoginActivity.this, "ログイン失敗:"+exception, Toast.LENGTH_LONG);
                toast.show();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        // Pass the activity result to the login button.
        mLoginButton.onActivityResult(requestCode, resultCode, data);
    }

    private void showTimeLine()
    {

        final Intent intent = new Intent(this, FirstActivity.class);
        startActivity(intent);


    }


}
