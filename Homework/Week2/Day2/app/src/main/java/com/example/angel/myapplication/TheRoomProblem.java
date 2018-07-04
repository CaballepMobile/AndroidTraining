package com.example.angel.myapplication;

public class TheRoomProblem {

    private static int xLength;
    private static int yLength;
    static final String warning = "<!>WARNING<!> - The previous set of rooms are infected! \n";
    static final String safe = "The previous set of rooms are still safe. \n";

    public static void main(String args[]) {

        System.out.println("Starting...\n");
        TheRoomUtil roomUtil = new TheRoomUtil();

        if(isOutbreak(roomUtil.True3x3())){
            System.out.println(warning);
        }else{
            System.out.println(safe);
        }

        if(isOutbreak(roomUtil.False3x3())){
            System.out.println(warning);
        }else{
            System.out.println(safe);
        }

        if(isOutbreak(roomUtil.True4x4())){
            System.out.println(warning);
        }else{
            System.out.println(safe);
        }

        if(isOutbreak(roomUtil.False4x4())){
            System.out.println(warning);
        }else{
            System.out.println(safe);
        }

        if(isOutbreak(roomUtil.horizontalTrue())){
            System.out.println(warning);
        }else{
            System.out.println(safe);
        }

        if(isOutbreak(roomUtil.verticalTrue())){
            System.out.println(warning);
        }else{
            System.out.println(safe);
        }

        if(isOutbreak(roomUtil.noInfection())){
            System.out.println(warning);
        }else{
            System.out.println(safe);
        }
    }

    static int consecutiveInfectedRooms;

    public static boolean isOutbreak(TheRoomUtil.Room[][] floor) {

        xLength = floor[0].length;
        yLength = floor[1].length;

        Draw(floor);

        for(int x = 0; x < xLength; x++){

            for(int y = 0; y < yLength; y++){

                consecutiveInfectedRooms = 0;
                if((floor[x][y].isInfected) && (!floor[x][y].visited)){

                    CheckNeighbors(x, y, floor);
                    if(consecutiveInfectedRooms >= 5){
                        return true;
                    }
                }
                floor[x][y].visited = true;
            }

        }

        return false;
    }

    private static void Draw(TheRoomUtil.Room[][] toDraw){
        for(int x = 0; x < xLength; x++){
            for(int y = 0; y < yLength; y++){
                if(toDraw[x][y].isInfected){
                    System.out.print("[X]");
                }else{
                    System.out.print("[ ]");
                }
            }
            System.out.println("");
        }
    }

    private static void CheckNeighbors(int currentX, int currentY, TheRoomUtil.Room[][] floor){

        //CheckWest
        if(currentX>0){
            if((floor[currentX-1][currentY].isInfected) && (!floor[currentX-1][currentY].visited)){

                floor[currentX-1][currentY].visited = true;
                consecutiveInfectedRooms++;
                CheckNeighbors(currentX-1, currentY, floor);
            }
        }

        //CheckNorth
        if(currentY>0){
            if((floor[currentX][currentY-1].isInfected) && (!floor[currentX][currentY-1].visited)){

                floor[currentX][currentY-1].visited = true;
                consecutiveInfectedRooms++;
                CheckNeighbors(currentX, currentY-1, floor);
            }
        }

        //CheckEast
        if(currentX < xLength-1){
            if((floor[currentX+1][currentY].isInfected) && (!floor[currentX+1][currentY].visited)){

                floor[currentX+1][currentY].visited = true;
                consecutiveInfectedRooms++;
                CheckNeighbors(currentX+1, currentY, floor);
            }
        }

        //CheckSouth
        if(currentY < yLength-1){
            if((floor[currentX][currentY+1].isInfected) && (!floor[currentX][currentY+1].visited)){

                floor[currentX][currentY+1].visited = true;
                consecutiveInfectedRooms++;
                CheckNeighbors(currentX, currentY+1, floor);
            }
        }
    }

}