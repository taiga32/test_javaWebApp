package beans;
import java.io.Serializable;

public class CircleBeans implements Serializable{
	private double radius;
	private String option;

	//コンストラクタ
	public CircleBeans(double radius, String option) {
		super();
		this.radius = radius;
		this.option = option;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	
}
