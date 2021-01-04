package com.example.maya.tabtest;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.widget.Button;
import android.widget.Toast;

import com.twitter.sdk.android.core.TwitterCore;


public class SettingFragment extends Fragment implements View.OnClickListener
{

    private OnFragmentInteractionListener mListener;

    public SettingFragment()
    {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static SettingFragment newInstance()
    {

        SettingFragment fragment = new SettingFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onResume()
    {

        super.onResume();

    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {

            //MainActivity mainActivity = (MainActivity) getActivity();
            //mainActivity.TbuttonGONE();

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_setting,container,false);



        //button_settab
        Button button_settab = (Button)view.findViewById(R.id.button_settab);
        button_settab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getContext(), TabSetupActivity.class);
                startActivity(intent);

            }
        });

        //logout_button
        Button button_logout = (Button)view.findViewById(R.id.button_logout);
        button_logout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast toast = Toast.makeText(getContext(), "ログアウトしました", Toast.LENGTH_LONG);
                toast.show();
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.finish();
                //ログアウト処理
                CookieSyncManager.createInstance(getContext());
                CookieManager cookieManager = CookieManager.getInstance();
                cookieManager.removeSessionCookie();
                TwitterCore.getInstance().getSessionManager().clearActiveSession();

                Intent intent = new Intent(getContext(), FirstActivity.class);
                startActivity(intent);

            }
        });

        //exit_button
        Button button_exit = (Button)view.findViewById(R.id.button_exit);
        button_exit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.finish();

            }
        });


        // Inflate the layout for this fragment
        return view;
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

    }

    @Override
    public void onDetach()
    {
        super.onDetach();
        mListener = null;

    }

    @Override
    public void onStop()
    {

        super.onStop();
    }


    @Override
    public void onClick(View v)
    {


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
