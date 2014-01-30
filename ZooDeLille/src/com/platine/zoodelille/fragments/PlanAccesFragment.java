package com.platine.zoodelille.fragments;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar.TabListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.platine.zoodelille.R;
import com.platine.zoodelille.tab.TabBusFragment;
import com.platine.zoodelille.tab.TabMetroFragment;
import com.platine.zoodelille.tab.TabVlilleFragment;
import com.platine.zoodelille.tab.TabVoitureFragment;


public class PlanAccesFragment extends Fragment {
	
	ActionBar actionBar;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

		View myInflatedView = inflater.inflate(R.layout.fragment_plan_acces, container, false);
		
		actionBar = getActivity().getActionBar();

		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		Tab tabA = actionBar.newTab().setText("Animaux");
		Tab tabB = actionBar.newTab().setText("Contact");

		Fragment fragmentA = new AnimauxFragment();
		Fragment fragmentB = new JeuxInteractifFragment();
		tabA.setTabListener(new MyTabsListener(fragmentA));
		tabB.setTabListener(new MyTabsListener(fragmentB));

		
		
		actionBar.addTab(tabA);
		actionBar.addTab(tabB);
		
		
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

	
	protected class MyTabsListener implements ActionBar.TabListener{
	private Fragment fragment;
	private boolean addok = false;
	
	android.support.v4.app.FragmentTransaction fft = getActivity().getSupportFragmentManager().beginTransaction();
	FragmentManager fm = getFragmentManager();
	
    public MyTabsListener(Fragment fragment){
    	this.fragment = fragment;
    }

	@Override
	public void onTabReselected(Tab tab, android.app.FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTabSelected(Tab tab, android.app.FragmentTransaction ft) {
			if(addok == false){
				fft.replace(R.id.frameLayout, fragment).commit();
				addok = true;
			}else{
				fft.replace(R.id.frameLayout, fragment);
			}
	}
	@Override
	public void onTabUnselected(Tab tab, android.app.FragmentTransaction ft) {
			fft.remove(fragment);
	}
}
}
