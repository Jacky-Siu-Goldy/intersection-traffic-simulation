package intersectionsimcar.core;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;

import intersectionsimcar.core.HeadedDownOrigCar.CarCornerCoordinate;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;



public abstract class IntersectionSimCar {
	private static int idCounter = 0;
	private int carId;
	private double rotationAngle; // whatever angle the sprite is facing and changes when the leftTurn() function or the rightTurn() function is called
	private double positionX;//Position for car in the X-axis
	private double positionY;//Position for car in the Y-axis
	private double rise;//calculated using a formula dependent on the rotation angle in a function  for change in the Y direction
	private double run; // calculated using a formula dependent on the rotation angle in a function  for change in the X direction
	private double riseOverRun; // slope of the line that the car follows if it is going straight. Used in the formula to calculate distance traveled in the X axis
	private double runOverRise; // inverse of the slope of the line that the car follows if it is going straight. Used in the formula to calculate distance traveled in the Y axis
	
	private double distanceTraveledXaxis;// change in the car position in the X-axis
	private double distanceTraveledYaxis;// change in the car position in the Y-axis
	private double distanceAdjusted; // want ever distance you want beside the constant variable DISTANCEWANTED 
	//private boolean afterLT_WantRightLaneChange;//boolean for indicating there is a desire to change to the right lane, not necessarily doing it right away, have to wait for the right moment
	//private boolean afterLT_WantLeftLaneChange;// boolean for indicating there is a desire to change to the left lane, not necessarily doing it right away, have to wait for the right moment
	
	public void assignCarID() {
		
		this.carId = idCounter++;
	}
	
	private String carSkin;
	
	public void setCarSkin(String skin) {
		
		this.carSkin = skin;
	}
	
	public String getCarSkin() {
		
		return this.carSkin;
		
	}
	
    private double customCarLengthBaseOnCarSkin;
	
	public double getCustomCarLengthBaseOnCarSkin() {
		return customCarLengthBaseOnCarSkin;
	}
	
	public void setCustomCarLengthBaseOnCarSkin(double length) {
		this.customCarLengthBaseOnCarSkin = length;
	}
	//***********************************************************************************************************************************************************
	//added 12:25am 2025-05-20
	  private IntersectionSimCar frontCar;
	    
	    private IntersectionSimCar rearCar;
	    
	    private IntersectionSimCar blindSpotCar;
	    
	    private IntersectionSimCar frontCarOnTheOtherLane;
	    
	    private IntersectionSimCar rearCarOnTheOtherLane;
	  
	    public IntersectionSimCar getFrontCar() {
			return frontCar;
		}

		public void setFrontCar(IntersectionSimCar frontCar) {
			this.frontCar = frontCar;
		}

		public IntersectionSimCar getRearCar() {
			return rearCar;
		}

		public void setRearCar(IntersectionSimCar rearCar) {
			this.rearCar = rearCar;
		}

		public IntersectionSimCar getBlindSpotCar() {
			return blindSpotCar;
		}

		public void setBlindSpotCar(IntersectionSimCar blindSpotCar) {
			this.blindSpotCar = blindSpotCar;
		}

		public IntersectionSimCar getFrontCarOnTheOtherLane() {
			return frontCarOnTheOtherLane;
		}

		public void setFrontCarOnTheOtherLane(IntersectionSimCar frontCarOnTheOtherLane) {
			this.frontCarOnTheOtherLane = frontCarOnTheOtherLane;
		}

		public IntersectionSimCar getRearCarOnTheOtherLane() {
			return rearCarOnTheOtherLane;
		}

		public void setRearCarOnTheOtherLane(IntersectionSimCar rearCarOnTheOtherLane) {
			this.rearCarOnTheOtherLane = rearCarOnTheOtherLane;
		}
	//***********************************************************************************************************************************************************
	public CancelLaneChangePhase getBeforeInt_CancelRightLaneChangePhase() {
		return beforeInt_CancelRightLaneChangePhase;
	}

	public void setBeforeInt_CancelRightLaneChangePhase(CancelLaneChangePhase beforeInt_CancelRightLaneChangePhase) {
		this.beforeInt_CancelRightLaneChangePhase = beforeInt_CancelRightLaneChangePhase;
	}
	
	public LaneChangePhase getBeforeInt_RightLaneChangePhase() {
		
		return this.beforeInt_RightLaneChangePhase;
	}

	public LaneChangePhase getAfterLT_RightLaneChangePhase() {
		return afterLT_RightLaneChangePhase;
	}

	public void setAfterLT_RightLaneChangePhase(LaneChangePhase afterLT_RightLaneChangePhase) {
		this.afterLT_RightLaneChangePhase = afterLT_RightLaneChangePhase;
	}

	public LaneChangePhase getAfterLT_LeftLaneChangePhase() {
		return afterLT_LeftLaneChangePhase;
	}

	public void setAfterLT_LeftLaneChangePhase(LaneChangePhase afterLT_LeftLaneChangePhase) {
		this.afterLT_LeftLaneChangePhase = afterLT_LeftLaneChangePhase;
	}

	public LaneChangePhase getAfterRT_RightLaneChangePhase() {
		return afterRT_RightLaneChangePhase;
	}

	public void setAfterRT_RightLaneChangePhase(LaneChangePhase afterRT_RightLaneChangePhase) {
		this.afterRT_RightLaneChangePhase = afterRT_RightLaneChangePhase;
	}

	public LaneChangePhase getAfterRT_LeftLaneChangePhase() {
		return afterRT_LeftLaneChangePhase;
	}

	public void setAfterRT_LeftLaneChangePhase(LaneChangePhase afterRT_LeftLaneChangePhase) {
		this.afterRT_LeftLaneChangePhase = afterRT_LeftLaneChangePhase;
	}

	public LaneChangePhase getAfterInt_RightLaneChangePhase() {
		return afterInt_RightLaneChangePhase;
	}

	public void setAfterInt_RightLaneChangePhase(LaneChangePhase afterInt_RightLaneChangePhase) {
		this.afterInt_RightLaneChangePhase = afterInt_RightLaneChangePhase;
	}

	public LaneChangePhase getAfterInt_LeftLaneChangePhase() {
		return afterInt_LeftLaneChangePhase;
	}

	public void setAfterInt_LeftLaneChangePhase(LaneChangePhase afterInt_LeftLaneChangePhase) {
		this.afterInt_LeftLaneChangePhase = afterInt_LeftLaneChangePhase;
	}

	public CancelLaneChangePhase getAfterLT_CancelRightLaneChangePhase() {
		return afterLT_CancelRightLaneChangePhase;
	}

	public void setAfterLT_CancelRightLaneChangePhase(CancelLaneChangePhase afterLT_CancelRightLaneChangePhase) {
		this.afterLT_CancelRightLaneChangePhase = afterLT_CancelRightLaneChangePhase;
	}

	public CancelLaneChangePhase getAfterLT_CancelLeftLaneChangePhase() {
		return afterLT_CancelLeftLaneChangePhase;
	}

	public void setAfterLT_CancelLeftLaneChangePhase(CancelLaneChangePhase afterLT_CancelLeftLaneChangePhase) {
		this.afterLT_CancelLeftLaneChangePhase = afterLT_CancelLeftLaneChangePhase;
	}

	public CancelLaneChangePhase getAfterRT_CancelRightLaneChangePhase() {
		return afterRT_CancelRightLaneChangePhase;
	}

	public void setAfterRT_CancelRightLaneChangePhase(CancelLaneChangePhase afterRT_CancelRightLaneChangePhase) {
		this.afterRT_CancelRightLaneChangePhase = afterRT_CancelRightLaneChangePhase;
	}

	public CancelLaneChangePhase getAfterRT_CancelLeftLaneChangePhase() {
		return afterRT_CancelLeftLaneChangePhase;
	}

	public void setAfterRT_CancelLeftLaneChangePhase(CancelLaneChangePhase afterRT_CancelLeftLaneChangePhase) {
		this.afterRT_CancelLeftLaneChangePhase = afterRT_CancelLeftLaneChangePhase;
	}

	public CancelLaneChangePhase getAfterInt_CancelRightLaneChangePhase() {
		return afterInt_CancelRightLaneChangePhase;
	}

	public void setAfterInt_CancelRightLaneChangePhase(CancelLaneChangePhase afterInt_CancelRightLaneChangePhase) {
		this.afterInt_CancelRightLaneChangePhase = afterInt_CancelRightLaneChangePhase;
	}

	public CancelLaneChangePhase getAfterInt_CancelLeftLaneChangePhase() {
		return afterInt_CancelLeftLaneChangePhase;
	}

	public void setAfterInt_CancelLeftLaneChangePhase(CancelLaneChangePhase afterInt_CancelLeftLaneChangePhase) {
		this.afterInt_CancelLeftLaneChangePhase = afterInt_CancelLeftLaneChangePhase;
	}

	
	
	

	
	public static final double MAX_X_DISTANCE_BETWEEN_CARS = 100000;
	public static final double MAX_Y_DISTANCE_BETWEEN_CARS = 100000;
	
  
	private double xCoordinate;
	private double yCoordinate;
	/**
	 * Identify the General placement of the car 
	 * 
	 * BI_ONRIGHTLANE --Before intersection and on right lane
	 * BI_ONLEFTLANE  --Before intersection turn and on left lane 
	 * LEFTTURNBOX       --On left turn box lane
	 * ART_ONRIGHTLANE   --After right turn and on right lane
	 * ART_ONLEFTLANE    --After right turn and on left lane
	 * ALT_ONRIGHTLANE   --After left turn and on right lane
	 * ALT_ONLEFTLANE    --After left turn and on left lane
	 * INBETWEENLANE     --In the middle of a lane change
	 * IN_INTERSECTIONBLT   --Inside the intersection blocking left traffic 
	 * IN_INTERSECTIONBRT   --Inside the intersection blocking right traffic
	 * IN_INTERSECTIONWFLTURN   --Inside the intersection waiting for left Turn
	 * IN_INTERSECTIONWFRTURN --Inside the intersection waiting for Right Turn
	 * IN_INTERSECTIONBOCT   --Inside the intersection blocking on coming traffic   
	 * AI_ONRIGHTLANE --After intersection and on right lane
	 * AI_ONLEFTLANE  --After intersection turn and on left lane 
	 */
	public enum GeneralPlacementOfCar{
		BI_ONRIGHTLANE, BI_ONLEFTLANE, LEFTTURNBOX, 
		ART_ONRIGHTLANE, ART_ONLEFTLANE, 
		ALT_ONRIGHTLANE,ALT_ONLEFTLANE, INTRANSITION, 
		IN_INTERSECTIONBLOCKLT, IN_INTERSECTIONBLOCKRT, 
		IN_INTERSECTIONWFLTURN, IN_INTERSECTIONWFRTURN, IN_INTERSECTIONBLOCKOCT,
		AI_ONRIGHTLANE, AI_ONLEFTLANE;
	}

	
	
	/**
	 * Indicate car Intention
	 * BI_ONRLWANTLLC  --Before Intersection on right lane, Want Left Lane Change
	 * BI_ONLLWANTRLC  --Before Intersection on left lane, Want Right Lane Change
	 * BI_ONLLWANTLLC  --Before Intersection on left lane, Want Left Lane Change
	 * BI_ONRLWANTRT   --Before Intersection on right Lane, Want Right Turn
	 * BI_ONLTBWANTLT  --Before Intersection on left turn box, Want Left Turn
	 * ART_ONLLWANTRLC  --After Right Turn on left lane, Want Right Lane Change
	 * ART_ONRLWANTLLC  --After Right Turn on right lane, Want Left Lane Change
	 * ALT_ONLLWANTRLC  --After Left Turn on left lane, Want Right Lane Change
	 * ALT_ONRLWANTLLC  --After Left Turn on right lane, Want Left Lane Change
	 * AI_ONLLWANTRLC --After Intersection on left lane, want Right Lane Change
	 * AI_ONRLWANTLLC --After Intersection on right lane, want Left Lane Change
	 */
	public enum CarIntention{
		BI_ONRLWANTLLC,BI_ONLLWANTRLC , BI_ONLLWANTLLC,
		BI_ONRLWANTRT, BI_ONLTBWANTLT,
		ART_ONRLWANTLLC, ART_ONLLWANTRLC, 
		ALT_ONRLWANTLLC, ALT_ONLLWANTRLC,
		AI_ONRLWANTLLC, AI_ONLLWANTRLC,
		NONE;
	}
	
	private CarIntention carIntention;
	
	public CarIntention getCarIntention() {
		return carIntention;
	}

	public void setCarIntention(CarIntention carIntention) {
		this.carIntention = carIntention;
	}

	private GeneralPlacementOfCar generalPlacementOfCar;
	private boolean xCoordinateSelected;//need to write the function that make the decision on that
	private boolean yCoordinateSelected;//need to write the function that make the decision on that
	public enum CarAction {
		GOSTRAIGHT, LEFTTURN, RIGHTTURN, BI_RIGHTLANECHANGE, BI_CANCELRIGHTLANECHANGE, BI_LEFTLANECHANGE, BI_CANCELLEFTLANECHANGE,
		
		ART_RIGHTLANECHANGE, ART_CANCELRIGHTLANECHANGE, ART_LEFTLANECHANGE, ART_CANCELLEFTLANECHANGE,
		
		ALT_RIGHTLANECHANGE, ALT_CANCELRIGHTLANECHANGE, ALT_LEFTLANECHANGE, ALT_CANCELLEFTLANECHANGE
	}
	
	private CarAction carAction;
	
	public enum LaneChangeProbabilities{
		
		HIGH(40, 20), MEDIUM(75, 68), LOW(95, 90), ZERO(101,101);
		
		private final int higher_Threshold;
		private final int lower_Threshold;
		
		LaneChangeProbabilities(int higher_Threshold, int lower_Threshold){
			this.higher_Threshold = higher_Threshold;
			this.lower_Threshold = lower_Threshold;
		}
		
		public void execute(IntersectionSimCar car) {
			if (this == ZERO) return;
			
			car.setGeneralPlacementOfCarBaseOnGeneralLocation();
			
			if(!car.lane_Change_Probabilities_accessed) {
				Random random = new Random();
				int randInt = random.nextInt(100);
				//System.out.println("randInt: " + randInt);
				//
				checkLaneChange(car, randInt);
			}
		}
		
		public GeneralPlacementOfCar generalPlacementOfCar;
		
		public GeneralPlacementOfCar getGeneralPlacementOfCar() {
			 return this.generalPlacementOfCar;
		 }
		public void setGeneralPlacementOfCar(GeneralPlacementOfCar generalPlacementOfCar) {
				this.generalPlacementOfCar = generalPlacementOfCar;
				
		 }
	
		

		
		 
		//************************************************************************************************************************************************************************************
		//getGeneralPlacementOfCar() method need to be just a declaration in the abstract class
		private void checkLaneChange(IntersectionSimCar car, int randInt) {//next to add more cases after fixing GeneralPlacementOfCar
			switch(this.getGeneralPlacementOfCar()) {
			
			  case GeneralPlacementOfCar.BI_ONRIGHTLANE:
				  if (randInt >= higher_Threshold) {
					  if(car.areAllLaneChangePhasesInactiveAndLeftAndRightTurnCompleted()) {
						  car.carIntention = CarIntention.BI_ONRLWANTLLC;
					  }
					  
				  }else if (randInt <= lower_Threshold) {
					  if(car.areAllLaneChangePhasesInactiveAndLeftAndRightTurnCompleted()) {
						  car.carIntention = CarIntention.BI_ONRLWANTRT;
					  }
					  
				  }
				  break;
			 
			  case GeneralPlacementOfCar.BI_ONLEFTLANE:
				 
				  if (randInt >= higher_Threshold) {
					  if(car.areAllLaneChangePhasesInactiveAndLeftAndRightTurnCompleted()) {
						  car.carIntention = CarIntention.BI_ONLLWANTRLC;
					  }
					  
					 // System.out.println("checkLaneChange(CircleRpCar, int)'s BI_ONLEFTLANE --> BI_ONLLWANTRLC accessed");
				  }else if (randInt <=lower_Threshold ) {
					  if(car.areAllLaneChangePhasesInactiveAndLeftAndRightTurnCompleted()) {
						  car.carIntention = CarIntention.BI_ONLLWANTLLC;
						  System.out.println("Enum: LaneChangeProbabilities --> checkLaneChange accessed -->GeneralPlacementOfCar.BI_ONLEFTLANE. carIntention set to: " + car.carIntention);
					  }
					  
				  }
				  break;
		
			  case GeneralPlacementOfCar.LEFTTURNBOX:
				  if(car.areAllLaneChangePhasesInactiveAndLeftAndRightTurnCompleted()) {
					  car.carIntention = CarIntention.BI_ONLTBWANTLT;
				  }
				  
				  break;
			
			  case GeneralPlacementOfCar.IN_INTERSECTIONWFRTURN:
				  if(car.areAllLaneChangePhasesInactiveAndLeftAndRightTurnCompleted()) {
					  car.carIntention = CarIntention.BI_ONRLWANTRT;
				  }
				  
			      break;
			 
			  case GeneralPlacementOfCar.IN_INTERSECTIONWFLTURN:
				  if(car.areAllLaneChangePhasesInactiveAndLeftAndRightTurnCompleted()) {
					  car.carIntention = CarIntention.BI_ONLTBWANTLT;
				  }
				 
			      break;
			  
			  case GeneralPlacementOfCar.IN_INTERSECTIONBLOCKOCT:
				  if(car.areAllLaneChangePhasesInactiveAndLeftAndRightTurnCompleted()) {
					  car.carIntention = CarIntention.BI_ONLTBWANTLT;
				  }
				  
				  break;
				  
			  case GeneralPlacementOfCar.AI_ONRIGHTLANE:
				  
				  if (randInt >= higher_Threshold) {
					  if(car.areAllLaneChangePhasesInactiveAndLeftAndRightTurnCompleted()) {
						  car.carIntention = CarIntention.AI_ONRLWANTLLC;
					  }
					  
				  }
				  break;
		
			  case GeneralPlacementOfCar.AI_ONLEFTLANE:
				  if (randInt >= higher_Threshold) {
					  if(car.areAllLaneChangePhasesInactiveAndLeftAndRightTurnCompleted()) {
						  car.carIntention = CarIntention.AI_ONLLWANTRLC;
					  }
					  
				  }
				  break;
		
			  case GeneralPlacementOfCar.ALT_ONLEFTLANE:
				  if (randInt >= higher_Threshold) {
					  if(car.areAllLaneChangePhasesInactiveAndLeftAndRightTurnCompleted()) {
						  car.carIntention = CarIntention.ALT_ONLLWANTRLC;
					  }
					  
				  }
					 
				  break;		
		
			  case GeneralPlacementOfCar.ALT_ONRIGHTLANE:
				  if (randInt >= higher_Threshold) {
					  if(car.areAllLaneChangePhasesInactiveAndLeftAndRightTurnCompleted()) {
						  car.carIntention = CarIntention.ALT_ONRLWANTLLC;
					  }
					  
				  }
				  break;
				  
		
			  case GeneralPlacementOfCar.ART_ONRIGHTLANE:
				  if (randInt >= higher_Threshold) {
					  if(car.areAllLaneChangePhasesInactiveAndLeftAndRightTurnCompleted()) {
						  car.carIntention = CarIntention.ART_ONRLWANTLLC;
					  }
					  
				  }
			  	  break;
			  	
		
			  case GeneralPlacementOfCar.ART_ONLEFTLANE:
				  if (randInt >= higher_Threshold) {
					  if(car.areAllLaneChangePhasesInactiveAndLeftAndRightTurnCompleted()) {
						  car.carIntention = CarIntention.ART_ONLLWANTRLC;
					  }
					  
				  }
				  break;
				  
			
				    
			default:
			
				break;
			}

		}
		
	}
	//CheckLaneChangeEnds
	//****************************************************************************************************************************
	public boolean areAllLaneChangePhasesInactiveAndLeftAndRightTurnCompleted() {
		return (Arrays.stream(LaneChangePhase.values())
			   .allMatch(phase -> phase == LaneChangePhase.NONE || phase == LaneChangePhase.COMPLETED) 
			   || this.rotationAngle == HEADING_UP_CARDINAL_ANGLE
			   || this.rotationAngle == HEADING_DOWN_CARDINAL_ANGLE
			   || this.rotationAngle == HEADING_LEFT_CARDINAL_ANGLE
			   || this.rotationAngle == HEADING_RIGHT_CARDINAL_ANGLE);
	}
	
	
	static LaneChangeProbabilities laneChangeProbabilities;
	//***************************************************************************************************************************************************************
	/**
	 * Different mode of (Lane Change Phase)
	 */
	public enum LaneChangePhase{
		NONE,PHASE_1,PHASE_2, PHASE_3, COMPLETED;
	}
	
	private LaneChangePhase afterLT_RightLaneChangePhase;
	private LaneChangePhase afterLT_LeftLaneChangePhase;
	private LaneChangePhase afterRT_RightLaneChangePhase;
	private LaneChangePhase afterRT_LeftLaneChangePhase;
	private LaneChangePhase beforeInt_RightLaneChangePhase;
	private LaneChangePhase beforeInt_LeftLaneChangePhase;
	private LaneChangePhase afterInt_RightLaneChangePhase;
	private LaneChangePhase afterInt_LeftLaneChangePhase;
	
	/**
	 * Different mode of (Cancel Lane Change Phase)
	 */
	public enum CancelLaneChangePhase {
		NONE, PHASE_1, PHASE_2, COMPLETED;
	}
	private CancelLaneChangePhase afterLT_CancelRightLaneChangePhase;
	private CancelLaneChangePhase afterLT_CancelLeftLaneChangePhase;
	private CancelLaneChangePhase afterRT_CancelRightLaneChangePhase;
	private CancelLaneChangePhase afterRT_CancelLeftLaneChangePhase;
	private CancelLaneChangePhase beforeInt_CancelRightLaneChangePhase;
	private CancelLaneChangePhase beforeInt_CancelLeftLaneChangePhase;
	private CancelLaneChangePhase afterInt_CancelRightLaneChangePhase;
	private CancelLaneChangePhase afterInt_CancelLeftLaneChangePhase;
	
	
	public static final double HEADING_UP_CARDINAL_ANGLE = 90;
	public static final double HEADING_LEFT_CARDINAL_ANGLE = 0;
	public static final double HEADING_RIGHT_CARDINAL_ANGLE = 180;
	public static final double HEADING_DOWN_CARDINAL_ANGLE = 270;
	
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public static final double TOP_MAKE_RIGHT_POINTX = 494.5;
	public static final double TOP_MAKE_RIGHT_POINTY = 215;
	public static final double TOP_MAKE_LEFT_POINTX = 572.5;
	public static final double TOP_MAKE_LEFT_POINTY = 297.5;
	
	public static final double BOTTOM_MAKE_RIGHT_POINTX = 650.5;
	public static final double BOTTOM_MAKE_RIGHT_POINTY = 578;
	public static final double BOTTOM_MAKE_LEFT_POINTX = 572.5;
	public static final double BOTTOM_MAKE_LEFT_POINTY = 495.5;
	
	public static final double LEFT_MAKE_RIGHT_POINTX = 391;
	public static final double LEFT_MAKE_RIGHT_POINTY = 474.5;
	public static final double LEFT_MAKE_LEFT_POINTX = 473.5;
	public static final double LEFT_MAKE_LEFT_POINTY = 396.5;
	
	public static final double RIGHT_MAKE_RIGHT_POINTX = 754;
	public static final double RIGHT_MAKE_RIGHT_POINTY = 318.5;
	public static final double RIGHT_MAKE_LEFT_POINTX = 671.5;
	public static final double RIGHT_MAKE_LEFT_POINTY = 396.5;
	
	//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	public static final double HEADING_LEFT_CENTER_OF_R_LANE_Y = 318.5;
	public static final double HEADING_LEFT_CENTER_OF_L_LANE_Y = 357.5;
	public static final double HEADING_LEFT_CENTER_OF_LTB_LANE_Y = 396.5;
	public static final double HEADING_RIGHT_CENTER_OF_LTB_LANE_Y = 396.5;
	public static final double HEADING_RIGHT_CENTER_OF_L_LANE_Y = 435.5;
	public static final double HEADING_RIGHT_CENTER_OF_R_LANE_Y = 474.5;
	
	
	public static final double HEADING_DOWN_CENTER_OF_R_LANE_X = 494.5;
	public static final double HEADING_DOWN_CENTER_OF_L_LANE_X = 533.5;
	public static final double HEADING_DOWN_CENTER_OF_LTB_LANE_X = 572.5;
	public static final double HEADING_UP_CENTER_OF_LTB_LANE_X = 572.5;
	public static final double HEADING_UP_CENTER_OF_L_LANE_X = 611.5;
	public static final double HEADING_UP_CENTER_OF_R_LANE_X = 650.5;
	
	//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public static final double TOLERANCE = 18.5;
	LaneManagement laneManagement;
	public LaneManagement getLaneManagement() {
		return laneManagement;
	}
	//*****************************************************************************************************************************

    /**
     * The typical distance covered by the car
     */
    public static final double DISTANCEWANTED = 2.8; //Standard speed of the car
    
    /**
     * Coordinate in the Y axis of when the car should start making a right turn to successfully make a right turn
     */
    public static final double UPRIGHTTURNY = 215; //Coordinate in the Y axis of when the car should start making a right turn to successfully make a right turn
    
    /**
     * Coordinate in the X axis of when the car should start making a left turn to successfully make a Left turn
     */
    public static final double UPLEFTTURNY = 297.5;//Coordinate in the X axis of when the car should start making a left turn to successfully make a Left turn
    
    /**
     * the radius of the circle whose perimeter represents the path that the car would be following when making a right turn
     */
    public static final double RIGHTTURNRADIUS = 103.5; // the radius of the circle whose perimeter represents the path that the car would be following when making a right turn
    
    /**
     * the radius of the circle whose perimeter represents the path that the car would be following when making a left turn
     */
    public static final double LEFTTURNRADIUS = 138; // the radius of the circle whose perimeter represents the path that the car would be following when making a left turn
    
    /**
     * The sign in a formula that convert that value of the angle of the car's position (as it follows circular path 
     * with respect to the circle's center) back to the rotationAngle (the direction the car is facing)
     * (This applies to a right-turning circle) 
     */
	public static final int RIGHTTURNTOCARDIRECTIONSIGN = -1;//The sign in a formula that convert that value of the angle of the car's position as it follows circular path with respect to the circle's center 
    													    //(This circle is for right turn) back to the rotationAngle (the direction the car is facing) 
   
    
	/**
	 * The sign in a formula that convert that value of the angle of the car's position (as it follows circular path 
	 * with respect to the circle's center) back to the rotationAngle (the direction the car is facing) 
	 * (This applies to a left-turning circle)
	 */
	public static final int LEFTTURNTOCARDIRECTIONSIGN = 1;//The sign in a formula that convert that value of the angle of the car's position as it follows circular path with respect to the circle's center 
                                                           //(This circle is for right turn) back to the rotationAngle (the direction the car is facing) 
    
	/**
	 * radius for lane change (the diameter of this circle span the center of the lane you are changing from to the center of the lane you are changing to)
	 */
    public static final double LANECHANGERADIUS = 19.5;    //radius for lane change
    
   
	public static final double R_BIRIGHT_LANECHANGEEXITANGLE = 282;
	public static final double L_BIRIGHT_LANE_CHANGEEXITANGLE = 270;
	/**
	 * The exit angle for canceling lane is not a final static variable because it can be different every time
	 */
	private double r_AltCancelRight_LaneChangeExitAngle;
	
	public double getR_AltCancelRight_LaneChangeExitAngle() {
		return r_AltCancelRight_LaneChangeExitAngle;
	}


	public void setR_AltCancelRight_LaneChangeExitAngle() {
		this.r_AltCancelRight_LaneChangeExitAngle = (IntersectionSimCar.getlAltrightLanechangeexitangle() - IntersectionSimCar.getlAltrightLanechangeexitangle() - 180)*2;
		
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
    
    

	private double straightEndingX;//phase 2's ending of going straight of any lane change (x-Coordinate)
    private double straightEndingY;
    private double straightStartingX;// phase 2's beginning of going straight of any lane change (x-Coordinate)
    private double straightStartingY;
    private double positionXSnapShot;// phase 2's  starting point in the x-axis (x-Coordinate) to be used by straightStartingX-->see it's definition right above 
   	private double positionYSnapShot; 
    private static final double LEFTTURNEXITANGLE = 180; // aligns with the rotationAngle which means the rotationAngle will be 180 degree when it exit the Left turn circle (a circular path)
    
    private static final double RIGHTTURNEXITANGLE = 0; // aligns with the rotationAngle which means the rotationAngle will be 0 degree when it exit the Right turn circle (a circular path)
    
    private double arcLength;                              //is the change in arc distance as the car makes a right turn or a left turn following a circular path
    
    private double angleWithRespectToTheRightTurnCircle; // what the name say
  
    

   
	private double angleWithRespectToTheLeftTurnCircle; // what the name say
    
	private boolean lane_Change_Probabilities_accessed ;
	private boolean laneChangePhase1_Initiated;
  

    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//variable used inside left and right turn calculation function and for phase2 calculation when doing a Lane Change

	private double h;// h = Math.cos((angleWithRespectToTheRightTurnCircle) * (Math.PI / 180)) * RADIUS - positionX; // the h value need for the circle formula (can be for right turn or left turn) that is used to  
	                 // calculate the positionX as the car follow the circular path
	
    private double k;// k = Math.sin((angleWithRespectToTheRightTurnCircle) * (Math.PI / 180)) * RADIUS - positionY; // the h value need for the circle formula (can be for right turn or left turn) that is used to 
                     // calculate the positionY as the car follow the circular path
    
    private double angleOfTheArc;// change of the angle with respect to the right or left turn circle dependent on the distanceAdjusted (uses a formula)
  
    

	

	


	private double velocityWanted;// velocity of the car dependent on distanceAdjusted (uses a formula)
   
  
    private double whereItsFacingPointOnThePerimeterX;// what the name say (use for the a circle representing the car)(its the X position on the circle's perimeter that is used for drawing a line connecting it the the center of 
    											   // the circle drawing representing the car (an alternative to using a car sprite)
    
    private double whereItsFacingPointOnThePerimeterY;// what the name say (use for the a circle representing the car)(its the Y position on the circle's perimeter that is used for drawing a line connecting it the the center of 
	                                               // the circle drawing representing the car (an alternative to using a car sprite)
    
    
  
   
    private boolean makeARight; //boolean used for when to start or stop calling the rightTurn() function
    
   
   
    private boolean makeALeft;//boolean used for when to start or stop calling the leftTurn() function
	private CancelLaneChangePhase BeforeIn_CancelRightLaneChangePhase;
    
    //********************************************************************************************************************************************************************************************************************************************
    //Car's Brain
	public enum TrafficLightSignal{
		HEADING_LEFTRIGHT_RED_UPDOWN_RED,
		HEADING_LEFTRIGHT_YELLOW_H1_UPDOWN_RED,
		HEADING_LEFTRIGHT_YELLOW_H2_UPDOWN_RED,
		HEADING_LEFTRIGHT_GREEN_UPDOWN_RED,
		HEADING_UPDOWN_YELLOW_H1_LEFTRIGHT_RED,
		HEADING_UPDOWN_YELLOW_H2_LEFTRIGHT_RED,
		HEADING_UPDOWN_GREEN_LEFTRIGHT_RED
	}
	
	TrafficLightSignal trafficLightSignal;
	/**
	 * Identify The Lane the Car is on
	 */
	public enum OnWhichLane{
		HEADING_LEFT_ON_RIGHT_LANE_LIST,
		HEADING_LEFT_ON_LEFT_LANE_LIST,
		HEADING_LEFT_IN_LEFTTURNBOX_LIST,
		
		HEADING_RIGHT_ON_RIGHT_LANE_LIST,
		HEADING_RIGHT_ON_LEFT_LANE_LIST,
		HEADING_RIGHT_IN_LEFTTURNBOX_LIST,
		
		HEADING_UP_ON_RIGHT_LANE_LIST,
		HEADING_UP_ON_LEFT_LANE_LIST,
		HEADING_UP_IN_LEFTTURNBOX_LIST,
		
		HEADING_DOWN_ON_RIGHT_LANE_LIST,
		HEADING_DOWN_ON_LEFT_LANE_LIST,
		HEADING_DOWN_IN_LEFTTURNBOX_LIST
		
	}
	
	/**
	 * Identify the Target Lane the Car is Changing Lane into
	 */
	public enum TargetLane{
		HEADING_LEFT_ON_RIGHT_LANE_LIST,
		HEADING_LEFT_ON_LEFT_LANE_LIST,
		HEADING_LEFT_IN_LEFTTURNBOX_LIST,
		
		HEADING_RIGHT_ON_RIGHT_LANE_LIST,
		HEADING_RIGHT_ON_LEFT_LANE_LIST,
		HEADING_RIGHT_IN_LEFTTURNBOX_LIST,
		
		HEADING_UP_ON_RIGHT_LANE_LIST,
		HEADING_UP_ON_LEFT_LANE_LIST,
		HEADING_UP_IN_LEFTTURNBOX_LIST,
		
		HEADING_DOWN_ON_RIGHT_LANE_LIST,
		HEADING_DOWN_ON_LEFT_LANE_LIST,
		HEADING_DOWN_IN_LEFTTURNBOX_LIST,
		EMPTYLIST
		
	}
	  public void setOnWhichLaneEnum() {

		  
		  Stream.of(
				  MapUtility.entry(isOnRightLaneHeadingDown(), OnWhichLane.HEADING_DOWN_ON_RIGHT_LANE_LIST),
				  MapUtility.entry(isOnLeftLaneHeadingDown(), OnWhichLane.HEADING_DOWN_ON_LEFT_LANE_LIST),
				  MapUtility.entry(isOnLeftTurnBoxHeadingDown(), OnWhichLane.HEADING_DOWN_IN_LEFTTURNBOX_LIST),
				  MapUtility.entry(isOnRightLaneHeadingRight(), OnWhichLane.HEADING_RIGHT_ON_RIGHT_LANE_LIST),
				  MapUtility.entry(isOnLeftLaneHeadingRight(), OnWhichLane.HEADING_RIGHT_ON_LEFT_LANE_LIST),
				  MapUtility.entry(isOnLeftTurnBoxHeadingRight(), OnWhichLane.HEADING_RIGHT_IN_LEFTTURNBOX_LIST),
				  MapUtility.entry(isOnRightLaneHeadingLeft(), OnWhichLane.HEADING_LEFT_ON_RIGHT_LANE_LIST),
				  MapUtility.entry(isOnLeftLaneHeadingLeft(), OnWhichLane.HEADING_LEFT_ON_LEFT_LANE_LIST),
				  MapUtility.entry(isOnLeftTurnBoxHeadingLeft(),OnWhichLane.HEADING_LEFT_IN_LEFTTURNBOX_LIST),
				  MapUtility.entry(isOnRightLaneHeadingUp(), OnWhichLane.HEADING_UP_ON_RIGHT_LANE_LIST),
				  MapUtility.entry(isOnLeftLaneHeadingUp(), OnWhichLane.HEADING_UP_ON_LEFT_LANE_LIST),
				  MapUtility.entry(isOnLeftTurnBoxHeadingUp(), OnWhichLane.HEADING_UP_IN_LEFTTURNBOX_LIST))
		          //.peek(e -> System.out.println("Checking: " + e.getValue() + " -> " + e.getKey())) // 👈 Here
				  .filter(Map.Entry::getKey)
				  //.peek(e -> System.out.println("PASSED: " + e.getValue())) // 👈 Optional second peek
				  .map(Map.Entry::getValue)
				  .findFirst()
				  .ifPresent(lane -> this.onWhichLane = lane);
		  }
	  

	  
	  public boolean isOnRightLaneHeadingDown() {
		  
		  return Math.abs(HEADING_DOWN_CENTER_OF_R_LANE_X - positionX) < TOLERANCE  && rotationAngle == HEADING_DOWN_CARDINAL_ANGLE;
	  }
	 
	  public boolean isOnLeftLaneHeadingDown() {
		  return Math.abs(HEADING_DOWN_CENTER_OF_L_LANE_X - positionX) < TOLERANCE  && rotationAngle == HEADING_DOWN_CARDINAL_ANGLE;
	  }
	 
	  public boolean isOnLeftTurnBoxHeadingDown() {
		  return Math.abs(HEADING_DOWN_CENTER_OF_LTB_LANE_X - positionX)< TOLERANCE && rotationAngle == HEADING_DOWN_CARDINAL_ANGLE;
	  }
	 
	  public boolean isOnRightLaneHeadingRight() {
		  return Math.abs(HEADING_RIGHT_CENTER_OF_R_LANE_Y - positionY) < TOLERANCE && rotationAngle == HEADING_RIGHT_CARDINAL_ANGLE;
	  }
	  
	  public boolean isOnLeftLaneHeadingRight() {
		  return Math.abs(HEADING_RIGHT_CENTER_OF_L_LANE_Y - positionY) < TOLERANCE && rotationAngle == HEADING_RIGHT_CARDINAL_ANGLE;
	  }
	 
	  public boolean isOnLeftTurnBoxHeadingRight() {
		  return Math.abs(HEADING_RIGHT_CENTER_OF_LTB_LANE_Y - positionY)< TOLERANCE && rotationAngle == HEADING_RIGHT_CARDINAL_ANGLE;
	  }  
	  public boolean isOnRightLaneHeadingLeft() {
		  return Math.abs(HEADING_LEFT_CENTER_OF_R_LANE_Y - positionY) < TOLERANCE && rotationAngle == HEADING_LEFT_CARDINAL_ANGLE;
	  }
	  
	  public boolean isOnLeftLaneHeadingLeft() {
		  return Math.abs(HEADING_LEFT_CENTER_OF_L_LANE_Y - positionY) < TOLERANCE && rotationAngle == HEADING_LEFT_CARDINAL_ANGLE;
	  }
	  
	  public boolean isOnLeftTurnBoxHeadingLeft() {
		  return Math.abs(HEADING_LEFT_CENTER_OF_LTB_LANE_Y - positionY)< TOLERANCE && rotationAngle == HEADING_LEFT_CARDINAL_ANGLE;
	  }
	  
	  public boolean isOnRightLaneHeadingUp() {
		  return Math.abs(HEADING_UP_CENTER_OF_R_LANE_X - positionX) < TOLERANCE && rotationAngle == HEADING_UP_CARDINAL_ANGLE;
	  }
	  
	  public boolean isOnLeftLaneHeadingUp() {
		  return Math.abs(HEADING_UP_CENTER_OF_L_LANE_X- positionX) < TOLERANCE && rotationAngle == HEADING_UP_CARDINAL_ANGLE;
	  }
	  
	  public boolean isOnLeftTurnBoxHeadingUp() {
		  return Math.abs(HEADING_UP_CENTER_OF_LTB_LANE_X - positionX)< TOLERANCE && rotationAngle == HEADING_UP_CARDINAL_ANGLE;
	  }

	  //************************************************************************************************************************************
	  //abstract function declaration for setTargetEnum() which is a stream function unique to the child
	  
	  public abstract void setTargetLaneEnum();
	  
	 
	  public abstract void setGeneralPlacementOfCarBaseOnGeneralLocation();
	 
	  public abstract double getFrontRightCornerPositionX();


		public abstract void setFrontRightCornerPositionX(double frontRightCornerPositionX);


		public abstract double getFrontRightCornerPositionY();


		public abstract void setFrontRightCornerPositionY(double frontRightCornerPositionY);


		public abstract double getFrontLeftCornerPositionX();


		public abstract void setFrontLeftCornerPositionX(double frontLeftCornerPositionX);


		public abstract double getFrontLeftCornerPositionY();


		public abstract void setFrontLeftCornerPositionY(double frontLeftCornerPositionY);


		public abstract double getRearRightCornerPositionX();

		public abstract void setRearRightCornerPositionX(double rearRightCornerPositionX);
		public abstract double getRearRightCornerPositionY();
		


		public abstract void setRearRightCornerPositionY(double rearRightCornerPositionY);


		public abstract double getRearLeftCornerPositionX();


		public abstract void setRearLeftCornerPositionX(double rearLeftCornerPositionX);


		public abstract double getRearLeftCornerPositionY();


		public abstract void setRearLeftCornerPositionY(double rearLeftCornerPositionY);

		public abstract double getFront_R_Corner_Angle();


		public abstract void setFront_R_Corner_Angle(double front_R_Corner_Angle);

		public abstract double getFront_L_Corner_Angle();

		public abstract void setFront_L_Corner_Angle(double front_L_Corner_Angle);
		
		
		
		
		
		public abstract void deleteCircleRpCorner(Pane root);
		
		public abstract void removeCarImageViewsFromRoot(Pane root);
		
		public abstract void carOperation();
	  //*********************************************************************************************************************************
	
		public ObservableList<IntersectionSimCar> getObservableListCarIsOn(){
    	    
    		return laneManagement.getHashMap_For_Observablelist().get(this.getOnWhichLaneListKey());
    	
         }
		 
		 private TargetLane targetLaneList;
			
		 public TargetLane getTargetLaneList() {
			return targetLaneList;
		}

		 public void setTargetLaneList(TargetLane targetLaneList) {
			 this.targetLaneList = targetLaneList;
		 }

		 private TargetLane targetLaneListKey;
		 
		 public TargetLane getTargetLaneListKey() {
			 return targetLaneListKey;
		 }
		 
		 public void setTargetLaneListKey (TargetLane targetLaneList) {
			 this.targetLaneListKey = targetLaneList;
		 }
		 
		 private OnWhichLane onWhichLane;
		 private OnWhichLane onWhichLaneListKey;
		 
		 public OnWhichLane getOnWhichLane() {
			 return this.onWhichLane;
		 }
		 
		 public void setOnWhichLane(OnWhichLane onWhichLane){
			 this.onWhichLane = onWhichLane;
		 }
		 public OnWhichLane getOnWhichLaneListKey() {
			 return this.onWhichLaneListKey;
		 }
         public void setOnWhichLaneListKey(OnWhichLane onWhichLaneListKey) {
        	 this.onWhichLaneListKey = onWhichLaneListKey;
         }
         
         //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
     	// (isAlive) needed to see if the Object is alive or has been deleted
     	 private boolean isAlive;
         public boolean isAlive() {
     		return isAlive;
     	 }
         //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

     	 public void setAlive(boolean isAlive) {
     		this.isAlive = isAlive;
     	 }

         
         public IntersectionSimCar (LaneManagement laneManagement, double positionX, double positionY) {
	
	
	        this.xCoordinate = 0;
	        this.yCoordinate = 0;
	        this.straightEndingX = 0;
	        this.straightEndingY = 0;
	        this.laneManagement = laneManagement;
			rotationAngle = 270; //initial rotation angle of sprite
			this.positionX = positionX; //where the car will spawn
			this.positionY = positionY;   //where the car will spawn
			this.setOnWhichLaneEnum();
			this.setOnWhichLaneListKey(onWhichLane);
			rise = 0;
			run = 0 ;
			riseOverRun = 0;
			runOverRise = 0;
			distanceTraveledXaxis = 0;
			distanceTraveledYaxis = 0;
			distanceAdjusted = DISTANCEWANTED;
			velocityWanted = distanceAdjusted/60;// over 16, 16 is arbitrary
			arcLength = distanceAdjusted;
			angleOfTheArc = 0;
			this.setAngleWithRespectToTheRightTurnCircle();
		    this.setAngleWithRespectToTheLeftTurnCircle();
		    whereItsFacingPointOnThePerimeterX = 431.5; //initial position
		    whereItsFacingPointOnThePerimeterY = 202; //initial position
		    lane_Change_Probabilities_accessed = false;
	        makeARight = false;
	
	        makeALeft = false;
	       
	
        	laneChangePhase1_Initiated = false;

			//afterLT_WantRightLaneChange = false;
			//whichLaneTheCarIsOn = OnWhichLane.LEFTTURNBOX;
			r_BiCancelRight_LaneChangeExitAngle = rotationAngle;
			this.setGeneralPlacementOfCarBaseOnGeneralLocation();
			carIntention = CarIntention.NONE;
			carAction = CarAction.GOSTRAIGHT;
	//--------------------------------------------------------------------------------------------------------------------------------------------
			afterLT_RightLaneChangePhase = LaneChangePhase.NONE;
			afterLT_LeftLaneChangePhase = LaneChangePhase.NONE;
			afterRT_RightLaneChangePhase = LaneChangePhase.NONE;
			afterRT_LeftLaneChangePhase = LaneChangePhase.NONE;
			beforeInt_RightLaneChangePhase = LaneChangePhase.NONE;
			beforeInt_LeftLaneChangePhase = LaneChangePhase.NONE;
			afterInt_RightLaneChangePhase = LaneChangePhase.NONE;
			afterInt_LeftLaneChangePhase = LaneChangePhase.NONE;
	//----------------------------------------------------------------------------------------------------------------------------------------------		
			afterLT_CancelRightLaneChangePhase = CancelLaneChangePhase.NONE;
			afterLT_CancelLeftLaneChangePhase = CancelLaneChangePhase.NONE;
			afterRT_CancelRightLaneChangePhase = CancelLaneChangePhase.NONE;
			afterRT_CancelLeftLaneChangePhase = CancelLaneChangePhase.NONE;
			beforeInt_CancelRightLaneChangePhase = CancelLaneChangePhase.NONE;
			beforeInt_CancelLeftLaneChangePhase = CancelLaneChangePhase.NONE;
			afterInt_CancelRightLaneChangePhase = CancelLaneChangePhase.NONE;
			afterInt_CancelLeftLaneChangePhase = CancelLaneChangePhase.NONE;
	//-----------------------------------------------------------------------------------------------------------------------------------------------
	        
	  
	

		
		
			 /*System.out.println("OnWhichLaneListKey: " +onWhichLaneListKey+ 
			 					"\n --->this: " + this.getCarSkin() + "----> front: " + (frontCar == null ? null : frontCar.getCar_P().getCarSkin() )+
			 					"\n --->this: " + this.getCarSkin() + "----> Rear: " + (rearCar == null ? null : rearCar.getCar_P().getCarSkin()));
			 System.out.println("\n targetLaneListKey: " +targetLaneListKey+ 
			 		
						"\n --->this: " + this.getCarSkin() + "----> frontCarOnTheOtherLane: " + (frontCarOnTheOtherLane == null ? null : frontCarOnTheOtherLane.getCar_P().getCarSkin() )+
						"\n --->this: " + this.getCarSkin() + "---->           blindSpotCar: " + (blindSpotCar == null ? null : blindSpotCar.getCar_P().getCarSkin())+
						"\n --->this: " + this.getCarSkin() + "---->  rearCarOnTheOtherLane: " + (rearCarOnTheOtherLane == null ? null : rearCarOnTheOtherLane.getCar_P().getCarSkin()));*/
			this.setR_AltCancelRight_LaneChangeExitAngle();
			
			this.setxCoordinateSelected(false);
		
			this.setStraightEndingX(0);
			this.setStraightEndingY(0);
			this.setStraightStartingX(0);
			this.setStraightStartingY(0);
			setAlive(true);
			
			assignCarID();
	
 
}
		 public double getPositionX() {
			return positionX;
		}

		 public void setPositionX(double positionX) {
			 this.positionX = positionX;
		 }

		 public double getPositionY() {
			 return positionY;
		 }

		 public void setPositionY(double positionY) {
			 this.positionY = positionY;
		 }

		 public double getK() {
			 return k;
		 }

		 public void setK(double k) {
			 this.k = k;
		 }

		

		 public double getRun() {
			 return run;
		 }

		 public void setRun(double run) {
			 this.run = run;
		 }

		 public double getRiseOverRun() {
			 return riseOverRun;
		 }

		 public void setRiseOverRun(double riseOverRun) {
			 this.riseOverRun = riseOverRun;
		 }

		 public double getRunOverRise() {
			 return runOverRise;
		 }

		 public void setRunOverRise(double runOverRise) {
			 this.runOverRise = runOverRise;
		 }

		 public double getxCoordinate() {
			 return xCoordinate;
		 }

		 public void setxCoordinate(double xCoordinate) {
			 this.xCoordinate = xCoordinate;
		 }

		 public double getyCoordinate() {
			 return yCoordinate;
		 }

		 public void setyCoordinate(double yCoordinate) {
			 this.yCoordinate = yCoordinate;
		 }

		 public boolean isxCoordinateSelected() {
			 return xCoordinateSelected;
		 }

		 public void setxCoordinateSelected(boolean xCoordinateSelected) {
			 this.xCoordinateSelected = xCoordinateSelected;
		 }

		 public boolean isyCoordinateSelected() {
			 return yCoordinateSelected;
		 }

		 public void setyCoordinateSelected(boolean yCoordinateSelected) {
			 this.yCoordinateSelected = yCoordinateSelected;
		 }

		 public double getStraightEndingX() {
			 return straightEndingX;
		 }

		 public void setStraightEndingX(double straightEndingX) {
			 this.straightEndingX = straightEndingX;
		 }

		 public double getStraightEndingY() {
			 return straightEndingY;
		 }

		 public void setStraightEndingY(double straightEndingY) {
			 this.straightEndingY = straightEndingY;
		 }

		 public double getStraightStartingX() {
			 return straightStartingX;
		 }

		 public void setStraightStartingX(double straightStartingX) {
			 this.straightStartingX = straightStartingX;
		 }

		 public double getStraightStartingY() {
			 return straightStartingY;
		 }

		 public void setStraightStartingY(double straightStartingY) {
			 this.straightStartingY = straightStartingY;
		 }

		


		 public void setWhereItsFacingPointOnThePerimeterX(double whereItsFacingPointOnThePerimeterX) {
			 this.whereItsFacingPointOnThePerimeterX = whereItsFacingPointOnThePerimeterX;
		 }

		 public double getWhereItsFacingPointOnThePerimeterY() {
			 return whereItsFacingPointOnThePerimeterY;
		 }

		 public void setWhereItsFacingPointOnThePerimeterY(double whereItsFacingPointOnThePerimeterY) {
			 this.whereItsFacingPointOnThePerimeterY = whereItsFacingPointOnThePerimeterY;
		 }

		

		 public GeneralPlacementOfCar getGeneralPlacementOfCar() {
			return generalPlacementOfCar;
		}

		 public void setGeneralPlacementOfCar(GeneralPlacementOfCar generalPlacementOfCar) {
			this.generalPlacementOfCar = generalPlacementOfCar;
		 }

		 public static double getlBirightLaneChangeexitangle() {
			 return L_BIRIGHT_LANE_CHANGEEXITANGLE;
		 }

		 public static double getlAltrightLanechangeexitangle() {
			 return L_ALTRIGHT_LANECHANGEEXITANGLE;
		 }

		 public static double getlAltleftLanechangeexitangle() {
			 return L_ALTLEFT_LANECHANGEEXITANGLE;
		 }
         //*****************************************************************************************************************************************************
		 

		 public int getCarId() {
			 return carId;
		 }

		 public void setCarId(int carId) {
			 this.carId = carId;
		 }

		 public double getRise() {
			 return rise;
		 }

		 public void setRise(double rise) {
			 this.rise = rise;
		 }

		

		

		

		

		 public double getDistanceAdjusted() {
			 return distanceAdjusted;
		 }

		 public void setDistanceAdjusted(double distanceAdjusted) {
			 this.distanceAdjusted = distanceAdjusted;
		 }

		 public CarAction getCarAction() {
			 return carAction;
		 }

		 public void setCarAction(CarAction carAction) {
			 this.carAction = carAction;
		 }

		

		 public void setBeforeInt_RightLaneChangePhase(LaneChangePhase beforeInt_RightLaneChangePhase) {
			 this.beforeInt_RightLaneChangePhase = beforeInt_RightLaneChangePhase;
		 }

		 public LaneChangePhase getBeforeInt_LeftLaneChangePhase() {
			 return beforeInt_LeftLaneChangePhase;
		 }

		 public void setBeforeInt_LeftLaneChangePhase(LaneChangePhase beforeInt_LeftLaneChangePhase) {
			 this.beforeInt_LeftLaneChangePhase = beforeInt_LeftLaneChangePhase;
		 }

		 public CancelLaneChangePhase getBeforeInt_CancelLeftLaneChangePhase() {
			 return beforeInt_CancelLeftLaneChangePhase;
		 }

		 public void setBeforeInt_CancelLeftLaneChangePhase(CancelLaneChangePhase beforeInt_CancelLeftLaneChangePhase) {
			 this.beforeInt_CancelLeftLaneChangePhase = beforeInt_CancelLeftLaneChangePhase;
		 }

		 public double getPositionXSnapShot() {
			 return positionXSnapShot;
		 }

		 public void setPositionXSnapShot(double positionXSnapShot) {
			 this.positionXSnapShot = positionXSnapShot;
		 }

		 public double getPositionYSnapShot() {
			 return positionYSnapShot;
		 }

		 public void setPositionYSnapShot(double positionYSnapShot) {
			 this.positionYSnapShot = positionYSnapShot;
		 }

	

		 public void setAngleWithRespectToTheRightTurnCircle(double angleWithRespectToTheRightTurnCircle) {
			 this.angleWithRespectToTheRightTurnCircle = angleWithRespectToTheRightTurnCircle;
		 }

		

		 public void setAngleWithRespectToTheLeftTurnCircle(double angleWithRespectToTheLeftTurnCircle) {
			 this.angleWithRespectToTheLeftTurnCircle = angleWithRespectToTheLeftTurnCircle;
		 }

		 public boolean isLane_Change_Probabilities_accessed() {
			 return lane_Change_Probabilities_accessed;
		 }

		 public void setLane_Change_Probabilities_accessed(boolean lane_Change_Probabilities_accessed) {
			 this.lane_Change_Probabilities_accessed = lane_Change_Probabilities_accessed;
		 }

		 public boolean isLaneChangePhase1_Initiated() {
			 return laneChangePhase1_Initiated;
		 }

		 public void setLaneChangePhase1_Initiated(boolean laneChangePhase1_Initiated) {
			 this.laneChangePhase1_Initiated = laneChangePhase1_Initiated;
		 }

		 public double getH() {
			 return h;
		 }

		 public void setH(double h) {
			 this.h = h;
		 }

		

		 public void setAngleOfTheArc(double angleOfTheArc) {
			 this.angleOfTheArc = angleOfTheArc;
		 }

		 public boolean isMakeARight() {
			 return makeARight;
		 }

		 public void setMakeARight(boolean makeARight) {
			 this.makeARight = makeARight;
		 }

		 public boolean isMakeALeft() {
			 return makeALeft;
		 }

		 public void setMakeALeft(boolean makeALeft) {
			 this.makeALeft = makeALeft;
		 }

		 public CancelLaneChangePhase getBeforeIn_CancelRightLaneChangePhase() {
			 return BeforeIn_CancelRightLaneChangePhase;
		 }

		 public void setBeforeIn_CancelRightLaneChangePhase(CancelLaneChangePhase beforeIn_CancelRightLaneChangePhase) {
			 BeforeIn_CancelRightLaneChangePhase = beforeIn_CancelRightLaneChangePhase;
		 }

		 public TrafficLightSignal getTrafficLightSignal() {
			 return trafficLightSignal;
		 }
		 
		 

		 public void setTrafficLightSignal(TrafficLightSignal trafficLightSignal) {
			 this.trafficLightSignal = trafficLightSignal;
		 }
		
		//*************************************************************************************************************************************************************************************
			/**
			 * function for rightTurn basically going around in a circular path determined by the constant value RIGHTTURNRADIUS or the constant value LANECHANGERADIUS. The center of that circular path (center of the circle) is always located on the right side 
			 * of the car position and it's always the rotationAngle(where the car is facing)+90 degree because the car position with respect to the center of the rightTurn Circle is always the difference of +90 degree
			 * @param exitAngle  insert any constant that has to do with (right turn which is exit angle) It is an angle that the car (where the car is facing) will always align with at a point in time 
			 * as the car goes around in this circular path, everytime if you don't tell the car to do something else as it hit that angle(eg: gasGoStraight)
			 * @param radius  to set the radius of the circular path to be followed by the car make a right for whatever reason
			 */
			
			public void rightTurn(double exitAngle, double radius) {
				 this.setAngleWithRespectToTheRightTurnCircle();
				 h = positionX - Math.cos(angleWithRespectToTheRightTurnCircle * (Math.PI / 180)) * radius ;//h is the x coordinate of the center of the right turn circle
				 k = positionY - Math.sin(angleWithRespectToTheRightTurnCircle * (Math.PI / 180)) * radius ;//k is the y coordinate of the center of the right turn circle
				 this.setAngleOfTheArc(exitAngle, radius);// angleOfTheArc--the angle of the change in distance traveled along the circular path of the right turn circle
				 angleWithRespectToTheRightTurnCircle = angleWithRespectToTheRightTurnCircle + angleOfTheArc;//update the angleWithRespectToTheRightTurnCircle as the car travel in a clockwise direction
				 
				 //keep the angleWithRespectToTheRightTurnCircle within the 0 to 360 degree range--check code improvement in chatgpt
				 if (this.angleWithRespectToTheRightTurnCircle < 0 ){
						this.angleWithRespectToTheRightTurnCircle += 360;
			            
			     }else if(this.angleWithRespectToTheRightTurnCircle >= 360){
			        	this.angleWithRespectToTheRightTurnCircle -=360;
			     }
				 //*********************************************************************************************************************
				 positionX = Math.cos( angleWithRespectToTheRightTurnCircle* (Math.PI / 180)) * radius + h;//update positionX as the car travel to a new position along the circular path
				 positionY = Math.sin( angleWithRespectToTheRightTurnCircle* (Math.PI / 180)) * radius + k;//update positionY as the car travel to a new position along the circular path
				 this.updateRotationAngle(angleWithRespectToTheRightTurnCircle,RIGHTTURNTOCARDIRECTIONSIGN);//updating the rotationAngle (where the car is facing) as it travel along the circular path dependent on the 
				                                                                                          //in the equation used rotationAngle = (angleWithRespectToTheRightTurnCircle -90)
				 rise = Math.sin(rotationAngle * (Math.PI / 180));//* orY;//update rise of the slope
			     
			     run = Math.cos(rotationAngle * (Math.PI / 180));//* orX;//update run of the slope
			     
			     //----------------------------------------------------------------------------------------------------------------------------------------------------
			       //dependent on the rotationAngle converted to rise and run which are the x and y value of the unit circle 
			       //dependent on run and rise value of the unit circle. basically the input = operator sign changes  in the equation needed to produce the x and y coordinate at the perimeter
			       //to draw the line connecting them to the center of the Circle. The line representing where the car is facing.
				 if(rise > -1 && rise < 0 && run > 0 && run < 1){ // 270 < (x,y) < 0 
			            
			            whereItsFacingIndicator(1, -1);
			        }else if (rise == -1 && Math.abs(run) < 0.000001){ // (x,y) = 270
			           
			            whereItsFacingIndicator(0, -1);
			        }else if (rise > -1 && rise < 0 && run > -1 && run < 0){ // 270 < (x,y) < 180
			            
			            whereItsFacingIndicator(-1, -1);
			        }else if(rise == 0 & Math.abs(run) > -1 && Math.abs(run) < -0.99999999){ // (x,y) = 180
			           
			            whereItsFacingIndicator(0, -1);
			        }else if (rise < 1 && rise > 0 && run > -1 && run < 0){ // 180 > (x,y) >90
			            
			            whereItsFacingIndicator(-1, 1);
			        }else if (rise == 1 && Math.abs(run) < 0.000001){ // (x,y) = 90
			            
			            whereItsFacingIndicator(1, 0);
			        }else if (rise < 1 && rise > 0 && run > 0 && run < 1){ // 90 > (x,y) > 0
			            
			            whereItsFacingIndicator(1, 1);
			        }else if (rise == 0 && run == 1){// (x,y) = 0
			            
			         //   carAngle = 90 - rotationAngle;
			            
			            whereItsFacingIndicator(0 , 1);
			        }else if (Math.abs(rise) < 0.00001 && run == -1){// (x,y) = 180
			           
			            whereItsFacingIndicator(0 , -1);
			        }
				//--------------------------------------------------------------------------------------------------------------------------------------------------------------
				
				
			}
			


			/**
			 * see explanation of rightTurn() function which is similar enough to describe what's going on in the leftTurn() function as there are only minor changes in the content are needed to suit the Left Turn purpose of the car
			 * @param exitAngle
			 * @param radius
			 */
		    //see explanation of rightTurn() function which is similar enough to describe what's going on in the leftTurn() function as only minor changes in the content are needed to suit the Left Turn purpose of the car
		    public void leftTurn(double exitAngle, double radius) {
		    	this.setAngleWithRespectToTheLeftTurnCircle();
		    	
				
		    	 h = positionX - Math.cos(angleWithRespectToTheLeftTurnCircle * (Math.PI / 180)) * radius ;
				 k = positionY - Math.sin(angleWithRespectToTheLeftTurnCircle * (Math.PI / 180)) * radius ;
			
				 
				 this.setAngleOfTheArc(exitAngle, radius);
				
				 angleWithRespectToTheLeftTurnCircle -= angleOfTheArc;
				
				 if (this.angleWithRespectToTheLeftTurnCircle < 0 ){
						this.angleWithRespectToTheLeftTurnCircle += 360;
						
			     }else if(this.angleWithRespectToTheLeftTurnCircle >= 360){
			        	this.angleWithRespectToTheLeftTurnCircle -=360;
			     }
				 positionX = Math.cos( angleWithRespectToTheLeftTurnCircle* (Math.PI / 180)) * radius + h;
				 positionY = Math.sin( angleWithRespectToTheLeftTurnCircle* (Math.PI / 180)) * radius + k;
				 this.updateRotationAngle(angleWithRespectToTheLeftTurnCircle,LEFTTURNTOCARDIRECTIONSIGN);
				
				 rise = Math.sin(rotationAngle * (Math.PI / 180));//* orY;
		        
				 run = Math.cos(rotationAngle * (Math.PI / 180));//* orX;
		       
				 if(rise > -1 && rise < 0 && run > 0 && run < 1){ // 270 < (x,y) < 0 
			            
			            whereItsFacingIndicator(1, -1);
			        }else if (rise == -1 && Math.abs(run) < 0.000001){ // (x,y) = 270
			           
			            whereItsFacingIndicator(0, -1);
			        }else if (rise > -1 && rise < 0 && run > -1 && run < 0){ // 270 < (x,y) < 180
			            
			            whereItsFacingIndicator(-1, -1);
			        }else if(rise == 0 & Math.abs(run) > -1 && Math.abs(run) < -0.99999999){ // (x,y) = 180
			           
			            whereItsFacingIndicator(0, -1);
			        }else if (rise < 1 && rise > 0 && run > -1 && run < 0){ // 180 > (x,y) >90
			            
			            whereItsFacingIndicator(-1, 1);
			        }else if (rise == 1 && Math.abs(run) < 0.000001){ // (x,y) = 90
			            
			            whereItsFacingIndicator(1, 0);
			        }else if (rise < 1 && rise > 0 && run > 0 && run < 1){ // 90 > (x,y) > 0
			            
			            whereItsFacingIndicator(1, 1);
			        }else if (rise == 0 && run == 1){// (x,y) = 0
			            
			         //   carAngle = 90 - rotationAngle;
			            
			            whereItsFacingIndicator(0 , 1);
			        }else if (Math.abs(rise) < 0.00001 && run == -1){// (x,y) = 180
			           
			            whereItsFacingIndicator(0 , -1);
			        }
		    }
		    
		   
		    /**
		     * set the value of whereItsFacingPointOnThePerimeterX and the value of whereItsFacingPointOnThePerimeterY needed to draw a line from that coordinate
		     * to the center of a circle representing the Car serving as an indicator of where the car is pointing. The purpose of this function is only 
		     * to calculate those value not to actually draw the line
		     * @param x use to change the sign of the operator in the formula needed to calculate whereItsFacingPointOnThePerimeterX
		     * @param y use to change the sign of the operator in the formula needed to calculate whereItsFacingPointOnThePerimeterY
		     */
		    public void whereItsFacingIndicator(int x, int y){
		    	   
		        
		           
		           
		            
		            
		        if( rotationAngle == 0){
		            
		            whereItsFacingPointOnThePerimeterY = positionY;
		            whereItsFacingPointOnThePerimeterX = positionX + x * 18.5 ;
		        }else if (rotationAngle == 180){ 
		            whereItsFacingPointOnThePerimeterY = positionY ;
		            whereItsFacingPointOnThePerimeterX = positionX + x * 18.5;
		        }else if ( rotationAngle ==270){
		            whereItsFacingPointOnThePerimeterX = positionX ;
		            whereItsFacingPointOnThePerimeterY = positionY + y * 18.5; 
		        }else if ( rotationAngle == 90){
		            whereItsFacingPointOnThePerimeterX = positionX ;
		            whereItsFacingPointOnThePerimeterY = positionY + y * 18.5;
		        }else{ 
		            whereItsFacingPointOnThePerimeterX = Math.round(positionX + x * Math.abs(run) * 18.5);//cosineRun * 50;
		            whereItsFacingPointOnThePerimeterY = Math.round(positionY + y  * Math.abs(rise) * 18.5);//sineRise * 50;
		        }

		    }
		    
		    
		    public double normalizedRotationAngle() {
		    	return Math.toRadians((rotationAngle + 360 + 180) % 360) ;
		    }
		    
		    public double angleNormalization(double angleToBeNormalized) {
		    	return Math.toRadians((angleToBeNormalized + 360 +180) % 360);
		    }
		    /**
		     * update the car position as it is going straight need positionManipulationFormula(double startRightTurnX, double straightEndingX, double straightEndingY) before it to work properly
		     */
		    public void gasGoStraight(){
		      
		    	//System.out.print("gasGoStraight() ---> positionX : " + this.positionX + "\n ");
		    	positionX += distanceTraveledXaxis;
		    	positionY += distanceTraveledYaxis;
		    	
		    	
		    }
		    //*******************************************************************************************************************************************************************************************
		    /**
			 * called inside the rightTurn(double,double) function see javadoc comments for that function
			 * This function basically reorientate the rotationAngle as the angle of the car with respect to the Right Turn or Left Turn Circle changes 
			 * @param angleWithRespectToTheRightOrLeftTurnCircle
			 * @param rightOrLeftTurnSign --need to change depending on whether its making a left turn or a right turn, because the equation need defer only by this sign
			 */
			//update the rotationAngle by converting angleWithRespectToTheRightorLeftTurnCircle to the rotationAngle
			public void updateRotationAngle(double angleWithRespectToTheRightOrLeftTurnCircle, int rightOrLeftTurnSign) {
				 rotationAngle = angleWithRespectToTheRightOrLeftTurnCircle + rightOrLeftTurnSign * 90;
			    
				 
				 //normalize the rotationAngle
				 double normalizedRotationAngle = (rotationAngle + 360) % 360;
				 rotationAngle = normalizedRotationAngle;
				
		        
			}


			
			
			
			// return angleWithRespectToTheRightTurnCircle
			public double getAngleWithRespectToTheRightTurnCircle() {
				return angleWithRespectToTheRightTurnCircle;
			}

			/**
			 * Update the angleWithRepectToTheRightTurnCircle by converting the rotationAngle into angleWithRespectToTheRightTurnCircle
			 */
			public void setAngleWithRespectToTheRightTurnCircle() {
				this.angleWithRespectToTheRightTurnCircle = rotationAngle + 90;
				
				double normalizedAngleWithRespectToTheRightTurnCircle = (angleWithRespectToTheRightTurnCircle + 360) % 360;
				
				angleWithRespectToTheRightTurnCircle = normalizedAngleWithRespectToTheRightTurnCircle;
				
				
				
			}
			
			
			// return angleWithRespectToTheLeftTurnCircle
		    public double getAngleWithRespectToTheLeftTurnCircle() {
				return angleWithRespectToTheLeftTurnCircle;
			}
		    /**
		     * Update the angleWithRepectToTheLeftTurnCircle by converting the rotationAngle into angleWithRespectToTheLeftTurnCircle
		     */
			public void setAngleWithRespectToTheLeftTurnCircle() {
				this.angleWithRespectToTheLeftTurnCircle = rotationAngle - 90;
				
		        double normalizedAngleWithRespectToTheLeftTurnCircle = (angleWithRespectToTheLeftTurnCircle + 360) % 360;
				
				angleWithRespectToTheLeftTurnCircle = normalizedAngleWithRespectToTheLeftTurnCircle;
				
				
			}
			//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			
			/**
			 * 
			 * @return AngleOfTheArc --this property used for calculating the arcDistance traveled by the car
			 */
			public double getAngleOfTheArc() {
				return angleOfTheArc;
			}
		    /**
		     * Called inside the rightTurn(double,double) or leftTurn(double,double) function
		     * see Javadoc comment in rightTurn function for explanation
		     * Update angleOfTheArc -- parameter include radius and the exitAngle//the exitAngle is going to align with the rotation Angle when the car exit the circle
		     * you use a boolean to indicate that they are aligned and then you can do something else like gasGoStraight(), leftTurn() or RightTurn() 
		     * @param exitAngle
		     * @param radius
		     */
			//
			//
			public void setAngleOfTheArc(double exitAngle, double radius) {
				double proximityToExitAngleOfArc = exitAngle - rotationAngle;
				double proximityToExitArcDistance = proximityToExitAngleOfArc * Math.PI/180 * radius;
				
				if(Math.abs(proximityToExitArcDistance) < distanceAdjusted) {
					this.angleOfTheArc = Math.abs(proximityToExitAngleOfArc);
				}else {
					this.angleOfTheArc = distanceAdjusted/ radius * 180/Math.PI;
				}
			}
			//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			//arcLength --distance traveled by the car along the circular path
			public double getArcLength() {
					return arcLength;
			}
			
			//set the arcLength
			public void setArcLength(double arclength) {
					this.arcLength = arclength;
			}
				
			//return the rotationAngle(where the car is facing)
			public double getRotationAngle() {
				return rotationAngle;
			}

		    //set the rotationAngle
			public void setRotationAngle(double rotationAngle) {
				this.rotationAngle = rotationAngle;
			}
			//*****************************************************************************************************************************************************************************************************************************
			  
			

			//return distanceTraveledXaxis --use for when the car is going straight
			public double getDistanceTraveledXaxis() {
				return distanceTraveledXaxis;
			}

		    //set distanceTraveledXaxis
			public void setDistanceTraveledXaxis(double distanceTraveledXaxis) {
				this.distanceTraveledXaxis = distanceTraveledXaxis;
			}

			//return distanceTraveledYaxis --use for when the car is going straight
			public double getDistanceTraveledYaxis() {
				return distanceTraveledYaxis;
			}

			//set distanceTraveledYaxis
			public void setDistanceTraveledYaxis(double distanceTraveledYaxis) {
				this.distanceTraveledYaxis = distanceTraveledYaxis;
			}

			//return velocityWanted
			public double getVelocityWanted() {
				return velocityWanted;
			}

			//set velocityWanted
			public void setVelocityWanted(double velocityWanted) {
				this.velocityWanted = velocityWanted;
			}



			//return whereItsFacingPointOnThePerimeterX --use for the circle representing the car in place of a car sprite
			public double getWhereItsFacingPointOnThePerimeterX() {
				return whereItsFacingPointOnThePerimeterX;
			}

			//set whereItsFacingPointOnThePerimeterX
			public void setWhereItsFacingPointOnTheRadiusX(double whereItsFacingPointOnTheRadiusX) {
				this.whereItsFacingPointOnThePerimeterX = whereItsFacingPointOnTheRadiusX;
			}

			 //return whereItsFacingPointOnThePerimeterY --use for the circle representing the car in place of a car sprite
			public double getWhereItsFacingPointOnTheRadiusY() {
				return whereItsFacingPointOnThePerimeterY;
			}

			 //set whereItsFacingPointOnThePerimeterY 
			public void setWhereItsFacingPointOnTheRadiusY(double whereItsFacingPointOnTheRadiusY) {
				this.whereItsFacingPointOnThePerimeterY = whereItsFacingPointOnTheRadiusY;
			}
			//*************************************************************************************************************************************************************************************

			public abstract Node getCarImageView_P();

			public abstract Node getCarImageView_brake_P();

			public abstract Node getFront_R_BlinkerImageView_P();

			public abstract Node getRear_R_BlinkerImageView_P();

			public abstract Node getFront_L_BlinkerImageView_P();

			public abstract Node getRear_L_BlinkerImageView_P();

			public abstract Node getFront_R_BlinkerImageView2_P();

			public abstract Node getFront_L_BlinkerImageView2_P();

			public abstract Node getRear_R_BlinkerImageView2_P();

			public abstract Node getRear_L_BlinkerImageView2_P();

			public abstract Node getFront_R_BlinkerImageView3_P();

			public abstract Node getFront_L_BlinkerImageView3_P();

			public abstract Node getRear_R_BlinkerImageView3_P();

			public abstract Node getRear_L_BlinkerImageView3_P();
			
			public abstract void positionCarCorners();
			
			public abstract Circle[] getCarCornerCircle();
			
			public abstract void setCarCornerCircle();
			
			public abstract CarCornerCoordinate[] getCarCornerCoordinate();
			
			public abstract void drawCircleRpCorner (CarCornerCoordinate[] carCornerCoordinate);
}

