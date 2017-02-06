package com.jikexueyuan.waimaidemo;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.jikexueyuan.waimaidemo.adapter.SectionPagerAdapter;

public class MainActivity extends AppCompatActivity {
//
    private ViewPager vpSwitcher;
    private ImageView ivHome,ivOrder,ivUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        为pageview绑定事件
        linkView();
//        初始化view
        initMainView();
//        注册点击事件
        registListener();
    }

    private void initMainView() {
        SectionPagerAdapter spAdapter = new SectionPagerAdapter(getSupportFragmentManager());
        vpSwitcher.setOffscreenPageLimit(3);
        vpSwitcher.setAdapter(spAdapter);
    }

    //    链接控件
    public void linkView(){
        vpSwitcher = (ViewPager) findViewById(R.id.vpSwitcher);
        //        底部导航栏
        ivHome = (ImageView) findViewById(R.id.ivHome);

        ivOrder = (ImageView) findViewById(R.id.ivOrder);

        ivUser = (ImageView) findViewById(R.id.ivUser);
    }

//    注册按键监听事件
    public void registListener(){
        ivHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivHome.setImageDrawable(getResources().getDrawable(R.drawable.tab_icon_home_selected));
                ivOrder.setImageDrawable(getResources().getDrawable(R.drawable.tab_icon_dingdan));
                ivUser.setImageDrawable(getResources().getDrawable(R.drawable.tab_icon_me));
//                页面滚动
                vpSwitcher.setCurrentItem(0);
            }
        });
        ivOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivOrder.setImageDrawable(getResources().getDrawable(R.drawable.tab_icon_dingdan_selected));
                ivHome.setImageDrawable(getResources().getDrawable(R.drawable.tab_icon_home));
                ivUser.setImageDrawable(getResources().getDrawable(R.drawable.tab_icon_me));
                vpSwitcher.setCurrentItem(1);
            }
        });
        ivUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivHome.setImageDrawable(getResources().getDrawable(R.drawable.tab_icon_home));
                ivUser.setImageDrawable(getResources().getDrawable(R.drawable.tab_icon_me_selected));
                ivOrder.setImageDrawable(getResources().getDrawable(R.drawable.tab_icon_dingdan));
                vpSwitcher.setCurrentItem(2);
            }
        });
        vpSwitcher.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0){
                    ivHome.setImageDrawable(getResources().getDrawable(R.drawable.tab_icon_home_selected));
                    ivOrder.setImageDrawable(getResources().getDrawable(R.drawable.tab_icon_dingdan));
                    ivUser.setImageDrawable(getResources().getDrawable(R.drawable.tab_icon_me));
                }else if (position == 1){
                    ivOrder.setImageDrawable(getResources().getDrawable(R.drawable.tab_icon_dingdan_selected));
                    ivHome.setImageDrawable(getResources().getDrawable(R.drawable.tab_icon_home));
                    ivUser.setImageDrawable(getResources().getDrawable(R.drawable.tab_icon_me));
                }else if (position == 2){
                    ivHome.setImageDrawable(getResources().getDrawable(R.drawable.tab_icon_home));
                    ivUser.setImageDrawable(getResources().getDrawable(R.drawable.tab_icon_me_selected));
                    ivOrder.setImageDrawable(getResources().getDrawable(R.drawable.tab_icon_dingdan));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
