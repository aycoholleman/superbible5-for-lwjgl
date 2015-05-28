package superbible5.ch4;

import superbible5.lwjgl.Animation;

public class ModelViewProjectionLWJGL extends Animation {

	public static void main(String[] args)
	{
		ModelViewProjectionLWJGL anim = new ModelViewProjectionLWJGL();
		anim.start();

	}
	
	private ModelViewProjection modelViewProjection;

	public ModelViewProjectionLWJGL()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void init()
	{
		// TODO Auto-generated method stub
		super.init();
		modelViewProjection = new ModelViewProjection();
		modelViewProjection.SetupRC();
	}

	@Override
	protected void update(float delta)
	{
	}

	@Override
	protected void render(float delta)
	{
		delta *= 60000;
		modelViewProjection.RenderScene(delta);
		//System.out.println("render: " + delta);
	}


}
