package com.example.saad.jspart3;



import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

import com.example.saad.jspart3.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyProfile extends Fragment {
    Switch myswitch;
    EditText ed_1;
    EditText ed_2;
    EditText ed_3;
    EditText ed_4;


    public MyProfile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_my_profile, container, false);
        myswitch=(Switch)view.findViewById(R.id.switch1);
        ed_1=(EditText)view.findViewById(R.id.edittext1);
        ed_2=(EditText)view.findViewById(R.id.edittext2);
        ed_3=(EditText)view.findViewById(R.id.edittext3);
        ed_4=(EditText)view.findViewById(R.id.edittext4);

        SharedPreferences sharedpref=MyProfile.this.getActivity().getPreferences(Context.MODE_PRIVATE);
        String result=sharedpref.getString("My key",null);
        /*if(result!=null)
        {
            text_view.setText(result);
        }*/
        myswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    ed_1.setEnabled(true);
                    ed_2.setEnabled(true);
                    ed_3.setEnabled(true);
                    ed_4.setEnabled(true);
                    SharedPreferences sharedpref=MyProfile.this.getActivity().getPreferences(Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedpref.edit();
                    editor.putString("My key","True");
                    editor.commit();

                }
                else {
                    ed_1.setEnabled(false);
                    ed_2.setEnabled(false);
                    ed_3.setEnabled(false);
                    ed_4.setEnabled(false);
                    SharedPreferences sharedpref=MyProfile.this.getActivity().getPreferences(Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedpref.edit();
                    editor.putString("My key","False");
                    editor.commit();

                }
            }
        });

        return view;

    }


}

