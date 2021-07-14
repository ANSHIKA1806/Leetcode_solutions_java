class Solution {
    public String customSortString(String S, String T) {
        int[] dict = new int[26];
         
        for (int i = 0; i < dict.length; i++) {
            dict[i] = Integer.MAX_VALUE;
        }
         
        // Step 1: note the position of each char in S
        //
        for (int i = 0; i < S.length(); i++) {
            dict[S.charAt(i) - 'a'] = i;
        }
         
        // Step 2: merge sort
        //
        char[] Aux = new char[T.length()];
        char[] A = T.toCharArray();
        customMergeSort(dict, A, Aux, 0, A.length - 1);
         
        return String.copyValueOf(A);
    }
     
    private void customMergeSort(int[] dict, char[] A, char[] Aux, int lo, int hi) {
         
        if (lo >= hi) {
            return;
        }
         
        int mid = lo + (hi - lo) / 2;
         
        customMergeSort(dict, A, Aux, lo, mid);
        customMergeSort(dict, A, Aux, mid + 1, hi);
         
        customMerge(dict, A, Aux, lo, mid, hi);
    }
     
    private void customMerge(int[] dict, char[] A, char[] Aux, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            Aux[i] = A[i];
        }
         
        int i = lo;
        int j = mid + 1;
         
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                A[k] = Aux[j++];
            } else if (j > hi) {
                A[k] = Aux[i++];
            } else if (dict[Aux[i] - 'a'] < dict[Aux[j] - 'a']) {
                A[k] = Aux[i++];;
            } else if (dict[Aux[i] - 'a'] >= dict[Aux[j] - 'a']) {
                A[k] = Aux[j++];
            }
        }
    }
}
