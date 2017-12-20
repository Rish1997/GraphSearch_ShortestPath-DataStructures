import java.util.*;
import java.lang.*;
import java.io.*;


class MedianMaintenance {

    public static void main(String[] args) throws FileNotFoundException {
        int[] list = new int[10000];
        File file = new File("Median.txt");
        Scanner sc = new Scanner(file);
        long sum = 0;

        for (int i = 0; i < list.length; i++) {

            list[i] = sc.nextInt();
            Arrays.sort(list, 0, i+1);
            sum+=list[i/2];
        }
        System.out.println(sum%10000);

    }
}