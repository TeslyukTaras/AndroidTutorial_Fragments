package com.teslyuk.androidtutorial.fragmentexample.fragments.signin;

import android.text.TextUtils;

import com.teslyuk.androidtutorial.fragmentexample.MainActivity;

public class SignInPresenter implements SignInContract.ISignInPresenter {

    private SignInContract.ISignInView view;
    private SignInFragment fragment;

    public SignInPresenter(SignInContract.ISignInView view, SignInFragment fragment) {
        this.view = view;
        this.fragment = fragment;
    }

    @Override
    public void signInClick() {
        validateInput();
    }

    private void validateInput() {
        view.hideLoginError();
        view.hidePasswordError();

        String login = view.getLoginText();
        String password = view.getPasswordText();
        if (TextUtils.isEmpty(login)) {
//            Toast.makeText(getActivity(), "Please enter login!", Toast.LENGTH_SHORT).show();
            view.showLoginError();
            return;
        }

        if (TextUtils.isEmpty(password)) {
//            Toast.makeText(getActivity(), "Please enter password!", Toast.LENGTH_SHORT).show();
            view.showPasswordError();
            return;
        }

        ((MainActivity) fragment.getActivity()).signIn(login, password);
    }

    @Override
    public void showSignUp() {
        ((MainActivity) fragment.getActivity()).showSignUp();
    }

    @Override
    public void showForgotPassword() {
        ((MainActivity) fragment.getActivity()).showForgotPassword();
    }

    @Override
    public void showAbout() {
        ((MainActivity) fragment.getActivity()).showAbout();
    }
}