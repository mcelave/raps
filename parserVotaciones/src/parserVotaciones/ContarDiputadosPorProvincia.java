package parserVotaciones;

import java.util.HashMap;

public class ContarDiputadosPorProvincia implements IEstrategiaParaContar {

	@Override
	public void contar(HashMap<String, Long> votaciones, Voto voto,
			String StringAContar) {
		
			if(votaciones.containsKey(voto.getProvincia())){
				Long cantidadDiputadosPorProvincia = votaciones.get(voto.getProvincia());
				votaciones.put(voto.getProvincia(), cantidadDiputadosPorProvincia+1);
			}else{
				votaciones.put(voto.getProvincia(), 1L);
			}
		
		
		

	}

}
