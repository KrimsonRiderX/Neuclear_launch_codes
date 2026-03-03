/**
 * OOPSBannerApp UC7 – Store Character Pattern in a Class
 *
 * This use case extends UC6 by implementing a CharacterPatternMap class to encapsulate
 * character-to-pattern mappings. The application retrieves and displays the "OOPS"
 * banner using these mappings. This approach enhances code organization and modularity.
 *
 * @author Aditya ojha
 * @version 7.0
 */
public class hi {

    // Extend the User Story 6 to implement a CharacterPatternMap class to encapsulate
    // character-to-pattern mappings. The application retrieves and displays the "OOPS"
    // banner using these mappings. Thereby addressing the drawback of not having a
    // centralized character pattern management system.

    // Key Requirements:
    // 1. Create CharacterPatternMap class to hold character and its pattern
    // 2. Implement methods to create and retrieve character patterns
    // 3. Use CharacterPatternMap to display the "OOPS" banner
    // 4. Implement modular and reusable character pattern management

    // Hint:–

    // Drawback of this approach is that we are creating CharacterPatternMap objects–

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
     * Static Method to Create and initializes CharacterPatternMap array for predefined characters
     *
     * Populates pattern maps for letters 'O', 'P', 'S' and space character.
     * Each character has a 7-line ASCII art representation.
     *
     * @return array of CharacterPatternMap objects containing character patterns
     */
    public static CharacterPatternMap[] createCharacterPatternMaps() {
        CharacterPatternMap[] characterPatternMap = new CharacterPatternMap[4];
        // Populate characterPatternMap with 'O', 'P', 'S', and space
        characterPatternMap[0] = new CharacterPatternMap('O', new String[]{
            " ***   ",
            "*   *  ",
            "*   *  ",
            "*   *  ",
            "*   *  ",
            "*   *  ",
            " ***   "
        });
        characterPatternMap[1] = new CharacterPatternMap('P', new String[]{
            " ***** ",
            "*     *",
            "*     *",
            "****** ",
            "*      ",
            "*      ",
            "*      "
        });
        characterPatternMap[2] = new CharacterPatternMap('S', new String[]{
            "  *****",
            " *    ",
            " *    ",
            "  **** ",
            "      *",
            "      *",
            " ***** "
        });
        characterPatternMap[3] = new CharacterPatternMap(' ', new String[]{
            "       ",
            "       ",
            "       ",
            "       ",
            "       ",
            "       ",
            "       "
        });
        return characterPatternMap;
    }

    /**
     * Retrieves the ASCII pattern for a given character
     *
     * Searches through the character pattern maps to find a matching character.
     * If the character is not found, recursively returns the pattern for space character.
     *
     * @param ch       the character to look up
     * @param charMaps the array of CharacterPatternMap objects to search through
     * @return the pattern array for the given character, or space pattern if not found
     */
    public static String[] getCharacterPattern(char ch, CharacterPatternMap[] charMaps) {
        // Loop through charMaps to find matching character and return pattern
        for (CharacterPatternMap charMap : charMaps) {
            if (charMap.getCharacter() == ch) {
                return charMap.getPattern();
            }
        }
        // If character not found, recursively return the pattern for space character
        return getCharacterPattern(' ', charMaps);
    }

    /**
     * Prints a message as a banner using ASCII art patterns
     *
     * Renders the entire message horizontally by combining individual character
     * pattern lines by line. Characters are separated by spacing for readability.
     *
     * @param message the message string to be displayed as a banner
     * @param charMaps the array of CharacterPatternMap objects containing available patterns
     */
    public static void printMessage(String message, CharacterPatternMap[] charMaps) {
        // Loop through each line and assemble the banner for the message
        String[] patterns[] = new String[message.length()][];
        for (int i = 0; i < message.length(); i++) {
            patterns[i] = getCharacterPattern(message.charAt(i), charMaps);
        }
        
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < message.length(); j++) {
                System.out.print(patterns[j][i]);
            }
            System.out.println();
        }
    }

    // Main method to run the banner display
    public static void main(String[] args) {
        // Create CharacterPatternMap array
        CharacterPatternMap[] charMaps = createCharacterPatternMaps();
        
        // Print the "OOPS" banner using the character pattern maps
        printMessage("OOPS", charMaps);
    }
}