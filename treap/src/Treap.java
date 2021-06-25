import java.util.ArrayList;
import java.util.Random;

public class Treap {
    static private Random rand = new Random();
    public int x;
    public int y;
    public Treap Left;
    public Treap Right;

    public Treap(int x, int y, Treap left, Treap right) {
        this.x = x;
        this.y = y;
        this.Left = left;
        this.Right = right;
    }

    public Treap(int x, int y) {
        this.x = x;
        this.y = y;
        this.Left = null;
        this.Right = null;
    }

    public static Treap Merge(Treap L, Treap R) {
        if (L == null) return R;
        if (R == null) return L;

        if (L.y > R.y) {
            return new Treap(L.x, L.y, L.Left, Merge(L.Right, R));
        } else {
            return new Treap(R.x, R.y, Merge(L, R.Left), R.Right);
        }
    }

    public Treap[] Split(int x) {
        Treap newTree = null;
        Treap L, R;
        if (this.x < x) {
            if (Right == null)
                R = null;
            else {
                Treap[] objArr = Right.Split(x);
                newTree = objArr[0];
                R = objArr[1];
            }
            L = new Treap(this.x, y, Left, newTree);
        } else {
            if (Left == null)
                L = null;
            else {
                Treap[] objArr = Left.Split(x);
                L = objArr[0];
                newTree = objArr[1];
            }
            R = new Treap(this.x, y, newTree, Right);
        }
        return new Treap[]{L, R};
    }

    public Treap Add(int x) {
        Treap[] objArr = Split(x);
        Treap l = objArr[0];
        Treap r = objArr[1];
        Treap m = new Treap(x, rand.nextInt());
        return Merge(Merge(l, m), r);
    }

    public boolean Search(int value) {
        if (x == value)
            return true;
        if (x > value)
            if (Left != null)
                return Left.Search(value);
        if (x < value)
            if (Right != null)
                return Right.Search(value);
        return false;
    }

    public static ArrayList<Integer> Traversal(Treap node, ArrayList<Integer> res)
    {
        if(node != null) {
            Traversal(node.Left, res);
            res.add(node.x);
            Traversal(node.Right, res);
        }
        return(res);
    }

    public Treap Remove(int x) {
        if (this.x == x)
            return Merge(Left, Right);
        if (this.x > x)
            if (Left != null)
                Left = Left.Remove(x);
        if (this.x < x)
            if (Right != null)
                Right = Right.Remove(x);
        return this;
    }
}
