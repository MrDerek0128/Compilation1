public class Group {
    int type;
    String value;
    int address;

    public Group(int type, String value, int address) {
        this.type = type;
        this.value = value;
        this.address = address;
    }

    public Group(int address) {
        this.address = address;
    }
}
