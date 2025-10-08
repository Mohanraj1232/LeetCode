import java.io.*;
import java.util.*;
public class Labyrinth{
    static int n, m;
    static char[][] grid;
    static boolean[][] visited;
    static int[][] parentDir;
    static int startX, startY,endX,endY;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static char[] dirChar = {'U','D','L','R'};
    static boolean bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{startX, startY});
        visited[startX][startY] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            if(x == endX && y == endY){
                return true;
            }
            for(int d=0;d<4;d++){
                int nx=x+dx[d];
                int ny=y+dy[d];
                if(nx<0 || nx>=n || ny<0 || ny>=m){
                    continue;
                }
                if(grid[nx][ny]== '#' || visited[nx][ny]){
                    continue;
                }
                visited[nx][ny]=true;
                parentDir[nx][ny]= d;
                q.add(new int[]{nx,ny});
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        FastScanner fs= new FastScanner();
        StringBuilder sb =new StringBuilder();
        n= fs.nextInt();
        m = fs.nextInt();
        grid = new char[n][m];
        visited= new boolean[n][m];
        parentDir = new int[n][m];
        for(int i = 0; i < n; i++){
            String line = fs.next();
            for(int j = 0; j < m; j++){
                grid[i][j] = line.charAt(j);
                if(grid[i][j]== 'A'){
                    startX= i;
                    startY =j;
                }else if(grid[i][j]== 'B'){
                    endX= i;
                    endY =j;
                }
            }
        }
        if(bfs()){
            sb.append("YES\n");
            String path = reconstructPath();
            sb.append(path.length()).append('\n');
            sb.append(path).append('\n');
        } else {
            sb.append("NO\n");
        }
        System.out.print(sb);
    }
    static String reconstructPath() {
        StringBuilder path = new StringBuilder();
        int x = endX, y = endY;
        while(x != startX || y != startY){
            int d = parentDir[x][y];
            path.append(dirChar[d]);
            if(d== 0){
                x++; 
            }
            else if(d== 1){
                x--; 
            }
            else if(d==2){
                y++; 
            }
            else if(d==3){
                y--; 
            }
        }
        path.reverse();
        return path.toString();
    }
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0,len = 0;
        private final InputStream in = System.in;
        private int readByte() throws IOException {
            if (ptr >= len){
                len= in.read(buffer);
                ptr =0;
                if(len <= 0){
                    return -1;
                }
            }
            return buffer[ptr++];
        }
        String next() throws IOException {
            StringBuilder sb = new StringBuilder();
            int c;
            while((c = readByte()) <= ' '){
                if (c == -1) return null;
            }
            do{
                sb.append((char) c);
            } while ((c = readByte()) > ' ');
            return sb.toString();
        }
        int nextInt() throws IOException{
            int c, sign = 1, val = 0;
            do c = readByte(); while (c <= ' ');
            if(c == '-') {
                sign = -1; c=readByte();
            }
            while(c > ' '){
                val=val * 10+c- '0';
                c= readByte();
            }
            return val * sign;
        }
    }
}