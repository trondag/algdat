package no.hiof.trondag;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

class postkontor
{
    private static class Kunde
    {
        // Lagrer data om en kunde pÃ¥ postkontoret

        // Tidspunkt nÃ¥r kunden stiller seg i kÃ¸en
        private int ankomst;

        public Kunde(int ankomst)
        {
            this.ankomst = ankomst;
        }

        public int venteTid(int tid)
        {
            return tid - ankomst;
        }
    }

    private static class Kasse
    {
        // Lagrer data for en Kasse pÃ¥ postkontoret

        // Tidspunkt når nåværende/siste kunde er/var ferdig
        private int tidFerdigKunde;
        private Queue<Kunde> kø;

        public Kasse()
        {
            tidFerdigKunde = 0;
            kø = new LinkedList<Kunde>();
        }

        public boolean erLedig(int tid)
        {
            return tid >= tidFerdigKunde;
        }

        public void settTidFerdigKunde(int tid)
        {
            tidFerdigKunde = tid;
        }

        public Queue<Kunde> getKø() {
            return kø;
        }

        public int getAntallIKo(){
            return this.kø.size();
        }

    }

    public static void simuler(int maksTid, int antKasser, int maksBetTid,
                               float p_k)
    {
        // Simulerer utvikling av kÃ¸en pÃ¥ et postkontor
        //
        // maksTid: Antall tidssteg
        // antKasser: Antall Ã¥pne kasser
        // maksBetTid: Maksimal betjeningstid per kunde
        // p_k: Sannsynligheten for at Ã©n kunde ankommer i lÃ¸pet av
        // et tidssteg

        Kasse[] kasser = new Kasse[antKasser];
        Random R = new Random();

        int totalBetTid = 0;   // Sum betjeningstid for alle betjente kunder
        int totalVenteTid = 0; // Sum ventetid for alle betjente kunder
        int totAntKunder = 0;  // Totalt antall kunder betjent
        int totAntledig = 0;   // Totalt antall ganger en Kasse var ledig

        // Setter alle kasser til å være ledige
        for (int i = 0; i < antKasser; i++)
            kasser[i] = new Kasse();

        // Simulerer et og et tidssteg
        for (int tid = 0; tid < maksTid; tid++)
        {
            // Trekker nytt tilfeldig tall. Hvis tallet som trekkes er
            // mindre enn p_k, settes ny kunde inn i køen
            if (R.nextDouble() < p_k) {
                Kasse valgtKasse= kasser[0];
                for (Kasse kasse : kasser) {
                    if (kasse.getAntallIKo() < valgtKasse.getAntallIKo()){
                        valgtKasse = kasse;
                    }
                }
                valgtKasse.kø.add(new Kunde(tid));
            }

            // Tar ut en kunde fra køen for hver ledige Kasse
            for (int i = 0; i < antKasser; i++)
                if (kasser[i].erLedig(tid))
                {
                    if (!kasser[i].kø.isEmpty())
                    {
                        // Trekk tilfelding betjeningstid
                        int betTid = R.nextInt(maksBetTid) + 1;

                        Kunde k = kasser[i].kø.remove();
                        kasser[i].settTidFerdigKunde(tid + betTid);

                        // Legger til informasjon fra dette tidssteget
                        totalBetTid += betTid;
                        totalVenteTid += k.venteTid(tid);
                        totAntKunder++;
                    }
                    else
                        totAntledig++;
                }
        }

        // Simulering ferdig, skriv ut litt statistikk

        System.out.println("\nPostkontoret er nÃ¥ stengt");
        System.out.println("Antall kunder behandlet: " + totAntKunder);
        int antall = 0;
        for (Kasse kasse : kasser){
            antall += kasse.getAntallIKo();
        }
        System.out.println("Antall kunder i kÃ¸: " + antall);
        if (totAntKunder > 0)
        {
            System.out.println("Gjennomsnittlig betjeningstid: " +
                    (float) totalBetTid / (float) totAntKunder);
            System.out.println("Gjennomsnittlig ventetid: " +
                    (float) totalVenteTid / (float) totAntKunder);

        }
        System.out.println("Gjennomsnittlig antall ledige kasser: " +
                (float) totAntledig / (float) maksTid );

    }

    public static void main(String[] args)
    {
        int maksTid, antKasser, maksBetTid;
        float p_k;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Velkommen til Remmen postkontor");
        System.out.print("Antall tidsteg?: ");
        maksTid = Integer.parseInt(scanner.nextLine());
        System.out.print("Antall kasser?: ");
        antKasser = Integer.parseInt(scanner.nextLine());
        System.out.print("Lengste betjeningstid?: ");
        maksBetTid = Integer.parseInt(scanner.nextLine());
        System.out.print("Gjennomsnittlig antall kundeankomster (< 1.0) per tidsenhet?: ");
        p_k = Float.parseFloat(scanner.nextLine());

        simuler(maksTid, antKasser, maksBetTid, p_k);
    }

}