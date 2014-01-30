package com.platine.zoodelille.fragments;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.platine.zoodelille.R;
import com.platine.zoodelille.tab.TabBusFragment;
import com.platine.zoodelille.tab.TabMetroFragment;
import com.platine.zoodelille.tab.TabVlilleFragment;
import com.platine.zoodelille.tab.TabVoitureFragment;


public class PlanAccesFragment extends FragmentActivity {
	
	ActionBar actionBar;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

		View myInflatedView = inflater.inflate(R.layout.fragment_plan_acces, container, false);
		
		actionBar = getActionBar();

//		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
//
//		String en_voiture = getResources().getString(R.string.voiture);
//		Tab tab_voiture = actionBar.newTab();
//		tab_voiture.setText(en_voiture);
//		TabListener<TabVoitureFragment> tl_voiture = new TabListener(this,en_voiture, TabVoitureFragment.class);
//		tab_voiture.setTabListener(tl_voiture);
//		actionBar.addTab(tab_voiture);
//
//		String en_metro = getResources().getString(R.string.metro);
//		Tab tab_metro = actionBar.newTab();
//		tab_metro.setText(en_metro);
//		TabListener<TabMetroFragment> tl_metro = new TabListener(this,en_metro, TabMetroFragment.class);
//		tab_metro.setTabListener(tl_metro);
//		actionBar.addTab(tab_metro);
//		
//		String en_bus = getResources().getString(R.string.bus);
//		Tab tab_bus = actionBar.newTab();
//		tab_bus = actionBar.newTab();
//		tab_bus.setText(en_bus);
//		TabListener<TabBusFragment> tl_bus = new TabListener(this,en_bus, TabBusFragment.class);
//		tab_bus.setTabListener(tl_bus);
//		actionBar.addTab(tab_bus);
//		
//		String en_vlille = getResources().getString(R.string.velo);
//		Tab tab_vlille = actionBar.newTab();
//		tab_vlille = actionBar.newTab();
//		tab_vlille.setText(en_vlille);
//		TabListener<TabVlilleFragment> tl_vlille = new TabListener(this,en_vlille, TabVlilleFragment.class);
//		tab_vlille.setTabListener(tl_vlille);
//		actionBar.addTab(tab_vlille);
//			
		return myInflatedView;
		
	}


	private class TabListener<T extends Fragment> implements ActionBar.TabListener{
		private android.app.Fragment mFragment;
		private final Activity mActivity;
		private final String mTag;
		private final Class<T> mClass;
		
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
		public TabListener(Activity activity, String tag, Class<T> clz) {
			mActivity = activity;
			mTag = tag;
			mClass = clz;
		}
		
//		public void onTabSelected(Tab tab, FragmentTransaction ft) {
//			// Check if the fragment is already initialized
//			if (mFragment == null) {
//				// If not, instantiate and add it to the activity
//				mFragment = Fragment.instantiate(mActivity, mClass.getName());
//				ft.add(android.R.id.content, mFragment, mTag);
//			} else {
//				// If it exists, simply attach it in order to show it
//				ft.attach(mFragment);
//			}
//		}
//		
//		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
//			if (mFragment != null) {
//				// Detach the fragment, because another one is being attached
//				ft.detach(mFragment);
//			}
//		}
//		
//		public void onTabReselected(Tab tab, FragmentTransaction ft) {
//			// User selected the already selected tab. Usually do nothing.
//		}
	
		@Override
		public void onTabReselected(Tab tab, android.app.FragmentTransaction ft) {
			// TODO Auto-generated method stub
			
		}
	
		@Override
		public void onTabSelected(Tab tab, android.app.FragmentTransaction ft) {
			// Check if the fragment is already initialized
			if (mFragment == null) {
				// If not, instantiate and add it to the activity
			//	mFragment = Fragment.instantiate(mActivity, mClass.getName());
				ft.add(android.R.id.content, mFragment, mTag);
			} else {
				// If it exists, simply attach it in order to show it
				ft.attach(mFragment);
			}
			
		}
	
		@Override
		public void onTabUnselected(Tab tab, android.app.FragmentTransaction ft) {
			if (mFragment != null) {
				// Detach the fragment, because another one is being attached
				ft.detach(mFragment);
			}
			
		}
	}
}
