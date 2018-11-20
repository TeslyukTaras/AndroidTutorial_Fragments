package com.teslyuk.androidtutorial.fragmentexample.fragments.about;

import android.view.View;
import android.widget.TextView;

import com.teslyuk.androidtutorial.fragmentexample.R;

public class AboutView implements AboutContract.IAboutView {

    private TextView backToSignInTv;
    private AboutContract.IAboutPresenter presenter;

    @Override
    public void init(View root) {
        backToSignInTv = (TextView) root.findViewById(R.id.back_signin_txt);
        initListeners();
    }

    @Override
    public void setPresenter(AboutContract.IAboutPresenter presenter) {
        this.presenter = presenter;
    }

    private void initListeners() {
        backToSignInTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.showSignIn();
            }
        });
    }
}
