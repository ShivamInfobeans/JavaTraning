package day2;

public class Day2 {
    /**
     *
     * @param arr1
     * @param a
     * @return
     */
    public int Fun( int[] arr1,int a)
    {

        for(int i=0;i<arr1.length;i++)
        {
            if(arr1[i]==a)
            {
                return i;
            }
        }
        return -1;

    }
    // 1 2 3 4 5 6
    public int[] reverse(int []arr)
    {
        int n= arr.length-1;
        int temp;
        for(int i=0;i< arr.length/2;i++)
        {
            temp=arr[i];
            arr[i]=arr[n];
            arr[n]=temp;
            n--;
        }
        return arr;
    }
    public static void main(String args[])
    {

    }
}
