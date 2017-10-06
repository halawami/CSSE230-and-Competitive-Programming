import org.omg.PortableInterceptor.ORBInitInfoPackage.DuplicateName;

public class Testingg {
	public static void main(String[] args) throws DuplicateName{
		double Fin = 7.37;
		double toFind = 60;
		int counter = 0;  //pllpre
		int counter2 = 0; //plldiv
		int counter3 =0;  //pllpost
		double error=10;
		
////		while((Fin / (counter + 2)) <= 8 && (Fin / (counter + 2)) >= 0.8){
		for(int i =1;i<=9.21;i++){
//	        while(((Fin * (counter2 + 2)) / (i + 2)) <= 340 && ((Fin * (counter2 + 2)) / (i + 2)) >= 120){
			for(int j = 46;j<=515;j++){
//	            while(counter3<1000){
        		for(int k =0;k<=41;k++){
        			double num = (j+2);
        			double denom = (i+2)*2*(k+2);
	                double Fosc = Fin*(num/denom);
//	                		((Fin * (j + 2)) / ((i + 2) * 2 * (k + 2)));
	                if(Fosc == toFind || Math.abs(Fosc-toFind)/(toFind)<=0.005){
	                	if(error>Math.abs(Fosc-toFind)/(toFind)){
	                		counter =i;
	                		counter2 = j;
	                		counter3 = k;
	                		System.out.println(Fosc);
	                		error = Math.abs(Fosc-toFind)/(toFind);
	                		System.out.println("PLL-Pre = " + counter);
	                        System.out.println("PLL-Div = " + counter2);
	                        System.out.println("PLL-Post = " + counter3);
	                        System.out.println(error);
//	                        System.out.println(((Fin * (j + 2)) / ((i + 2) * 2 * (k + 2))));
	                	}
	                }
	            }	
	        }	
		}	
		
//		int n =8;
//		int sum = 0;
//		for(int i =0;i<=n+2;i++){
//			for(int j =0; j<n*n;j++){
//				sum++;
//			}
//		} 
//		System.out.println(sum);

//		runs (n+3)*n^2 times
		
//		for(int i =0;i<n;i++){
//			for(int j =i; j<n;j++){
//			System.out.println(sum++);
//			}
//		} 
//		runs (n+(n-1)+(n-2)...) times (n+1comb2) or (n(n+1))/2
//
		
//		for(int i =1;i<=n;i++){
//			for(int j =1;j<=i*i;j++){
//				if(j%i==0){
//					for(int k =0;k<j;k++){
//						System.out.println(sum++);
//					}
//				}
//			}
//		}
		
		
//		for(int i =n;i>0;i/=2){
//			for(int j =0; j<i;j++){
//				System.out.println(sum++);
//			}
//		} 
		//runs log2(n)+1 times
		
//		for(int i =n;i>=1;i=i/2){
//			System.out.println(i);
//		}	
		//runs log2(n)+1 times, rounds up
	}
}
