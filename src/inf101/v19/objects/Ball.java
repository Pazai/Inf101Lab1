package inf101.v19.objects;

import javafx.scene.paint.Paint;

/**
 * A class to represent bouncing balls
 */
public class Ball {
	// TODO: missing fields for position and velocity
	private double DeltaX;
	private double DeltaY;
	private double xPos;
	private double yPos;
	/** Color of the ball's surface */
	private Paint color;

	/** The ball's radius. */
	private double radius;

	/**
	 * Link back to demo
	 */
	private BallDemo demo;

	/**
	 * Number of steps taken
	 */
	private int steps = 0;
	
	/**
	 * Create a new ball with position and velocity (0,0)
	 * 
	 * @param color
	 *            The color
	 * @param radius
	 *            The radius
	 */
	public Ball(Paint color, double radius, BallDemo demo) {
		if (radius < 0)
			throw new IllegalArgumentException("Radius should not be negative");
		this.color = color;
		this.radius = radius;
		this.demo = demo;
	}

	/**
	 * Move ball to a new position.
	 * 
	 * After calling {@link #moveTo(double, double)}, {@link #getX()} will return
	 * {@code newX} and {@link #getY()} will return {@code newY}.
	 * 
	 * @param newX
	 *            New X position
	 * @param newY
	 *            New Y position
	 */
	public void moveTo(double newX, double newY) {
		// TOD
		this.xPos = newX;
		this.yPos = newY;
	}

	/**
	 * @return Current X position
	 */
	public double getX() {
		// TOD
		return this.xPos;
	}

	/**
	 * @return Current Y position
	 */
	public double getY() {
		// TOD
		return this.yPos;
	}

	/**
	 * @return Current X movement
	 */
	public double getDeltaX() {
		// TOD
		return this.DeltaX;
	}

	/**
	 * @return Current Y movement
	 */
	public double getDeltaY() {
		// TOD
		return this.DeltaY;
	}

	/**
	 * @return The ball's radius
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * @return The ball's width (normally 2x {@link #getRadius()})
	 */
	public double getWidth() {
		return radius * 2;
	}

	/**
	 * @return The ball's height (normally 2x {@link #getRadius()})
	 */
	public double getHeight() {
		return radius * 2;
	}

	/**
	 * @return Paint/color for the ball
	 */
	public Paint getColor() {
		return color;
	}

	/**
	 * Perform one time step.
	 * 
	 * For each time step, the ball's (xPos,yPos) position should change by
	 * (deltaX,deltaY).
	 */
	public void step() {
		// TOD: step
		this.xPos += getDeltaX();
		this.yPos += getDeltaY();
		// TODO: Explosion / Oppgave 5

		steps++;
	}

	/**
	 * Change current velocity (deltaX, deltaY)
	 * 
	 * The arguments are added to the current values of deltaX,deltaY
	 * 
	 * @param ddx
	 *            Change to deltaX
	 * @param ddy
	 *            Change to deltaY
	 */
	public void accelerate(double ddx, double ddy) {
		// TODOs
		this.DeltaX += ddx;
		this.DeltaY += ddy;
	}

	/**
	 * Indicate that the ball has hit something, and should move back and
	 * bounce.
	 * 
	 * If bounceX != 0 or bounceY != 0, then the ball has hit something in the X
	 * and/or Y direction and should reverse its movement.

	 * The (bounceX,bounceY) arguments can be added to the balls position in
	 * order to stop it from overlapping with whatever it hit.
	 * 
	 * @param bounceX X-distance the ball needs to move in order to not overlap with the object it hit
	 * @param bounceY Y-distance the ball needs to move in order to not overlap with the object it hit
	 */
	public void hit(double bounceX, double bounceY) {
		// TOD
		if(bounceX != 0) {
			this.xPos +=  bounceX;
			this.DeltaX = -getDeltaX();
		}else if(bounceY != 0){
			this.DeltaY = -getDeltaY();
			this.yPos += bounceY;
		}
	}

	/**
	 * Stop the ball. (Sets deltaX/deltaY to 0) 
	 */
	public void halt() {
		// TOD
		this.DeltaX = 0;
		this.DeltaY = 0;
	}
}
