class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] bp=new boolean[s.length()+1][p.length()+1];
        bp[s.length()][p.length()]=true;
        for(int i=p.length()-1;i>=0;i--){
            if(p.charAt(i)!='*')
                break;
            else
                bp[s.length()][i]=true;
        }
        for (int i=s.length()-1;i>=0;i--) {
            for (int j=p.length()-1;j>=0;j--) {
                boolean first=s.charAt(i)==p.charAt(j) || p.charAt(j)=='?' || p.charAt(j)=='*';
                if (first) {
                    if (p.charAt(j)=='*') bp[i][j]=bp[i+1][j] || bp[i][j+1];
                    else bp[i][j]=bp[i+1][j+1];
                } else {
                    bp[i][j]=false;
                }
            }
        }
        return bp[0][0];
    }
}
