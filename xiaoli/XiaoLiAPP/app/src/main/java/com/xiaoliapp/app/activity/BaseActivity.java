package com.xiaoliapp.app.activity;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.xiaoliapp.app.R;
import com.xiaoliapp.app.constants.Constants;

//公共的Activity,向其他Activity提供顶部和底部布局
public abstract class BaseActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener, View
		.OnClickListener {

	protected RadioGroup bottomTab;

	protected RadioGroup.OnCheckedChangeListener checkedChangeListener;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_base);

		checkedChangeListener = this;

		bottomTab = (RadioGroup) this.findViewById(R.id.base_bottom_tab);
		bottomTab.setOnCheckedChangeListener(this);
	}

	//标题栏是否需要
	protected void setTitle(boolean isShow) {
		if (!isShow) {
			LinearLayout linearLayout = (LinearLayout) this.findViewById(R.id.activity_base);
			linearLayout.removeViewAt(0);
		}
	}

	//重置标题文字
	protected void setTitle(String title) {
		TextView topTitle = (TextView) this.findViewById(R.id.base_top_title);
		topTitle.setText(title);
	}

	//顶部右侧取消键是否显示
	protected void setCancel(boolean isShow) {
		if (!isShow) {
			TextView topCancel = (TextView) this.findViewById(R.id.base_top_cancel);
			topCancel.setVisibility(View.INVISIBLE);
		}
	}

	//设置顶部右侧取消键的文字
	protected void setCancel(String content) {
		TextView topCancel = (TextView) this.findViewById(R.id.base_top_cancel);
		topCancel.setText(content);
	}

	//顶部回退键是否显示
	protected void setBack(boolean isShow) {
		if (!isShow) {
			TextView topBack = (TextView) this.findViewById(R.id.base_top_back);
			topBack.setVisibility(View.INVISIBLE);
		}
	}

	//底部tab是否显示
	protected void setBottomBar(boolean isShow) {
		if (!isShow) {
			LinearLayout linearLayout = (LinearLayout) this.findViewById(R.id.activity_base);
			linearLayout.removeViewAt(2);
		}
	}

	//初始化内容区
	protected abstract void init();

	public void onCheckedChanged(RadioGroup group, int checkedId) {

		Intent intent = new Intent();
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

		switch (checkedId) {
			case R.id.bottom_tab_relation:
				intent.setAction("com.xiaoli.activity.RelationActivity");
				break;
			case R.id.bottom_tab_guide:
				intent.setAction("com.xiaoli.activity.GuideActivity");
				break;
			case R.id.bottom_tab_discover:
				intent.setAction("com.xiaoli.activity.DiscoverActivity");
				break;
			case R.id.bottom_tab_profile:
				intent.setAction("com.xiaoli.activity.ProfileActivity");
				break;
			default:
				break;
		}
		if (intent.getAction() != null) {
			startActivity(intent);
		}
	}

	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.base_top_back:
				super.onBackPressed();
		}
	}
}
