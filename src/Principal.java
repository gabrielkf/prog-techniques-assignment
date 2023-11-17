import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class Principal extends JFrame implements MouseMotionListener
{
	private static int Width = 1300;
	private static int Height = 700;
	
	private Shuriken Item;
	private CasaNinja Background;
	
	public Principal() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addMouseMotionListener(this);
	
		Item = new Shuriken(Width, Height);
		Background = new CasaNinja();
	}
	
	//EVITAR ALTERAR ESSE METODO
	public static void main(String[] args) {
		//Criando uma instancia da classe principal
		Principal mainThread = new Principal();
		mainThread.setSize(Width, Height);
		mainThread.createBufferStrategy(1);		
		mainThread.setVisible(true);
		mainThread.createBufferStrategy(2);
	}
	
	//EVITAR ALTERAR ESSE METODO
	public void paint(Graphics g) {
		this.renderGraphics();
		repaint();
	}
	
	//EVITAR ALTERAR ESSE METODO
	public void renderGraphics() {
		if (!getBufferStrategy().contentsLost())
		{
			getBufferStrategy().show();
		}
		
		Graphics graphicsContext = getBufferStrategy().getDrawGraphics();
		Graphics graphics = graphicsContext.create();
		
		//Limpando a tela
		graphics.setColor(Color.WHITE);        
		graphics.fillRect(0, 0, getWidth(), getHeight());
		renderizarImagens(graphics);
		
		//Liberando os contextos criados
		graphicsContext.dispose(); 
		graphics.dispose();
	}
	
	//ESSE EH O METODO QUE DEVE SER ADAPTADO AO PROJETO
	public void renderizarImagens(Graphics graphics) {
		Background.DrawWithSize(
				graphics,
				Width,
				Height);
		Item.DrawWithSize(
				graphics,
				Shuriken.Size,
				Shuriken.Size);
	}

	@Override
	public void mouseDragged(MouseEvent e)
	{
		Item.SetTarget(e.getX(), e.getY());
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		Item.SetTarget(e.getX(), e.getY());
	}
}