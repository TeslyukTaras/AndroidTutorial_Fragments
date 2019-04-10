package com.teslyuk.androidtutorial.fragmentexample.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

import com.teslyuk.androidtutorial.fragmentexample.MainActivity
import com.teslyuk.androidtutorial.fragmentexample.R

/**
 * Created by taras.teslyuk on 3/23/17.
 */

class SignInFragment : Fragment() {

    private lateinit var root: View

    private lateinit var signInBtn: Button
    private lateinit var signUpTv: TextView
    private lateinit var forgotPasswordTv: TextView
    private lateinit var aboutTv: TextView
    private lateinit var loginEt: EditText
    private lateinit var passwordEt: EditText

    private val loginText: String
        get() = loginEt.text.toString()

    private val passwordText: String
        get() = passwordEt.text.toString()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        root = inflater.inflate(R.layout.fragment_signin, container, false)
        initView()
        return root
    }

    private fun initView() {
        signInBtn = root.findViewById(R.id.signin_btn)
        signUpTv = root.findViewById(R.id.signup_txt)
        forgotPasswordTv = root.findViewById(R.id.forgot_password_txt)
        aboutTv = root.findViewById(R.id.about_txt)
        loginEt = root.findViewById(R.id.login_et)
        passwordEt = root.findViewById(R.id.password_et)
        initListeners()
    }

    private fun initListeners() {
        signInBtn.setOnClickListener { signInClick() }
        signUpTv.setOnClickListener { showSignUp() }
        forgotPasswordTv.setOnClickListener { showForgotPassword() }
        aboutTv.setOnClickListener { showAbout() }
    }

    private fun hideLoginError() {
        loginEt.error = null
    }

    private fun hidePasswordError() {
        passwordEt.error = null
    }

    private fun showLoginError() {
        loginEt.error = "Please enter login!"
    }

    private fun showPasswordError() {
        passwordEt.error = "Please enter password!"
    }

    //logic
    private fun signInClick() {
        validateInput()
    }

    private fun validateInput() {
        hideLoginError()
        hidePasswordError()

        val login = loginText
        val password = passwordText
        if (TextUtils.isEmpty(login)) {
            Toast.makeText(activity, "Please enter login!", Toast.LENGTH_SHORT).show();
            showLoginError()
            return
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(activity, "Please enter password!", Toast.LENGTH_SHORT).show();
            showPasswordError()
            return
        }

        (activity as MainActivity).signIn(login, password)
    }

    private fun showSignUp() {
        (activity as MainActivity).showSignUp()
    }

    private fun showForgotPassword() {
        (activity as MainActivity).showForgotPassword()
    }

    private fun showAbout() {
        (activity as MainActivity).showAbout()
    }
}