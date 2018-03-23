package com.example.obaidurrahman.databasefirst;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Pavilion on 03/23/2018.
 */

public class ViewContactFragment extends Fragment {
   private View view;
    DatabaseHelper helper;
    private ListView listView;
    private Context context;
    private CustomAdapter adapter;
    private List<Contacts> contactsList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.viewfragmentlayout,container,false);
        context=getActivity().getBaseContext();

        helper=new DatabaseHelper(getActivity().getBaseContext());
        contactsList=helper.getContacts();
        adapter=new CustomAdapter(context,contactsList);
       listView=view.findViewById(R.id.mylist);
       listView.setAdapter(adapter);
       adapter.notifyDataSetChanged();
        return view;
    }
}
