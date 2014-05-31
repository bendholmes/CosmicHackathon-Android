package cosmic.hackathon.models;

import cosmic.hackathon.images.ColourDetector;
import cosmic.hackathon.images.Colours;

public class AnswerCard {

	private String name;
	private String imageResourceName;
	private Colours colour;
	
	public AnswerCard(String name, String imageResourceName, Colours colour) {
		this.name = name;
		this.imageResourceName = imageResourceName;
		this.colour = colour;
	}
	
	public String getName() {
		return name;
	}
	
	public String getImageResourceName() {
		return imageResourceName;
	}
	
	public Colours getColour() {
		return colour;
	}
	
	public boolean isAPictureOfThisCard(int[] pixels) {
		Colours pixelsColour = ColourDetector.whatColourAmI(pixels);
		return colour.equals(pixelsColour);
	}
}
