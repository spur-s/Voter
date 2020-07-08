package com.sparsh.vote.navfragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.sparsh.vote.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFragment extends Fragment {
    TextView tvfullname ;
    Button btnsuscribe;
    ImageView profilepicimageview, coverpicimageview;
    RecyclerView recycler_viewpoll;

    public AccountFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        tvfullname= view.findViewById(R.id.tvfullname);
        btnsuscribe= view.findViewById(R.id.btnsuscribe);
        profilepicimageview= view.findViewById(R.id.profilepicimageview);
        coverpicimageview= view.findViewById(R.id.coverpicimageview);
        recycler_viewpoll= view.findViewById(R.id.recycler_viewpoll);

        btnsuscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }
}
