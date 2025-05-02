package com.array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Array {
    public static void main(String[] args) {
        int[] input = {10, 2, 5, 6, 11, 3, 15};
//        int[] input = {10, 2, 5, 6, 15,10,20,56,10};
//        int[] input = {1, 2, 3, 5, 5};
//        System.out.println(birthdayCakeCandles(input));
//        miniMaxSum1(input);
//        miniMaxSum(input);
//        System.out.println(getBattery(Arrays.asList(4, 25, -30, 70, -10)));
//        System.out.println(min(input));
//        System.out.println(longestSubarray(Arrays.asList(3, 2, 2, 1)));
//        System.out.println(xorOfArray(input));
//        staircase(6);
//        print(6);
//        System.out.println(timeConversion("07:05:45PM"));
//        anylyzeArrays();
        System.out.printf("Effects of passing reference to entire array: %n" + "The values of the original array are: %n");
        for (int value: input) {
            System.out.printf(" %04d", value);
        }
        modifyArray(input);
        System.out.printf("%n%nThe values of the modified array are:%n");

        for (int value:input) {
            System.out.printf(" %04d", value);
        }

        System.out.printf("%n%nEffects of passing array element value:%n" + "array[3] before modifyElement: %d%n", input[3]);

        modifyElements(input[3]);
        System.out.printf("array[3] after modifyElement: %d%n", input[3]);

    }

    static  double average(double... numbers){
        double total = 0.0;
        for (double tmp: numbers) {
            total+=tmp;
        }
        return total;
    }

    static void modifyArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i]*=2;
        }
    }
    static void modifyElements(int el){
        el*=2;
        System.out.printf("Value of element in modify element: %d%n", el);
    }

    static void anylyzeArrays(){
        int[] response = {1,2,5,4,3,5,2,1,3,3,1,4,3,3,3,2, 3, 3, 2, 14 };
        int[] frequency = new int[6];
        for (int answer = 0; answer < response.length; answer++) {
            try {
                ++frequency[response[answer]];
            }catch (ArrayIndexOutOfBoundsException ex){
                System.out.println(ex);
                System.out.printf("response[%d] = %d%n%n",answer,response[answer]);
            }
            
        }
        System.out.printf("%s%10s%n","Rating", "Frequency");
        for (int rating = 0; rating < frequency.length; rating++) {
            System.out.printf("%6d%10d%n",rating, frequency[rating]);
        }
    }

    static String timeConversion(String s) {
        StringBuilder res= new StringBuilder(s);
        String time= s.substring(s.length()-2,s.length());
        int parseTime=Integer.valueOf(s.substring(0,2));
        if (time.equals("AM")){
            if (parseTime==12)
                res.replace(0,2,"00");
            return res.substring(0,res.length()-2);
        }
        else{
            if (parseTime==12){
                res.substring(0,res.length()-2);
            }else{
                parseTime+=12;
                res.replace(0,2,String.valueOf(parseTime));
            }

            return res.substring(0,res.length()-2);
        }
    }


    public static void print(int n) {
        String c = "*";
        for (int i = 1; i <= n; i++) {
            int star = 1;
            String s = "";
            while (star <= i) {
                s += c;
                star++;
            }
            System.out.printf("%6s\n", s);
        }
    }

    static long min;
    static long max;

    public static void generate(int[] arr, LinkedList<Integer> list, boolean[] visited) {
        if (list.size() == 4) {
            min = Math.min(min, cal(list));
            max = Math.max(max, cal(list));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                list.add(arr[i]);
                visited[i] = true;
                generate(arr, list, visited);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    public static long cal(LinkedList<Integer> list) {
        long res = 0;
        for (int a : list) {
            res += a;
        }
        return res;
    }

    static void miniMaxSum(int[] arr) {
        min = Long.MAX_VALUE;
        max = Long.MIN_VALUE;
        boolean[] visited = new boolean[arr.length];
        generate(arr, new LinkedList<>(), visited);
        System.out.printf("%d %d\n", min, max);
    }


    static void miniMaxSum1(int[] arr) {
        int max, min, sum;
        sum = min = max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum +=arr[i];
            if (max > arr[i]) {
                if (min > arr[i])
                    min = arr[i];
            } else
                max = arr[i];
        }
        System.out.println((sum - max) + " " + (sum - min));
    }

    static int birthdayCakeCandles(int[] ar) {
        int count =0;
        int max =ar[0];
        for (int i = 0; i < ar.length; i++) {
            int temp= max;
            if(max==ar[i]){
                count++;
            }else if(max<ar[i]){
                count=0;
                max=ar[i];
                count++;
            }

        }
        return count;

    }




    public static void rotatingArray(int[] arr, int n, int d) {
        if (arr.length == 0)
            return;

    }

    static void staircase(int n) {
        if (n == 0)
            return;
//        for (int i = 1; i <= n; ++i) {
//            for (int j=1; j<=n-i;++j){
//                System.out.print('\u00a0');
//            }
//            for (int j = n-i+1; j <=n ; ++j) {
//                System.out.print("#");
//            }
//            System.out.println("");
//        }
//        for (int i = 1; i <n ; i++) {
//            System.out.println(new String(new char[n-i]).replace("\0","")+new String(new char[i]).replace("\0","#"));
//        }
        char[] arreglo = new char[n];
        Arrays.fill(arreglo, ' ');
        int i = 0;
        for (i = 1; i <= n; i++) {
            arreglo[n - i] = '#';
            System.out.println(arreglo);
        }


    }


    static void plusMinus(int[] arr) {
        int n = arr.length;
        if (n == 0)
            return;
        double plus = 0;
        double zero = 0;
        double minus = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                plus++;
            } else if (arr[i] < 0) {
                minus++;
            } else {
                zero++;
            }
        }
        System.out.println(plus / n);
        System.out.println(minus / n);
        System.out.println(zero / n);


    }

    public static int xorOfArray(int[] arr) {
        if (arr.length == 0)
            return 0;
        int xor_arr = 0;
        for (int i = 0; i < arr.length; i++) {
            xor_arr = xor_arr ^ arr[i];
        }
        return xor_arr;
    }

    public static int min(int[] arr) {
        int min = arr[0];
        int min1 = arr[1];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min1 = min;
                min = arr[i];
            } else if (arr[i] < min1) {
                min1 = arr[i];
            }
        }
        return min1;
    }

    public static int getBattery(List<Integer> events) {

        int initBattery = 50;
        if (events.isEmpty())
            return initBattery;
        for (int i = 1; i < events.size(); i++) {
            initBattery = initBattery + events.get(i);
            if (initBattery >= 100) {
                initBattery = 100;
            } else if (initBattery <= 0) {
                initBattery = 0;
            }
        }
        return initBattery;
    }

    public static int longestSubarray(List<Integer> arr) {
        int size = 1;
        if (arr.isEmpty())
            return size;
        List<Integer> tempList = new ArrayList<>();
        for (int i = 1; i < arr.size() - 1; i++) {
            for (int j = 2; j < arr.size(); j++) {
                int temp = arr.get(j) - arr.get(i);
                if (temp == 0 || temp == 1) {
                    size++;
                }
            }
        }
        return size;
    }
}
