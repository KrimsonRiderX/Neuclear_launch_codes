import java.util.HashMap;
import java.util.Map;

/**
 * OOPSBannerApp UC8 – Use HashMap for Character Pattern Management
 *
 * This use case extends UC7 by implementing a HashMap-based character pattern system
 * to improve flexibility and scalability. Instead of managing CharacterPatternMap objects
 * in an array, this implementation utilizes the Collections Framework to store patterns
 * in a HashMap for more efficient character lookups and cleaner pattern management.
 *
 * @author Aditya Ojha
 * @version 8.0
 */
public class hi {

    // Extend UC7 to utilize the Collections Framework with HashMap for managing
    // character patterns. This approach provides more efficient character lookups,
    // better scalability, and eliminates the need for array-based management.

    // Key Requirements:
    // 1. Use HashMap to store ASCII art patterns for characters
    // 2. Create methods to generate and retrieve character patterns
    // 3. Retrieve the Character Pattern and display patterns for the message "OOPS"
    // 4. Implement a modular and reusable character pattern system
    // 5. Utilize the Collections Framework for pattern management

    // Benefit: HashMap provides O(1) lookup time compared to array's O(n) linear search–

    /**
     * CharacterPatternMap – Inner class for storing character-to-pattern mappings
     *
     * Encapsulates a single character and its corresponding ASCII art pattern.
     * Provides immutable access to character and pattern data through getters.
     */
    static class CharacterPatternMap {
        /** The character being represented */
        Character character;
        /** The ASCII art pattern lines for the character */
        String[] pattern;

        /**
         * Constructs a CharacterPatternMap with a character and its pattern
         *
         * @param character the character to be mapped
         * @param pattern   the ASCII art pattern representation as array of strings
         */
        public CharacterPatternMap(Character character, String[] pattern) {
            this.character = character;
            this.pattern = pattern;
        }

        /**
         * Retrieves the mapped character
         *
         * @return the character associated with this pattern map
         */
        public Character getCharacter() {
            return character;
        }

        /**
         * Retrieves the ASCII art pattern
         *
         * @return the pattern array representing the character
         */
        public String[] getPattern() {
            return pattern;
        }
    }

    /**
     * Static Method to Create and initialize a HashMap with character-to-pattern mappings
     *
     * Populates a HashMap with ASCII art patterns for letters 'O', 'P', 'S' and space character.
     * Uses the Collections Framework (HashMap) for more efficient pattern management and lookup.
     * Each character has a 7-line ASCII art representation.
     *
     * @return HashMap where keys are characters and values are String arrays representing patterns
     */
    public static Map<Character, String[]> createCharacterPatternMap() {
        Map<Character, String[]> charMap = new HashMap<>();
        
        // Populate charMap with 'O', 'P', 'S', and space using HashMap
        charMap.put('O', new String[]{
            " ***   ",
            "*   *  ",
            "*   *  ",
            "*   *  ",
            "*   *  ",
            "*   *  ",
            " ***   "
        });
        
        charMap.put('P', new String[]{
            " ***** ",
            "*     *",
            "*     *",
            "****** ",
            "*      ",
            "*      ",
            "*      "
        });
        
        charMap.put('S', new String[]{
            "  *****",
            " *    ",
            " *    ",
            "  **** ",
            "      *",
            "      *",
            " ***** "
        });
        
        charMap.put(' ', new String[]{
            "       ",
            "       ",
            "       ",
            "       ",
            "       ",
            "       ",
            "       "
        });
        
        return charMap;
    }

    /**
     * Retrieves the ASCII pattern for a given character from the HashMap
     *
     * Looks up the character in the HashMap to find its ASCII art pattern.
     * If the character is not found, returns the pattern for space character.
     * This approach provides O(1) constant-time lookup performance.
     *
     * @param ch       the character to look up
     * @param charMap  the HashMap containing character-to-pattern mappings
     * @return the pattern array for the given character, or space pattern if not found
     */
    public static String[] getCharacterPattern(char ch, Map<Character, String[]> charMap) {
        // Use HashMap.getOrDefault() for efficient lookup with fallback to space
        return charMap.getOrDefault(ch, charMap.get(' '));
    }

    /**
     * Displays a message as a banner using ASCII art patterns from the HashMap
     *
     * Renders the entire message horizontally by combining individual character
     * pattern lines by line. Uses HashMap for efficient character-to-pattern lookups.
     * Characters are separated by spacing for readability.
     *
     * @param message the message string to be displayed as a banner
     * @param charMap the HashMap containing character patterns
     */
    public static void displayBanner(String message, Map<Character, String[]> charMap) {
        // Getting pattern height. Assuming all patterns have the same height
        int patternHeight = charMap.get('O').length;
        
        // Loop through each line of the pattern height and build the banner line by line
        for (int line = 0; line < patternHeight; line++) {
            StringBuilder sb = new StringBuilder();
            for (char ch : message.toCharArray()) {
                String[] pattern = getCharacterPattern(ch, charMap);
                sb.append(pattern[line]).append(" "); // Adding space between characters
            }
            System.out.println(sb.toString());
        }
    }

    // Main method to run the banner display using HashMap
    public static void main(String[] args) {
        // Create HashMap for character patterns using Collections Framework
        Map<Character, String[]> charMap = createCharacterPatternMap();
        
        // Display the "OOPS" banner using the HashMap-based character patterns
        displayBanner("OOPS", charMap);
    }
}