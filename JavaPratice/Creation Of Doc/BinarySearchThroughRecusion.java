/**
 * Here showing how to search a elements in an array by Binary Search through Recursion
 */

public class BinarySearchThroughRecusion{
    static int binarySearch(int arr[],int s,int e,int serNo){
        while(s<=e){
            int mid= (s+e)/2;
            if(arr[mid]<serNo){
                return binarySearch(arr, mid+1, e, serNo);
            }
            else if(arr[mid]>serNo){
                return binarySearch(arr, s, mid-1, serNo);
            }
            else{
                return mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = new int[]{1, 5,8,10,13,18,19};
       int res= binarySearch(arr,0,arr.length-1,1);
       if(res>-1){
        System.out.println("postion is -: "+res);
       }else{
        System.out.println("eleemnt not present");
       }
    }
    
}
