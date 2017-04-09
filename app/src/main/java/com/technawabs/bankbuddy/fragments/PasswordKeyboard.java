package com.technawabs.bankbuddy.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.technawabs.bankbuddy.R;

public class PasswordKeyboard extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private TextView passwordNum1;
    private TextView passwordNum2;
    private TextView passwordNum3;
    private TextView passwordNum4;
    private GridView numberGrid;
    private String mParam1;
    private OnFragmentInteractionListener mListener;

    public PasswordKeyboard() {
        // Required empty public constructor
    }

    public static PasswordKeyboard newInstance(String param1) {
        PasswordKeyboard fragment = new PasswordKeyboard();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_password_keyboard, container, false);
        passwordNum1 = (TextView) view.findViewById(R.id.password_num_1);
        passwordNum2 = (TextView) view.findViewById(R.id.password_num_2);
        passwordNum3 = (TextView) view.findViewById(R.id.password_num_3);
        passwordNum4 = (TextView) view.findViewById(R.id.password_num_4);
        numberGrid = (GridView) view.findViewById(R.id.number_grid);
//        numberGrid.set
        return view;
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
        void onFragmentInteraction(Uri uri);
    }
}
