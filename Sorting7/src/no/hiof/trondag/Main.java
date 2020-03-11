package no.hiof.trondag;

class Liste
{
    public LinkedInt forsteElement;
    public LinkedInt sisteElement;
    public int size;

    public Liste(){}

    public void leggTil(int tall){
        LinkedInt linkedInt = new LinkedInt(tall);
        if (forsteElement == null){
            forsteElement = linkedInt;
            sisteElement = linkedInt;
            size = 1;
        } else {
            sisteElement.neste = linkedInt;
            sisteElement = sisteElement.neste;
            size++;
        }
    }

    LinkedInt get(int index){
        LinkedInt currentElement = forsteElement;
        for (int i = 0; i <= index; i++){
            if (i == index){
                return currentElement;
            } else {
                currentElement = currentElement.neste;
            }
        }
        return currentElement;
    }

    void fjern(int index){
        this.get(index-2).neste = this.get(index);
    }

    int fjernSisteElement(){
        int sisteElementIListe = this.sisteElement.getInt();
        this.get(size-2).neste = null;
        size--;
        return sisteElementIListe;
    }
}
class LinkedInt {
    private int verdi;
    LinkedInt neste;

    LinkedInt(int tall){
        verdi = tall;
    }
    int getInt(){
        return verdi;
    }
}


public class Main {



    public static void main(String[] args) {
        Liste liste = new Liste();
        for (int i = 0; i < 5; i++){
            liste.leggTil((int)Math.floor(Math.random()*30));
        }
        liste.fjernSisteElement();
        liste.fjern(1);

    }
}
