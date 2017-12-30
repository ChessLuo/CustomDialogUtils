package com.zsml.dialoglibrary.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.zsml.dialoglibrary.R;
import com.zsml.dialoglibrary.utils.DisplayUtils;

/**
 *
 * @描述 封装dialog
 * @author luoweichao
 * @wechat 1329869063
 * @date 2017/12/28/028 20:39
 *
 */
public class CustomDialog extends Dialog {

    private Context context;             //上下文
    private int height, width;           //宽高
    private boolean cancelTouchout;      //是否点击dialog外面背景取消dialog
    private View view;                   //自定义dialog布局View
    private int resAnim;                 //进出动画
    private int showPosition;            //显示位置

    private CustomDialog(Builder builder) {
        super(builder.context);
        context = builder.context;
        height = builder.height;
        width = builder.width;
        resAnim = builder.resAnim;
        showPosition = builder.position;
        cancelTouchout = builder.cancelTouchout;
        view = builder.view;
    }


    private CustomDialog(Builder builder, int resStyle) {
        super(builder.context, resStyle);
        context = builder.context;
        height = builder.height;
        width = builder.width;
        resAnim = builder.resAnim;
        showPosition = builder.position;
        cancelTouchout = builder.cancelTouchout;
        view = builder.view;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(view);

        setCanceledOnTouchOutside(cancelTouchout);

        Window win = getWindow();
        if (resAnim==-1){
            resAnim = R.style.styleAnim;
        }
        win.setWindowAnimations(resAnim);

        WindowManager.LayoutParams lp = win.getAttributes();
        lp.gravity = showPosition;

        if (width==-1){
            DisplayMetrics dm = context.getResources().getDisplayMetrics();
            width = (int)(dm.widthPixels * 0.7);//默认宽度设置为屏幕的0.7
            height = WindowManager.LayoutParams.WRAP_CONTENT;//默认高度为包裹内容
        }
        lp.height = height;
        lp.width = width;
        win.setAttributes(lp);
    }

    /**建立Builder模式*/
    public static class Builder {

        private Context context;
        private int height, width=-1;
        private boolean cancelTouchout=true;
        private View view;
        private int resStyle = -1;
        private int resAnim = -1;
        private int position = Gravity.CENTER;//默认居中


        public Builder(Activity context) {
            this.context = context;
        }

        public Builder view(int resView) {
            view = LayoutInflater.from(context).inflate(resView, null);
            return this;
        }

        public Builder setHeightPX(int val) {
            height = val;
            return this;
        }

        public Builder setWidthPX(int val) {
            width = val;
            return this;
        }

        public Builder setHeightDP(int val) {
            height = DisplayUtils.dip2px(context, val);
            return this;
        }

        public Builder setWidthDP(int val) {
            width = DisplayUtils.dip2px(context, val);
            return this;
        }

        public Builder setHeightDimenRes(int dimenRes) {
            height = context.getResources().getDimensionPixelOffset(dimenRes);
            return this;
        }

        public Builder setWidthDimenRes(int dimenRes) {
            width = context.getResources().getDimensionPixelOffset(dimenRes);
            return this;
        }

        public Builder setDialogStyle(int resStyle) {
            this.resStyle = resStyle;
            return this;
        }

        public Builder setDialogAnim(int resAnim) {
            this.resAnim = resAnim;
            return this;
        }

        public Builder setDialogPosition(int position) {
            this.position = position;
            return this;
        }


        public Builder cancelTouchout(boolean val) {
            cancelTouchout = val;
            return this;
        }

        public Builder addViewOnclick(int viewRes,View.OnClickListener listener){
            view.findViewById(viewRes).setOnClickListener(listener);
            return this;
        }


        public CustomDialog build() {
            if (resStyle != -1) {
                return new CustomDialog(this, resStyle);
            } else {
                return new CustomDialog(this,R.style.Dialog);
            }
        }
    }

    public View getDialogView(){
        return view;
    }

    /**拿到子View*/
    public <E extends View> E findView(int viewId) {
        if (view != null) {
            E v = (E) view.findViewById(viewId);
            return v;
        }
        return null;
    }

}
