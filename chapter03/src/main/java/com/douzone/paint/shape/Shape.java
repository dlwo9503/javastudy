package com.douzone.paint.shape;

import com.douzone.paint.i.Drawable;

public abstract class Shape implements Drawable{ // 추상 클래스이므로 new 객체로 생성 불가능하게 함
	private String lineColor;
	private String fillColor;
	
	public abstract void draw(); // 추상화 메소드 상태로 구현
}
