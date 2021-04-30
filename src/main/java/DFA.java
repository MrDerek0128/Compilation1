import java.util.ArrayList;
import java.util.HashMap;

public class DFA {
    public String state = "start";

    public HashMap<String, String[]> DFAMap = new HashMap<>() {
        {
            put("start",new String[] {"start","char","num","operator","delimiter","wrong"});
            put("char",new String[] {"end","char","char","end","end","wrong"});
            put("num",new String[] {"end","end","num","end","end","wrong"});
            put("operator",new String[] {"end","end","end","end","end","wrong"});
            put("delimiter",new String[] {"end","end","end","end","end","wrong"});
        }
    };

    public ArrayList<Group> toResult(String fs) {
        ArrayList<Group> groups = new ArrayList<>();
        ArrayList<String> id = new ArrayList<>();
        String pre = state;
        String buff = "";
        int index;
        Form form = new Form();
        int charAddress = 1;
        for (int i = 0; i < fs.length();i++){
            char c = fs.charAt(i);
            int p = pend(c);
            if (p==5) {
                groups.add(0,new Group(-1));
                return groups;
            }
            pre = state;
            state = DFAMap.get(state)[p];
            if (i==fs.length()-1) {
                state="end";
            }
            if ("end".equals(state)){
                if ("char".equals(pre)) {
                    index = form.keyWord.indexOf(buff);
                    if (index != -1) {
                        groups.add(new Group(1,buff,index+1));
                    }else {
                        if (!id.contains(buff)){
                            groups.add(new Group(2,buff,charAddress));
                            id.add(buff);
                            charAddress++;
                        }else {
                            groups.add(new Group(2,buff,id.indexOf(buff)+1));
                        }

                    }
                }
                else if ("operator".equals(pre)) {
                    index = form.operator.indexOf(buff);
                    groups.add(new Group(3,buff,index+1));
                }
                else if ("num".equals(pre)) {
                    groups.add(new Group(4,buff,0));
                }
                else if ("delimiter".equals(pre)) {
                    index = form.delimiter.indexOf(buff);
                    groups.add(new Group(5,buff,index+1));
                }
                buff = "";
                state = DFAMap.get("start")[p];
            }
            buff = buff+c;
            if ("start".equals(state)){
                buff = "";
            }
        }
        if (!"".equals(buff)) {
            int p=pend(buff.charAt(0));
            if (p==3) {
                index = form.operator.indexOf(buff);
                groups.add(new Group(3,buff,index+1));
            }
            else if (p==4) {
                index = form.delimiter.indexOf(buff);
                groups.add(new Group(5,buff,index+1));
            }
            else if (p==5) {
                groups.add(0,new Group(-1));
            }
        }
        return groups;
    }

    public int pend(char c) {
        if (c==' ' || (int)c==10 || (int)c==13){
            return 0;
        }
        else if (Character.isLetter(c)){
            return 1;
        }
        else if (Character.isDigit(c) || c == '.'){
            return 2;
        }
        else if (new Form().operator.contains(Character.toString(c))){
            return 3;
        }
        else if (new Form().delimiter.contains(Character.toString(c))){
            return 4;
        }
        else {
            return 5;
        }
    }
}
