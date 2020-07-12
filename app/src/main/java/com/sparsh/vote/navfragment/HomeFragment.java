package com.sparsh.vote.navfragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sparsh.vote.CreatePoll;
import com.sparsh.vote.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.floatBtn);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own detail action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show();
//
//            }
            public void onClick(View view) {
                Intent myintent = new Intent(getActivity(), CreatePoll.class);
                startActivity(myintent);
            }
        });
        return view;
    }
}
