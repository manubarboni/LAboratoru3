package Ex1;

import static java.lang.Math.hypot;

public class Parabola {
    private int a,b,c;

    public Parabola(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "f(x)= " + a + " x^2 + " + b + " x + " + c;
    }
    public String mijlocSegment(Parabola p) {
        float xMijloc,yMijloc;
        xMijloc = (-(p.b/2*p.a) - (this.b/2*this.a))/2;
        yMijloc = ((-(p.b^2)+4*p.a*p.c)/4*p.a + (-(this.b^2)+4*this.a*this.c)/4*this.a)/2;
        return "( " + xMijloc + "," + yMijloc + " )";
    }
    static public String mijlocSeg(Parabola p1,Parabola p2) {
        float xMijloc,yMijloc;
        xMijloc = (-(p1.b/2*p1.a) - (p2.b/2*p2.a))/2;
        yMijloc = ((-(p1.b^2)+4*p1.a*p1.c)/4*p1.a + (-(p2.b^2)+4*p2.a*p2.c)/4*p2.a)/2;
        return "( " + xMijloc + "," + yMijloc + " )";
    }
    public double Lungime(Parabola p){
        float xP,yP,xC,yC;
        xP = -(p.b/2*p.a);
        xC = -(this.b/2*this.a);
        yP = (-(p.b^2)+4*p.a*p.c)/4*p.a;
        yC = (-(this.b^2)+4*this.a*this.c)/4*this.a;
        return hypot(xP-xC,yP-yC);
    }
    static public double Lung(Parabola p1,Parabola p2) {
        float xP1,yP1,xP2,yP2;
        xP1 = -(p1.b/2*p1.a);
        xP2 = -(p2.b/2*p2.a);
        yP1 = (-(p1.b^2)+4*p1.a*p1.c)/4*p1.a;
        yP2 = (-(p2.b^2)+4*p2.a*p2.c)/4*p2.a;
        return hypot(xP2-xP1,yP2-yP1);
    }
}
