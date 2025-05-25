package intersectionsimcar.core;

import java.util.HashMap;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LaneManagement {
	private ObservableList<IntersectionSimCar> headingDownRightLaneList;
	private ObservableList<IntersectionSimCar> headingDownLeftLaneList;
	private ObservableList<IntersectionSimCar> headingDownLTBLaneList;	
	 	
	private ObservableList<IntersectionSimCar> headingUpRightLaneList;
 	private ObservableList<IntersectionSimCar> headingUpLeftLaneList;
 	private ObservableList<IntersectionSimCar> headingUpLTBLaneList;
 	
 	private ObservableList<IntersectionSimCar> headingLeftRightLaneList;
 	private ObservableList<IntersectionSimCar> headingLeftLeftLaneList;
 	private ObservableList<IntersectionSimCar> headingLeftLTBLaneList;
 	
 	private ObservableList<IntersectionSimCar> headingRightRightLaneList;
 	private ObservableList<IntersectionSimCar> headingRightLeftLaneList;
 	private ObservableList<IntersectionSimCar> headingRightLTBLaneList;
 	private ObservableList<IntersectionSimCar> emptyList;
 	
 	public LaneManagement() {
 		
 		hashMap_For_Observablelist = new HashMap<>();
 		tL_HashMap_For_Observablelist = new HashMap<>();
 		this.headingDownRightLaneList = FXCollections.observableArrayList();
 		this.headingDownLeftLaneList = FXCollections.observableArrayList();
 		this.headingDownLTBLaneList = FXCollections.observableArrayList();
 		
 		this.headingUpRightLaneList = FXCollections.observableArrayList();
 		this.headingUpLeftLaneList = FXCollections.observableArrayList();
 		this.headingUpLTBLaneList = FXCollections.observableArrayList();
 		
 		this.headingLeftRightLaneList = FXCollections.observableArrayList();
 		this.headingLeftLeftLaneList = FXCollections.observableArrayList();
 		this.headingLeftLTBLaneList = FXCollections.observableArrayList();
 		
 		this.headingRightRightLaneList = FXCollections.observableArrayList();
 		this.headingRightLeftLaneList = FXCollections.observableArrayList();
 		this.headingRightLTBLaneList = FXCollections.observableArrayList();
 		
 		this.populateHashMap_For_Observationalist ();
 		this.populateTLHashMap_For_Observationalist ();
 		
 	}
          
	public ObservableList<IntersectionSimCar> getHeadingDownRightLaneList() {
		return headingDownRightLaneList;
	}

	public void setHeadingDownRightLaneList(IntersectionSimCar car) {
		this.headingDownRightLaneList.add(car);
	}

	public ObservableList<IntersectionSimCar> getHeadingDownLeftLaneList() {
		return headingDownLeftLaneList;
	}

	public void setHeadingDownLeftLaneList(IntersectionSimCar car) {
		this.headingDownLeftLaneList.add(car);
	}

	public ObservableList<IntersectionSimCar> getHeadingDownLTBLaneList() {
		return headingDownLTBLaneList;
	}

	public void setHeadingDownLTBLaneList(IntersectionSimCar car) {
		this.headingDownLTBLaneList.add(car);
	}

	public ObservableList<IntersectionSimCar> getHeadingUpRightLaneList() {
		return headingUpRightLaneList;
	}

	public void setHeadingUpRightLaneList(IntersectionSimCar car) {
		this.headingUpRightLaneList.add(car);
	}

	public ObservableList<IntersectionSimCar> getHeadingUpLeftLaneList() {
		return headingUpLeftLaneList;
	}

	public void setHeadingUpLeftLaneList(IntersectionSimCar car) {
		this.headingUpLeftLaneList.add(car);
	}

	public ObservableList<IntersectionSimCar> getHeadingUpLTBLaneList() {
		return headingUpLTBLaneList;
	}

	public void setHeadingUpLTBLaneList(IntersectionSimCar car) {
		this.headingUpLTBLaneList.add(car);
	}

	public ObservableList<IntersectionSimCar> getHeadingLeftRightLaneList() {
		return headingLeftRightLaneList;
	}

	public void setHeadingLeftRightLaneList(IntersectionSimCar car) {
		this.headingLeftRightLaneList.add(car);
	}

	public ObservableList<IntersectionSimCar> getHeadingLeftLeftLaneList() {
		return headingLeftLeftLaneList;
	}

	public void setHeadingLeftLeftLaneList(IntersectionSimCar car) {
		this.headingLeftLeftLaneList.add(car);
	}

	public ObservableList<IntersectionSimCar> getHeadingLeftLTBLaneList() {
		return headingLeftLTBLaneList;
	}

	public void setHeadingLeftLTBLaneList(IntersectionSimCar car) {
		this.headingLeftLTBLaneList.add(car);
	}

	public ObservableList<IntersectionSimCar> getHeadingRightRightLaneList() {
		return headingRightRightLaneList;
	}

	public void setHeadingRightRightLaneList(IntersectionSimCar car) {
		this.headingRightRightLaneList.add(car);
	}

	public ObservableList<IntersectionSimCar> getHeadingRightLeftLaneList() {
		return headingRightLeftLaneList;
	}

	public void setHeadingRightLeftLaneList(IntersectionSimCar car) {
		this.headingRightLeftLaneList.add(car);
	}

	public ObservableList<IntersectionSimCar> getHeadingRightLTBLaneList() {
		return headingRightLTBLaneList;
	}

	public void setHeadingRightLTBLaneList(IntersectionSimCar car) {
		this.headingRightLTBLaneList.add(car);
	}

	public ObservableList<IntersectionSimCar> getEmptyList() {
		return emptyList;
	}
	
	

	 private HashMap<IntersectionSimCar.OnWhichLane, ObservableList<IntersectionSimCar>> hashMap_For_Observablelist;
	 
	 public HashMap<IntersectionSimCar.OnWhichLane, ObservableList<IntersectionSimCar>> getHashMap_For_Observablelist() {
			return hashMap_For_Observablelist;
		}

	 private HashMap<IntersectionSimCar.TargetLane, ObservableList<IntersectionSimCar>> tL_HashMap_For_Observablelist; 
	    
	    public HashMap<IntersectionSimCar.TargetLane, ObservableList<IntersectionSimCar>> getTL_HashMap_For_ObservableList() {
	    	return tL_HashMap_For_Observablelist;
	    }
	    
	    public void populateHashMap_For_Observationalist () {
	    
	    	
	    	this.hashMap_For_Observablelist.put(IntersectionSimCar.OnWhichLane.HEADING_DOWN_ON_RIGHT_LANE_LIST, this.headingDownRightLaneList);
	    	this.hashMap_For_Observablelist.put(IntersectionSimCar.OnWhichLane.HEADING_DOWN_ON_LEFT_LANE_LIST, this.headingDownLeftLaneList);
	    	this.hashMap_For_Observablelist.put(IntersectionSimCar.OnWhichLane.HEADING_DOWN_IN_LEFTTURNBOX_LIST, this.headingDownLTBLaneList);
	    	
	    	this.hashMap_For_Observablelist.put(IntersectionSimCar.OnWhichLane.HEADING_UP_ON_RIGHT_LANE_LIST, this.headingUpRightLaneList);
	    	this.hashMap_For_Observablelist.put(IntersectionSimCar.OnWhichLane.HEADING_UP_ON_LEFT_LANE_LIST, this.headingUpLeftLaneList);
	    	this.hashMap_For_Observablelist.put(IntersectionSimCar.OnWhichLane.HEADING_UP_IN_LEFTTURNBOX_LIST, this.headingUpLTBLaneList);
	    	
	    	this.hashMap_For_Observablelist.put(IntersectionSimCar.OnWhichLane.HEADING_LEFT_ON_RIGHT_LANE_LIST, this.headingLeftRightLaneList);
	    	this.hashMap_For_Observablelist.put(IntersectionSimCar.OnWhichLane.HEADING_LEFT_ON_LEFT_LANE_LIST, this.headingLeftLeftLaneList);
	    	this.hashMap_For_Observablelist.put(IntersectionSimCar.OnWhichLane.HEADING_LEFT_IN_LEFTTURNBOX_LIST, this.headingLeftLTBLaneList);
	    	
	    	this.hashMap_For_Observablelist.put(IntersectionSimCar.OnWhichLane.HEADING_RIGHT_ON_RIGHT_LANE_LIST, this.headingRightRightLaneList);
	    	this.hashMap_For_Observablelist.put(IntersectionSimCar.OnWhichLane.HEADING_RIGHT_ON_LEFT_LANE_LIST, this.headingRightLeftLaneList);
	    	this.hashMap_For_Observablelist.put(IntersectionSimCar.OnWhichLane.HEADING_RIGHT_IN_LEFTTURNBOX_LIST, this.headingRightLTBLaneList);
	    	
	    }
	    
	    public void populateTLHashMap_For_Observationalist () {
			
			
			this.getTL_HashMap_For_ObservableList().put(IntersectionSimCar.TargetLane.HEADING_DOWN_ON_RIGHT_LANE_LIST, this.headingDownRightLaneList);
			this.getTL_HashMap_For_ObservableList().put(IntersectionSimCar.TargetLane.HEADING_DOWN_ON_LEFT_LANE_LIST, this.headingDownLeftLaneList);
			this.getTL_HashMap_For_ObservableList().put(IntersectionSimCar.TargetLane.HEADING_DOWN_IN_LEFTTURNBOX_LIST, this.headingDownLTBLaneList);
			
			this.getTL_HashMap_For_ObservableList().put(IntersectionSimCar.TargetLane.HEADING_UP_ON_RIGHT_LANE_LIST, this.headingUpRightLaneList);
			this.getTL_HashMap_For_ObservableList().put(IntersectionSimCar.TargetLane.HEADING_UP_ON_LEFT_LANE_LIST, this.headingUpLeftLaneList);
			this.getTL_HashMap_For_ObservableList().put(IntersectionSimCar.TargetLane.HEADING_UP_IN_LEFTTURNBOX_LIST, this.headingUpLTBLaneList);
			
			this.getTL_HashMap_For_ObservableList().put(IntersectionSimCar.TargetLane.HEADING_LEFT_ON_RIGHT_LANE_LIST, this.headingLeftRightLaneList);
			this.getTL_HashMap_For_ObservableList().put(IntersectionSimCar.TargetLane.HEADING_LEFT_ON_LEFT_LANE_LIST, this.headingLeftLeftLaneList);
			this.getTL_HashMap_For_ObservableList().put(IntersectionSimCar.TargetLane.HEADING_LEFT_IN_LEFTTURNBOX_LIST, this.headingLeftLTBLaneList);
			
			this.getTL_HashMap_For_ObservableList().put(IntersectionSimCar.TargetLane.HEADING_RIGHT_ON_RIGHT_LANE_LIST, this.headingRightRightLaneList);
			this.getTL_HashMap_For_ObservableList().put(IntersectionSimCar.TargetLane.HEADING_RIGHT_ON_LEFT_LANE_LIST, this.headingRightLeftLaneList);
			this.getTL_HashMap_For_ObservableList().put(IntersectionSimCar.TargetLane.HEADING_RIGHT_IN_LEFTTURNBOX_LIST, this.headingRightLTBLaneList);
			this.getTL_HashMap_For_ObservableList().put(IntersectionSimCar.TargetLane.EMPTYLIST, this.emptyList);
			
	    }
}
