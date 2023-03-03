import java.util.Arrays;
class Sala {
    private String nume;
    private String tipulSalii;
    private int locuri;
    boolean[] interval=new boolean[24];
    public Sala(String nume,String tipulSalii)
    {
        this.nume=nume;
        this.tipulSalii=tipulSalii;
        if(tipulSalii.matches("Seminar"))
            this.locuri=50;
        if(tipulSalii.matches("Laborator"))
            this.locuri=18;
        if(tipulSalii.matches("Curs"))
            this.locuri=120;
        Arrays.fill(interval, false);
    }

    public String toString()
    {
        StringBuilder s=new StringBuilder();
        s.append("Numele: ").append(this.nume).append("\n").append("Tipul Salii: ").append(tipulSalii).append("\n");
        for(int i = 0 ; i < 24 ; i++)
            s.append(interval[i]).append(" ").append(i).append("-").append(i+1).append("\n");
        s.append("Nr locuri: ").append(this.locuri).append("\n");
        return s.toString();
    }

    public boolean verificareOra(int ora)
    {
        return ((ora >= 8 ) && (ora<=20));
    }

    public void ocupareSala(int inceput,int sfarsit) {
        if(sfarsit-inceput>3 || sfarsit-inceput<=0)
        {
            System.out.println("Nu se poate lua sala pentru acest numar de ore\n");
            return;
        }
        if(verificareOra(inceput) && verificareOra(sfarsit))
        {
            for(int i = inceput; i<sfarsit; i++)
            {
                if(interval[i])
                {
                    System.out.println("Sala e deja ocupata in acest interval!");
                    Arrays.fill(interval,inceput,i,false);
                    return;
                }
                interval[i]=true;
            }
        }
        else {
            System.out.println("Sala nu se poate lua intre orele: " + inceput + " " + sfarsit);
        }
    }

}
class Cladire{
    private String nume;
    private Sala[] sali=new Sala[20];
    private int c = 0;
    public Cladire(String nume)
    {
        this.nume=nume;
    }
    public void adaugaSala(Sala a)
    {
        sali[c++]=a;
    }
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append("Cladirea: ").append(this.nume).append(" Cu Sala/Salile:\n");
        for(int i = 0 ; i < c ; i++)
            s.append(sali[i]);
        return s.toString();
    }
}


public class Universitate {
    public static void main(String[] args) {
        Sala a1 = new Sala("A101","Curs");
        Sala a2 = new Sala("A109","Seminar");
        Sala a3 = new Sala("ASPC","Curs");

        a1.ocupareSala(10,13);
        a2.ocupareSala(10,12);
        a2.ocupareSala(20,23);//false
        a3.ocupareSala(10,13);
        a3.ocupareSala(13,16);
        a3.ocupareSala(21,23);//false

        Cladire c1=new Cladire("Cladirea Principala");
        c1.adaugaSala(a1);
        c1.adaugaSala(a2);
        c1.adaugaSala(a3);

        System.out.println(c1);
    }
}