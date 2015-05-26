package superbible5.ch4;

import superbible5.lwjgl.Animation;

public class ModelViewProjectionLWJGL extends Animation {

	public static void main(String[] args)
	{
		ModelViewProjectionLWJGL anim = new ModelViewProjectionLWJGL();
		anim.start();

	}

	public ModelViewProjectionLWJGL()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void init()
	{
		// TODO Auto-generated method stub
		super.init();
	}

	@Override
	protected void update(float delta)
	{
		System.out.println("update: " + delta);
	}

	@Override
	protected void render(float delta)
	{
		System.out.println("render: " + delta);
	}


}
