import java.util.Arrays;

class Sala {
    String nume;
    int asdasda;
    boolean[] interval=new boolean[24];
    public Sala(String nume)
    {
        this.nume=nume;
        Arrays.fill(interval, false);
    }

    public String toString()
    {
        StringBuilder s=new StringBuilder();
        s.append("Numele: ").append("A101\n");
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


public class University {
    public static void main(String[] args) {
        Sala a1 = new Sala("A101");
        System.out.println(a1);
        a1.ocupareSala(0, 2);
        System.out.println(a1);
        a1.ocupareSala(8, 11);
        System.out.println(a1);
        a1.ocupareSala(8, 12);
        System.out.println(a1);
        a1.ocupareSala(19, 21);
        System.out.println(a1);
        a1.ocupareSala(15, 18);
        System.out.println(a1);
    }
}