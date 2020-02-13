package no.hiof.trondag;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Flyplass {

    Queue<Fly> landingsko;
    Queue<Fly> avgangsko;
    public static final int MAX_FLY_I_KO = 10;
    public static int antallFly = 0;

    public Flyplass() {
        this.landingsko = new LinkedList<Fly>();
        this.avgangsko = new LinkedList<Fly>();
    }

    public class Fly {

        public int flyNummer;

        public Fly() {
            flyNummer = antallFly;
            antallFly++;
        }
        @Override
        public String toString(){
            return "Fly " + flyNummer;
        }
    }

    public void simuler(int tidssteg, double avgangsFrekvens, double ankomstFrekvens){
        int antLandedeFly = 0;
        int antAvgangFly = 0;
        int avvisteFly = 0;
        int tommeTidssteg = 0;
        for (int i = 0; i < tidssteg; i++){

            // Fly som skal lande

            int antallNyeFlySomSkalLande = getPoissonRandom(ankomstFrekvens);

            for (int k = 0; k < antallNyeFlySomSkalLande ; k++){
                Fly fly = new Fly();
                if (landingsko.size() >= MAX_FLY_I_KO){
                    System.out.println("Landingskøen er full, og " + fly + " blir sent videre til en annen flyplass");
                    avvisteFly++;
                    continue;
                } else {
                    landingsko.add(fly);
                }
            }

            // Fly som skal ta av

            int antallNyeFlySomSkalTaAv = getPoissonRandom(avgangsFrekvens);

            for (int k = 0; k < antallNyeFlySomSkalTaAv ; k++){
                Fly fly = new Fly();
                if (avgangsko.size() >= MAX_FLY_I_KO){
                    System.out.println("Avgangskøen er full, " + fly + " må prøve avgang senere");
                    avvisteFly++;
                    continue;
                } else {
                    avgangsko.add(fly);
                }
            }

            if (!landingsko.isEmpty()){
                antLandedeFly++;
                System.out.println(landingsko.remove().toString() + " Har landet.");
            } else if (!avgangsko.isEmpty()){
                antAvgangFly++;
                System.out.println(avgangsko.remove().toString() + " har tatt av.");
            } else {
                tommeTidssteg++;
                System.out.println("Flyplassen er tom.");
            }


        }
        System.out.println("\nSimulering ferdig etter       " + tidssteg + " tidsenheter.");
        System.out.println("Antall fly behandlet:         " + antallFly);
        System.out.println("Antall fly landet:            " + antLandedeFly);
        System.out.println("Antall fly tatt av:           " + antAvgangFly);
        System.out.println("Antall fly avvist:            " + avvisteFly);
        System.out.println("Antall fly klare for landing: " + landingsko.size());
        System.out.println("Antall fly klare for avgang:  " + avgangsko.size());
        double tom = (((double)tommeTidssteg) / (double)tidssteg) * 100;
        System.out.println("Flyplassen sto tom            " + tom + "% av tiden");

    }

    private static int getPoissonRandom(double mean)
    {
        Random r = new Random();
        double L = Math.exp(-mean);
        int k = 0;
        double p = 1.0;
        do
        {
            p = p * r.nextDouble();
            k++;
        } while (p > L);
        return k - 1;
    }


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Velkommen til flyplassimulator v.0.99.9999999999999");
        System.out.println("Vi vil nå simulere nye Remmen flyplass som har planlagt byggestart i år 2089");
        System.out.println("I hvor mange tidsenheter skal denne simuleringen kjøre?");
        int tidssteg = scanner.nextInt();
        System.out.println("Forventet antall ankomster pr. tidsenhet?");
        double ankomstFrekvens = scanner.nextDouble();
        System.out.println("Forventet antall avganger pr. tidsenhet?");
        double avgangsfrekvens = scanner.nextDouble();
        Flyplass flyplass = new Flyplass();
        flyplass.simuler(tidssteg, ankomstFrekvens, avgangsfrekvens);
    }

}
