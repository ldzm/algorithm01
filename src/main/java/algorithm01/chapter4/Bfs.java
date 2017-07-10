package algorithm01.chapter4;

public class Bfs {

	private class Node {
		int x;
		int y;
		int s;
	}
	
	void bfs() {

		int a[][] =
		{
				{ 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0 },
				{ 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0 },
				{ 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 1 }, };
		
		Node que[] = new Node[2501];
		for(int i = 0; i < que.length; i++) {
			que[i] = new Node();
		}
		
		int book[][] = new int[51][51];
		int[][] next =
		{
				{ 0, 1 }, // right
				{ 1, 0 }, // down
				{ 0, -1 }, // left
				{ -1, 0 } // up
		};
		int n = 5;
		int m = 4;
		
		int startx = 1;
		int starty = 1;
		int p = 4;
		int q = 3;
		
		// init queue
		int head = 1;
		int tail = 1;
		// insert
		que[tail].x = startx;
		que[tail].y = starty;
		que[tail].s = 0;
		tail++;
		book[startx][starty] = 1;

		int flag = 0; // 用来判断是否到达目标点 
		
		while(head < tail)
		{
			for (int k = 0; k < 4; k++)
			{
				int tx = que[head].x + next[k][0];
				int ty = que[head].y + next[k][1];
				if(tx < 1 || tx > n || ty < 1 || ty > m)
				{
					continue;
				}

				if(0 == a[tx][ty] && 0 == book[tx][ty])
				{
					book[tx][ty] = 1;
					que[tail].x = tx;
					que[tail].y = ty;
					que[tail].s = que[head].s + 1;
					tail++;
				}
				
				if (tx == p && ty == q)
				{
					flag = 1;
					break;
				}
			}
			
			if (1 == flag)
			{
				break;
			}
			
			head++;
		}
		
		System.out.println(que[tail - 1].s);
		return;
	}
	
	public static void main(String[] args) {
		
		new Bfs().bfs();
	}
}
