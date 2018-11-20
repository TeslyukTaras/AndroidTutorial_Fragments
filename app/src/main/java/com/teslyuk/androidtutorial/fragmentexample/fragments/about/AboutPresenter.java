package com.teslyuk.androidtutorial.fragmentexample.fragments.about;

import com.teslyuk.androidtutorial.fragmentexample.MainActivity;

public class AboutPresenter implements AboutContract.IAboutPresenter {

    private AboutFragment fragment;
    private AboutContract.IAboutView view;

    public AboutPresenter(AboutFragment fragment, AboutContract.IAboutView view) {
        this.fragment = fragment;
        this.view = view;
    }

    @Override
    public void showSignIn() {
        ((MainActivity) fragment.getActivity()).showSignIn();
    }
}
