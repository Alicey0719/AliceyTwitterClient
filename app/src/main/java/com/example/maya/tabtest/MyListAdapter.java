package com.example.maya.tabtest;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class MyListAdapter extends BaseAdapter {



    /* メンバ変数 */
    private Context mContext;                    // コンテキスト(おまじないとしておく)
    private List<MyData> mItem;                  // List構造　作成したクラスの要素を保存する
    private LayoutInflater mLayoutInflater;     // リスト要素のレイアウト




    /* コンストラクタ */
    public MyListAdapter(Context context, List<MyData> items){
        mContext = context;
        mItem = items;
        mLayoutInflater = LayoutInflater.from(context);
    }



    // リスト内の要素数の取得
    @Override
    public int getCount()
    {
        return mItem.size();
    }



    // 引数で指定された場所のデータを取得する。
    @Override
    public Object getItem(int position)
    {
        return mItem.get(position);
    }



    // 引数で指定した要素のIDを取得する。
    @Override
    public long getItemId(int position)
    {
        return position;
    }



    // 要素を取得する。ListView側から、要素を取得し表示するに呼ばれる。
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

        // nullチェック
        if (convertView == null)
        {
            // 新規作成
            convertView = mLayoutInflater.inflate(R.layout.activity_my_list_adapter, parent, false);

        }




        // 指定位置のデータを取得する
        MyData item = mItem.get(position);



        // リソース情報の取得
        Resources res = mContext.getResources();



        // res の drawableフォルダにあるデータをメンバ変数のデータ(ファイル名)を元にリソースIDに変換する
        int imgId = res.getIdentifier(mItem.get(position).getIcon(), "drawable", mContext.getPackageName());



        // レイアウトに各要素を設定する。
        ((ImageView) convertView.findViewById(R.id.icon)).setImageResource(imgId);
        ((TextView) convertView.findViewById(R.id.name)).setText(mItem.get(position).getName());
        ((TextView) convertView.findViewById(R.id.text)).setText(mItem.get(position).getText());



        // データを応答する。
        return convertView;

    }



    /**
     *  データ追加メソッド
     *  @param arg_index 追加位置 0オリジン
     *  @param arg_data 追加データ
     *  */
    public void add(int arg_index, MyData arg_data)
    {
        mItem.add(arg_index,arg_data);
    }



    /**
     *  データ削除メソッド
     *  @param arg_index 削除位置 0オリジン
     *  */
    public void delete(int arg_index)
    {
        mItem.remove(arg_index);
    }


}
