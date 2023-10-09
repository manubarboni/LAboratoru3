package Ex1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        List<Parabola> listaParabole = new ArrayList<Parabola>();
        int a,b,c;
        Scanner flux_in = new Scanner(new File("in.txt"));
        while(flux_in.hasNextLine()) {
            String linie = flux_in.nextLine();
            String[] numere = linie.split(" ");
            a = Integer.parseInt(numere[0]);
            b = Integer.parseInt(numere[1]);
            c = Integer.parseInt(numere[2]);
            listaParabole.add(new Parabola(a,b,c));
        }
        for(Parabola p:listaParabole){
            System.out.println(p.toString());
        }
        Parabola p0 = listaParabole.get(0);
        Parabola p1 = listaParabole.get(1);
        System.out.println(p0.mijlocSegment(p1));
        System.out.println(p0.Lungime(p1));
        System.out.println(Parabola.mijlocSeg(p0,p1));
        System.out.println(Parabola.Lung(p0,p1));
    }
}