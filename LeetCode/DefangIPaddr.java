//https://leetcode-cn.com/problems/defanging-an-ip-address/
public class DefangIPaddr {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
    public static void main(String[] args){
        String newString = "1.1.1.1";
        System.out.println(new DefangIPaddr().defangIPaddr(newString));
    }
}
