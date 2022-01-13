public class PredictTheWinner_486 {
    static int[] numsCopy;
    public static boolean PredictTheWinner(int[] nums) {
        if(nums.length==1) return true;
        int end = nums.length-1;
        numsCopy =nums;
        return helper(0, end, true, 0,0);
    }
    public static boolean helper(int start, int end, boolean isPlayer1, int player1score, int player2score ){
        if(start == end){
            return player1score-player2score>=0 ? true: false;
        }else{
            if(numsCopy[start] > numsCopy[end]) {
                if(isPlayer1){
                    player1score+=numsCopy[start];
                }else{
                    player2score+=numsCopy[start];
                }
                start++;
//            }else if(numsCopy[start] == numsCopy[end]){
//                if(numsCopy[start+1]>numsCopy[end-1]){
//                    if(isPlayer1){
//                        player1score+=numsCopy[end];
//                    }else{
//                        player2score+=numsCopy[end];
//                    }
//                    end--;
//                }else{
//                    if(isPlayer1){
//                        player1score+=numsCopy[start];
//                    }else{
//                        player2score+=numsCopy[start];
//                    }
//                    start++ ;
//                }
            }else{
                if(isPlayer1){
                    player1score+=numsCopy[end];
                }else{
                    player2score+=numsCopy[end];
                }
                end--;
            }
            return helper(start, end, !isPlayer1, player1score,player2score);
        }
    }

    public static void main(String[] args) {
        System.out.println(PredictTheWinner(new int[]{1,5,233,7}));
    }
}

