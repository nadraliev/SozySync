package com.soutvoid.sozysync;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by andrew on 20.04.16.
 */
public class ProfilesListFragment extends android.support.v4.app.Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profiles_list, container, false);

        rootView.findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Snackbar", Snackbar.LENGTH_LONG).show();
            }
        });

        return rootView;
    }

    public static ProfilesListFragment newInstance() {
        ProfilesListFragment fragment = new ProfilesListFragment();
        Bundle args = new Bundle();
        //set arguments here
        fragment.setArguments(args);
        return fragment;
    }
}
