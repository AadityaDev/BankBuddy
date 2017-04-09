package com.technawabs.bankbuddy.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.technawabs.bankbuddy.R;

public class ImageFragment extends BaseFragment {

    private int mPosition;

    public void setmPosition(int mPosition) {
        this.mPosition = mPosition;
    }

    public static ImageFragment newInstance(int mPosition) {
        ImageFragment fragment = new ImageFragment();
        fragment.setmPosition(mPosition);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image, container, false);
//        ((ImageView) view.findViewById(R.id.imagefragment_image)).setImageResource(R.mipmap.ic_launcher_round);

        return view;
    }

    public void onImageClicked(View view) {
        Toast.makeText(getActivity().getApplicationContext(), "position: " + mPosition, Toast.LENGTH_SHORT).show();
    }

}
