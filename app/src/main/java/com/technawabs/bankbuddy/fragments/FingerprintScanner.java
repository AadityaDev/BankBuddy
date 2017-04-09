package com.technawabs.bankbuddy.fragments;

import android.content.Context;
import android.content.Intent;
import android.hardware.fingerprint.FingerprintManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.technawabs.bankbuddy.R;
import com.technawabs.bankbuddy.constants.AppError;
import com.technawabs.bankbuddy.fragments.fingerprint.FingerPrintAuthCallback;
import com.technawabs.bankbuddy.fragments.fingerprint.FingerPrintAuthHelper;
import com.technawabs.bankbuddy.utils.Utility;

public class FingerprintScanner extends BaseFragment implements FingerPrintAuthCallback, View.OnClickListener {

    private TextView mAuthMsgTv;
    private Button mGoToSettingsBtn;

    private TextView fingerprintSupport;
    private TextView cancelAction;
    private ImageView dialpadAction;
    private FingerPrintAuthHelper mFingerPrintAuthHelper;
    private OnFragmentInteractionListener mListener;

    public FingerprintScanner() {
        // Required empty public constructor
    }

//    public static FingerprintScanner newInstance(String param1, String param2) {
//        FingerprintScanner fragment = new FingerprintScanner();
//        Bundle args = new Bundle();
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fingerprint_scanner, container, false);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mFingerPrintAuthHelper = FingerPrintAuthHelper.getHelper(getContext(), this);
        } else {
            Log.d(getTAG(), "Version is below m");
        }

        fingerprintSupport = (TextView) view.findViewById(R.id.fingerprint_support);
        cancelAction = (TextView) view.findViewById(R.id.cancel_action);
        dialpadAction = (ImageView) view.findViewById(R.id.dialpad_action);

        fingerprintSupport.setOnClickListener(this);
        cancelAction.setOnClickListener(this);
        dialpadAction.setOnClickListener(this);
        cancelAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(getTAG(), "Cancel");
                Toast.makeText(getContext(), "Dialpad Clicked", Toast.LENGTH_LONG).show();
            }
        });
        dialpadAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Dialpad Clicked", Toast.LENGTH_SHORT).show();
                Log.d(getTAG(), "Dialpad Clicked");
                Intent dial = new Intent(Intent.ACTION_DIAL);
                startActivity(dial);
            }
        });

        mGoToSettingsBtn = (Button) view.findViewById(R.id.go_to_settings_btn);
        mGoToSettingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Utility.isSupportedHardware(getContext())) {
                    Log.d(getTAG(), "Hardware Supported");
                    Toast.makeText(getContext(), "Hardware supported", Toast.LENGTH_SHORT).show();
                    Utility.openSecuritySettings(getContext());
                } else {
                    Log.d(getTAG(), "Hardware Not Supported");
                    Toast.makeText(getContext(), "Hardware Not supported", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mAuthMsgTv = (TextView) view.findViewById(R.id.auth_message_tv);

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

    @Override
    public void onResume() {
        super.onResume();

        mGoToSettingsBtn.setVisibility(View.GONE);
        mAuthMsgTv.setText("Scan your finger");

        if (mFingerPrintAuthHelper != null) {
            mFingerPrintAuthHelper.startAuth();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
//        mFingerPrintAuthHelper.stopAuth();
    }

    @Override
    public void onNoFingerPrintHardwareFound() {
        mAuthMsgTv.setText("Your device does not have finger print scanner. Please type 1234 to authenticate.");

    }

    @Override
    public void onNoFingerPrintRegistered() {
        mAuthMsgTv.setText("There are no finger prints registered on this device. Please register your finger from settings.");
        mGoToSettingsBtn.setVisibility(View.VISIBLE);
    }

    @Override
    public void onBelowMarshmallow() {
        mAuthMsgTv.setText("You are running older version of android that does not support finger print authentication. Please type 1234 to authenticate.");
    }

    @Override
    public void onAuthSuccess(FingerprintManager.CryptoObject cryptoObject) {
        Toast.makeText(getContext(), "Authentication succeeded.", Toast.LENGTH_SHORT).show();
//        startActivity(new Intent(getContext(), AuthSuccessScreen.class));
    }

    @Override
    public void onAuthFailed(int errorCode, String errorMessage) {
        switch (errorCode) {
            case AppError.AuthError.CANNOT_RECOGNIZE_ERROR:
                mAuthMsgTv.setText("Cannot recognize your finger print. Please try again.");
                break;
            case AppError.AuthError.NON_RECOVERABLE_ERROR:
                mAuthMsgTv.setText("Cannot initialize finger print authentication. Please type 1234 to authenticate.");
                break;
            case AppError.AuthError.RECOVERABLE_ERROR:
                mAuthMsgTv.setText(errorMessage);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fingerprint_image:
                break;
            case R.id.dialpad_action:
                Toast.makeText(getContext(), "Dialpad Clicked", Toast.LENGTH_SHORT).show();
                Log.d(getTAG(), "Dialpad Clicked");
                break;
            case R.id.cancel_action:
                Toast.makeText(getContext(), "Cancel Clicked", Toast.LENGTH_SHORT).show();
                Log.d(getTAG(), "Cancel Clicked");
                fingerprintSupport.setText("cancel");
                break;
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


    private void initializeScanner(@NonNull String algorithm) {
//        try {
//            fingerprintManagerCompat.from(getActivity());
//            if (fingerprintManagerCompat.isHardwareDetected()) {
//                signature = Signature.getInstance(algorithm);
//                cryptoObject = new FingerprintManagerCompat.CryptoObject(signature);
//            } else {
//
//            }
//        } catch (NoSuchAlgorithmException e) {
//            ExceptionUtility.exceptionMessage(e, TAG);
//        } catch (Exception e) {
//            ExceptionUtility.exceptionMessage(e, TAG);
//        } finally {
//
//        }
    }

}
