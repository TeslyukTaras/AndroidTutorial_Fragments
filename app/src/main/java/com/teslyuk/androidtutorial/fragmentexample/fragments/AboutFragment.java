package com.teslyuk.androidtutorial.fragmentexample.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.teslyuk.androidtutorial.fragmentexample.MainActivity;
import com.teslyuk.androidtutorial.fragmentexample.R;

/**
 * Created by taras.teslyuk on 4/27/17.
 */

public class AboutFragment extends Fragment {

    private View root;
    private TextView backToSignInTv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_about, container, false);

        initView();
        initListeners();

        return root;
    }

    private void initView() {
        backToSignInTv = (TextView) root.findViewById(R.id.back_signin_txt);
    }

    private void initListeners() {
        backToSignInTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).showSignIn();
            }
        });
    }
}
