import java.util.*;

public class ScalesSolution
{
	private String scasol;
	//Creates a new scales solution based on a string parameter
	//The string parameter is checked to see if it contains all zeros and ones
	//Otherwise the random binary string generator is used (n = length of parameter)
	public ScalesSolution(String s)
	{
		boolean ok = true;
		int n = s.length();
		for(int i=0;i<n;++i)
		{
			char si = s.charAt(i);
			if (si != '0' && si != '1') ok = false;
		}
		if (ok)
		{
			scasol = s;
		}
		else
		{
			scasol = RandomBinaryString(n);
		}
	}
	private static String RandomBinaryString(int n)
	{
		String s = new String();
		for(int i=0;i<n;++i)
		{
			s += Integer.toString(CS2004.UI(0, 1));
		}
		//Code goes here
		//Create a random binary string of just ones and zeros of length n
		
		return(s);
	}
	public ScalesSolution(int n) 
	{
		scasol = RandomBinaryString(n);	
	}
	//This is the fitness function for the Scales problem
	//This function returns -1 if the number of weights is less than
	//the size of the current solution
	public double ScalesFitness(ArrayList<Double> weights)
	{
		if (scasol.length() > weights.size()) return(-1);
		double lhs = 0.0,rhs = 0.0;
		int n = scasol.length();
		for (int i = 0;i<n;i++) {
			if (scasol.charAt(i)== '0') lhs += weights.get(i);
			else rhs += weights.get(i);
		}
		//Code goes here
		//Check each element of scasol for a 0 (lhs) and 1 (rhs) add the weight wi
		//to variables lhs and rhs as appropriate
		
		return(Math.abs(lhs-rhs));
	}
	//Display the string without a new line
	public void print()
	{
		System.out.print(scasol);
	}
	//Display the string with a new line
	public void println()
	{
		print();
		System.out.println();
	}
	public void SmallChange()	//swaps a random element of the scasol
	{
		int p = CS2004.UI(0,scasol.length()-1);
		String x = "";
		for(int i = 0;i<scasol.length();i++) {
			if (i == p) {
				if (scasol.charAt(i)=='0') {
					x += "1";
				}
				else x += "0";
			}
			else x += scasol.charAt(i);
		}
		scasol = x;
	}
	public String GetSol()
	{
		return(scasol);
	}

}