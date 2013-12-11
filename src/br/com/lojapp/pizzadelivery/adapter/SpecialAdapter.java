package br.com.lojapp.pizzadelivery.adapter;

import java.util.HashMap;
import java.util.List;

import com.lojapp.pizzadelivery.R;
 
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;
 
public class SpecialAdapter extends SimpleAdapter {
     
    public SpecialAdapter(Context context, List<HashMap<String, String>> items, int resource, String[] from, int[] to) {
        super(context, items, resource, from, to);
    }
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      View view = super.getView(position, convertView, parent);
      
      if (position % 2 == 0) {
			view.setBackgroundResource(R.drawable.list_bgcolor);
		} else {
			view.setBackgroundResource(R.drawable.list_bgalt);
		}
      
      return view;
    }
}