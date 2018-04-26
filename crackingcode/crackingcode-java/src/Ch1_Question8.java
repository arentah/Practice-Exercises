import java.util.ArrayList;

public class Ch1_Question8 {
    public static void main(String[] args){
        int[][] tmp = {{1,0,3,4,5}, {6,7,8,0,1}, {9,8,7,6,5}};
        for(int i = 0; i < tmp.length; i++){
            for(int j = 0; j < tmp[0].length; j++){

                if(j < tmp[0].length - 1)
                    System.out.print(tmp[i][j] + " ");
                else
                    System.out.print(tmp[i][j]+"\n");
            }
        }
        System.out.println();
        tmp = matrx(tmp);
        for(int i = 0; i < tmp.length; i++){
            for(int j = 0; j < tmp[0].length; j++){

                if(j < tmp[0].length - 1)
                    System.out.print(tmp[i][j] + " ");
                else
                    System.out.print(tmp[i][j]+"\n");
            }
        }
    }

    public static int[][] matrx(int[][] mtx){
        ArrayList<Integer> arr = new ArrayList<>();
        int m = mtx.length;
        int n = mtx[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mtx[i][j] == 0){
                    arr.add(i);
                    arr.add(j);
                }
            }
        }
        for(int k = 0; k < arr.size(); k = k + 2){
            int first = arr.get(k);
            int second = arr.get(k+1);
            for(int i = 0; i < m; i ++)
                mtx[i][second] = 0;
            for(int j = 0; j < n; j++)
                mtx[first][j] = 0;
        }
        return mtx;
    }
}
