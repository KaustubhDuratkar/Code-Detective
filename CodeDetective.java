import java.io.*;
import java.time.LocalDate;
import java.util.*;

interface Debuggable {
    void investigate();
    boolean solve(String answer);
}

abstract class Bug {
    private String type;
    private String explanation;

    public Bug(String type, String explanation) {
        this.type = type;
        this.explanation = explanation;
    }

    public String getType() {
        return type;
    }

    public String getExplanation() {
        return explanation;
    }

    public abstract void display();
}

class RuntimeBug extends Bug {
    public RuntimeBug(String explanation) {
        super("Runtime Error", explanation);
    }

    @Override
    public void display() {
        System.out.println("Bug Category: Runtime Error");
    }
}

class LogicBug extends Bug {
    public LogicBug(String explanation) {
        super("Logic Error", explanation);
    }

    @Override
    public void display() {
        System.out.println("Bug Category: Logic Error");
    }
}

class CompileBug extends Bug {
    public CompileBug(String explanation) {
        super("Compilation Error", explanation);
    }

    @Override
    public void display() {
        System.out.println("Bug Category: Compilation Error");
    }
}

class ConceptBug extends Bug {
    public ConceptBug(String explanation) {
        super("Conceptual Error", explanation);
    }

    @Override
    public void display() {
        System.out.println("Bug Category: Conceptual Error");
    }
}

class CaseFile implements Debuggable {
    private int id;
    private String title;
    private String story;
    private String code;
    private String evidence;
    private Bug bug;
    private String repair;
    private String[] keywords;
    private int difficulty;
    private boolean solved;
    private boolean hintUsed;

    public CaseFile(int id, String title, String story, String code,
                    String evidence, Bug bug, String repair,
                    String[] keywords, int difficulty) {
        this.id = id;
        this.title = title;
        this.story = story;
        this.code = code;
        this.evidence = evidence;
        this.bug = bug;
        this.repair = repair;
        this.keywords = keywords;
        this.difficulty = difficulty;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public boolean isSolved() {
        return solved;
    }

    public boolean isHintUsed() {
        return hintUsed;
    }

    public void markSolved() {
        solved = true;
    }

    public void useHint() {
        hintUsed = true;
    }

    public void investigate() {
        System.out.println("\n----------------------------------------");
        System.out.println("CASE #" + id + " : " + title);
        System.out.println("----------------------------------------");
        System.out.println("Story:");
        System.out.println(story);

        System.out.println("\nBroken Code:");
        System.out.println(code);

        System.out.println("Evidence:");
        System.out.println(evidence);

        bug.display();
        System.out.println("Difficulty: " + getDifficultyName());
    }

    public boolean solve(String answer) {
        String cleaned = answer.toLowerCase().trim();

        for (String keyword : keywords) {
            if (cleaned.contains(keyword.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public void showRepair() {
        System.out.println("\nCorrect Diagnosis: " + bug.getType());
        System.out.println("Explanation:");
        System.out.println(bug.getExplanation());

        System.out.println("\nCorrect Repair:");
        System.out.println(repair);
    }

    private String getDifficultyName() {
        if (difficulty == 1)
            return "Easy";
        if (difficulty == 2)
            return "Medium";
        return "Hard";
    }
}

class Detective {
    private String name;
    private int xp;
    private int solvedCases;
    private int hintsUsed;
    private int streak;
    private int attempts;
    private Set<String> achievements;

    public Detective(String name) {
        this.name = name;
        achievements = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public int getXp() {
        return xp;
    }

    public int getSolvedCases() {
        return solvedCases;
    }

    public int getHintsUsed() {
        return hintsUsed;
    }

    public int getStreak() {
        return streak;
    }

    public int getAttempts() {
        return attempts;
    }

    public void addAttempt() {
        attempts++;
    }

    public void solveCase(int difficulty, boolean hintUsed) {
        int reward = difficulty * 50;

        if (!hintUsed) {
            reward += 25;
        }

        xp += reward;
        solvedCases++;
        streak++;

        if (solvedCases == 1)
            unlock("First Blood");

        if (solvedCases >= 5)
            unlock("Bug Hunter");

        if (solvedCases >= 10)
            unlock("Master Detective");

        if (streak >= 3)
            unlock("Three Case Streak");

        if (!hintUsed)
            unlock("No Hints Needed");
    }

    public boolean useHint() {
        if (xp >= 15) {
            xp -= 15;
            hintsUsed++;
            return true;
        }
        return false;
    }

    public String getRank() {
        if (xp < 100)
            return "Rookie Detective";
        if (xp < 250)
            return "Junior Debugger";
        if (xp < 500)
            return "Code Sleuth";
        if (xp < 800)
            return "Bug Hunter";
        if (xp < 1200)
            return "Senior Detective";
        return "Code Master";
    }

    public int getLevel() {
        return (xp / 200) + 1;
    }

    public void unlock(String achievement) {
        achievements.add(achievement);
    }

    public boolean hasAchievement(String achievement) {
        return achievements.contains(achievement);
    }

    public Set<String> getAchievements() {
        return achievements;
    }

    public void showProfile() {
        System.out.println("\n========== DETECTIVE PROFILE ==========");
        System.out.println("Name          : " + name);
        System.out.println("Rank          : " + getRank());
        System.out.println("Level         : " + getLevel());
        System.out.println("XP            : " + xp);
        System.out.println("Cases Solved  : " + solvedCases);
        System.out.println("Attempts      : " + attempts);
        System.out.println("Hints Used    : " + hintsUsed);
        System.out.println("Current Streak: " + streak);
        System.out.println("========================================");
    }

    public void showAchievements() {
        System.out.println("\n========== ACHIEVEMENTS ==========");

        String[] all = {
            "First Blood",
            "Bug Hunter",
            "Master Detective",
            "Three Case Streak",
            "No Hints Needed"
        };

        for (String achievement : all) {
            if (hasAchievement(achievement))
                System.out.println("[UNLOCKED] " + achievement);
            else
                System.out.println("[LOCKED]   " + achievement);
        }
    }

    public void loadData(int xp, int solved, int hints, int streak,
                         int attempts, Set<String> loadedAchievements) {
        this.xp = xp;
        this.solvedCases = solved;
        this.hintsUsed = hints;
        this.streak = streak;
        this.attempts = attempts;
        this.achievements = loadedAchievements;
    }
}

class GameEngine {
    private ArrayList<CaseFile> cases;
    private Detective detective;
    private Scanner scanner;
    private Random random;
    private LocalDate lastDailyChallenge;

    public GameEngine(Detective detective) {
        this.detective = detective;
        scanner = new Scanner(System.in);
        random = new Random();
        cases = new ArrayList<>();
        createCases();
    }

    private void createCases() {

        cases.add(new CaseFile(
            1,
            "The Divided Number",
            "A calculator program suddenly crashes when the detective enters zero.",
            "int a = 20;\nint b = 0;\nint result = a / b;\nSystem.out.println(result);",
            "Console: java.lang.ArithmeticException: / by zero",
            new RuntimeBug("Java cannot perform integer division by zero. It throws ArithmeticException."),
            "Check whether b is zero before performing the division.",
            new String[]{"arithmetic", "division by zero", "divide by zero", "arithmeticexception"},
            1
        ));

        cases.add(new CaseFile(
            2,
            "The Missing Evidence",
            "A tiny program refuses to compile even though its logic appears correct.",
            "int x = 10\nSystem.out.println(x);",
            "Compiler: ';' expected",
            new CompileBug("Java statements normally end with a semicolon."),
            "int x = 10;\nSystem.out.println(x);",
            new String[]{"semicolon", "missing semicolon", ";"},
            1
        ));

        cases.add(new CaseFile(
            3,
            "The Rectangle Mystery",
            "A rectangle program produces an incorrect area for every input.",
            "int length = 10;\nint width = 5;\nint area = length + width;\nSystem.out.println(area);",
            "Expected area: 50\nProgram output: 15",
            new LogicBug("The area of a rectangle is length multiplied by width, not added."),
            "int area = length * width;",
            new String[]{"multiplication", "multiply", "length * width", "logic"},
            1
        ));

        cases.add(new CaseFile(
            4,
            "Beyond the Array",
            "The program is asked to display the fourth element of a three-element array.",
            "int[] numbers = {10, 20, 30};\nSystem.out.println(numbers[3]);",
            "Console: ArrayIndexOutOfBoundsException",
            new RuntimeBug("An array of three elements has indexes 0, 1 and 2."),
            "Use numbers[2] for the third element, or increase the array size.",
            new String[]{"array index", "index", "arrayindexoutofbounds", "out of bounds"},
            1
        ));

        cases.add(new CaseFile(
            5,
            "The Number Impostor",
            "A user enters a word where the program expects a number.",
            "String input = \"hello\";\nint number = Integer.parseInt(input);",
            "Console: NumberFormatException",
            new RuntimeBug("parseInt() cannot convert a non-numeric String such as hello into an integer."),
            "Validate the input or handle NumberFormatException using try-catch.",
            new String[]{"numberformatexception", "parseint", "non numeric", "invalid number"},
            2
        ));

        cases.add(new CaseFile(
            6,
            "The Invisible Object",
            "A programmer tries to access a method, but the object was never created.",
            "String name = null;\nSystem.out.println(name.length());",
            "Console: NullPointerException",
            new RuntimeBug("name contains null, so there is no String object on which length() can be called."),
            "Initialize name before using it, or check name != null.",
            new String[]{"nullpointer", "null", "nullpointerexception"},
            2
        ));

        cases.add(new CaseFile(
            7,
            "The Endless Loop",
            "A countdown application never reaches its final message.",
            "int i = 5;\nwhile (i > 0) {\n    System.out.println(i);\n}",
            "Program keeps printing 5 forever.",
            new LogicBug("The loop condition remains true because i is never changed."),
            "Decrease i inside the loop: i--;",
            new String[]{"infinite loop", "i--", "decrement", "loop condition"},
            2
        ));

        cases.add(new CaseFile(
            8,
            "The Identity Crisis",
            "Two strings contain the same text, but Java reports that they are different.",
            "String a = new String(\"Java\");\nString b = new String(\"Java\");\nif (a == b)\n    System.out.println(\"Same\");",
            "Output: Nothing",
            new ConceptBug("== compares object references for Strings. equals() compares their contents."),
            "Use if (a.equals(b)) to compare String values.",
            new String[]{"equals", "string", "reference", "==", "string comparison"},
            2
        ));

        cases.add(new CaseFile(
            9,
            "The Constructor Trap",
            "A Student object receives a name, but the object's field remains empty.",
            "class Student {\n    String name;\n    Student(String name) {\n        name = name;\n    }\n}",
            "student.name remains null.",
            new ConceptBug("The parameter name is assigned to itself. this.name refers to the object's field."),
            "Student(String name) {\n    this.name = name;\n}",
            new String[]{"this", "this.name", "constructor", "field"},
            2
        ));

        cases.add(new CaseFile(
            10,
            "The Maximum Mistake",
            "The program should find the largest number, but returns the smallest one.",
            "int a = 10;\nint b = 20;\nint max;\nif (a < b)\n    max = a;\nelse\n    max = b;",
            "Expected maximum: 20\nProgram output: 10",
            new LogicBug("The comparison assigns the smaller value when a < b."),
            "if (a > b) max = a; else max = b;",
            new String[]{"comparison", "greater", ">", "maximum", "max"},
            2
        ));

        cases.add(new CaseFile(
            11,
            "The File That Isn't There",
            "A report generator tries to read a file that does not exist.",
            "FileReader reader = new FileReader(\"report.txt\");",
            "Compiler: unreported exception FileNotFoundException",
            new CompileBug("FileReader can throw FileNotFoundException and must be handled or declared."),
            "Use try-catch or declare throws FileNotFoundException.",
            new String[]{"filenotfound", "exception", "try catch", "throws"},
            3
        ));

        cases.add(new CaseFile(
            12,
            "The Race",
            "Two threads update the same counter, but the final result changes between runs.",
            "class Counter {\n    int count = 0;\n    void increment() {\n        count++;\n    }\n}",
            "Two threads should produce 2000, but output may be less than 2000.",
            new ConceptBug("Both threads can access count simultaneously. The update operation is not synchronized."),
            "Use synchronized on increment() so only one thread changes count at a time.",
            new String[]{"synchronized", "race condition", "thread", "concurrency"},
            3
        ));
    }

    public void start() {
        System.out.println("\n========================================");
        System.out.println("           CODEDETECTIVE");
        System.out.println("     Interactive Java Debugging");
        System.out.println("========================================");

        boolean running = true;

        while (running) {
            showMenu();

            int choice = readInt("Choose an option: ");

            switch (choice) {
                case 1:
                    investigateCase();
                    break;
                case 2:
                    randomCase();
                    break;
                case 3:
                    dailyChallenge();
                    break;
                case 4:
                    detective.showProfile();
                    break;
                case 5:
                    showCaseHistory();
                    break;
                case 6:
                    detective.showAchievements();
                    break;
                case 7:
                    saveProgress();
                    break;
                case 8:
                    showGuide();
                    break;
                case 9:
                    running = false;
                    saveProgress();
                    System.out.println("\nProgress saved. Detective signing off.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void showMenu() {
        System.out.println("\n============== MAIN MENU ==============");
        System.out.println("1. Investigate a Case");
        System.out.println("2. Random Case");
        System.out.println("3. Daily Challenge");
        System.out.println("4. Detective Profile");
        System.out.println("5. Case History");
        System.out.println("6. Achievements");
        System.out.println("7. Save Progress");
        System.out.println("8. How To Play");
        System.out.println("9. Exit");
        System.out.println("========================================");
    }

    private void investigateCase() {
        showCaseList();

        int id = readInt("Enter case number: ");
        CaseFile selected = findCase(id);

        if (selected == null) {
            System.out.println("Case not found.");
            return;
        }

        playCase(selected);
    }

    private void randomCase() {
        ArrayList<CaseFile> available = new ArrayList<>();

        for (CaseFile c : cases) {
            if (!c.isSolved())
                available.add(c);
        }

        if (available.isEmpty()) {
            System.out.println("All cases have been solved!");
            return;
        }

        CaseFile selected = available.get(random.nextInt(available.size()));
        System.out.println("\nRandom case selected...");
        playCase(selected);
    }

    private void dailyChallenge() {
        LocalDate today = LocalDate.now();

        System.out.println("\n========== DAILY CHALLENGE ==========");
        System.out.println("Date: " + today);

        int index = today.getDayOfYear() % cases.size();
        CaseFile selected = cases.get(index);

        if (selected.isSolved()) {
            System.out.println("Today's case has already been solved.");
            return;
        }

        System.out.println("Today's detective assignment:");
        playCase(selected);
    }

    private void playCase(CaseFile selected) {
        selected.investigate();

        boolean hintUsed = false;

        while (true) {
            System.out.println("\n1. Submit Diagnosis");
            System.out.println("2. Request Hint");
            System.out.println("3. View Repair");
            System.out.println("4. Abandon Case");

            int choice = readInt("Choose: ");

            if (choice == 1) {
                String answer = readLine("What is the bug? ");
                detective.addAttempt();

                if (selected.solve(answer)) {
                    if (selected.isSolved()) {
                        System.out.println("\nCase already solved.");
                        selected.showRepair();
                        return;
                    }

                    selected.markSolved();
                    detective.solveCase(
                        selected.getDifficulty(),
                        hintUsed || selected.isHintUsed()
                    );

                    System.out.println("\n*** CASE SOLVED ***");
                    selected.showRepair();

                    int reward = selected.getDifficulty() * 50;
                    if (!hintUsed && !selected.isHintUsed())
                        reward += 25;

                    System.out.println("\nXP earned: " + reward);
                    System.out.println("Current Rank: " + detective.getRank());
                    System.out.println("Current Level: " + detective.getLevel());
                    return;
                } else {
                    System.out.println("\nIncorrect diagnosis.");
                    System.out.println("The evidence suggests another problem.");
                }

            } else if (choice == 2) {
                if (selected.isHintUsed()) {
                    System.out.println("Hint already used for this case.");
                } else if (detective.useHint()) {
                    selected.useHint();
                    hintUsed = true;
                    System.out.println("\nHINT: Focus on the error message and the suspicious operation.");
                    System.out.println("Hint cost: 15 XP");
                } else {
                    System.out.println("You need at least 15 XP to use a hint.");
                }

            } else if (choice == 3) {
                selected.showRepair();

            } else if (choice == 4) {
                System.out.println("Case abandoned. No XP awarded.");
                return;

            } else {
                System.out.println("Invalid option.");
            }
        }
    }

    private void showCaseList() {
        System.out.println("\n============== CASE FILES =============");

        for (CaseFile c : cases) {
            String status = c.isSolved() ? "[SOLVED]" : "[OPEN]";
            String difficulty;

            if (c.getDifficulty() == 1)
                difficulty = "Easy";
            else if (c.getDifficulty() == 2)
                difficulty = "Medium";
            else
                difficulty = "Hard";

            System.out.println(
                c.getId() + ". " + c.getTitle() +
                " | " + difficulty + " | " + status
            );
        }
    }

    private void showCaseHistory() {
        System.out.println("\n============= CASE HISTORY =============");

        int solved = 0;

        for (CaseFile c : cases) {
            if (c.isSolved()) {
                solved++;
                System.out.println(
                    "Case #" + c.getId() + " - " +
                    c.getTitle() + " : SOLVED"
                );
            }
        }

        if (solved == 0)
            System.out.println("No cases solved yet.");

        System.out.println("\nProgress: " + solved + "/" + cases.size());
    }

    private CaseFile findCase(int id) {
        for (CaseFile c : cases) {
            if (c.getId() == id)
                return c;
        }
        return null;
    }

    private int readInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private String readLine(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    private void showGuide() {
        System.out.println("\n============= HOW TO PLAY =============");
        System.out.println("You are a Java debugging detective.");
        System.out.println("Each case contains:");
        System.out.println("- A short story");
        System.out.println("- Broken Java code");
        System.out.println("- Evidence or an error message");
        System.out.println("- A hidden bug category");
        System.out.println();
        System.out.println("Your job is to identify the bug.");
        System.out.println("Correct answers earn XP.");
        System.out.println("Hints cost 15 XP.");
        System.out.println("Hard cases give more XP.");
        System.out.println("Solve cases without hints for bonus XP.");
        System.out.println("========================================");
    }

    public void saveProgress() {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("detective_save.txt"));

            writer.println(detective.getName());
            writer.println(detective.getXp());
            writer.println(detective.getSolvedCases());
            writer.println(detective.getHintsUsed());
            writer.println(detective.getStreak());
            writer.println(detective.getAttempts());

            for (CaseFile c : cases) {
                if (c.isSolved())
                    writer.println("SOLVED:" + c.getId());
            }

            writer.close();
            System.out.println("Progress saved to detective_save.txt");

        } catch (IOException e) {
            System.out.println("Could not save progress.");
        }
    }
}

public class CodeDetective {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("           CODEDETECTIVE");
        System.out.println("      Java Debugging Learning Game");
        System.out.println("========================================");

        System.out.print("Enter detective name: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty())
            name = "Anonymous Detective";

        Detective detective = new Detective(name);

        loadPreviousProgress(detective);

        GameEngine game = new GameEngine(detective);
        game.start();

        scanner.close();
    }

    private static void loadPreviousProgress(Detective detective) {

        File file = new File("detective_save.txt");

        if (!file.exists()) {
            System.out.println("\nNo previous save found.");
            System.out.println("Starting a new investigation...");
            return;
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            reader.readLine();

            int xp = Integer.parseInt(reader.readLine());
            int solved = Integer.parseInt(reader.readLine());
            int hints = Integer.parseInt(reader.readLine());
            int streak = Integer.parseInt(reader.readLine());
            int attempts = Integer.parseInt(reader.readLine());

            Set<String> achievements = new HashSet<>();

            if (solved >= 1)
                achievements.add("First Blood");
            if (solved >= 5)
                achievements.add("Bug Hunter");
            if (solved >= 10)
                achievements.add("Master Detective");
            if (streak >= 3)
                achievements.add("Three Case Streak");
            if (hints == 0 && solved > 0)
                achievements.add("No Hints Needed");

            detective.loadData(
                xp,
                solved,
                hints,
                streak,
                attempts,
                achievements
            );

            reader.close();

            System.out.println("\nPrevious progress detected.");
            System.out.println("Welcome back, " + detective.getName() + "!");
            System.out.println("XP: " + detective.getXp());
            System.out.println("Rank: " + detective.getRank());

        } catch (IOException | NumberFormatException e) {
            System.out.println("Save file could not be loaded.");
            System.out.println("Starting with fresh progress.");
        }
    }
}
