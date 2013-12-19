package br.com.lojapp.pizzadelivery.activity;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import java.util.zip.Inflater;

import br.com.lojapp.pizzadelivery.adapter.ViewPagerAdapter;
import br.com.lojapp.pizzadelivery.fragments.TabFragmentA;
import br.com.lojapp.pizzadelivery.fragments.TabFragmentB;
import br.com.lojapp.pizzadelivery.fragments.TabFragmentC;
import br.com.lojapp.pizzadelivery.fragments.TabFragmentD;

import com.lojapp.pizzadelivery.R;


import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.TabContentFactory;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener {
	
	private TabHost mTabHost;
	private ViewPager mViewPager;
	private HashMap<String, TabInfo> mapTabInfo = new HashMap<String, MainActivity.TabInfo>();
	private PagerAdapter mPagerAdapter;
	
	// Informação da Tab
	private class TabInfo {
		private String tag;
		private Class<?> clss;
		private Bundle args;
		private Fragment fragment;
		
		TabInfo(String tag, Class<?> clazz, Bundle args) {
			this.tag = tag;
			this.clss = clazz;
			this.args = args;
		}
	}
	
	// Um simples factory que retorna View para o TabHost
	class TabFactory implements TabContentFactory {
		
		private final Context mContext;
		
		public TabFactory(Context context) {
			mContext = context;
		}
		
		public View createTabContent(String tag) {
			View v = new View(mContext);
			v.setMinimumWidth(0);
			v.setMinimumHeight(0);
			return v;
		}
	}
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Infla o layout
		setContentView(R.layout.activity_main);
		// Inicializa o TabHost
		this.initialiseTabHost(savedInstanceState);
		if (savedInstanceState != null) {
			// Define a Tab de acordo com o estado salvo
			mTabHost.setCurrentTabByTag(savedInstanceState.getString("tab"));
		}
		// Inicializa o ViewPager
		this.initialiseViewPager();
	}
	
	protected void onSaveInstanceState(Bundle outState) {
		// salva a Tab selecionada
		outState.putString("tab", mTabHost.getCurrentTabTag());
		super.onSaveInstanceState(outState);
	}
	
	private void initialiseViewPager() {
		 
		List<Fragment> fragments = new Vector<Fragment>();
		fragments.add(Fragment.instantiate(this, TabFragmentA.class.getName()));
		fragments.add(Fragment.instantiate(this, TabFragmentB.class.getName()));
		fragments.add(Fragment.instantiate(this, TabFragmentC.class.getName()));
		fragments.add(Fragment.instantiate(this, TabFragmentD.class.getName()));
		
		this.mPagerAdapter = new ViewPagerAdapter(super.getSupportFragmentManager(), fragments);
		this.mViewPager = (ViewPager) super.findViewById(R.id.viewpager);
		this.mViewPager.setAdapter(this.mPagerAdapter);
		this.mViewPager.setOnPageChangeListener(this);
	}
	
	private void initialiseTabHost(Bundle args) {
		mTabHost = (TabHost) findViewById(android.R.id.tabhost);
		mTabHost.setup();
		TabInfo tabInfo = null;
		MainActivity.AddTab(this, this.mTabHost, 
				this.mTabHost.newTabSpec("Tab1").setIndicator("Salgadas"), 
				(tabInfo = new TabInfo("Tab1", TabFragmentA.class, args)));
		MainActivity.AddTab(this, this.mTabHost, 
				this.mTabHost.newTabSpec("Tab2").setIndicator("Doces"), 
				(tabInfo = new TabInfo("Tab2", TabFragmentB.class, args)));
		MainActivity.AddTab(this, this.mTabHost, 
				this.mTabHost.newTabSpec("Tab3").setIndicator("Bebidas"),
				(tabInfo = new TabInfo("Tab3", TabFragmentC.class, args)));
		MainActivity.AddTab(this, this.mTabHost, 
				this.mTabHost.newTabSpec("Tab4").setIndicator("Sobremesas"), 
				(tabInfo = new TabInfo("Tab4", TabFragmentD.class, args)));
		this.mapTabInfo.put(tabInfo.tag, tabInfo);
		mTabHost.setOnTabChangedListener(this);
	}
	
	private static void AddTab(MainActivity activity, TabHost tabHost, TabHost.TabSpec tabSpec, TabInfo tabInfo) {
		// Attach uma tab view factory para o spec
		tabSpec.setContent(activity.new TabFactory(activity));
		tabHost.addTab(tabSpec);
	}

	@Override
	public void onPageScrollStateChanged(int state) {
		
	}

	@Override
	public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
		
	}

	@Override
	public void onPageSelected(int position) {
		this.mTabHost.setCurrentTab(position);
	}

	@Override
	public void onTabChanged(String tag) {
		// Avisa para o mViewPager qual a Tab que está ativa
		int pos = this.mTabHost.getCurrentTab();
		this.mViewPager.setCurrentItem(pos);
	}
	
	/*
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}*/

}
