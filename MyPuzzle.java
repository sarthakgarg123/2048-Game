import java.util.*;
public class MyPuzzle {

	//public static int a[][]=new int[4][4];
	MyPuzzle(int a[][]) {
		// TODO Auto-generated constructor stub
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				a[i][j]=0;
			}
		}
		
	}
	public static void create(int a[][])
	{
		int arr[][]=new int[16][2];
		int k=0;
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				if(a[i][j]==0)
				{
					arr[k][0]=i;
					arr[k][1]=j;
					++k;
				}
			}
		}
		if(k>0)
		{
			Random r=new Random();
			int x=r.nextInt(k);
			int z=r.nextInt(2);
			if(z==0) z=2;
			else z=4;
			a[arr[x][0]][arr[x][1]]=z;
		}
	}
	public static void printgrid(int arr[][])
	{
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				System.out.print(arr[i][j]);
				System.out.print(" ");
			}
			System.out.println("");
		}
	}
	public static void chk(int arr[][],char s)
	{
		if(s=='U')
		{
			for(int j=0;j<4;j++)
			{
				int flag=0;
				for(int i=0;i<4;i++)
				{
					if(arr[i][j]!=0)
					{
						int x=i;
						while(x>0 && (arr[x-1][j]==0 || arr[x-1][j]==arr[x][j]))
						{
							if(arr[x-1][j]==0)
							{
								arr[x-1][j]=arr[x][j];
								arr[x][j]=0;
							}
							else if(flag<x && arr[x-1][j]==arr[x][j])
							{
								//c=x;
								arr[x-1][j]+=arr[x][j];
								arr[x][j]=0;
								flag=x;
							}
							//System.out.println(i);
							//printgrid(arr);
							--x;
						}
					}
				}
			}
		}
		if(s=='D')
		{
			for(int j=0;j<4;j++)
			{	
				int flag=4;
				for(int i=3;i>=0;i--)
				{
					if(arr[i][j]!=0)
					{
						int x=i;
						while(x<3 && (arr[x+1][j]==0 || arr[x+1][j]==arr[x][j]))
						{
							if(arr[x+1][j]==0)
							{
								arr[x+1][j]=arr[x][j];
								arr[x][j]=0;
							}
							else if(flag>x && arr[x+1][j]==arr[x][j])
							{
								//c=x;
								arr[x+1][j]+=arr[x][j];
								arr[x][j]=0;
								flag=x;
							}
							//System.out.println(i);
							//printgrid(arr);
							++x;
						}
					}
				}
			}
		}
		if(s=='L')
		{
			for(int i=0;i<4;i++)
			{	
				int flag=0;
				for(int j=0;j<4;j++)
				{
					if(arr[i][j]!=0)
					{
						int x=j;
						while(x>0 && (arr[i][x-1]==0 || arr[i][x-1]==arr[i][x]))
						{
							if(arr[i][x-1]==0)
							{
								arr[i][x-1]=arr[i][x];
								arr[i][x]=0;
							}
							else if(flag<x && arr[i][x-1]==arr[i][x])
							{
								//c=x;
								arr[i][x-1]+=arr[i][x];
								arr[i][x]=0;
								flag=x;
							}
							//System.out.println(i);
							//printgrid(arr);
							--x;
						}
					}
				}
			}
		}
		if(s=='R')
		{
			for(int i=0;i<4;i++)
			{	
				int flag=4;
				for(int j=3;j>=0;j--)
				{
					if(arr[i][j]!=0)
					{
						int x=j;
						while(x<3 && (arr[i][x+1]==0 || arr[i][x+1]==arr[i][x]))
						{
							if(arr[i][x+1]==0)
							{
								arr[i][x+1]=arr[i][x];
								arr[i][x]=0;
							}
							else if(flag>x && arr[i][x+1]==arr[i][x+1])
							{
								//c=x;
								arr[i][x+1]+=arr[i][x];
								arr[i][x]=0;
								flag=x;
							}
							//System.out.println(i);
							//printgrid(arr);
							++x;
						}
					}
				}
			}
		}
	}
	public static int win(int arr[][])
	{
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				if(arr[i][j]==2048) 
					return 1;
			}
		}
		return 0;
	}
	public static int isover(int a[][])
	{
		int i,j;
		for(i=0;i<4;i++)
		{
			for(j=0;j<4;j++)
			{
				if(a[i][j]==0) return 0;
			}
		}
		for(i=0;i<4;i++)
		{
			for(j=0;j<4;j++)
			{
				if(i-1>=0 && a[i][j]==a[i-1][j]) return 0;
				else if(i+1<4 && a[i][j]==a[i+1][j]) return 0;
				else if(j-1>=0 && a[i][j]==a[i][j-1]) return 0;
				else if(j+1<4 && a[i][j]==a[i][j+1]) return 0;
			}
		}
		return 1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][]=new int[4][4];
		int flag=0;
		//MyPuzzle my=new MyPuzzle(a);
		/*for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				a[i][j]=0;
			}
		}*/
		Scanner s=new Scanner(System.in);
		//int arr[][]=new int[4][4];
		/*for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				arr[i][j]=s.nextInt();
			}
		}*/
		//chk(arr,'R');
		create(a);
		printgrid(a);
		while(true)
		{
			if(win(a)==1) {
				flag=1;break;
			}
			else if(isover(a)==1) {
				flag=2;break;
			}
			else 
			{
				char c;
				c=s.next().charAt(0);
				if(c=='U' || c=='D' || c=='R' || c=='L') chk(a,c);
				else break;
				create(a);
				printgrid(a);
			}
		}
		if(flag==1)
			System.out.println("WIN");
		else System.out.println("LOSE");
		s.close();
	}
}
