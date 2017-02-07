/**
 * Gerardo Hernandez
 * SID# 20217586
 * HW1-2
 * Due Date 02/07/2017
 *
 */
import java.util.Scanner ;

public class Infected {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int edges,computers,origin ;
		int[][] connections ;
		int[] infectedList ;
		int infected = 0 ;

		
		computers = input.nextInt();
		if(computers < 100)
		{
			edges = input.nextInt();
			connections = new int[edges][2];
			
			for(int i = 0 ; i < edges ; i++)
			{
				connections[i][0] = input.nextInt();
				connections[i][1] = input.nextInt();
						
			}
			
			origin = input.nextInt() ;
			
			infectedList = new int[computers]; 
			infectedList[infected++] = origin ;
			//infected++ ;
			
			for(int i = 0 ; i < edges; i++)
			{
				if(isInfected(infectedList,infected,connections[i][0]))
				{
					if(!isInfected(infectedList,infected,connections[i][1]))
					{
						infectedList[infected] = connections[i][1] ;
						infected++ ;
						
						
					}
					
				}
				else if(isInfected(infectedList,infected,connections[i][1]))
				{
					infectedList[infected] = connections[i][0] ;
					infected++ ;
					
				}
				
								
			}
			
			System.out.println(infected-1);
			
		}
		else
		{
			
			System.out.println("Computer count exceeds the max of 100");
			
		}
		
		
		input.close();
			
	}
	
	public static boolean isInfected(int[] infected, int size, int item)
	{
		for(int i = 0 ; i < size ; i++ )
		{
			if(infected[i] == item)
			{
				
				return true ;
			}
			
		}
		
		return false ;
	}
	
	//I might not need this
	public static void addToInfected(int[] infected, int size, int newItem)
	{
		
		infected[size]= newItem ;
		
	}

}
