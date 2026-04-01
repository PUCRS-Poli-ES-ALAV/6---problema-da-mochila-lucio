import java.util.HashMap;
import java.util.Map;

class Fibo {

    private static long iterations;
    private static Map<Long, Long> mem;
    public static void main(String[] args) {
        int[] testes_base = {4, 8, 16, 32};
        int[] testes_extra = {128, 1000, 10000};

        /* for (int i : testes_base) {
            iterations = 0;
            System.out.printf("%d elementos\n", i);
            System.out.printf("Recursivo base:\n Resultado: %d\n Iteracoes: %d\n", fibo_rec(i), iterations);
            iterations = 0;
            System.out.printf("Vetorial:\n Resultado: %d\n Iteracoes: %d\n", fibo_vet(i), iterations);
            iterations = 0;
            System.out.printf("Recursivo com cache:\n Resultado: %d\n Iteracoes: %d\n", fibo_mem(i), iterations);
        } */
        for (int i : testes_extra) {
            iterations = 0;
            System.out.printf("%d elementos\n", i);
            System.out.printf("Vetorial:\n Resultado: %d\n Iteracoes: %d\n", fibo_vet(i), iterations);
            iterations = 0;
            //System.out.printf("Recursivo com cache:\n Resultado: %d\n Iteracoes: %d\n", fibo_mem(i), iterations);
        }
    }

    static long fibo_rec(int n){
        iterations++;
        if(n<=1)
            return n;
        return fibo_rec(n-1)+fibo_rec(n-2);
    }

    static long fibo_vet(int n){
        long[] vet = new long[n+1];
        vet[0] = 0;
        vet[1] = 1;

        for (int i = 2; i < vet.length; i++) {
            iterations++;
            vet[i] = vet[i-1]+vet[i-2];
        }
        return vet[n];
    }

    static long fibo_mem(long n){
        mem = new HashMap<>();
        mem.put((long) 0, (long) 0);
        mem.put((long) 1, (long) 1);

        return fibo_mem_rec(n);
    }

    static long fibo_mem_rec(long n){
        iterations++;
        if(mem.containsKey(n))
            return mem.get(n);
        long atrshi = fibo_mem_rec(n-1)+fibo_mem_rec(n-2);
        mem.put(n, atrshi);
        return atrshi;
    }
}