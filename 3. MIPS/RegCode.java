public enum RegCode {
    $zero("0000"),
    $t0("1000"),
    $t1("1001"),
    $t2("1010"),
    $t3("1011"),
    $t4("1100");

    private String code;

    RegCode(String s){
        this.code = s;
    }

    public String getCode() { return this.code; }
}
