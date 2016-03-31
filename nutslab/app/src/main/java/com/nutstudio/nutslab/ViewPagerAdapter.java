package com.nutstudio.nutslab;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by admin on 2016/2/23.
 */ ////////
public class ViewPagerAdapter extends PagerAdapter {
    private List<View> content;

    public ViewPagerAdapter(List<View> content) {
        this.content = content;
    }

    //viewpager适配器
    @Override
    public int getCount() {
        return content.size();
    }

    @Override
    public boolean isViewFromObject(View p1, Object p2) {
        return p1 == p2;
    }

    @Override
    public Object instantiateItem(View container, int position) {
        View view = content.get(position);
        ((ViewPager) container).addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView(content.get(position));
    }
}
