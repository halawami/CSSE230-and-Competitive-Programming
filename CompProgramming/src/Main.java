import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n =0;
		int xDim = 0;
		int yDim = 0;
		int zDim = 0;
		int mass = 0;
		int x1,y1,z1,v1,v2,v3 = 0;
		n = sc.nextInt();
		xDim=sc.nextInt();
		yDim = sc.nextInt();
		zDim = sc.nextInt();
		ArrayList<int[]>[] array = null; 
		for(int i=0;i<=n;i++){
			array[i] = getList(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(),sc.nextInt(),xDim,yDim,zDim);
		}
		for(int i=0;i<n;i++){
			for(int j =0;j<array[i].size();j++){
				if(array[i+1].contains(array[i].get(j))){
					System.out.println("true");
				}
			}
		}
		ArrayList<int[]> list = getList(12, 4, 1, 4, 5, 3, -2,8,8,8);
	}
	
	public static ArrayList<int[]> getList(int mass, int x1,int y1,int z1,int v1, int v2, int v3,int xBound,int yBound,int zBound){
		int[] initialPosition = {x1,y1,z1};
		ArrayList<int[]> positions = new ArrayList<>();
		int xPos = x1;
		int yPos = y1;
		int zPos = z1;	
		int count=0;
		while(true){
			int[] tempArr = {xPos%xBound,yPos%yBound,zPos%zBound};
			positions.add(tempArr);
			if(count>0 && Arrays.equals(positions.get(0), tempArr)){
				break;
			}	
			for(int i =0;i<tempArr.length;i++){
				System.out.print(tempArr[i] + " ");
			}
			System.out.println();
			if(xPos+v1<0){
				xPos = xBound+v1;
			}else{
			xPos = Math.abs(xPos+v1);
			}
			if(yPos+v2<0){
				yPos = yBound+v2;
			}else{
			yPos = Math.abs(yPos+v2);
			}
			if(zPos+v3<0){
				zPos = zBound+v3;
			}else{
			zPos = Math.abs(zPos+v3);
			}
			count++;
		}
		return positions;
	}
}
