package br.com.lojapp.pizzadelivery.fragments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.lojapp.pizzadelivery.adapter.SpecialAdapter;

import com.lojapp.pizzadelivery.R;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TabFragmentC extends ListFragment {
	
	//Array de Strings
	String[] arrayCod = {"101","102","103","104","105","106"};
	
	String[] arraySabor = {"Caipirinha","Cerveja","Champagne","Refrigerante","Sucos","Vinho"};
	
	String[] arrayPreco = {"12,00","9,00","3,00","6,00","8,00","10,00"};
	
	String[] arrayIngrediente = {"Pinga ou Vodca, Limão e Açúcar a gosto",
			"Bohemia, Brahma, Heineken, Original e Skol",
			"Brut, Demi-sec, Doux, Extra-Brut, Extra-Dry e Sec",
			"Coca-Cola, Fanta Laranja, Fanta Uva, Guaraná Antarctica, Schweppes e Sprite",
			"Abacaxi, Côco, Caju, Goiaba, Laranja, Limão, Maracujá, Melancia e Morango",
			"Branco, Tinto, Suave, Seco e Pro-Seco",};
	

	private static final String TAG_COD = "codigo";
	private static final String TAG_SABOR = "sabor";
	private static final String TAG_PRECO = "preco";
	private static final String TAG_INGREDIENTE = "ingrediente";
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		List<HashMap<String,String>> pizzalist = new ArrayList<HashMap<String,String>>();
		
		for (int i = 0; i < arrayCod.length; i++) {
			HashMap<String, String> map = new HashMap<String, String>();
			
			map.put(TAG_COD, arrayCod[i]);
			map.put(TAG_SABOR, arraySabor[i]);
			map.put(TAG_PRECO, arrayPreco[i]);
			map.put(TAG_INGREDIENTE, arrayIngrediente[i]);
			pizzalist.add(map);
		}

		SpecialAdapter adapter = new SpecialAdapter(getActivity(), pizzalist,
				R.layout.list_item, new String[] { TAG_SABOR, TAG_INGREDIENTE, TAG_PRECO }, 
				new int[] { R.id.sabor, R.id.ingrediente, R.id.preco });
		
        setListAdapter(adapter);
		
		return super.onCreateView(inflater, container, savedInstanceState);
	}
}