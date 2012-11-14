package br.com.yaw.ssjc.event;

import br.com.yaw.ssjc.model.Mercadoria;


/**
 * Define um evento para a exclusão de uma <code>Mercadoria</code>.
 * 
 * @author YaW Tecnologia
 */
public class DeletarMercadoriaEvent extends AbstractEvent<Mercadoria> {
	
	public DeletarMercadoriaEvent(Mercadoria m) {
		super(m);
	}

}
