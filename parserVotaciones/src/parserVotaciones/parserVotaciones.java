package parserVotaciones;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class parserVotaciones {
	
	
		public static void iterarDiccionario(HashMap<String, Long> diccionario){
			
			 Iterator<Entry<String, Long>> it = diccionario.entrySet().iterator();
			   while (it.hasNext()) {
				   Map.Entry pair = (Map.Entry)it.next();
				   System.out.println(pair.getKey() + " = " + pair.getValue());
				   it.remove(); // avoids a ConcurrentModificationException
			   }
			  
		}
		
		public static List<Tuple> iterarDiccionarioYMeterEnTuplas(HashMap<String, Long> diccionario){
			
			List<Tuple> result = new ArrayList<Tuple>();
			
			 Iterator<Entry<String, Long>> it = diccionario.entrySet().iterator();
			   while (it.hasNext()) {
				   Map.Entry pair = (Map.Entry)it.next();
				   Tuple t = new Tuple((String) pair.getKey(), (Long) pair.getValue());
				   result.add(t);
				   it.remove(); 
			   }
			   
			   return result;
		}
	
	
	
	
	
	public static void main(String args[]){
		
		   String csvFilePath = "C:\\Users\\kotomi\\Desktop\\p\\Reglas de Asociación y Patrones Secuenciales\\tp\\datos\\csv-votaciones-periodo-reunion-acta\\";
		   
		   File miDirectorio = new File(csvFilePath);
		   String[] archivos = miDirectorio.list();

		   CSVParser ausencias = new CSVParser();
		   ausencias.setEstrategia(new ContarAusentesPorBloque());
		   
		   System.out.println("----------AUSENCIAS POR BLOQUE");
		   HashMap<String, Long> ausenciasPorBloque = new HashMap<String, Long>();
		   
		   for(int i = 0 ; i < archivos.length; i++ ){
			   ausencias.parseCSV(ausenciasPorBloque, "\"AUSENTE\"", csvFilePath+archivos[i]);
		   } 
		   
		   
		   iterarDiccionario(ausenciasPorBloque);
		   System.out.println("---------- FIN AUSENCIAS POR BLOQUE");
		  
		   
		   System.out.println();
		   System.out.println();
		 
		   System.out.println("----------AUSENCIAS POR DIPUTADO");
		   CSVParser ausenciasPorDiputado = new CSVParser();
		   ausenciasPorDiputado.setEstrategia(new ContarDiputadosPresentes());
		   
		   HashMap<String, Long> ausenciasDeCadaDiputado = new HashMap<String, Long>();
		   
		   for(int i = 0 ; i < archivos.length; i++ ){
			   ausenciasPorDiputado.parseCSV(ausenciasDeCadaDiputado, "\"AUSENTE\"", csvFilePath+archivos[i]);
		   } 
		   
		  
		   List<Tuple> tuplas = iterarDiccionarioYMeterEnTuplas(ausenciasDeCadaDiputado);
		
		   tuplas.sort(Tuple.ComparadorTuplas);
		   
		   for(int i = tuplas.size()-1; i > tuplas.size()-11; i--){
			   System.out.println(tuplas.get(i).getNombre()+ " tuvo " + tuplas.get(i).getContador() + " ausencias"  ); 
		   }
		   
		   System.out.println("---------- FIN AUSENCIAS POR BLOQUE");
		   
		   
		   
		   for(int i = 0 ; i < archivos.length; i++ ){
			   ausenciasPorDiputado.parseCSV(ausenciasDeCadaDiputado, "\"AUSENTE\"", csvFilePath+archivos[i]);
		   } 
		   
		   CSVParser diputadosTotales = new CSVParser();
		  
		   
		   List<String> diputados = new ArrayList<String>();
		   List<String> diputadosSinAusencias = new ArrayList<String>();
		   for(int i = 0 ; i <archivos.length; i++ ){
			   diputados = diputadosTotales.diputadosTotales((csvFilePath+archivos[i]), diputados ) ;
		   }
		   
		  for(String s : diputados){
			  if(!ausenciasDeCadaDiputado.containsKey(s)){
				  diputadosSinAusencias.add(s);
			  }
		  }
		  
		  System.out.println("los siguientes diputados no tienen ausencias");
		  for(String s :diputadosSinAusencias){
			  System.out.println(s);
		  }
		 
		  System.out.println();
		  System.out.println();
		   
		  
		  System.out.println("--- cantidad de diputados por provincia------------------"); 
		   CSVParser diputadosPorProvincia = new CSVParser();
		   diputadosPorProvincia.setEstrategia(new ContarDiputadosPorProvincia());
		   HashMap<String, Long> cantidadDiputadosPorProvincia = new HashMap<String, Long>();
		   for(int i = 0 ; i <1; i++ ){
			 diputadosPorProvincia.parseCSV(cantidadDiputadosPorProvincia, "", csvFilePath+archivos[i]);
		   }
		   
		   
		   iterarDiccionario(cantidadDiputadosPorProvincia);
			
		   System.out.println("--- FIN cantidad de diputados por provincia------------------"); 
		  
		  
		   
		   
	}

}
