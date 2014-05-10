package com.lojikstudio.animatchy;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;

public class AniMatchyView extends View {

	public AniMatchyView(Context context) {
		super(context);
		
	}
	
	public boolean onTouchEvent(MotionEvent event) {
		int eventaction = event.getAction();
		int X = (int)event.getX();
		int Y = (int)event.getY();
		
		switch (eventaction) {
		case MotionEvent.ACTION_DOWN:
			break;
		case MotionEvent.ACTION_MOVE:
			break;
		case MotionEvent.ACTION_UP:
			break;
		}
		invalidate();
		return true;
	}

}
