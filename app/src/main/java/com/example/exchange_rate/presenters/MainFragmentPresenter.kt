package com.example.exchange_rate.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.exchange_rate.data.repository.BaseRepository
import com.example.exchange_rate.data.repository.IBaseRepository
import com.example.exchange_rate.view.IMainFragmentView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@InjectViewState
class MainFragmentPresenter: MvpPresenter<IMainFragmentView>(){

    fun getBase(item:String){
        viewState.showBase(item)
    }
}