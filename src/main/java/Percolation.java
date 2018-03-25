import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

	private int[] grid; 
	private int N =0;
	private WeightedQuickUnionUF weightedQUF ;

	public Percolation(int n) {
		// create n-by-n grid, with all sites blocked
		N = n;
		for (int i = 0; i <= (n * n -1); i++) {
			grid[i] = 0; // 0 is closed , 1 is open
		}
		
		weightedQUF = new WeightedQuickUnionUF(n);
	}

	
	
	
	public void open(int row, int col) {
		// open site (row, col) if it is not open already
		if((row >0 && row<= (N-1)) && (col >0 && col <= (N-1))) {
		
		
		if(!isOpen(row, col)) {
			int currentIndex = (row-1)*N+(col-1);
		grid[currentIndex]=1;
		row = row-1;
		col =col-1;
		int maxIndex = ((N)^2)-1;
		int prevRow = row-1;
		int nextRow = row +1;
		int prevCol = col-1;
		int nextCol = col+1;
		
		if(prevCol >0) {
		int indexLeft = row * N + (prevCol);
		if(indexLeft > 0 && indexLeft < maxIndex)
			weightedQUF.union(currentIndex, indexLeft);
		}
		if(nextCol <= (N-1)) {
		int indexRight = row*N + (nextCol);
		if(indexRight > 0 && indexRight < maxIndex)
			weightedQUF.union(currentIndex, indexRight);
		}
        if(prevRow >0) {
		int indexTop = (prevRow)*N + (col);
		if(indexTop > 0 && indexTop < maxIndex)
			weightedQUF.union(currentIndex, indexTop);
        }
        if(nextRow <= (N-1)) {
		int indexDown = nextRow*N+ (col);
		if(indexDown > 0 && indexDown < maxIndex)
			weightedQUF.union(currentIndex, indexDown);
		
		}
		}
		}else {
			throw new IllegalArgumentException();
		}
		
	}

	public boolean isOpen(int row, int col) {
		
		int indexInArray = (row-1) * grid.length+(col-1);
		
		if(grid[indexInArray]==1)
		return true;
		else
			return false;
		// is site (row, col) open?
	}

	public boolean isFull(int row, int col) { 
		
		if((row >0 && row<= (N-1)) && (col >0 && col <= (N-1))) {
		row = row -1;
		col = col -1;
		int currentIndex = row * N + col;
		int topRow=0;	
		for(int i=0;i< N-1;i++) {
			int topRowIndex = topRow*N + i;
			if(weightedQUF.connected(currentIndex, topRowIndex))
				return true;
			
		}
		
		}else {
			throw new IllegalArgumentException();
		}
		
		return false;
		// is site (row, col) full?
	}

	public int numberOfOpenSites() {

		int noOfOpenSites = 0;

		for (int i = 0; i < grid.length; i++) {
			if (grid[i] == 1) {
				noOfOpenSites++;
			}
		}
		return noOfOpenSites;
		// number of open sites
	}

	public boolean percolates() {
		
		
		
		return false;
		// does the system percolate?
	}

	public static void main(String[] args) {
		// test client (optional)
	}

}
