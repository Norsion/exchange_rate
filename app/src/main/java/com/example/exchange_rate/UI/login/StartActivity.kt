package com.example.exchange_rate.UI.login


import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.exchange_rate.App
import com.example.exchange_rate.R
import com.example.exchange_rate.presenters.StartActivityPresenter
import com.example.exchange_rate.view.IStartActivityView


class StartActivity : MvpAppCompatActivity(), IStartActivityView  {

    @InjectPresenter
    lateinit var mPresenter: StartActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        mPresenter.showFragment()
    }
    override fun showFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, LogInFragment())
            .addToBackStack(null)
            .commit()
    }
}
