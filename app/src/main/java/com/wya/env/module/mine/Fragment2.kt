package com.wya.env.module.mine

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.wya.env.R

/**
 * @date: 2018/7/3 13:55
 * @author: Chunjiang Mao
 * @classname: Fragment2
 * @describe: Example Fragment
 */
class Fragment2 : Fragment() {

    private lateinit var rootView: View
    private var tvExample: TextView? = null

    @SuppressLint("NewApi")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        rootView = View.inflate(activity, R.layout.two_fragment, null)
        initView()
        return view
    }

    private fun initView() {
        tvExample = rootView.findViewById<View>(R.id.tv_example) as TextView
        tvExample!!.setOnClickListener {
            //            Intent intent = new Intent(getActivity(), ExampleActivity.class);
            //            getActivity().startActivity(intent);
        }
    }

}
