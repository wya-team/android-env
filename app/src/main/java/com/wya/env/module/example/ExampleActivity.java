package com.wya.env.module.example;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.wya.env.R;
import com.wya.env.base.BaseActivity;
import com.wya.env.module.example.takephoto.TakePhotoExampleActivity;
import com.wya.env.module.example.view.ViewsActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExampleActivity extends BaseActivity {

    @BindView(R.id.tv_take_photo)
    TextView tvTakePhoto;
    @BindView(R.id.tv_view)
    TextView tvView;
    private Context context;

    @Override
    protected void initView() {
        context = this;
        initClick();
    }

    @Override
    protected int getLayoutID() {
        return R.layout.example_activity;
    }

    private void initClick() {
        tvTakePhoto.setOnClickListener(view -> {
            Intent intent = new Intent(context, TakePhotoExampleActivity.class);
            context.startActivity(intent);
        });
        tvView.setOnClickListener(view -> {
            Intent intent = new Intent(context, ViewsActivity.class);
            context.startActivity(intent);
        });
    }

}
