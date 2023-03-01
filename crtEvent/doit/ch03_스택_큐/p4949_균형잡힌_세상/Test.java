package doit.ch03_스택_큐.p4949_균형잡힌_세상;

public class Test {
    public static void main(String[] args) {
        String str = "So when I die (the [first] I will see in (heaven) is a score list).";
        String[] brackets = str.replaceAll("[^(\\(\\)\\[\\])]", "").split("");

        for (String bracket : brackets) {
            System.out.println(bracket);
        }
    }
}
