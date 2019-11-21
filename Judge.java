import java.util.HashSet;
import java.util.Set;

public class Judge {

    /**
     * According to the relationship of trust, judge whether there is a judge in the town.
     *
     * @param N     According to the relationship of trust, judge whether there is a judge in the town.
     * @param trust Trust relationship
     * @return judge
     */
    public int findJudge(int N, int[][] trust) {
        int[][] graphIntoDegree = new int[N + 1][N + 1];
        int[][] graphOutDegree = new int[N + 1][N + 1];
        for (int i = 0; i < graphIntoDegree.length; i++) {
            graphIntoDegree[i] = new int[N + 1];
            graphOutDegree[i] = new int[N + 1];
        }
        for (int[] pair : trust) {
            graphIntoDegree[pair[1]][pair[0]] = 1;
            graphOutDegree[pair[0]][pair[1]] = 1;
        }
        for (int i = 1; i <= N; i++) {
            if (getOutDegree(graphOutDegree, i) == 0 && getInDegree(graphIntoDegree, i) == N - 1) {
                return i;
            }
        }
        return -1;
    }

    private int getOutDegree(int[][] graphOutDegree, int node) {
        int count = 0;
        for (int i = 1; i < graphOutDegree.length; i++) {
            count += graphOutDegree[node][i];
        }
        return count;
    }


    private int getInDegree(int[][] graphIntoDegree, int node) {
        int count = 0;
        for (int i = 1; i < graphIntoDegree.length; i++) {
            count += graphIntoDegree[node][i];
        }
        return count;
    }

    // public static void main(String[] args) {
    //     Judge judge = new Judge();
    //     int[][] arr1 = {{1, 2}};
    //     System.out.println(judge.findJudge(2, arr1));
    //     int[][] arr2 = {{1, 3}, {2, 3}};
    //     System.out.println(judge.findJudge(3, arr2));
    //     int[][] arr3 = {{1, 3}, {2, 3}, {3, 1}};
    //     System.out.println(judge.findJudge(3, arr3));
    //     int[][] arr4 = {{1, 2}, {2, 3}};
    //     System.out.println(judge.findJudge(3, arr4));
    //     int[][] arr5 = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
    //     System.out.println(judge.findJudge(4, arr5));
    // }


}
