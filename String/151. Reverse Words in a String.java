class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        String[] tmp=s.split("\\s+");
        List<String> lst=new ArrayList<String>();
        for(String t:tmp){
            lst.add(t);
        }
        Collections.reverse(lst);
        StringBuilder sb=new StringBuilder();
        while(lst.size()>1){
            sb.append(lst.remove(0));
            sb.append(" ");
        }
        sb.append(lst.remove(0));
        return new String(sb);
    }
}
