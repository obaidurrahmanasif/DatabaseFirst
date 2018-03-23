package com.example.obaidurrahman.databasefirst;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Pavilion on 03/23/2018.
 */

public class AddContactFragment extends Fragment {
    private View view;
    private EditText inpName;
    private EditText inpNumber;
    private Button addBtn;
    DatabaseHelper helper;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.addcontactlayout,container,false);
        helper=new DatabaseHelper(getActivity().getBaseContext());
        inpName=view.findViewById(R.id.inpname);
        inpNumber=view.findViewById(R.id.inpnumber);
        addBtn=view.findViewById(R.id.btnok);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sname=inpName.getText().toString();
                String snumber=inpNumber.getText().toString();
                Contacts contacts=new Contacts();
                contacts.setName(sname);
                contacts.setNumber(Integer.parseInt(snumber));
            boolean flag=helper.insetContacts(contacts);
            if(flag==true)
                Toast.makeText(getActivity().getBaseContext(),"Data Inserted",Toast.LENGTH_LONG).show();
             else   Toast.makeText(getActivity().getBaseContext(),"Data not Inserted",Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}
