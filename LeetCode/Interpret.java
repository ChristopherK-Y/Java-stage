//https://leetcode-cn.com/problems/goal-parser-interpretation/
public class Interpret {
    public String interpret(String command) {
        command = command.replace("()","o");
        command = command.replace("(al)","al");
        return command;
    }
}
