package com.platine.zoodelille.fragments;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.platine.zoodelille.R;
import com.platine.zoodelille.tab.Tab1Fragment;
import com.platine.zoodelille.tab.Tab2Fragment;


public class PlanAccesFragment extends Fragment{
	
	ActionBar actionBar;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

		View myInflatedView = inflater.inflate(R.layout.fragment_plan_acces, container, false);
		
		actionBar = getActivity().getActionBar();

		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		String label1 = getResources().getString(R.string.label1);
		Tab tab = actionBar.newTab();
		tab.setText(label1);
		
		TabListener tl = new TabListener(getActivity(),label1, Tab1Fragment.class);
		tab.setTabListener(tl);
		actionBar.addTab(tab);

		String label2 = getResources().getString(R.string.label2);
		tab = actionBar.newTab();
		tab.setText(label2);
		TabListener tl2 = new TabListener(getActivity(),label2, Tab2Fragment.class);
		tab.setTabListener(tl2);
		actionBar.addTab(tab);
			
		return myInflatedView;
		
	}


	private class TabListener implements ActionBar.TabListener {
	private Fragment mFragment;
	private final Activity mActivity;
	private final String mTag;
	private final Class mClass;
	
	/**
	 * Constructor used each time a new tab is created.
	 * 
	 * @param activity
	 *            The host Activity, used to instantiate the fragment
	 * @param tag
	 *            The identifier tag for the fragment
	 * @param clz
	 *            The fragment's Class, used to instantiate the fragment
	 */
	public TabListener(Activity activity, String tag, Class clz) {
		mActivity = activity;
		mTag = tag;
		mClass = clz;
	}
	
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// Check if the fragment is already initialized
		if (mFragment == null) {
			// If not, instantiate and add it to the activity
			mFragment = Fragment.instantiate(mActivity, mClass.getName());
			ft.add(android.R.id.content, mFragment, mTag);
		} else {
			// If it exists, simply attach it in order to show it
			ft.attach(mFragment);
		}
	}
	
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		if (mFragment != null) {
			// Detach the fragment, because another one is being attached
			ft.detach(mFragment);
		}
	}
	
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// User selected the already selected tab. Usually do nothing.
	}

	@Override
	public void onTabReselected(Tab tab, android.app.FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(Tab tab, android.app.FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabUnselected(Tab tab, android.app.FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
	}
}
