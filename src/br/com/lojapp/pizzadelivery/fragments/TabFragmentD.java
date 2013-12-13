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

public class TabFragmentD extends ListFragment {
	
	//Array de Strings
	String[] arrayCod = {"201","202","203","204","205","206","207"};
	
	String[] arraySabor = {"Brigadeirão","Brownie","Creme Papaya","CupCake","Gelatina","Petit Gateau","Pudim"};
	
	String[] arrayPreco = {"12,00","11,00","12,00","13,00","10,00","15,00","11,00"};
	
	String[] arrayIngrediente = {"Delicioso doce de Chocolate",
			"Delicioso doce de Chocolate",
			"Mamão, Sorvete de Creme e Licor",
			"Delicioso Bolo de Chocolate",
			"Tutti-Frutti, Morango, Abacaxi, Maracujá e Limão",
			"Bolo de Chocolate, Sorvete de Creme e Chantilly",
			"Delicioso Pudim de leite condensado",};
	

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
