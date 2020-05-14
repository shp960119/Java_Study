import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static int max = 0;
    static void combination(int[] arr, boolean[] visited, int start, int n, int r, int R, boolean[][] word,LinkedList<Integer> L, int[] I ) {
        if(r == 0) {
            int[] nrr = new int[R];
            int temp = 0;
            int ans;
            for(int i = 0; i < n; i++){
                if(visited[i]){
                    nrr[temp] = arr[i];
                    temp++;
                }
            }
            ans = check(nrr,word,L,I);
            if(max < ans){
                max = ans;
            }
            return;
        }

        for(int i=start; i<n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1,R,word,L,I);
            visited[i] = false;
        }
    }
    public static int check(int[] arr, boolean[][] word,LinkedList<Integer> L, int[] I){
        int num = 0;
        int tt;
        int cc;
        boolean bo;
        for(int i = 0; i < word.length; i++){
            bo = true;
            tt = 0;
            cc = 0;
            for(int j = 0; j < word[0].length; j++){
                if(word[i][j]){
                    tt++;
                }
            }
            for(int j = 0; j < arr.length; j++){
                if(I[i] > arr.length){
                    bo = false;
                    break;
                }
                if(word[i][L.get(arr[j])]){
                    cc++;
                }
            }
            if(bo && (cc == tt-5)){
                num++;
            }
        }
        return num;
    }
    public static void set(){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int K = scan.nextInt();
        boolean[][] words = new boolean[N][26];
        int[] len = new int[N];
        String[] S = new String[N];
        LinkedList<Integer> te = new LinkedList<>();
        LinkedList<Integer> ce = new LinkedList<>();
        te.add((int)'a' - 97);
        te.add((int)'n' - 97);
        te.add((int)'t' - 97);
        te.add((int)'i' - 97);
        te.add((int)'c' - 97);
        int temp;
        int tint;
        for(int i = 0; i < N; i++){
            S[i] = scan.next();
            words[i][(int)'a' - 97] = true;
            words[i][(int)'n' - 97] = true;
            words[i][(int)'t' - 97] = true;
            words[i][(int)'i' - 97] = true;
            words[i][(int)'c' - 97] = true;
            tint = 0;
            for(int j = 4; j < S[i].length()-4; j++){
                temp = (int)S[i].charAt(j)-97;
                if(!words[i][temp]) {
                    words[i][temp] = true;
                    tint++;
                }
                if(!te.contains(temp)){
                    te.add(temp);
                    ce.add(temp);
                }
            }
            len[i] = tint;
        }
        int[] arr = new int[ce.size()];
        boolean[] visited = new boolean[ce.size()];

        for(int i = 0; i < arr.length; i++){
            arr[i] = i;
        }
        if(ce.size() > K-5) {
            combination(arr, visited, 0, ce.size(), K - 5, K - 5, words, ce, len);
            System.out.println(max);
        }
        else{
            System.out.println(N);
        }
    }

    public static void main(String[] args) {
        set();
    }
}
