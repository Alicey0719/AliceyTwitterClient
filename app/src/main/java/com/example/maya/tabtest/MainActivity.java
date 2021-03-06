package com.example.maya.tabtest;

import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;

import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.tweetcomposer.ComposerActivity;

import java.sql.Time;


public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener,PageFragment.OnFragmentInteractionListener,View.OnClickListener
{

    FloatingActionButton tweetbutton;
    SearchView searchView;

    // リストタイトル配列
    final String[] pageTitle = {"Home", "List", "Search", "User", "Config" };
    String searchWord = "" ;
    TimeLinePrevFragment[] p = new TimeLinePrevFragment[10];

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // xmlからTabLayoutの取得
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        // xmlからViewPagerを取得
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);



        //FloatingActionButton
        tweetbutton = (FloatingActionButton) findViewById(R.id.TweetButton);
                tweetbutton.setSize(0);

        //searchView

        searchView = (SearchView) findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener()
        {

            // クエリーを送信
            @Override
            public boolean onQueryTextSubmit(String query)
            {
                //TimeLinePrevFragment.searchWordInput(query);
                //searchWord = query;
                p[2].searchWordInput(query);
                //TimeLinePrevFragment fragment = FragmentManager.getFragments();



                return false;
            }

            // クエリーを編集中
            @Override
            public boolean onQueryTextChange(String newText)
            {
                return false;
            }
        });



        // 表示Pageに必要な項目を設定
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager())
        {

            @Override
            public Fragment getItem(int position)
            {

                    switch (position)
                    {
                        case 0:
                            p[0] = new TimeLinePrevFragment();
                            p[0].tl_syurui = "home";
                            p[0].KeyWord = "null";
                            return p[0];
                            //return TimeLinePrevFragment.newInstance("home","null");
                        case 1:
                            p[1] = new TimeLinePrevFragment();
                            p[1].tl_syurui = "list";
                            p[1].KeyWord = "list4";
                            return p[1];
                            //return TimeLinePrevFragment.newInstance("list","list3");

                        case 2:
                            p[2] = new TimeLinePrevFragment();
                            p[2].tl_syurui = "search";
                            p[2].KeyWord = "";
                            return p[2];
                           //return TimeLinePrevFragment.newInstance("search",searchWord);

                        case 3:
                            p[3] = new TimeLinePrevFragment();
                            p[3].tl_syurui = "user";
                            p[3].KeyWord = "KST_BC_";
                            return p[3];
                           //return TimeLinePrevFragment.newInstance("user","yuzusoft");

                        /*
                        case 4:
                            p[4] = new TimeLinePrevFragment();
                            p[4].tl_syurui = "test";
                            p[4].KeyWord = "null";
                            return p[4];
                           // return TimeLinePrevFragment.newInstance("test","null");
                           */

                        case 4:
                            return SettingFragment.newInstance();


                        default:
                             return BlankFragment.newInstance();

                    }
            }


            @Override
            public CharSequence getPageTitle(int position)
            {
                return pageTitle[position];

            }


            @Override
            public int getCount()
            {
                return pageTitle.length;

            }

        };



        // ViewPagerにページを設定
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener((ViewPager.OnPageChangeListener) this);


        // ViewPagerをTabLayoutを設定
        tabLayout.setupWithViewPager(viewPager);

        //FABボタンクリック
        findViewById(R.id.TweetButton).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                TweetButtonClickEvent(v);
            }
        });


    }

    //TweetButtonOnClickイベント
    private void TweetButtonClickEvent(View v)
    {
        Intent intent = new Intent (MainActivity.this , AddTweetMenu.class);
        startActivity(intent);

    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
    {

    }


    @Override
    public void onPageSelected(int position)
    {
         if (position == (pageTitle.length - 1)) { TbuttonGONE(); }
         else if (position == 2 )  { setSearchViewVisible(1); }
         else
             {
             TbuttonVISIBLE();
             setSearchViewVisible(0);
         }
    }


    @Override
    public void onPageScrollStateChanged(int state)
    {

    }


    @Override
    public void onFragmentInteraction(Uri uri)
    {
        // Fragment
    }


    @Override
    public void onClick(View view)
    {

    }

    public void TbuttonGONE ()
    {
        tweetbutton.setVisibility(View.GONE);

    }

    public void TbuttonVISIBLE ()
    {
        tweetbutton.setVisibility(View.VISIBLE);

    }

    public void setSearchViewVisible(int a)
    {
        if (a == 1)
        {
            searchView.setVisibility(View.VISIBLE);
        }
        else
        {
            searchView.setVisibility(View.GONE);
        }

    }





}
