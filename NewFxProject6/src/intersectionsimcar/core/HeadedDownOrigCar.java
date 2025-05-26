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
    
    private Pane root;
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
      

    public void initialize() {
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
	
	 @Override
	 public void setGeneralPlacementOfCarBaseOnGeneralLocation() {
		  
		   double dist_from_LeftTurn_Point = Math.sqrt(Math.pow((TOP_MAKE_LEFT_POINTY - this.getPositionX()),2) + Math.pow((TOP_MAKE_LEFT_POINTY - this.getPositionY()),2));//tweak here
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
	 
	 public HeadedDownOrigCar(Pane root, LaneManagement laneManagement, 
  		   double spawnPositionX, 
  		   double spawnPositionY) {
  	    super( laneManagement, spawnPositionX, spawnPositionY);
  	   
  	    carCornerCoordinate = new CarCornerCoordinate[4];

  	    
  	    this.setGeneralPlacementOfCarBaseOnGeneralLocation();//still need to ensure all lane are accounted for
		//this.needToDoThisEverytimeSetFrontCarAndRearCar();
		//this.needToDoThisEverytimeSetTargetFrontCarBlindSpotCarRearCar();
  	    Random random = new Random();
  	
  	   //car_P.setxCoordinateSelected(false);
  	   int randomInt = random.nextInt(180);
  	   
  	//calculateAndSetAllBlinkersAngle(this.angle_DifferenceToFrontBlinkers, this.angle_DifferenceToRearBlinkers); remember to delete this it doesn't belong here
		//calculateAllBlinkersPosition(this.length_CarPosToFrontBlinkers, this.length_CarPosToRearBlinkers); remember to delete this it doesn't belong here
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
		 this.positionCarCorners();
	  	 this.setCarCornerCircle();
     	this.initialize();
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


	public void removeCarImageViewsFromRoot(Pane root) {
  	
  	
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
     /*
      
      if (  getCarIntention() == CarIntention.BI_ONLTBWANTLT && (UPLEFTTURNY - getPositionY()) < getDistanceTraveledYaxis()) {
      	//System.out.println("CircleRpCar PositionManipulationFormula");
      	setDistanceTraveledYaxis(UPLEFTTURNY - getPositionY());
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
      */
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
      
      blinkersBlinks();
  		
  }
  
  
	public void carOperation() {
  	
		 
  	positionManipulationFormula(this.getxCoordinate(),this.getyCoordinate(),getStraightEndingX(),getStraightEndingY());
  	
		
  		calculateAndSetAllBlinkersAngle(this.angle_Diff_Front_Blinkers, this.angle_Diff_Rear_Blinkers);
 	 	calculateAllBlinkersPosition(this.length_For_Front_Blinkers, this.length_For_Rear_Blinkers);
 	 	calculateAndSetAllCornersAngle(this.angle_Diff_Front_Corners, this.angle_Diff_Rear_Corners);
		calculateAllCornersPosition(this.length_For_Front_Corners, this.length_For_Rear_Corners);
		this.positionCarCorners();
		this.drawCircleRpCorner(carCornerCoordinate);
		//this.setGeneralPlacementOfCar();//still need to ensure all lane are accounted for
		this.needToDoThisEverytimeSetFrontCarAndRearCar();
		//this.needToDoThisEverytimeSetTargetFrontCarBlindSpotCarRearCar();
		//this.laneChangePointXSelection();// need to come up with lane change decision logic
		//this.laneChangePointYSelection();
		//this.carState();
		//this.actionBaseOnCarState(carImageView_P, carImageView_brake_P);
		this.gasGoStraight();
	
		
		//------------------------------------------------------------------------------------------------------------------------------------Temporary Code
		/* 
		if (this.getHeadingDownLeftLaneList() != null && this.getHeadingDownLeftLaneList().size() < 1) {
			 for (Car car : this.getHeadingDownLeftLaneList()) {
				 System.out.println("\ntargetLaneListKey: " +this.getOnWhichLaneListKey()+ 
		    		"\n --->this: " + car.getCarSkin() + "---->            OnWhichLane: " + this.getOnWhichLaneListKey() +
					"\n --->this: " + car.getCarSkin() + "----> frontCarOnTheOtherLane: " + (this.getFrontCarOnTheOtherLane() == null ? null : car.getFrontCarOnTheOtherLane().getCarSkin() )+
					"\n --->this: " + car.getCarSkin() + "---->           blindSpotCar: " + (this.getBlindSpotCar() == null ? null : car.getBlindSpotCar().getCarSkin())+
					"\n --->this: " + car.getCarSkin() + "---->  rearCarOnTheOtherLane: " + (this.getRearCarOnTheOtherLane() == null ? null : car.getRearCarOnTheOtherLane().getCarSkin()));
		 
			 }
		 }
		*/
		 //--------------------------------------------------------------------------------------------------------------------------------------Temporary Code
	/*
				 System.out.println("\ntargetLaneListKey: " +this.getOnWhichLaneListKey()+ 
		    		"\n --->this: " + this.getCarSkin() + "---->        OnWhichLane: " + this.getOnWhichLaneListKey() +
		    		"\n --->this: " + this.getCarSkin() + "getObservablelistCarisOn(): " + this.laneManagement.getHashMap_For_Observablelist().get(getOnWhichLaneListKey() +
					"\n --->this: " + this.getCarSkin() + "---->           frontCar: " + this.getFrontCar() == null ? null : this.getFrontCar().getCarSkin() )+
					       
					"\n --->this: " + this.getCarSkin() + "---->            rearCar: " + this.getRearCar() == null ? null : this.getRearCar().getCarSkin());
	*/	 
		
		
		
		
		
		
		//this.blinkersBlinks();
  }
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
		public void needToDoThisEverytimeSetFrontCarAndRearCar() {
			this.setOnWhichLaneEnum();
		    
			//this.setOnWhichLaneListKey(this.getOnWhichLane());
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
			System.out.println("\n --->this: " + this.getCarSkin() + "getObservablelistCarisOn(): " + this.getObservableListCarIsOn());
			for(IntersectionSimCar car : theListOfTheLaneTheCarIsOn) {
				if(this == car) {
					continue;
				}else {
					if (this.getFrontLeftCornerPositionY() < car.getRearLeftCornerPositionY()) {
				        System.out.println("setFrontCarRearCarHeadingDown: setFrontCar(...) if statement true");
						temp_Front_DistanceY = Math.abs(this.getFrontLeftCornerPositionY() - car.getRearLeftCornerPositionY());
						if(temp_Front_DistanceY < nearest_Front_Car_Base_On_DistanceHeadingDownY) {
							nearest_Front_Car_Base_On_DistanceHeadingDownY = temp_Front_DistanceY;
							setFrontCar(((IntersectionSimCar)car));
							
						}
					}
					if (this.getRearLeftCornerPositionY() > car.getFrontLeftCornerPositionY()) {
						System.out.println("setFrontCarRearCarHeadingDown: setRearCar(...) if statement true");
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


	private void blinkersBlinks() {
	
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

	private void setBlinkersVisible(ImageView[] blinkers, boolean visible) {
		for (ImageView blinker: blinkers) {
			blinker.setVisible(visible);    	
		}
	}

	

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
	
	
}
