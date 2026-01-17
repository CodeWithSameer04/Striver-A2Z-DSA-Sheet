import java.util.*;

class Main {
    
    static boolean canPlaceCows(long[] stalls, int n, int c, long dist) {
        int cowsPlaced = 1;
        long lastPos = stalls[0];

        for (int i = 1; i < n; i++) {
            if (stalls[i] - lastPos >= dist) {
                cowsPlaced++;
                lastPos = stalls[i];

                if (cowsPlaced == c)
                    return true;
            }
        }
        return false;
    }

    static long largestMinDistance(long[] stalls, int n, int c) {
        Arrays.sort(stalls);

        long low = 1;
        long high = stalls[n - 1] - stalls[0];
        long answer = 0;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (canPlaceCows(stalls, n, c, mid)) {
                answer = mid;
                low = mid + 1;   // try larger distance
            } else {
                high = mid - 1;  // reduce distance
            }
        }
        return answer;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();   // number of test cases

        while (t-- > 0) {
            int n = sc.nextInt();
            int c = sc.nextInt();

            long[] stalls = new long[n];
            for (int i = 0; i < n; i++) {
                stalls[i] = sc.nextLong();
            }

            System.out.println(largestMinDistance(stalls, n, c));
        }
        sc.close();
    }
}
