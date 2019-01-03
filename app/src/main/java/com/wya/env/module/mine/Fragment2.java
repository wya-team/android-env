package com.wya.env.module.mine;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wya.env.R;

public class Fragment2 extends Fragment {

    private View view;
    private TextView tv_example;


    @SuppressLint("NewApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.two_fragment, null);
        initView();
        return view;
    }

    private void initView() {
        tv_example = (TextView) view.findViewById(R.id.tv_example);
        tv_example.setOnClickListener(view -> {
//            Intent intent = new Intent(getActivity(), ExampleActivity.class);
//            getActivity().startActivity(intent);
        });
    }

}
