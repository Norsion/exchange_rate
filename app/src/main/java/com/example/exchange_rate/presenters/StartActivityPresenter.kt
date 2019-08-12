package com.example.exchange_rate.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.exchange_rate.view.IStartActivityView

@InjectViewState
class StartActivityPresenter:MvpPresenter<IStartActivityView>() {

    fun showFragment(){
        viewState.showFragment()
    }

}