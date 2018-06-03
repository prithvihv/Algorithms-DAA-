import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        StringTokenizer st = new StringTokenizer("1dt16cs068,04/06/18","/,");
        while(st.hasMoreTokens()){
            System.out.print(st.nextToken());
            if(st.hasMoreTokens()){
                System.out.print(",");
            }
        }
    }
}
