
public class LogicLine{	
	private Object a[][];
	private boolean table[][];
	private int tableint[][];
	private boolean gridOn = true;
	private int x;
	private int y;
	private boolean isthreadon = true;
	
	public LogicLine(int x, int y){
		this.a = new Object[x][y];
		this.table = new boolean[x][y+1];
		this.tableint = new int[x][y+1];
		this.x = x;
		this.y = y;
	}
	
	public boolean isGridOn() {
		return gridOn;
	}

	public void setGridOn(boolean gridOn) {
		this.gridOn = gridOn;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isIsthreadon() {
		return isthreadon;
	}

	public void setIsthreadon(boolean isthreadon) {
		this.isthreadon = isthreadon;
	}

	public Object[][] getA() {
		return a;
	}

	public void add(Object component, int x, int y) { 
		this.a[x][y] = component;

		if (this.a[x][y] instanceof RungLineDown) {
			((RungLineDown)(this.a[x][y])).setInitx(x);
			((RungLineDown)(this.a[x][y])).setInity(y);
			int size = ((RungLineDown)(this.a[x][y])).getSize();
			
			for (int x1 = x; x1<(x+size); x1++) {
				this.a[x1][y]=component;
			}
		}
		else if (this.a[x][y] instanceof RungLineUp) {
			((RungLineUp)(this.a[x][y])).setInitx(x);
			((RungLineUp)(this.a[x][y])).setInity(y);
			int size = ((RungLineUp)(this.a[x][y])).getSize();
		
			for (int x1 = x; x1<(x+size); x1++) {
				this.a[x1][y]=component;
			}
		}
	}

	public void remove(int i, int j) {
		this.a[i][j]= null;
	}
	
	public void RungAsString () {
		RungAsString t = new RungAsString(1);		
		
		for (int i = (this.x-1); i>0; i--) {
			for (int j = (this.y-1); j>0 ; j--) {				
			
				if(this.a[i][j]instanceof InNO) {
					int p = j*5;
			 		StringBuilder colocar  = new StringBuilder(t.getStringLaddertoedit(i));
			 		colocar.delete(p, p+5);
			 		colocar.insert(p,((InNO)(this.a[i][j])).getLogicString());
			 		t.setStringLadder(colocar.toString(), i);
			 	}			
				else if(this.a[i][j]instanceof InNC) {
					int p = j*5;
			 		StringBuilder colocar  = new StringBuilder(t.getStringLaddertoedit(i));
			 		colocar.delete(p, p+5);
			 		colocar.insert(p, ((InNC)(this.a[i][j])).getLogicString());
			 		t.setStringLadder(colocar.toString(),i);				
				}	
				else if(this.a[i][j]instanceof Out) {
					int p = j*5;
			 		StringBuilder colocar  = new StringBuilder(t.getStringLaddertoedit(i));
			 		colocar.delete(p, p+5);
			 		colocar.insert(p, ((Out)(this.a[i][j])).getLogicString());
			 		t.setStringLadder(colocar.toString(),i);				
				}	
				else if(this.a[i][j]instanceof RungLineDown) {
					int p = j*5;
			 		StringBuilder colocar  = new StringBuilder(t.getStringLaddertoedit(i));
			 		
			 		if (((RungLineDown)(this.a[i][j])).getInitx()==i) {
			 			colocar.delete(p+2, p+3);
				 		colocar.insert(p+2, "|");
			 		}
			 		else {
			 			
			 			colocar.delete(0, p+3);
			 			for (int str = 0; str<p+2; str++) {
			 				colocar.insert(str, " ");
			 			}
			 			
				 		colocar.insert(p+2, "|");
			 		}
			 		
			 		t.setStringLadder(colocar.toString(),i);				
				}	
				
				else if(this.a[i][j]instanceof RungLineUp) {
					int p = 2+(j*5);
			 		StringBuilder colocar  = new StringBuilder(t.getStringLaddertoedit(i));
			 		
			 		if (((RungLineUp)(this.a[i][j])).getInitx()==i) {
			 			colocar.delete(p, p+1);
				 		colocar.insert(p, "|");
			 		}
			 		else {
			 			colocar.delete(p, colocar.length());
			 			for (int str = p; str<colocar.length(); str++) {
			 				colocar.insert(str, " ");
			 			}
				 		colocar.insert(p, "|");
			 		}
			 		t.setStringLadder(colocar.toString(),i);				
			}					
		}
	}
		for (int i = 0; i<=9; i++) {
			if (t.getStringLadder(i)!=null) {
				System.out.println("Linha " +i+ " " +t.getStringLadder(i));
			}
		}	
	}
	
/*	public void showTable () {
		
		boolean s[][] = new boolean[10][10];
		System.out.println("-----------------------------");
		for (int i = 0; i<=9; i++) {
		
			for (int j = 0; j <= 9 ; j++) {				
			    
				if(this.a[i][j]instanceof InNO) {
			 	}			
				else if(this.a[i][j]instanceof InNC) {
									
				}	
				else if(this.a[i][j]instanceof Out) {
								
				}										
			}					
		}	
		System.out.println("-----------------------------");
	}    

  */

	public String getstateString(int i, int j) {
		
		if(this.a[i][j]instanceof InNO) {
			return("position: ("+ i +", "+ j +")| State:  "+((InNO)(this.a[i][j])).getState());		
		}   
		else if(this.a[i][j]instanceof InNC) {
			return("position: ("+ i +", "+ j +")| State:  "+((InNC)(this.a[i][j])).getState());
		}
		else if(this.a[i][j]instanceof Out) {
			return("position: ("+ i +", "+ j +")| State:  "+((Out)(this.a[i][j])).getState());
		}
		else{
			return("Can't find an object in ("+i+", "+j+")");
		}
	}
	
	public boolean getstate(int i, int j) {	
		boolean state = false;
		if(this.a[i][j]instanceof InNO) {
			state = ((InNO)(this.a[i][j])).getState();		
		}   
		else if(this.a[i][j]instanceof InNC) {
			state = ((InNC)(this.a[i][j])).getState();		
		}
		else if(this.a[i][j]instanceof Out) {
			state = ((Out)(this.a[i][j])).getState();		
		}	
		return state;
	}
	
	public void run() {	
		for (int twice = 0; twice<3; twice++) {
			
			for (int i = 0; i<this.x; i++) {
				boolean init = this.gridOn;	
		
				for ( int j = 0; j <this.y ; j++) {				
					if(this.a[i][j]instanceof InNO) {	
						((InNO)(this.a[i][j])).setIn(init);
						init = ((InNO)(this.a[i][j])).getOut();
					}
        
					else if(this.a[i][j]instanceof InNC) {				
						((InNC)(this.a[i][j])).setIn(init);
						init = ((InNC)(this.a[i][j])).getOut();
					}
				
					else if(this.a[i][j]instanceof RungLineDown) {
						((RungLineDown)(this.a[i][j])).setIn(init);
						init = ((RungLineDown)(this.a[i][j])).getOut(i);
					}
				
					else if(this.a[i][j]instanceof RungLineUp) {
						((RungLineUp)(this.a[i][j])).setIn(i,init);
						init = ((RungLineUp)(this.a[i][j])).getOut();
					}
					
					else if(this.a[i][j]instanceof Out) {
						((Out)(this.a[i][j])).setIn(init);
						init = ((Out)(this.a[i][j])).getOut();				
					}        				
				}  
			}
		}	
	}
	
	
	
	
	public void runTeste () {

		for (int i = 0; i<this.x; i++) {
			boolean init = true;	
		
			for (int j = 0; j <this.y ; j++) {								    		
				if(this.a[i][j]instanceof InNO) {
					
					if (init == true && ((InNO)(this.a[i][j])).getState()==true){
						init = true;
					}
					else if (init == true && ((InNO)(this.a[i][j])).getState()==false){
						init = false;
					}
					else if (init == false && ((InNO)(this.a[i][j])).getState()==true){
						init = false;
					}
				}
        
				else if(this.a[i][j]instanceof InNC) {
					if (init == true && ((InNC)(this.a[i][j])).getState()==true){
						init = true;
					}
					else if (init == true && ((InNC)(this.a[i][j])).getState()==false){
						init = false;
					}
					else if (init == false && ((InNC)(this.a[i][j])).getState()==true){
						init = false;
					}

				}
				
				else if(this.a[i][j]instanceof RungLineDown) {
					
					if (init == true){
						((RungLineDown)(this.a[i][j])).setIn(true);
						((RungLineDown)(this.a[i][j])).setAllOutTrue();
						init = true;
					}	
					else if (init == false){
						((RungLineDown)(this.a[i][j])).setIn(false);
						((RungLineDown)(this.a[i][j])).setAllOutFalse();
						init = false;
					}
				}
				
	/*			else if(this.a[i][j]instanceof RungLineUp) {
					
					if (init == true){						
						((RungLineUp)(this.a[i][j])).setOut(true);

					}	
					else if (init == false){
						((RungLineUp)(this.a[i][j])).setIn(false);
						((RungLineUp)(this.a[i][j])).setAllOutFalse();
					}
				}
     */   
				else if(this.a[i][j]instanceof Out) {
					if (init == true && ((Out)(this.a[i][j])).getState()==true){
						init = true;
					}
					else if (init == true && ((Out)(this.a[i][j])).getState()==false){
						((Out)(this.a[i][j])).setState(true);
					}
					
					else if (init == false && ((Out)(this.a[i][j])).getState()==true){
						System.out.println("Logic error on the output("+i+", "+j+")");
					}				
				}        				
			}  
		}
	}

	/*public void runthreadTestes() {
		new Thread() {
				public void run(){
					while (isthreadon==true){
						for (int i = 0; i<x; i++) {
							boolean init = gridOn;	
	
							for (int j = 0; j <y ; j++) {				
								if(a[i][j]instanceof InNO) {	
									((InNO)(a[i][j])).setIn(init);
									init = ((InNO)(a[i][j])).getOut();
								}
    
								else if(a[i][j]instanceof InNC) {				
									((InNC)(a[i][j])).setIn(init);
									init = ((InNC)(a[i][j])).getOut();
								}
			
								else if(a[i][j]instanceof RungLineDown) {
									((RungLineDown)(a[i][j])).setIn(init);
									init = ((RungLineDown)(a[i][j])).getOut(i);
								}
			
								else if(a[i][j]instanceof RungLineUp) {
									((RungLineUp)(a[i][j])).setIn(i,init);
									init = ((RungLineUp)(a[i][j])).getOut();
								}
				
								else if(a[i][j]instanceof Out) {
									((Out)(a[i][j])).setIn(init);
									init = ((Out)(a[i][j])).getOut();				
								}        				
							}  
						}
					}
				} 
		}.start();
	}*/
}

