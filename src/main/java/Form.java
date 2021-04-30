import java.util.ArrayList;

public class Form {

    public ArrayList<String> keyWord = new ArrayList<>();
    public ArrayList<String> delimiter = new ArrayList<>();
    public ArrayList<String> operator = new ArrayList<>();

    public Form() {
        keyWord.add("auto");
        keyWord.add("break");
        keyWord.add("case");
        keyWord.add("char");
        keyWord.add("const");
        keyWord.add("continue");
        keyWord.add("default");
        keyWord.add("do");
        keyWord.add("double");
        keyWord.add("else");
        keyWord.add("enum");
        keyWord.add("extern");
        keyWord.add("float");
        keyWord.add("for");
        keyWord.add("goto");
        keyWord.add("if");
        keyWord.add("int");
        keyWord.add("long");
        keyWord.add("register");
        keyWord.add("return");
        keyWord.add("short");
        keyWord.add("signed");
        keyWord.add("sizeof");
        keyWord.add("static");
        keyWord.add("struct");
        keyWord.add("switch");
        keyWord.add("typedef");
        keyWord.add("union");
        keyWord.add("unsigned");
        keyWord.add("void");
        keyWord.add("volatile");
        keyWord.add("while");

        delimiter.add("\"");
        delimiter.add("'");
        delimiter.add("[");
        delimiter.add("]");
        delimiter.add("{");
        delimiter.add("}");
        delimiter.add("(");
        delimiter.add(")");
        delimiter.add(";");
        delimiter.add(",");
        delimiter.add(":");
        delimiter.add("|");
        delimiter.add("&");

        operator.add("+");
        operator.add("-");
        operator.add("*");
        operator.add("/");
        operator.add(">");
        operator.add("<");
        operator.add("=");
    }
}
