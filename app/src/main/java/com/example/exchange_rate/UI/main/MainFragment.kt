package com.example.exchange_rate.UI.main


import android.os.Bundle
import android.view.*
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.exchange_rate.App
import com.example.exchange_rate.view.IMainFragmentView
import com.example.exchange_rate.presenters.MainFragmentPresenter
import com.example.exchange_rate.R
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : MvpAppCompatFragment(), IMainFragmentView {



    @InjectPresenter
    lateinit var presenter: MainFragmentPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        presenter.getBase(arguments?.getString("rub")?:"")
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageViewLogout.setOnClickListener {
            activity?.finish()
        }
    }

    override fun showBase(item: String) {
            rate_value.text = item
        }

        override fun showError(error: String) {
            Toast.makeText(context, error, Toast.LENGTH_LONG).show()
        }



}