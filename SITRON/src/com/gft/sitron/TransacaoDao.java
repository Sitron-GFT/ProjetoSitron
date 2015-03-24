package com.gft.sitron;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class TransacaoDao {
	static private Set<Transacao> transacao = new HashSet<Transacao>();
	
	public void adiciona(Transacao t){
		transacao.add(t);
		System.out.println("adiciona Ok");
	}
	
	public List<Transacao> getLista(){
		List<Transacao> resultado = new ArrayList<Transacao>();
		
		resultado.addAll(transacao);
		return resultado;
	}

}






