import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) throws IOException {
        String path = "src/main/resources/source.txt";
        File file = new File(path);
        String fs = FileUtils.readFileToString(file, "utf-8");
        DFA dfa = new DFA();
        ArrayList<Group> groups = dfa.toResult(fs);
        if (groups.get(0).address==-1){
            System.out.println("含有非法字符，识别失败");
            return;
        }
        ArrayList<String> id = MyUtil.getId(groups);
        String path1 = "src/main/resources/id.txt";
        File file1 = new File(path1);
        FileUtils.writeLines(file1,id,false);
        String path2 = "src/main/resources/result.txt";
        File file2 = new File(path2);
        FileUtils.writeStringToFile(file2,"","utf-8",false);
        for (Group group:groups) {
            String write = "";
            if (group.type==4) {
                write="("+group.type+","+group.value+")\n";
            } else {
                write="("+group.type+","+group.value+","+group.address+")\n";
            }
            FileUtils.writeStringToFile(file2,write,"utf-8",true);
        }
        System.out.println("识别通过");
    }
}
