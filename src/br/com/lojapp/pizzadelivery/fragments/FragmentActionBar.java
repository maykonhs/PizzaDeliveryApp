package br.com.lojapp.pizzadelivery.fragments;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lojapp.pizzadelivery.R;

public class FragmentActionBar extends Fragment {

	private TextView tvAppName;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_actionbar, null);

		tvAppName = (TextView) view.findViewById(R.id.tv_app_name_id);

		/*
		 * Typeface face = Typeface.createFromAsset(getAssets(), "alberto.ttf");
		 * tvAppName.setTypeface(face);
		 */

		return view;
	}

}
