package com.teslyuk.androidtutorial.fragmentexample

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.teslyuk.androidtutorial.fragmentexample.fragments.AboutFragment
import com.teslyuk.androidtutorial.fragmentexample.fragments.ForgotPasswordFragment
import com.teslyuk.androidtutorial.fragmentexample.fragments.SignInFragment
import com.teslyuk.androidtutorial.fragmentexample.fragments.SignUpFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        connectToAuthServer()
        showSignIn()
    }

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
    }

    fun replaceFragment(fragment: Fragment, containerId: Int) {
        supportFragmentManager.beginTransaction()
                .replace(containerId, fragment)
                .addToBackStack(null)
                .commit()
    }

    fun addFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit()
    }

    fun showSignUp() {
        replaceFragment(SignUpFragment())
    }

    fun showSignIn() {
        replaceFragment(SignInFragment())
    }

    fun showForgotPassword() {
        replaceFragment(ForgotPasswordFragment())
    }

    fun showAbout() {
        replaceFragment(AboutFragment())
    }

    fun connectToAuthServer() {
        Toast.makeText(this, "Connect to Auth server!", Toast.LENGTH_SHORT).show()
    }

    fun signIn(login: String, password: String) {
        Toast.makeText(this, "You are logged in!", Toast.LENGTH_SHORT).show()
    }

    fun signUp(login: String, email: String, password: String) {
        Toast.makeText(this, "You are Signed up!", Toast.LENGTH_SHORT).show()
    }

    fun sendRecoverCode(email: String) {
        Toast.makeText(this, "You will receive recover code!", Toast.LENGTH_SHORT).show()
    }
}
