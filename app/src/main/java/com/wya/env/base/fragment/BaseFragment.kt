package com.wya.env.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.wya.env.R

class BaseFragment : Fragment() {

    companion object {
        fun newInstance() = BaseFragment()
    }

    private lateinit var viewModel: BaseFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.base_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BaseFragmentViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
