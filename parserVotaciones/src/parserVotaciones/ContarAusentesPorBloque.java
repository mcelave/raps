package parserVotaciones;

import java.util.HashMap;

public class ContarAusentesPorBloque implements IEstrategiaParaContar {

	@Override
	public void contar(HashMap<String, Long> votaciones, Voto voto,
			String StringAContar) {
	
		if(voto.getVoto().equals(StringAContar)){
			if(votaciones.containsKey(voto.getBloque())){
				Long abstencionesActuales = votaciones.get(voto.getBloque());
				votaciones.put(voto.getBloque(), abstencionesActuales+1);
			}else{
				votaciones.put(voto.getBloque(), 1L);
			}
		}
		
		
	}

}
