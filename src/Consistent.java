public class Consistent {
    public  Matrix Multiply(Matrix mtrA, Matrix mtrB) {
        Matrix result = new Matrix(mtrA.GetHeight(), mtrB.GetWidth(), 0);

        for(int i = 0; i < mtrA.GetHeight(); ++i) {
            for(int j = 0; j < mtrB.GetWidth(); ++j) {
                for(int k = 0; k < mtrA.GetWidth(); ++k) {
                    result.Set(i, j, result.Get(i, j) + mtrA.Get(i, k) * mtrB.Get(k, j));
                }
            }
        }
        return result;
    }
}
