public class MinimumWindowSubstring {
    public static String minWindow(String S, String T) {
    
    if(S==null||S.isEmpty()||T==null||T.isEmpty()) return "";
    
    int i=0, j=0;
    int[] Tmap=new int[256];
    int[] Smap=new int[256];
    for(int k=0; k< T.length(); k++){
        Tmap[T.charAt(k)]++;
    }
    int found=0;
    int length=Integer.MAX_VALUE;
    String res="";
    while(j<S.length()){
        if(found<T.length()){
            if(Tmap[S.charAt(j)]>0){
                Smap[S.charAt(j)]++;
                if(Smap[S.charAt(j)]<=Tmap[S.charAt(j)]){
                    found++;
                }
            }
            j++;
        }
        while(found==T.length()){
            if(j-i<length){
                length=j-i; res=S.substring(i,j);
            }
            if(Tmap[S.charAt(i)]>0){
                Smap[S.charAt(i)]--;
                if(Smap[S.charAt(i)]<Tmap[S.charAt(i)]){
                    found--;
                }
            }
            i++;
        }
    }
    return res;
    }

    public static void main(String args[])
    {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
