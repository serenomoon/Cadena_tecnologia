package cadenatecnologia122;

public class Utils {

    public static String separadorHorizontal(int lenght) {
        return separadorHorizontal(lenght, '-');
    }

    public static String separadorHorizontal(int lenght, char caracter) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lenght; i++) {
            sb.append(caracter);
        }
        sb.append("\n");
        return sb.toString();
    }
}
