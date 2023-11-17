import Item.PosicaoInvalidaException;

public class ImagemMovida extends Imagem {
	private int MaxX;
	private int MaxY;
	
	public ImagemMovida(int maxX, int maxY)
	{
		MaxX = maxX;
		MaxY = maxY;
	}
	
	public void moverDireita(int shift) throws PosicaoInvalidaException
	{
		var x = this.getX() + shift;
		
		if (x > MaxX)
		{
			throw new PosicaoInvalidaException();
		}
		
		this.setX(x);
	}
	
	public void moverEsquerda(int shift)
	{
		this.setX(this.getX() - shift);
	}
	
	public void moverCima(int shift)
	{
		this.setY(this.getY() - shift);
	}
	
	public void moverBaixo(int shift) throws PosicaoInvalidaException
	{
		var y = getY() + shift;
		
		if (y > MaxY)
		{
			throw new PosicaoInvalidaException();
		}
		
		this.setY(y);
	}
}
