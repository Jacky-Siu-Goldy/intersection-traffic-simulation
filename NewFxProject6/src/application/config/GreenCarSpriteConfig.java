package application.config;

public class GreenCarSpriteConfig extends CarSkinConfig {
	public static final int IMAGE_WIDTH = 40;//done
    public static final int FRONT_BLINKER_ANGLE_DIFF = 19;
    public static final int REAR_BLINKER_ANGLE_DIFF = 147;
    public static final int FRONT_BLINKER_DISTANCE = 45;
    public static final int REAR_BLINKER_DISTANCE = 26;
    
    public static final int FRONT_CORNER_ANGLE_DIFF = 19;
    public static final int REAR_CORNER_ANGLE_DIFF = 150;
    public static final int FRONT_CORNER_DISTANCE = 51;
    public static final int REAR_CORNER_DISTANCE = 30;
    
    public int image_Width;
	public int front_Blinker_Angle_Diff;
    public int rear_Blinker_Angle_Diff;
    public int front_Blinker_Distance;
    public int rear_Blinker_Distance;
    
    public int front_Corner_Angle_Diff;
    public int rear_Corner_Angle_Diff;
    public int front_Corner_Distance;
    public int rear_Corner_Distance;
	
    
    public GreenCarSpriteConfig() {
    	this.image_Width = IMAGE_WIDTH;
    	this.front_Blinker_Angle_Diff = FRONT_BLINKER_ANGLE_DIFF;
    	this.rear_Blinker_Angle_Diff = REAR_BLINKER_ANGLE_DIFF;
    	this.front_Blinker_Distance = FRONT_BLINKER_DISTANCE;
    	this.rear_Blinker_Distance = REAR_BLINKER_DISTANCE;
    	
    	this.front_Corner_Angle_Diff = FRONT_CORNER_ANGLE_DIFF;
    	this.rear_Corner_Angle_Diff = REAR_CORNER_ANGLE_DIFF;
    	this.front_Corner_Distance = FRONT_CORNER_DISTANCE;
    	this.rear_Corner_Distance = REAR_CORNER_DISTANCE;
    	
    	
    }
    
    @Override
    public int getImage_Width() {
    		return image_Width;
    }
   
    @Override
	public int getFront_Blinker_Angle_Diff() {
		return front_Blinker_Angle_Diff;
	}
	
    @Override
	public int getRear_Blinker_Angle_Diff() {
		return rear_Blinker_Angle_Diff;
	}
	
    @Override
	public int getFront_Blinker_Distance() {
		return front_Blinker_Distance;
	}

    @Override
	public int getRear_Blinker_Distance() {
		return rear_Blinker_Distance;
	}
	
    @Override
	public int getFront_Corner_Angle_Diff() {
		return front_Corner_Angle_Diff;
	}
	
    @Override
	public int getRear_Corner_Angle_Diff() {
		return rear_Corner_Angle_Diff;
	}
	
    @Override
	public int getFront_Corner_Distance() {
		return front_Corner_Distance;
	}
	
    @Override
	public int getRear_Corner_Distance() {
		return rear_Corner_Distance;
	}
}
