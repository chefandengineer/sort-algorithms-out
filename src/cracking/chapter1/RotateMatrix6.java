package cracking.chapter1;

import java.util.Arrays;

public class RotateMatrix6 {
	public static void rotate(int[][] matrix, int n){
	for(int i = 0; i <= n/2; i++) {
			for(int j = i; j <= n - i; j++) {
				//top to right
				int temp = matrix[j][n - i];
				matrix[j][n-i] = matrix[i][j];
		    	matrix[i][j] = matrix[j][i];
		    	matrix[j][i] = matrix[n-i][j];
				matrix[n-i][j] = temp;			
			}
		}	
	}
	public static void main(String[] args){
		int[][] matrix = new int[3][3];
		matrix[0][0] = 1;
		matrix[0][1] = 2;
		matrix[0][2] = 3;
		matrix[1][0] = 4;
		matrix[1][1] = 5;
		matrix[1][2] = 6;
		matrix[2][0] = 7;
		matrix[2][1] = 8;
		matrix[2][2] = 9;
		for(int i = 0; i <= 2 ; i++){
			for(int j = 0; j <= 2 ; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		rotate(matrix,2);
		for(int i = 0; i <= 2 ; i++){
			for(int j = 0; j <= 2 ; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
