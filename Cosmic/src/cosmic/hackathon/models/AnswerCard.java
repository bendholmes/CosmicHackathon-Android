package cosmic.hackathon.models;

import android.graphics.drawable.Drawable;
import cosmic.hackathon.images.ColourDetector;
import cosmic.hackathon.images.Colours;

public class AnswerCard {

	private String name;
	private int imageResourceId;
	private Colours colour;
	
	public AnswerCard(String name, int imageResourceId, Colours colour) {
		this.name = name;
		this.imageResourceId = imageResourceId;
		this.colour = colour;
	}
	
	public String getName() {
		return name;
	}
	
	public int getImageResourceId() {
		return imageResourceId;
	}
	
	public Colours getColour() {
		return colour;
	}
	
	public boolean isAPictureOfThisCard(int[] pixels) {
		Colours pixelsColour = ColourDetector.whatColourAmI(pixels);
		return colour.equals(pixelsColour);
	}
}
