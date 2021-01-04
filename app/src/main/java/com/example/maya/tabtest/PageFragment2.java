package com.example.maya.tabtest;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class PageFragment2 extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER



    /* メンバ変数 */
    private ListView listView;      // ListView本体
    private MyListAdapter adapter;  // Adapter


    // ボタン



    private OnFragmentInteractionListener mListener;



    // コンストラクタ
    public PageFragment2()
    {
        // Required empty public constructor
    }



    // インスタンス生成用
    public static PageFragment2 newInstance()
    {
        PageFragment2 fragment = new PageFragment2();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        // Inflate the layout for this fragment
        /* 初期化処理 */
        View view = inflater.inflate(R.layout.fragment_page2, container, false);

        listView = (ListView) view.findViewById(R.id.listView);

        // リスナーの登録


        // 配列リストの作成　仮データ保存用
        ArrayList<MyData> mItem = new ArrayList<MyData>();



        // 配列リストにデータをaddで追加
        //大きすぎる画像NG
        mItem.add(new MyData("test1", "てすと1", "くろかみ"));
        mItem.add(new MyData("test2", "てすと2", "ぎんぱつ"));
        mItem.add(new MyData("nanami_icon", "てすぅと3", "きんぱつ"));
        mItem.add(new MyData("nanami_icon", "てすぅと4", "あおかみ"));
        mItem.add(new MyData("murasame", "てすぅと5", "111111"));




        // BaseAdapter を継承したadapterのインスタンスを生成
        // このActivityのコンテキストと、追加したいデータを通知する。
        adapter = new MyListAdapter(this.getContext(), mItem);




        // ListViewにadapterをセット
        listView.setAdapter(adapter);




        // リストビューの要素が選択された時に呼び出されるコールバックリスナーを登録
        // 匿名クラスの利用
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            // 要素のクリック時に実行されるメソッド
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 選択されたアイテムを取得します

                //MyData item = (MyData) parent.getItemAtPosition(position);
                // Toast.makeText(getContext(), item.getName(), Toast.LENGTH_LONG).show();


            }

        });

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

        if (null != mListener)
        {

            if (context instanceof OnFragmentInteractionListener)
            {
                mListener = (OnFragmentInteractionListener) context;
            }
            else
            {
                throw new RuntimeException(context.toString()
                        + " must implement OnFragmentInteractionListener");
            }
        }
    }




    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



    @Override
    public void onClick(View v) {

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
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
