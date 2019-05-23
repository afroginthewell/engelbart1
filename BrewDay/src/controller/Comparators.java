package controller;


import java.util.List;

import model.Recipe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Comparators implements Comparator{

//this class is for sort according to the recipe's max brew amount

	@Override
	public int compare(Object o1, Object o2) {
		Recipe s1=(Recipe)o1;
		Recipe s2=(Recipe)o2;
//		System.out.println(s1.getLackAmount());
//		System.out.println(s2.getLackAmount());
//		System.out.println(s1.getLackAmount()-s2.getLackAmount());
		if(s1.getLackAmount()-s2.getLackAmount()<0)	 {    
			
	    	 return 1;
	     }
	     else if(s1.getLackAmount()-s2.getLackAmount()>0){
	    	 return -1;
	     }
	     else {return 0;}

	}
 }