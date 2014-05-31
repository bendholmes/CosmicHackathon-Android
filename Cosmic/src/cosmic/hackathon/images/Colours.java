package cosmic.hackathon.images;

public enum Colours {

	RED(180, 53, 112),
	GREEN(97, 172, 102),
	BLUE(90, 168, 222),
	YELLOW(249, 178, 51);
	
	public int r;
	public int g;
	public int b;
	
	private Colours(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
}
