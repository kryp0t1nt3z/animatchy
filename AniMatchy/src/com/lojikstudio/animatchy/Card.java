package com.lojikstudio.animatchy;

import android.graphics.Bitmap;

public class Card {

	private int id;
	private Bitmap bmp;
	
	public Card(int frontCard){
		id=frontCard;
		
	}
	
	public void setBitmap(Bitmap newBitmap){
		bmp = newBitmap;
	}
	
	public Bitmap getBitmap(){
		return bmp;
	}
	
	public int getId(){
		return id;
	}
}
