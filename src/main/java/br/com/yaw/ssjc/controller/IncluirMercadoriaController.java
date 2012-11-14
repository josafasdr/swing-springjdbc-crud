package br.com.yaw.ssjc.controller;

import javax.swing.JFrame;

import br.com.yaw.ssjc.action.AbstractAction;
import br.com.yaw.ssjc.dao.MercadoriaDAO;
import br.com.yaw.ssjc.event.IncluirMercadoriaEvent;
import br.com.yaw.ssjc.model.Mercadoria;
import br.com.yaw.ssjc.ui.IncluirMercadoriaFrame;

/**
 * Define a <code>Controller</code> responsável por gerir a tela de inclusão/edição de <code>Mercadoria</code>.
 * 
 * @see br.com.yaw.ssjc.controller.AbstractController
 * 
 * @author YaW Tecnologia
 */
public class IncluirMercadoriaController extends AbstractController {

	private IncluirMercadoriaFrame frame;
	
	public IncluirMercadoriaController(final ListaMercadoriaController parent) {
		super(parent);
		this.frame = new IncluirMercadoriaFrame();
		
		frame.addWindowListener(this);
		registerAction(frame.getCancelarButton(), new AbstractAction() {
			@Override
			public void action() {
				dispose();
			}
		});
		
		registerAction(frame.getSalvarButton(), new AbstractAction() {
			private Mercadoria m;
			
			@Override
			public void action() {
				Mercadoria m = frame.getMercadoria();
				MercadoriaDAO dao =  parent.getMercadoriaDAO();
				dao.save(m);
			}
			
			@Override
			public void posAction() {
				dispose();
				fireEvent(new IncluirMercadoriaEvent(m));
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
	
	public void show(Mercadoria m) {
		((IncluirMercadoriaFrame) getFrame()).setMercadoria(m);
		show();
	}
	
	@Override
	protected void dispose() {
		super.dispose();
		frame.setVisible(false);
		frame.resetForm();
	}
	
}
