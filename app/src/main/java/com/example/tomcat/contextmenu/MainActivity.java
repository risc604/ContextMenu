package com.example.tomcat.contextmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    ListView listview;
    String[] values = new String[] { "item1", "item2", "item3", "item4", "item5" };
    int pos = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView) findViewById(R.id.listview1);

        final ArrayList<String> list = new ArrayList<String>();
        for(int i=0; i<values.length; ++i)
        {
            list.add(values[i]);
        }

        MainListAdapter mAdapter = new MainListAdapter (this, list);
        listview.setAdapter(mAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                listview.showContextMenuForChild(view);
            }
        });

        // 註冊浮動功能表給 view, 在本例為 listview
        this.registerForContextMenu(listview);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        switch (id)
        {
            case R.id.action_settings:
                Toast.makeText(this, "list " + pos + " menu 設定", Toast.LENGTH_LONG );
                return  true;

            case R.id.action_new:
                Toast.makeText(this, "list " + pos + " menu 新增", Toast.LENGTH_LONG );
                return  true;

            case R.id.action_edit:
                Toast.makeText(this, "list " + pos + " menu 修改", Toast.LENGTH_LONG );
                pos = -1;
                return  true;
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater    inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);

        AdapterView.AdapterContextMenuInfo  info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        pos = info.position + 1;
        menu.setHeaderTitle("選取 " + values[info.position]);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //return super.onContextItemSelected(item);

        return onOptionsItemSelected(item);
    }

    public void onListItemClick(ListView l, View v, int position, long id){
        l.showContextMenuForChild(v);
    }


}
