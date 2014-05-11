package com.lojikstudio.animatchy;

import android.graphics.Bitmap;

public class Card {

	private int id;
	private Bitmap bmp;
	private int card;
	
	
	public Card(int newId){
		id=newId;
		card = Math.round(id/2);
		
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
	
	public int getCard(){
		return card;
	}
}
