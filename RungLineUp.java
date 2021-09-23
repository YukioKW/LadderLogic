
public class RungLineUp {
	private boolean[] in;
	private boolean out;
	private int size;
	private int initx;
	private int inity;
	
	public RungLineUp(int size){
		this.in= new boolean[size];
		this.size = size;
	}

	public boolean getIn(int i) {
		return in[i];
	}

	public void setIn(int in, boolean s) {
		this.in[in-this.initx] = s;	
		for (int i = 0; i<this.size; i++) {
			if (this.in[i]==true) {
				this.out = true;		
			}
			else {
				this.out = false;
				
			}
		}
		
	
	}

	public boolean getOut() {
		return out;
	}

	public void setOut(boolean out) {
		this.out = out;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getInitx() {
		return initx;
	}

	public void setInitx(int initx) {
		this.initx = initx;
	}

	public int getInity() {
		return inity;
	}

	public void setInity(int inity) {
		this.inity = inity;
	}
	
}
