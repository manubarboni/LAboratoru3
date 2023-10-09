package Ex2;

import Ex1.Parabola;

import javax.swing.text.DateFormatter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        List<Produs> produse = new ArrayList<Produs>();
        Scanner flux_in = new Scanner(new File("produse.txt"));
        while(flux_in.hasNextLine()) {
            String linie = flux_in.nextLine();
            String[] campuri = linie.split(",");
            String den = campuri[0];
            float prt = Float.parseFloat(campuri[1]);
            int can = Integer.parseInt(campuri[2]);
            LocalDate exp = LocalDate.parse(campuri[3], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            produse.add(new Produs(den,prt,can,exp));
        }
        int optiune;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("1.Afisare");
            System.out.println("2.Expirate");
            System.out.println("3.Vanzare");
            System.out.println("4.Afisare minim");
            System.out.println("5.Fisier");
            System.out.println("Optiune:");
            optiune = in.nextInt();
            switch(optiune) {
                case 0: break;
                case 1: {
                    for (Produs p : produse) {
                        System.out.println(p.toString());
                    }
                    break;
                }
                case 2: {
                    System.out.println("Produse expirate:");
                    for (Produs p : produse) {
                        if (LocalDate.now().isAfter(p.getData_expirare()))
                            System.out.println(p.toString());
                    }
                    break;
                }
                case 3: {
                    System.out.println("Introduceti produsul pt vanzare:");
                    String den = in.next();
                    System.out.println("Introduceti cantitatea pt vanzare:");
                    int cant = Integer.parseInt(in.next());
                    Iterator<Produs> iterator = produse.iterator();

                    while (iterator.hasNext()){
                        Produs produs = iterator.next();
                        if (produs.getDenumire().equalsIgnoreCase(den)) {
                            produs.vinde(den, cant);
                            if(produs.getCantitate()==0)
                                iterator.remove();
                        }
                    }


                    break;
                }
                case 4: {
                    for (Produs p : produse) {
                        System.out.println(p.toString());
                    }
                    System.out.println("\n");
                    float min = produse.get(1).getPret();
                    for (Produs p : produse) {
                        if (p.getPret() < min)
                            min = p.getPret();
                    }
                    for (Produs p : produse) {
                        if (p.getPret() == min)
                            System.out.println(p.toString());
                    }
                    break;
                }
                case 5: {
                    System.out.println("Introduceti cantitatea maxima:");
                    int cant = Integer.parseInt(in.next());
                    PrintStream flux_out = new PrintStream("out.txt");
                    for (Produs p : produse) {
                        if (p.getCantitate() < cant)
                            flux_out.println(p.toString());
                    }
                    break;
                }
                default: {
                    System.out.println("Nu este un nr valid");
                    break;
                }
            }
        }while(optiune!=0);
    }
}
