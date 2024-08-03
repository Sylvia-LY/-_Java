public class HelpHandler implements Handler {

    @Override
    public boolean doCmd(String word, Game game) {
        System.out.println("你迷路了吗？可用的命令有：go，help，bye");
        System.out.println("如：go east");
        return false;
    }
}
