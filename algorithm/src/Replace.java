public class Replace {
    public String replaceSpace(StringBuffer str) {
        int spaceNum=0;
        for (int i=0;i<str.length();i++) {
            if (str.charAt(i)==' ') {
                spaceNum++;
            }
        }
        //str.charAt()是从0……到str.length()-1的，所以index要length()-1;
        int oldIndex=str.length()-1;
        int newStrLength=str.length()+2*spaceNum;
        int newIndex=newStrLength-1;
        str.setLength(newStrLength);

        //从右往左遍历
        while (oldIndex>=0&&oldIndex<newStrLength) {
            if (str.charAt(oldIndex)==' ') {
                str.setCharAt(newIndex--,'0');
                str.setCharAt(newIndex--,'2');
                str.setCharAt(newIndex--,'%');
            } else {
                str.setCharAt(newIndex--,str.charAt(oldIndex));
            }
            oldIndex--;
        }
        return str.toString();

    }
}
