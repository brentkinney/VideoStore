public class Misc {
    public static void main(String[] args) {

        int n = 4; // Number of disks
        towerOfHanoi(n, 'A', 'C', 'B'); // A, B and C are names of rods

        System.out.println();
        System.out.println();

        int[] A = { 2, 4, 6, 8, 10 };
        System.out.println("Non recursive result");
        System.out.println(containsSum(A, 12));
        System.out.println();
        System.out.println();
        System.out.println("Recursive result");
        System.out.println(containsSumRecursive(A, 12));

    }

    /**
     * method to move all discs from one rod to another without placing larger discs on smaller ones
     * @param n number of discs to use
     * @param from_rod name of first rod, A
     * @param to_rod name of second rod, B
     * @param aux_rod name of third rod, C
     */
    static void towerOfHanoi(int n, char from_rod, char to_rod, char aux_rod) {
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + from_rod + " to rod " + to_rod);
            return;
        }
        towerOfHanoi(n - 1, from_rod, aux_rod, to_rod);
        System.out.println("Move disk " + n + " from rod " + from_rod + " to rod " + to_rod);
        towerOfHanoi(n - 1, aux_rod, to_rod, from_rod);
    }

    public static boolean containsSum(int[] A, int sum) {
        for (int i = 0, j = A.length - 1; i < j;) {
            if (A[i] + A[j] == sum)
                return true;
            if (A[i] + A[j] < sum)
                i++;
            else
                j--;
        }
        return false;
    }

    /**
     * determine if ordered int array contains two elements that sum to given int
     * @param A ordered int array to check
     * @param sum value of int to check if elements sum too
     * @return true if two elements sum to given int, false if not
     */
    public static boolean containsSumRecursive(int[] A, int sum) {
        return containsSumRecursive(A, sum, 0, A.length - 1);
    }
    
    private static boolean containsSumRecursive(int[] A, int sum, int i, int j) {
        if (i == j)
            return false;
        if (A[i] + A[j] == sum)
            return true;
        if (A[i] + A[j] < sum)
            return containsSumRecursive(A, sum, i + 1, j);
        return containsSumRecursive(A, sum, i, j - 1);
    }

}
