package com.example.maya.tabtest;


/* 要素用データクラス */
public class MyData {


    /* メンバ変数 */
    private String icon;     // icon画像のファイル名
    private String name;    // アカウント名
    private String text;     // 文章



    /* コンストラクタ 開始 */
    // 引数なし
    public MyData(){
        this.icon = "ic_menu_edit";
        this.name = "No Name";
        this.text = "Text is Nothing";
    }



    // 引数あり
    public MyData(
            String arg_icon,
            String arg_name,
            String arg_text
    ){
        this.icon = arg_icon;
        this.name = arg_name;
        this.text = arg_text;
    }

    /* コンストラクタ 終了 */




    /* ゲッター・セッター */
    public String getIcon()
    {
        return this.icon;
    }


    public void setIcon(String arg_icon)
    {
        this.icon = arg_icon;
    }


    public String getName()
    {
        return this.name;
    }


    public void setName(String arg_name)
    {
        this.name = arg_name;
    }


    public String getText()
    {
        return this.text;
    }


    public void setText(String arg_text)
    {
        this.text = arg_text;
    }

}

