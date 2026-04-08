public class DistanciaEdicaoDinamica{


    static int it = 0;

    public static void main(String[] args) {
        String s1 = "Maven, a Yiddish word meaning accumulator of knowledge, began as an attempt to " +
				"simplify the build processes in the Jakarta Turbine project. There were several" + 
				" projects, each with their own Ant build files, that were all slightly different." +
				"JARs were checked into CVS. We wanted a standard way to build the projects, a clear "+ 
				"definition of what the project consisted of, an easy way to publish project information" +
				"and a way to share JARs across several projects. The result is a tool that can now be" +
				"used for building and managing any Java-based project. We hope that we have created " +
				"something that will make the day-to-day work of Java developers easier and generally help " +
				"with the comprehension of any Java-based project.";
        String s2 = "This post is not about deep learning. But it could be might as well. This is the power of " +
				"kernels. They are universally applicable in any machine learning algorithm. Why you might" +
				"ask? I am going to try to answer this question in this article." + 
			        "Go to the profile of Marin Vlastelica Pogančić" + 
			        "Marin Vlastelica Pogančić Jun";
        System.out.println(distEdProgDina(s1,s2));
        System.out.println(it);
    }

    public static int distEdProgDina(String a, String b){
        int m = a.length();
        int n = b.length();
        int [] [] matriz = new int [m+1][n+1];
        matriz[0][0] = 0;
        int custoExtra = 0;
        for (int i = 1;i<m+1;i++){
            matriz[i][0] = matriz[i-1][0]+1;
        }
        for (int i = 1;i<n+1;i++){
            matriz[0][i] = matriz[0][i-1]+1;
        }
        for (int i = 1;i<m+1;i++){
            for (int j = 1; j < n+1; j++) {
                it++;
                if(a.charAt(i-1)==b.charAt(j-1)){
                    custoExtra =0;
                }
                else{
                    custoExtra =1;
                }
                matriz[i][j] = Math.min(matriz[i-1][j]+1, Math.min(matriz[i][j-1]+1,matriz[i-1][j-1]+custoExtra));
            }
        }

        return matriz[m][n];
    }
}