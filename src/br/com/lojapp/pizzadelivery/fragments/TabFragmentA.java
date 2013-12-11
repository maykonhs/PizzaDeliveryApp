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
import android.widget.SimpleAdapter;

public class TabFragmentA extends ListFragment {
	
	//Array de Strings
	String[] arrayCod = {"001","002","003","004","005","006","007","008","009","010"};
	
	String[] arraySabor = {"A Moda","Atum","Baiana","Calabresa","Frango Catupiry","Marguerita","Mussarela","Portuguesa","Quatro Queijos","Toscana"};
	
	String[] arrayPreco = {"10,90","11,90","12,90","13,90","14,90","15,90","16,90","17,90","18,90","19,90"};
	
	String[] arrayIngrediente = {"Ingredientes escolhidos a moda do cliente","Molho de Tomate, Atum, Cebola e Azeitona",
			"Molho de Tomate, Calabresa moída, Cebola, Ovos cozidos, Pimenta e Azeitona",
			"Molho de Tomate, Calabresa fatiada, Cebola e Azeitona","Molho de Tomate, Frango desfiado, Catupiry e Azeitona",
			"Molho de Tomate, Mussarela, Tomate, Manjericão e Azeitona","Molho de Tomate, Mussarela, Orégano e Azeitona",
			"Molho de Tomate, Presunto, Mussarela, Cebola, Ovos Cozidos e Azeitona",
			"Molho de Tomate, Mussarela, Provolone, Gorgonzola, Catupiry e Azeitona",
			"Molho de Tomate, Calabresa, Mussarela, Cebola e Azeitona"};
	

	private static final String TAG_COD = "codigo";
	private static final String TAG_SABOR = "sabor";
	private static final String TAG_PRECO = "preco";
	private static final String TAG_INGREDIENTE = "ingrediente";
	
	//ArrayList<HashMap<String, String>> pizzalist = new ArrayList<HashMap<String, String>>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		/*if (container == null) {
			return null;
		}*/
		
		List<HashMap<String,String>> pizzalist = new ArrayList<HashMap<String,String>>();
		 
		
		for (int i = 0; i < arrayCod.length; i++) {
			HashMap<String, String> map = new HashMap<String, String>();
			
			map.put(TAG_COD, arrayCod[i]);
			map.put(TAG_SABOR, arraySabor[i]);
			map.put(TAG_PRECO, arrayPreco[i]);
			map.put(TAG_INGREDIENTE, arrayIngrediente[i]);
			pizzalist.add(map);
		}

		// Instantiating an adapter to store each items
        // R.layout.list_item defines the layout of each item
		SpecialAdapter adapter = new SpecialAdapter(getActivity(), pizzalist,
				R.layout.list_item, new String[] { TAG_SABOR, TAG_INGREDIENTE, TAG_PRECO }, 
				new int[] { R.id.sabor, R.id.ingrediente, R.id.preco });
        setListAdapter(adapter);
		
		// Inflamos o layout tab_layout_a.xml
		//return (RelativeLayout) inflater.inflate(R.layout.tab_layout_a, container, false);
		return super.onCreateView(inflater, container, savedInstanceState);
	}
}

