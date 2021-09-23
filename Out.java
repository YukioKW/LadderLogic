public class Out {
	
	private char id;
	private boolean state;
	private boolean in;
	private boolean out;
	private int position;

 	public Out() {
 		this.setState(false);
 		this.setIn(false);
 		this.setOut(false);
 	}
 	
	public void setState(boolean state) {
		this.state = state;
		if (this.in == true) {
			this.state = true;
			this.out = true;
			
		}
		else if (this.in == false) {
			this.state = false;
			this.out = false;
		}
	}
	
	public boolean getIn() {
		return in;
	}
	
	public void setIn(boolean in) {
		this.in = in;
		this.out= in;
		this.state = in;
	}
	
	public boolean getState() {
		return state;
	}
	
	public char getId() {
		return id;
	}
	
	public void setId(char id) {
		this.id = id;
	}
	
	public boolean getOut() {
		return out;
	}
	
	public void setOut(boolean out) {
		this.out = out;
	}
	
	public int getPosition() {
		return position;
	}
	
	public void setPosition(int position) {
		this.position = position;
	}
	public String getLogicString() {
		return ("-( )-");
	}
	
}
