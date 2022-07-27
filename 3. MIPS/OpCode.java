public enum OpCode {
    or("0000"),
    add("0001"),
    sub("0010"),
    bneq("0011"),
    beq("0100"),
    sw("0101"),
    j("0110"),
    subi("0111"),
    lw("1000"),
    and("1001"),
    srl("1010"),
    addi("1011"),
    ori("1100"),
    nor("1101"),
    andi("1110"),
    sll("1111");

    private String code;

    OpCode(String s) {
        this.code = s;
    }

    public String getCode() { return this.code; }
}
