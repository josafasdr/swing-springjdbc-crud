package br.com.yaw.ssjc.event;

/**
 * Define um evento para a atualizar a tabela de mercadorias.
 * 
 * @author YaW Tecnologia
 */
public class AtualizarListarMercadoriaEvent extends AbstractEvent<Object> {
	
	public AtualizarListarMercadoriaEvent(Object m) {
		super(m);
	}

}
