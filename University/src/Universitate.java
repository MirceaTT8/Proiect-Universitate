import java.util.Arrays;
abstract class Sala {
    String nume;
    boolean[] interval=new boolean[24];
    public Sala(String nume)
    {
        this.nume=nume;
        Arrays.fill(interval, false);
    }

    public String toString()
    {
        StringBuilder s=new StringBuilder();
        s.append("Numele: ").append(this.nume).append("\n");
        for(int i = 0 ; i < 24 ; i++)
            s.append(interval[i]).append(" ").append(i).append("-").append(i+1).append("\n");
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
            System.out.println("Sala nu se poate lua intre aceste ore!");
        }
    }

}



class Sala_Seminar extends Sala{
    private final int locuri;
    public Sala_Seminar(String nume)
    {
        super(nume);
        locuri = 50;
    }
    public String toString()
    {
        return "Tipul Salii: Seminar\n Cu locurile" + this.locuri + "\n" + super.toString();
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
        Sala_Seminar a1 = new Sala_Seminar("A101");
        System.out.println(a1);
        a1.ocupareSala(10, 13);
        Cladire c1=new Cladire("Cladirea Principala");
        c1.adaugaSala(a1);
        System.out.println(c1);
    }
}