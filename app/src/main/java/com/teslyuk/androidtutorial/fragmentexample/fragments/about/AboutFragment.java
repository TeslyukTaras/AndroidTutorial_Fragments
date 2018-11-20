package com.teslyuk.androidtutorial.fragmentexample.fragments.about;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.teslyuk.androidtutorial.fragmentexample.R;

/**
 * Created by taras.teslyuk on 4/27/17.
 */

public class AboutFragment extends Fragment {

    private AboutContract.IAboutView view;
    private AboutContract.IAboutPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_about, container, false);

        initView(root);
        initPresenter();

        return root;
    }

    public void initView(View root) {
        view = new AboutView();
        view.init(root);
    }

    public void initPresenter() {
        presenter = new AboutPresenter(this, view);
        view.setPresenter(presenter);
    }
}
