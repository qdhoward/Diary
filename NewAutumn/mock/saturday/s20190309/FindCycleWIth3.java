package NewAutumn.mock.saturday.s20190309;

import java.util.Arrays;

public class FindCycleWIth3 {
//    public boolean findCycle(boolean[][] matches) {
//        boolean[][] adj = new boolean[matches.length][matches.length];
//        int[] visited = new int[matches.length];
//        buildGraph(matches, visited);
//
//        StringBuilder sb = new StringBuilder();
//        for(int i = 0; i < N; i++) {
//            if(visited[i] == 0) {                 // unvisited
//                if(!dfs(adj, visited, sb, i)) return "";
//            }
//        }
//        return sb.reverse().toString();
//    }
//
//    private boolean dfs(boolean[][] matches, int[] visited, int i, int[] length) {
//        visited[i] = 1;                            // 1 = visiting
//        for(int j = 0; j < matches.length; j++) {
//            if(matches[i][j]) {                        // connected
//                if(visited[j] == 1 && length[0] == 3) { // 1 => 1, cycle
//                    return true;
//                }
//                if(visited[j] == 0) {              // 0 = unvisited
//                    length[0]++;
//                    if(!dfs(matches, visited, j, length)) {
//                        return false;
//                    }
//                }
//            }
//        }
//        visited[i] = 2;                           // 2 = visited
//        length[0]--;
//        return false;
//    }
//
//    private void buildGraph(boolean[][] matches, int[] visited) {
//        Arrays.fill(visited, -1);                 // -1 = not even existed
//        for (int i = 0; i < matches.length; i++) {
//            for (int j = 0; j < matches.length; j++) {
//                if (matches[i][j]) {
//                    visited[i] = 0;
//                    visited[j] = 0;
//                }
//            }
//        }
//    }
}
