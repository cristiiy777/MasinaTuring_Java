package masinaturing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MasinaTuring {

    private String st_Initiala = " ";
    private ArrayList<String> st_Finale = new ArrayList<>();
    private ListaTranzitiiTuring lista = new ListaTranzitiiTuring();

    MasinaTuring(String new_fisier) throws Exception {

        BufferedReader buf = new BufferedReader(new FileReader(new_fisier));

        //prima linie din notepad = stare initiala
        this.st_Initiala = buf.readLine();
        System.out.println(st_Initiala);

        //a doua linie incepe citirea de stari finale
        String linie = buf.readLine();
        String tabel[] = linie.split(" ");
        for (int i = 0; i < tabel.length; i++) {
            this.st_Finale.add(tabel[i]);
        }
        System.out.println(st_Finale);

        //a treia linie incepe citirea de tranzitii Turing (String stareInceput, char caracterCitit, char caracterScris, char directie, String stareSfarsit)
        while (true) {
            linie = buf.readLine();
            if (linie == null) {
                break;
            } else {
                String tr[] = linie.split(" ");
                TranzitieTuring tranz = new TranzitieTuring(tr[0], tr[1].charAt(0), tr[2].charAt(0), tr[3].charAt(0), tr[4]);
                System.out.println(tranz.toString());
                lista.adaugaTranzitieTuring(tranz);
            }
        }

    }

    
    public static void main(String[] args) {

        //citire din fisier
        MasinaTuring MT = null;
        try {

            MT = new MasinaTuring("Turing.txt");

        } catch (Exception ex) {
            Logger.getLogger(MasinaTuring.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Introduceti cuvantul: ");

        Scanner scanner = new Scanner(System.in);
        String cuvant = scanner.nextLine();

        int index = 1;
        char caracter_scris;
        char directie;
        StringBuilder cuvantNou;
        char caracter_citit;
        boolean exista_st_inceput = false;
        
        String stare = MT.lista.spuneTranzitie(0).getStareInceput();
   
        caracter_citit = cuvant.charAt(0);
        
        if (MT.lista.gasesteTranzitie(stare, caracter_citit) != null) {
            System.out.println("Exista stare initiala: " + stare);
            exista_st_inceput = true;
        } else {
            System.out.println("Nu exista stare initiala");
            System.out.println("Cuvantul este Respins !");
            return;
        }
        
        cuvant = 'B' + cuvant;
        
        while (true) {

            if (MT.st_Finale.contains(stare)) {
                System.out.println("Ai ajuns într-o stare finală. Stare: " + stare);
                System.out.println("Continut banda: " + cuvant);
                return;
            }

            if (index == cuvant.length()) {
                cuvant = cuvant + 'B';
            }

            caracter_citit = cuvant.charAt(index);

            System.out.println(caracter_citit);

            TranzitieTuring tranzitie = MT.lista.gasesteTranzitie(stare, caracter_citit);
            if (tranzitie == null) {
                System.out.println("Nu s-a gasit o tranzitie pentru starea " + stare + " si caracterul " + caracter_citit);
                System.out.println("Cuvantul este Respins !");
                return;
            }
            
            caracter_scris = tranzitie.getCaracterScris();

            cuvantNou = new StringBuilder(cuvant);
            cuvantNou.setCharAt(index, caracter_scris);
            cuvant = cuvantNou.toString();
            System.out.println(cuvantNou);
          
            directie = tranzitie.getDirectie();

            if (index == 0 && directie == 'L') {
                System.out.println("Scuze boss, am sărit de pe bandă");
                System.out.println("Cuvantul este Respins !");
                break;
            }

            switch (directie) {
                case 'R':
                    index++;
                    break;

                case 'L':
                    index--;
                    break;
            }

            stare = tranzitie.getStareSfarsit();

        }
       
    }

}
