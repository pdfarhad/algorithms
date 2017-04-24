import java.util.Arrays;

class NQueenSolve{
    class Position{
        public int row,col;
        Position(int x, int y){
            this.row = x;
            this.col = y;

        }
    }
    public Position[] nQueenProblemSolve(int n){
        Position [] positions = new Position[n];

        boolean ifSolution = nQueenProblemSolveUtil(n,0,positions);
        if(ifSolution){
            System.out.println("Solutions" + positions);
            return positions;
        }
        else {
            System.out.println("No solution");
            return new Position[0];
        }

    }
    public boolean nQueenProblemSolveUtil(int n, int row, Position[] positions){
        if(n == row){
            return true;
        }
        
        for(int col = 0; col<n; col++){
            boolean isSafe = true;

            for(int queen = 0; queen < row; queen++){
                if(positions[queen].col == col || positions[queen].row - positions[queen].col == row - col 
                || positions[queen].row + positions[queen].col == row + col ){
                    isSafe = false;
                    break;
                }
            }
            if(isSafe)
            {
                positions[row] = new Position(row,col);
                if( nQueenProblemSolveUtil(n, row+1, positions)){
                     return true;
                  }
            }
            

        }

        return false;
    }
     public static void main(String[] args) {

        
        NQueenSolve n = new NQueenSolve();
        Position[] positions = n.nQueenProblemSolve(8);
        
        Arrays.stream(positions).forEach(position-> System.out.println(position.row + "  " + position.col));
        
        for(int i=0; i <8; i++){
            for(int j=0; j<8; j++){
                
                if(positions[i].row == i && positions[i].col == j){
                    // System.out.println(i + " Q " + j);
                    System.out.print(" Q ");
                }
                else
                    System.out.print(" . ");

            }
            System.out.println();
        }
    }
}