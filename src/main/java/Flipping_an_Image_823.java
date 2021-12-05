class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int n=A.length;
        for (int[] a :A){
            for(int i = 0; i*2< n; i++){
                int tmp = a[i] ^ 1;
                a[i]= a[n-i-1]^1;
                a[n-i-1]=tmp;
            }
            
        }
        return A;
    }
}