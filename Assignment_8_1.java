package com.springboot.tightoil.demo;

import java.util.Scanner;

public class Assignment_8_1 {

    public static void ShortestPast_DIJ(int[][] G,int v0,boolean[][] P,int[] D)
    {
        int v,w;
        boolean[] f=new boolean[G.length];

        for(v=0;v<G.length;++v)
        {
            f[v]=false; D[v]=G[v0][v];
            for(w=0;w<G.length;++w) P[v][w]=false;
            if(D[v]<Integer.MAX_VALUE)
            {
                P[v][v0]=true;
                P[v][v]=true;
            }
        }

        D[v0]=0; f[v0]=true;
        for(int i=1;i<G.length;++i)
        {
            int min=Integer.MAX_VALUE;
            for(w=0;w<G.length;++w)
            {
                if(!f[w])
                    if(D[w]<min)
                    {
                        v=w; min=D[v];
                    }
            }
            f[v]=true;
            for(w=0;w<G.length;++w)
            {
                if(!f[w]&&(min+G[v][w]<D[w])&&min<Integer.MAX_VALUE&&G[v][w]<Integer.MAX_VALUE)
                {
                    D[w]=min+G[v][w];
                    P[w]=P[v].clone();
                    P[w][w]=true;
                }
            }

        }
    }

    public static int[][] readG(Scanner in,int n)
    {
        int[][] G=new int[n][n];
        for(int i=0;i<n;++i)
        {
            for(int j=0;j<n;++j)
            {
                G[i][j]=in.nextInt();
                if(G[i][j]==-1)
                    G[i][j]=Integer.MAX_VALUE;
            }
        }
        return G;
    }

    public static void printD(int[] D)
    {
        System.out.println("destination"+"\tShortest path length");
        for(int i=0;i<D.length;i++)
        {
            if(D[i]<Integer.MAX_VALUE)
                System.out.println(i+"\t"+D[i]);
            else
                System.out.println(i+"\tNONE");
        }

    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int[][] G=readG(in,3);
        int v0=0;
        boolean[][] P=new boolean[3][3];
        int[] D=new int[3];

        ShortestPast_DIJ(G, v0, P, D);
        printD(D);

    }

}
