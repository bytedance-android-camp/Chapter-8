package com.bytedance.camera.demo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bytedance.camera.demo.utils.Utils;

import java.io.File;

public class TakePictureActivity extends AppCompatActivity {

    private ImageView imageView;
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int REQUEST_EXTERNAL_STORAGE = 101;
    private File imageFile;
    String[] permissions = new String[] {

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_picture);
        imageView = findViewById(R.id.img);
        findViewById(R.id.btn_picture).setOnClickListener(v -> {
            if (Utils.isPermissionsReady(TakePictureActivity.this,permissions)) {
                takePicture();
            } else {
                //todo 在这里申请相机、存储的权限
                Utils.reuqestPermissions(TakePictureActivity.this,permissions,REQUEST_EXTERNAL_STORAGE);
            }
        });

    }

    private void takePicture() {
        //todo 打开相机

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
        //todo 处理返回数据
        }
    }

    private void setPicByBitmap() {
        //todo 根据imageView裁剪
        //todo 根据缩放比例读取文件，生成Bitmap

        //todo 如果存在预览方向改变，进行图片旋转

        //todo 如果存在预览方向改变，进行图片旋转
    }



    private void setPicByPath(Bitmap bitmap) {
        //todo 显示图片
        imageView.setImageBitmap(bitmap);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_EXTERNAL_STORAGE: {
                //todo 判断权限是否已经授予
                if (Utils.isPermissionsReady(TakePictureActivity.this,permissions)){
                    takePicture();
                }
                break;
            }
        }
    }
}
