import java.io.File;
import java.util.Scanner;

public class Main {


    public static void readFile(String  filename){
        Scores scores =new Scores();
       try{

           Scanner scanner = new Scanner(new File(filename));

           while(scanner.hasNext()){
                String line = scanner.nextLine();
                String []  teams =  line.split(",");

                //get team names
                String teamA =  teams[0].substring(0,teams[0].length()-2).strip();
                String teamB = teams[1].substring(0,teams[1].length()-2).strip();

                //get team scores
                int scoreA = Integer.parseInt(teams[0].substring(teams[0].length()-2).strip()); //Assumed  that the game is soccer where scores above 100 are not possible
                int scoreB = Integer.parseInt(teams[1].substring(teams[1].length()-2).strip());

                scores.addTeams(teamA,teamB,scoreA,scoreB);
           }

           scanner.close();


       }catch (Exception e){
           e.printStackTrace();
       }

       scores.displayScores();


    }



    public static void main(String [] args){

        // the code takes in the file name as input

        if(args.length==0){
            System.out.println();
        }else{
            readFile(args[0]);
        }


    }

}
