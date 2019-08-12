package com.example.exchange_rate.view

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType


interface IMainFragmentView : MvpView {
    fun showBase(item: String)
    fun showError(error:String)
}