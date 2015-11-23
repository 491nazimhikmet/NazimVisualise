package model;

import java.util.ArrayList;
import java.util.List;

public class Word {
	private int wordID;
	private String text;
	private double wordStart;
	private double wordFinish;
	private int workLineID;
	
	private boolean isBold;
	private boolean isItalic;
	private String font;
	
	private List<Word> words;

	
	public Word(){
		//words = new ArrayList<Character>();
	}


	public int getWordID() {
		return wordID;
	}


	public String getText() {
		return text;
	}


	public double getWordStart() {
		return wordStart;
	}


	public double getWordFinish() {
		return wordFinish;
	}


	public int getWorkLineID() {
		return workLineID;
	}


	public boolean isBold() {
		return isBold;
	}


	public boolean isItalic() {
		return isItalic;
	}


	public String getFont() {
		return font;
	}


	public List<Word> getWords() {
		return words;
	}
}
