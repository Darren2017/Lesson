import java.util.*;

public class Matrix{
    public static void main(String[] args){
        int n, m, k;
        Scanner in = new Scanner(System.in);
        System.out.print("请输入矩阵1的行数");
        n = in.nextInt();
        System.out.print("请输入矩阵1的列数");
        m = in.nextInt();
        System.out.print("请输入矩阵2的列数：");
        k = in.nextInt();
        int[][] matrix1 = new int[n][m];
        int[][] matrix2 = new int[m][k];
        int[][] matrix3 = new int[n][k];
        System.out.println("请输入一个" + n + "行" + m + "列的行列式");
        for(int i = 0; i < matrix1.length; i++){
            for(int j = 0; j < matrix1[i].length; j++){
                matrix1[i][j] = in.nextInt();
            }
        }
        System.out.println("请输入一个" + m + "行" + k + "列的行列式");
        for(int i = 0; i < matrix2.length; i++){
            for(int j = 0; j < matrix2[i].length; j++){
                matrix2[i][j] = in.nextInt();
            }
        }
        for(int i = 0; i < matrix1.length; i++){
            for(int j = 0; j < matrix2[0].length; j++){
                matrix3[i][j] = 0;
                for(int l = 0; l < matrix2.length; l++){
                    matrix3[i][j] += matrix1[i][l] * matrix2[l][j];
                }
            }
        }

        System.out.println("矩阵相乘得：");
        for(int[] i:matrix3){
            for(int j:i){
                System.out.print(j + "  ");
            }
            System.out.println();
        }
    }
}