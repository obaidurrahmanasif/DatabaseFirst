package com.example.obaidurrahman.databasefirst;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Pavilion on 03/23/2018.
 */

public class CustomAdapter extends BaseAdapter{
    private Context context;
    private List<Contacts> contactsList;
    CustomAdapter(Context context, List<Contacts> contactsList) {
        this.context=context;
        this.contactsList=contactsList;

    }

    @Override
    public int getCount() {
        return contactsList.size();
    }

    @Override
    public Object getItem(int position) {
        return contactsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(context);
        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.childlayout,null);
        }
        TextView nameView;
        TextView numberView;
        nameView=convertView.findViewById(R.id.name);
        numberView=convertView.findViewById(R.id.number);

        nameView.setText(contactsList.get(position).getName());
        nameView.setText(""+contactsList.get(position).getNumber());
        return convertView;
    }
}
