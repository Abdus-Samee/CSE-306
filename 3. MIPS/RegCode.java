public enum RegCode {
    $zero("0"),
    $t0("8"),
    $t1("9"),
    $t2("a"),
    $t3("b"),
    $t4("c");

    private String code;

    RegCode(String s){
        this.code = s;
    }

    public String getCode() { return this.code; }
}
