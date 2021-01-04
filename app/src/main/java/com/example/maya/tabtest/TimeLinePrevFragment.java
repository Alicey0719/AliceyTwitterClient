package com.example.maya.tabtest;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ListFragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

import com.twitter.sdk.android.tweetui.SearchTimeline;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.TwitterListTimeline;
import com.twitter.sdk.android.tweetui.UserTimeline;

import java.security.Key;


public class TimeLinePrevFragment extends ListFragment
{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    // TODO: Rename and change types of parameters

    private OnFragmentInteractionListener mListener;
    private SwipeRefreshLayout mSwipe;

    TwitterListTimeline listTimeLine;
    SearchTimeline searchTimeline;
    UserTimeline userTimeline;
    ListView listView;
    int list_position = 1;
    public String tl_syurui;
    public String KeyWord;
    int flag_adp = 0;


    public TimeLinePrevFragment()
    {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters

    //インスタンス生成
    public TimeLinePrevFragment newInstance(String const_tl,String Word)
    {
        TimeLinePrevFragment fragment = new TimeLinePrevFragment();
        Bundle args = new Bundle();
        tl_syurui = const_tl;
        KeyWord = Word;

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {       }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        View v = inflater.inflate(R.layout.fragment_time_line_prev, container, false);


        TweetTimelineListAdapter adapter = SelectTimeLine(tl_syurui);
        setListAdapter(adapter);

        return v;

    }


    @Override
    public void onStart()
    {
        listView = getListView();


        listView.setOnScrollListener(new AbsListView.OnScrollListener()
        {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i)
            {
                //リストの現在地
                list_position = listView.getFirstVisiblePosition();

                //List位置で更新処理ON,OFF
                if (list_position != 0)
                {
                    mSwipe.setEnabled(false);
                }
                else if (list_position == 0)
                {
                    mSwipe.setEnabled(true);
                }

            }

            @Override
            public void onScroll(AbsListView absListView,
                                 int firstVisibleItem, int visibleItemCount, int totalItemCount)
            {
                if (totalItemCount != 0 && totalItemCount == firstVisibleItem + visibleItemCount)
                {
                    // 最後尾までスクロールしたので、何かデータ取得する処理
                }

            }

        });

        //引っ張って更新処理
        mSwipe = (SwipeRefreshLayout) getView().findViewById(R.id.refresh);
        // Callback登録
        mSwipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {
            @Override
            public void onRefresh()
            {
                //処理
                final TweetTimelineListAdapter adapter = SelectTimeLine(tl_syurui);

                new Handler().postDelayed(new Runnable()
                {
                    // Runnable型のインスタンス化と定義
                    @Override
                    public void run()
                    {
                        // 遅らせて実行したい処理
                        setListAdapter(adapter);
                        mSwipe.setRefreshing(false);

                    }
                }, 910); // 遅らせたい時間(ミリ秒) 3000ミリ秒 -> 3秒

            }
        });

        super.onStart();
    }



    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri)
    {
        if (mListener != null)
        {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener)
        {
            mListener = (OnFragmentInteractionListener) context;
        }
       // else
       // {
            //???????????????????????????
            //throw new RuntimeException(context.toString()
            //        + " must implement OnFragmentInteractionListener");
       // }
    }


    @Override
    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }




    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */



    public interface OnFragmentInteractionListener
    {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


    //PrevSelect
    public TweetTimelineListAdapter SelectTimeLine(String select)
    {



        TweetTimelineListAdapter adapter = null;

        if (KeyWord == null)
        {
            KeyWord = "";
        }

        if (select == "home") { adapter = TimeLineHomeAdp();}
        if (select == "list") { adapter = TimeLineListAdp();}
        if (select == "search") { adapter = TimeLineSearchAdp(KeyWord);}
        if (select == "user") { adapter = TimeLineUserAdp(KeyWord);}


        if (select == null ) { adapter = TimeLineHomeAdp();}


        return adapter;
    }

    //ListPrev
    public TweetTimelineListAdapter TimeLineListAdp()
    {

        if (flag_adp == 0)
        {
            listTimeLine = new TwitterListTimeline.Builder()
                    .slugWithOwnerScreenName(KeyWord, "shigure_alicey")
                    .build();

            flag_adp = 1;

        }

        final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(getContext())
                .setTimeline(listTimeLine)
                .build();

        return adapter;

    }
    public TweetTimelineListAdapter TimeLineHomeAdp()
    {
        if (flag_adp == 0)
        {
            listTimeLine = new TwitterListTimeline.Builder()
                    .slugWithOwnerScreenName("Home", "shigure_alicey")
                    .build();

            flag_adp = 1;

        }

        final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(getContext())
                .setTimeline(listTimeLine)
                .build();

        return adapter;
    }
    public TweetTimelineListAdapter TimeLineSearchAdp(String Word)
    {
        if (flag_adp == 0)
        {
            searchTimeline = new SearchTimeline.Builder()
                    .query(Word)
                    .build();

            flag_adp = 1;
        }
        final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(getContext())
                .setTimeline(searchTimeline)
                .build();

        return adapter;
    }
    public TweetTimelineListAdapter TimeLineUserAdp(String User_name)
    {
        if (flag_adp == 0)
        {
            userTimeline = new UserTimeline.Builder()
                    .screenName(User_name)
                    .build();

            flag_adp = 1;
        }
        final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(getContext())
                .setTimeline(userTimeline)
                .build();
        setListAdapter(adapter);

        return adapter;
    }

    public void searchWordInput(String w)
    {
        KeyWord = w;
        flag_adp = 0;

    }


}






