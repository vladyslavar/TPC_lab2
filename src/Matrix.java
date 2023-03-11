import java.util.ArrayList;
import java.util.List;

public class Matrix {
    private List<List<Integer>> matrix;

    public Matrix(List<List<Integer>> matrix) {
        this.matrix = matrix;
    }

    public Matrix(int rows, int columns, int value) {
        this.matrix = new ArrayList();

        for(int i = 0; i < rows; ++i) {
            List<Integer> row = new ArrayList();

            for(int j = 0; j < columns; ++j) {
                row.add(value);
            }

            this.matrix.add(row);
        }

    }

    public static Matrix RandomMatrix(int rows, int columns) {
        Matrix result = new Matrix(rows, columns, 0);

        for(int i = 0; i < rows; ++i) {
            for(int j = 0; j < columns; ++j) {
                result.Set(i, j, (int)(Math.random() * 10.0));
            }
        }

        return result;
    }

    public Integer Get(int row, int column) {
        return (Integer)((List)this.matrix.get(row)).get(column);
    }

    public void Set(int row, int column, Integer value) {
        ((List)this.matrix.get(row)).set(column, value);
    }

    public int GetHeight() {
        return this.matrix.size();
    }

    public int GetWidth() {
        return ((List)this.matrix.get(0)).size();
    }

    public String toString() {
        String result = "\n";

        for(int i = 0; i < this.GetHeight(); ++i) {
            for(int j = 0; j < this.GetWidth(); ++j) {
                result = result + this.Get(i, j) + " ";
            }

            result = result + "\n";
        }

        return result;
    }
    public void print()
    {
        for (int i = 0; i < this.GetHeight(); i++)
        {
            for (int j = 0; j < this.GetWidth(); j++)
            {
                System.out.print(this.Get(i, j) + " ");
            }
            System.out.println();
        }
    }
}
