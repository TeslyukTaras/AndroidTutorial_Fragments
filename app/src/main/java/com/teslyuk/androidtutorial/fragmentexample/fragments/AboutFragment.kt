package com.teslyuk.androidtutorial.fragmentexample.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.teslyuk.androidtutorial.fragmentexample.MainActivity

import com.teslyuk.androidtutorial.fragmentexample.R

/**
 * Created by taras.teslyuk on 4/27/17.
 */

class AboutFragment : Fragment() {

    private lateinit var root: View
    private lateinit var backToSignInTv: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        root = inflater.inflate(R.layout.fragment_about, container, false)

        initView()
        initListeners()

        return root
    }

    private fun initView() {
        backToSignInTv = root.findViewById(R.id.back_signin_txt)
        initListeners()
    }

    private fun initListeners() {
        backToSignInTv.setOnClickListener { showSignIn() }
    }

    private fun showSignIn() {
        (activity as MainActivity).showSignIn()
    }
}
