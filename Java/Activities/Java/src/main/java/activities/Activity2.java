package activities;

public class Activity2 {
    public static void main(String[] args) {
        int[] a = {10, 77, 10, 54, -11, 10};

        int searchNum = 10;
        int fixedsum = 30;
        System.out.println("result is: " + sum(a, searchNum,fixedsum));
    }

    public static boolean sum(int[] a, int searchNum, int fixedsum) {
        int temp = 0;
        for (int num : a) {
            if (num == searchNum) {
                temp += num;
            }
            if (temp > fixedsum) {
                break;
            }

        }
        return temp == fixedsum;
    }
}
