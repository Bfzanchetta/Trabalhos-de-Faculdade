package Bicho.BST;

public class Node
{
    /** Each node has a line and a normal equation, or beginning and end points for both*/
    /** Line equation values */
    private double lineX1, lineX2, lineY1, lineY2;

    /** Normal equation values */
    private double normalX1, normalX2, normalY1, normalY2;

    /** Left and Right sub-nodes references */
    private Node left, right;

    /** Current node's index */
    private int n;

    public Node(double lineX1, double lineX2, double lineY1, double lineY2,
                double normalX1, double normalX2, double normalY1, double normalY2,
                Node left, Node right, int n)
    {
        this.lineX1 = lineX1;
        this.lineX2 = lineX2;
        this.lineY1 = lineY1;
        this.lineY2 = lineY2;
        this.normalX1 = normalX1;
        this.normalX2 = normalX2;
        this.normalY1 = normalY1;
        this.normalY2 = normalY2;
        this.left = left;
        this.right = right;
        this.n = n;
    }

    /** Empty constructor will basically start the object Node with measurement params as (double)0.0,
     *  left and right node references will point to null and current index will reference -1 for error handling
     */
    public Node()
    {
        this.lineX1 = 0.0;
        this.lineX2 = 0.0;
        this.lineY1 = 0.0;
        this.lineY2 = 0.0;
        this.normalX1 = 0.0;
        this.normalX2 = 0.0;
        this.normalY1 = 0.0;
        this.normalY2 = 0.0;
        this.left = null;
        this.right = null;
        this.n = -1;
    }

    public double getLineX1() {return lineX1;}
    public void setLineX1(double lineX1) {this.lineX1 = lineX1;}

    public double getLineX2() {return lineX2;}
    public void setLineX2(double lineX2) {this.lineX2 = lineX2;}

    public double getLineY1() {return lineY1;}
    public void setLineY1(double lineY1) {this.lineY1 = lineY1;}

    public double getLineY2() {return lineY2;}
    public void setLineY2(double lineY2) {this.lineY2 = lineY2;}

    public double getNormalX1() {return normalX1;}
    public void setNormalX1(double normalX1) {this.normalX1 = normalX1;}

    public double getNormalX2() {return normalX2;}
    public void setNormalX2(double normalX2) {this.normalX2 = normalX2;}

    public double getNormalY1() {return normalY1;}
    public void setNormalY1(double normalY1) {this.normalY1 = normalY1;}

    public double getNormalY2() {return normalY2;}
    public void setNormalY2(double normalY2) {this.normalY2 = normalY2;}

    public Node getLeft() {try {return left;}
        catch(NullPointerException e) {throw new NullPointerException("NullPointer exception on getLeft of node with n: " + getN());}}
    public void setLeft(Node left) {try {this.left = left;}
        catch(NullPointerException e) {throw new NullPointerException("NullPointer exception on setLeft of node with n: " + getN());}}

    public Node getRight() {try {return right;}
        catch(NullPointerException e) {throw new NullPointerException("NullPointer exception on getRight of node with n: " + getN());}}
    public void setRight(Node right) {try {this.right = right;}
        catch(NullPointerException e) {throw new NullPointerException("NullPointer exception on setRight of node with n: " + getN());}}

    public int getN() {return n;}
    public void setN(int n) {this.n = n;}
}
