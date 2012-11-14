package br.com.yaw.ssjc.event;

import br.com.yaw.ssjc.model.Mercadoria;

/**
 * Define um evento para a inclusão de uma <code>Mercadoria</code>.
 * 
 * @author YaW Tecnologia
 */
public class IncluirMercadoriaEvent extends AbstractEvent<Mercadoria> {
	
	public IncluirMercadoriaEvent(Mercadoria m) {
		super(m);
	}
}
