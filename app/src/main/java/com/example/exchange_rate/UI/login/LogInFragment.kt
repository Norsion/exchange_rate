package com.example.exchange_rate.UI.login


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.exchange_rate.R
import com.example.exchange_rate.UI.main.MainFragment
import com.example.exchange_rate.presenters.LogInFragmentPresenter
import com.example.exchange_rate.view.ILogInFragmentView
import kotlinx.android.synthetic.main.fragment_login.*

class LogInFragment : MvpAppCompatFragment(), ILogInFragmentView {

    @InjectPresenter
    lateinit var presenter: LogInFragmentPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        add_email_edit_text.setOnFocusChangeListener { _, _ ->
            if(!presenter.isEmailValid(add_email_edit_text.text.trim()) && add_email_edit_text.text.isNotEmpty()) {
                add_email_edit_text.error = "Incorrect email!"
            }
        }
        add_password_edit_text.setOnFocusChangeListener { _, _ ->
            if(!presenter.isPasswordValid(add_password_edit_text.text) && add_password_edit_text.text.isNotEmpty()) {
                add_password_edit_text.error = "Incorrect password!"
            }
        }
        button_login.setOnClickListener {
            when(presenter.isEmailValid(add_email_edit_text.text) &&  presenter.isPasswordValid(add_password_edit_text.text)){
                false -> Toast.makeText(context, "Incorrect username or password.", Toast.LENGTH_LONG).show()
                true -> {
                    presenter.getValue()
                    Log.d("Error", "this is ${presenter.getValue()}")
                }
            }
        }
    }

    override fun requestComplited(item: String) {
        var mainFragment = MainFragment()
        var bundle = Bundle()
        bundle.putString("rub", item)
        mainFragment.arguments = bundle
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.container, mainFragment)
            ?.commit()
    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_login, container, false)
    }




}