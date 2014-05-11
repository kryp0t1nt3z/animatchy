package com.lojikstudio.animatchy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;

public class GameView extends TitleView {
	private float scale;
	private Context myContext;
	private List<Card> deck = new ArrayList<Card>();
	private List<Card> deck2 = new ArrayList<Card>();
	private int scaledCardW;
	private int scaledCardH;
	private int screenW;
	private int screenH;
	private List<Card> myHand = new ArrayList<Card>();
	private List<Card> myHand2 = new ArrayList<Card>();
	private List<Card> discardPile = new ArrayList<Card>();
	private Bitmap cardBack;
	private boolean isFlipped = false;
	private int cardIdx = -1;
	private String[] animals = {
		"monkey","tiger", "hippo", "zebra"	
	};

	public GameView(Context context, int backGroundColor) {
		super(context, backGroundColor);
		myContext = context;
		scale = myContext.getResources().getDisplayMetrics().density;
	}

	private void initCards() {
		for (int j=0; j<4;j++){
			String next = animals[j];
		for (int i = 0; i < 4; i++) {
			int tempId = i;
			Card tempCard = new Card(tempId);
			int resourceId = getResources().getIdentifier(next,
					"drawable", myContext.getPackageName());
			Bitmap tempBitmap = BitmapFactory.decodeResource(
					myContext.getResources(), resourceId);
			scaledCardW = (int) (screenW / 8);
			scaledCardH = (int) (scaledCardW * 1.28);
			Bitmap scaledBitmap = Bitmap.createScaledBitmap(tempBitmap,
					scaledCardW, scaledCardH, false);
			tempCard.setBitmap(scaledBitmap);
			deck.add(tempCard);
		}
	}
		for (int j=0; j<4;j++){
			String next = animals[j];
		for (int i = 0; i < 4; i++) {
			int tempId = i;
			Card tempCard = new Card(tempId);
			int resourceId = getResources().getIdentifier(next,
					"drawable", myContext.getPackageName());
			Bitmap tempBitmap = BitmapFactory.decodeResource(
					myContext.getResources(), resourceId);
			scaledCardW = (int) (screenW / 8);
			scaledCardH = (int) (scaledCardW * 1.28);
			Bitmap scaledBitmap = Bitmap.createScaledBitmap(tempBitmap,
					scaledCardW, scaledCardH, false);
			tempCard.setBitmap(scaledBitmap);
			deck2.add(tempCard);
		}
	}
	}

	@Override
	public void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		screenW = w;
		screenH = h;
		Bitmap tempBitmap = BitmapFactory.decodeResource(
				myContext.getResources(), R.drawable.animal_base_card);
		scaledCardW = (int) (screenW / 8);
		scaledCardH = (int) (scaledCardW * 1.28);
		cardBack = Bitmap.createScaledBitmap(tempBitmap, scaledCardW,
				scaledCardH, false);
		initCards();
		dealCards();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		for (int i = 0; i < myHand.size(); i++) {
			if (i < 4) {
				canvas.drawBitmap(myHand.get(i).getBitmap(), i
						* (scaledCardW + 5), screenH - scaledCardH
						- (50 * scale), null);
				canvas.drawBitmap(myHand2.get(i).getBitmap(), i
						* (scaledCardW + 5), screenH - scaledCardH
						- (125 * scale), null);
			}
		}
	}

	private void drawCard(List<Card> handToDraw) {
		handToDraw.add(0, deck.get(0));
		handToDraw.add(0, deck.get(0));
		Collections.shuffle(deck, new Random());
		handToDraw.add(0, deck2.get(0));
		handToDraw.add(0, deck2.get(0));
		Collections.shuffle(deck2, new Random());
	}

	private void dealCards() {
		//Collections.shuffle(deck, new Random());
		//Collections.shuffle(deck2, new Random());
		for (int i = 0; i < 1; i++) {
			drawCard(myHand);
			drawCard(myHand2);
			drawCard(myHand);
			drawCard(myHand2);
	}
	}

	public boolean onTouchEvent(MotionEvent event) {
		int eventaction = event.getAction();
		int X = (int) event.getX();
		int Y = (int) event.getY();

		switch (eventaction) {
		case MotionEvent.ACTION_DOWN:
			for (int i = 0; i < 4;) {
				if (X > (scaledCardW + 5)
						&& X < i * (scaledCardW + 5) + scaledCardW
						&& Y > screenH - scaledCardH - (50 * scale)) {
					cardIdx = i;
				}
				for (int j = 0; j < 4;) {
					if (X > (scaledCardW + 5)
							&& X < j * (scaledCardW + 5) + scaledCardW
							&& Y > screenH - scaledCardH - (125 * scale)) {
						cardIdx = j;
					}
				}
			}
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
