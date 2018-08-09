package com.wya.env.module.example.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.wya.env.R;
import com.wya.views.dialog.CustomDialog;
import com.wya.views.dialog.LoadingDialog;
import com.wya.views.widget.CornerImageView;
import com.wya.views.widget.GlideCircleTransform;
import com.wya.views.widget.GlideRoundTransform;

/**
 * 创建日期：2018/8/8 16:21
 * 作者： Mao Chunjiang
 * 文件名称：ViewsActivity
 * 类说明：View展示页面
 */

public class ViewsActivity extends AppCompatActivity {
    private LoadingDialog loadingDialog;
    private Button btn_loading;
    private Button btn_dialog;
    private CornerImageView img;
    private ImageView img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_views);
        initView();
    }

    private void initView() {
        btn_loading = (Button) findViewById(R.id.btn_loading);
        btn_loading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadingDialog = new LoadingDialog(ViewsActivity.this, true);
                loadingDialog.show();
            }
        });

        img = (CornerImageView) findViewById(R.id.img);
        //图片圆形加载
        Glide.with(this).load("")
                .error(this.getResources().getDrawable(R.mipmap.ic_launcher))
                .placeholder(this.getResources().getDrawable(R.mipmap.ic_launcher))
                .transform(new CenterCrop(this), new GlideCircleTransform(this))
                .into(img);
        //图片圆角加载
        img2 = (ImageView) findViewById(R.id.img2);
        Glide.with(this).load("https://www.baidu.com/img/bd_logo1.png")
                .error(this.getResources().getDrawable(R.mipmap.ic_launcher))
                .placeholder(this.getResources().getDrawable(R.mipmap.ic_launcher))
                .transform(new CenterCrop(this), new GlideRoundTransform(this))
                .into(img2);
        //显示普通dialog
        btn_dialog = (Button) findViewById(R.id.btn_dialog);
        btn_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });

    }

    /**
     * 是否保存
     */
    private CustomDialog commondialog;
    private void showDialog() {
        commondialog = new CustomDialog(this);
        commondialog.show();
        commondialog.setMessage("毛春江帅吗？");
        commondialog.setTitle("提示");
        commondialog.setCancleText("不帅");
        commondialog.setConfirmText("帅");
        commondialog.setConfirmColor(R.drawable.btn_blue_click_color);
        commondialog.setCancleColor(R.drawable.btn_c333333_click_color);
        commondialog.setYesOnclickListener(new CustomDialog.onYesOnclickListener() {
            @Override
            public void onYesClick() {
                commondialog.dismiss();
            }
        });
        commondialog.setNoOnclickListener(new CustomDialog.onNoOnclickListener() {
            @Override
            public void onNoClick() {
            }
        });
    }
}
