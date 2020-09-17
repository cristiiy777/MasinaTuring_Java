package masinaturing;

import java.util.ArrayList;

public class ListaTranzitiiTuring {
    
    private ArrayList <TranzitieTuring> lista;

    public ListaTranzitiiTuring() {
        this.lista = new ArrayList <TranzitieTuring>();
    }
        
        void adaugaTranzitieTuring(TranzitieTuring tr)
            {
            this.lista.add(tr);
            //adauga element
            }
        
        TranzitieTuring spuneTranzitie(int index)
            {
            return this.lista.get(index);
            //luam un element
            }
        
        TranzitieTuring gasesteTranzitie(String st_Inceput, char caracter_citit)
            {
            for(int i=0; i < lista.size(); i++)
                {
                    TranzitieTuring tmp = this.spuneTranzitie(i);
                    if(tmp.getStareInceput().equals(st_Inceput))
                        if(tmp.getCaracterCitit() == caracter_citit)
                            return tmp; //returneaza tranzitia
                    //am gasit o tranzitie ce incepe cu o anumita stare si simbol
                }
            return null;
            }
        
}

