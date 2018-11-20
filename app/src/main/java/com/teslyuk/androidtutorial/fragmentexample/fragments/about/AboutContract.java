package com.teslyuk.androidtutorial.fragmentexample.fragments.about;

import android.view.View;

public interface AboutContract {

    interface IAboutView {
        void init(View root);

        void setPresenter(IAboutPresenter presenter);
    }

    interface IAboutPresenter {
        void showSignIn();
    }

}
