package com.example.maya.tabtest;

import android.support.v4.app.ListFragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.tweetui.SearchTimeline;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.Timeline;
import com.twitter.sdk.android.tweetui.TwitterListTimeline;
import com.twitter.sdk.android.tweetui.UserTimeline;
import com.twitter.sdk.android.tweetui.CollectionTimeline;
import com.twitter.sdk.android.tweetui.FixedTweetTimeline;

import twitter4j.User;


public class TimeLine_Test extends ListFragment
{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


    // TODO: Rename and change types of parameters


    private OnFragmentInteractionListener mListener;

    public TimeLine_Test()
    {
        // Required empty public constructor
    }



    // TODO: Rename and change types and number of parameters
    //インスタンス生成
    public static TimeLine_Test newInstance()
    {
        TimeLine_Test fragment = new TimeLine_Test();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {

        }



    }


    //中身
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {


        final TwitterListTimeline listTimeLine;
        listTimeLine = new TwitterListTimeline.Builder()
                .slugWithOwnerScreenName("Home", "shigure_alicey")
                .build();

        final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(getContext())
                .setTimeline(listTimeLine)
                .build();
        setListAdapter(adapter);


        /*******
        final SearchTimeline searchTimeline;
        searchTimeline = new SearchTimeline.Builder()
                .query("@shigure_alicey")
                .build();
        final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(getContext())
                .setTimeline(searchTimeline)
                .build();
        setListAdapter (adapter);
                                                                                         ***********/


        return inflater.inflate(R.layout.fragment_time_line__test, container, false);

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
}





