package com.xiaoliapp.app.fragments;


import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import com.xiaoliapp.app.R;
import com.xiaoliapp.app.adapter.CommonPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class GuidePlanStationFragment extends Fragment implements TabLayout.OnTabSelectedListener {

	private TabLayout tabLayout;
	private ViewPager viewPager;

	public GuidePlanStationFragment() {
		// Required empty public constructor
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_guide_plan_station, container, false);

		tabLayout = (TabLayout) view.findViewById(R.id.fragment_guide_inner_tab_layout);
		tabLayout.setOnTabSelectedListener(this);
		tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);

		viewPager = (ViewPager) view.findViewById(R.id.fragment_guide_inner_pager);
		viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

		initData();
		return view;
	}


	//实现联动

	public void onTabSelected(TabLayout.Tab tab) {
		viewPager.setCurrentItem(tab.getPosition());
	}

	public void onTabUnselected(TabLayout.Tab tab) {

	}

	public void onTabReselected(TabLayout.Tab tab) {

	}

	private void initData() {

		//TODO TabLayout数据的添加
		tabLayout.addTab(tabLayout.newTab().setText("全部"));
		tabLayout.addTab(tabLayout.newTab().setText("求婚"));
		tabLayout.addTab(tabLayout.newTab().setText("告白"));
		tabLayout.addTab(tabLayout.newTab().setText("探亲"));
		tabLayout.addTab(tabLayout.newTab().setText("乔迁"));
		tabLayout.addTab(tabLayout.newTab().setText("会友"));
		tabLayout.addTab(tabLayout.newTab().setText("商务"));
		tabLayout.addTab(tabLayout.newTab().setText("致歉"));
		tabLayout.addTab(tabLayout.newTab().setText("道谢"));
		tabLayout.addTab(tabLayout.newTab().setText("流氓"));
		tabLayout.addTab(tabLayout.newTab().setText("讨债"));
		tabLayout.addTab(tabLayout.newTab().setText("白痴"));
		tabLayout.addTab(tabLayout.newTab().setText("傻蛋"));

		List<Fragment> fragmentList = new ArrayList<Fragment>();
		for (int i = 0; i < 13; i++) {
			fragmentList.add(new GuideInnerFragment());
		}

		CommonPagerAdapter adapter = new CommonPagerAdapter(getChildFragmentManager(), fragmentList);
		viewPager.setAdapter(adapter);
	}
}
