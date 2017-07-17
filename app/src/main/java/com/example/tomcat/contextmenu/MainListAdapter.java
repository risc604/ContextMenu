package com.example.tomcat.contextmenu;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by tomcat on 2017/7/17.
 */

public class MainListAdapter extends BaseAdapter
{
    private Activity activity;
    private List<String> mTextView;
    private static LayoutInflater inflater = null;

    public MainListAdapter(Activity a, List<String> str)
    {
        activity = a;
        mTextView = str;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mTextView.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        View vi = view;
        if (view == null)
        {
            vi = inflater.inflate(R.layout.main_list_item, null);
        }

        TextView TextView1 = (TextView) vi.findViewById(R.id.TextView1);
        TextView1.setText(mTextView.get(i).toString());
        return vi;
    }
}
