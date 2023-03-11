import java.util.ArrayList;
import java.util.List;

public class StripThreads {
    public  Matrix Multiply(Matrix mtrA, Matrix mtrB) {
        Matrix mtrC = new Matrix(mtrA.GetHeight(), mtrB.GetWidth(), 0);
        List<StripThread> threads = new ArrayList<>();
        int i;
        for (i = 0; i < mtrA.GetHeight(); ++i) {
            StripThread stripThread = new StripThread(mtrA, mtrB, mtrC, i);
            threads.add(stripThread);
            stripThread.start();
        }
        for (StripThread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return mtrC;
    }
}
class StripThread extends Thread {
    Matrix A;
    Matrix B;
    Matrix result;
    int row;

    public StripThread(Matrix A, Matrix B, Matrix C, int row) {
        this.A = A;
        this.B = B;
        this.result = C;
        this.row = row;
    }
    @Override
    public void run() {
        for(int j = 0; j < this.B.GetWidth(); ++j) {
            for(int k = 0; k < this.A.GetWidth(); ++k) {
                this.result.Set(this.row, j,
                        this.result.Get(this.row, j) + this.A.Get(this.row, k) * this.B.Get(k, j));
            }
        }

    }
}