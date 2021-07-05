package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;

import com.example.myapplication.Fragments.Fragment1;
import com.example.myapplication.Fragments.Fragment2;
import com.example.myapplication.Fragments.Fragment3;


public class HOME extends AppCompatActivity {
    ViewPager2 viewPager;
    private String TAG=getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        viewPager = findViewById(R.id.pager);
        viewPager.setAdapter(new ScreenSlidePagerAdapter(this));
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                Log.e(TAG, "onPageScrolled: " );
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                Log.e(TAG, "onPageSelected: " );
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
                SharedPreferences preferences =getSharedPreferences("R-FIT",MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();

                switch (viewPager.getCurrentItem()) {
                    case 0:
                        editor.putInt("fragment_1",preferences.getInt("fragment_1",0)+1);
                        break;
                    case 1:
                        editor.putInt("fragment_2",preferences.getInt("fragment_2",0)+1);
                        break;
                    case 2:
                        editor.putInt("fragment_3",preferences.getInt("fragment_3",0)+1);
                        break;
                    case 3:
                        editor.putInt("fragment_4",preferences.getInt("fragment_4",0)+1);
                        break;
                }
                editor.commit();
                Log.e(TAG, "onPageScrollStateChanged: " );
            }
        });

        CountDownTimer timer = new CountDownTimer(100000, 3000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Log.e("TAG", "onTick: ");
                switch (viewPager.getCurrentItem()) {
                    case 0:
                        viewPager.setCurrentItem(1);
                        break;
                    case 1:
                        viewPager.setCurrentItem(2);
                        break;
                    case 2:
                        viewPager.setCurrentItem(3);
                        break;
                    case 3:
                        viewPager.setCurrentItem(0);
                        break;
                }
            }

            @Override
            public void onFinish() {

            }
        };
        timer.start();

    }

    private class ScreenSlidePagerAdapter extends FragmentStateAdapter {
        public ScreenSlidePagerAdapter(FragmentActivity fa) {
            super(fa);
        }

        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    return new Fragment1();
                case 1:
                    return new Fragment2();
                case 2:
                    return new Fragment3();
                default:
                    return new MotivationFragment();
            }
        }

        @Override
        public int getItemCount() {
            return 4;
        }
    }
}

