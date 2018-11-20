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
    private Button signInBtn;
    private TextView signUpTv, forgotPasswordTv, aboutTv;
    private EditText loginEt, passwordEt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_signin, container, false);

        initView();
        initListeners();

        return root;
    }


    private void initView() {
        signInBtn = (Button) root.findViewById(R.id.signin_btn);
        signUpTv = (TextView) root.findViewById(R.id.signup_txt);
        forgotPasswordTv = (TextView) root.findViewById(R.id.forgot_password_txt);
        aboutTv = (TextView) root.findViewById(R.id.about_txt);
        loginEt = (EditText) root.findViewById(R.id.login_et);
        passwordEt = (EditText) root.findViewById(R.id.password_et);
    }

    private void initListeners() {
        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateInput();
            }
        });

        signUpTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).showSignUp();
            }
        });

        forgotPasswordTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).showForgotPassword();
            }
        });

        aboutTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).showAbout();
            }
        });
    }

    private void validateInput() {
        loginEt.setError(null);
        passwordEt.setError(null);
        String login = loginEt.getText().toString();
        String password = passwordEt.getText().toString();
        if (TextUtils.isEmpty(login)) {
            Toast.makeText(getActivity(), "Please enter login!", Toast.LENGTH_SHORT).show();
            loginEt.setError("Please enter login!");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getActivity(), "Please enter password!", Toast.LENGTH_SHORT).show();
            passwordEt.setError("Please enter password!");
            return;
        }

        ((MainActivity) getActivity()).signIn(login, password);
    }

}
