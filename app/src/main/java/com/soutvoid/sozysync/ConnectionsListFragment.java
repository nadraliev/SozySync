package com.soutvoid.sozysync;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ConnectionsListFragment extends android.support.v4.app.Fragment {

    private OnFragmentInteractionListener mListener;

    public ConnectionsListFragment() {
        // Required empty public constructor
    }


    public static ConnectionsListFragment newInstance() {
        ConnectionsListFragment fragment = new ConnectionsListFragment();
        Bundle args = new Bundle();
        //set arguments here
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //get arguments
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_connections_list, container, false);

        //handle fab clicks
        rootView.findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connectionWorkerDropbox = new ConnectionWorkerDropbox();
                connectionWorkerDropbox.createConnection(getActivity().getApplicationContext());
            }
        });


        return rootView;
    }

    ConnectionWorkerDropbox connectionWorkerDropbox;

    @Override
    public void onResume() {
        try {
            if (connectionWorkerDropbox != null) {
                connectionWorkerDropbox.finishAuthorisation();
                ((TextView) getView().findViewById(R.id.sample)).setText(connectionWorkerDropbox.connection.token);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onResume();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
