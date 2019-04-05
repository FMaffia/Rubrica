package it.rubrica.telefono;

import java.util.HashMap;
import java.util.Map;

import it.rubrica.model.Persona;
import it.rubrica.operazioni.OperazioniTelefono;

public class Telefono {

	private static OperazioniTelefono rubrica = OperazioniTelefono.getIstance();
	private static Map<String, Persona> memoriaSim = new HashMap<>();
	private static Persona p1 = new Persona("Raffaele", "Ziccadenti");
	private static Persona p2 = new Persona("Edo", "Galizia");
	private static Persona p3 = new Persona("Buri", "Quaglia");
	private static Persona p4 = new Persona("Alberto", "Ruggeri");
	private static Persona p5 = new Persona("Zamuele", "Parentato");

	public static void main(String[] args) {
		avviaRubrica();
		rubrica.visualizzaNumeriOrdinata(memoriaSim);
	}

	public static void avviaRubrica() {
		memoriaSim.put("333-0000", p1);
		memoriaSim.put("333-1111", p2);
		memoriaSim.put("333-3333", p3);
		memoriaSim.put("333-4444", p4);
		memoriaSim.put("333-2222", p5);
	}

}
