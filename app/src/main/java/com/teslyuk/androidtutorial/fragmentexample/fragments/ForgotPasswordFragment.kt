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
 * Created by taras.teslyuk on 4/27/17.
 */

class ForgotPasswordFragment : Fragment() {

    private lateinit var root: View
    private lateinit var sendRecoverCodeBtn: Button
    private lateinit var emailEt: EditText
    private lateinit var backToSignInTv: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        root = inflater.inflate(R.layout.fragment_forgot_password, container, false)

        initView()
        initListeners()

        return root
    }

    private fun initView() {
        sendRecoverCodeBtn = root.findViewById(R.id.send_recover_code_btn)
        emailEt = root.findViewById(R.id.email_et)
        backToSignInTv = root.findViewById(R.id.back_signin_txt)
    }

    private fun initListeners() {
        sendRecoverCodeBtn.setOnClickListener { validateData() }
        backToSignInTv.setOnClickListener { (activity as MainActivity).showSignIn() }
    }

    private fun validateData() {
        emailEt.error = null
        val email = emailEt.text.toString()
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(activity, "Please enter valid email!", Toast.LENGTH_SHORT).show()
            emailEt.error = "Please enter valid email!"
            return
        }

        (activity as MainActivity).sendRecoverCode(email)
    }
}
