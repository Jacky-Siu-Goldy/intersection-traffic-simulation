package intersectionsimcar.core;

import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;


import application.config.BlueRaceCarConfig;
import application.config.CarSkinConfig;
import application.config.FinishedBlueBydConfig;
import application.config.FinishedGrey2BydConfig;
import application.config.FinishedGreyBydConfig;
import application.config.FinishedTealByd2Config;
import application.config.GreenCarSpriteConfig;
import application.config.RedCarSpriteConfig;
import application.config.RedCorrollaConfig;
import application.config.YellowCarSprite3Config;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;



public class HeadedDownOrigCar extends IntersectionSimCar implements LaneManagementInterface{
	private Image carImage_P;
    private Image carImage_brake_P;
    private ImageView carImageView_P;
    private ImageView carImageView_brake_P;
   
    private Image front_R_BlinkerImage_P;
    private Image front_L_BlinkerImage_P;
    private Image rear_R_BlinkerImage_P;
    private Image rear_L_BlinkerImage_P;
    
    
    private ImageView front_R_BlinkerImageView_P;
    
    
    private ImageView front_L_BlinkerImageView_P;
    
    
    private ImageView rear_R_BlinkerImageView_P;
    
    
    private ImageView rear_L_BlinkerImageView_P;
    
    private Image front_R_BlinkerImage2_P;
    private Image front_L_BlinkerImage2_P;
    private Image rear_R_BlinkerImage2_P;
    private Image rear_L_BlinkerImage2_P;
    
    
    private ImageView front_R_BlinkerImageView2_P;
    
    private ImageView front_L_BlinkerImageView2_P;
   
    private ImageView rear_R_BlinkerImageView2_P;
    
    private ImageView rear_L_BlinkerImageView2_P;
    
    
    private Image front_R_BlinkerImage3_P;
    private Image front_L_BlinkerImage3_P;
    private Image rear_R_BlinkerImage3_P;
    private Image rear_L_BlinkerImage3_P;
    
    private ImageView front_R_BlinkerImageView3_P;
    
    private ImageView front_L_BlinkerImageView3_P;
    
    private ImageView rear_R_BlinkerImageView3_P;
    
    private ImageView rear_L_BlinkerImageView3_P;
 
    
    private ImageView[] blinkersSet1;
    private ImageView[] blinkersSet2;
    private ImageView[] blinkersSet3;
    
    private ImageView[] rightBlinkersSet;
    private ImageView[] rightBlinkersSet2;
    private ImageView[] rightBlinkersSet3;
    
    private ImageView[] leftBlinkersSet;
    private ImageView[] leftBlinkersSet2;
    private ImageView[] leftBlinkersSet3;
    //*********************************************************************************************************************************************************************************************************************************
    //Blinkers and Brake lights ON/OFF 2025-05-28 4:58pm
    enum RightBlinkersToggle{
    	ON, OFF
    };
    
    protected RightBlinkersToggle rightBlinkersToggle;
    
    enum LeftBlinkersToggle{
    	ON, OFF
    };
    
    protected LeftBlinkersToggle leftBlinkersToggle;
    
    enum BrakeLightsToggle{
    	ON,OFF
    };
    
    protected BrakeLightsToggle brakeLightsToggle;
    
   
    enum TheRightSpotToStartBlinking{
    	GREATERTHANXSPOTSELECTED,
    	LESSERTHANXSPOTSELECTED,
    	GREATERTHANYSPOTSELECTED,
    	LESSERTHANYSPOTSELECTED,
    	DOESNTNEEDTOBLINK
    }
    
   protected TheRightSpotToStartBlinking theRightSpotToStartBlinking;
   /**
    * Important for the laneChangePoint Selected calculation needed for when the Life or right Blinkers will start blinking
    */
   public void setTheRightSpotToStartBlinking(){
	   setOnWhichLaneEnum();
	   switch (onWhichLane) {
	   case OnWhichLane.HEADING_LEFT_ON_RIGHT_LANE_LIST:
		      
		       theRightSpotToStartBlinking = TheRightSpotToStartBlinking.GREATERTHANXSPOTSELECTED;
		   break;
	   case OnWhichLane.HEADING_LEFT_ON_LEFT_LANE_LIST:
		       
		       theRightSpotToStartBlinking = TheRightSpotToStartBlinking.GREATERTHANXSPOTSELECTED;
		   break;
	   case OnWhichLane.HEADING_LEFT_IN_LEFTTURNBOX_LIST:
		       
		       theRightSpotToStartBlinking = TheRightSpotToStartBlinking.GREATERTHANXSPOTSELECTED;
		   break;
	   case OnWhichLane.HEADING_RIGHT_ON_RIGHT_LANE_LIST:
		      
		       theRightSpotToStartBlinking = TheRightSpotToStartBlinking.LESSERTHANXSPOTSELECTED;
		   break;
	   case OnWhichLane.HEADING_RIGHT_ON_LEFT_LANE_LIST:
		      
		       theRightSpotToStartBlinking = TheRightSpotToStartBlinking.LESSERTHANXSPOTSELECTED;
		   break;
	   case OnWhichLane.HEADING_RIGHT_IN_LEFTTURNBOX_LIST:
		       
		       theRightSpotToStartBlinking = TheRightSpotToStartBlinking.LESSERTHANXSPOTSELECTED;
		   break;
	   case OnWhichLane.HEADING_UP_ON_RIGHT_LANE_LIST:
		   	  
		   	   theRightSpotToStartBlinking = TheRightSpotToStartBlinking.GREATERTHANYSPOTSELECTED;
		   break;
	   case OnWhichLane.HEADING_UP_ON_LEFT_LANE_LIST:
		     
		       theRightSpotToStartBlinking = TheRightSpotToStartBlinking.GREATERTHANYSPOTSELECTED;
		   break;
	   case OnWhichLane.HEADING_UP_IN_LEFTTURNBOX_LIST:
		      
		       theRightSpotToStartBlinking = TheRightSpotToStartBlinking.GREATERTHANYSPOTSELECTED;
		   break;
	   case OnWhichLane.HEADING_DOWN_ON_RIGHT_LANE_LIST:
		      
		       theRightSpotToStartBlinking = TheRightSpotToStartBlinking.LESSERTHANYSPOTSELECTED;
		   break;
	   case OnWhichLane.HEADING_DOWN_ON_LEFT_LANE_LIST:
		      
		       theRightSpotToStartBlinking = TheRightSpotToStartBlinking.LESSERTHANYSPOTSELECTED;
		   break;
	   case OnWhichLane.HEADING_DOWN_IN_LEFTTURNBOX_LIST:
		      
		       theRightSpotToStartBlinking = TheRightSpotToStartBlinking.LESSERTHANYSPOTSELECTED;
		   break;
		   
	   default:
		   theRightSpotToStartBlinking = TheRightSpotToStartBlinking.DOESNTNEEDTOBLINK;
		   System.out.print("setTheRightSpotToStartBlinking(): ---> the blinkers toggle are set if everything is done right\n" +
	                        "like if the calculation is made");
			   break;
		   
	   
	  
	   }
   }
   
   /**
    * only need this to signal for Left Lane Change when necessary STILL NEED TO DO CONDITION FOR WHEN TO TURN BLINKERS ON FOR RIGHT TURN
    */
   public void rightBlinkersShouldBlinkAtTheRightMoment() {
	   if(decideWhenToStartBlinking()) {
		   rightBlinkersToggle = RightBlinkersToggle.ON;
	   }
   }
  
 
   /**
    * only need this to signal for Left Lane Change when necessary STILL NEED TO DO CONDITION FOR WHEN TO TURN BLINKERS ON FOR LEFT TURN
    */
   public void leftBlinkersShouldBlinkAtTheRightMoment() {
	   if(decideWhenToStartBlinking()) {
		   leftBlinkersToggle = LeftBlinkersToggle.ON;
	   }
   }
   
   /**
    * Helper Method for both left or right BlinkersShouldBlinkAtTheRightMoment
    * @return
    */
   public boolean decideWhenToStartBlinking() {
	   setTheRightSpotToStartBlinking();
	   double result = actualCalculationResultOfWhenToStartBlinking();
	   
			   return (0 > result && 120 > result);
			  
		
			   
			   
	   
	   
   }
   
  private double actualCalculationResultOfWhenToStartBlinking() {
	  switch (theRightSpotToStartBlinking) {
	  	case TheRightSpotToStartBlinking.GREATERTHANXSPOTSELECTED:
	  			
	  			return((isxCoordinateSelected() && positionX > xCoordinate)? Math.abs(positionX - xCoordinate) : -1.2);
	  		
	  	case TheRightSpotToStartBlinking.LESSERTHANXSPOTSELECTED:
	  		
  				return ((isxCoordinateSelected() && positionX < xCoordinate)? Math.abs(positionX - xCoordinate) : -1.2);
	  		
	  	case TheRightSpotToStartBlinking.GREATERTHANYSPOTSELECTED:
	  		
	  			return((isyCoordinateSelected() && positionY > yCoordinate)? Math.abs(positionY - yCoordinate): -1.2);
	  		
	  	case TheRightSpotToStartBlinking.LESSERTHANYSPOTSELECTED:
	  		
	  			return ((isyCoordinateSelected() && positionY < yCoordinate)? Math.abs(positionY - yCoordinate) : -1.2);
	  		
	  	case TheRightSpotToStartBlinking.DOESNTNEEDTOBLINK:
	  		    return -1.2;
	  		
	    default:  	
	    		return -1.2;
	  }
  }
  //Blinkers and Brake Lights ON/OFF (section) Ends 
  //related stuff: check sectioned off stuff in code further down the bottom such as
  /*
   * 1) Left or right blinkers signal turn on will borrow from setTargetEnum() Helpers functions to determine the necessity to consider turning the blinkers on (section)
   * 
   * 2) Other Blinkers Animation Stuff (section)
   */
  //*************************************************************************************************************************************************************************************************
   //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  	private double frontRightBlinkerPositionX;
      private double frontRightBlinkerPositionY;
      private double frontLeftBlinkerPositionX;
      private double frontLeftBlinkerPositionY;
      
      private double rearRightBlinkerPositionX;
      private double rearRightBlinkerPositionY;
      private double rearLeftBlinkerPositionX;
      private double rearLeftBlinkerPositionY;
      
      //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
      private double length_CarPosToFrontBlinkers;
      private double length_CarPosToRearBlinkers;
      private double angle_DifferenceToFrontBlinkers;
      private double angle_DifferenceToRearBlinkers;
     
      //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
      private double front_R_Blinker_Angle;
      private double front_L_Blinker_Angle;
      private double rear_R_Blinker_Angle;
      private double rear_L_Blinker_Angle;
  	//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
      //Below: Used to determine the Car's body bounds(for keeping the car spaced out)
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    	private double frontRightCornerPositionX;
        private double frontRightCornerPositionY;
        private double frontLeftCornerPositionX;
        private double frontLeftCornerPositionY;
        
        private double rearRightCornerPositionX;
        private double rearRightCornerPositionY;
        private double rearLeftCornerPositionX;
        private double rearLeftCornerPositionY;
        
        //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        private double length_CarPosToFrontCorners;
        private double length_CarPosToRearCorners;
        private double angle_DifferenceToFrontCorners;
        private double angle_DifferenceToRearCorners;
       
        //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        private double front_R_Corner_Angle;
        private double front_L_Corner_Angle;
        private double rear_R_Corner_Angle;
        private double rear_L_Corner_Angle;
    	//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        protected static final double LEFTTURNEXITANGLE = 180; // aligns with the rotationAngle which means the rotationAngle will be 180 degree when it exit the Left turn circle (a circular path)
        
        protected static final double RIGHTTURNEXITANGLE = 0; // aligns with the rotationAngle which means the rotationAngle will be 0 degree when it exit the Right turn circle (a circular path)
        
        public static final double R_BIRIGHT_LANE_CHANGEEXITANGLE = 282;
    	public static final double L_BIRIGHT_LANE_CHANGEEXITANGLE = 270;
    	
    	 /**
         * This constant is used for the righTurn(double exitAngle, double radius) function
         * if you keep calling that function without doing anything for what happens when it hit that exit angle your car will basically keep going in a circle,
         * but as it goes around in a circle it will always hit that point which matches the exit angle, the rotationAngle will always align to match the exit angle at that instance
         * And as the name suggest this constant is used for right lane change after the car makes a left turn at the intersection. When the car's rotationAngle align with this 
         * exitAngle, phase1 of the lane change process should end and go on to phase2
         */
    	public static final double R_ALTRIGHT_LANECHANGEEXITANGLE = 192;// right turn exit angle for right Lane change after left turn
    	/**
         * This constant is used for the leftTurn(double exitAngle, double radius) function
         * if you keep calling that function without doing any for what happens when it hit that exit angle your car will basically keep going in a circle,
         * but as it goes around in a circle it will always hit that point which matches the exit angle, the rotationAngle will always align to match the exit angle at that instance
         * And as the name suggest this constant is used for right lane change after the car makes a left turn at the intersection. When the car's rotationAngle align with this 
         * exitAngle, phase3 of the lane change process should end and you do something else for example make it go straight
         */
        public static final double L_ALTRIGHT_LANECHANGEEXITANGLE = 180;// left  turn exit angle for right lane change after left turn
       
        
        /**
         * see explanation for other LANCHANGEEXITANGLE
         */
        public static final double L_ALTLEFT_LANECHANGEEXITANGLE =  135;// left turn exit angle for left lane change after left turn
        public static final double R_ALTLEFT_LANECHANGEEXITANGLE =  180;// right turn exit angle for left lane change after left turn
        
        /**
         * Coordinate in the Y axis of when the car should start making a right turn to successfully make a right turn
         */
        public static final double HEADINGDOWNRIGHTTURNY = 215; //Coordinate in the Y axis of when the car should start making a right turn to successfully make a right turn
        
        /**
         * Coordinate in the X axis of when the car should start making a left turn to successfully make a Left turn
         */
        public static final double HEADINGDOWNLEFTTURNY = 297.5;//Coordinate in the X axis of when the car should start making a left turn to successfully make a Left turn
        
        /**
    	 * The exit angle for canceling lane is not a final static variable because it can be different every time
    	 */
    	private double r_AltCancelRight_LaneChangeExitAngle;
    	
    	public double getR_AltCancelRight_LaneChangeExitAngle() {
    		return r_AltCancelRight_LaneChangeExitAngle;
    	}


    	public void setR_AltCancelRight_LaneChangeExitAngle() {
    		this.r_AltCancelRight_LaneChangeExitAngle = (this.getlAltrightLanechangeexitangle() - this.getlAltrightLanechangeexitangle() - 180)*2;
    		
    		this.r_AltCancelRight_LaneChangeExitAngle = (this.r_AltCancelRight_LaneChangeExitAngle + 360) % 360;
    		//System.out.println("r_ALTCANCELRIGHT_LANECHANGEEXITANGLE :" + this.getR_AltCancelRight_LaneChangeExitAngle());
    	}
    	
    	private double r_BiCancelRight_LaneChangeExitAngle;
    	
    	public double getR_BiCancelRight_LaneChangeExitAngle() {
    		 return r_BiCancelRight_LaneChangeExitAngle;
    	}
    	public void SetR_BiCancelRight_LaneChangeExitAngle() {
    		double temp_Angle  = this.rotationAngle - (this.rotationAngle - HEADING_DOWN_CARDINAL_ANGLE)*2;
    		
    		this.r_BiCancelRight_LaneChangeExitAngle = temp_Angle;
    		//System.out.println("r_BICancelRight_LaneChangeExitAngle :" + this.getR_BiCancelRight_LaneChangeExitAngle());
    	}
    	

    public void initializeBlinkersSetsAll4() {
			 blinkersSet1 = new ImageView[]{front_R_BlinkerImageView_P,
												front_L_BlinkerImageView_P,
												rear_R_BlinkerImageView_P,
												rear_L_BlinkerImageView_P };
		    
		    blinkersSet2 = new ImageView[]{front_R_BlinkerImageView2_P, 
		    									front_L_BlinkerImageView2_P,
		    									rear_R_BlinkerImageView2_P, 
		    									rear_L_BlinkerImageView2_P};
		    
		    blinkersSet3 = new ImageView[]{front_R_BlinkerImageView3_P, 
		    									front_L_BlinkerImageView3_P,
												rear_R_BlinkerImageView3_P, 
												rear_L_BlinkerImageView3_P};
    
    }
    
    public void initializeRightBlinkersSets() {
    	rightBlinkersSet = new ImageView[] {front_R_BlinkerImageView_P,
    			                            rear_R_BlinkerImageView_P};
    	
    	rightBlinkersSet2 = new ImageView[] {front_R_BlinkerImageView2_P,
    										rear_R_BlinkerImageView2_P};
     	
    	rightBlinkersSet3 = new ImageView[] {front_R_BlinkerImageView3_P,
     										rear_R_BlinkerImageView3_P};
    	
    }
    
    public void initializeLeftBlinkersSets() {
    	leftBlinkersSet = new ImageView[] {front_L_BlinkerImageView_P,
    			                            rear_L_BlinkerImageView_P};
    	
    	leftBlinkersSet2 = new ImageView[] {front_L_BlinkerImageView2_P,
    										rear_L_BlinkerImageView2_P};
     	
    	leftBlinkersSet3 = new ImageView[] {front_L_BlinkerImageView3_P,
     										rear_L_BlinkerImageView3_P};
    	
    }
	private double nearest_Front_Car_Base_On_DistanceHeadingRightX;
	private double nearest_Front_Car_Base_On_DistanceHeadingLeftX;
	private double nearest_Front_Car_Base_On_DistanceHeadingUpY;
	private double nearest_Front_Car_Base_On_DistanceHeadingDownY;
	
	private double nearest_Rear_Car_Base_On_DistanceHeadingRightX;
	private double nearest_Rear_Car_Base_On_DistanceHeadingLeftX;
	private double nearest_Rear_Car_Base_On_DistanceHeadingUpY;
	private double nearest_Rear_Car_Base_On_DistanceHeadingDownY;
	
	private double targetLane_Nearest_Front_Car_Base_On_DistanceHeadingRightX;
	private double targetLane_Nearest_Front_Car_Base_On_DistanceHeadingLeftX;
	private double targetLane_Nearest_Front_Car_Base_On_DistanceHeadingUpY;
	private double targetLane_Nearest_Front_Car_Base_On_DistanceHeadingDownY;
	
	private double targetLane_Nearest_Rear_Car_Base_On_DistanceHeadingRightX;
	private double targetLane_Nearest_Rear_Car_Base_On_DistanceHeadingLeftX;
	private double targetLane_Nearest_Rear_Car_Base_On_DistanceHeadingUpY;
	private double targetLane_Nearest_Rear_Car_Base_On_DistanceHeadingDownY;
    public Circle[] carCornerCircle ;

    public Circle[] getCarCornerCircle() {
		return carCornerCircle;
	}



	public void setCarCornerCircle() {
		this.carCornerCircle = new Circle[4];
		
		carCornerCircle[0] = new Circle();
		carCornerCircle[1] = new Circle();
		carCornerCircle[2] = new Circle();
		carCornerCircle[3] = new Circle();
	}
	private int blinkersCounter;
    private int angle_Diff_Front_Blinkers;
    private int angle_Diff_Rear_Blinkers;
    private int length_For_Front_Blinkers;
    private int length_For_Rear_Blinkers;

    private int angle_Diff_Front_Corners;
    private int angle_Diff_Rear_Corners;
    private int length_For_Front_Corners;
    private int length_For_Rear_Corners;
    /**
     * Calculate the length of the Car from the front of the car to the back of the car
     * should be called in the constructor to set the boundary of the car needed for use in spacing
     * can be called again to calculate  as the car faces in the direction of a new cardinal angle
     * to account for screen warping of the dimensions
     */
    public void setCustomCarLengthBaseOnCarSkin() {
		double temp_customCarLengthBaseOnCarSkin = 0;
		switch (this.getOnWhichLaneListKey()) {
		case OnWhichLane.HEADING_LEFT_ON_RIGHT_LANE_LIST:
			temp_customCarLengthBaseOnCarSkin = Math.abs(this.getFrontLeftCornerPositionX() - this.getRearLeftCornerPositionX());
			setCustomCarLengthBaseOnCarSkin ( temp_customCarLengthBaseOnCarSkin);
			break;
		case OnWhichLane.HEADING_LEFT_ON_LEFT_LANE_LIST:
			temp_customCarLengthBaseOnCarSkin = Math.abs(this.getFrontLeftCornerPositionX() - this.getRearLeftCornerPositionX());
			setCustomCarLengthBaseOnCarSkin ( temp_customCarLengthBaseOnCarSkin);
			break;
		case OnWhichLane.HEADING_LEFT_IN_LEFTTURNBOX_LIST:
			temp_customCarLengthBaseOnCarSkin = Math.abs(this.getFrontLeftCornerPositionX() - this.getRearLeftCornerPositionX());
			setCustomCarLengthBaseOnCarSkin ( temp_customCarLengthBaseOnCarSkin);
			break;
		case OnWhichLane.HEADING_RIGHT_ON_RIGHT_LANE_LIST:
			temp_customCarLengthBaseOnCarSkin = Math.abs(this.getFrontLeftCornerPositionX() - this.getRearLeftCornerPositionX());
			setCustomCarLengthBaseOnCarSkin ( temp_customCarLengthBaseOnCarSkin);
			break;
		case OnWhichLane.HEADING_RIGHT_ON_LEFT_LANE_LIST:
			temp_customCarLengthBaseOnCarSkin = Math.abs(this.getFrontLeftCornerPositionX() - this.getRearLeftCornerPositionX());
			setCustomCarLengthBaseOnCarSkin ( temp_customCarLengthBaseOnCarSkin);
			break;
			
		case OnWhichLane.HEADING_RIGHT_IN_LEFTTURNBOX_LIST:
			temp_customCarLengthBaseOnCarSkin = Math.abs(this.getFrontLeftCornerPositionX() - this.getRearLeftCornerPositionX());
			setCustomCarLengthBaseOnCarSkin ( temp_customCarLengthBaseOnCarSkin);
			break;
		case OnWhichLane.HEADING_UP_ON_RIGHT_LANE_LIST:
			temp_customCarLengthBaseOnCarSkin = Math.abs(this.getFrontLeftCornerPositionY() - this.getRearLeftCornerPositionY());
			setCustomCarLengthBaseOnCarSkin ( temp_customCarLengthBaseOnCarSkin);
			break;
		case OnWhichLane.HEADING_UP_ON_LEFT_LANE_LIST:
			temp_customCarLengthBaseOnCarSkin = Math.abs(this.getFrontLeftCornerPositionY() - this.getRearLeftCornerPositionY());
			setCustomCarLengthBaseOnCarSkin ( temp_customCarLengthBaseOnCarSkin);
			break;
		case OnWhichLane.HEADING_UP_IN_LEFTTURNBOX_LIST:
			temp_customCarLengthBaseOnCarSkin = Math.abs(this.getFrontLeftCornerPositionY() - this.getRearLeftCornerPositionY());
			setCustomCarLengthBaseOnCarSkin ( temp_customCarLengthBaseOnCarSkin);
			break;
		case OnWhichLane.HEADING_DOWN_ON_RIGHT_LANE_LIST:
			temp_customCarLengthBaseOnCarSkin = Math.abs(this.getFrontLeftCornerPositionY() - this.getRearLeftCornerPositionY());
			setCustomCarLengthBaseOnCarSkin ( temp_customCarLengthBaseOnCarSkin);
			break;
		case OnWhichLane.HEADING_DOWN_ON_LEFT_LANE_LIST:
			temp_customCarLengthBaseOnCarSkin = Math.abs(this.getFrontLeftCornerPositionY() - this.getRearLeftCornerPositionY());
			setCustomCarLengthBaseOnCarSkin ( temp_customCarLengthBaseOnCarSkin);
			break;
		case OnWhichLane.HEADING_DOWN_IN_LEFTTURNBOX_LIST:
			temp_customCarLengthBaseOnCarSkin = Math.abs(this.getFrontLeftCornerPositionY() - this.getRearLeftCornerPositionY());
			setCustomCarLengthBaseOnCarSkin ( temp_customCarLengthBaseOnCarSkin);
			break;
		default:
			setCustomCarLengthBaseOnCarSkin ( temp_customCarLengthBaseOnCarSkin);
			break;
			
		
	}
	}
    
    
	
	//Car Brain Working on Target Lane "Direction Class Dependent" -->Need to Tweak
	  
	 

	 public void setTargetLaneEnum() {//this is class specific!!!!!
		 //System.out.println("setTargetLaneEnum() ---> carIntention: " + this.carIntention);
		 Stream.of(
			 MapUtility.entry(isBI_ONRLWANTLLC(), TargetLane.HEADING_DOWN_ON_LEFT_LANE_LIST),
			 MapUtility.entry(isBI_ONLLWANTRLC(), TargetLane.HEADING_DOWN_ON_RIGHT_LANE_LIST),
			 MapUtility.entry(isBI_ONLLWANTLLC(), TargetLane.HEADING_DOWN_IN_LEFTTURNBOX_LIST),
			 MapUtility.entry(isBI_ONLTBWANTLT(), TargetLane.HEADING_RIGHT_ON_LEFT_LANE_LIST),
			 MapUtility.entry(isBI_ONRLWANTRT(), TargetLane.HEADING_LEFT_ON_RIGHT_LANE_LIST),
			 MapUtility.entry(isART_ONRLWANTLLC(), TargetLane.HEADING_LEFT_ON_LEFT_LANE_LIST),
			 MapUtility.entry(isART_ONLLWANTRLC(), TargetLane.HEADING_LEFT_ON_RIGHT_LANE_LIST),
			 MapUtility.entry(isALT_ONRLWANTLLC(),TargetLane.HEADING_RIGHT_ON_LEFT_LANE_LIST),
			 MapUtility.entry(isALT_ONLLWANTRLC(), TargetLane.HEADING_RIGHT_ON_RIGHT_LANE_LIST),
			 MapUtility.entry(isAI_ONRLWANTLLC(), TargetLane.HEADING_DOWN_ON_LEFT_LANE_LIST),
			 MapUtility.entry(isAI_ONLLWANTRLC(), TargetLane.HEADING_DOWN_ON_RIGHT_LANE_LIST))
		 
		 .filter(Map.Entry::getKey)
		 //.peek(e -> System.out.println("Checking TargetLane: " + e.getValue() + " -> " + e.getKey())) // 👈 Here
		 .map(Map.Entry::getValue)
		 .findFirst()
		 .ifPresentOrElse(lane ->{ this.setTargetLaneList(lane) ;},
		                  ()->{
		                	 /* System.out.println("The targetLaneList this list it's point to should now\n"
		                	  		+ "be empty, so the car is blind on the cars of the lane \n"
		                			+ "it is changing to");*/
		                	  this.setTargetLaneList(TargetLane.EMPTYLIST) ;
		                  });
	 }
	 
	 public boolean isBI_ONRLWANTLLC() {
		 return this.getCarIntention() == CarIntention.BI_ONRLWANTLLC;
	 }
	 
	 public boolean isBI_ONLLWANTRLC() {
		 return this.getCarIntention() == CarIntention.BI_ONLLWANTRLC;
	 }
	 
	 public boolean isBI_ONLLWANTLLC() {
		 return this.getCarIntention() == CarIntention.BI_ONLLWANTLLC;
	 }
	 
	 public boolean isBI_ONRLWANTRT() {
		 return this.getCarIntention() == CarIntention.BI_ONRLWANTRT;
	 }
	 
	 public boolean isBI_ONLTBWANTLT() {
		 return this.getCarIntention() == CarIntention.BI_ONLTBWANTLT;
	 }
	 
	 public boolean isART_ONRLWANTLLC() {
		 return this.getCarIntention() == CarIntention.ART_ONRLWANTLLC;
	 }
	 
	 public boolean isART_ONLLWANTRLC() {
		 return this.getCarIntention() == CarIntention.ART_ONLLWANTRLC;
	 }
	 
	 public boolean isALT_ONRLWANTLLC() {
		 return this.getCarIntention() == CarIntention.ALT_ONRLWANTLLC;
	 }
	 
	 public boolean isALT_ONLLWANTRLC() {
		 return this.getCarIntention() == CarIntention.ALT_ONLLWANTRLC;
	 }
	 
	 public boolean isAI_ONRLWANTLLC() {
		 return this.getCarIntention() == CarIntention.AI_ONRLWANTLLC;
	 }
	 
	 public boolean isAI_ONLLWANTRLC() {
		 return this.getCarIntention() == CarIntention.AI_ONLLWANTRLC;
	 }
	 //************at this point 10:37 pm before dinner 2025-05-18
		//Ended here do Target Lane Stuff Later 11:52 2025-05-19
		/**
		 * need to do a needToDoThisEveryTimeSetTargetFrontCarBlindSpotCarRearCar(){} --->method
		 */
		public void needToDoThisEverytimeSetTargetFrontCarBlindSpotCarRearCar() {
			this.setTargetLaneEnum();
			this.setTargetLaneListKey(this.getTargetLaneList());
			this.setTargetLaneCarsDetection( laneManagement.getTL_HashMap_For_ObservableList().get(getTargetLaneListKey()));
		};
		
		/**
		 * need to do a setTargetFrontCarBlindSpotCarRearCar()-->method
		 */
	public void setTargetLaneCarsDetection(ObservableList<IntersectionSimCar> theListOfTheLaneTheTargetedCarIsOn){//Should be not Class Specific
		
		
			
		    
			if(theListOfTheLaneTheTargetedCarIsOn.size() > 0 ) {
				
					switch (this.getTargetLaneListKey()) {
					/*case TargetLane.HEADING_LEFT_ON_RIGHT_LANE_LIST:
						setTargetLaneFrontCarBlindSpotCarRearCarHeadingLeft(theListOfTheLaneTheTargetedCarIsOn, LaneChangeDirection.LEFT);
					   
						break;
					case TargetLane.HEADING_LEFT_ON_LEFT_LANE_LIST:
						setTargetLaneFrontCarBlindSpotCarRearCarHeadingLeft(theListOfTheLaneTheTargetedCarIsOn, LaneChangeDirection.RIGHT);
						break;
					case TargetLane.HEADING_LEFT_IN_LEFTTURNBOX_LIST:
						setTargetLaneFrontCarBlindSpotCarRearCarHeadingLeft(theListOfTheLaneTheTargetedCarIsOn, LaneChangeDirection.LEFT);
						break;
					case TargetLane.HEADING_RIGHT_ON_RIGHT_LANE_LIST:
						setTargetLaneFrontCarBlindSpotCarRearCarHeadingRight(theListOfTheLaneTheTargetedCarIsOn, LaneChangeDirection.LEFT);
						break;
					case TargetLane.HEADING_RIGHT_ON_LEFT_LANE_LIST:
						setTargetLaneFrontCarBlindSpotCarRearCarHeadingRight(theListOfTheLaneTheTargetedCarIsOn, LaneChangeDirection.RIGHT);
						break;
						
					case TargetLane.HEADING_RIGHT_IN_LEFTTURNBOX_LIST:
						setTargetLaneFrontCarBlindSpotCarRearCarHeadingRight(theListOfTheLaneTheTargetedCarIsOn, LaneChangeDirection.LEFT);
						break;
					case TargetLane.HEADING_UP_ON_RIGHT_LANE_LIST:
						setTargetLaneFrontCarBlindSpotCarRearCarHeadingUp(theListOfTheLaneTheTargetedCarIsOn, LaneChangeDirection.LEFT);
						break;
					case TargetLane.HEADING_UP_ON_LEFT_LANE_LIST:
						setTargetLaneFrontCarBlindSpotCarRearCarHeadingUp(theListOfTheLaneTheTargetedCarIsOn, LaneChangeDirection.RIGHT);
						break;
					case TargetLane.HEADING_UP_IN_LEFTTURNBOX_LIST:
						setTargetLaneFrontCarBlindSpotCarRearCarHeadingUp(theListOfTheLaneTheTargetedCarIsOn, LaneChangeDirection.LEFT);
						break;*/
					case TargetLane.HEADING_DOWN_ON_RIGHT_LANE_LIST:
						setTargetLaneCarsDetectionHeadingDown(theListOfTheLaneTheTargetedCarIsOn, LaneChangeDirection.LEFT);
						break;
					case TargetLane.HEADING_DOWN_ON_LEFT_LANE_LIST:
						setTargetLaneCarsDetectionHeadingDown(theListOfTheLaneTheTargetedCarIsOn, LaneChangeDirection.RIGHT);
						break;
					case TargetLane.HEADING_DOWN_IN_LEFTTURNBOX_LIST:
						setTargetLaneCarsDetectionHeadingDown(theListOfTheLaneTheTargetedCarIsOn, LaneChangeDirection.LEFT);
						break;
					default:
						
						break;
						
					
				}
			}
			
		}
	//--------------------------------------------------------------------------------------------------------------------- work in progress 2025-05-13 5:16pm
	//---------------------------------------------------------------------------------------------------------------------^ work for this ended
	//Car Brain Continue.....
	enum LaneChangeDirection {
		RIGHT,
		LEFT
	}


	//------------------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		//Construction Zone for HeadingDown 12:09AM 2025-05-15
		//Construction Completed for HeadingDown 12:24AM 2025-05-15
		/*remember to fix the TargetLane Enum to a a DEFAULTEMPTYLIST and Initialize a Default OberservableList That's Empty

	    ///step 1: change the function Name by tweaking the "Heading---" Part of the name
	    
	    ///step 2: double temp_Front_Distance---Can be X or Y may need adjustment to the name
	    ///        double temp_Rear_Distance--- same thing ^
	    ///        that's it
	    ///
	    ///step 3: targetLane_Nearest_Front_Car_Base_On_DistanceHeading---need tweaking for "Heading---XorY" Part of the name
	    ///        targetLane_Nearest_Rear_Car_Base_On_DistanceHeading--- same thing ^ 
	    ///
	    ///step 4: isWithinBlindSpotFrontBound_Heading---need tweaking for "Heading---" Part of the name (Be sure to create the Helper function that it is)
	    ///		   isWithinBlindSpotRearBound_Heading---need tweaking for same thing ^
	    ///
	    ///step 5: (first if statement inside else)((helper)isFrontCar_Heading---Need direction)
	    ///        if statement inside (universal helper)isTempFrontDistanceGreaterThanLengthOfTheBlindSpotCarAndLessThanGreatestDistanceOfTheNearestFrontCar
	    ///        (...first argument like step 2 for Front, second argument no change, third argument like step 3 for the front one)
	    ///        inside(this if statement) like step 3 for (the Front one)-->targetLane_Nearest--blahblah (step 6)
	    ///        
	    ///        (Second if statement inside else)((helper)isRearCar_Heading---Need Direction)
	    ///        if statement inside (universal helper)isTempRearDistanceGreaterThanLengthOfTheBlindSpotCarAndLessThanGreaTestDistanceOfTheNearestRearCar
	    ///        (...first argument like step 2 for Rear, second argument no change, third argument like step 3 for the Rear one)
	    ///        inside(this if statement) like step 3 for (the Rear one)-->targetLane_Nearest--blahblah (step 6)
	            
	     */
		 /* 
		 * New Universal Helper Functions
		 * step 1: getTemp_FrontDistance--XorY //Done
		 * 
		 * step 2: getTemp_RearDistance--XorY //Done
		 */
		public void setTargetLaneCarsDetectionHeadingDown(ObservableList<IntersectionSimCar> theListOfTheLaneTheTargetedCarIsOn, LaneChangeDirection laneChangeDirection) {//Done
			
			double temp_Front_DistanceY;//Done step2
			double temp_Rear_DistanceY;//Done step2
			double lengthOfTheBlindSpotCar;
			
			setPrimaryBlindSpotCar(null);
			setFrontBlindSpotCarFrontCar(null);
			setFrontBlindSpotCar(null);
			setRearBlindSpotCar(null);
			setRearBlindSpotCarRearCar(null);
		    setFrontCarOnTargetLaneList(null);
		    setRearCarOnTargetLaneList(null);
			targetLane_Nearest_Front_Car_Base_On_DistanceHeadingDownY = MAX_Y_DISTANCE_BETWEEN_CARS;//Done step3
			targetLane_Nearest_Rear_Car_Base_On_DistanceHeadingDownY = MAX_Y_DISTANCE_BETWEEN_CARS;//Done step3
			temp_Rear_DistanceY = MAX_Y_DISTANCE_BETWEEN_CARS - 1 ;
			temp_Front_DistanceY = MAX_Y_DISTANCE_BETWEEN_CARS -1 ;
				for(IntersectionSimCar car : theListOfTheLaneTheTargetedCarIsOn) {
					lengthOfTheBlindSpotCar = car.getCustomCarLengthBaseOnCarSkin();
					if(this.getTargetLaneList() == TargetLane.EMPTYLIST || this == car || car == null) {
						continue;
					}else {
						
						
						if (isPrimaryBlindSpotCar(car)) {
							this.setPrimaryBlindSpotCar(car);
							this.setFrontCarOnTargetLaneList (this.getPrimaryBlindSpotCar().getFrontCar());
							this.setRearCarOnTargetLaneList (this.getPrimaryBlindSpotCar().getRearCar());
							
						}else if(isFrontBlindSpotCar(car) || isRearBlindSpotCar(car)) {
							 if(isFrontBlindSpotCar(car)) {
								this.setFrontBlindSpotCar(car);
								this.setFrontBlindSpotCarFrontCar(frontBlindSpotCar.getFrontCar());
								if(isRearBlindSpotCar ((IntersectionSimCar)frontBlindSpotCar.getRearCar())) {
									this.setRearBlindSpotCar((IntersectionSimCar)frontBlindSpotCar.getRearCar());
									this.setRearBlindSpotCarRearCar((IntersectionSimCar) rearBlindSpotCar.getRearCar());
									this.setRearCarOnTargetLaneList((rearBlindSpotCarRearCar == null? null : rearBlindSpotCarRearCar.getRearCar()));
								}else {
									this.setRearCarOnTargetLaneList(frontBlindSpotCar.getRearCar());
									this.setFrontCarOnTargetLaneList((frontBlindSpotCarFrontCar == null? null : frontBlindSpotCarFrontCar.getFrontCar()));
								}
							 }	
							 if(isRearBlindSpotCar(car)) {
								this.setRearBlindSpotCar(car);
								this.setRearBlindSpotCarRearCar(rearBlindSpotCar.getRearCar());
								if(isFrontBlindSpotCar ((IntersectionSimCar)rearBlindSpotCar.getFrontCar())) {
									this.setFrontBlindSpotCar((IntersectionSimCar)rearBlindSpotCar.getFrontCar());
									this.setFrontBlindSpotCarFrontCar((IntersectionSimCar) frontBlindSpotCar.getFrontCar());
									this.setFrontCarOnTargetLaneList((frontBlindSpotCarFrontCar == null? null : frontBlindSpotCarFrontCar.getFrontCar()));
								}else {
									this.setFrontCarOnTargetLaneList(rearBlindSpotCar.getFrontCar());
									this.setRearCarOnTargetLaneList((rearBlindSpotCarRearCar == null? null: rearBlindSpotCarRearCar.getRearCar()));
								}
							 }
							 
						}else if(isFrontCar_HeadingDown(car) ||isRearCar_HeadingDown(car) ) {
						
							  if(isFrontCar_HeadingDown(car)) {
									temp_Front_DistanceY = getTemp_FrontDistanceY(laneChangeDirection, car, temp_Front_DistanceY);//Done wasn't in steps
									if(isTempFrontDistanceGreaterThanLengthOfTheBlindSpotCarAndLessThanGreatestDistanceOfTheNearestFrontCar(temp_Front_DistanceY,lengthOfTheBlindSpotCar, this.targetLane_Nearest_Front_Car_Base_On_DistanceHeadingDownY)) {
										targetLane_Nearest_Front_Car_Base_On_DistanceHeadingDownY = temp_Front_DistanceY;//<Done step 5   //Done ^ step 5 and 6
										this.setFrontCarOnTargetLaneList(car);
										IntersectionSimCar temp_RearCar = ((this.getFrontCarOnTargetLaneList().getRearCar() == rearBlindSpotCar)? (rearBlindSpotCar == null? null: rearBlindSpotCar.getRearCar()):
																			this.getFrontCarOnTargetLaneList().getRearCar());
									                       temp_RearCar = (temp_RearCar == rearBlindSpotCarRearCar? (rearBlindSpotCarRearCar == null? null: rearBlindSpotCarRearCar.getRearCar()):
									                    	               temp_RearCar);
														   
										this.setRearCarOnTargetLaneList (temp_RearCar);
										//System.out.println("setTargetlaneFrontCarBlindSpotCarRearCarHeadingDown(blah)....isFrontCar_HeadingDown(this,car)....accessed");if(this.carIntention == CarIntention.BI_ONLLWANTRLC) {
										 System.out.println("\n\n--------------------------------------------------------------------------------------------------------------------------------------------------------------"+
										            "\n isFrontCar accessed"+  
												    "\n targetLaneListKey: " +this.getTargetLaneListKey()+ 
										    		"\n --->this: " + this.getCarSkin() + "ID: " +this.getCarId()  + " ---->               OnWhichLane: " + this.getOnWhichLaneListKey() +
													"\n --->this: " + this.getCarSkin() + "ID: " +this.getCarId()  + " ---->    frontCarOnTheOtherLane: " + (this.getFrontCarOnTargetLaneList() == null ? null : this.getFrontCarOnTargetLaneList().getCarSkin() )+ " ID: " +(this.getFrontCarOnTargetLaneList() == null ? null : this.getFrontCarOnTargetLaneList().getCarId())+
													"\n --->this: " + this.getCarSkin() + "ID: " +this.getCarId()  + " ----> frontBlindSpotCarFrontCar: " + (this.getFrontBlindSpotCarFrontCar() == null ? null : this.getFrontBlindSpotCarFrontCar().getCarSkin())+ " ID: " + (this.getFrontBlindSpotCarFrontCar() == null ? null : this.getFrontBlindSpotCarFrontCar().getCarId())+
													"\n --->this: " + this.getCarSkin() + "ID: " +this.getCarId()  + " ---->         frontblindSpotCar: " + (this.getFrontBlindSpotCar() == null ? null : this.getFrontBlindSpotCar().getCarSkin())+ " ID: " + (this.getFrontBlindSpotCar() == null ? null : this.getFrontBlindSpotCar().getCarId())+
													"\n --->this: " + this.getCarSkin() + "ID: " +this.getCarId()  + " ---->       primaryblindSpotCar: " + (this.getPrimaryBlindSpotCar() == null ? null : this.getPrimaryBlindSpotCar().getCarSkin())+ " ID: " + (this.getPrimaryBlindSpotCar() == null ? null : this.getPrimaryBlindSpotCar().getCarId())+
													"\n --->this: " + this.getCarSkin() + "ID: " +this.getCarId()  + " ---->          rearblindSpotCar: " + (this.getRearBlindSpotCar() == null ? null : this.getRearBlindSpotCar().getCarSkin())+ " ID: " + (this.getRearBlindSpotCar() == null ? null : this.getRearBlindSpotCar().getCarId())+
													"\n --->this: " + this.getCarSkin() + "ID: " +this.getCarId()  + " ---->   rearblindSpotCarRearCar: " + (this.getRearBlindSpotCarRearCar() == null ? null : this.getRearBlindSpotCarRearCar().getCarSkin())+ " ID: " + (this.getRearBlindSpotCarRearCar() == null ? null : this.getRearBlindSpotCarRearCar().getCarId())+
													
													"\n --->this: " + this.getCarSkin() + "ID: " +this.getCarId()  + " ---->  rearCarOnTheOtherLane: " + (this.getRearCarOnTargetLaneList() == null ? null : this.getRearCarOnTargetLaneList().getCarSkin())+ " ID: " + (this.getRearCarOnTargetLaneList() == null ? null : this.getRearCarOnTargetLaneList().getCarId())
										            +"\n isFrontCar End---------------------------------------------------------------------------------------------------------------------------------------------------------------");
									           }
												
										
									}
							  }
							  if (isRearCar_HeadingDown(car)) {//Done step 5{
									temp_Rear_DistanceY = getTemp_RearDistanceY(laneChangeDirection, car , temp_Rear_DistanceY);//Done wasn't in steps
									if(isTempRearDistanceGreaterThanLengthOfTheBlindSpotCarAndLessThanGreatestDistanceOfTheNearestRearCar(temp_Rear_DistanceY,lengthOfTheBlindSpotCar, this.targetLane_Nearest_Rear_Car_Base_On_DistanceHeadingDownY)) {
										targetLane_Nearest_Rear_Car_Base_On_DistanceHeadingDownY = temp_Rear_DistanceY;//<Done step 5*      //Done ^ step 5 and 6*
										this.setRearCarOnTargetLaneList(car);
										
										IntersectionSimCar temp_FrontCar = (this.getRearCarOnTargetLaneList().getFrontCar() == frontBlindSpotCar? (frontBlindSpotCar == null? null:frontBlindSpotCar.getFrontCar()) :
																	        this.getRearCarOnTargetLaneList().getFrontCar());
									                       temp_FrontCar = (temp_FrontCar == rearBlindSpotCar? (rearBlindSpotCar == null? null: rearBlindSpotCar.getFrontCar()):
									                    	                 temp_FrontCar);
									                       temp_FrontCar = (temp_FrontCar == frontBlindSpotCar? (frontBlindSpotCar == null? null : frontBlindSpotCar.getFrontCar()):
									                    	                 temp_FrontCar);
									                       temp_FrontCar = (temp_FrontCar == frontBlindSpotCarFrontCar? (frontBlindSpotCarFrontCar == null? null: frontBlindSpotCarFrontCar.getFrontCar()):
									                    	                 temp_FrontCar);
										                 
										this.setFrontCarOnTargetLaneList(temp_FrontCar);
										 System.out.println("\n\n--------------------------------------------------------------------------------------------------------------------------------------------------------------"+
										            "\n isRearCar accessed"+  
												    "\n targetLaneListKey: " +this.getTargetLaneListKey()+ 
										    		"\n --->this: " + this.getCarSkin() + "ID: " +this.getCarId()  + " ---->               OnWhichLane: " + this.getOnWhichLaneListKey() +
													"\n --->this: " + this.getCarSkin() + "ID: " +this.getCarId()  + " ---->    frontCarOnTheOtherLane: " + (this.getFrontCarOnTargetLaneList() == null ? null : this.getFrontCarOnTargetLaneList().getCarSkin() )+ " ID: " +(this.getFrontCarOnTargetLaneList() == null ? null : this.getFrontCarOnTargetLaneList().getCarId())+
													"\n --->this: " + this.getCarSkin() + "ID: " +this.getCarId()  + " ----> frontBlindSpotCarFrontCar: " + (this.getFrontBlindSpotCarFrontCar() == null ? null : this.getFrontBlindSpotCarFrontCar().getCarSkin())+ " ID: " + (this.getFrontBlindSpotCarFrontCar() == null ? null : this.getFrontBlindSpotCarFrontCar().getCarId())+
													"\n --->this: " + this.getCarSkin() + "ID: " +this.getCarId()  + " ---->         frontblindSpotCar: " + (this.getFrontBlindSpotCar() == null ? null : this.getFrontBlindSpotCar().getCarSkin())+ " ID: " + (this.getFrontBlindSpotCar() == null ? null : this.getFrontBlindSpotCar().getCarId())+
													"\n --->this: " + this.getCarSkin() + "ID: " +this.getCarId()  + " ---->       primaryblindSpotCar: " + (this.getPrimaryBlindSpotCar() == null ? null : this.getPrimaryBlindSpotCar().getCarSkin())+ " ID: " + (this.getPrimaryBlindSpotCar() == null ? null : this.getPrimaryBlindSpotCar().getCarId())+
													"\n --->this: " + this.getCarSkin() + "ID: " +this.getCarId()  + " ---->          rearblindSpotCar: " + (this.getRearBlindSpotCar() == null ? null : this.getRearBlindSpotCar().getCarSkin())+ " ID: " + (this.getRearBlindSpotCar() == null ? null : this.getRearBlindSpotCar().getCarId())+
													"\n --->this: " + this.getCarSkin() + "ID: " +this.getCarId()  + " ---->   rearblindSpotCarRearCar: " + (this.getRearBlindSpotCarRearCar() == null ? null : this.getRearBlindSpotCarRearCar().getCarSkin())+ " ID: " + (this.getRearBlindSpotCarRearCar() == null ? null : this.getRearBlindSpotCarRearCar().getCarId())+
													
													"\n --->this: " + this.getCarSkin() + "ID: " +this.getCarId()  + " ---->  rearCarOnTheOtherLane: " + (this.getRearCarOnTargetLaneList() == null ? null : this.getRearCarOnTargetLaneList().getCarSkin())+ " ID: " + (this.getRearCarOnTargetLaneList() == null ? null : this.getRearCarOnTargetLaneList().getCarId())
										            +"\n isRearCar End---------------------------------------------------------------------------------------------------------------------------------------------------------------");
									           }
									}
							  }
							  
								
					 }  
						
						
						
			    
			
			if(this.carIntention == CarIntention.BI_ONLLWANTRLC) {
				 System.out.println("\n targetLaneListKey: " +this.getTargetLaneListKey()+ 
		    		"\n --->this: " + this.getCarSkin() + "ID: " +this.getCarId()  + " ---->               OnWhichLane: " + this.getOnWhichLaneListKey() +
					"\n --->this: " + this.getCarSkin() + "ID: " +this.getCarId()  + " ---->    frontCarOnTheOtherLane: " + (this.getFrontCarOnTargetLaneList() == null ? null : this.getFrontCarOnTargetLaneList().getCarSkin() )+ " ID: " +(this.getFrontCarOnTargetLaneList() == null ? null : this.getFrontCarOnTargetLaneList().getCarId())+
					"\n --->this: " + this.getCarSkin() + "ID: " +this.getCarId()  + " ----> frontBlindSpotCarFrontCar: " + (this.getFrontBlindSpotCarFrontCar() == null ? null : this.getFrontBlindSpotCarFrontCar().getCarSkin())+ " ID: " + (this.getFrontBlindSpotCarFrontCar() == null ? null : this.getFrontBlindSpotCarFrontCar().getCarId())+
					"\n --->this: " + this.getCarSkin() + "ID: " +this.getCarId()  + " ---->         frontblindSpotCar: " + (this.getFrontBlindSpotCar() == null ? null : this.getFrontBlindSpotCar().getCarSkin())+ " ID: " + (this.getFrontBlindSpotCar() == null ? null : this.getFrontBlindSpotCar().getCarId())+
					"\n --->this: " + this.getCarSkin() + "ID: " +this.getCarId()  + " ---->       primaryblindSpotCar: " + (this.getPrimaryBlindSpotCar() == null ? null : this.getPrimaryBlindSpotCar().getCarSkin())+ " ID: " + (this.getPrimaryBlindSpotCar() == null ? null : this.getPrimaryBlindSpotCar().getCarId())+
					"\n --->this: " + this.getCarSkin() + "ID: " +this.getCarId()  + " ---->          rearblindSpotCar: " + (this.getRearBlindSpotCar() == null ? null : this.getRearBlindSpotCar().getCarSkin())+ " ID: " + (this.getRearBlindSpotCar() == null ? null : this.getRearBlindSpotCar().getCarId())+
					"\n --->this: " + this.getCarSkin() + "ID: " +this.getCarId()  + " ---->   rearblindSpotCarRearCar: " + (this.getRearBlindSpotCarRearCar() == null ? null : this.getRearBlindSpotCarRearCar().getCarSkin())+ " ID: " + (this.getRearBlindSpotCarRearCar() == null ? null : this.getRearBlindSpotCarRearCar().getCarId())+
					
					"\n --->this: " + this.getCarSkin() + "ID: " +this.getCarId()  + " ---->  rearCarOnTheOtherLane: " + (this.getRearCarOnTargetLaneList() == null ? null : this.getRearCarOnTargetLaneList().getCarSkin())+ " ID: " + (this.getRearCarOnTargetLaneList() == null ? null : this.getRearCarOnTargetLaneList().getCarId()));
		         }
				
		}
		
		//Construction Zone for HeadingDown 12:09AM 2025-05-15
		//Construction Completed for HeadingDown 12:24AM 2025-05-15
		//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
		private boolean isFrontCar_HeadingDown( IntersectionSimCar car) { // done step 3
			
			boolean isFrontCar = this.getFrontLeftCornerPositionY() < car.getRearLeftCornerPositionY();
			//System.out.println("isFrontCar_HeadingDown(blah...) accessed: isFrontCar =" + isFrontCar);
			
			return ((car != primaryBlindSpotCar && car != frontBlindSpotCar && car != rearBlindSpotCar)?
					(this.getFrontLeftCornerPositionY() < car.getRearLeftCornerPositionY()) : false);//Done step 3
		}
		private boolean isRearCar_HeadingDown(IntersectionSimCar car) { // done step 4
			return ((car != primaryBlindSpotCar && car != frontBlindSpotCar && car != rearBlindSpotCar)?
					(this.getRearLeftCornerPositionY() > car.getFrontLeftCornerPositionY()):false); // Done step 4
			
		}

		//Construction Zone for HeadingDown 12:09AM 2025-05-15
		//Construction Completed for HeadingDown 12:24AM 2025-05-15
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// new helper function for setTargetLaneCarsDetectionHeadingDown(blah)
		
		private boolean isPrimaryBlindSpotCar(IntersectionSimCar car) {
			
			return ((this.getFrontRightCornerPositionY() >= car.getFrontRightCornerPositionY() && this.getRearRightCornerPositionY() <= car.getRearRightCornerPositionY())||
					(this.getFrontRightCornerPositionY() <= car.getFrontRightCornerPositionY() && this.getRearRightCornerPositionY() >= car.getRearRightCornerPositionY()));
		}
		
		
		private boolean isFrontBlindSpotCar(IntersectionSimCar car) {
			return (car!=null? ((this.getFrontRightCornerPositionY() > car.getRearLeftCornerPositionY()) && 
					(this.getRearRightCornerPositionY() < car.getRearLeftCornerPositionY())): false);
		}
		
		private boolean isRearBlindSpotCar(IntersectionSimCar car) {
			
			return (car!=null ?((this.getFrontRightCornerPositionY() > car.getFrontLeftCornerPositionY()) && 
					(this.getRearRightCornerPositionY() < car.getFrontLeftCornerPositionY())): false);
		}
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		//ZOMBIE: "UNIVERSAL HELPERS RIGHT HERE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
		// This two are helper function that are non-Direction Specific but be sure to follow instruction about tweaking it's arguments inside the setTargetLaneFrontCarBlindSpotCarRearCarHeading--Need Direction Method
		private boolean isTempFrontDistanceGreaterThanLengthOfTheBlindSpotCarAndLessThanGreatestDistanceOfTheNearestFrontCar(double temp_Front_DistanceXorY, double customCarLengthBaseOnCarSkin, double determineFrontCar_Needs_Heading) {
			
			boolean isAtTheRightDistanceToBeAFrontCar =(temp_Front_DistanceXorY < determineFrontCar_Needs_Heading);
			//System.out.println("isTempFrontDistanceGreaterThanLengthOfBlindSpotCarAndLessThanGreastestDistanceOfTheNearestFrontCar(Blah): isAtTheRightDistanceToBeAFrontCar:" + isAtTheRightDistanceToBeAFrontCar);
			return isAtTheRightDistanceToBeAFrontCar;
		}
		
		private boolean isTempRearDistanceGreaterThanLengthOfTheBlindSpotCarAndLessThanGreatestDistanceOfTheNearestRearCar(double temp_Rear_DistanceXorY,double customCarLengthBaseOnCarSkin, double determineRearCar_Needs_Heading) {
			return ( temp_Rear_DistanceXorY < determineRearCar_Needs_Heading);
		}
		/*
		 * --------------------------------------------------------------------------------------------
		 * New Construction for New Universal Helper Functions  1:05AM 2025-05-15
		 * Construction for New Universal Helper Function Completed 1:33AM 2025-05-15
		 /* 
		 * New Universal Helper Functions
		 * step 1: getTemp_FrontDistance--XorY
		 * 
		 * step 2: getTemp_RearDistance--XorY
		 */
		 
		 private double getTemp_FrontDistanceY(LaneChangeDirection laneChangeDirection, IntersectionSimCar car, double temp_Front_Distance) {
			 if(car != primaryBlindSpotCar && car != frontBlindSpotCar && car != rearBlindSpotCar) {
				 return (laneChangeDirection == LaneChangeDirection.RIGHT?
						 Math.abs(this.getFrontLeftCornerPositionY() - car.getRearLeftCornerPositionY()):
							 Math.abs(this.getFrontRightCornerPositionY() - car.getRearRightCornerPositionY()));
			 }else {
				 return temp_Front_Distance;
			 }
		 }
		 
		 private double getTemp_RearDistanceY(LaneChangeDirection laneChangeDirection, IntersectionSimCar car, double temp_Rear_Distance) {
			if(car != primaryBlindSpotCar && car != frontBlindSpotCar && car != rearBlindSpotCar) {
				 return (laneChangeDirection == LaneChangeDirection.RIGHT?
						 Math.abs(this.getRearRightCornerPositionY() - car.getFrontRightCornerPositionY()):
							 Math.abs(this.getRearLeftCornerPositionY() - car.getFrontLeftCornerPositionY()));
			}else {
				 return temp_Rear_Distance;
			}
		 }
		 
		/* private double getTemp_FrontDistanceX(LaneChangeDirection laneChangeDirection, IntersectionSimCar car) {
			 return (laneChangeDirection == LaneChangeDirection.RIGHT?
					 Math.abs(this.getFrontLeftCornerPositionY() - car.getRearLeftCornerPositionY()):
						 Math.abs(this.getFrontRightCornerPositionY() - car.getRearRightCornerPositionY()));
		 }
		 
		 private double getTemp_RearDistanceX(LaneChangeDirection laneChangeDirection, IntersectionSimCar car) {
			 return (laneChangeDirection == LaneChangeDirection.RIGHT?
					 Math.abs(this.getRearRightCornerPositionY() - car.getFrontRightCornerPositionY()):
						 Math.abs(this.getRearLeftCornerPositionY() - car.getFrontLeftCornerPositionY()));
		 }*/
		 // New Construction for New Universal Helper Functions 1:05AM 2025-05-15
		 //Construction for New Universal Helper Function Completed 1:33AM 2025-05-15
		 //------------------------------------------------------------------------------------------------------------------
//*****************************************************************************************************************************************************************************************************************
	 //Left or right blinkers signal turn on will borrow from setTargetEnum() Helpers functions to determine the necessity to consider turning the blinkers on
	 public void turnOnLeftOrRightBlinkersBasedOnCarIntention() {
		
		if(isBI_ONLLWANTRLC()||isBI_ONRLWANTRT()||isART_ONLLWANTRLC()||isALT_ONLLWANTRLC()||isAI_ONLLWANTRLC()) {
			rightBlinkersShouldBlinkAtTheRightMoment();
		}else if(isBI_ONRLWANTLLC()||isBI_ONLLWANTLLC()||isBI_ONLTBWANTLT()||isART_ONRLWANTLLC()||isALT_ONRLWANTLLC()||isAI_ONRLWANTLLC()) {
			leftBlinkersShouldBlinkAtTheRightMoment();
		}
	 }
	 //*****************************************************************************************************************************************************************************************************************
	/**
	 * kinda have an idea of how to keep track of the car making a right turn or a left turn 
	 * the Center point of the left turn circle the car path is tracing is (TOP_MAKE_LEFT_POINTX + LEFTTURNRADIUS) is the X
	 * (TOP_MAKE_LEFT_POINTY) is the Y so the Coordinate of the Center Point is (X,Y) and you can use the pythagorean theorem to calculate the point you 
	 * want the car to pause and wait for traffic to clear, the point where the Left turning should end and the car should be going straight, and that
	 * allows you to track and know when left turn has started and the car progress in the left turn SAME THING CAN BE DONE FOR THE RIGHT (MAKE CHANGES IN THE CODE LATER!!!!) ^^
	 * 
	 * CHATGPT Math.atan2(dy,dx) GODSEND ATANGENT FOR ALL QUARDRANTS BABY!!!!!!!!!!!! METHOD FROM A BRILLIANT MIND NOTHING TO DO WITH ME!!!!!
	 */
	 @Override
	 public void setGeneralPlacementOfCarBasedOnGeneralLocation() {
		  
		   double dist_from_LeftTurn_Point = Math.sqrt(Math.pow((TOP_MAKE_LEFT_POINTX - this.getPositionX()),2) + Math.pow((TOP_MAKE_LEFT_POINTY - this.getPositionY()),2));//tweak here
		   double dist_from_RightTurn_Point = Math.sqrt(Math.pow((TOP_MAKE_RIGHT_POINTX - this.getPositionX()), 2) + Math.pow((TOP_MAKE_RIGHT_POINTY - this.getPositionY()),2));
		   
		     if(isGoingStraightBeforeIntersection() && isOnOriginalRightLane()) {
		    	 this.setGeneralPlacementOfCar( GeneralPlacementOfCar.BI_ONRIGHTLANE);
		     }else if(isGoingStraightBeforeIntersection() && isOnOriginalLeftLane()) {
		    	 this.setGeneralPlacementOfCar( GeneralPlacementOfCar.BI_ONLEFTLANE);
		     }else if(isInsideLeftTurnBox()) {
		    	 this.setGeneralPlacementOfCar(GeneralPlacementOfCar.LEFTTURNBOX);
		     }else if (dist_from_RightTurn_Point < 5.5){
		    	 this.setGeneralPlacementOfCar(GeneralPlacementOfCar.IN_INTERSECTIONWFRTURN);
			 }else if(dist_from_LeftTurn_Point < 5.5){//tweak here
				 this.setGeneralPlacementOfCar(GeneralPlacementOfCar.IN_INTERSECTIONWFLTURN);
			 }else if(isBlockingOnComingTraffic()) {//tweak here
				 this.setGeneralPlacementOfCar(GeneralPlacementOfCar.IN_INTERSECTIONBLOCKOCT);
			 }else if(isOnOriginalLeftLane() && isBlockingLeftTraffic() || isOnOriginalRightLane() && isBlockingLeftTraffic()) {//tweak here
				 this.setGeneralPlacementOfCar(GeneralPlacementOfCar.IN_INTERSECTIONBLOCKLT);
			 }else if(isOnOriginalLeftLane() && isBlockingRightTraffic() || isOnOriginalRightLane() && isBlockingRightTraffic()) {//tweak here
				 this.setGeneralPlacementOfCar(GeneralPlacementOfCar.IN_INTERSECTIONBLOCKRT);
			 }else if(isOnRightLaneAfterRightTurn()) {
				 this.setGeneralPlacementOfCar(GeneralPlacementOfCar.ART_ONRIGHTLANE);
		     }else if(isOnLeftLaneAfterRightTurn()) {
		    	 this.setGeneralPlacementOfCar(GeneralPlacementOfCar.ART_ONLEFTLANE);
		     }else if(isOnRightLaneAfterLeftTurn() ) {
		     
		    	 this.setGeneralPlacementOfCar(GeneralPlacementOfCar.ALT_ONRIGHTLANE);
			 }else if(isOnLeftLaneAfterLeftTurn()) {
				 this.setGeneralPlacementOfCar(GeneralPlacementOfCar.ALT_ONLEFTLANE);
			 }else if(isGoingStraightAfterIntersection() && isOnOriginalRightLane() ){
				 this.setGeneralPlacementOfCar(GeneralPlacementOfCar.AI_ONRIGHTLANE);
			 }else if(isGoingStraightAfterIntersection() && isOnOriginalLeftLane() ){
				 this.setGeneralPlacementOfCar(GeneralPlacementOfCar.AI_ONLEFTLANE);
			 }else{
				 this.setGeneralPlacementOfCar(GeneralPlacementOfCar.INTRANSITION);
			 }
	  }
	  
	 private boolean isGoingStraightBeforeIntersection() {
		 return this.getPositionY() < TOP_MAKE_RIGHT_POINTY && this.getRotationAngle() == HEADING_DOWN_CARDINAL_ANGLE;//tweak here
	 }
	 
	 private boolean isGoingStraightAfterIntersection() {
		 return this.getPositionY() > BOTTOM_MAKE_RIGHT_POINTY && this.getRotationAngle() == HEADING_DOWN_CARDINAL_ANGLE;//tweak here need Fs for it to work
	 }
	 
	 private boolean isBlockingOnComingTraffic() {
		 return this.getPositionX() > TOP_MAKE_LEFT_POINTX && this.getPositionX() < BOTTOM_MAKE_RIGHT_POINTX;//tweak here need blinkers for it to work
	 }
	 private boolean isInsideLeftTurnBox() {
		 return Math.abs(HEADING_DOWN_CENTER_OF_LTB_LANE_X - this.getPositionX()) < TOLERANCE && this.getRotationAngle() == HEADING_DOWN_CARDINAL_ANGLE;
	 }
	 
	 private boolean isBlockingLeftTraffic() {
		 return this.getPositionY() >=  TOP_MAKE_RIGHT_POINTY + 2.5 && this.getPositionY() <= TOP_MAKE_LEFT_POINTY + 5.5 ;//tweak here need blinkers for it to work**not finished
	 }
	 
	 private boolean isBlockingRightTraffic() {
		 return  this.getPositionY() >TOP_MAKE_LEFT_POINTY + 5.5  && this.getPositionY() <= BOTTOM_MAKE_RIGHT_POINTY - 2.5;//tweak here need blinkers for it to work
	 }
	 private boolean isOnOriginalLeftLane() {
		 return Math.abs(HEADING_DOWN_CENTER_OF_L_LANE_X - this.getPositionX()) < TOLERANCE;
	 }
	 
	 private boolean isOnOriginalRightLane() {
		 return Math.abs(HEADING_DOWN_CENTER_OF_R_LANE_X - this.getPositionX()) < TOLERANCE;
	 }
	 
	 private boolean isOnRightLaneAfterRightTurn() {//tweak
		 return Math.abs(HEADING_LEFT_CENTER_OF_R_LANE_Y - this.getPositionY()) < TOLERANCE && this.getRotationAngle() == HEADING_LEFT_CARDINAL_ANGLE;
	 }
	 
	 private boolean isOnLeftLaneAfterRightTurn() {//tweak
		 return Math.abs(HEADING_LEFT_CENTER_OF_L_LANE_Y - this.getPositionY()) < TOLERANCE && this.getRotationAngle() == HEADING_LEFT_CARDINAL_ANGLE;
	 }
	 
	 private boolean isOnRightLaneAfterLeftTurn() {//tweak
		 return  Math.abs(HEADING_RIGHT_CENTER_OF_R_LANE_Y - this.getPositionY()) < TOLERANCE && this.getRotationAngle() == HEADING_RIGHT_CARDINAL_ANGLE;
	 }
	 
	 private boolean isOnLeftLaneAfterLeftTurn() {//tweak
		 return Math.abs(HEADING_RIGHT_CENTER_OF_L_LANE_Y - this.getPositionY()) < TOLERANCE && this.getRotationAngle() == HEADING_RIGHT_CARDINAL_ANGLE;
	 }
	 
	 
	 public class CarCornerCoordinate{
			public double coordinateX_P;
			public double coordinateY_P;

				public CarCornerCoordinate(double coordinateX, double coordinateY) {
					this.coordinateX_P = coordinateX;
					this.coordinateY_P = coordinateY;
				}
				
				public double getCoordinateX_P() {
					return this.coordinateX_P;
				}
				
				public double getCoordinateY_P() {
					return this.coordinateY_P;
				}
			}



			private CarCornerCoordinate[] carCornerCoordinate;

			public CarCornerCoordinate[] getCarCornerCoordinate() {
				return carCornerCoordinate;
			}

			public void positionCarCorners() {

				double frontRCornerX = this.getFrontRightCornerPositionX();
				double frontRCornerY = this.getFrontRightCornerPositionY();
				double frontLCornerX = this.getFrontLeftCornerPositionX();
				double frontLCornerY = this.getFrontLeftCornerPositionY();
				double rearRCornerX = this.getRearRightCornerPositionX();
				double rearRCornerY = this.getRearRightCornerPositionY();
				double rearLCornerX = this.getRearLeftCornerPositionX();
				double rearLCornerY = this.getRearLeftCornerPositionY();
				
				carCornerCoordinate[0]= new CarCornerCoordinate(frontRCornerX, frontRCornerY);
				carCornerCoordinate[1] = new CarCornerCoordinate(frontLCornerX, frontLCornerY);
				carCornerCoordinate[2] = new CarCornerCoordinate(rearRCornerX, rearRCornerY);
				carCornerCoordinate[3] = new CarCornerCoordinate(rearLCornerX, rearLCornerY);





			}
    @Override
	public void drawCircleRpCorner ( CarCornerCoordinate[] carCornerCoordinate) {
		if(this != null && carCornerCoordinate.length == 4) {
			
			for (int i = 0 ; i < 4; i++) {
		    	
		        if (this.carCornerCircle[i] != null) {
		    		
		    		//set properties
		    		carCornerCircle[i].setCenterX(carCornerCoordinate[i].getCoordinateX_P());
		    		carCornerCircle[i].setCenterY(carCornerCoordinate[i].getCoordinateY_P());
		    		
		    		//set circle radius
		    		carCornerCircle[i].setRadius(2);
		    		
		    		//set the fill color
		    		carCornerCircle[i].setFill(Color.RED);
		    		
		    		//optional: set the border (stroke)
		    		carCornerCircle[i].setStroke(Color.BLACK);
		    		carCornerCircle[i].setStrokeWidth(1);
		            carCornerCircle[i].setVisible(false);//set to false to view the blinkers blinking
		           
		        }
		    }
		}
				
	}
	 //note remember to setCarskinlength 2025-05-29 2:37am -->DONE
	 public HeadedDownOrigCar(Pane root, LaneManagement laneManagement, 
  		   double spawnPositionX, 
  		   double spawnPositionY) {
  	    super( laneManagement, spawnPositionX, spawnPositionY);
  	    this.setGeneralPlacementOfCarBasedOnGeneralLocation();
  	    carCornerCoordinate = new CarCornerCoordinate[4];
  	     r_BiCancelRight_LaneChangeExitAngle = rotationAngle;
  	  
  	    this.setGeneralPlacementOfCarBasedOnGeneralLocation();//still need to ensure all lane are accounted for
		this.needToDoThisEverytimeSetFrontCarAndRearCar();
		//this.needToDoThisEverytimeSetTargetFrontCarBlindSpotCarRearCar();
  	    Random random = new Random();
  	
  	   //car_P.setxCoordinateSelected(false);
  	   int randomInt = random.nextInt(180);
  	   
  	
	    front_R_BlinkerImage_P = new Image(getClass().getResource("/Signal-lights-for-intersection-programOriginal/New-folder/Turn_Signals_002LB.png").toExternalForm());
	    front_L_BlinkerImage_P = new Image(getClass().getResource("/Signal-lights-for-intersection-programOriginal/New-folder/Turn_Signals_002LB.png").toExternalForm());
	    rear_R_BlinkerImage_P = new Image(getClass().getResource("/Signal-lights-for-intersection-programOriginal/New-folder/Turn_Signals_002LB.png").toExternalForm());
	    rear_L_BlinkerImage_P = new Image(getClass().getResource("/Signal-lights-for-intersection-programOriginal/New-folder/Turn_Signals_002LB.png").toExternalForm());
	    front_R_BlinkerImage2_P = new Image(getClass().getResource("/Signal-lights-for-intersection-programOriginal/New-folder/Turn_Signals_002.png").toExternalForm());
	    front_L_BlinkerImage2_P = new Image(getClass().getResource("/Signal-lights-for-intersection-programOriginal/New-folder/Turn_Signals_002.png").toExternalForm());
	    rear_R_BlinkerImage2_P = new Image(getClass().getResource("/Signal-lights-for-intersection-programOriginal/New-folder/Turn_Signals_002.png").toExternalForm());
	    rear_L_BlinkerImage2_P = new Image(getClass().getResource("/Signal-lights-for-intersection-programOriginal/New-folder/Turn_Signals_002.png").toExternalForm());
	    front_R_BlinkerImage3_P = new Image(getClass().getResource("/Signal-lights-for-intersection-programOriginal/New-folder/Turn_Signals_002_brightest.png").toExternalForm());
	    front_L_BlinkerImage3_P = new Image(getClass().getResource("/Signal-lights-for-intersection-programOriginal/New-folder/Turn_Signals_002_brightest.png").toExternalForm());
	    rear_R_BlinkerImage3_P = new Image(getClass().getResource("/Signal-lights-for-intersection-programOriginal/New-folder/Turn_Signals_002_brightest.png").toExternalForm());
	    rear_L_BlinkerImage3_P = new Image(getClass().getResource("/Signal-lights-for-intersection-programOriginal/New-folder/Turn_Signals_002_brightest.png").toExternalForm());
	    front_R_BlinkerImageView_P = new ImageView(front_R_BlinkerImage_P);
	    front_L_BlinkerImageView_P = new ImageView(front_L_BlinkerImage_P);
	    rear_R_BlinkerImageView_P = new ImageView(rear_R_BlinkerImage_P);
	    rear_L_BlinkerImageView_P = new ImageView(rear_L_BlinkerImage_P);
	    front_R_BlinkerImageView2_P = new ImageView(front_R_BlinkerImage2_P);
	    front_L_BlinkerImageView2_P = new ImageView(front_L_BlinkerImage2_P);
	    rear_R_BlinkerImageView2_P = new ImageView(rear_R_BlinkerImage2_P);
	    rear_L_BlinkerImageView2_P = new ImageView(rear_L_BlinkerImage2_P);
	    front_R_BlinkerImageView3_P = new ImageView(front_R_BlinkerImage3_P);
	    front_L_BlinkerImageView3_P = new ImageView(front_L_BlinkerImage3_P);
	    rear_R_BlinkerImageView3_P = new ImageView(rear_R_BlinkerImage3_P);
	    rear_L_BlinkerImageView3_P = new ImageView(rear_L_BlinkerImage3_P);
	    front_R_BlinkerImageView_P.setFitWidth(12);
  	    front_L_BlinkerImageView_P.setFitWidth(12);
  	    rear_R_BlinkerImageView_P.setFitWidth(12);
  	    rear_L_BlinkerImageView_P.setFitWidth(12);
  	    front_R_BlinkerImageView2_P.setFitWidth(12);
     	front_L_BlinkerImageView2_P.setFitWidth(12);
     	rear_R_BlinkerImageView2_P.setFitWidth(12);
     	rear_L_BlinkerImageView2_P.setFitWidth(12);
        front_R_BlinkerImageView3_P.setFitWidth(12);
  	    front_L_BlinkerImageView3_P.setFitWidth(12);
  	    rear_R_BlinkerImageView3_P.setFitWidth(12);
  	    rear_L_BlinkerImageView3_P.setFitWidth(12);
  	
  	    front_R_BlinkerImageView_P.setFitHeight(10);
     	front_L_BlinkerImageView_P.setFitHeight(10);
     	rear_R_BlinkerImageView_P.setFitHeight(10);
    	rear_L_BlinkerImageView_P.setFitHeight(10);
    	front_R_BlinkerImageView2_P.setFitHeight(10);
        front_L_BlinkerImageView2_P.setFitHeight(10);
        rear_R_BlinkerImageView2_P.setFitHeight(10);
        rear_L_BlinkerImageView2_P.setFitHeight(10);
        front_R_BlinkerImageView3_P.setFitHeight(10);
     	front_L_BlinkerImageView3_P.setFitHeight(10);
     	rear_R_BlinkerImageView3_P.setFitHeight(10);
    	rear_L_BlinkerImageView3_P.setFitHeight(10);
		if (randomInt >=0 && randomInt < 20) {
			carImage_P = new Image(getClass().getResource("/car-sprite2/blue-race-car.png").toExternalForm());
		    carImage_brake_P= new Image(getClass().getResource("/car-sprite2/blue-race-car-brake.png").toExternalForm());
		    this.setCarSkin( "blue-race-car");
			carImageView_P = new ImageView(carImage_P);
			carImageView_brake_P = new ImageView(carImage_brake_P);
			this.setBlinkerLengthAndAngleAlsoCarImageViewWidth(new BlueRaceCarConfig());
		}else if ( randomInt >=20 && randomInt < 40) {
			carImage_P = new Image(getClass().getResource("/car-sprite2/finished-blue-byd.png").toExternalForm());
			carImage_brake_P = new Image(getClass().getResource("/car-sprite2/finished-blue-byd-brake.png").toExternalForm());
			this.setCarSkin("finished-blue-byd");
			carImageView_P = new ImageView(carImage_P);
			carImageView_brake_P = new ImageView(carImage_brake_P);
			
		    this.setBlinkerLengthAndAngleAlsoCarImageViewWidth(new FinishedBlueBydConfig());
		}else if (randomInt >=40 && randomInt < 60) {
			carImage_P = new Image(getClass().getResource("/car-sprite2/red-corrolla.png").toExternalForm());
			carImage_brake_P = new Image(getClass().getResource("/car-sprite2/red-corrolla-brake.png").toExternalForm());
			this.setCarSkin("red-corrolla");
		  		carImageView_P = new ImageView(carImage_P);
		  		carImageView_brake_P = new ImageView(carImage_brake_P);
		  		
		  		this.setBlinkerLengthAndAngleAlsoCarImageViewWidth(new RedCorrollaConfig());
		  
		  	}else if (randomInt >=60 && randomInt < 80) {
		  		carImage_P = new Image(getClass().getResource("/car-sprite2/finished-grey2-byd.png").toExternalForm());
			carImage_brake_P = new Image(getClass().getResource("/car-sprite2/finished-grey2-byd-brake.png").toExternalForm());
			this.setCarSkin("finished-grey2-byd");
			carImageView_P = new ImageView(carImage_P);
			carImageView_brake_P = new ImageView(carImage_brake_P);
		  	
			this.setBlinkerLengthAndAngleAlsoCarImageViewWidth(new FinishedGrey2BydConfig());
		}else if (randomInt >=80 && randomInt < 100) {
			carImage_P = new Image(getClass().getResource("/car-sprite2/finished-grey-byd.png").toExternalForm());
			carImage_brake_P = new Image(getClass().getResource("/car-sprite2/finished-grey-byd-brake.png").toExternalForm());
			this.setCarSkin("finished-grey-byd");
			carImageView_P = new ImageView(carImage_P);
			carImageView_brake_P = new ImageView(carImage_brake_P);
		  	
			this.setBlinkerLengthAndAngleAlsoCarImageViewWidth(new FinishedGreyBydConfig());
		}else if (randomInt >=100 && randomInt < 120) {
			carImage_P = new Image(getClass().getResource("/car-sprite2/finished-teal-byd2.png").toExternalForm());
			carImage_brake_P  = new Image(getClass().getResource("/car-sprite2/finished-teal-byd2-brake.png").toExternalForm());
			this.setCarSkin("finished-teal-byd2");
			carImageView_P = new ImageView(carImage_P);
			carImageView_brake_P = new ImageView(carImage_brake_P);
		  	
			this.setBlinkerLengthAndAngleAlsoCarImageViewWidth(new FinishedTealByd2Config());
		}else if(randomInt >=120 && randomInt < 140) {
			carImage_P = new Image(getClass().getResource("/car-sprite2/Yellow-car-sprite3.png").toExternalForm());
			carImage_brake_P = new Image(getClass().getResource("/car-sprite2/Yellow-car-sprite3-brake.png").toExternalForm());
			this.setCarSkin("Yellow car Sprite");
			carImageView_P = new ImageView(carImage_P);
			carImageView_brake_P = new ImageView(carImage_brake_P);
		  	
			this.setBlinkerLengthAndAngleAlsoCarImageViewWidth(new YellowCarSprite3Config());
		}else if(randomInt >=140 && randomInt < 160) {
			carImage_P = new Image(getClass().getResource("/car-sprite2/Red-car-sprite.png").toExternalForm());
				carImage_brake_P  = new Image(getClass().getResource("/car-sprite2/Red-car-sprite-brake.png").toExternalForm());
				this.setCarSkin("Red-car-Sprite");		
			carImageView_P = new ImageView(carImage_P);
			carImageView_brake_P = new ImageView(carImage_brake_P);
		
			this.setBlinkerLengthAndAngleAlsoCarImageViewWidth(new RedCarSpriteConfig());
		}else if(randomInt >=160 && randomInt < 180) {
			carImage_P = new Image(getClass().getResource("/car-sprite2/Green-car-sprite.png").toExternalForm());
			carImage_brake_P = new Image(getClass().getResource("/car-sprite2/Green-car-sprite-brake.png").toExternalForm());
			this.setCarSkin("Green-Car-Sprite");
			carImageView_P = new ImageView(carImage_P);
			carImageView_brake_P = new ImageView(carImage_brake_P);
		  	
			this.setBlinkerLengthAndAngleAlsoCarImageViewWidth(new GreenCarSpriteConfig());
		}else{
			System.out.println("Something went wrong in Car.java line 19 to line 29.");
		}
		calculateAndSetAllBlinkersAngle(this.angle_Diff_Front_Blinkers, this.angle_Diff_Rear_Blinkers);
 	 	calculateAllBlinkersPosition(this.length_For_Front_Blinkers, this.length_For_Rear_Blinkers);
 	 	calculateAndSetAllCornersAngle(this.angle_Diff_Front_Corners, this.angle_Diff_Rear_Corners);
		calculateAllCornersPosition(this.length_For_Front_Corners, this.length_For_Rear_Corners);
		
		
		  this.setCustomCarLengthBaseOnCarSkin();
		 this.positionCarCorners();
	  	 this.setCarCornerCircle();
     	this.initializeBlinkersSetsAll4();
     	this.initializeLeftBlinkersSets();
     	this.initializeRightBlinkersSets();
     	rightBlinkersToggle = RightBlinkersToggle.OFF;
     	leftBlinkersToggle = LeftBlinkersToggle.OFF;
     	double imageViewsAngle = 0;
		imageViewsAngle = 360 - (90 - this.getRotationAngle());
		double normalizedImageViewAngle = (imageViewsAngle + 360) % 360;
		imageViewsAngle = normalizedImageViewAngle;
		
		
		this.carImageView_P.setPreserveRatio(true);
		this.carImageView_brake_P.setPreserveRatio(true);
		double fixedX2 =  this.getPositionX();
	
		double fixedY2 =  this.getPositionY();
		
		
		
		positionBlinkersImageView(imageViewsAngle, this.front_R_BlinkerImageView_P, this.front_L_BlinkerImageView_P, this.rear_R_BlinkerImageView_P, this.rear_L_BlinkerImageView_P);
		positionBlinkersImageView(imageViewsAngle, this.front_R_BlinkerImageView2_P, this.front_L_BlinkerImageView2_P, this.rear_R_BlinkerImageView2_P, this.rear_L_BlinkerImageView2_P);
		positionBlinkersImageView(imageViewsAngle, this.front_R_BlinkerImageView3_P, this.front_L_BlinkerImageView3_P, this.rear_R_BlinkerImageView3_P, this.rear_L_BlinkerImageView3_P);
		
		double calculatedLayoutPointForOffCenterFixedPointX = fixedX2 - this.carImageView_P.getFitWidth()/2;
		double calculatedLayoutPointForOffCenterFixedPointY = fixedY2 - 52;
		
	
		
		
		this.carImageView_P.setLayoutX(fixedX2);
		this.carImageView_P.setLayoutY(fixedY2);

		this.carImageView_brake_P.setLayoutX(fixedX2);
		this.carImageView_brake_P.setLayoutY(fixedY2);
		 //Calculate the Translation to move the pivot point to (0,0)
		Translate translateToPivot2 = new Translate(-fixedX2, -fixedY2);
		
		
		
	
		
		
		//Rotate around the center of the ImageView, now aligned with the desired fixed coordinate
		Rotate rotate3 = new Rotate (imageViewsAngle, fixedX2, fixedY2);
		Rotate rotate4 = new Rotate (imageViewsAngle, fixedX2, fixedY2);
		
		
		//carImage2View.getTransforms().add(rotate2);
		//Translate the ImageView back to its original position
	
		Translate backToPosition2 = new Translate(calculatedLayoutPointForOffCenterFixedPointX, calculatedLayoutPointForOffCenterFixedPointY);
		
		this.carImageView_P.getTransforms().clear();// you need to clear it so the angle return back to its original position because the previous angle matters
		this.carImageView_P.getTransforms().addAll(translateToPivot2, rotate3, backToPosition2);
		
		this.carImageView_brake_P.getTransforms().clear();// you need to clear it so the angle return back to its original position because the previous angle matters
		this.carImageView_brake_P.getTransforms().addAll(translateToPivot2, rotate4, backToPosition2);
  	
  	
	
  }
  
  
 


	public Image getCarImage_P() {
		return carImage_P;
	}


	public void setCarImage_P(Image carImage_P) {
		this.carImage_P = carImage_P;
	}


	public ImageView getCarImageView_P() {
		return carImageView_P;
	}


	public void setCarImageView_P(ImageView carImageView_P) {
		this.carImageView_P = carImageView_P;
	}


	public void removeCarImagesAndImageViewsFromRoot(Pane root) {
  	
  	    this.carImageView_P.setImage(null);
  	    this.carImageView_brake_P.setImage(null);
  	    this.front_R_BlinkerImageView_P.setImage(null);
  	    this.front_L_BlinkerImageView_P.setImage(null);
  	    this.rear_R_BlinkerImageView_P.setImage(null);
	    this.rear_L_BlinkerImageView_P.setImage(null);
	    this.front_R_BlinkerImageView2_P.setImage(null);
  	    this.front_L_BlinkerImageView2_P.setImage(null);
  	    this.rear_R_BlinkerImageView2_P.setImage(null);
	    this.rear_L_BlinkerImageView2_P.setImage(null);
	    this.front_R_BlinkerImageView3_P.setImage(null);
  	    this.front_L_BlinkerImageView3_P.setImage(null);
  	    this.rear_R_BlinkerImageView3_P.setImage(null);
	    this.rear_L_BlinkerImageView3_P.setImage(null);
  		root.getChildren().remove(this.carImageView_P);
  		root.getChildren().remove(this.carImageView_brake_P);
  	    root.getChildren().remove(this.front_R_BlinkerImageView_P);
  	    root.getChildren().remove(this.front_L_BlinkerImageView_P);
  	    root.getChildren().remove(this.rear_R_BlinkerImageView_P);
  	    root.getChildren().remove(this.rear_L_BlinkerImageView_P);
  	    
  	    root.getChildren().remove(this.front_R_BlinkerImageView2_P);
  	    root.getChildren().remove(this.front_L_BlinkerImageView2_P);
  	    root.getChildren().remove(this.rear_R_BlinkerImageView2_P);
  	    root.getChildren().remove(this.rear_L_BlinkerImageView2_P);
  	    
  	    root.getChildren().remove(this.front_R_BlinkerImageView3_P);
  	    root.getChildren().remove(this.front_L_BlinkerImageView3_P);
  	    root.getChildren().remove(this.rear_R_BlinkerImageView3_P);
  	    root.getChildren().remove(this.rear_L_BlinkerImageView3_P);
  }
	/**
   * Need to think about it
   * @param startRightTurnX
   * @param straightEndingX
   * @param straightEndingY
   */
  //set the object properties: rise, run, velocityWanted, riseOverRun, runOverRise, distanceTraveledYaxis, distanceTraveledXaxis
  //make sure if wantToMakeALeft is true then the car i start turning when It hit the Y coordinate UPLEFTTURNY so that the leftTurn() function can be called at that critical point
  public void positionManipulationFormula(double startLaneChangeTurnX, double startLaneChangeTurnY, double straightEndingX, double straightEndingY){
      
      setRise( Math.sin(getRotationAngle() * (Math.PI / 180)));//* orY;
     
      setRun(Math.cos(getRotationAngle() * (Math.PI / 180)));//* orX;
      setVelocityWanted(getDistanceAdjusted()/60);
      setRiseOverRun(getRise()/getRun());
      setRunOverRise (getRun()/getRise());
      double normalizedRotationAngle = this.normalizedRotationAngle();
      //distanceTraveledXaxis = 60 * Math.sqrt(Math.pow(velocityWanted,2)/ (Math.pow(riseOverRun,2) + 1));
      //distanceTraveledYaxis = 60 * Math.sqrt(Math.pow(velocityWanted,2)/ (Math.pow(runOverRise,2) + 1));
      
      setDistanceTraveledXaxis(Math.cos(normalizedRotationAngle)* getDistanceAdjusted());
      setDistanceTraveledYaxis (Math.sin(normalizedRotationAngle)* getDistanceAdjusted());
      double remainingDistanceX_Test = Math.abs(getPositionX() - startLaneChangeTurnX);
      double remainingDistanceY_Test = Math.abs(getPositionY() - startLaneChangeTurnY);
      double remainingDistanceXab = Math.abs(getPositionX() - straightEndingX); //absolute value of the remaining Distance in the x-axis at the end of phase 2 in a lane change operation
      double remainingDistanceYab = Math.abs(getPositionY() - straightEndingY); //absolute value of the remaining Distance in the y-axis at the end of phase 2 in a lane change operation 
      //double remainingDistanceHDFCarY = Math.abs(270 - this.getFrontRightCornerPositionY());
     /*System.out.println("this.beforeInt_RightLaneChangePhase == LaneChangePhase.PHASE_2: " + (this.beforeInt_RightLaneChangePhase == LaneChangePhase.PHASE_2) + "\n"
  		               +"remainingDistanceXab = " + remainingDistanceXab + " , distanceTraveledXaxis =" + Math.abs(distanceTraveledXaxis) + "\n"
  		               +"remainingDistanceYab = " + remainingDistanceYab + " , distanceTraveledYaxis =" + Math.abs(distanceTraveledYaxis) + "\n"); */
     
      
      if (  getCarIntention() == CarIntention.BI_ONLTBWANTLT && (HEADINGDOWNLEFTTURNY - getPositionY()) < getDistanceTraveledYaxis()) {
      	//System.out.println("CircleRpCar PositionManipulationFormula");
      	setDistanceTraveledYaxis(HEADINGDOWNLEFTTURNY - getPositionY());
      	setCarIntention(CarIntention.NONE);
      }else if (getCarIntention() == CarIntention.BI_ONLLWANTRLC && remainingDistanceY_Test < getDistanceTraveledYaxis()){
      	setDistanceTraveledYaxis(remainingDistanceY_Test);
      	
      }else if (getCarIntention() == CarIntention.ALT_ONLLWANTRLC && remainingDistanceX_Test < getDistanceTraveledXaxis()){
      	setDistanceTraveledXaxis(remainingDistanceX_Test);
      	
      }else if (getAfterLT_RightLaneChangePhase() == LaneChangePhase.PHASE_2 && remainingDistanceXab < Math.abs(getDistanceTraveledXaxis()) && remainingDistanceYab < Math.abs(getDistanceTraveledYaxis())) {
      	setDistanceTraveledYaxis(remainingDistanceYab);
      	setDistanceTraveledXaxis (remainingDistanceXab);
      }else if (getBeforeInt_RightLaneChangePhase() == LaneChangePhase.PHASE_2 && remainingDistanceXab < Math.abs(getDistanceTraveledXaxis()) && remainingDistanceYab < Math.abs(getDistanceTraveledYaxis())) {
      	//System.out.println("positionManipulationFormula(****) -->this.beforeInt_RightLanePhase == LaneChangePhase.Phase2--->accessed");
      	setDistanceTraveledYaxis ( Math.sin(normalizedRotationAngle)/ Math.abs(Math.sin(normalizedRotationAngle))*remainingDistanceYab);
      	setDistanceTraveledXaxis (Math.cos(normalizedRotationAngle)/ Math.abs(Math.cos(normalizedRotationAngle))*remainingDistanceXab);
      }
      
      calculateAndSetAllBlinkersAngle(this.angle_Diff_Front_Blinkers, this.angle_Diff_Rear_Blinkers);
	 	calculateAllBlinkersPosition(this.length_For_Front_Blinkers, this.length_For_Rear_Blinkers);
	 	calculateAndSetAllCornersAngle(this.angle_Diff_Front_Corners, this.angle_Diff_Rear_Corners);
		calculateAllCornersPosition(this.length_For_Front_Corners, this.length_For_Rear_Corners);
		 this.positionCarCorners();
	  	 //this.setCarCornerCircle();
   	     //this.initialize();
      double imageViewsAngle = 0;
		imageViewsAngle = 360 - (90 - this.getRotationAngle());
		double normalizedImageViewAngle = (imageViewsAngle + 360) % 360;
		imageViewsAngle = normalizedImageViewAngle;
		
		
		this.carImageView_P.setPreserveRatio(true);
		this.carImageView_brake_P.setPreserveRatio(true);
		double fixedX2 =  this.getPositionX();
	
		double fixedY2 =  this.getPositionY();
		
		
		
		positionBlinkersImageView(imageViewsAngle, this.front_R_BlinkerImageView_P, this.front_L_BlinkerImageView_P, this.rear_R_BlinkerImageView_P, this.rear_L_BlinkerImageView_P);
		positionBlinkersImageView(imageViewsAngle, this.front_R_BlinkerImageView2_P, this.front_L_BlinkerImageView2_P, this.rear_R_BlinkerImageView2_P, this.rear_L_BlinkerImageView2_P);
		positionBlinkersImageView(imageViewsAngle, this.front_R_BlinkerImageView3_P, this.front_L_BlinkerImageView3_P, this.rear_R_BlinkerImageView3_P, this.rear_L_BlinkerImageView3_P);
		
		double calculatedLayoutPointForOffCenterFixedPointX = fixedX2 - this.carImageView_P.getFitWidth()/2;
		double calculatedLayoutPointForOffCenterFixedPointY = fixedY2 - 52;
		
	
		
		
		this.carImageView_P.setLayoutX(fixedX2);
		this.carImageView_P.setLayoutY(fixedY2);

		this.carImageView_brake_P.setLayoutX(fixedX2);
		this.carImageView_brake_P.setLayoutY(fixedY2);
		 //Calculate the Translation to move the pivot point to (0,0)
		Translate translateToPivot2 = new Translate(-fixedX2, -fixedY2);
		
		
		
	
		
		
		//Rotate around the center of the ImageView, now aligned with the desired fixed coordinate
		Rotate rotate3 = new Rotate (imageViewsAngle, fixedX2, fixedY2);
		Rotate rotate4 = new Rotate (imageViewsAngle, fixedX2, fixedY2);
		
		
		//carImage2View.getTransforms().add(rotate2);
		//Translate the ImageView back to its original position
	
		Translate backToPosition2 = new Translate(calculatedLayoutPointForOffCenterFixedPointX, calculatedLayoutPointForOffCenterFixedPointY);
		
		this.carImageView_P.getTransforms().clear();// you need to clear it so the angle return back to its original position because the previous angle matters
		this.carImageView_P.getTransforms().addAll(translateToPivot2, rotate3, backToPosition2);
		
		this.carImageView_brake_P.getTransforms().clear();// you need to clear it so the angle return back to its original position because the previous angle matters
		this.carImageView_brake_P.getTransforms().addAll(translateToPivot2, rotate4, backToPosition2);
      
     
  		
  }
  
//****************************************************************************************************************************************************************************************************************
  /**
   * Manages and set the Car State
   */
  public void carState() {
 	 	
 	 
 	
 	   
 		
 		//this.aLT_RightLaneChangePhaseIntention();
	  
 		this.bI_RightLaneChangePhaseIntention();
 		turnOnLeftOrRightBlinkersBasedOnCarIntention();
 		this.setCarActionState();
 		
 		
 		
  }
  
  public void setCarActionState() {
		 
		 
		 
		 if(this.shouldDo_AfterLeftTurn_RightLaneChange()) {
			 
			 //System.out.println("CircleRpCar.java line: 796 carID: "+this+ " CarIntention: " + carIntention);
				
				carAction = CarAction.ALT_RIGHTLANECHANGE;
				//System.out.println("CircleRpCar.java line 801 accessed ---car ID: " +  this + " | Phase: " + afterLT_RightLaneChangePhase + " |  PositionX: " + positionX);	
				
		}else if(this.shouldDo_BeforeInt_RightLaneChange()) {
		     //System.out.println("setCarActionState() --> this.shouldDo_BeforeInt_RightLaneChange()");
			 carAction = CarAction.BI_RIGHTLANECHANGE;
		
		}else {
			
			if( this.shouldGoStraight()) {
				carAction = CarAction.GOSTRAIGHT;
			}
		}
		 this.bI_RightLaneChangePhaseState();
		 //this.bI_CancelRightLaneChangePhaseState();//Wrong Reason Get Rid for now because of shouldCancelRightLaneChange helper function
		 //this.aLT_RightLaneChangePhaseState();
		 //this.aLT_CancelRightLaneChangePhaseState();
		
		 if(shouldLeftTurn()) {
		 		
				carAction = CarAction.LEFTTURN;
		
		 }
		 
		
	 }
  /**
   * Decision setting the state in right lane change mode after a left turn after conditions are met
   * condition: if car has intention for right lane change and if car reached turning point position
   * @return boolean True/false
   */
  private boolean shouldDo_AfterLeftTurn_RightLaneChange() {
 	 return carIntention == CarIntention.ALT_ONLLWANTRLC && this.positionX == this.xCoordinate;
  }
  
  /**
   * Decision setting the state in right lane change mode before Intersection after conditions are met
   * condition: if car has intention for right lane change and if car reached turning point position
   * @return boolean True/false
   */
  private boolean shouldDo_BeforeInt_RightLaneChange() {
 	 //System.out.println("shouldDo_BeforeInt_RightLaneChange()--->carIntention:" + carIntention);
 	 return carIntention == CarIntention.BI_ONLLWANTRLC && this.positionY == this.yCoordinate;
  }
  
  /**
   * if carAction's state is not set to (after left turn right lane change) and if the car is not facing a cardinal angle 
   * @return boolean True/false
   */
  private boolean shouldGoStraight() {
 	 
 	 return carAction != CarAction.ALT_RIGHTLANECHANGE && carAction != CarAction.ALT_CANCELRIGHTLANECHANGE  && (rotationAngle == 180 || rotationAngle ==270 || rotationAngle == 90 || rotationAngle == 0);
  }
  
  /**
   * need to think about it **if the car is on the leftTurnBox lane then it has to turn left
   * need to WORK ON THIS CONDITION
   * @return
   */
  private boolean shouldLeftTurn() {
 	 return this.getGeneralPlacementOfCar() == GeneralPlacementOfCar.LEFTTURNBOX && this.getPositionY() == 297.5;
  }
  /**
   * How the car would act base on it's state
   * @param carImageView --ImageView contained the skin associated with the CircleRpCar Object
   * @param carImageView_brake --ImageView contained the skin (Brake Light On) associated with the CircleRpCar Object
   */
  public void actionBaseOnCarState(ImageView carImageView, ImageView carImageView_Brake) {//May Need tweaking here
 	 
 	 
	 this.rightBlinkersOnOffBasedOnToggleState();
	 this.leftBlinkersOnOffBasedOnToggleState();
 	 carImageView.setVisible(false);
 	 carImageView_Brake.setVisible(true);
 	// System.out.println("actionBaseOnCarState: " + this.carAction);
 	 switch(carAction) {
 	 	case CarAction.LEFTTURN:
 	 		// makeALeftTurn(carImageView, carImageView_Brake);
 	 		break;
 	 	case CarAction.BI_RIGHTLANECHANGE:
  		   // System.out.println("actionBaseOnCarState(ImageView, ImageView) --> case carAction.BI_RIGHTLANECHANGE accessed");
  			this.bI_RightLaneChange();
  			break;
 	 	
 	 	case CarAction.BI_CANCELRIGHTLANECHANGE:
 	 		//System.out.println("actionBaseOnCarState : BI_CANCELRIGHTLANECHANGE.");
  		    this.bI_CancelRightLaneChange();
  		    break;
 	 	
 	 	case CarAction.ALT_RIGHTLANECHANGE:
 	 		    
 	 			//this.aLT_RightLaneChange();
 	 		break;
 	 	case CarAction.ALT_CANCELRIGHTLANECHANGE:
 	 		   // this.aLT_CancelRightLaneChange();
 	 		break;
 	 	
 	 	
 	 	case CarAction.GOSTRAIGHT:
 	 		//carImageView.setVisible(true);
 	    	//carImageView_Brake.setVisible(false);
 	 		this.gasGoStraight();
 	 		break;
 	 	default:  	
 			
 	 		break;
 	 }
  }
  public void makeALeftTurn(ImageView carImageView, ImageView carImageView_Brake) {
 	 carImageView.setVisible(false);
  	 carImageView_Brake.setVisible(true);
  	this.leftTurn(this.LEFTTURNEXITANGLE,IntersectionSimCar.LEFTTURNRADIUS );
  }
  
 
 
 
 
 //**************************************************************************************************************************************************************************************************************
	public void carOperation() {
  	
		this.laneChangePointYSelection();
  	positionManipulationFormula(this.getxCoordinate(),this.getyCoordinate(),getStraightEndingX(),getStraightEndingY());
  	
		
  		calculateAndSetAllBlinkersAngle(this.angle_Diff_Front_Blinkers, this.angle_Diff_Rear_Blinkers);
 	 	calculateAllBlinkersPosition(this.length_For_Front_Blinkers, this.length_For_Rear_Blinkers);
 	 	calculateAndSetAllCornersAngle(this.angle_Diff_Front_Corners, this.angle_Diff_Rear_Corners);
		calculateAllCornersPosition(this.length_For_Front_Corners, this.length_For_Rear_Corners);
		this.positionCarCorners();
		this.drawCircleRpCorner(carCornerCoordinate);
		//this.setGeneralPlacementOfCar();//still need to ensure all lane are accounted for
		this.needToDoThisEverytimeSetFrontCarAndRearCar();
		if(this.getFrontCar() != null && this.getFrontCar().isAlive() == false)
           this.setFrontCar(null);
		this.needToDoThisEverytimeSetTargetFrontCarBlindSpotCarRearCar();
		//this.laneChangePointXSelection();// need to come up with lane change decision logic
		
		this.carState();
		this.actionBaseOnCarState(carImageView_P, carImageView_brake_P);
		
		//System.out.println("distanceAdjusted: " + this.distanceAdjusted);
		//this.gasGoStraight();
	
		
		//------------------------------------------------------------------------------------------------------------------------------------Temporary Code
		
		         
		
		 //--------------------------------------------------------------------------------------------------------------------------------------Temporary Code
	      /*
				 System.out.println(
				    "\ntargetLaneListKey: " +this.getOnWhichLaneListKey()+ 
		    		"\n --->this: " + this.getCarSkin() + "---->        OnWhichLane: " + this.getOnWhichLaneListKey() +
		    		"\n --->this: " + this.getCarSkin() + "getObservablelistCarisOn(): " + this.laneManagement.getHashMap_For_Observablelist().get(getOnWhichLaneListKey()) +
					"\n --->this: " + this.getCarSkin() + "---->           frontCar: " + (this.getFrontCar() == null ? null : this.getFrontCar().getCarSkin()) +
					       
					"\n --->this: " + this.getCarSkin() + "---->            rearCar: " + (this.getRearCar() == null ? null : this.getRearCar().getCarSkin())
				);
		   */
		
		
		
		
		
		
		//this.blinkersBlinks();
  }
  /**
   * needed for initialization and continued calculation to keep blinkers in their proper place along with the car's movement
   * @param angle_Difference_Front_Blinkers --> the fixed angle difference between the rotation angle and the angle a front blinker needs to be at
   * @param angle_Difference_Back_Blinkers  --> the fixed angle difference between the rotation angle and the angle a rear blinker needs to be at
   */
  public void calculateAndSetAllBlinkersAngle(double angle_Difference_Front_Blinkers, double angle_Difference_Back_Blinkers) {
 	 
  	double bN_front_R_Blinker_Angle = this.getRotationAngle() + angle_Difference_Front_Blinkers;
  	double bN_front_L_Blinker_Angle = this.getRotationAngle() - angle_Difference_Front_Blinkers;
  	double bN_rear_R_Blinker_Angle = this.getRotationAngle() + angle_Difference_Back_Blinkers;
  	double bN_rear_L_Blinker_Angle = this.getRotationAngle() - angle_Difference_Back_Blinkers;
  	
  	this.front_R_Blinker_Angle = angleNormalization(bN_front_R_Blinker_Angle);
  	this.front_L_Blinker_Angle = angleNormalization(bN_front_L_Blinker_Angle);
  	this.rear_R_Blinker_Angle = angleNormalization(bN_rear_R_Blinker_Angle);
  	this.rear_L_Blinker_Angle = angleNormalization(bN_rear_L_Blinker_Angle);
  }
  
  /**
   * need for initialization and continued calculation to keep blinkers in their proper place along with the car's movement
   * @param length_CarPosToFrontBlinker --the fixed length between the primary reference point such as (positionX,positionY) and the front Blinker Position (blahblah....X, blahblah....Y)
   * @param length_CarPosToRearBlinker  --the fixed length between the primary reference point such as (positionX,positionY) and the rear Blinker Position (blahblah....X, blahblah....Y)
   */
  public void calculateAllBlinkersPosition (double length_CarPosToFrontBlinker, double length_CarPosToRearBlinker) {
  	double change_In_X_Front_R_Blinker = Math.cos(front_R_Blinker_Angle) * length_CarPosToFrontBlinker;
  	double change_In_Y_Front_R_Blinker = Math.sin(front_R_Blinker_Angle) * length_CarPosToFrontBlinker;
  	double change_In_X_Front_L_Blinker = Math.cos(front_L_Blinker_Angle) * length_CarPosToFrontBlinker;
  	double change_In_Y_Front_L_Blinker = Math.sin(front_L_Blinker_Angle) * length_CarPosToFrontBlinker;
  	
  	double change_In_X_Rear_R_Blinker = Math.cos(rear_R_Blinker_Angle) * length_CarPosToRearBlinker;
  	double change_In_Y_Rear_R_Blinker = Math.sin(rear_R_Blinker_Angle) * length_CarPosToRearBlinker;
  	double change_In_X_Rear_L_Blinker = Math.cos(rear_L_Blinker_Angle) * length_CarPosToRearBlinker;
  	double change_In_Y_Rear_L_Blinker = Math.sin(rear_L_Blinker_Angle) * length_CarPosToRearBlinker;
  	
  	frontRightBlinkerPositionX = this.getPositionX() + change_In_X_Front_R_Blinker;
  	frontRightBlinkerPositionY = this.getPositionY()  + change_In_Y_Front_R_Blinker;
  	frontLeftBlinkerPositionX = this.getPositionX() + change_In_X_Front_L_Blinker;
  	frontLeftBlinkerPositionY = this.getPositionY() + change_In_Y_Front_L_Blinker;
  	rearRightBlinkerPositionX = this.getPositionX()  + change_In_X_Rear_R_Blinker;
  	rearRightBlinkerPositionY = this.getPositionY()  + change_In_Y_Rear_R_Blinker;
  	rearLeftBlinkerPositionX = this.getPositionX()  + change_In_X_Rear_L_Blinker;
  	rearLeftBlinkerPositionY = this.getPositionY()  + change_In_Y_Rear_L_Blinker;
  }
  
 
  
  
  public double getFrontRightBlinkerPositionX() {
		return frontRightBlinkerPositionX;
	}


	public void setFrontRightBlinkerPositionX(double frontRightBlinkerPositionX) {
		this.frontRightBlinkerPositionX = frontRightBlinkerPositionX;
	}


	public double getFrontRightBlinkerPositionY() {
		return frontRightBlinkerPositionY;
	}


	public void setFrontRightBlinkerPositionY(double frontRightBlinkerPositionY) {
		this.frontRightBlinkerPositionY = frontRightBlinkerPositionY;
	}


	public double getFrontLeftBlinkerPositionX() {
		return frontLeftBlinkerPositionX;
	}


	public void setFrontLeftBlinkerPositionX(double frontLeftBlinkerPositionX) {
		this.frontLeftBlinkerPositionX = frontLeftBlinkerPositionX;
	}


	public double getFrontLeftBlinkerPositionY() {
		return frontLeftBlinkerPositionY;
	}


	public void setFrontLeftBlinkerPositionY(double frontLeftBlinderPositionY) {
		this.frontLeftBlinkerPositionY = frontLeftBlinderPositionY;
	}


	public double getRearRightBlinkerPositionX() {
		return rearRightBlinkerPositionX;
	}


	public void setRearRightBlinkerPositionX(double backRightBlinkerPositionX) {
		this.rearRightBlinkerPositionX = backRightBlinkerPositionX;
	}


	public double getRearRightBlinkerPositionY() {
		return rearRightBlinkerPositionY;
	}


	public void setRearRightBlinkerPositionY(double backRightBlinkerPositionY) {
		this.rearRightBlinkerPositionY = backRightBlinkerPositionY;
	}


	public double getRearLeftBlinkerPositionX() {
		return rearLeftBlinkerPositionX;
	}


	public void setRearLeftBlinkerPositionX(double backLeftBlinkerPositionX) {
		this.rearLeftBlinkerPositionX = backLeftBlinkerPositionX;
	}


	public double getRearLeftBlinkerPositionY() {
		return rearLeftBlinkerPositionY;
	}


	public void setRearLeftBlinkerPositionY(double backLeftBlinderPositionY) {
		this.rearLeftBlinkerPositionY = backLeftBlinderPositionY;
	}


	


	public double getFront_R_Blinker_Angle() {
		return front_R_Blinker_Angle;
	}


	public void setFront_R_Blinker_Angle(double front_R_Blinker_Angle) {
		this.front_R_Blinker_Angle = front_R_Blinker_Angle;
	}


	public double getFront_L_Blinker_Angle() {
		return front_L_Blinker_Angle;
	}


	public void setFront_L_Blinker_Angle(double front_L_Blinker_Angle) {
		this.front_L_Blinker_Angle = front_L_Blinker_Angle;
	}


	public double getBack_R_Blinker_Angle() {
		return rear_R_Blinker_Angle;
	}


	public void setBack_R_Blinker_Angle(double back_R_Blinker_Angle) {
		this.rear_R_Blinker_Angle = back_R_Blinker_Angle;
	}


	public double getBack_L_Blinker_Angle() {
		return rear_L_Blinker_Angle;
	}


	public void setBack_L_Blinker_Angle(double back_L_Blinker_Angle) {
		this.rear_L_Blinker_Angle = back_L_Blinker_Angle;
	}
  //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 public void calculateAndSetAllCornersAngle(double angle_Difference_Front_Corners, double angle_Difference_Back_Corners) {
  	 
	    	double bN_front_R_Corner_Angle = this.getRotationAngle() + angle_Difference_Front_Corners;
	    	double bN_front_L_Corner_Angle = this.getRotationAngle() - angle_Difference_Front_Corners;
	    	double bN_rear_R_Corner_Angle = this.getRotationAngle() + angle_Difference_Back_Corners;
	    	double bN_rear_L_Corner_Angle = this.getRotationAngle() - angle_Difference_Back_Corners;
	    	
	    	this.front_R_Corner_Angle = angleNormalization(bN_front_R_Corner_Angle);
	    	this.front_L_Corner_Angle = angleNormalization(bN_front_L_Corner_Angle);
	    	this.rear_R_Corner_Angle = angleNormalization(bN_rear_R_Corner_Angle);
	    	this.rear_L_Corner_Angle = angleNormalization(bN_rear_L_Corner_Angle);
	    }
	    
	    public void calculateAllCornersPosition (double length_CarPosToFrontCorner, double length_CarPosToRearCorner) {
	    	double change_In_X_Front_R_Corner = Math.cos(front_R_Corner_Angle) * length_CarPosToFrontCorner;
	    	double change_In_Y_Front_R_Corner = Math.sin(front_R_Corner_Angle) * length_CarPosToFrontCorner;
	    	double change_In_X_Front_L_Corner = Math.cos(front_L_Corner_Angle) * length_CarPosToFrontCorner;
	    	double change_In_Y_Front_L_Corner = Math.sin(front_L_Corner_Angle) * length_CarPosToFrontCorner;
	    	
	    	double change_In_X_Rear_R_Corner = Math.cos(rear_R_Corner_Angle) * length_CarPosToRearCorner;
	    	double change_In_Y_Rear_R_Corner = Math.sin(rear_R_Corner_Angle) * length_CarPosToRearCorner;
	    	double change_In_X_Rear_L_Corner = Math.cos(rear_L_Corner_Angle) * length_CarPosToRearCorner;
	    	double change_In_Y_Rear_L_Corner = Math.sin(rear_L_Corner_Angle) * length_CarPosToRearCorner;
	    	
	    	frontRightCornerPositionX = this.getPositionX() + change_In_X_Front_R_Corner;
	    	frontRightCornerPositionY = this.getPositionY() + change_In_Y_Front_R_Corner;
	    	frontLeftCornerPositionX = this.getPositionX() + change_In_X_Front_L_Corner;
	    	frontLeftCornerPositionY = this.getPositionY() + change_In_Y_Front_L_Corner;
	    	rearRightCornerPositionX = this.getPositionX() + change_In_X_Rear_R_Corner;
	    	rearRightCornerPositionY = this.getPositionY() + change_In_Y_Rear_R_Corner;
	    	rearLeftCornerPositionX = this.getPositionX() + change_In_X_Rear_L_Corner;
	    	rearLeftCornerPositionY = this.getPositionY() + change_In_Y_Rear_L_Corner;
	    }
	    
	    
	public double getFrontRightCornerPositionX() {
			return frontRightCornerPositionX;
		}


		public void setFrontRightCornerPositionX(double frontRightCornerPositionX) {
			this.frontRightCornerPositionX = frontRightCornerPositionX;
		}


		public double getFrontRightCornerPositionY() {
			return frontRightCornerPositionY;
		}


		public void setFrontRightCornerPositionY(double frontRightCornerPositionY) {
			this.frontRightCornerPositionY = frontRightCornerPositionY;
		}


		public double getFrontLeftCornerPositionX() {
			return frontLeftCornerPositionX;
		}


		public void setFrontLeftCornerPositionX(double frontLeftCornerPositionX) {
			this.frontLeftCornerPositionX = frontLeftCornerPositionX;
		}


		public double getFrontLeftCornerPositionY() {
			return frontLeftCornerPositionY;
		}


		public void setFrontLeftCornerPositionY(double frontLeftCornerPositionY) {
			this.frontLeftCornerPositionY = frontLeftCornerPositionY;
		}


		public double getRearRightCornerPositionX() {
			return rearRightCornerPositionX;
		}


		public void setRearRightCornerPositionX(double rearRightCornerPositionX) {
			this.rearRightCornerPositionX = rearRightCornerPositionX;
		}


		public double getRearRightCornerPositionY() {
			return rearRightCornerPositionY;
		}


		public void setRearRightCornerPositionY(double rearRightCornerPositionY) {
			this.rearRightCornerPositionY = rearRightCornerPositionY;
		}


		public double getRearLeftCornerPositionX() {
			return rearLeftCornerPositionX;
		}


		public void setRearLeftCornerPositionX(double rearLeftCornerPositionX) {
			this.rearLeftCornerPositionX = rearLeftCornerPositionX;
		}


		public double getRearLeftCornerPositionY() {
			return rearLeftCornerPositionY;
		}


		public void setRearLeftCornerPositionY(double rearLeftCornerPositionY) {
			this.rearLeftCornerPositionY = rearLeftCornerPositionY;
		}


		public double getFront_R_Corner_Angle() {
			return front_R_Corner_Angle;
		}


		public void setFront_R_Corner_Angle(double front_R_Corner_Angle) {
			this.front_R_Corner_Angle = front_R_Corner_Angle;
		}


		public double getFront_L_Corner_Angle() {
			return front_L_Corner_Angle;
		}


		public void setFront_L_Corner_Angle(double front_L_Corner_Angle) {
			this.front_L_Corner_Angle = front_L_Corner_Angle;
		}

		
		/*
		public ObservableList<Car> getTargetObservaleListOfCars(CircleRpCar.OnWhichLane TargetLane){         
			return this.getHashMap_For_Observablelist().get(TargetLane);
		}
		*/
		/**
		 * Updates the front and rear car references. This method is called frequently, 
		 * so setOnWhichLaneEnum() is called here as a tag-along — it has no effect on 
		 * the getObservableListCarIsOn() result at this stage.
		 *
		 * Note:
		 * - getObservableListCarIsOn() depends on `onWhichLaneListKey`, which is not 
		 *   updated until a lane change or turn (left/right) is completed and the car 
		 *   is officially added to the target lane list.
		 *
		 * - setOnWhichLaneListKey(getOnWhichLane()) must be handled separately once 
		 *   lane change or a turn (left/right) is finalized.
		 *
		 * The onWhichLaneListKey resets the nearest car distances based on current car skin size and 
		 * heading direction.
		 */
		public void needToDoThisEverytimeSetFrontCarAndRearCar() {
			this.setOnWhichLaneEnum();
		    
			
			this.setCustomCarLengthBaseOnCarSkin();
		    this.nearest_Front_Car_Base_On_DistanceHeadingRightX = MAX_X_DISTANCE_BETWEEN_CARS;
			this.nearest_Front_Car_Base_On_DistanceHeadingLeftX = MAX_X_DISTANCE_BETWEEN_CARS;
			this.nearest_Front_Car_Base_On_DistanceHeadingUpY = MAX_Y_DISTANCE_BETWEEN_CARS;
			this.nearest_Front_Car_Base_On_DistanceHeadingDownY = MAX_Y_DISTANCE_BETWEEN_CARS;
			
			this.nearest_Rear_Car_Base_On_DistanceHeadingRightX = MAX_X_DISTANCE_BETWEEN_CARS;
			this.nearest_Rear_Car_Base_On_DistanceHeadingLeftX = MAX_X_DISTANCE_BETWEEN_CARS;
			this.nearest_Rear_Car_Base_On_DistanceHeadingUpY = MAX_Y_DISTANCE_BETWEEN_CARS;
			this.nearest_Rear_Car_Base_On_DistanceHeadingDownY = MAX_Y_DISTANCE_BETWEEN_CARS;
		    
		    this.setFrontCarAndRearCar(this.getObservableListCarIsOn());
		}
	 //************************************************************************************************************************************************
		//Do Target Lane Later 12:16AM 2025-05-20
	 //************************************************************************************************************************************************
		//---------------------------------------------------------------------------------------------------------------------
		/**
		 * The reason there is a switch statement in there is because it need to align this.onWhichLaneListKey with the method to set the front car and the rear car depending on the direction such as Heading Up...or Left etc
		 * @param theListOfTheLaneTheCarIsOn --> The Only Argument That  that should be passed into this parameter is "this.hashMap_For_Observablelist.get(onWhichLaneListKey)" because the value will align with 
		 * 								         the this.onWhichLaneListKey which is part of the OnWhichLane enum
		 */
		public void setFrontCarAndRearCar(ObservableList<IntersectionSimCar> theListOfTheLaneTheCarIsOn){//Class Specific
		
		
			
		    setFrontCar(null);
		    setRearCar (null);
			if(theListOfTheLaneTheCarIsOn.size() > 0 ) {
				
					switch (this.getOnWhichLaneListKey()) {
					case OnWhichLane.HEADING_LEFT_ON_RIGHT_LANE_LIST:
						setFrontCarRearCarHeadingLeft(theListOfTheLaneTheCarIsOn);
					   
						break;
					case OnWhichLane.HEADING_LEFT_ON_LEFT_LANE_LIST:
						setFrontCarRearCarHeadingLeft(theListOfTheLaneTheCarIsOn);
						break;
					case OnWhichLane.HEADING_LEFT_IN_LEFTTURNBOX_LIST:
						setFrontCarRearCarHeadingLeft(theListOfTheLaneTheCarIsOn);
						break;
					case OnWhichLane.HEADING_RIGHT_ON_RIGHT_LANE_LIST:
						setFrontCarRearCarHeadingRight(theListOfTheLaneTheCarIsOn);
						break;
					case OnWhichLane.HEADING_RIGHT_ON_LEFT_LANE_LIST:
						setFrontCarRearCarHeadingRight(theListOfTheLaneTheCarIsOn);
						break;
						
					case OnWhichLane.HEADING_RIGHT_IN_LEFTTURNBOX_LIST:
						setFrontCarRearCarHeadingRight(theListOfTheLaneTheCarIsOn);
						break;
					case OnWhichLane.HEADING_UP_ON_RIGHT_LANE_LIST:
						setFrontCarRearCarHeadingUp(theListOfTheLaneTheCarIsOn);
						break;
					case OnWhichLane.HEADING_UP_ON_LEFT_LANE_LIST:
						setFrontCarRearCarHeadingUp(theListOfTheLaneTheCarIsOn);
						break;
					case OnWhichLane.HEADING_UP_IN_LEFTTURNBOX_LIST:
						setFrontCarRearCarHeadingUp(theListOfTheLaneTheCarIsOn);
						break;
					case OnWhichLane.HEADING_DOWN_ON_RIGHT_LANE_LIST:
						setFrontCarRearCarHeadingDown(theListOfTheLaneTheCarIsOn);
						
						break;
					case OnWhichLane.HEADING_DOWN_ON_LEFT_LANE_LIST:
						setFrontCarRearCarHeadingDown(theListOfTheLaneTheCarIsOn);
						break;
					case OnWhichLane.HEADING_DOWN_IN_LEFTTURNBOX_LIST:
						setFrontCarRearCarHeadingDown(theListOfTheLaneTheCarIsOn);
						break;
					default:
						
						break;
						
					
				}
			}
			
		}
		
		public void setFrontCarRearCarHeadingLeft(ObservableList<IntersectionSimCar> theListOfTheLaneTheCarIsOn) {
			nearest_Front_Car_Base_On_DistanceHeadingLeftX = MAX_X_DISTANCE_BETWEEN_CARS;
			nearest_Rear_Car_Base_On_DistanceHeadingRightX = MAX_X_DISTANCE_BETWEEN_CARS;
			double temp_Front_DistanceX;
			double temp_Rear_DistanceX;
			for(IntersectionSimCar car : theListOfTheLaneTheCarIsOn) {
				if(this == car) {
					continue;
				}else {
					if (((IntersectionSimCar)this).getFrontLeftCornerPositionX() > ((IntersectionSimCar)car).getRearLeftCornerPositionX()) {
				
						temp_Front_DistanceX = Math.abs(this.getFrontLeftCornerPositionX() - ((IntersectionSimCar)car).getRearLeftCornerPositionX());
						if(temp_Front_DistanceX < nearest_Front_Car_Base_On_DistanceHeadingLeftX) {
							nearest_Front_Car_Base_On_DistanceHeadingLeftX = temp_Front_DistanceX;
							setFrontCar(((IntersectionSimCar)car));
						}
					}
					if (((IntersectionSimCar)this).getRearLeftCornerPositionX() < car.getFrontLeftCornerPositionX()) {
						temp_Rear_DistanceX = Math.abs(this.getRearLeftCornerPositionX() - ((IntersectionSimCar)car).getFrontLeftCornerPositionX());
						if(temp_Rear_DistanceX < nearest_Rear_Car_Base_On_DistanceHeadingLeftX) {
							nearest_Rear_Car_Base_On_DistanceHeadingLeftX = temp_Rear_DistanceX;
							setRearCar(((IntersectionSimCar)car));
						}
					
					}
				}
				
				
			}
			
		}
		
		public void setFrontCarRearCarHeadingRight(ObservableList<IntersectionSimCar> theListOfTheLaneTheCarIsOn) {
			nearest_Front_Car_Base_On_DistanceHeadingRightX = MAX_X_DISTANCE_BETWEEN_CARS;
			nearest_Rear_Car_Base_On_DistanceHeadingRightX = MAX_X_DISTANCE_BETWEEN_CARS;
			double temp_Front_DistanceX;
			double temp_Rear_DistanceX;
			for(IntersectionSimCar car : theListOfTheLaneTheCarIsOn) {
				if(this == car) {
					continue;
				}else  {
					if (((IntersectionSimCar)this).getFrontRightCornerPositionX() < ((IntersectionSimCar)car).getRearRightCornerPositionX()) {
						temp_Front_DistanceX = Math.abs(this.getFrontRightCornerPositionX() - ((IntersectionSimCar)car).getRearRightCornerPositionX());
						if(temp_Front_DistanceX < nearest_Front_Car_Base_On_DistanceHeadingRightX) {
							nearest_Front_Car_Base_On_DistanceHeadingRightX = temp_Front_DistanceX;
							setFrontCar(((IntersectionSimCar)car));
						}
					}
					if (((IntersectionSimCar)this).getRearLeftCornerPositionX() > ((IntersectionSimCar)car).getFrontLeftCornerPositionX()) {
						temp_Rear_DistanceX = Math.abs(this.getRearLeftCornerPositionX() - ((IntersectionSimCar)car).getFrontLeftCornerPositionX());
						if(temp_Rear_DistanceX < nearest_Rear_Car_Base_On_DistanceHeadingLeftX) {
							nearest_Rear_Car_Base_On_DistanceHeadingRightX = temp_Rear_DistanceX;
							setRearCar(((IntersectionSimCar)car));
						}
					}
				}
				
				
			}
			
		}
		
		public void setFrontCarRearCarHeadingUp(ObservableList<IntersectionSimCar> theListOfTheLaneTheCarIsOn) {
			nearest_Front_Car_Base_On_DistanceHeadingUpY = MAX_Y_DISTANCE_BETWEEN_CARS;
			nearest_Rear_Car_Base_On_DistanceHeadingUpY = MAX_Y_DISTANCE_BETWEEN_CARS;
			double temp_Front_DistanceY;
			double temp_Rear_DistanceY;
			for(IntersectionSimCar car : theListOfTheLaneTheCarIsOn) {
				if(this == car) {
					continue;
				}else {
					 if (this.getFrontRightCornerPositionY() > car.getRearRightCornerPositionY()) {
							temp_Front_DistanceY = Math.abs(this.getFrontRightCornerPositionY() - car.getRearRightCornerPositionY());
							if(temp_Front_DistanceY < nearest_Front_Car_Base_On_DistanceHeadingUpY) {
								nearest_Front_Car_Base_On_DistanceHeadingUpY = temp_Front_DistanceY;
								setFrontCar(((IntersectionSimCar)car));
							}
					 }
					 if (this.getRearRightCornerPositionY() < car.getFrontRightCornerPositionY()) {
							temp_Rear_DistanceY = Math.abs(this.getRearRightCornerPositionY() - car.getFrontRightCornerPositionY());
							if(temp_Rear_DistanceY < nearest_Rear_Car_Base_On_DistanceHeadingUpY) {
								nearest_Rear_Car_Base_On_DistanceHeadingUpY = temp_Rear_DistanceY;
								setRearCar(((IntersectionSimCar)car));
							}
					 }
				
				}
				
				
			}
			
			
		}
		
		public void setFrontCarRearCarHeadingDown(ObservableList<IntersectionSimCar> theListOfTheLaneTheCarIsOn) {
			nearest_Front_Car_Base_On_DistanceHeadingDownY = MAX_Y_DISTANCE_BETWEEN_CARS;
			nearest_Rear_Car_Base_On_DistanceHeadingDownY = MAX_Y_DISTANCE_BETWEEN_CARS;
			double temp_Front_DistanceY;
			double temp_Rear_DistanceY;
			//System.out.println("\n --->this: " + this.getCarSkin() + "getObservablelistCarisOn(): " + this.getObservableListCarIsOn());
			for(IntersectionSimCar car : theListOfTheLaneTheCarIsOn) {
				if(this == car) {
					continue;
				}else {
					if (this.getFrontLeftCornerPositionY() < car.getRearLeftCornerPositionY()) {
				       // System.out.println("setFrontCarRearCarHeadingDown: setFrontCar(...) if statement true");
						temp_Front_DistanceY = Math.abs(this.getFrontLeftCornerPositionY() - car.getRearLeftCornerPositionY());
						if(temp_Front_DistanceY < nearest_Front_Car_Base_On_DistanceHeadingDownY) {
							nearest_Front_Car_Base_On_DistanceHeadingDownY = temp_Front_DistanceY;
							setFrontCar(((IntersectionSimCar)car));
							
						}
					}
					if (this.getRearLeftCornerPositionY() > car.getFrontLeftCornerPositionY()) {
						//System.out.println("setFrontCarRearCarHeadingDown: setRearCar(...) if statement true");
						temp_Rear_DistanceY = Math.abs(((IntersectionSimCar)this).getRearLeftCornerPositionY() - car.getFrontLeftCornerPositionY());
						if(temp_Rear_DistanceY < nearest_Rear_Car_Base_On_DistanceHeadingDownY) {
							nearest_Rear_Car_Base_On_DistanceHeadingDownY = temp_Rear_DistanceY;
							setRearCar(((IntersectionSimCar)car));
							
						}
					}
					
				}
				
				
			}
			
		}
	    
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		public void positionBlinkersImageView(double imageViewAngle, ImageView front_R_BlinkerImageView, ImageView front_L_BlinkerImageView, ImageView rear_R_BlinkerImageView, ImageView rear_L_BlinkerImageView) {
		
			double frontRBlinkerX = this.getFrontRightBlinkerPositionX();
			double frontRBlinkerY = this.getFrontRightBlinkerPositionY();
			double frontLBlinkerX = this.getFrontLeftBlinkerPositionX();
			double frontLBlinkerY = this.getFrontLeftBlinkerPositionY();
			double rearRBlinkerX = this.getRearRightBlinkerPositionX();
			double rearRBlinkerY = this.getRearRightBlinkerPositionY();
			double rearLBlinkerX = this.getRearLeftBlinkerPositionX();
			double rearLBlinkerY = this.getRearLeftBlinkerPositionY();
			
			double calculatedLayoutPointForCenterFrontRBlinkerX =  frontRBlinkerX - front_R_BlinkerImageView.getFitWidth()/2;
			double calculatedLayoutPointForCenterFrontRBlinkerY = frontRBlinkerY - front_R_BlinkerImageView.getFitHeight()/2;
			double calculatedLayoutPointForCenterFrontLBlinkerX =  frontLBlinkerX - front_L_BlinkerImageView.getFitWidth()/2;
			double calculatedLayoutPointForCenterFrontLBlinkerY = frontLBlinkerY - front_L_BlinkerImageView.getFitHeight()/2;
			double calculatedLayoutPointForCenterRearRBlinkerX = rearRBlinkerX - rear_R_BlinkerImageView.getFitWidth()/2;
			double calculatedLayoutPointForCenterRearRBlinkerY = rearRBlinkerY - rear_R_BlinkerImageView.getFitHeight()/2;
			double calculatedLayoutPointForCenterRearLBlinkerX = rearLBlinkerX - rear_L_BlinkerImageView.getFitWidth()/2;
			double calculatedLayoutPointForCenterRearLBlinkerY = rearLBlinkerY - rear_L_BlinkerImageView.getFitHeight()/2;
			
			front_R_BlinkerImageView.setLayoutX(frontRBlinkerX);
			front_R_BlinkerImageView.setLayoutY(frontRBlinkerY);
			front_L_BlinkerImageView.setLayoutX(frontLBlinkerX);
			front_L_BlinkerImageView.setLayoutY(frontLBlinkerY);
			
			rear_R_BlinkerImageView.setLayoutX(rearRBlinkerX);
			rear_R_BlinkerImageView.setLayoutY(rearRBlinkerY);
			rear_L_BlinkerImageView.setLayoutX(rearLBlinkerX);
			rear_L_BlinkerImageView.setLayoutY(rearLBlinkerY);
			
			//Calculate the Transition To move the pivot point to (0,0)
			Translate translateToPivotFR = new Translate(-frontRBlinkerX, -frontRBlinkerY);
			Translate translateToPivotFL = new Translate(-frontLBlinkerX, -frontLBlinkerY);
			Translate translateToPivotRR = new Translate(-rearRBlinkerX, -rearRBlinkerY);
			Translate translateToPivotRL = new Translate(-rearLBlinkerX, -rearLBlinkerY);
			
			//Rotate around the center of the ImageView, and now align with the desired blinker coordinate
			Rotate rotateFR = new Rotate (imageViewAngle, frontRBlinkerX, frontRBlinkerY);
			Rotate rotateFL = new Rotate (imageViewAngle, frontLBlinkerX, frontLBlinkerY);
			Rotate rotateRR = new Rotate (imageViewAngle, rearRBlinkerX, rearRBlinkerY);
			Rotate rotateRL = new Rotate (imageViewAngle, rearLBlinkerX, rearLBlinkerY);
			
			//Translate the ImageView back to its original position
			Translate backToPositionFR = new Translate(calculatedLayoutPointForCenterFrontRBlinkerX, calculatedLayoutPointForCenterFrontRBlinkerY);
			Translate backToPositionFL = new Translate(calculatedLayoutPointForCenterFrontLBlinkerX, calculatedLayoutPointForCenterFrontLBlinkerY);
			Translate backToPositionRR = new Translate(calculatedLayoutPointForCenterRearRBlinkerX, calculatedLayoutPointForCenterRearRBlinkerY);
			Translate backToPositionRL = new Translate(calculatedLayoutPointForCenterRearLBlinkerX, calculatedLayoutPointForCenterRearLBlinkerY);
			
			front_R_BlinkerImageView.getTransforms().clear();// you need to clear it so the angle return back to its original position because the previous angle matters
			front_L_BlinkerImageView.getTransforms().clear();
			rear_R_BlinkerImageView.getTransforms().clear();
			rear_L_BlinkerImageView.getTransforms().clear();
			
			front_R_BlinkerImageView.getTransforms().addAll(translateToPivotFR, rotateFR, backToPositionFR);
			front_L_BlinkerImageView.getTransforms().addAll(translateToPivotFL, rotateFL, backToPositionFL);
			rear_R_BlinkerImageView.getTransforms().addAll(translateToPivotRR, rotateRR, backToPositionRR);
			rear_L_BlinkerImageView.getTransforms().addAll(translateToPivotRL, rotateRL, backToPositionRL);
		
		
		}
//**************************************************************************************************************************************************************************************************************
		//Other Blinkers Animation Stuff

	private void blinkersBlink() {
	
		blinkersCounter++;
		if (blinkersCounter >= 0 && blinkersCounter <20) {
			setBlinkersVisible(blinkersSet1, true);
		    setBlinkersVisible(blinkersSet2, false);
		    setBlinkersVisible(blinkersSet3, false);
		}else if (blinkersCounter >=20 && blinkersCounter <30) {
			setBlinkersVisible(blinkersSet1, false);
		    setBlinkersVisible(blinkersSet2, true);
		    setBlinkersVisible(blinkersSet3, false);
		}else if (blinkersCounter >= 30 && blinkersCounter <=40) {
			setBlinkersVisible(blinkersSet1, false);
		    setBlinkersVisible(blinkersSet2, false);
		    setBlinkersVisible(blinkersSet3, true);
			blinkersCounter=0;
		}
	}
    
	private void rightBlinkersBlink() {
		blinkersCounter++;
		if (blinkersCounter >= 0 && blinkersCounter <20) {
			setBlinkersVisible(rightBlinkersSet, true);
		    setBlinkersVisible(rightBlinkersSet2, false);
		    setBlinkersVisible(rightBlinkersSet3, false);
		}else if (blinkersCounter >=20 && blinkersCounter <30) {
			setBlinkersVisible(rightBlinkersSet, false);
		    setBlinkersVisible(rightBlinkersSet2, true);
		    setBlinkersVisible(rightBlinkersSet3, false);
		}else if (blinkersCounter >= 30 && blinkersCounter <=40) {
			setBlinkersVisible(rightBlinkersSet, false);
		    setBlinkersVisible(rightBlinkersSet2, false);
		    setBlinkersVisible(rightBlinkersSet3, true);
			blinkersCounter=0;
		}
	}
	
	
	public void rightBlinkersOff(){
		setBlinkersVisible(rightBlinkersSet, true);
	    setBlinkersVisible(rightBlinkersSet2, false);
	    setBlinkersVisible(rightBlinkersSet3, false);
	}
	
	private void rightBlinkersOnOffBasedOnToggleState() {
		switch (rightBlinkersToggle) {
		case RightBlinkersToggle.ON:
			rightBlinkersBlink();
			break;
			
		case RightBlinkersToggle.OFF:
			rightBlinkersOff();
			break;
		}
	}
	
	private void leftBlinkersBlink() {
		blinkersCounter++;
		if (blinkersCounter >= 0 && blinkersCounter <20) {
			setBlinkersVisible(leftBlinkersSet, true);
		    setBlinkersVisible(leftBlinkersSet2, false);
		    setBlinkersVisible(leftBlinkersSet3, false);
		}else if (blinkersCounter >=20 && blinkersCounter <30) {
			setBlinkersVisible(leftBlinkersSet, false);
		    setBlinkersVisible(leftBlinkersSet2, true);
		    setBlinkersVisible(leftBlinkersSet3, false);
		}else if (blinkersCounter >= 30 && blinkersCounter <=40) {
			setBlinkersVisible(leftBlinkersSet, false);
		    setBlinkersVisible(leftBlinkersSet2, false);
		    setBlinkersVisible(leftBlinkersSet3, true);
			blinkersCounter=0;
		}
	}
	
	private void leftBlinkersOnOffBasedOnToggleState() {
		switch (leftBlinkersToggle) {
		case LeftBlinkersToggle.ON:
			leftBlinkersBlink();
			break;
			
		case LeftBlinkersToggle.OFF:
			leftBlinkersOff();
			break;
		}
	}
	public void leftBlinkersOff() {
		setBlinkersVisible(leftBlinkersSet, true);
	    setBlinkersVisible(leftBlinkersSet2, false);
	    setBlinkersVisible(leftBlinkersSet3, false);
	}
	private void setBlinkersVisible(ImageView[] blinkers, boolean visible) {
		for (ImageView blinker: blinkers) {
			blinker.setVisible(visible);    	
		}
	}
     //Other Blinkers Animation Stuff Ends
	//****************************************************************************************************************************************************************************************************************
	/**
	 * needed for Initialization to be put in the constructor of HeadedDownOrigCar
	 * @param carSkinConfig --needed to get car skin information
	 */
	public void setBlinkerLengthAndAngleAlsoCarImageViewWidth (CarSkinConfig carSkinConfig) {
		angle_Diff_Front_Blinkers = carSkinConfig.getFront_Blinker_Angle_Diff();
		angle_Diff_Rear_Blinkers = carSkinConfig.getRear_Blinker_Angle_Diff();
		length_For_Front_Blinkers = carSkinConfig.getFront_Blinker_Distance();
		length_For_Rear_Blinkers = carSkinConfig.getRear_Blinker_Distance();
		
		angle_Diff_Front_Corners = carSkinConfig.getFront_Corner_Angle_Diff();
		angle_Diff_Rear_Corners = carSkinConfig.getRear_Corner_Angle_Diff();
		length_For_Front_Corners = carSkinConfig.getFront_Corner_Distance();
		length_For_Rear_Corners = carSkinConfig.getRear_Corner_Distance();
		this.carImageView_P.setFitWidth(carSkinConfig.getImage_Width());
		this.carImageView_brake_P.setFitWidth(carSkinConfig.getImage_Width());
	}
    //*****************************************************************************************************************************************************************************************************************
	@Override
	public ObservableList<IntersectionSimCar> getObservableListCarIsOn(){
		return this.laneManagement.getHashMap_For_Observablelist().get(this.getOnWhichLaneListKey());
	}

	@Override
	public void deleteCircleRpCorner(Pane root) {
	     
	    for (int i = 0; i < carCornerCircle.length; i++) {
	    	Circle circle = carCornerCircle[i];
	    	
	    	if(circle != null ) {//Before getCenterX()/ getCenterY() always check
	    		root.getChildren().remove(circle);
	    		
	    		boolean isCircleDeleted = !root.getChildren().contains(circle);
	    		if(isCircleDeleted) {
	    			//System.out.println("Circle deleted");
	    		}else {
	    			//System.out.println("Circle not deleted");
	    		}
	    		carCornerCircle[i] = null;
	    	}
	    }
	    
	}



	public Image getCarImage_brake_P() {
		return carImage_brake_P;
	}



	public void setCarImage_brake_P(Image carImage_brake_P) {
		this.carImage_brake_P = carImage_brake_P;
	}



	public ImageView getCarImageView_brake_P() {
		return carImageView_brake_P;
	}



	public void setCarImageView_brake_P(ImageView carImageView_brake_P) {
		this.carImageView_brake_P = carImageView_brake_P;
	}



	public Image getFront_R_BlinkerImage_P() {
		return front_R_BlinkerImage_P;
	}



	public void setFront_R_BlinkerImage_P(Image front_R_BlinkerImage_P) {
		this.front_R_BlinkerImage_P = front_R_BlinkerImage_P;
	}



	public Image getFront_L_BlinkerImage_P() {
		return front_L_BlinkerImage_P;
	}



	public void setFront_L_BlinkerImage_P(Image front_L_BlinkerImage_P) {
		this.front_L_BlinkerImage_P = front_L_BlinkerImage_P;
	}



	public Image getRear_R_BlinkerImage_P() {
		return rear_R_BlinkerImage_P;
	}



	public void setRear_R_BlinkerImage_P(Image rear_R_BlinkerImage_P) {
		this.rear_R_BlinkerImage_P = rear_R_BlinkerImage_P;
	}



	public Image getRear_L_BlinkerImage_P() {
		return rear_L_BlinkerImage_P;
	}



	public void setRear_L_BlinkerImage_P(Image rear_L_BlinkerImage_P) {
		this.rear_L_BlinkerImage_P = rear_L_BlinkerImage_P;
	}



	public ImageView getFront_R_BlinkerImageView_P() {
		return front_R_BlinkerImageView_P;
	}



	public void setFront_R_BlinkerImageView_P(ImageView front_R_BlinkerImageView_P) {
		this.front_R_BlinkerImageView_P = front_R_BlinkerImageView_P;
	}



	public ImageView getFront_L_BlinkerImageView_P() {
		return front_L_BlinkerImageView_P;
	}



	public void setFront_L_BlinkerImageView_P(ImageView front_L_BlinkerImageView_P) {
		this.front_L_BlinkerImageView_P = front_L_BlinkerImageView_P;
	}



	public ImageView getRear_R_BlinkerImageView_P() {
		return rear_R_BlinkerImageView_P;
	}



	public void setRear_R_BlinkerImageView_P(ImageView rear_R_BlinkerImageView_P) {
		this.rear_R_BlinkerImageView_P = rear_R_BlinkerImageView_P;
	}



	public ImageView getRear_L_BlinkerImageView_P() {
		return rear_L_BlinkerImageView_P;
	}



	public void setRear_L_BlinkerImageView_P(ImageView rear_L_BlinkerImageView_P) {
		this.rear_L_BlinkerImageView_P = rear_L_BlinkerImageView_P;
	}



	public Image getFront_R_BlinkerImage2_P() {
		return front_R_BlinkerImage2_P;
	}



	public void setFront_R_BlinkerImage2_P(Image front_R_BlinkerImage2_P) {
		this.front_R_BlinkerImage2_P = front_R_BlinkerImage2_P;
	}



	public Image getFront_L_BlinkerImage2_P() {
		return front_L_BlinkerImage2_P;
	}



	public void setFront_L_BlinkerImage2_P(Image front_L_BlinkerImage2_P) {
		this.front_L_BlinkerImage2_P = front_L_BlinkerImage2_P;
	}



	public Image getRear_R_BlinkerImage2_P() {
		return rear_R_BlinkerImage2_P;
	}



	public void setRear_R_BlinkerImage2_P(Image rear_R_BlinkerImage2_P) {
		this.rear_R_BlinkerImage2_P = rear_R_BlinkerImage2_P;
	}



	public Image getRear_L_BlinkerImage2_P() {
		return rear_L_BlinkerImage2_P;
	}



	public void setRear_L_BlinkerImage2_P(Image rear_L_BlinkerImage2_P) {
		this.rear_L_BlinkerImage2_P = rear_L_BlinkerImage2_P;
	}



	public ImageView getFront_R_BlinkerImageView2_P() {
		return front_R_BlinkerImageView2_P;
	}



	public void setFront_R_BlinkerImageView2_P(ImageView front_R_BlinkerImageView2_P) {
		this.front_R_BlinkerImageView2_P = front_R_BlinkerImageView2_P;
	}



	public ImageView getFront_L_BlinkerImageView2_P() {
		return front_L_BlinkerImageView2_P;
	}



	public void setFront_L_BlinkerImageView2_P(ImageView front_L_BlinkerImageView2_P) {
		this.front_L_BlinkerImageView2_P = front_L_BlinkerImageView2_P;
	}



	public ImageView getRear_R_BlinkerImageView2_P() {
		return rear_R_BlinkerImageView2_P;
	}



	public void setRear_R_BlinkerImageView2_P(ImageView rear_R_BlinkerImageView2_P) {
		this.rear_R_BlinkerImageView2_P = rear_R_BlinkerImageView2_P;
	}



	public ImageView getRear_L_BlinkerImageView2_P() {
		return rear_L_BlinkerImageView2_P;
	}



	public void setRear_L_BlinkerImageView2_P(ImageView rear_L_BlinkerImageView2_P) {
		this.rear_L_BlinkerImageView2_P = rear_L_BlinkerImageView2_P;
	}



	public Image getFront_R_BlinkerImage3_P() {
		return front_R_BlinkerImage3_P;
	}



	public void setFront_R_BlinkerImage3_P(Image front_R_BlinkerImage3_P) {
		this.front_R_BlinkerImage3_P = front_R_BlinkerImage3_P;
	}



	public Image getFront_L_BlinkerImage3_P() {
		return front_L_BlinkerImage3_P;
	}



	public void setFront_L_BlinkerImage3_P(Image front_L_BlinkerImage3_P) {
		this.front_L_BlinkerImage3_P = front_L_BlinkerImage3_P;
	}



	public Image getRear_R_BlinkerImage3_P() {
		return rear_R_BlinkerImage3_P;
	}



	public void setRear_R_BlinkerImage3_P(Image rear_R_BlinkerImage3_P) {
		this.rear_R_BlinkerImage3_P = rear_R_BlinkerImage3_P;
	}



	public Image getRear_L_BlinkerImage3_P() {
		return rear_L_BlinkerImage3_P;
	}



	public void setRear_L_BlinkerImage3_P(Image rear_L_BlinkerImage3_P) {
		this.rear_L_BlinkerImage3_P = rear_L_BlinkerImage3_P;
	}



	public ImageView getFront_R_BlinkerImageView3_P() {
		return front_R_BlinkerImageView3_P;
	}



	public void setFront_R_BlinkerImageView3_P(ImageView front_R_BlinkerImageView3_P) {
		this.front_R_BlinkerImageView3_P = front_R_BlinkerImageView3_P;
	}



	public ImageView getFront_L_BlinkerImageView3_P() {
		return front_L_BlinkerImageView3_P;
	}



	public void setFront_L_BlinkerImageView3_P(ImageView front_L_BlinkerImageView3_P) {
		this.front_L_BlinkerImageView3_P = front_L_BlinkerImageView3_P;
	}



	public ImageView getRear_R_BlinkerImageView3_P() {
		return rear_R_BlinkerImageView3_P;
	}



	public void setRear_R_BlinkerImageView3_P(ImageView rear_R_BlinkerImageView3_P) {
		this.rear_R_BlinkerImageView3_P = rear_R_BlinkerImageView3_P;
	}



	public ImageView getRear_L_BlinkerImageView3_P() {
		return rear_L_BlinkerImageView3_P;
	}



	public void setRear_L_BlinkerImageView3_P(ImageView rear_L_BlinkerImageView3_P) {
		this.rear_L_BlinkerImageView3_P = rear_L_BlinkerImageView3_P;
	}



	public double getRear_R_Blinker_Angle() {
		return rear_R_Blinker_Angle;
	}



	public void setRear_R_Blinker_Angle(double rear_R_Blinker_Angle) {
		this.rear_R_Blinker_Angle = rear_R_Blinker_Angle;
	}
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 /**
     * This is supposed to be the brain function for now the selection of the lane Change X-Coordinate is randomized
     */
    public void laneChangePointYSelection() {
   	   Random random = new Random();
   		
   		
   		if (beforeInt_RightLaneChangePhase == LaneChangePhase.COMPLETED && carIntention == CarIntention.BI_ONLLWANTRLC && !yCoordinateSelected
   				|| beforeInt_RightLaneChangePhase == LaneChangePhase.NONE && carIntention == CarIntention.BI_ONLLWANTRLC && !yCoordinateSelected ){//tweak here
   			yCoordinate  = random.nextDouble(1100);
   			if(yCoordinate >= 0 && yCoordinate < 215 && yCoordinate > this.getPositionY())//tweak here
   			yCoordinateSelected = true;
   			//System.out.println("laneChangePointYSelection() accessed");
   		}else if (beforeInt_RightLaneChangePhase == LaneChangePhase.COMPLETED) {//tweak here
   			yCoordinateSelected = false;
   		}
    }
    
    public void bI_RightLaneChangePhaseIntention() {
   	 if(!lane_Change_Probabilities_accessed && this.generalPlacementOfCar == GeneralPlacementOfCar.BI_ONLEFTLANE 
   			 && carIntention == CarIntention.NONE  ) {//tweak here
   		 //System.out.println("CircleRpCar.java line: 872 accessed, isXCoordinateSelected: " + this.isxCoordinateSelected());
   	     laneChangeProbabilities = LaneChangeProbabilities.HIGH;
   	     laneChangeProbabilities.execute(this);
   	    //System.out.println("CircleRpCar.java line: 851 carID: "+this+ " CarIntention: " + carIntention);
   		//ToDo: should activate turn signal 
   	     lane_Change_Probabilities_accessed = true;
   	}
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    public void bI_RightLaneChangePhaseState() {//tweak here
    	//System.out.println("bI_RightLaneChangePhaseState()-->accessed, !laneChangePhase1-Initiated = " + laneChangePhase1_Initiated);
    	if (shouldBeginBI_RLC_Phase1()) {//tweak here
   		 
   			beforeInt_RightLaneChangePhase = LaneChangePhase.PHASE_1;//tweak here
   			//System.out.println("CircleRpCar.java line 893 accessed ---car ID: " +  this + " |Before intersection Phase: " + beforeInt_RightLaneChangePhase + " |  PositionX: " + positionX);
   			laneChangePhase1_Initiated = true;
   			
   			//System.out.println("bI_RightLaneChangePhaseState()-->shouldBeginBI_RLC_Phase1() -->accessed");
   		}else if(shouldBeginBI_RLC_Phase2()) {//tweak here
   	       System.out.println("bI_RightLaneChangePhaseState() carIntention: " + this.carIntention );
   	        beforeInt_RightLaneChangePhase = LaneChangePhase.PHASE_2;//tweak here
   		    this.phase2CalculationBI_RLC();//tweak here
   		   
   		    this.SetR_BiCancelRight_LaneChangeExitAngle();
   	        
   	        	
   	        
   		}else if(shouldBeginBI_RLC_Phase3()) {//tweak here
   			//System.out.println("CircleRpCar.java line 913: accessed");
   			beforeInt_RightLaneChangePhase = LaneChangePhase.PHASE_3;//tweak here
   		}else if(shouldBeginBI_RLC_PhaseCompleted()  ) {
   			
   		 beforeInt_RightLaneChangePhase = LaneChangePhase.COMPLETED;//tweak here
   		 carIntention = CarIntention.NONE;
   		 rightBlinkersToggle = RightBlinkersToggle.OFF;
   		 carAction = CarAction.GOSTRAIGHT;
   		 //System.out.println("bI_RightLaneChangePhaseState: Lane Change Completed: positionX = " + this.getPositionX() + " ");
   		 lane_Change_Probabilities_accessed = false;
   		 laneChangePhase1_Initiated = false;
   		}
    }
    
    
    /**
     * If carAction says (ALT_RIGHTLANECHANGE)--meaning after Left Turn (The car is  on the left lane and It wants to do a right lane change). 
     * laneChangePhase1_initiated has to be false because once phase1 is initiated it will not initiate phase 1 again until after the lane change is completed.
     * It is a boolean function for if it should begin phase 1 of the After Left Turn on left lane right lane change phases  
     * @return true or false
     */
    private boolean shouldBeginBI_RLC_Phase1() {//tweak here
   	 return carAction == CarAction.BI_RIGHTLANECHANGE && !laneChangePhase1_Initiated;//tweak here
    }
    
    /**
     * After phase 1 is initiated the car will start turning until it reaches the optimum angle (right Lane Change ExitAngle
     * A boolean function for if it should begin phase 2 of the After Left Turn on left lane right lane change phases  
     * @return true or false
     */
    private boolean shouldBeginBI_RLC_Phase2() {//tweak here
   	 return this.getRotationAngle() == HeadedDownOrigCar.R_BIRIGHT_LANE_CHANGEEXITANGLE && beforeInt_RightLaneChangePhase ==  LaneChangePhase.PHASE_1;//tweak here
    }
    

    /**
     * A boolean function for if it should begin phase 3 of the After Left Turn on left lane right lane change phases  
     * @return true or false
     */
    private boolean shouldBeginBI_RLC_Phase3() {//tweak here
   	 return this.getPositionX() == this.getStraightEndingX() && this.getPositionY() == this.getStraightEndingY() && beforeInt_RightLaneChangePhase == LaneChangePhase.PHASE_2;//tweak here
    }
    
    //The function Below is the condition for canceling (after left turn) right lane change
    /**
     * &&&--means need to work on it
     * For this now this function will always = true when rotationAngle is equal to the  R_ALTRIGHT_LANECHANGEEXITANGLE
     * @return true or false
     */

    private boolean shouldBICancelRightLaneChange() {//tweak here
   	 return (this.getRotationAngle() == 282);//tweak here
    }
    
    /**
     * A boolean function for if it should begin phase named completed of the After Left Turn on left lane right lane change phases
     * @return true or false
     */
    private boolean shouldBeginBI_RLC_PhaseCompleted() {//tweak here
   	 return this.getRotationAngle() == this.L_BIRIGHT_LANE_CHANGEEXITANGLE && beforeInt_RightLaneChangePhase == LaneChangePhase.PHASE_3;//tweak here
    }
    
    /**
     * After Left Turn on left lane right lane change calculation for phase2
     */
      private void phase2CalculationBI_RLC() {//tweak here
    	this.setAngleWithRespectToTheRightTurnCircle();
    	//System.out.println("angleWithRespectToTheRightTurnCircle = " + this.getAngleWithRespectToTheRightTurnCircle());
       	this.positionXSnapShot = this.getPositionX();
        this.positionYSnapShot = this.getPositionY();
   		this.setStraightStartingX(positionXSnapShot);
   		this.setStraightStartingY(positionYSnapShot);
   		
   		
   		double startingX = this.getStraightStartingX();
   		double startingY = this.getStraightStartingY();
   		double laneChangeRadius = this.getLanechangeradius();
   		double temp_AngleWithRespectToRightTurnCircle = Math.toRadians(this.angleWithRespectToTheRightTurnCircle);
   		this.setH(startingX - Math.cos(temp_AngleWithRespectToRightTurnCircle) * laneChangeRadius) ;//h is the x coordinate of the center of the right turn circle//tweak here
   		this.setK(startingY  - Math.sin(temp_AngleWithRespectToRightTurnCircle) * laneChangeRadius) ;//k is the y coordinate of the center of the right turn circle//tweak here
   		double temp_H = this.getH();//tweak here
   		//double temp_K = this.getK();//tweak here
   		double temp_StraightEndingX = startingX + (temp_H - startingX)*2;//tweak here
   		double temp_RotationAngle = angleNormalization(this.getRotationAngle());//tweak here
   		this.setRise(Math.sin(temp_RotationAngle));//* orY;//update rise of the slope
   		this.setRun(Math.cos(temp_RotationAngle));//* orX;//update run of the slope
           double temp_Rise = this.getRise();//tweak here
           double temp_Run = this.getRun();//tweak here
           this.setRiseOverRun(temp_Rise/temp_Run);//tweak here
           this.setRunOverRise(temp_Run/temp_Rise);//tweak here
           //double temp_RiseOverRun = this.getRiseOverRun();
           double temp_RiseOverRun = this.getRiseOverRun();//tweak here
           double temp_StraightEndingY = temp_RiseOverRun * (temp_StraightEndingX - startingX) + startingY;//tweak here
   		this.setStraightEndingX(temp_StraightEndingX);
   		this.setStraightEndingY(temp_StraightEndingY);
       }
   	
     

	/**
   	 * This function makes the car perform the action
   	 */
       public void bI_RightLaneChange() {//tweak here
    	   
    	   switch(beforeInt_RightLaneChangePhase) {
    	   case LaneChangePhase.PHASE_1:
    		   //System.out.println("BI_RightLaneChange() --> phase 1: accessed");
    	   		 
      			this.rightTurn(HeadedDownOrigCar.R_BIRIGHT_LANE_CHANGEEXITANGLE, 19.5);
      			break;
    	   case LaneChangePhase.PHASE_2:
    		    //System.out.println("bI_RightLaneChange() :" + this.getR_BiCancelRight_LaneChangeExitAngle());
	        	//bI_CancelRightLaneChangePhaseState(); ///DONE AWAY WITH CANCEL LANE CHANGE FOR NOW
	        
	  			//System.out.println("bI_RightLaneChang--> Phase2");
	  			double temp_StraightEndingX = this.getStraightEndingX();
	  			double temp_StraightEndingY = this.getStraightEndingY();
	  			this.positionManipulationFormula(this.getxCoordinate(),this.getyCoordinate(), temp_StraightEndingX, temp_StraightEndingY);
	  			this.gasGoStraight();
	  			break;
    	   case LaneChangePhase.PHASE_3:
    		   this.leftTurn(HeadedDownOrigCar.L_BIRIGHT_LANE_CHANGEEXITANGLE, 19.5);
    		   break;
		default:
			break;
    	  }
       	/*if(beforeInt_RightLaneChangePhase == LaneChangePhase.PHASE_1) {//tweak here
   		    //System.out.println("BI_RightLaneChange() --> phase 1: accessed");
   		 
   			this.rightTurn(CircleRpCar.getrBiRightLaneChangeExitAngle(), 19.5);
   		}else if(beforeInt_RightLaneChangePhase == LaneChangePhase.PHASE_2) {//tweak here
   			
		
				//System.out.println("bI_RightLaneChangePhaseState() :" + this.getR_BiCancelRight_LaneChangeExitAngle());
	        	bI_CancelRightLaneChangePhaseState();
	        
   			//System.out.println("bI_RightLaneChang--> Phase2");
   			double temp_StraightEndingX = this.getStraightEndingX();
   			double temp_StraightEndingY = this.getStraightEndingY();
   			this.positionManipulationFormula(this.getxCoordinate(),this.getyCoordinate(), temp_StraightEndingX, temp_StraightEndingY);
   			this.gasGoStraight();
   		}else if (beforeInt_RightLaneChangePhase == LaneChangePhase.PHASE_3) {//tweak here
   		  
   			this.leftTurn(CircleRpCar.getlBiRightLaneChangeExitAngle(), 19.5);//tweak here
   		  ///System.out.println("BI_RightLaneChange()--> phase 3: accessed, positionX: " + this.positionX + " " );
   			
   		}*/
       }
       public void bI_CancelRightLaneChangePhaseState() {
       	if (shouldBICancelRightLaneChange()) {
       		//System.out.println("bI_CancelRightLaneChangePhaseState : accessed and beforeInt_RightLaneChangePhase set to CancelLaneChange Phase_1");
       		
           	beforeInt_CancelRightLaneChangePhase = CancelLaneChangePhase.PHASE_1;
           	//System.out.println("Car ID: " + this + ", beforeInt_CancelRightLaneChangePhase = " + this.beforeInt_CancelRightLaneChangePhase);
           	beforeInt_RightLaneChangePhase = LaneChangePhase.NONE;
           	carAction = CarAction.BI_CANCELRIGHTLANECHANGE;
         	//System.out.println("rotationAngle: "+ this.getRotationAngle());
           }else if (rotationAngle == this.getR_BiCancelRight_LaneChangeExitAngle() && beforeInt_CancelRightLaneChangePhase == CancelLaneChangePhase.PHASE_1 ) { 
        	   //System.out.println("bI_CancelRightLaneChangePhaseState : accessed and beforeInt_RightLaneChangePhase set to CancelLaneChange Phase_2");
        	beforeInt_CancelRightLaneChangePhase = CancelLaneChangePhase.PHASE_2;
           }else if(rotationAngle == 270 && BeforeIn_CancelRightLaneChangePhase == CancelLaneChangePhase.PHASE_2){
        	beforeInt_CancelRightLaneChangePhase = CancelLaneChangePhase.COMPLETED;
           }else if (BeforeIn_CancelRightLaneChangePhase == CancelLaneChangePhase.COMPLETED){
        	beforeInt_CancelRightLaneChangePhase = CancelLaneChangePhase.NONE;
           	 carIntention = CarIntention.NONE;
       		
       		 carAction = CarAction.GOSTRAIGHT;
       		 lane_Change_Probabilities_accessed = false;
       		 laneChangePhase1_Initiated = false;
           //	System.out.println("BI_CancelRightLaneChangePhaseState(): accessed");
           }
       	   //System.out.println("Car ID: " + this + ", beforeInt_CancelRightLaneChangePhase = " + this.beforeInt_CancelRightLaneChangePhase);
       	 //System.out.println("bI_CancelRightLaneChangePhaseState() accessed Car ID: "+ this + " carAction: " + carAction);
       }
       
     


	public void bI_CancelRightLaneChange(){
       	if(beforeInt_CancelRightLaneChangePhase == CancelLaneChangePhase.PHASE_1) {//tweak here
       		//System.out.print("BI_CancelRightLaneChange() accessed---->r_BiCancelRight_LaneChangeExitAngle :" + this.getR_BiCancelRight_LaneChangeExitAngle());
       		this.leftTurn(this.getR_BiCancelRight_LaneChangeExitAngle(), 250);
       		
       	}else if(beforeInt_CancelRightLaneChangePhase == CancelLaneChangePhase.PHASE_2) {//tweak here
       		
       		this.rightTurn(270, LANECHANGERADIUS);
       	}else if (beforeInt_CancelRightLaneChangePhase == CancelLaneChangePhase.COMPLETED&& rotationAngle == 270){//tweak here
       		
       		//System.out.println(" Bi_CancelRightLaneChange(): accessed");
       	}
   }
       
  


	
     //before intersection right lane change ended
	//******************************************************************************************************************************************************************************************************************************
    public static double getrBiRightLaneChangeExitAngle() {
   	 return R_BIRIGHT_LANE_CHANGEEXITANGLE;
    }
	 public static double getlBiRightLaneChangeExitAngle() {
		 return L_BIRIGHT_LANE_CHANGEEXITANGLE;
	 }

	 public static double getlAltrightLanechangeexitangle() {
		 return L_ALTRIGHT_LANECHANGEEXITANGLE;
	 }

	 public static double getlAltleftLanechangeexitangle() {
		 return L_ALTLEFT_LANECHANGEEXITANGLE;
	 }
	
	
	
}
