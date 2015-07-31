package com.gmy.fastgo.activity;

import java.util.ArrayList;
import java.util.List;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.gmy.fastgo.config.LearnContent;

/**
 * Created by jemy on 1/25/14.
 */
public class ContentSlidePagerAdapter extends FragmentPagerAdapter {
	private int contentListSize;
	private List<ContentSlidePageFragment> contentFragmentList;

	public ContentSlidePagerAdapter(FragmentManager fm,
			List<LearnContent> learnContentList) {
		super(fm);
		this.contentFragmentList = new ArrayList<ContentSlidePageFragment>();
		this.contentListSize = learnContentList.size();
		for (LearnContent learnContent : learnContentList) {
			ContentSlidePageFragment fragment = new ContentSlidePageFragment();
			fragment.setLearnContent(learnContent);
			this.contentFragmentList.add(fragment);
		}
	}

	@Override
	public Fragment getItem(int position) {
		return this.contentFragmentList.get(position);
	}

	@Override
	public int getCount() {
		return this.contentListSize;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return this.contentFragmentList.get(position).getLearnContent()
				.getContentName();
	}
}
