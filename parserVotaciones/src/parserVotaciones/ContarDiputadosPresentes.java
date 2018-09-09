package parserVotaciones;

import java.util.HashMap;

public class ContarDiputadosPresentes  implements IEstrategiaParaContar  {
	
	
	@Override
	public void contar(HashMap<String, Long> votaciones, Voto voto,
			String StringAContar) {
	
		if(voto.getVoto().equals(StringAContar)){
			if(votaciones.containsKey(voto.getNombre())){
				Long ausenciasDelDiputado = votaciones.get(voto.getNombre());
				votaciones.put(voto.getNombre(), ausenciasDelDiputado+1);
			}else{
				votaciones.put(voto.getNombre(), 1L);
			}
		}
		
		
	}

	
	
	

}
