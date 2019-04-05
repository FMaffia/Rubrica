package it.rubrica.operazioni;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import it.rubrica.model.Persona;

public class OperazioniTelefono {

	private static OperazioniTelefono istance = null;

	public static OperazioniTelefono getIstance() {
		if (istance == null) {
			return new OperazioniTelefono();
		} else {
			return istance;
		}
	}

	private OperazioniTelefono() {
	}

	public static void nuovoNumero(String telefono, Persona persona, Map<String, Persona> memoriaSim) {
		memoriaSim.put(telefono, persona);
	}

	public static void eliminaNumero(String telefono, Map<String, Persona> memoriaSim) {
		memoriaSim.remove(telefono);
	}

	public static Persona ricercaPersonaDaNumero(String telefono, Map<String, Persona> memoriaSim) {
		boolean isPresent = memoriaSim.containsKey(telefono);
		Persona personaTrovata = new Persona();
		if (isPresent) {
			return personaTrovata = memoriaSim.get(telefono);
		}
		return personaTrovata;

	}

	public static String ricercaNumero(Persona persona, Map<String, Persona> memoriaSim) {
		String numeroTrovato = "";
		boolean isPresent = memoriaSim.containsValue(persona);
		if (isPresent) {
			for (String numero : memoriaSim.keySet()) {
				if (memoriaSim.get(numero).equals(persona)) {
					numeroTrovato = numero;
				}
			}
		} else {
			numeroTrovato = "Nessssuno";
		}
		return numeroTrovato;
	}

	public static String ricercaNumeroLambda(Persona persona, Map<String, Persona> memoriaSim) {
		String personaTrovata = "Nessssuno";
		Optional<Entry<String, Persona>> p = memoriaSim.entrySet().stream().filter(k -> k.getValue().equals(persona)).findFirst();
		if (p.isPresent()) {
			personaTrovata = p.get().getKey();
		}
		return personaTrovata;
	}

	public void visualizzaNumeriOrdinata(Map<String, Persona> memoriaSim) {
		memoriaSim.entrySet()
		        .stream()
		        .sorted(Map.Entry.<String, Persona>comparingByValue())
		        .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new))
		        .forEach((chiave, valore) -> System.out.println("Numero: " + chiave + ", " + valore.getNome() + " " + valore.getCognome()));
	}

	public void stampaOrdinato(LinkedHashMap<String, Persona> listaOrdinata) {
		for (String numero : listaOrdinata.keySet()) {
			System.out.println(numero + " " + listaOrdinata.get(numero));
		}
	}
}
