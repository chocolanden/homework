import java.util.Scanner;

public class demo {
	public static int[][] maze;  //�Թ�����
	public static int n;  //�����С
	public static int min;  //����ܲ���
	
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
		bool_maze(1,1,0);  //���
		if(min==0) {
			System.out.println("no solution");
		}else {
			System.out.println(min);
		}
	}
	
	public static void bool_maze(int a,int b,int count) {
		if(a==n-2 && b==n-2) {
			min = Math.min(min, count);  //�Ѿ������յ㣬
		}else {
			maze[a][b] = 1;  //�߹���λ�ò����ظ��ߣ��ʶ��߹�����Ϊ1���ϰ��
			if(a>1 && maze[a-1][b]==0) {
				bool_maze(a-1, b, count+1);  //��
			}
			if(a<n-1 && maze[a+1][b]==0) {
				bool_maze(a+1, b, count+1);  //��
			}
			if(b>1 && maze[a][b-1]==0) {
				bool_maze(a, b-1, count+1);  //��
			}
			if(b<n-1 && maze[a][b+1]==0) {
				bool_maze(a, b+1, count+1);  //��
			}
			//���ݣ��ָ�ԭ����״̬��
			maze[a][b]=0;//���Ӹô����ڵط�����û���ҵ�����·�������Խ�֮ǰ�߹�������·��״̬�ָ�
		}
	}

}
