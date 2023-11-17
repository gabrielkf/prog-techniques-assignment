
public class Shuriken
	extends ImagemMovida
	implements Runnable
{
	public static int Size = 50;
	private static String ImagePath = "shuriken.png";
	private static double Velocity = 1.8;
	private static int SleepTime = 50;
	
	private int StartX;
	private int StartY;
	private int TargetX;
	private int TargetY;
	
	private Thread thread = new Thread(this);
	
	public Shuriken(int containerWidth, int containerHeight)
	{
		super(containerWidth - Size, containerHeight - Size);
		this.setImg(ImagePath);
		
		StartX = containerWidth / 2;
		StartY = containerHeight / 2;
		SetTarget(StartX, StartY);
		
		thread.start();
	}
	
	public void SetTarget(int x, int y)
	{
		TargetX = x;
		TargetY = y;
	}
	
	public void ResetPosition()
	{
		setX(StartX);
		setY(StartY);
	}
	
	@Override
	public void run() {
		try {
			while (true)
			{
				ChaseTarget();
				
				thread.sleep(SleepTime);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void ChaseTarget()
	{
		var x = TargetX - getX();
		var y = TargetY - getY();
		
		if (x == 0 || y == 0) return;
		
		var min = x > y ? x : y;
		
		var xDiff = (double)x * Velocity / min;
		var yDiff = (double)y * Velocity / min;
		
		try
		{
			moverDireita((int)xDiff);
			moverBaixo((int)yDiff);			
		}
		catch(Exception exception)
		{
			System.out.println(exception.getMessage());
		}
	}
}