package intersectionsimcar.core;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;



public class Main extends Application {
//	private double circleX = 400;
//	private double circleY = 278.5;
	
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Traffic Light Coordinates
	public final static double  LEFTTORIGHTTRAFFICLIGHT_X = 710.5;// --> X-coordinate for Traffic Light (Direction: Left to right) 
	public final static double LEFTTORIGHTTRAFFICLIGHT_Y = 584.5; // --> Y-coordinate for Traffic Light (Direction: Left to right) 
	
	public final static double RIGHTTOLEFTTRAFFICLIGHT_X = 434.5;
	public final static double RIGHTTOLEFTTRAFFICLIGHT_Y = 208.5;
	
	public final static double TOPTOBOTTOMTRAFFICLIGHT_X = 760.5;
	public final static double TOPTOBOTTOMTRAFFICLIGHT_Y = 258.5;
	
	public final static double BOTTOMTOTOPTRAFFICLIGHT_X = 384.5;
	public final static double BOTTOMTOTOPTRAFFICLIGHT_Y = 534.5;
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
// Lane Information : Center of the Lane & Starting Point
	
	
	public final static double RIGHTTOLEFTCARRIGHTLANE_X = 318.5;//* <--  (Center of the "right lane" x-axis from the Right to the Left) 
	public final static double RIGHTTOLEFTCARRIGHTLANE_Y = 1173;//* <--   (Starting point Y "right lane" from the Right to the Left)
	public final static double RIGHTTOLEFTCARLEFTLANE_X = 357.5;//* <--   (Center of the "left lane" x-axis from the Right to the Left)
	public final static double RIGHTTOLEFTCARLEFTLANE_Y = 1173;//* <--    (Starting point Y "left lane" from the Right to the Left)
	
	
	public final static double  LEFTTORIGHTCARLEFTLANE_X = 435.5;//*--> 
	public final static double LEFTTORIGHTCARLEFTLANE_Y = -20;//*-->
	public final static double  LEFTTORIGHTCARRIGHTLANE_X = 474.5;//* -->
	public final static double LEFTTORIGHTCARRIGHTLANE_Y = -20;//*-->
	
	
	
	public final static double TOPTOBOTTOMCARRIGHTLANE_X = 494.5;//* v
	public final static double TOPTOBOTTOMCARRIGHTLANE_Y = -20;//*   v
	public final static double TOPTOBOTTOMCARLEFTLANE_X = 533.5;//*  v
	public final static double TOPTOBOTTOMCARLEFTLANE_Y = -20;//*    v
	
	
	public final static double BOTTOMTOTOPCARLEFTLANE_X = 611.5;//* ^
	public final static double BOTTOMTOTOPCARLEFTLANE_Y = 788;//* ^
	public final static double BOTTOMTOTOPCARRIGHTLANE_X = 650.5;//* ^
	public final static double BOTTOMTOTOPCARRIGHTLANE_Y = 788;//* ^
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	
	
	public static int trafficLightCounter = 0;
	public static boolean running = true;
	public LaneManagement laneManagement;
	/*public final static ObservableList<Car> headingDownRightLaneList = FXCollections.observableArrayList();
	public final static ObservableList<Car> headingDownLeftLaneList = FXCollections.observableArrayList();
	public final static ObservableList<Car> headingDownLTBLaneList = FXCollections.observableArrayList();
	
	public final static ObservableList<Car> headingUpRightLaneList = FXCollections.observableArrayList();
	public final static ObservableList<Car> headingUpLeftLaneList = FXCollections.observableArrayList();
	public final static ObservableList<Car> headingUpLTBLaneList = FXCollections.observableArrayList();
	
	public final static ObservableList<Car> headingLeftRightLaneList = FXCollections.observableArrayList();
	public final static ObservableList<Car> headingLeftLeftLaneList = FXCollections.observableArrayList();
	public final static ObservableList<Car> headingLeftLTBLaneList = FXCollections.observableArrayList();
	
	public final static ObservableList<Car> headingRightRightLaneList = FXCollections.observableArrayList();
	public final static ObservableList<Car> headingRightLeftLaneList = FXCollections.observableArrayList();
	public final static ObservableList<Car> headingRightLTBLaneList = FXCollections.observableArrayList();
	public final static ObservableList<Car> emptyList = FXCollections.observableArrayList();*/
	
	//***************************************************************************************************************************************************************************************************************
	private final ExecutorService executor = Executors.newFixedThreadPool(3);
	private final Object spawnLock = new Object();
	private ImageView trafficLightRedImageView;
	private  ImageView trafficLightRedImageView2;
	private ImageView trafficLightRedImageView3;
	private ImageView trafficLightRedImageView4;
	
	
	private  ImageView trafficLightYellowImageView;
	private  ImageView trafficLightYellowImageView2;
	private  ImageView trafficLightYellowImageView3;
	private  ImageView trafficLightYellowImageView4;
	
	private  ImageView trafficLightGreenImageView;
	private  ImageView trafficLightGreenImageView2;
	private  ImageView trafficLightGreenImageView3;
	private ImageView trafficLightGreenImageView4;
	//HeadedDownOrigCar car ; 
	public Main() {
		this.laneManagement = new LaneManagement();
	}
	
	
	
	//private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
	@Override
	public void start(Stage primaryStage) {
		 
		/*try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}*/
		
		
		
		primaryStage.setTitle("Rotate Car Off Center");
		Image intersectionImage = new Image(getClass().getResource("/Signal-lights-for-intersection-programOriginal/finished-background2.png").toExternalForm());
		BackgroundImage backgroundImage = new BackgroundImage(intersectionImage,
															  BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,
															  BackgroundPosition.DEFAULT,
															  BackgroundSize.DEFAULT);
		Pane root = new Pane();
		//-----------------------------------------------------------------------------------------------
		//LaneRegistry added 9:34PM 2025-05-22
		;
		
		root.setBackground(new Background(backgroundImage));
		Scene scene = new Scene (root, 1153, 768);
		primaryStage.setScene(scene);
		primaryStage.show();
		/*car =  new HeadedDownOrigCar(root, 
				   laneManagement,
				   TOPTOBOTTOMCARRIGHTLANE_X, 
				   -50);*/
		//Draw Line Map-------------------------------------------------------------------------------
		
		Line lineInBetweenCurbAndFirstorizontal = new Line();
		
		lineInBetweenCurbAndFirstorizontal.setStartX(0);
		lineInBetweenCurbAndFirstorizontal.setStartY(318.5);
		lineInBetweenCurbAndFirstorizontal.setEndX(1153);
		lineInBetweenCurbAndFirstorizontal.setEndY(318.5);
		
		lineInBetweenCurbAndFirstorizontal.setStroke(Color.GREEN);
		lineInBetweenCurbAndFirstorizontal.setStrokeWidth(2);
		
		//root.getChildren().add(lineInBetweenCurbAndFirstorizontal);//***********************
		
		Line firstDashLineFromTheTopHorizontal = new Line();
		
		firstDashLineFromTheTopHorizontal.setStartX(0);
		firstDashLineFromTheTopHorizontal.setStartY(338);
		firstDashLineFromTheTopHorizontal.setEndX(1153);
		firstDashLineFromTheTopHorizontal.setEndY(338);
		
		firstDashLineFromTheTopHorizontal.setStroke(Color.BLUE);
		firstDashLineFromTheTopHorizontal.setStrokeWidth(2);
		
		//root.getChildren().add(firstDashLineFromTheTopHorizontal);
		
		Line lineInBetweenFirstAndSecondHorizontal = new Line();
		
		lineInBetweenFirstAndSecondHorizontal.setStartX(0);
		lineInBetweenFirstAndSecondHorizontal.setStartY(357.5);
		lineInBetweenFirstAndSecondHorizontal.setEndX(1153);
		lineInBetweenFirstAndSecondHorizontal.setEndY(357.5);
		
		lineInBetweenFirstAndSecondHorizontal.setStroke(Color.AQUA);
		lineInBetweenFirstAndSecondHorizontal.setStrokeWidth(2);
		
		//root.getChildren().add(lineInBetweenFirstAndSecondHorizontal);//***********************
		
		Line secondDashLineFromTheTopHorizontal = new Line();
		
		secondDashLineFromTheTopHorizontal.setStartX(0);
		secondDashLineFromTheTopHorizontal.setStartY(377);
		secondDashLineFromTheTopHorizontal.setEndX(1153);
		secondDashLineFromTheTopHorizontal.setEndY(377);

		secondDashLineFromTheTopHorizontal.setStroke(Color.ORANGE);
		secondDashLineFromTheTopHorizontal.setStrokeWidth(2);
		
		//root.getChildren().add(secondDashLineFromTheTopHorizontal);
		
		Line lineInBetweenSecondAndThirdHorizontal = new Line();
		
		lineInBetweenSecondAndThirdHorizontal.setStartX(0);
		lineInBetweenSecondAndThirdHorizontal.setStartY(396.5);
		lineInBetweenSecondAndThirdHorizontal.setEndX(1153);
		lineInBetweenSecondAndThirdHorizontal.setEndY(396.5);
		
		lineInBetweenSecondAndThirdHorizontal.setStroke(Color.CORAL);
		lineInBetweenSecondAndThirdHorizontal.setStrokeWidth(2);
		
		//root.getChildren().add(lineInBetweenSecondAndThirdHorizontal);//***********************
		
		Line thirdDashLineFromTheTopHorizontal = new Line();
		
		thirdDashLineFromTheTopHorizontal.setStartX(0);
		thirdDashLineFromTheTopHorizontal.setStartY(416);
		thirdDashLineFromTheTopHorizontal.setEndX(1153);
		thirdDashLineFromTheTopHorizontal.setEndY(416);
		
		thirdDashLineFromTheTopHorizontal.setStroke(Color.ORANGE);
		thirdDashLineFromTheTopHorizontal.setStrokeWidth(2);
		
		//root.getChildren().add(thirdDashLineFromTheTopHorizontal);
		
		Line lineInBetweenThirdAndFourthHorizontal = new Line();
		
		lineInBetweenThirdAndFourthHorizontal.setStartX(0);
		lineInBetweenThirdAndFourthHorizontal.setStartY(435.5);
		lineInBetweenThirdAndFourthHorizontal.setEndX(1153);
		lineInBetweenThirdAndFourthHorizontal.setEndY(435.5);
		
		lineInBetweenThirdAndFourthHorizontal.setStroke(Color.AQUA);
		lineInBetweenThirdAndFourthHorizontal.setStrokeWidth(2);
		
		//root.getChildren().add(lineInBetweenThirdAndFourthHorizontal);//******************************
		
		Line fourthDashLineFromTheTopHorizontal = new Line();
		
		fourthDashLineFromTheTopHorizontal.setStartX(0);
		fourthDashLineFromTheTopHorizontal.setStartY(455);
		fourthDashLineFromTheTopHorizontal.setEndX(1153);
		fourthDashLineFromTheTopHorizontal.setEndY(455);
		
		fourthDashLineFromTheTopHorizontal.setStroke(Color.BLUE);
		fourthDashLineFromTheTopHorizontal.setStrokeWidth(2);
		
		//root.getChildren().add(fourthDashLineFromTheTopHorizontal);
		
		Line lineInBetweenFourthAndCurbHorizontal = new Line();
		
		lineInBetweenFourthAndCurbHorizontal.setStartX(0);
		lineInBetweenFourthAndCurbHorizontal.setStartY(474.5);
		lineInBetweenFourthAndCurbHorizontal.setEndX(1153);
		lineInBetweenFourthAndCurbHorizontal.setEndY(474.5);
		
		lineInBetweenFourthAndCurbHorizontal.setStroke(Color.GREEN);
		lineInBetweenFourthAndCurbHorizontal.setStrokeWidth(2);
		
		//root.getChildren().add(lineInBetweenFourthAndCurbHorizontal);//*******************************
		
		Line lineInBetweenCurbAndFirstVertical = new Line();
		
		lineInBetweenCurbAndFirstVertical.setStartX(494.5);
		lineInBetweenCurbAndFirstVertical.setStartY(0);
		lineInBetweenCurbAndFirstVertical.setEndX(494.5);
		lineInBetweenCurbAndFirstVertical.setEndY(768);
		
		lineInBetweenCurbAndFirstVertical.setStroke(Color.GREEN);
		lineInBetweenCurbAndFirstVertical.setStrokeWidth(2);
		
		//root.getChildren().add(lineInBetweenCurbAndFirstVertical);//*****************************
		
		Line firstDashLineFromTheLeftVertical = new Line();
		
		firstDashLineFromTheLeftVertical.setStartX(514);
		firstDashLineFromTheLeftVertical.setStartY(0);
		firstDashLineFromTheLeftVertical.setEndX(514);
		firstDashLineFromTheLeftVertical.setEndY(768);
		
		firstDashLineFromTheLeftVertical.setStroke(Color.BLUE);
		firstDashLineFromTheLeftVertical.setStrokeWidth(2);
		
		//root.getChildren().add(firstDashLineFromTheLeftVertical);
		
		Line lineInBetweenFirstAndSecondVertical = new Line();
		
		lineInBetweenFirstAndSecondVertical.setStartX(533.5);
		lineInBetweenFirstAndSecondVertical.setStartY(0);
		lineInBetweenFirstAndSecondVertical.setEndX(533.5);
		lineInBetweenFirstAndSecondVertical.setEndY(768);
		
		lineInBetweenFirstAndSecondVertical.setStroke(Color.CORAL);
		lineInBetweenFirstAndSecondVertical.setStrokeWidth(2);
		
		//root.getChildren().add(lineInBetweenFirstAndSecondVertical);//**************************
		
		Line secondDashLineFromTheLeftVertical = new Line();
		
		secondDashLineFromTheLeftVertical.setStartX(553);
		secondDashLineFromTheLeftVertical.setStartY(0);
		secondDashLineFromTheLeftVertical.setEndX(553);
		secondDashLineFromTheLeftVertical.setEndY(768);
		
		secondDashLineFromTheLeftVertical.setStroke(Color.YELLOW);
		secondDashLineFromTheLeftVertical.setStrokeWidth(2);
		
		//root.getChildren().add(secondDashLineFromTheLeftVertical);
		
		Line lineInBetweenSecondAndThirdVertical = new Line();
		
		lineInBetweenSecondAndThirdVertical.setStartX(572.5);
		lineInBetweenSecondAndThirdVertical.setStartY(0);
		lineInBetweenSecondAndThirdVertical.setEndX(572.5);
		lineInBetweenSecondAndThirdVertical.setEndY(768);
		
		lineInBetweenSecondAndThirdVertical.setStroke(Color.AQUA);
		lineInBetweenSecondAndThirdVertical.setStrokeWidth(2);
		
		//root.getChildren().add(lineInBetweenSecondAndThirdVertical);//****************************
		
		Line thirdDashLineFromTheLeftVertical = new Line();
		
		thirdDashLineFromTheLeftVertical.setStartX(592);
		thirdDashLineFromTheLeftVertical.setStartY(0);
		thirdDashLineFromTheLeftVertical.setEndX(592);
		thirdDashLineFromTheLeftVertical.setEndY(768);
		
		thirdDashLineFromTheLeftVertical.setStroke(Color.YELLOW);
		thirdDashLineFromTheLeftVertical.setStrokeWidth(2);
		
		//root.getChildren().add(thirdDashLineFromTheLeftVertical);
		
		Line lineInBetweenThirdAndFourthVertical = new Line();
		
		lineInBetweenThirdAndFourthVertical.setStartX(611.5);
		lineInBetweenThirdAndFourthVertical.setStartY(0);
		lineInBetweenThirdAndFourthVertical.setEndX(611.5);
		lineInBetweenThirdAndFourthVertical.setEndY(768);
		
		lineInBetweenThirdAndFourthVertical.setStroke(Color.CORAL);
		lineInBetweenThirdAndFourthVertical.setStrokeWidth(2);
		
		//root.getChildren().add(lineInBetweenThirdAndFourthVertical);//*******************
		
		Line fourthDashLineFromTheLeftVertical = new Line();
		
		fourthDashLineFromTheLeftVertical.setStartX(631);
		fourthDashLineFromTheLeftVertical.setStartY(0);
		fourthDashLineFromTheLeftVertical.setEndX(631);
		fourthDashLineFromTheLeftVertical.setEndY(768);
		
		fourthDashLineFromTheLeftVertical.setStroke(Color.BLUE);
		fourthDashLineFromTheLeftVertical.setStrokeWidth(2);
		
		//root.getChildren().add(fourthDashLineFromTheLeftVertical);
		
		Line lineInBetweenFourthAndCurbVertical = new Line();
		
		lineInBetweenFourthAndCurbVertical.setStartX(650.5);
		lineInBetweenFourthAndCurbVertical.setStartY(0);
		lineInBetweenFourthAndCurbVertical.setEndX(650.5);
		lineInBetweenFourthAndCurbVertical.setEndY(768);
		
		lineInBetweenFourthAndCurbVertical.setStroke(Color.GREEN);
		lineInBetweenFourthAndCurbVertical.setStrokeWidth(2);
		
		//root.getChildren().add(lineInBetweenFourthAndCurbVertical);//****************
		
		
		
		Image trafficLightRedImage = new Image(getClass().getResource("/Signal-lights-for-intersection-programOriginal/red_small.png").toExternalForm());
		Image trafficLightYellowImage = new Image(getClass().getResource("/Signal-lights-for-intersection-programOriginal/yellow_small.png").toExternalForm());
		Image trafficLightGreenImage = new Image(getClass().getResource("/Signal-lights-for-intersection-programOriginal/green_small.png").toExternalForm());
		ImageView trafficLightTemplateImageView = new ImageView(trafficLightRedImage);
		
		trafficLightTemplateImageView.setFitWidth(41);
		trafficLightTemplateImageView.setPreserveRatio(true);
		
		
		double trafficLightTemplateWidth = trafficLightRedImage.getWidth();
		double trafficLightTemplateHeight = trafficLightRedImage.getHeight();
		
		double trafficLightTemplateImageCenterX = trafficLightTemplateWidth / 2;
		double trafficLightTemplateImageCenterY = trafficLightTemplateHeight / 2;
		
		this.trafficLightRedImageView = new ImageView(trafficLightRedImage);
		
		this.trafficLightRedImageView2 = new ImageView(trafficLightRedImage);
		
		this.trafficLightRedImageView3 = new ImageView(trafficLightRedImage);
		
		this.trafficLightRedImageView4 = new ImageView(trafficLightRedImage);
		
		trafficLightRedImageView.setFitWidth(41);
		trafficLightRedImageView.setPreserveRatio(true);
		trafficLightRedImageView2.setFitWidth(41);
		trafficLightRedImageView2.setPreserveRatio(true);
		trafficLightRedImageView3.setFitWidth(41);
		trafficLightRedImageView3.setPreserveRatio(true);
		trafficLightRedImageView4.setFitWidth(41);
		trafficLightRedImageView4.setPreserveRatio(true);
		
		
		
		this.trafficLightYellowImageView = new ImageView(trafficLightYellowImage);
		
		this.trafficLightYellowImageView2 = new ImageView(trafficLightYellowImage);
        
		this.trafficLightYellowImageView3 = new ImageView(trafficLightYellowImage);
        
		this.trafficLightYellowImageView4 = new ImageView(trafficLightYellowImage);
        
        trafficLightYellowImageView.setFitWidth(41);
		trafficLightYellowImageView.setPreserveRatio(true);
		trafficLightYellowImageView2.setFitWidth(41);
		trafficLightYellowImageView2.setPreserveRatio(true);
		trafficLightYellowImageView3.setFitWidth(41);
		trafficLightYellowImageView3.setPreserveRatio(true);
		trafficLightYellowImageView4.setFitWidth(41);
		trafficLightYellowImageView4.setPreserveRatio(true);



		
		
		
		this.trafficLightGreenImageView = new ImageView(trafficLightGreenImage);
		
		this.trafficLightGreenImageView2 = new ImageView(trafficLightGreenImage);
		
		this.trafficLightGreenImageView3 = new ImageView(trafficLightGreenImage);
		
		this.trafficLightGreenImageView4 = new ImageView(trafficLightGreenImage);		
		
		trafficLightGreenImageView.setFitWidth(41);
		trafficLightGreenImageView.setPreserveRatio(true);
		trafficLightGreenImageView2.setFitWidth(41);
		trafficLightGreenImageView2.setPreserveRatio(true);
		trafficLightGreenImageView3.setFitWidth(41);
		trafficLightGreenImageView3.setPreserveRatio(true);
		trafficLightGreenImageView4.setFitWidth(41);
		trafficLightGreenImageView4.setPreserveRatio(true);
		
		
		
		trafficLightPlacement(root, trafficLightRedImageView, 90,  LEFTTORIGHTTRAFFICLIGHT_X, LEFTTORIGHTTRAFFICLIGHT_Y, trafficLightTemplateImageCenterX, trafficLightTemplateImageCenterY);
		trafficLightPlacement(root, trafficLightRedImageView2,  270, RIGHTTOLEFTTRAFFICLIGHT_X, RIGHTTOLEFTTRAFFICLIGHT_Y, trafficLightTemplateImageCenterX, trafficLightTemplateImageCenterY);
		trafficLightPlacement(root, trafficLightRedImageView3, 0, TOPTOBOTTOMTRAFFICLIGHT_X, TOPTOBOTTOMTRAFFICLIGHT_Y, trafficLightTemplateImageCenterX, trafficLightTemplateImageCenterY);
		trafficLightPlacement(root, trafficLightRedImageView4, 180, BOTTOMTOTOPTRAFFICLIGHT_X, BOTTOMTOTOPTRAFFICLIGHT_Y, trafficLightTemplateImageCenterX, trafficLightTemplateImageCenterY);
		
		trafficLightPlacement(root, trafficLightYellowImageView, 90,  LEFTTORIGHTTRAFFICLIGHT_X, LEFTTORIGHTTRAFFICLIGHT_Y, trafficLightTemplateImageCenterX, trafficLightTemplateImageCenterY);
		trafficLightPlacement(root, trafficLightYellowImageView2,  270, RIGHTTOLEFTTRAFFICLIGHT_X, RIGHTTOLEFTTRAFFICLIGHT_Y, trafficLightTemplateImageCenterX, trafficLightTemplateImageCenterY);
		trafficLightPlacement(root, trafficLightYellowImageView3, 0, TOPTOBOTTOMTRAFFICLIGHT_X, TOPTOBOTTOMTRAFFICLIGHT_Y, trafficLightTemplateImageCenterX, trafficLightTemplateImageCenterY);
		trafficLightPlacement(root, trafficLightYellowImageView4, 180, BOTTOMTOTOPTRAFFICLIGHT_X, BOTTOMTOTOPTRAFFICLIGHT_Y, trafficLightTemplateImageCenterX, trafficLightTemplateImageCenterY);
		
		trafficLightPlacement(root, trafficLightGreenImageView, 90,  LEFTTORIGHTTRAFFICLIGHT_X, LEFTTORIGHTTRAFFICLIGHT_Y, trafficLightTemplateImageCenterX, trafficLightTemplateImageCenterY);
		trafficLightPlacement(root, trafficLightGreenImageView2,  270, RIGHTTOLEFTTRAFFICLIGHT_X, RIGHTTOLEFTTRAFFICLIGHT_Y, trafficLightTemplateImageCenterX, trafficLightTemplateImageCenterY);
		trafficLightPlacement(root, trafficLightGreenImageView3, 0, TOPTOBOTTOMTRAFFICLIGHT_X, TOPTOBOTTOMTRAFFICLIGHT_Y, trafficLightTemplateImageCenterX, trafficLightTemplateImageCenterY);
		trafficLightPlacement(root, trafficLightGreenImageView4, 180, BOTTOMTOTOPTRAFFICLIGHT_X, BOTTOMTOTOPTRAFFICLIGHT_Y, trafficLightTemplateImageCenterX, trafficLightTemplateImageCenterY);
		//---------------------------------------------------------------------------------------------------
		//carObjectList.add(new Car(root,new Circle()));
		//*************************************************************************************************************************************************
		//SPAWN CAR THREAD DEAL WITH IT LATER
		
		executor.submit((Runnable)() -> {
            
            while (!Thread.currentThread().isInterrupted()) {
            	 try {
                     
	            	Random random = new Random();
	     		   	int randIn = random.nextInt(1000) + 500;
	     		   	Thread.sleep(randIn);
	     		   	
	     		   	Platform.runLater((Runnable)()->{spawnCars(root, laneManagement,
	     		   											   TOPTOBOTTOMCARRIGHTLANE_X, 
	     		   											   TOPTOBOTTOMCARRIGHTLANE_Y 
	     		   											   );});
	            	
            	 }catch (InterruptedException e) {
            		 Thread.currentThread().interrupt();
            	 }
            }
        });
		//SPAWN CAR THREAD ENDS
		//************************************************************************************************************************************************
		
		executor.submit((Runnable)() -> {
            
            while (!Thread.currentThread().isInterrupted()) {
            	 try {
                     
	            	Random random = new Random();
	     		   	int randIn = random.nextInt(1400) + 1400;
	     		   	Thread.sleep(randIn);
	     		   	synchronized(spawnLock) {
		     		   	Platform.runLater((Runnable)()->{
		     		   										if( laneManagement.getHeadingDownLeftLaneList() != null && laneManagement.getHeadingDownLeftLaneList().size() < 1) {
			     		   									
		     		   											spawnCars(root, laneManagement,
			     		   			                                   TOPTOBOTTOMCARLEFTLANE_X, 
			     		   			                                   TOPTOBOTTOMCARLEFTLANE_Y 
			     		   			                                   );
		     		   										}
		     		   									});
	     		   	}
            	 }catch (InterruptedException e) {
            		 Thread.currentThread().interrupt();
            	 }
            }
        });
		//********************************************************************************************************************************************
		// Thread for Removing Cars
		
        executor.submit((Runnable) () -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(1); // Simulate delay
                    
                    Platform.runLater(()->{
                    	deleteCar(root,laneManagement.getHeadingDownLeftLaneList());
                    	
                	    deleteCar(root,laneManagement.getHeadingDownRightLaneList());
                	});	
                    	
                    
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        
        //Thread for Removing Cars Ends
        //************************************************************************************************************************************************
	
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(15), e ->{
			
			//********************************************************************************************************************************************
			//Car Operation Stuff
			
		
				for(IntersectionSimCar car : laneManagement.getHeadingDownLeftLaneList()) {
				((IntersectionSimCar)car).carOperation();
				}
			
			
			
				for(IntersectionSimCar car : laneManagement.getHeadingDownRightLaneList()) {
				((IntersectionSimCar)car).carOperation();
				}
			
			//car.carOperation(root);
			//Car Operation Stuff Ends
			//**********************************************************************************************************************************************
			
	           
		   // car.carOperation(root);
			
			
		}),
				
				/*new KeyFrame(Duration.millis(16), e ->{
			//this.setCircleX();
			
			
			circleCar1.getCircle_p().setTranslateX(circleCar1.getPositionX());
			circleCar1.getCircle_p().setTranslateY(circleCar1.getPositionY());
			//System.out.println(circleCar1.getPositionY());
		    carWhereItsFacingIndicator.setStartX(circleCar1.getPositionX());
		    carWhereItsFacingIndicator.setStartY(circleCar1.getPositionY());
		    carWhereItsFacingIndicator.setEndX(circleCar1.getWhereItsFacingPointOnTheRadiusX());
		    carWhereItsFacingIndicator.setEndY(circleCar1.getWhereItsFacingPointOnTheRadiusY());
		    carWhereItsFacingIndicator.setStroke(Color.RED);
		    carWhereItsFacingIndicator.setStrokeWidth(3);
		    
		   
		   
		})),*/new KeyFrame(Duration.millis(15), e ->{
			boolean redLightOn = true;
			boolean redLightOff = false;
			boolean yellowLightOn = true;
			boolean yellowLightOff = false;
			boolean greenLightOn = true;
			boolean greenLightOff = false;
			
			trafficLightCounter++;
			if(trafficLightCounter >= 1 & trafficLightCounter <125) {
				
				headingRighOrLeftTrafficLightState(redLightOn, yellowLightOff,greenLightOff);
				headingUpOrDownTrafficLightState(redLightOn, yellowLightOff, greenLightOff);
				/*trafficLightSignal_Alert_For_All_List(headingDownRightLaneList,
													  headingDownLeftLaneList,
													  headingDownLTBLaneList,
													  headingUpRightLaneList,
													  headingUpLeftLaneList,
													  headingUpLTBLaneList,
													  headingLeftRightLaneList,
													  headingLeftLeftLaneList,
													  headingLeftLTBLaneList,
													  headingRightRightLaneList,
													  headingRightLeftLaneList,
													  headingRightLTBLaneList,
													  CircleRpCar.TrafficLightSignal.HEADING_LEFTRIGHT_RED_UPDOWN_RED);*/
				
			}else if (trafficLightCounter >= 125 & trafficLightCounter <1063){//938
				
				
				headingRighOrLeftTrafficLightState(redLightOn, yellowLightOff,greenLightOff);
				headingUpOrDownTrafficLightState(redLightOff, yellowLightOff, greenLightOn);
				/*trafficLightSignal_Alert_For_All_List(headingDownRightLaneList,
						  headingDownLeftLaneList,
						  headingDownLTBLaneList,
						  headingUpRightLaneList,
						  headingUpLeftLaneList,
						  headingUpLTBLaneList,
						  headingLeftRightLaneList,
						  headingLeftLeftLaneList,
						  headingLeftLTBLaneList,
						  headingRightRightLaneList,
						  headingRightLeftLaneList,
						  headingRightLTBLaneList,
						  CircleRpCar.TrafficLightSignal.HEADING_UPDOWN_GREEN_LEFTRIGHT_RED);*/
				
			}else if (trafficLightCounter >= 1063 & trafficLightCounter <1313){//250
				
				headingRighOrLeftTrafficLightState(redLightOn, yellowLightOff,greenLightOff);
				headingUpOrDownTrafficLightState(redLightOff, yellowLightOn, greenLightOff);
				/*trafficLightSignal_Alert_For_All_List(headingDownRightLaneList,
						  headingDownLeftLaneList,
						  headingDownLTBLaneList,
						  headingUpRightLaneList,
						  headingUpLeftLaneList,
						  headingUpLTBLaneList,
						  headingLeftRightLaneList,
						  headingLeftLeftLaneList,
						  headingLeftLTBLaneList,
						  headingRightRightLaneList,
						  headingRightLeftLaneList,
						  headingRightLTBLaneList,
						  CircleRpCar.TrafficLightSignal.HEADING_UPDOWN_YELLOW_H1_LEFTRIGHT_RED);*/
			
			}else if (trafficLightCounter >= 1313 & trafficLightCounter <1438){
				
				headingRighOrLeftTrafficLightState(redLightOn, yellowLightOff,greenLightOff);
				headingUpOrDownTrafficLightState(redLightOff, yellowLightOn, greenLightOff);
				/*trafficLightSignal_Alert_For_All_List(headingDownRightLaneList,
						  headingDownLeftLaneList,
						  headingDownLTBLaneList,
						  headingUpRightLaneList,
						  headingUpLeftLaneList,
						  headingUpLTBLaneList,
						  headingLeftRightLaneList,
						  headingLeftLeftLaneList,
						  headingLeftLTBLaneList,
						  headingRightRightLaneList,
						  headingRightLeftLaneList,
						  headingRightLTBLaneList,
						  CircleRpCar.TrafficLightSignal.HEADING_UPDOWN_YELLOW_H2_LEFTRIGHT_RED);*/
			
			}else if (trafficLightCounter >= 1438 & trafficLightCounter <1563){
				
				headingRighOrLeftTrafficLightState(redLightOn, yellowLightOff,greenLightOff);
				headingUpOrDownTrafficLightState(redLightOn, yellowLightOff, greenLightOff);
				/*trafficLightSignal_Alert_For_All_List(headingDownRightLaneList,
						  headingDownLeftLaneList,
						  headingDownLTBLaneList,
						  headingUpRightLaneList,
						  headingUpLeftLaneList,
						  headingUpLTBLaneList,
						  headingLeftRightLaneList,
						  headingLeftLeftLaneList,
						  headingLeftLTBLaneList,
						  headingRightRightLaneList,
						  headingRightLeftLaneList,
						  headingRightLTBLaneList,
						  CircleRpCar.TrafficLightSignal.HEADING_LEFTRIGHT_RED_UPDOWN_RED);*/
				
			}else if (trafficLightCounter >= 1563 & trafficLightCounter <2501){
			
				headingRighOrLeftTrafficLightState(redLightOff, yellowLightOff,greenLightOn);
				headingUpOrDownTrafficLightState(redLightOn, yellowLightOff, greenLightOff);
				/*trafficLightSignal_Alert_For_All_List(headingDownRightLaneList,
						  headingDownLeftLaneList,
						  headingDownLTBLaneList,
						  headingUpRightLaneList,
						  headingUpLeftLaneList,
						  headingUpLTBLaneList,
						  headingLeftRightLaneList,
						  headingLeftLeftLaneList,
						  headingLeftLTBLaneList,
						  headingRightRightLaneList,
						  headingRightLeftLaneList,
						  headingRightLTBLaneList,
						  CircleRpCar.TrafficLightSignal.HEADING_LEFTRIGHT_GREEN_UPDOWN_RED);*/
			
			}else if (trafficLightCounter >= 2501 & trafficLightCounter <2751){
			
				headingRighOrLeftTrafficLightState(redLightOff, yellowLightOn,greenLightOff);
				headingUpOrDownTrafficLightState(redLightOn, yellowLightOff, greenLightOff);
				/*trafficLightSignal_Alert_For_All_List(headingDownRightLaneList,
						  headingDownLeftLaneList,
						  headingDownLTBLaneList,
						  headingUpRightLaneList,
						  headingUpLeftLaneList,
						  headingUpLTBLaneList,
						  headingLeftRightLaneList,
						  headingLeftLeftLaneList,
						  headingLeftLTBLaneList,
						  headingRightRightLaneList,
						  headingRightLeftLaneList,
						  headingRightLTBLaneList,
						  CircleRpCar.TrafficLightSignal.HEADING_LEFTRIGHT_YELLOW_H1_UPDOWN_RED);*/
				
			}else if (trafficLightCounter >= 2751 & trafficLightCounter <2876){
			
				headingRighOrLeftTrafficLightState(redLightOff, yellowLightOn,greenLightOff);
				headingUpOrDownTrafficLightState(redLightOn, yellowLightOff, greenLightOff);
				/*trafficLightSignal_Alert_For_All_List(headingDownRightLaneList,
						  headingDownLeftLaneList,
						  headingDownLTBLaneList,
						  headingUpRightLaneList,
						  headingUpLeftLaneList,
						  headingUpLTBLaneList,
						  headingLeftRightLaneList,
						  headingLeftLeftLaneList,
						  headingLeftLTBLaneList,
						  headingRightRightLaneList,
						  headingRightLeftLaneList,
						  headingRightLTBLaneList,
						  CircleRpCar.TrafficLightSignal.HEADING_LEFTRIGHT_YELLOW_H2_UPDOWN_RED);*/
				
				trafficLightCounter = 0;
			}
			
			
		}));
	
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
		
		//bor law--------------------------------------------------------
		
		//timeline.setCycleCount(Timeline.INDEFINITE);
		//timeline.play();
		//-----------------------------------------------------------------------------
		
		//Circle mapCircle = new Circle();
		//root.getChildren().add(mapCircle);
		//Event handler for mouse movement on the scene
		scene.setOnMouseMoved((MouseEvent event)-> {
			
			double x = event.getSceneX();
			double y = event.getSceneY();
			/*if(x >= 572.5) {
				
				mapCircle.setRadius( x - 572.5  );
				mapCircle.setFill(null);
				mapCircle.setStroke(Color.RED);
				mapCircle.setStrokeWidth(2);
				mapCircle.setTranslateX(x);
				mapCircle.setTranslateY(y);
			}*/
			
			//System.out.println("Cursor location: X=" + x + ", Y=" + y);
		});
		
		//Circle Map-------------------------------------------------------------------------------------------------
		
		Circle topMakeRight = new Circle();
		
		topMakeRight.setCenterX(391);
		topMakeRight.setCenterY(215);
		topMakeRight.setRadius(103.5);
		topMakeRight.setFill(null);
		topMakeRight.setStroke(Color.RED);
		topMakeRight.setStrokeWidth(2);
		//root.getChildren().add(topMakeRight);
		
		Circle topMakeLeft = new Circle();
		
		topMakeLeft.setCenterX(710.5);
		topMakeLeft.setCenterY(297.5);
		topMakeLeft.setRadius(138);
		topMakeLeft.setFill(null);
		topMakeLeft.setStroke(Color.AQUA);
		topMakeLeft.setStrokeWidth(2);
		//root.getChildren().add(topMakeLeft);
		
		Circle bottomMakeRight = new Circle();
		
		bottomMakeRight.setCenterX(754);
		bottomMakeRight.setCenterY(578);
		bottomMakeRight.setRadius(103.5);
		bottomMakeRight.setFill(null);
		bottomMakeRight.setStroke(Color.RED);
		bottomMakeRight.setStrokeWidth(2);
		//root.getChildren().add(bottomMakeRight);
		
		Circle bottomMakeLeft = new Circle();
		
		bottomMakeLeft.setCenterX(434.5);
		bottomMakeLeft.setCenterY(495.5);
		bottomMakeLeft.setRadius(138);
		bottomMakeLeft.setFill(null);
		bottomMakeLeft.setStroke(Color.AQUA);
		bottomMakeLeft.setStrokeWidth(2);
		//root.getChildren().add(bottomMakeLeft);
		
		Circle leftMakeRight = new Circle();
		
		leftMakeRight.setCenterX(391);
		leftMakeRight.setCenterY(578);
		leftMakeRight.setRadius(103.5);
		leftMakeRight.setFill(null);
		leftMakeRight.setStroke(Color.RED);
		leftMakeRight.setStrokeWidth(2);
		//root.getChildren().add(leftMakeRight);
		
		Circle leftMakeLeft = new Circle();
		
		leftMakeLeft.setCenterX(473.5);
		leftMakeLeft.setCenterY(258.5);
		leftMakeLeft.setRadius(138);
		leftMakeLeft.setFill(null);
		leftMakeLeft.setStroke(Color.CORAL);
		leftMakeLeft.setStrokeWidth(2);
		//root.getChildren().add(leftMakeLeft);
		
		Circle rightMakeRight = new Circle();		
		
		rightMakeRight.setCenterX(754);
		rightMakeRight.setCenterY(215);
		rightMakeRight.setRadius(103.5);
		rightMakeRight.setFill(null);
		rightMakeRight.setStroke(Color.RED);
		rightMakeRight.setStrokeWidth(2);
		//root.getChildren().add(rightMakeRight);
		
		
		
		Circle rightMakeLeft = new Circle();
		
		rightMakeLeft.setCenterX(671.5);
		rightMakeLeft.setCenterY(534.5);
		rightMakeLeft.setRadius(138);
		rightMakeLeft.setFill(null);
		rightMakeLeft.setStroke(Color.CORAL);
		rightMakeLeft.setStrokeWidth(2);
		//root.getChildren().add(rightMakeLeft);
		
		//Circle Map Ends-------------------------------------------------------------------------------------------------------
		
	
		primaryStage.setOnCloseRequest(event -> {
           timeline.stop();
           executor.shutdown();
            Platform.exit();
        });
	}
	
	public void headingRighOrLeftTrafficLightState(boolean redLightOnOff, boolean yellowLightOnOff, boolean greenLightOnOff) {
		trafficLightRedImageView.setVisible(redLightOnOff);
		trafficLightRedImageView2.setVisible(redLightOnOff);
		trafficLightYellowImageView.setVisible(yellowLightOnOff);
		trafficLightYellowImageView2.setVisible(yellowLightOnOff);
		trafficLightGreenImageView.setVisible(greenLightOnOff);
		trafficLightGreenImageView2.setVisible(greenLightOnOff);
	}
	
	public void headingUpOrDownTrafficLightState(boolean redLightOnOff, boolean yellowLightOnOff, boolean greenLightOnOff) {
		trafficLightRedImageView3.setVisible(redLightOnOff);
		trafficLightRedImageView4.setVisible(redLightOnOff);
		trafficLightYellowImageView3.setVisible(yellowLightOnOff);
		trafficLightYellowImageView4.setVisible(yellowLightOnOff);
		trafficLightGreenImageView3.setVisible(greenLightOnOff);
		trafficLightGreenImageView4.setVisible(greenLightOnOff);
	}
	
	public void trafficLightPlacement(Pane root, ImageView trafficLightImageView, double imageViewAngle , double x_Coordinate, double y_Coordinate, double trafficLightImageCenterX, double trafficLightImageCenterY ) {
		
		
		root.getChildren().add(trafficLightImageView);
		
		double calculatedLayoutTrafficLightCenterPointX = x_Coordinate - trafficLightImageCenterX;
		double calculatedLayoutTrafficLightCenterPointY = y_Coordinate - trafficLightImageCenterY;
		
		trafficLightImageView.setLayoutX(x_Coordinate);
		trafficLightImageView.setLayoutY(y_Coordinate);
		
		Translate translateToPivot = new Translate(-x_Coordinate, -y_Coordinate);
		
		
		Rotate rotate = new Rotate (imageViewAngle, x_Coordinate, y_Coordinate);
		
		Translate backToPosition = new Translate(calculatedLayoutTrafficLightCenterPointX, calculatedLayoutTrafficLightCenterPointY);
		
		trafficLightImageView.getTransforms().clear();
		trafficLightImageView.getTransforms().addAll(translateToPivot, rotate, backToPosition);
		
		
	}
	//*****************************************************************************************************************************************************************************************
	//TRAFFIC SIGNAL LIGHT ALERT FOR ALL LIST FUNCTION PROBABLY GONNA HAVE TO ASSOCIATE THIS WITH THE LANEREGISTRY LATER ON
	
	/*public void trafficLightSignal_Alert_For_All_List (ObservableList<Car> headingDownRightLaneList_A, 
			  ObservableList<Car> headingDownLeftLaneList_A,
			  ObservableList<Car> headingDownLTBLaneList_A,
		      ObservableList<Car> headingUpRightLaneList_A, 
			  ObservableList<Car> headingUpLeftLaneList_A,
			  ObservableList<Car> headingUpLTBLaneList_A,
			  ObservableList<Car> headingLeftRightLaneList_A, 
			  ObservableList<Car> headingLeftLeftLaneList_A,
			  ObservableList<Car> headingLeftLTBLaneList_A,
			  ObservableList<Car> headingRightRightLaneList_A, 
			  ObservableList<Car> headingRightLeftLaneList_A,
			  ObservableList<Car> headingRightLTBLaneList_A, CircleRpCar.TrafficLightSignal trafficLightSignal) {
		
		trafficLightSignal_alert(headingDownLeftLaneList_A, trafficLightSignal);
		trafficLightSignal_alert(headingDownRightLaneList_A, trafficLightSignal);
		trafficLightSignal_alert(headingDownLTBLaneList_A, trafficLightSignal);
		
		trafficLightSignal_alert(headingUpLeftLaneList_A, trafficLightSignal);
		trafficLightSignal_alert(headingUpRightLaneList_A, trafficLightSignal);
		trafficLightSignal_alert(headingUpLTBLaneList_A, trafficLightSignal);
		
		trafficLightSignal_alert(headingRightLeftLaneList_A, trafficLightSignal);
		trafficLightSignal_alert(headingRightRightLaneList_A, trafficLightSignal);
		trafficLightSignal_alert(headingRightLTBLaneList_A, trafficLightSignal);
		
		trafficLightSignal_alert(headingLeftLeftLaneList_A, trafficLightSignal);
		trafficLightSignal_alert(headingLeftRightLaneList_A, trafficLightSignal);
		trafficLightSignal_alert(headingLeftLTBLaneList_A, trafficLightSignal);
		
	}*/
	//TRAFFIC SIGNAL LIGHT ALERT FOR ALL LIST FUNCTION ENDS
	//*******************************************************************************************************************************************************************************************************
	//TRAFFIC LIGHT SIGNAL FUNCTION
	/*
	public void trafficLightSignal_alert(ObservableList<Car> cars, CircleRpCar.TrafficLightSignal trafficLightSignal) {
		if(cars == null || cars.isEmpty()) {
			return;
		}else {
			for (Car car : cars) {
				car.trafficLightSignal = trafficLightSignal;
			}
		}
		
	}*/
	//TRAFFIC LIGHT SIGNAL FUNCTION ENDS
	
	//**********************************************************************************************************************************************************************************************************
	public void spawnCars(Pane root,
	                      LaneManagement laneManagement, 
						  double carLaneX, 
						  double carLaneY) {
		
		
		   
			
			Platform.runLater(() -> {
				
				

				 //PauseTransition delay = new PauseTransition(Duration.seconds(3));
					 //System.out.println("OnWhichLane: " +  car.getCar_P().getOnWhichLaneListKey() + " ObservableList: " + car.getCar_P().getObservableListCarIsOn().contains(car));
			
					 //delay.setOnFinished(event -> {
						 IntersectionSimCar car =  new HeadedDownOrigCar(root, 
								   laneManagement,
								   carLaneX, 
								   carLaneY);
				
				   
				 
				  	root.getChildren().add(car.getCarImageView_P());
					root.getChildren().add(car.getCarImageView_brake_P());
					car.getCarImageView_brake_P().setVisible(true);
					car.getCarImageView_P().setVisible(false);
					
					
					root.getChildren().add(car.getFront_R_BlinkerImageView_P());
					root.getChildren().add(car.getFront_L_BlinkerImageView_P());
					root.getChildren().add(car.getRear_R_BlinkerImageView_P());
					root.getChildren().add(car.getRear_L_BlinkerImageView_P());
					root.getChildren().add(car.getFront_R_BlinkerImageView2_P());
					root.getChildren().add(car.getFront_L_BlinkerImageView2_P());
					root.getChildren().add(car.getRear_R_BlinkerImageView2_P());
					root.getChildren().add(car.getRear_L_BlinkerImageView2_P());
					root.getChildren().add(car.getFront_R_BlinkerImageView3_P());
					root.getChildren().add(car.getFront_L_BlinkerImageView3_P());
					root.getChildren().add(car.getRear_R_BlinkerImageView3_P());
					root.getChildren().add(car.getRear_L_BlinkerImageView3_P());
					car.getFront_R_BlinkerImageView_P().setVisible(false);
					car.getFront_L_BlinkerImageView_P().setVisible(false);
					car.getRear_R_BlinkerImageView_P().setVisible(false);
					car.getRear_L_BlinkerImageView_P().setVisible(false);
					car.getFront_R_BlinkerImageView2_P().setVisible(true);
					car.getFront_L_BlinkerImageView2_P().setVisible(true);
					car.getRear_R_BlinkerImageView2_P().setVisible(true);
					car.getRear_L_BlinkerImageView2_P().setVisible(true);
					car.getFront_R_BlinkerImageView3_P().setVisible(false);
					car.getFront_L_BlinkerImageView3_P().setVisible(false);
					car.getRear_R_BlinkerImageView3_P().setVisible(false);
					car.getRear_L_BlinkerImageView3_P().setVisible(false);
					
					
				
					

						car.drawCircleRpCorner(car.getCarCornerCoordinate());
						if (car.getCarCornerCircle() != null && car.getCarCornerCircle().length == 4) {
							for(Circle circle : car.getCarCornerCircle()) {
								root.getChildren().add(circle);
							}
						}else {
							System.out.println("SpawnCar: car.getCarCornerCircle() = null");
						}
					    	if( car.getObservableListCarIsOn() != null) {
					        car.getObservableListCarIsOn().add(((IntersectionSimCar)car));
					       // System.out.println("spawnCar(...) --> car.getObersvableListCarIsOn " + ((IntersectionSimCar)car).getObservableListCarIsOn());
					    	}
					 // });
				// delay.play();
				
			});
	
			
	}
	/*public void stop() throws Exception{
		super.stop();
		Executor.shutdown();
	}*/
	//***********************************************************************************************************************************************************************
	//DELETE CAR FUNCTION
	
	public void deleteCar(Pane root, ObservableList<IntersectionSimCar> carObjectList) {
				//------------------------	
		ObservableList<IntersectionSimCar> toBeRemovedCar = FXCollections.observableArrayList();		
		 if(!carObjectList.isEmpty()) {
				for (IntersectionSimCar car : carObjectList) {
	                double carPositionX = ((IntersectionSimCar)car).getPositionX();
	                double carPositionY = ((IntersectionSimCar)car).getPositionY();
	                
	               
	                 if(carPositionY > 768 ) {
	                	 toBeRemovedCar.add((IntersectionSimCar) car);
	                	 car.setRearCar(null);
	                	 car.setLaneManagement(null);
	                	 car.setAlive(false);
	                	
	                	 ((IntersectionSimCar)car).deleteCircleRpCorner(root);
	                 	((IntersectionSimCar)car).removeCarImagesAndImageViewsFromRoot(root);
	                 	
	                }
	            }
				carObjectList.removeAll(toBeRemovedCar);
        	    
			}


	 
		
		
	}
		
	
	//DELETE CAR FUNCTION ENDS
	//****************************************************************************************************************************************
	public static void main(String[] args) {
		launch(args);
	}
    
	/*public void setCircleX() {
		this.circleX +=1;
	}
	public double getCircleX() {
		return circleX;
	}

	public double getCircleY() {
		return circleY;
	}
*/
}

