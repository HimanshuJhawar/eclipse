package codingBlocksRecursionBasics;

public class RecursionBasics {

	public static void main(String[] args) {

	//	PrintDec(5);
	//	PrintInc(5);
	//	PrintDecInc(5);
	//	PrintDecIncSKIP(5);
	
		//	int fact=Factorial(5);
	//	System.out.println(fact);
	
		//	int pow=Power(3,4);
	//	System.out.println(pow);
		
	//	int n=9;
	//	NthTermOfFiboSeries(n,0,1);
		
	//	int[]arr= {1,4,7,8,7};
	//	int num=0;
	//	boolean result=issorted(arr,num);
	//	System.out.println(result);
		
	//	pattern(7,1,1);
		
	//	int[]arr = {3,8,1,8,8,4};
	//	int[]brr=allIndices(arr,0,8,0);
	//	for(int i=0 ; i<brr.length ; i++)
	//	System.out.print(brr[i]+" ");
		
		
		TowerOfHanoi(20,"src","dest","helper");
		
	}
	
	
	public static void PrintDec(int n) {
		
		if(n==0) return;
		
		System.out.println(n);
		
		PrintDec(n-1);
		
	}

	
	public static void PrintInc(int n) {
		if(n==0) return;
		PrintInc(n-1);
		System.out.println(n);
	}
	

	public static void PrintDecInc(int n) {
		if(n==0) return;
		System.out.println(n);
		PrintDecInc(n-1);
		System.out.println(n);
	}

  
    public static void PrintDecIncSKIP(int n) {
    	if(n==0) return;
    	if(n%2==1) System.out.println(n);
    	PrintDecIncSKIP(n-1);
    	if(n%2==0) System.out.println(n);
    }


    public static int Factorial(int n) {
    	if(n==1) return(1);
    	int fact=n*Factorial(n-1);
    	return(fact);
    }


    public static int Power(int num , int pow) {
	   if(pow==0) return(1);
	   num=num*Power(num,pow-1);
	   return(num);
   }

        
    public static void NthTermOfFiboSeries(int n,int a,int b) {
    	if(n==1)
    	{
    	System.out.println(a);
    	return;
    	}
    	int c=a+b;
    	NthTermOfFiboSeries(n-1 , b ,c);
    }


    public static boolean issorted(int [] arr , int num) {
    	if(arr[num]>arr[num+1]) return(false);
    	if(num==arr.length-2) return(true);
    	boolean result=issorted(arr , num+1);
        return(result);        
    }
    
    
    public static void pattern(int N , int row , int col) {
    	    if(row>N) return;
	    	if(col<=row)                           // *
	    	 {                                     // **
		    	System.out.print("*");             // ***
		    	pattern(N,row,col+1);              // ****
	    	 }                                     // *****
	    	else return;                           // ******
	    	if(row==col)
	    	 {
		    	System.out.println();
		    	pattern(N,row+1,1);
	    	 }
    }
    

    public static int[] allIndices(int []arr , int index , int data , int count) {
    	if(index==arr.length)
    	{
    		int[] crr=new int[count];
    	   return(crr);
    	}
    	int [] brr =null;
    //	if(index<arr.length)
    //	{
	    	if(arr[index]==data)
	    	{
	    		brr=allIndices(arr , index+1 , data , count+1);
	    	}
	    	else
	    	{
	    		brr=allIndices(arr , index+1 , data , count);
	    	}
    //	}
    	if(arr[index]==data)
    	{
    		brr[count]=index;
    	}
    	return(brr);
    }


    public static void TowerOfHanoi(int n , String src , String dest , String helper) {
    	if(n==0)
    	return;
    	TowerOfHanoi(n-1 , src , helper , dest);
		System.out.println("move "+n+" disc from "+src+" to "+dest);
    	TowerOfHanoi(n-1 , helper , dest , src);
    	return;
    }
  

}
