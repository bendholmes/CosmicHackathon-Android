package cosmic.hackathon.images;

import java.util.HashMap;
import java.util.Map;

public class ColourDetector {

	private static int rValue(int pixel) {
		return (pixel >> 16) & 0xff;
	}
	
	private static int gValue(int pixel) {
		return (pixel >> 8) & 0xff;
	}
	
	private static int bValue(int pixel) {
		return pixel & 0xff;
	}
	
	public static Colours whatColourAmI(int pixels[]) {
		Map<Colours, Double> colourCounts = new HashMap<Colours, Double>();
		
		for (Colours c : Colours.values()) {
			colourCounts.put(c, 0.0);
		}
		
		int numberOfPixels = 0;
		
		for (int pixel : pixels) {
			numberOfPixels++;
			int pr = rValue(pixel);
			int pg = gValue(pixel);
			int pb = bValue(pixel);
			
			Double lowestTotal = null;
			Colours predictedColour = null;
			
			for (Colours c : Colours.values()) {
				double redError = Math.pow(c.r - pr, 2);
				double greenError = Math.pow(c.g - pg, 2);
				double blueError = Math.pow(c.b - pb, 2);
				
				
				double total = Math.sqrt(redError + greenError + blueError);

				if (lowestTotal == null || total < lowestTotal) {
					predictedColour = c;
					lowestTotal = total;
				}
				
			}
			colourCounts.put(predictedColour, colourCounts.get(predictedColour)+1);
			if (numberOfPixels == 2000) {
				break;
			}
		} 

		Double lowestTotal = null;
		Colours predictedColour = null;
		
		for (Map.Entry<Colours, Double> entry : colourCounts.entrySet()) {
			if (lowestTotal == null || lowestTotal < entry.getValue()) {
				predictedColour = entry.getKey();
				lowestTotal = entry.getValue();
			}
		}
		
		return predictedColour;
	}
	
}
