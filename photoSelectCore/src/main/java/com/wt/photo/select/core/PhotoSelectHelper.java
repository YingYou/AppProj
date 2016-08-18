package com.wt.photo.select.core;

import android.content.Context;
import android.graphics.Color;

import cn.finalteam.galleryfinal.CoreConfig;
import cn.finalteam.galleryfinal.FunctionConfig;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.ThemeConfig;

/**
 * Created by 吴同 on 2016/8/2 0002.
 */
public class PhotoSelectHelper {
    private final Context mContext;
    private final int mCropSize;
    private boolean mCrop = false;
    private FunctionConfig functionConfig;

    public PhotoSelectHelper(Context context, boolean crop, int cropSize) {
        mContext = context;
        mCrop = crop;
        mCropSize = cropSize;
        init();
    }


    private void init() {
        //设置主题
        ThemeConfig theme = new ThemeConfig.Builder()
                .setCheckSelectedColor(Color.rgb(0x18, 0x37, 0x4b))
                .setCheckNornalColor(mContext.getResources().getColor(android.R.color.transparent))
//                .setIconCheck(R.mipmap.ic_launcher)
                .setTitleBarBgColor(Color.rgb(0x18, 0x37, 0x4b))
                .setFabNornalColor(Color.rgb(0x18, 0x37, 0x4b))
                .setFabPressedColor(Color.rgb(0x18, 0x37, 0x4b))
//                .setIconBack(com.wt.basecore.R.mipmap.icon_return)
                .build();
        //配置功能
        functionConfig = new FunctionConfig.Builder()
                .setEnableCamera(false)
                .setEnableRotate(false)
                .setEnableCrop(mCrop)
                .setCropSquare(mCrop)
                .setForceCrop(mCrop)
                .setCropWidth(mCropSize)
                .setCropHeight(mCropSize)
                .setCropReplaceSource(true)
                .setEnableEdit(true)

                .setEnablePreview(false)
                .build();

        //配置imageloader
        PhotoSelectPicassoImageLoader imageloader = new PhotoSelectPicassoImageLoader();
        CoreConfig coreConfig = new CoreConfig.Builder(mContext, imageloader, theme)
                .setFunctionConfig(functionConfig)
                .build();
        GalleryFinal.init(coreConfig);
    }

    /**
     * 单张图片选择
     *
     * @param code
     * @param callback
     */
    public void openGallerySingle(int code, GalleryFinal.OnHanlderResultCallback callback) {
        GalleryFinal.openGallerySingle(code, functionConfig, callback);
    }

    /**
     * 多张图片选择
     *
     * @param code
     * @param maxNum
     * @param callback
     */
    public void openGalleryMulti(int code, int maxNum, GalleryFinal.OnHanlderResultCallback callback) {
        GalleryFinal.openGalleryMuti(code, maxNum, callback);
    }

    /**
     * 拍照
     *
     * @param code
     * @param callback
     */
    public void openCamera(int code, GalleryFinal.OnHanlderResultCallback callback) {
        GalleryFinal.openCamera(code, functionConfig, callback);
    }
}
