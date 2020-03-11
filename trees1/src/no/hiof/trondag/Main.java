package no.hiof.trondag;

class treNode
{
    int data;
    treNode venstre, hoeyre;
    static int antallBlader;

    public treNode(int n)
    {
        data = n;
        venstre = hoeyre = null;
    }

    void setVenstre(treNode treNode){
        this.venstre = treNode;
    }

    void setHoeyre(treNode treNode){
        this.hoeyre = treNode;
    }

}

public class Main {

    static int antBlader;

    static int antallBlader(treNode rot)
    {
        // Tomt tre?
        if (rot == null)
            return 0;

        // Er denne noden et blad?
        if (rot.venstre == null && rot.hoeyre == null)
            return 1;

        // Returner summen av antall blader i venstre og hÃ¸yre subtre
        return antallBlader(rot.venstre) + antallBlader(rot.hoeyre);

    }
    static int antallMedEttBarn(treNode rot)
    {
        // Returnerer antall noder med bare ett barn
        // i et tre med en gitt rot

        int leggTil = 0;

        if (rot == null)
        return 0;

        if (rot.venstre == null && rot.hoeyre != null) {
            antallMedEttBarn(rot.hoeyre);
            leggTil = 1;
        }
        if (rot.venstre != null && rot.hoeyre == null){
            antallMedEttBarn(rot.venstre);
            leggTil = 1;
        }

        return leggTil + antallMedEttBarn(rot.venstre) + antallMedEttBarn(rot.hoeyre);
    }

    static int antallMedToBarn(treNode rot)
    {
        // Returnerer antall noder med to barn (fulle noder)
        // i et tre med en gitt rot
        int leggTil = 0;

        if (rot == null)
        return 0;

        if (rot.venstre != null && rot.hoeyre != null){
            leggTil = 1;
        }

        return leggTil + antallMedToBarn(rot.venstre) + antallMedToBarn(rot.hoeyre);
    }

    public static void main(String[] args) {
	treNode en = new treNode(1);
	treNode to = new treNode(2);
	treNode tre = new treNode(3);
	treNode fire = new treNode(4);
	treNode fem = new treNode(5);
	treNode seks = new treNode(6);
	treNode sju = new treNode(7);
	treNode åtte = new treNode(8);
	treNode ni = new treNode(9);
	treNode ti = new treNode(10);
	treNode elleve = new treNode(11);
	treNode tolv = new treNode(12);
	treNode tretten = new treNode(13);
	treNode fjorten = new treNode(14);
	treNode femten = new treNode(15);
	treNode seksten = new treNode(16);

	en.venstre = to;
	en.hoeyre = tre;
	to.venstre = fire;
	to.hoeyre = fem;
	fire.hoeyre = seks;
	seks.venstre = sju;
	seks.hoeyre = åtte;
	åtte.hoeyre = ni;
	tre.venstre = ti;
	tre.hoeyre = elleve;
	elleve.venstre = tolv;
	elleve.hoeyre = tretten;
	tretten.hoeyre = fjorten;
	fjorten.hoeyre = femten;
	fjorten.venstre = seksten;

        System.out.println(antallMedToBarn(en));
    }
}
