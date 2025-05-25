package application.config;

public abstract class CarSkinConfig {
	
	public int image_Width;
	public int front_Blinker_Angle_Diff;
    public int rear_Blinker_Angle_Diff;
    public int front_Blinker_Distance;
    public int rear_Blinker_Distance;
    
    public int front_Corner_Angle_Diff;
    public int rear_Corner_Angle_Diff;
    public int front_Corner_Distance;
    public int rear_Corner_Distance;
	
    public CarSkinConfig() {
    	this.image_Width = 0;
    	this.front_Blinker_Angle_Diff = 0;
    	this.rear_Blinker_Angle_Diff = 0;
    	this.front_Blinker_Distance = 0;
    	this.rear_Blinker_Distance = 0;
    	
    	this.front_Corner_Angle_Diff = 0;
    	this.rear_Corner_Angle_Diff = 0;
    	this.front_Corner_Distance = 0;
    	this.rear_Corner_Distance = 0;
    	
    	
    }
    public int getImage_Width() {
    		return image_Width;
    }
   
	public int getFront_Blinker_Angle_Diff() {
		return front_Blinker_Angle_Diff;
	}
	
	public int getRear_Blinker_Angle_Diff() {
		return rear_Blinker_Angle_Diff;
	}
	
	public int getFront_Blinker_Distance() {
		return front_Blinker_Distance;
	}

	public int getRear_Blinker_Distance() {
		return rear_Blinker_Distance;
	}
	
	public int getFront_Corner_Angle_Diff() {
		return front_Corner_Angle_Diff;
	}
	
	public int getRear_Corner_Angle_Diff() {
		return rear_Corner_Angle_Diff;
	}
	
	public int getFront_Corner_Distance() {
		return front_Corner_Distance;
	}
	
	public int getRear_Corner_Distance() {
		return rear_Corner_Distance;
	}

	
    
    
}
