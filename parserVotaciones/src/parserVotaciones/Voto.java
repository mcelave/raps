package parserVotaciones;

public class Voto {
	
	private String nombre;
	
	private String bloque;
	
	private String provincia;
	
	private String voto;
	
	
	public Voto() {}

	
	public Voto(String nombre, String bloque, String provincia, String voto) {
		super();
		this.nombre = nombre;
		this.bloque = bloque;
		this.provincia = provincia;
		this.voto = voto;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getBloque() {
		return bloque;
	}
	
	public String getProvincia() {
		return provincia;
	}
	
	public String getVoto() {
		return voto;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setBloque(String bloque) {
		this.bloque = bloque;
	}
	
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	public void setVoto(String voto) {
		this.voto = voto;
	}
	
	
	
	
	

}
