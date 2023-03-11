import java.util.ArrayList;
import java.util.List;

public class FoxThreads {
    public static Matrix Multiply(Matrix mtrA, Matrix mtrB, int block_size) {
        Matrix mtrC = new Matrix(mtrA.GetHeight(), mtrB.GetWidth(), 0);
        List<FoxThread> threads = new ArrayList<FoxThread>();
        for (int i = 0; i < mtrA.GetHeight(); i += block_size) {
            for (int j = 0; j < mtrB.GetWidth(); j += block_size) {
                FoxThread foxThread = new FoxThread(mtrA, mtrB, mtrC, i, j,
                        Math.min(i + block_size, mtrA.GetHeight()), Math.min(j + block_size, mtrB.GetWidth()));
                threads.add(foxThread);
                foxThread.start();
            }
        }
        for (FoxThread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return mtrC;
    }
}
class FoxThread extends Thread {
    Matrix A;
    Matrix B;
    Matrix result;
    int i_start;
    int j_start;
    int i_end;
    int j_end;

    public FoxThread(Matrix A, Matrix B, Matrix C, int i_start, int j_start, int i_end, int j_end) {
        this.A = A;
        this.B = B;
        this.result = C;
        this.i_start = i_start;
        this.j_start = j_start;
        this.i_end = i_end;
        this.j_end = j_end;
    }
    @Override
    public void run() {
        for (int i = i_start; i < i_end; i++) {
            for (int j = j_start; j < j_end; j++) {
                for (int k = 0; k < A.GetWidth(); k++) {
                    result.Set(i, j, result.Get(i, j) + A.Get(i, k) * B.Get(k, j));
                }
            }
        }
    }
}