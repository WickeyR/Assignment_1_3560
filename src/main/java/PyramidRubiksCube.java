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


    /*
     */

}
