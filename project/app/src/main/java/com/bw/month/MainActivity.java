package com.bw.month;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.bw.month.fragment.Fen_Fragment;
import com.bw.month.fragment.Me_Fragment;
import com.bw.month.fragment.Shop_Fragment;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {

    private ViewPager pager;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = findViewById(R.id.main_pager);
        radioGroup = findViewById(R.id.main_group);
//        默认选中第一个
        radioGroup.check(radioGroup.getChildAt(0).getId());

//        添加到list
        final ArrayList<Fragment> list = new ArrayList<Fragment>();
        list.add(new Fen_Fragment());
        list.add(new Shop_Fragment());
        list.add(new Me_Fragment());

//        适配器
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

//        滑动
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                radioGroup.check(radioGroup.getChildAt(i).getId());

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

//        点击
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.main_button1:

                        pager.setCurrentItem(0);
                        break;

                    case R.id.main_button2:

                        pager.setCurrentItem(1);
                        break;

                    case R.id.main_button3:

                        pager.setCurrentItem(2);
                        break;
                }
            }
        });
    }
}
