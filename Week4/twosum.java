import java.util.*;
import java.io.*;

class Main
{
    static int hasArrayTwoCandidates(long A[], int arr_size, int sum)
    {
        int l;
       
        /* Sort the elements */
        Arrays.sort(A);
        
        Set<Long> linkedHashSet = new LinkedHashSet<>();
       
        /* Now look for the two candidates 
           in the sorted array*/
        l = 0;
       // r = 1; 
        while (l < arr_size )
        {
            long x = A[l++];
            int r = l;
            //if(A[l] + A[r] == 16){
                // System.out.println("hello");
                while(r < arr_size-1){
                    long y = A[r++];
                    //System.out.println(linkedHashSet.size());
                    if (x != y && x + y <= sum && x+y >= -1 * sum ){
                        linkedHashSet.add(x+y);
                        System.out.println(linkedHashSet.size());
                        //continue;
                    }
                }
            //  if(A[l] + A[r] <= sum && A[l] + A[r] >= -1 * sum && A[l] != A[r]){
            //     linkedHashSet.add(A[l]+A[r]);
            //     // linkedHashSet.add(A[r]);
            //     System.out.println(linkedHashSet.size());
            //     l++;
            //     r--;
            //  }
            //  else if(A[l] + A[r] < -1*sum )
            //       l++;
            //  else // A[i] + A[j] > sum
            //       r--;
        }    
        return linkedHashSet.size();
    }
      
    //main function
    public static void main(String args[]) throws FileNotFoundException
    {
        File file = new File("./2sum.txt");
        Scanner sc = new Scanner(file);
        long[] A = new long[1000001];
        int i = 0;
        while(sc.hasNext()){
            A[i++] = Long.parseLong(sc.nextLine());
        }
        
         //long A[] = {1, 4, 45, 6, 10, -8};
        int n = 10000;
        // int arr_size = 6;
          
            System.out.println(hasArrayTwoCandidates(A, A.length, n));
       
    }
}