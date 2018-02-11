package tutorioal;

public class Main {

    public static void main(String[] args) {

        System.out.println(beautify("trots", 't'));

    }

    public static String beautify(String s, char bad) {

        StringBuilder buffer = new StringBuilder();

        for (char currentChar : s.toCharArray()) {
            if(currentChar != bad){
                buffer.append(currentChar);
            }
        }

        return buffer.toString();
    }
}

