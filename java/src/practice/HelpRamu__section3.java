package practice;

import java.util.Scanner;

public class HelpRamu__section3 {

	public static void main(String[] args) {

		

		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int i=1 ; i<=T ; i++)
		{
		    // . for c1,c2,c3,c4 we are using array
		    //System.out.println("for c1,c2,c3,c4 we are using arr");
		    int[]arr=new int[5];
		    arr[0]=0;
		    for(int k=1 ; k<=4 ; k++)
		    {
		        arr[k]=sc.nextInt();
		    }

		     //enter n and m
		     //System.out.println("enter n and m");
		     int n=sc.nextInt();
		     int m=sc.nextInt();
		     
		     //enter number of individual rickshaws
		     //System.out.println("enter number of individual rickshaws");
		     int[]arrR=new int[n+1];
		     arrR[0]=0;
		     int l;
		     for(l=1 ; l<=n ; l++)
		     {
		         arrR[l]=sc.nextInt();
		     }

		     //enter number of individual cabs
		     //System.out.println("enter number of individual cabs");
		     int[]arrC=new int[m+1];
		     arrC[0]=0;
		     int o;
		     for(o=1 ; o<=m ; o++)
		     {
		         arrC[o]=sc.nextInt();
		     }


		     //solution starts
		     
		     //total rickshaws
		     int rick=0;
		     for(int j=1 ; j<=n ; j++)
		     {
		         rick+=arrR[j];
		     }

		     //total cabs
		     int cab=0;
		     for(int j=1 ; j<=m ; j++)
		     {
		         cab+=arrC[j];
		     }

		     //testing all cases
		     int[] result=new int[10];
		     result[1]=arr[1]*rick+arr[1]*cab;      
		     result[2]=arr[1]*rick+arr[2]*cab;      
		     result[3]=arr[1]*rick+arr[3];          
		     result[4]=arr[2]+arr[1]*cab;           
		     result[5]=arr[2]+arr[2]*cab;
		     result[6]=arr[2]+arr[3];
		     result[7]=arr[3]+arr[1]*cab;
		     result[8]=arr[3]+arr[2]*cab;
		     result[9]=arr[3]+arr[3];


		     //finding smallest amount
		     int smallest=0;
		     for(int j=1 ; j<=9 ; j++)
		     {
		         if(result[j]<smallest)
		         smallest=result[j];
		     }

		     // checking with last option
		     if(smallest>arr[4])
		     System.out.println(smallest);
		     else
		     System.out.println(arr[4]);


		     
		     
		     
		     }
		
		
		
	}

}
