public class RichestCustomerWealth_1672 {
    public int maximumWealth(int[][] accounts) {
        int max_wealth= 0;
        for(int i =0; i< accounts.length; i++){
            int total=0;
            for(int j =0; j< accounts[i].length; j++){
                total+=accounts[i][j];
            }
            max_wealth = Math.max(max_wealth,total);
        }
        return max_wealth;
    }
}

//example
//        int[][] foo = new int[][] {
//        new int[] { 1, 2, 3 },
//        new int[] { 1, 2, 3, 4},
//        };
//
//        System.out.println(foo.length); //2
//        System.out.println(foo[0].length); //3
//        System.out.println(foo[1].length); //4

//A11 A12  A13 ...A1N
//A21 A22  A23 ...A2N
//.
//.
//.
//Am1 Am2  Am3 ...AmN