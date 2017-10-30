package com.example.llp.adapterpattern;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.llp.librarycirclemenu.CircleMenuLayout;
import com.example.llp.librarycirclemenu.CircleMenuLayout.*;

import java.util.ArrayList;
import java.util.List;


public class CircleActivity extends Activity
{

	private CircleMenuLayout mCircleMenuLayout;
	List<MenuItem> mMenuItems = new ArrayList<MenuItem>();

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		//自已切换布局文件看效果
		setContentView(R.layout.circlemenu_layout);

		mCircleMenuLayout = (CircleMenuLayout) findViewById(R.id.id_menulayout);

		mockMenuItems();

		mCircleMenuLayout.setAdapter(new CircleMenuAdapter(mMenuItems));

		mCircleMenuLayout.setOnMenuItemClickListener(new CircleMenuLayout.OnMenuItemClickListener()
		{
			
			@Override
			public void itemClick(View view, int pos)
			{
				Toast.makeText(CircleActivity.this, mMenuItems.get(pos).title,
						Toast.LENGTH_SHORT).show();

			}
			
		});
		
	}

	//模拟数据
	private void mockMenuItems() {
		String[] mItemTexts = new String[] { "安全 ", "服务", "理财",
				"转账", "账户", "信用卡" };
		int[] mItemImgs = new int[] { R.mipmap.menu_1,
				R.mipmap.menu_2, R.mipmap.menu_3,
				R.mipmap.menu_4, R.mipmap.menu_5,
				R.mipmap.menu_6 };

		for(int i=0; i<Math.min(mItemTexts.length, mItemImgs.length); i++) {
			MenuItem item = new MenuItem(mItemTexts[i], mItemImgs[i]);
			mMenuItems.add(item);
		}
	}

}
