package it.polito.tdp.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.db.AnagrammaDAO;

public class Anagramma {
	
	AnagrammaDAO anagrammaDao;
	List<String> listaAnagrammi;
	

	public Anagramma() {
		this.anagrammaDao = new AnagrammaDAO();
		
	}
	
	public List<String> anagramma(String s) {
		listaAnagrammi = new ArrayList<>();
		anagramma_ricorsiva("", 0, s);
		return listaAnagrammi;
	}

	public void anagramma_ricorsiva(String parziale, int livello, String rimanenti) {
		if (rimanenti.length() == 0) { /*caso terminale*/
			listaAnagrammi.add(parziale);
		}else {
			for (int pos = 0; pos < rimanenti.length(); pos++) {
				anagramma_ricorsiva(parziale+rimanenti.charAt(pos), livello+1, rimanenti.substring(0, pos) + rimanenti.substring(pos+1));
			}
		}
	}

	public boolean isCorrettoDAO(String ss) {
		return this.anagrammaDao.isCorrect(ss);
	}

}
