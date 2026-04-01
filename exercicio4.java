import java.util.List;

public class exercicio4{


    public static int mochilaMaxValor(int[] pesos, int[] valores, int capacidade) {
        int n = pesos.length;
        int melhorValor = 0;
        int combinaçõesPossiveis = 1 << n;

        for (int mascara = 0; mascara < combinaçõesPossiveis; mascara++) {

            int pesoTotal = 0;
            int valorTotal = 0;

            for (int i = 0; i < n; i++) {
                if ((mascara & (1 << i)) != 0) {
                    pesoTotal += pesos[i];
                    valorTotal += valores[i];
                }
            }

            if (pesoTotal <= capacidade && valorTotal > melhorValor) {
                melhorValor = valorTotal;
            }
        }

        return melhorValor;
    }

    public static void main(String[] args) {
      int[] pesos = {5,2,2,1};
      int[] valores = {2,4,2,3};
      int capacidade = 7;

      System.out.println(mochilaMaxValor(pesos, valores, capacidade));
    }
}
