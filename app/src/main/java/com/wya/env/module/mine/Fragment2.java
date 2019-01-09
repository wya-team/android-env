package com.wya.env.module.mine;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wya.env.R;
/**
 * @date: 2018/7/3 13:55
 * @author: Chunjiang Mao
 * @classname: Fragment2
 * @describe: Example Fragment
 */
public class Fragment2 extends Fragment {
    
    private View view;
    private TextView tvExample;
    
    @SuppressLint("NewApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.two_fragment, null);
        initView();
        return view;
    }
    
    private void initView() {
        tvExample = (TextView) view.findViewById(R.id.tv_example);
        tvExample.setOnClickListener(view -> {
            //            Intent intent = new Intent(getActivity(), ExampleActivity.class);
            //            getActivity().startActivity(intent);
        });
    }
    
}
