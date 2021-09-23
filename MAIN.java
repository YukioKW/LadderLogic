public class MAIN {
	public static void main(String[] args) {
		
		InNO ino1 = new InNO();		
		InNC inc2 = new InNC();	
		InNC inc1 = new InNC();		
		Out out1 = new Out();			
		RungLineDown rld1 = new RungLineDown(2);
		RungLineUp rlu1 = new RungLineUp(2);	
	
		LogicLine Ladder01 = new LogicLine(3,9);	
		Ladder01.add(rld1, 1, 2);
		Ladder01.add(rlu1, 1, 4);
		
		Ladder01.add(ino1, 1, 3);
		Ladder01.add(inc1, 1, 1);
		Ladder01.add(inc2, 2, 3);
		Ladder01.add(out1, 1, 5);
		
		Ladder01.run();	
		Ladder01.RungAsString();
		System.out.println("\n"+Ladder01.getstateString(1, 5)+" - Saida Ladder01");		
		
		inc2.setState(false); // Abrindo o contato inc2 que esta em (2,3)
		System.out.println("Mudado o estado do contato inc2 para false");	
		Ladder01.run();		
		System.out.println(Ladder01.getstateString(1, 5)+" - Saida Ladder01");	
	}
}
