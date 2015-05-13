package superbible5.lwjgl;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;
import org.lwjgl.glfw.GLFWScrollCallback;
import org.lwjgl.opengl.GLContext;

public abstract class AbstractAnimation {

	protected final long windowId;
	protected final GLFWErrorCallback errorCallback;
	protected final GLFWKeyCallback keyCallback;
	protected final GLFWCursorPosCallback cursorPosCallback;
	protected final GLFWMouseButtonCallback mouseButtonCallback;
	protected final GLFWScrollCallback scrollCallback;
	private boolean running;

	public AbstractAnimation()
	{
		if (glfwInit() != GL_TRUE) {
			System.err.println("Error initializing GLFW");
			System.exit(1);
		}

		glfwWindowHint(GLFW_SAMPLES, 4);
		glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 4);
		glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
		glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GL_TRUE);
		glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
		glfwWindowHint(GLFW_RESIZABLE, GL_TRUE);
		windowId = glfwCreateWindow(640, 480, getWindowTitle(), NULL, NULL);

		if (windowId == NULL) {
			System.err.println("Error creating a window");
			System.exit(1);
		}

		glfwSetErrorCallback(errorCallback = onError());
		glfwSetKeyCallback(windowId, keyCallback = onKeyPress());
		glfwSetCursorPosCallback(windowId, cursorPosCallback = onMouseMove());
		glfwSetMouseButtonCallback(windowId, mouseButtonCallback = onClick());
		glfwSetScrollCallback(windowId, scrollCallback = onScroll());

		glfwMakeContextCurrent(windowId);
		GLContext.createFromCurrent();

		glfwSwapInterval(1);
	}

	public final void start()
	{
		float now, last = 0, delta;
		// Template method
		init();
		running = true;
		while (running && glfwWindowShouldClose(windowId) != GL_TRUE) {
			now = (float) glfwGetTime();
			delta = now - last;
			last = now;
			// Template method
			update(delta);
			// Template method
			render(delta);
			glfwPollEvents();
			glfwSwapBuffers(windowId);
		}
		// Template method
		dispose();
		releaseCallbacks();
		glfwDestroyWindow(windowId);
		glfwTerminate();
		System.exit(0);
	}

	public void stop()
	{
		running = false;
	}

	protected abstract String getWindowTitle();

	protected abstract void init();

	protected abstract void update(float delta);

	protected abstract void render(float delta);

	protected abstract void dispose();

	protected abstract GLFWKeyCallback onKeyPress();

	protected abstract GLFWErrorCallback onError();

	protected abstract GLFWCursorPosCallback onMouseMove();

	protected abstract GLFWMouseButtonCallback onClick();

	protected abstract GLFWScrollCallback onScroll();

	protected boolean isKeyPressed(int key)
	{
		return glfwGetKey(windowId, key) != GLFW_RELEASE;
	}

	public boolean isMouseButtonPressed(int button)
	{
		return glfwGetMouseButton(windowId, button) != GLFW_RELEASE;
	}

	public long getWindowId()
	{
		return windowId;
	}

	private void releaseCallbacks()
	{
		if (keyCallback != null) {
			keyCallback.release();
		}
		if (errorCallback != null) {
			errorCallback.release();
		}
		if (cursorPosCallback != null) {
			cursorPosCallback.release();
		}
		if (mouseButtonCallback != null) {
			mouseButtonCallback.release();
		}
		if (scrollCallback != null) {
			scrollCallback.release();
		}
	}

}