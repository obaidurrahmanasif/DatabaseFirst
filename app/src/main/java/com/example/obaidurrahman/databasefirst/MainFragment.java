package com.example.obaidurrahman.databasefirst;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Pavilion on 03/23/2018.
 */

public class MainFragment extends Fragment {
    private View view;
    private Button addContact;
    private Button viewButton;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.mainfragmentlayout,container,false);
        addContact=view.findViewById(R.id.navadd);
        viewButton=view.findViewById(R.id.navview);
        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager=getFragmentManager();
                manager.beginTransaction().replace(R.id.changView,new ViewContactFragment()).commit();
            }
        });
        addContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager=getFragmentManager();
                manager.beginTransaction().replace(R.id.changView,new AddContactFragment()).commit();
            }
        });

        return view;
    }
}
