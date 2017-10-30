package com.example.llp.adapterpattern;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.llp.librarycirclemenu.CircleMenuLayout.CircleMenuAdapter;
import com.example.llp.librarycirclemenu.CircleMenuLayout.MenuItem;

import java.util.ArrayList;
import java.util.List;


public class ListViewActivity extends Activity
{

	private ListView mListView;
	List<MenuItem> mMenuItems = new ArrayList<MenuItem>();

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		//自已切换布局文件看效果
		setContentView(R.layout.listview_layout);

		mListView = (ListView) findViewById(R.id.id_ListView);

		mockMenuItems();

		mListView.setAdapter(new CircleMenuAdapter(mMenuItems));

		mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
				Toast.makeText(ListViewActivity.this, mMenuItems.get(i).title,
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
