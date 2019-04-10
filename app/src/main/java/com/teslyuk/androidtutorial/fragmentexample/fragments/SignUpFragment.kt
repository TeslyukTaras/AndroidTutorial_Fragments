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

class SignUpFragment : Fragment() {

    private lateinit var root: View
    private lateinit var signUpBtn: Button
    private lateinit var signInTv: TextView
    private lateinit var loginEt: EditText
    private lateinit var emailEt: EditText
    private lateinit var passwordEt: EditText
    private lateinit var confirmPasswordEt: EditText

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        root = inflater.inflate(R.layout.fragment_signup, container, false)

        initView()
        initListeners()

        return root
    }

    private fun initView() {
        signUpBtn = root.findViewById(R.id.signup_btn)
        signInTv = root.findViewById(R.id.signin_txt)
        loginEt = root.findViewById(R.id.login_et)
        emailEt = root.findViewById(R.id.email_et)
        passwordEt = root.findViewById(R.id.password_et)
        confirmPasswordEt = root.findViewById(R.id.confirm_password_et)
    }

    private fun initListeners() {
        signUpBtn.setOnClickListener { validateInput() }
        signInTv.setOnClickListener { (activity as MainActivity).showSignIn() }
    }

    private fun validateInput() {
        loginEt.error = null
        emailEt.error = null
        passwordEt.error = null
        confirmPasswordEt.error = null

        val login = loginEt.text.toString()
        val email = emailEt.text.toString()
        val password = passwordEt.text.toString()
        val confirmPassword = confirmPasswordEt.text.toString()

        if (TextUtils.isEmpty(login)) {
            Toast.makeText(activity, "Please enter login!", Toast.LENGTH_SHORT).show()
            loginEt.error = "Please enter login!"
            return
        }

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(activity, "Please enter email!", Toast.LENGTH_SHORT).show()
            emailEt.error = "Please enter email!"
            return
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(activity, "Please enter password!", Toast.LENGTH_SHORT).show()
            passwordEt.error = "Please enter password!"
            return
        }

        if (TextUtils.isEmpty(confirmPassword)) {
            Toast.makeText(activity, "Please enter confirm password!", Toast.LENGTH_SHORT).show()
            confirmPasswordEt.error = "Please enter confirm password!"
            return
        }

        if (password != confirmPassword) {
            Toast.makeText(activity, "Passwords aren't equal!", Toast.LENGTH_SHORT).show()
            return
        }

        var hasBigCharacter = false
        for (i in 0 until password.length) {
            val c = password[i]
            if (c in 'A'..'Z') {
                hasBigCharacter = true
            }
        }

        if (!hasBigCharacter) {
            Toast.makeText(activity, "Passwords don't contain big characters!", Toast.LENGTH_SHORT).show()
            return
        }

        (activity as MainActivity).signUp(login, email, password)
    }
}
