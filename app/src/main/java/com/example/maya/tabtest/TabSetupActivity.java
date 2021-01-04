package com.example.maya.tabtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class TabSetupActivity extends AppCompatActivity
{

    // 選択肢
    private String spinnerItems[] = {"1", "2", "3","4","5","6","7","8","9","10"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_setup);


        Spinner spinner_tabkazu = (Spinner) findViewById(R.id.tab_kazu);

        // ArrayAdapter
        ArrayAdapter<String> adapter
                = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, spinnerItems);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // spinner に adapter をセット
        spinner_tabkazu.setAdapter(adapter);

        // リスナーを登録
        spinner_tabkazu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            //　アイテムが選択された時
            @Override
            public void onItemSelected(AdapterView<?> parent,
                                       View view, int position, long id)
            {
                Spinner spinner = (Spinner)parent;
                String item = (String)spinner.getSelectedItem();

                Toast toast = Toast.makeText(TabSetupActivity.this, item, Toast.LENGTH_LONG);
                toast.show();

            }

            //　アイテムが選択されなかった
            public void onNothingSelected(AdapterView<?> parent) {
                //

            }
        });



    }
}
