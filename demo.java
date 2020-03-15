import java.util.Scanner;

public class demo {
	public static int[][] maze;  //迷宫矩阵
	public static int n;  //矩阵大小
	public static int min;  //最短总步长
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		maze = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				maze[i][j] = sc.nextInt();
			}
		}
		bool_maze(1,1,0);  //起点
		if(min==0) {
			System.out.println("no solution");
		}else {
			System.out.println(min);
		}
	}
	
	public static void bool_maze(int x,int y,int count) {
		if(x==n-2 && y==n-2) {
			min = Math.min(min, count);  //已经到达终点，
		}else {
			maze[x][y] = 1;  //走过的位置不能重复走，故而走过就设为1（障碍物）
			if(x>1 && maze[x-1][y]==0) {
				bool_maze(x-1, y, count+1);  //上
			}
			if(x<n-1 && maze[x+1][y]==0) {
				bool_maze(x+1, y, count+1);  //下
			}
			if(y>1 && maze[x][y-1]==0) {
				bool_maze(x, y-1, count+1);  //左
			}
			if(y<n-1 && maze[x][y+1]==0) {
				bool_maze(x, y+1, count+1);  //右
			}
			//回溯，恢复原来的状态，
			maze[x][y]=0;//即从该处相邻地方出发没有找到完整路径，所以将之前走过的这条路径状态恢复
		}
	}

}
