package com.wya.env.module.example;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.wya.env.R;
import com.wya.env.module.example.takephoto.TakePhotoExampleActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExampleActivity extends AppCompatActivity {

    @BindView(R.id.tv_take_photo)
    TextView tvTakePhoto;

    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example_activity);
        ButterKnife.bind(this);
        context = this;
        initClick();
    }

    private void initClick() {
        tvTakePhoto.setOnClickListener(view -> {
            Intent intent = new Intent(context, TakePhotoExampleActivity.class);
            context.startActivity(intent);
        });
    }
}
