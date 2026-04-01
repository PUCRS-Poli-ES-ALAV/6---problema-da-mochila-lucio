

public class MochilaDinamica{

    public record Tupla(int valor, int peso) {};

    static int it = 0;

    public static void main (String args []){
        Tupla [] itens = new Tupla[5];
        itens [1] = new Tupla(2,5);
        itens [2] = new Tupla(4,2);
        itens [3] = new Tupla(2,2);
        itens [4] = new Tupla(3,1);
        System.out.println(backPackPD(4, 7, itens));
        System.out.println(it);
    }


    public static int backPackPD (int n, int c, Tupla [] itens){
        int [] [] maxTab = new int [n+1][c+1];
        for (int i = 0;i<=c;i++){
            maxTab[0][i] = 0;
        }
        for (int i = 0;i<=n;i++){
            maxTab[i][0] = 0;
        }
        
        for (int i = 1;i<=n;i++){
            for (int j = 1;j<=c;j++){
                it++;
                if (itens[i].peso<=j){
                    maxTab [i][j] = Math.max(maxTab[i-1][j], (itens[i].valor + maxTab[i-1][j-itens[i].peso]));
                }
                else{
                    maxTab [i][j] = maxTab[i-1][j];
                }
            }
        }
        return maxTab[n][c];
    }
}