import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/** Contact: hakantasariztech@gmail.com */
public class FixtureGenerator {
    public static ArrayList<String> teams = new ArrayList<>();
    public static Map<String, Integer> homeAwayBalance = new HashMap<>();

    public static void main(String[] args) {
        addDefaultTeams();
        generateFixtureGames(teams);
    }

    public static void generateFixtureGames(ArrayList<String> teams){
        ArrayList<String> allPossibleMatches = new ArrayList<>();
        Collections.shuffle(teams);
        Collections.shuffle(allPossibleMatches);
        int numberOfTeams = teams.size();

        //Generate all possible matches.
        for (int i = 0; i < numberOfTeams; i++) {
            for (int j = 0; j < numberOfTeams; j++) {
                if (i != j) {
                    allPossibleMatches.add(teams.get(i) + "-" + teams.get(j));
                }
            }
        }

        ArrayList<String> firstHalfMatches = new ArrayList<>();
        ArrayList<String> secondHalfMatches = new ArrayList<>();
        ArrayList<String> temporaryMatches = new ArrayList<>();
        while (true){
            Collections.shuffle(temporaryMatches);
            temporaryMatches.clear();
            temporaryMatches.addAll(allPossibleMatches);
            firstHalfMatches.clear();
            secondHalfMatches.clear();
            while(temporaryMatches.size() > 0){
                Collections.shuffle(temporaryMatches);
                int maxIteration = temporaryMatches.size(); //Continuously changing.
                int iterationsDone = 0;
                while (temporaryMatches.size() > 0 && iterationsDone <= maxIteration){
                    maxIteration--;
                    String firstMatch = temporaryMatches.get(0);
                    String[] strList = firstMatch.split("-");
                    String secondMatch = strList[1] + "-" + strList[0];
                    if (homeAwayBalance.get(strList[0]) <=3){
                        homeAwayBalance.put(strList[0], homeAwayBalance.get(strList[0])+1);
                        firstHalfMatches.add(firstMatch);
                        secondHalfMatches.add(secondMatch);
                    }else {
                        firstHalfMatches.add(secondMatch);
                        secondHalfMatches.add(firstMatch);
                    }
                    temporaryMatches.remove(firstMatch);
                    temporaryMatches.remove(secondMatch);
                }
            }
            if (isHomeAwayGamesBalanced(homeAwayBalance)){
                break;
            }
            clearHomeAwayGamesBalanced(homeAwayBalance);
        }

        Collections.shuffle(firstHalfMatches);
        Collections.shuffle(secondHalfMatches);

        generateFixtureStages(firstHalfMatches, 1);
        generateFixtureStages(secondHalfMatches, 2);
    }
    public static void generateFixtureStages(ArrayList<String> matchesForStage, int half) {
        if (half == 1){
            System.out.println("-----Fall Stage-----\n");
        }else {
            System.out.println("-----Spring Stage-----\n");
        }
        ArrayList<String> roundList = new ArrayList<>();
        ArrayList<String> temporaryMatchList = new ArrayList<>();

        do {
            int weeks = teams.size() - 1; // Weeks per Stage.
            Collections.shuffle(matchesForStage);
            roundList.clear();
            temporaryMatchList.clear();
            temporaryMatchList.addAll(matchesForStage);

            //Get weekly matches per weeks.
            for (int z = 0; z < weeks; z++) {
                ArrayList<String> tempThreeMatches = new ArrayList<>(getWeeklyMatches(temporaryMatchList));
                if (tempThreeMatches.size() != 0) {
                    roundList.addAll(tempThreeMatches);
                    temporaryMatchList.removeAll(tempThreeMatches);
                } else {
                    break;
                }
            }
        } while (roundList.size() != matchesForStage.size());

        printFinalFixture(roundList,half);
    }
    public static void printFinalFixture(ArrayList<String> listToPrint, int half){
        int weekNumber = 1;
        int matchesPerWeek = teams.size()/2; //E.g. 6 teams --> 3 matches per week.
        int weeks = listToPrint.size()/((teams.size())/2); // E.g. 6 teams --> 5 matches per stage; 5x3 = 15 games per stage; 15/3 = 5 weeks per stage.
        if (half != 1){
            weekNumber += weeks;
        }
        for (int t = 0; t < weeks; t++){
            System.out.format("\t\033[4mWeek %d\033[0m\n", (weekNumber));
            weekNumber++;
            for (int i = 0; i < matchesPerWeek; i++){
                System.out.println(listToPrint.get(0));
                listToPrint.remove(0);
            }
            System.out.println();
        }
    }
    public static ArrayList<String> getWeeklyMatches(ArrayList<String> matchList){
        ArrayList<String> returnList = new ArrayList<>();
        ArrayList<String> emptyList = new ArrayList<>();
        ArrayList<String> allTeams = new ArrayList<>(teams);
        ArrayList<String> temporaryMatchList = new ArrayList<>(matchList);
        int x = matchList.size();
        int counter = 0; //Used for the continuity of while(true) loop.
        boolean exit = false;
        while (!exit) {
            int matchesPerWeek = teams.size()/2;
            for (int i = 0; i < x; i++){
                String match = temporaryMatchList.get(i);
                String[] strList1 = match.split("-");
                if (allTeams.contains(strList1[0]) && allTeams.contains((strList1[1]))) {
                    allTeams.remove(strList1[0]);
                    allTeams.remove(strList1[1]);
                    returnList.add(match);
                    temporaryMatchList.remove(match);
                    x--;
                }
                if (returnList.size() == matchesPerWeek){
                    exit = true;
                    break;
                }
            }
            if (counter == matchList.size()){
                return emptyList;
            }
            counter++;
        }
        return returnList;
    }
    public static void clearHomeAwayGamesBalanced(Map<String, Integer> homeAwayBalance){
        for (String team : teams) {
            homeAwayBalance.put(team, 0);
        }
    }
    public static boolean isHomeAwayGamesBalanced(Map<String, Integer> homeAwayBalance){
        for (String team : teams) {
            int homeGames = homeAwayBalance.get(team);
            if (2 >= homeGames || homeGames > 4) {
                return false;
            }
        }
        return true;
    }
    public static void addDefaultTeams(){
        teams.add("Arsenal");
        teams.add("Barcelona");
        teams.add("Bayern");
        teams.add("Dortmund");
        teams.add("Inter");
        teams.add("Liverpool");
        teams.add("Milan");
        teams.add("RealMadrid");
        if (teams.size() % 2 == 1){
            teams.add("Bay");
        }
        for (String team : teams) {
            homeAwayBalance.put(team, 0);
        }
    }
}