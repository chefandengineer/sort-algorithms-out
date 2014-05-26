package cracking.chapter1;

public class SetMatrixToZero7 {
	public static void setMatrix(int[][] matrix){
		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix[0].length];
		
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length;j++){
				if(matrix[i][j] == 0){
					row[i] = true;
					column[j] = true;
				}
			}
		}
		
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length;j++){
				if(row[i] || column[j]){
					matrix[i][j] = 0;
				}
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
		matrix[1][2] = 0;
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
		setMatrix(matrix);
		for(int i = 0; i <= 2 ; i++){
			for(int j = 0; j <= 2 ; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
