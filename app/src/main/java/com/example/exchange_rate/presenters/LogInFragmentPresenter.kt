package com.example.exchange_rate.presenters

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.exchange_rate.data.repository.BaseRepository
import com.example.exchange_rate.view.ILogInFragmentView
import com.example.partytask.data.network.ApiClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers



@InjectViewState
class LogInFragmentPresenter:MvpPresenter<ILogInFragmentView>(){

    //@Inject lateinit
    var baseRepository: BaseRepository = BaseRepository()

    fun isEmailValid(email:CharSequence):Boolean {
           return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()

    }
    fun isPasswordValid(password:CharSequence):Boolean {
        val regex = Regex("""^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\S+${'$'}).{8,}""")
        return regex.matches(password)
    }

    fun getValue(){
        baseRepository.getBase()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d("Repo", "this is рубль ${it.rate?.RUB}")
                viewState.requestComplited(it.rate?.RUB.toString())
                Log.d("Repo", "this is метод ${ApiClient.instance.apiService.getBase()}")
                Log.d("LogInPresenter","this is ${it.rate?.RUB.toString()}")
            }, {

            })
    }
}