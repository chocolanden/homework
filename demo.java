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
	
	public static void bool_maze(int a,int b,int count) {
		if(a==n-2 && b==n-2) {
			min = Math.min(min, count);  //已经到达终点，
		}else {
			maze[a][b] = 1;  //走过的位置不能重复走，故而走过就设为1（障碍物）
			if(a>1 && maze[a-1][b]==0) {
				bool_maze(a-1, b, count+1);  //上
			}
			if(a<n-1 && maze[a+1][b]==0) {
				bool_maze(a+1, b, count+1);  //下
			}
			if(b>1 && maze[a][b-1]==0) {
				bool_maze(a, b-1, count+1);  //左
			}
			if(b<n-1 && maze[a][b+1]==0) {
				bool_maze(a, b+1, count+1);  //右
			}
			//回溯，恢复原来的状态，
			maze[a][b]=0;//即从该处相邻地方出发没有找到完整路径，所以将之前走过的这条路径状态恢复
		}
	}

}
