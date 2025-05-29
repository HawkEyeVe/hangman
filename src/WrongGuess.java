public class WrongGuess {
    private int guess;

    public void getPrintGuess(int guess) {
        switch (guess) {
            case 0 -> {
                System.out.println("""
                        
                        
                        
                        """);
            }
            case 1 -> {
                System.out.println("""
                         O
                        
                        
                        """);
            }
            case 2 -> {
                System.out.println("""
                         O
                         |
                        
                        """);
            }
            case 3 -> {
                System.out.println("""
                         O
                        /|
                        
                        """);
            }
            case 4 -> {
                System.out.println("""
                         O
                        /|\\
                        
                        """);
            }
            case 5 -> {
                System.out.println("""
                         O
                        /|\\
                        /
                        """);
            }
            case 6 -> {
                System.out.println("""
                         O
                        /|\\
                        / \\
                        """);
            }

        }
    }
}
