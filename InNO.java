public class InNO {	
	private char id;
	private boolean state;
	private boolean in;
	private boolean out;
	private int position;

 	public InNO() {
 		this.setState(false);
 		this.setIn(false);
 		this.setOut(false);
 	}
 	
	public void setState(boolean state) {
		this.state = state;
		
		if (this.state == true && this.in == true) {
			this.out = true;
		}	
		else{
			this.out = false;	
		}
	}
	
	public boolean getIn() {
		return in;
	}
	
	public void setIn(boolean in) {
		this.in = in;
		if (this.state == true && this.in == true ) {
			this.out = true;
		}		
		else{
			this.out = false;
		}
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
		return ("-[ ]-");
	}
	
}
