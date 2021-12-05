public class validMountainArray_941 {
    public boolean validMountainArray(int[] arr) {
        int max = 0;
        int maxIndex= 0;
        for (int i=0 ;i<arr.length; i++){
            if(arr[i]>=max){
                max = arr[i];
                maxIndex = i;
            }
        }
        if(maxIndex==0 ||maxIndex==arr.length -1){
            return false;
        }
        for(int i=0 ;i<arr.length-1; i++){
            if(i<maxIndex ){
                if(!(arr[i]<arr[maxIndex]) || !(arr[i]<arr[i+1])|| !(arr[i]!=arr[i+1])){
                    return false;

                }
            }else if(i>maxIndex){
                if(!(arr[i]<arr[maxIndex])|| !(arr[i]>arr[i+1])||!(arr[i]!=arr[i+1])){
                    return false;
                }
            }
        }
        return true;
    }
}
