// GridImplementation

import GridWorld.* ;
import java.io.* ;
import org.omg.PortableServer.*;

public class GridImplementation implements GridOperations {

  	public int rows, columns;
  	public int gridArray[][];

  	public GridImplementation(int rows, int columns) {
		gridArray = new int[rows][columns];
  	  	this.rows = rows;
    	this.columns = columns ;
  	}

  	public int columns() {
  	  	return columns;
  	}

  	public int rows(){
    	return rows;
  	}

  	public void set(int i, int j, int value) {
    		gridArray[i][j] = value;
  	}

  	public int get(int i, int j) {
    		int t = gridArray[i][j];
    		System.out.println("In grid.get() row = " + i);
    		System.out.println("In grid.get() col = " + j);
    		System.out.println("In grid.get() value = " + t);
    		return t;
  	}
}
