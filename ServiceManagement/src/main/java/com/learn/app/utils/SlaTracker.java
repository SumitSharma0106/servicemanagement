//package com.learn.app.utils;
//
//import com.learn.app.constant.SLAConstant;
//import com.learn.app.entity.CreateIncident;
//
//public class SlaTracker {
//	
//	public String generateSLA(String priority) {
//		return generateSLA_Priority(priority);
//		
//	}
//	
//	String prio=null;
//	
//	private String generateSLA_Priority(String priority) {
//		
//		CreateIncident creIncident = new CreateIncident();
//		if(creIncident.getPriority().equalsIgnoreCase("P1")) {
//			return creIncident.setSla("4 hours");
//		}
//		else if(creIncident.getPriority().equalsIgnoreCase("P2")) {
//			creIncident.setSla(SLAConstant.P2);}
//	    else if(creIncident.getPriority().equalsIgnoreCase("P3")) {
//				creIncident.setSla(SLAConstant.P3);}
//	    else {
//		creIncident.setSla(SLAConstant.P4);}
//		
//		return priority;
//		
//	}
//
//}
