package com.teslyuk.androidtutorial.fragmentexample.fragments.signin;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.teslyuk.androidtutorial.fragmentexample.MainActivity;
import com.teslyuk.androidtutorial.fragmentexample.R;

/**
 * Created by taras.teslyuk on 3/23/17.
 */

public class SignInFragment extends Fragment {

    private View root;

    private SignInContract.ISignInView view;
    private SignInContract.ISignInPresenter presenter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_signin, container, false);

        initView(root);
        initPresenter();

        return root;
    }

    private void initView(View root) {
        view = new SignInView();
        view.init(root);
    }

    private void initPresenter() {
        presenter = new SignInPresenter(view, this);
        view.setPresenter(presenter);
    }

}