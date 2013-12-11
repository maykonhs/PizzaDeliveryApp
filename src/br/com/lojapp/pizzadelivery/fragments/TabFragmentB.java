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

public class TabFragmentB extends ListFragment {
	
	//Array de Strings
	String[] arrayCod = {"011","012","013","014","015","016","017","018","019","020","021","022"};
	
	String[] arraySabor = {"A Moda","Banana","Beijinho","Brigadeiro","Chocolate com Amendoin",
			"Chocolate com Sorvete","Floresta Negra","Prestígio","Romeu e Julieta","Sensação","Doce de Leite","Nutella"};
	
	String[] arrayPreco = {"R$ 23,00","R$ 48,30","R$ 22,20","R$ 19,00","R$ 28,00","R$ 20,00","R$ 20,00","R$ 22,00","R$ 24,00","R$ 18,00","R$ 22,00","R$ 21,00"};
	
	String[] arrayIngrediente = {"Ingredientes escolhidos a moda do cliente",
			"Creme de Leite, bananas, açucar de confeiteiro e canela",
			"Creme de Leite, Chocolate branco, coco ralado e fios de bisnaga",
			"Creme de Leite, Chocolate preto ou branco, frios de bisnaga e granulado",
			"Creme de Leite, chocoalte preto ou branco, frios de bisnaga e amendoin",
			"Creme de Leite, chocolate preto ou branco, sorvete e frios de bisnaga",
			"Creme de Leite, chocolate preto ou branco, cerejas e fios de bisnaga",
			"Creme de Leite, chocolate preto, Côco ralado e leite condensado",
			"Creme de Leite, goiabada e banana em pedaços",
			"Creme de Leite, chocolate preto, morangos ap creme de leite e leite condensado",
			"Recheado de Doce de Leite", "Recheado de Nutella"};
	

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