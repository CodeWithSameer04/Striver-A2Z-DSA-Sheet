import java.util.*;

class Solution {
    public List<String> findPath(int[][] grid) {
        List<String> result = new ArrayList<>();
        int n = grid.length;

        if (grid[0][0] == 0)
            return result;

        boolean[][] visited = new boolean[n][n];
        dfs(0, 0, grid, visited, "", result);

        return result;
    }

    private void dfs(int i, int j, int[][] grid, boolean[][] visited,
                     String path, List<String> result) {

        int n = grid.length;

        // reached destination
        if (i == n - 1 && j == n - 1) {
            result.add(path);
            return;
        }

        visited[i][j] = true;

        // Down
        if (isSafe(i + 1, j, grid, visited))
            dfs(i + 1, j, grid, visited, path + "D", result);

        // Left
        if (isSafe(i, j - 1, grid, visited))
            dfs(i, j - 1, grid, visited, path + "L", result);

        // Right
        if (isSafe(i, j + 1, grid, visited))
            dfs(i, j + 1, grid, visited, path + "R", result);

        // Up
        if (isSafe(i - 1, j, grid, visited))
            dfs(i - 1, j, grid, visited, path + "U", result);

        visited[i][j] = false; // backtrack
    }

    private boolean isSafe(int i, int j, int[][] grid, boolean[][] visited) {
        int n = grid.length;
        return i >= 0 && j >= 0 && i < n && j < n
                && grid[i][j] == 1 && !visited[i][j];
    }
}
