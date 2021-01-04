package com.example.maya.tabtest;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.tweetcomposer.ComposerActivity;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;

import java.io.File;


public class AddTweetMenu extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tweet_menu);

        /*****************
        //Uri imageUri = FileProvider.getUriForFile(AddTweetMenu.this,
        //        BuildConfig.APPLICATION_ID + ".file_provider",
        //        new File("/path/to/image"));



        TweetComposer.Builder builder = new TweetComposer.Builder(this);
                //.text("")
                //.image(imageUri);
        builder.show();

        this.finish();
                                                        ****************/


        final TwitterSession session = TwitterCore.getInstance().getSessionManager()
                .getActiveSession();
        final Intent intent = new ComposerActivity.Builder(AddTweetMenu.this)
                .session(session)
                //.image(uri)
                //.text("めぐるかわいい")
                //.hashtags("#twitter")
                .createIntent();
        startActivity(intent);


        this.finish();




    }

}
