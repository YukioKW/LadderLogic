
public class RungLineDown {
	private boolean[] out;
	private boolean in;
	private int size;
	private int initx;
	private int inity;
	
	public RungLineDown(int size){
		this.out= new boolean[size];
		this.size = size;
	}
	
	public boolean getOut(int line) {
		return this.out[line-this.initx];
	}

	public void setOut(int line, boolean state) {
		this.out[line] = state;
	}
	
	public void setOut(boolean[] Out) {
		this.out= Out;
	}
	
	public boolean getIn() {
		return in;
	}

	public void setIn(boolean in) {
		this.in = in;
		if (this.in==true) {
			this.setAllOutTrue();
		}
		else if (this.in==false) {
			this.setAllOutFalse();
		}
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
	public void setAllOutTrue() {
		for (int i = 0; i<this.size; i++) {
			this.out[i] = true;
		}		
	}
	public void setAllOutFalse() {
		for (int i = 0; i<this.size; i++) {
			this.out[i] = false;
		}		
	}	
}
