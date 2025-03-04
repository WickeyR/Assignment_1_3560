//Author: Ricky Franco
//18 Feb 2024
//PyramidRubiksCube.java: Represent a Pyramid Rubik's Cube using java data structures


public class PyramidRubiksCube {

    //The 2D Array that will represent our RUBIK
    char[][] RUBIK;

    //Saves the colors that are on the Rubik for future use
    final char[] COLORS = {'R', 'G', 'B', 'Y'};

    //Represents the number of faces in the Rubik
    final int NUM_OF_FACES = 4 ;

    // Represents the number of tiles on each face in the Rubik
    final int NUM_OF_FACE_TILES  =  9;


    /**
     * Constructs a Pyramid Rubik
     */
    public PyramidRubiksCube(){
        //Set the size of the Rubik to the number of faces and tiles
        RUBIK = new char[NUM_OF_FACES][NUM_OF_FACE_TILES];

        //Call functions to initialize faces and edges of the Rubik
        initializeFaces();
        initializeEdges();

        //Validate the Rubik and let the user know the result, exit if invalid
        if(validateCube()){
            System.out.println("Valid Pyramid Rubik Created");
        }else{
            System.out.println("Invalid Pyramid Rubik Created");
            System.exit(0);
        }
    }


    /**
     * Initialize each of the four faces of the Pyramix
     */
    public void initializeFaces() {
        // //Loops 4 times to fill each face with the unique color
        for (int faceIndex = 0; faceIndex < NUM_OF_FACES; faceIndex++) {
            // For each tile on the current face (0 through 8)
            for (int tileIndex = 0; tileIndex < NUM_OF_FACE_TILES; tileIndex++) {
                // Assign the unique color from COLORS char array
                RUBIK[faceIndex][tileIndex] = COLORS[faceIndex];
            }
        }
    }


    /**
     * Initialize edges of the Pyramix
     */
    public void initializeEdges() {
        // Define which edges match up on the pyramix

        // Edge between Face 0 (Red) and Face 1 (Green)
        int[] face0ToFace1 = {2, 5, 8}; // Tiles on face 0 that connect to face 1
        int[] face1ToFace0 = {0, 3, 6}; // Tiles on face 1 that connect to face 0

        // Edge between Face 0 (Red) and Face 2 (Blue)
        int[] face0ToFace2 = {0, 3, 6}; // Tiles on face 0 that connect to face 2
        int[] face2ToFace0 = {2, 5, 8}; // Tiles on face 2 that connect to face 0

        // Edge between Face 0 (Red) and Face 3 (Yellow)
        int[] face0ToFace3 = {6, 7, 8}; // Tiles on face 0 that connect to face 3
        int[] face3ToFace0 = {0, 1, 2}; // Tiles on face 3 that connect to face 0

        // Edge between Face 1 (Green) and Face 2 (Blue)
        int[] face1ToFace2 = {2, 5, 8}; // Tiles on face 1 that connect to face 2
        int[] face2ToFace1 = {0, 3, 6}; // Tiles on face 2 that connect to face 1

        // Edge between Face 1 (Green) and Face 3 (Yellow)
        int[] face1ToFace3 = {6, 7, 8}; // Tiles on face 1 that connect to face 3
        int[] face3ToFace1 = {6, 7, 8}; // Tiles on face 3 that connect to face 1

        // Edge between Face 2 (Blue) and Face 3 (Yellow)
        int[] face2ToFace3 = {6, 7, 8}; // Tiles on face 2 that connect to face 3
        int[] face3ToFace2 = {2, 5, 8}; // Tiles on face 3 that connect to face 2
    }


    /**
     * Validates that the Pyramid Rubik's Cube is in a valid state
     * @return true if valid, false otherwise
     */
    public boolean validateCube() {
       //Used to count the occurrence of each color
        int[] colorCount = new int[128];

        // Count how many times each color appears throughout the cube
        for (int face = 0; face < NUM_OF_FACES; face++) {

            //Ensures each face consists of 9 tiles
            if (RUBIK[face].length != NUM_OF_FACE_TILES) {
                return false;
            }

            // Count the colors on current face
            for (int tile = 0; tile < NUM_OF_FACE_TILES; tile++) {
                char color = RUBIK[face][tile];
                colorCount[color]++;
            }
        }

        // Verify each color appears exactly 9 times for each face
        for (char color : COLORS) {
            if (colorCount[color] != NUM_OF_FACE_TILES) {
                return false;
            }
        }



        return true;
    }

    public static void main(String[] args) {
        PyramidRubiksCube cube = new PyramidRubiksCube();
    }

}
