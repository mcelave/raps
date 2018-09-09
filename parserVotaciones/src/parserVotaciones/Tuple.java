package parserVotaciones;

import java.util.Comparator;

public class Tuple implements Comparable<Tuple> {
	
	private String nombre;
	
	private Long contador;

	
	public Tuple() {
	
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((contador == null) ? 0 : contador.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tuple other = (Tuple) obj;
		if (contador == null) {
			if (other.contador != null)
				return false;
		} else if (!contador.equals(other.contador))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}



	public Tuple(String nombre, Long contador) {
		super();
		this.nombre = nombre;
		this.contador = contador;
	}

	public String getNombre() {
		return nombre;
	}

	public Long getContador() {
		return contador;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setContador(Long contador) {
		this.contador = contador;
	}


	@Override
	public int compareTo(Tuple arg0) {
		return this.contador.compareTo(arg0.getContador());
		
		
	}
	
	public static Comparator<Tuple> ComparadorTuplas  = new Comparator<Tuple>() {

		public int compare(Tuple tupla1, Tuple tupla2) {
		
			Long tuplaCont1 = tupla1.getContador();
			Long tuplaCont2 = tupla2.getContador();
			
			//ascending order
			return tuplaCont1.compareTo(tuplaCont2);
		
		//descending order
		//return fruitName2.compareTo(fruitName1);
		}
	};
	

}
