package com.example.display_coating.adapter;

import java.util.List;

import android.graphics.Bitmap;

public class DuibiEntity {

	private int count;
	private List<String []> value;
	private List<Bitmap> left;
	private List<Bitmap> right;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public List<String[]> getValue() {
		return value;
	}
	public void setValue(List<String[]> value) {
		this.value = value;
	}
	public List<Bitmap> getLeft() {
		return left;
	}
	public void setLeft(List<Bitmap> left) {
		this.left = left;
	}
	public List<Bitmap> getRight() {
		return right;
	}
	public void setRight(List<Bitmap> right) {
		this.right = right;
	}
	
	
	
	
}
