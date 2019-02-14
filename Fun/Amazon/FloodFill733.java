package Fun.Amazon;

public class FloodFill733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] != newColor) {
            dfs(image, sr, sc, image[sr][sc], newColor);
        }
        return image;
    }
    public void dfs(int[][] image, int x, int y, int color, int newColor) {
        if (isOutOfBound(x, y, image.length, image[0].length)) {
            return;
        }
        int currentColor = image[x][y];
        if (currentColor == color) {
            image[x][y] = newColor;
            dfs(image, x - 1, y, currentColor, newColor);
            dfs(image, x, y - 1, currentColor, newColor);
            dfs(image, x + 1, y, currentColor, newColor);
            dfs(image, x, y + 1, currentColor, newColor);
        }
    }

    private boolean isOutOfBound(int x, int y, int row, int col) {
        return x < 0 || x >= row || y < 0 || y >= col;
    }
}
