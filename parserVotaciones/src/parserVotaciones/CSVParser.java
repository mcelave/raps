package parserVotaciones;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CSVParser {
	

	
	private IEstrategiaParaContar estrategia;


	
	

	public CSVParser() {
	
	}
	

	public CSVParser(IEstrategiaParaContar estrategia) {
		this.estrategia = estrategia;
	}
	
	

	public void parseCSV(HashMap<String, Long> votaciones, String tipoVotacion, String csvFile ){
		
		
		String line = "";
		String cvsSplitBy = ",";
		try (BufferedReader br =  new BufferedReader(new InputStreamReader(new FileInputStream(csvFile),"UTF-8"))){
			br.readLine();
			while ((line = br.readLine()) != null) {
				
				String[] datosVoto = line.split(cvsSplitBy);
				
				Voto voto = new Voto();
				
				String nombre =datosVoto[0];
				String apellido = datosVoto[1];
				voto.setNombre(nombre + " " +apellido );
				String bloque =datosVoto[2];
				
				if(bloque.equals("\"Cultura")){
					voto.setBloque(datosVoto[2]+datosVoto[3]);
					voto.setProvincia(datosVoto[4]);
					voto.setVoto(datosVoto[5]);
				}else{
					voto.setBloque(bloque);
					String provincia = datosVoto[3];
					voto.setProvincia(provincia);
					String decision =datosVoto[4];
					voto.setVoto(decision);	
					
				}
				
				estrategia.contar(votaciones, voto, tipoVotacion);
			
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	public List<String> diputadosTotales( String csvFile, List<String> diputadosActuales ){
		
		
		String line = "";
		String cvsSplitBy = ",";
		//List<String> diputadoTotales = new ArrayList<String>();
		
		
		try (BufferedReader br =  new BufferedReader(new InputStreamReader(new FileInputStream(csvFile),"UTF-8"))){
			br.readLine();
			while ((line = br.readLine()) != null) {
				
				String[] datosVoto = line.split(cvsSplitBy);
				
				String nombre =datosVoto[0];
				String apellido = datosVoto[1];
				
				if(!diputadosActuales.contains(nombre + " " +apellido)){
					diputadosActuales.add(nombre + " " +apellido);
				}
			
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return diputadosActuales;
		
	}


	public IEstrategiaParaContar getEstrategia() {
		return estrategia;
	}


	public void setEstrategia(IEstrategiaParaContar estrategia) {
		this.estrategia = estrategia;
	}



}
