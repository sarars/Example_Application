package main.java.com.application.java.joonspoon_examples;

public class Smurf {
	
	private String name;
	
	private static int papaCount;
	
	private Smurf(String name) {
		if ( name.equalsIgnoreCase("papa") ) {
			papaCount++;
		}
		this.name = name;
	}
	
	public static Smurf createSmurf( String name ) {
		if( name.equalsIgnoreCase("handy")  ) {
			System.out.println("Creating smurf "+ name + "Smurf");
		}
		else if( papaCount < 1 ) {
			System.out.println("Creating smurf "+ name + "Smurf");
		}
		return new Smurf(name);
	}

}
