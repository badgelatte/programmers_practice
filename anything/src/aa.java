import java.util.ArrayList;
import java.util.List;

class Pair{
    int row;
    int column;

    Pair(int row, int column) {
        this.row = row;
        this.column = column;
    }

}

class aa {
    public static void main(String[] args) {
        // solution2(new int[][]{{0, 0, 0, 0, 0}, {0, 1, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}});
        solution(new int[][]{{1}});
    }

    public static int solution2(int[][] board) {
        int answer = 0;
        List<int[]> landmineList = new ArrayList<>();
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j] == 1) {
                    landmineList.add(new int[]{i,j});
                }
            }
        }

        // board = checkTominus(board, landmineList);

        for (int[] landmineLoc : landmineList) {
            System.out.println(landmineLoc[0]+", "+landmineLoc[1]);
            
        }
        return answer;
    }

    public int[][] checkTominus(int[][] board, List<int[]> list) {
        int max = board.length - 1;
        List<int[]> dangerList = new ArrayList<>();

        for (int[] landmine : list) {
            int row = landmine[0];
            int column = landmine[1];

            if(landmine[0] == 0) {
                if(landmine[1] == 0) {
                    dangerList.add(new int[]{0,1});
                    dangerList.add(new int[]{1,0});
                    dangerList.add(new int[]{1,1});
                    continue;
                }
                if(landmine[1] == max) {
                    dangerList.add(new int[]{0, max - 1});
                    dangerList.add(new int[]{1, max - 1});
                    dangerList.add(new int[]{1, max});
                    continue;
                }
                dangerList.add(new int[]{0, column - 1});
                dangerList.add(new int[]{0, column + 1});
                dangerList.add(new int[]{1, column - 1});
                dangerList.add(new int[]{1, column});
                dangerList.add(new int[]{1, column + 1});
                continue;
            }
            if(landmine[0] == max) {
                if(landmine[1] == 0) {
                    dangerList.add(new int[]{max - 1, 0});
                    dangerList.add(new int[]{max - 1, 1});
                    dangerList.add(new int[]{max, 1});
                    continue;
                }
                if(landmine[1] == max) {
                    dangerList.add(new int[]{max - 1, max - 1});
                    dangerList.add(new int[]{max -1, max});
                    dangerList.add(new int[]{max, max - 1});
                    continue;
                }
                dangerList.add(new int[]{max - 1, column -1});
                dangerList.add(new int[]{max - 1, column});
                dangerList.add(new int[]{max - 1, column + 1});
                dangerList.add(new int[]{max, column - 1});
                dangerList.add(new int[]{max, column + 1});
                continue;
            }
            if(landmine[1] == 0) {
                dangerList.add(new int[]{row - 1, 0});
                dangerList.add(new int[]{row - 1, 1});
                dangerList.add(new int[]{row, 1});
                dangerList.add(new int[]{row + 1, 0});
                dangerList.add(new int[]{row + 1, 1});
                continue;
            }
            if(landmine[1] == max) {
                dangerList.add(new int[]{row - 1, column - 1});
                dangerList.add(new int[]{row - 1, column});
                dangerList.add(new int[]{row, column - 1});
                dangerList.add(new int[]{row + 1, column - 1});
                dangerList.add(new int[]{row + 1, column});
                continue;
            }

            dangerList.add(new int[]{row - 1, column - 1});
            dangerList.add(new int[]{row - 1, column});
            dangerList.add(new int[]{row - 1, column + 1});
            dangerList.add(new int[]{row, column - 1});
            dangerList.add(new int[]{row, column + 1});
            dangerList.add(new int[]{row, column - 1});
            dangerList.add(new int[]{row + 1, column - 1});
            dangerList.add(new int[]{row + 1, column});
            dangerList.add(new int[]{row + 1, column + 1});
        }

        return board;
    }

    public static int solution(int[][] board) {
        int length = board.length;
        
        if(length == 1) {
            return OneSpace(board[0][0]);
        }

        for(int i = 0; i < length; i++) {
            for(int j = 0; j < length; j++) {
                int outlines = 0;
                if((outlines = isDangerous(i, j, board)) > 0) {
                    board = checkDangerous(i, j, board, outlines);
                }
            }
        }
        
        return safeSpaceCount(board);
    }

    public static int OneSpace(int space) {
        if(space == 0) {
            return 1;
        }
        return 0;
    }
    
    public static int isDangerous(int row,int column, int[][] board) {
        int space = 0;
        if(board[row][column] == 0 || board[row][column] == -1) {
            return 0;
        }
        
        space++;
        
        if(row == 0) {
            space++;
        }
        if(column == 0) {
            space++;
        }
        if(row == board.length - 1) {
            space++;
        }
        if(column == board.length - 1) {
            space++;
        }
        
        return space;
    }

    public static int[][] checkDangerous(int row, int column, int[][] board, int outlines) {
        if(outlines == 1) { // 테두리를 인접하지 않은 곳에서 지뢰 발견한 경우
            board[row - 1][column - 1] = (board[row - 1][column - 1] == 1 ? 1 : -1);
            board[row - 1][column] = (board[row - 1][column] == 1 ? 1 : -1);
            board[row - 1][column + 1] = (board[row - 1][column + 1] == 1 ? 1 : -1);
            board[row][column - 1] = (board[row][column - 1] == 1 ? 1 : -1);
            board[row][column + 1] = (board[row][column + 1] == 1 ? 1 : -1);
            board[row + 1][column - 1] = (board[row + 1][column - 1] == 1 ? 1 : -1);
            board[row + 1][column] = (board[row + 1][column] == 1 ? 1 : -1);
            board[row + 1][column + 1] = (board[row + 1][column + 1] == 1 ? 1 : -1);
            
            return board;
        }
        
        if(outlines == 2) { // 모서리가 아닌 테두리에 지뢰가 있는 경우
            if(row == 0) {
                board[0][column - 1] = (board[0][column - 1] == 1 ? 1 : -1);
                board[0][column + 1] = (board[0][column + 1] == 1 ? 1 : -1);
                board[1][column - 1] = (board[1][column - 1] == 1 ? 1 : -1);
                board[1][column] = (board[1][column] == 1 ? 1 : -1);
                board[1][column + 1] = (board[1][column + 1] == 1 ? 1 : -1);
            }
            if(column == 0) {
                board[row - 1][0] = board[row - 1][0] == 1 ? 1: -1;
                board[row - 1][1] = board[row - 1][1] == 1 ? 1 : -1;
                board[row][1] = board[row][1] == 1 ? 1 : -1;
                board[row + 1][0] = board[row + 1][0] == 1 ? 1 : -1;
                board[row + 1][1] = board[row + 1][1] == 1 ? 1 : -1;
            }
            if(row == board.length - 1) {
                board[row - 1][column - 1] = board[row - 1][column - 1] == 1 ? 1 : -1;
                board[row - 1][column] = board[row - 1][column] == 1 ? 1 : -1;
                board[row - 1][column + 1] = board[row - 1][column + 1] == 1 ? 1 : -1;
                board[row][column - 1] = board[row][column - 1] == 1 ? 1 : -1;
                board[row][column + 1] = board[row][column + 1] == 1 ? 1 : -1;
            }
            if(column == board.length - 1) {
                board[row - 1][column - 1] = board[row - 1][column - 1] == 1 ? 1 : -1;
                board[row - 1][column] = board[row - 1][column] == 1 ? 1 : -1;
                board[row][column - 1] = board[row][column - 1] == 1 ? 1 : -1;
                board[row + 1][column - 1] = board[row + 1][column - 1] == 1 ? 1 : -1;
                board[row + 1][column] = board[row + 1][column] == 1 ? 1 : -1;
            }
            
            return board;
        }
        
        // 모서리에 지뢰가 있는 경우
        if(row == 0) {
            board[1][column] = board[1][column] == 1 ? 1 : -1;
            if(column == 0) {
                board[0][1] = board[0][1] == 1 ? 1 : -1;
                board[1][1] = board[1][1] == 1 ? 1 : -1;
            } else {
                board[0][column - 1] = board[0][column - 1] == 1 ? 1 : -1;
                board[1][column - 1] = board[1][column - 1] == 1 ? 1 : -1;
            }
        }
        if(row == board.length - 1) {
            board[row - 1][column] = board[row - 1][column] == 1 ? 1 : -1;
            if(column == 0) {
                board[row][1] = board[row][1] == 1 ? 1 : -1;
                board[row - 1][1] = board[row - 1][1] == 1 ? 1 : -1;
            } else {
                board[row][column - 1] = board[row][column - 1] == 1 ? 1 : -1;
                board[row - 1][column - 1] = board[row - 1][column - 1] == 1 ? 1 : -1;
            }
        }
        
        return board;
    }
    
    public static int safeSpaceCount(int[][] board) {
        int count = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if(board[i][j] == 0) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
}