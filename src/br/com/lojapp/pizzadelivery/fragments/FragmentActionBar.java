package br.com.lojapp.pizzadelivery.fragments;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.lojapp.pizzadelivery.R;

public class FragmentActionBar extends Fragment {

	private TextView tvAppName;
	private Button btnEditList;
	private Button btnPlace;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_actionbar, null);

		tvAppName = (TextView) view.findViewById(R.id.tv_app_name_id);
		
		btnEditList = (Button) view.findViewById(R.id.btn_action_edit_list_id);
		btnPlace = (Button) view.findViewById(R.id.btn_action_place_id);

		/*
		 * Typeface face = Typeface.createFromAsset(getAssets(), "alberto.ttf");
		 * tvAppName.setTypeface(face);
		 */

		return view;
	}

}
