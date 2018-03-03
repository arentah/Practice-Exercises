public class Ch1_Question7 {
    public static void main(String[] args){

        int[][] test = new int[][]{ {11,12,13,14,15}, {16,17,18,19,20},
                {21,22,23,24,25}, {26,27,28,29,30}, {31,32,33,34,35} };
        System.out.println("before rotating\n--------------");
        printNxNMatrix(test);
        test = rotateMatrix(test);
        System.out.println("\nafter rotating\n--------------");
        printNxNMatrix(test);

    }
    public static int[][] rotateMatrix(int[][] mtx){
        //rotate 90 degrees counter clockwise
        //first make transpose, columns become rows or rows become columns
        //second reverse columns of transpose
        int count = 0;
        for(int i = 0; i < mtx.length ; i++){
            for(int j = 0; j < mtx[0].length; j++){
                if(i == j)
                    continue;
                if(i >= count && j >= count){
                    int tmp = mtx[i][j];
                    mtx[i][j] = mtx[j][i];
                    mtx[j][i] = tmp;
                }
            }
            count++;
        }

        int inc = 0;
        for(int i = mtx.length-1; i >= ( (mtx.length % 2 == 0) ? (mtx.length/2) : ((mtx.length/2)+1)) ; i--){
            for(int j = 0; j < mtx[0].length; j++){
                int tmp = mtx[i][j];
                mtx[i][j] = mtx[inc][j];
                mtx[inc][j] = tmp;
            }
            inc++;
        }
        return mtx;
    }

    public static void printNxNMatrix(int[][] mtx){
        for(int i = 0; i < mtx.length; i++ ){
            for(int j = 0; j < mtx[0].length; j++){
                System.out.print(mtx[i][j]+" ");
            }
            System.out.println();
        }
    }
}
