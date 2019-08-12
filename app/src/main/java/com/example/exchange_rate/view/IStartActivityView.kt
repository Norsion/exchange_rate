package com.example.exchange_rate.view

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType


interface IStartActivityView:MvpView {
    fun showFragment()
}