package br.com.yaw.ssjc.controller;

import java.util.List;

import javax.swing.JFrame;

import br.com.yaw.ssjc.action.AbstractAction;
import br.com.yaw.ssjc.dao.MercadoriaDAO;
import br.com.yaw.ssjc.event.BuscarMercadoriaEvent;
import br.com.yaw.ssjc.model.Mercadoria;
import br.com.yaw.ssjc.ui.BuscaMercadoriaFrame;

/**
 * Define a <code>Controller</code> responsável por gerir a tela de Busca de <code>Mercadoria</code> pelo campo <code>nome</code>.
 * 
 * @see br.com.yaw.ssjc.controller.AbstractController
 * 
 * @author YaW Tecnologia
 */
public class BuscarMercadoriaController extends AbstractController {

	private BuscaMercadoriaFrame frame;
	
	public BuscarMercadoriaController(final ListaMercadoriaController parent) {
		super(parent);
		frame = new BuscaMercadoriaFrame();
		frame.addWindowListener(this);
		
		registerAction(frame.getBuscarButton(), new AbstractAction() {
			List<Mercadoria> list; 
			
			@Override
			public void action() {
				if (frame.getText().length() > 0) {
					MercadoriaDAO dao = parent.getMercadoriaDAO();
					list = dao.getMercadoriasByNome(frame.getText());
				}
			}
			
			@Override
			public void posAction() {
				cleanUp();
				if (list != null && !list.isEmpty()) {
					fireEvent(new BuscarMercadoriaEvent(list));
				}
			}
		});
	}
	
	@Override
	protected JFrame getFrame() {
		return frame;
	}

	public void show() {
		frame.setVisible(true);
	}

	@Override
	protected void cleanUp() {
		super.cleanUp();
		frame.setVisible(false);
		frame.resetForm();
	}
}
