package com.udit.dfs;

import java.util.Arrays;

public class NumberOfIslands {

	public static void main(String[] args) {
		
		NumberOfIslands obj = new NumberOfIslands();
		char[][] grid = {
				{'1'},
				{'1'}
							};
		obj.show(grid);
		System.out.println("Islands : "+obj.numIslands(grid));
		obj.show(grid);
	}
	
	public int numIslands(char[][] grid) {
		
		if(grid == null || grid.length == 0) {
			return 0;
		}
		
		int count = 0;
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					count += dfs(grid, i, j);
					System.out.println("After iteration, count : " + count);
					show(grid);
				}
			}
		}

		return count;
	}
	
	public int dfs(char[][] grid, int i, int j) {
	
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != '1') {
			return 0;
		}

		grid[i][j] = '*';

		dfs(grid, i + 1, j);
		dfs(grid, i - 1, j);
		dfs(grid, i, j + 1);
		dfs(grid, i, j - 1);
		
		return 1;
	}
	
	public void show(char[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			System.out.println(Arrays.toString(grid[i]));
		}
	}
}
