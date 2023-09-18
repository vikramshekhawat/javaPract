import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] arr={-1,1};
        //System.out.println(unpaired(arr));
       // System.out.println(unpaired2(arr));
        System.out.println(getMinNo(arr));

    }



    public static void distinct(int[] arr){
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        set.stream().forEach(x-> System.out.println(x));
        System.out.println(set.size());
    }

    public static int getMinNo(int[] arr){
        int data=0;
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0){
                list.add(arr[i]);
            }
        }
        for(int i=1;i<arr.length;i++){
            if(!list.contains(i)){
                return i;
            }
        }
        data=arr.length+1;
        return data;
    }

//10001

//1,2,5,8,10,12
//1,1,7,9,9,
    public static int unpaired(int[] arr){
        int unpaired=0;
       // Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
                 unpaired ^=arr[i];
             }

        return unpaired;
    }
    public static int unpaired2(int[] A) {HashSet<Integer> dups = new HashSet<Integer>();
        int elem = -1;

        for (int i = 0; i < A.length; i++) {
            if (dups.add(A[i])) {
                elem = A[i];
            }
        }
        return elem;
    }

public static int countTriangle(int[] arr){
    Arrays.sort(arr);
    int triangleCount=0;
    if(arr.length<3){
        return 0;
    }
    for(int i=0;i<arr.length-2;i++){
        int k=i+2;
        for(int m=i+1;m<arr.length-1;m++){
            while(k<arr.length && arr[i]>arr[k]-arr[m]){
                k++;
            }
            triangleCount=triangleCount+(k-m-1);
        }
    }
return triangleCount;

}
    public static void rotatArray(int[] arr,int k){
        for(int i=0;i<k;i++){
            int lastValue=arr[arr.length-1];
            for(int j=arr.length-2;j>=0;j--){
                arr[j+1]=arr[j];
            }
            arr[0]=lastValue;
        }
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public static void rotateArray(String s){
        char[] arr = s.toCharArray();
        int k=arr.length;
        int[] newArr=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            int newPosition=(i+k) % (arr.length);
            newArr[newPosition]=arr[i];
        }
        for(int i=0;i<newArr.length;i++){
            System.out.println(newArr[i]);
        }
    }
public static int solution(int N) {
    int counter = 0;
    int maxCounter = 0;
    boolean flag = false;
    String bString = Integer.toString(N, 2);
    char[] charArray = bString.toCharArray();
    Character c;
    for (int i = 0; i < charArray.length; i++) {
        c = charArray[i];
        if (c.equals('1')) {
            if (counter > maxCounter) {
                maxCounter = counter;
            }
            counter = 0;
        }
        if (c.equals('0')) {
            counter++;
        }
    }
    return maxCounter;
}


}