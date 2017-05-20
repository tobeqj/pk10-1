package com.laowopcdandan28;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.laowopcdandan28.base.BaseFmAct;
import com.laowopcdandan28.fm.Fm1;
import com.laowopcdandan28.fm.Fm2;
import com.laowopcdandan28.fm.Fm3;
import com.laowopcdandan28.fm.Fm4;
import com.laowopcdandan28.view.BanSlidingViewPage;
import com.laowopcdandan28.view.TitleView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseFmAct {
    @ViewInject(R.id.title_view)
    TitleView mTitleView;
    @ViewInject(R.id.banSlidingView)
    private BanSlidingViewPage m_banSlidingView;

    @ViewInject(R.id.iv1)
    private ImageView iv1;
    @ViewInject(R.id.iv2)
    private ImageView iv2;
    @ViewInject(R.id.iv3)
    private ImageView iv3;
    @ViewInject(R.id.iv4)
    private ImageView iv4;

    @ViewInject(R.id.tv1)
    private TextView tv1;
    @ViewInject(R.id.tv2)
    private TextView tv2;
    @ViewInject(R.id.tv3)
    private TextView tv3;
    @ViewInject(R.id.tv4)
    private TextView tv4;
    private ArrayList<Fragment> mFraments = new ArrayList<>();
    int currentIndex = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitleView(mTitleView,"PC蛋蛋28");
        mTitleView.findViewById(R.id.title_back).setVisibility(View.INVISIBLE);
        mFraments.add(new Fm1());
        mFraments.add(new Fm3());
        mFraments.add(new Fm2());
        mFraments.add(new Fm4());
        ItineraryFragmentAdapter itineraryFragmentAdapter = new ItineraryFragmentAdapter(getSupportFragmentManager());
        m_banSlidingView.setAdapter(itineraryFragmentAdapter);
//        m_banSlidingView.setOnPageChangeListener(new ItineraryOnPageChangeListener());
        m_banSlidingView.setOffscreenPageLimit(0);
        m_banSlidingView.setCurrentItem(currentIndex);
        m_banSlidingView.setScanScroll(false);
        iv1.setImageResource(R.mipmap.mainnav_icon01_on);
        tv1.setTextColor(getResources().getColor(R.color.title_red));
        //m_tv_quote.setTextColor(getResources().getColor(R.color.swipe_refrsh_color3));
    }


    class ItineraryFragmentAdapter extends FragmentPagerAdapter {

        public ItineraryFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFraments.get(position);
        }

        @Override
        public int getCount() {
            return mFraments.size();
        }
    }
    @Event({R.id.ll1,R.id.ll2,R.id.ll3,R.id.ll4})
    private void ItineraryOnClick(View v) {

        switch (v.getId()) {
            case R.id.ll1:
                currentIndex = 0;
                iv1.setImageResource(R.mipmap.mainnav_icon01_on);
                tv1.setTextColor(getResources().getColor(R.color.title_red));
                iv2.setImageResource(R.mipmap.mainnav_icon05);
                tv2.setTextColor(getResources().getColor(R.color.text_default_color));
                iv3.setImageResource(R.mipmap.mainnav_icon07);
                tv3.setTextColor(getResources().getColor(R.color.text_default_color));
                iv4.setImageResource(R.mipmap.mainnav_icon06);
                tv4.setTextColor(getResources().getColor(R.color.text_default_color));
                break;
            case R.id.ll2:
                currentIndex = 1;
                iv1.setImageResource(R.mipmap.mainnav_icon01);
                tv1.setTextColor(getResources().getColor(R.color.text_default_color));
                iv2.setImageResource(R.mipmap.mainnav_icon05_on);
                tv2.setTextColor(getResources().getColor(R.color.title_red));
                iv3.setImageResource(R.mipmap.mainnav_icon07);
                tv3.setTextColor(getResources().getColor(R.color.text_default_color));
                iv4.setImageResource(R.mipmap.mainnav_icon06);
                tv4.setTextColor(getResources().getColor(R.color.text_default_color));
                break;
            case R.id.ll3:
                currentIndex = 2;
                iv1.setImageResource(R.mipmap.mainnav_icon01);
                tv1.setTextColor(getResources().getColor(R.color.text_default_color));
                iv2.setImageResource(R.mipmap.mainnav_icon05);
                tv2.setTextColor(getResources().getColor(R.color.text_default_color));
                iv3.setImageResource(R.mipmap.mainnav_icon07_on);
                tv3.setTextColor(getResources().getColor(R.color.title_red));
                iv4.setImageResource(R.mipmap.mainnav_icon06);
                tv4.setTextColor(getResources().getColor(R.color.text_default_color));
                break;
            case R.id.ll4:
                currentIndex = 3;
                iv1.setImageResource(R.mipmap.mainnav_icon01);
                tv1.setTextColor(getResources().getColor(R.color.text_default_color));
                iv2.setImageResource(R.mipmap.mainnav_icon05);
                tv2.setTextColor(getResources().getColor(R.color.text_default_color));
                iv3.setImageResource(R.mipmap.mainnav_icon07);
                tv3.setTextColor(getResources().getColor(R.color.text_default_color));
                iv4.setImageResource(R.mipmap.mainnav_icon06_on);
                tv4.setTextColor(getResources().getColor(R.color.title_red));
                break;
        }
       // ToastManager.getManager().show("" +  currentIndex);
        m_banSlidingView.setCurrentItem(currentIndex);
    }
}
