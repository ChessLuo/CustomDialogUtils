package com.zsml.customdialog;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.zsml.dialoglibrary.widget.CustomDialog;


public class MainActivity extends Activity implements View.OnClickListener {

    private Button mBtn1;
    private Button mBtn2;
    private Button mBtn3;
    private Button mBtn4;
    private Button mBtn5;


    private CustomDialog dialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtn1 = (Button) findViewById(R.id.btn1);
        mBtn2 = (Button) findViewById(R.id.btn2);
        mBtn3 = (Button) findViewById(R.id.btn3);
        mBtn4 = (Button) findViewById(R.id.btn4);
        mBtn5 = (Button) findViewById(R.id.btn5);

        mBtn1.setOnClickListener(this);
        mBtn2.setOnClickListener(this);
        mBtn3.setOnClickListener(this);
        mBtn4.setOnClickListener(this);
        mBtn5.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                showDialog1();
                break;
            case R.id.btn2:
                showDialog2();
                break;
            case R.id.btn3:
                showDialog3();
                break;
            case R.id.btn4:
                showDialog4();
                break;
            case R.id.btn5:
                showDialog5();
                break;
        }
    }

    private void showDialog5() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.ll_1:
                        dialog.cancel();
                        Toast.makeText(MainActivity.this, "微信好友",
                                Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.ll_2:
                        dialog.cancel();
                        Toast.makeText(MainActivity.this, "朋友圈",
                                Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.tv_cancel_dialog:
                        dialog.cancel();
                        break;
                }
            }
        };

        DisplayMetrics dm = this.getResources().getDisplayMetrics();
        int width = dm.widthPixels;//屏幕宽度
        int height = WindowManager.LayoutParams.WRAP_CONTENT;//高度为包裹内容

        dialog = new CustomDialog.Builder(this)
                .view(R.layout.dialog_custom_view3)
                .addViewOnclick(R.id.ll_1,listener)
                .addViewOnclick(R.id.ll_2,listener)
                .addViewOnclick(R.id.tv_cancel_dialog,listener)
                .setDialogPosition(Gravity.BOTTOM) //设置dialog显示位置
                .setWidthPX(width) //设置宽
                .setHeightPX(height)//设置高
                .build();
        dialog.show();
    }


    private void showDialog4() {

        dialog = new CustomDialog.Builder(this)
                .view(R.layout.dialog_custom_view2)
                .addViewOnclick(R.id.tv_update, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                        Toast.makeText(MainActivity.this, "好吧，你给我滚！", Toast.LENGTH_SHORT).show();
                    }
                })
                .setDialogAnim(R.style.Anim) //设置dialog动画
                .setDialogPosition(Gravity.CENTER|Gravity.RIGHT) //设置dialog显示位置
                .cancelTouchout(false)//点击dialog背景不能取消dialog
                .build();
        //代码设置view属性
        TextView tv_title = dialog.findView(R.id.tv_title);
        TextView tips = dialog.findView(R.id.tv_tips);
        TextView tv_update = dialog.findView(R.id.tv_update);
        tv_title.setText("辞职信");
        tips.setText("由于程序猿这行业是高危行业，所以我决定明天就向老板申请离职，毕竟世界那么大，我还想活着去看看");
        tv_update.setText("必须辞职");

        dialog.show();
    }

    private void showDialog3() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.tv_cancel:
                        dialog.cancel();
                        break;

                    case R.id.tv_update:
                        dialog.cancel();
                        Toast.makeText(MainActivity.this, "哈哈，准备更新！",
                                Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };
        dialog = new CustomDialog.Builder(this)
                .view(R.layout.dialog_custom_view2)
                .addViewOnclick(R.id.tv_cancel,listener)
                .addViewOnclick(R.id.tv_update,listener)
                .setDialogPosition(Gravity.LEFT) //设置dialog显示位置
                .build();
        dialog.show();
    }



    private void showDialog2() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.tv_cancel:
                        dialog.cancel();
                        break;

                    case R.id.tv_update:
                        dialog.cancel();
                        Toast.makeText(MainActivity.this, "好吧，你给我滚！",
                                Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };

        dialog = new CustomDialog.Builder(this)
                .view(R.layout.dialog_custom_view1)
                .addViewOnclick(R.id.tv_cancel,listener)
                .addViewOnclick(R.id.tv_update,listener)
                .build();
        //代码设置view属性
        TextView tv_title = dialog.findView(R.id.tv_title);
        TextView tips = dialog.findView(R.id.tv_tips);
        TextView tv_update = dialog.findView(R.id.tv_update);
        tv_title.setText("辞职信");
        tips.setText("由于程序猿这行业是高危行业，所以我决定明天就向老板申请离职，毕竟世界那么大，我还想活着去看看");
        tv_update.setText("立即辞职");

        dialog.show();
    }

    private void showDialog1() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.tv_cancel:
                        dialog.cancel();
                        break;

                    case R.id.tv_update:
                        dialog.cancel();
                        Toast.makeText(MainActivity.this, "哈哈，准备更新！",
                                Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };
        dialog = new CustomDialog.Builder(this)
                .view(R.layout.dialog_custom_view1)
                .addViewOnclick(R.id.tv_cancel,listener)
                .addViewOnclick(R.id.tv_update,listener)
                .setDialogAnim(R.style.Anim) //设置dialog动画
                .cancelTouchout(false) //点击dialog背景不能取消dialog，默认为true
                .build();
        dialog.show();
    }

}
