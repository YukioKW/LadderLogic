
public class RungAsString {
	private String[] StringLadder=new String[10];
	private int nLinha;
 
 	public RungAsString(int n) {
 		this.setnLinha(n);
 		this.setStringLadder("I------1----2----3----4----5----6----7----8----9--------I", 0);
 	}
 	
	public int getnLinha() {
		return nLinha;
	}
	public void setnLinha(int nLinha) {
		this.nLinha = nLinha;
	}
	public String getStringLaddertoedit(int i) {
		if (this.StringLadder[i]== null ) {
			this.setStringLadder("I-------------------------------------------------------I", i);
		}
		return StringLadder[i];
	}
	
	public String getStringLadder(int i) {	
			return StringLadder[i];		
	}
		
	public void setStringLadder(String s, int i) {
		this.StringLadder[i] = s;
	}
	
	public String[] getFullLogic(){
		return StringLadder;
	}
}
