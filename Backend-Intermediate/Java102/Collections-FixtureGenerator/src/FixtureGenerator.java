import java.util.*;
//TODO: Home/Away games should be equally distributed in both stages.
/** hakantasariztech@gmail.com */
public class FixtureGenerator {
    public static ArrayList<String> teams = new ArrayList<>();

    public static void main(String[] args) {
        teams.add("Dortmund");
        teams.add("Bayern");
        teams.add("RealMadrid");
        teams.add("Barcelona");
        teams.add("Milan");
        teams.add("Arsenal");
        teams.add("Inter");
        teams.add("Liverpool");
        if (teams.size() % 2 == 1){
            teams.add("Bay");
        }
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
        //Shuffle the possible matches.
        for (int s = 0; s < 3; s++){
            Collections.shuffle(allPossibleMatches);
        }

        ArrayList<String> firstHalfMatches = new ArrayList<>();
        ArrayList<String> secondHalfMatches = new ArrayList<>();
        while(allPossibleMatches.size() > 0){
            int maxIteration = allPossibleMatches.size() + 1;
            int iterationsDone = 0;
            while (allPossibleMatches.size() > 0 && iterationsDone < maxIteration ){
                maxIteration--;
                String firstMatch = allPossibleMatches.get(0);
                String[] strList = firstMatch.split("-");
                String secondMatch = strList[1] + "-" + strList[0];
                firstHalfMatches.add(firstMatch);
                secondHalfMatches.add(secondMatch);
                allPossibleMatches.remove(firstMatch);
                allPossibleMatches.remove(secondMatch);
            }
        }
        Collections.shuffle(firstHalfMatches);
        Collections.shuffle(secondHalfMatches);

        generateFixture(firstHalfMatches, 1);
        generateFixture(secondHalfMatches, 2);
    }
    public static void generateFixture(ArrayList<String> matchesForStage, int half) {
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

        printFixture(roundList,half);
        printFixture(roundList,half);
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
    public static void printFixture(ArrayList<String> listToPrint, int half){
        int weekNumber = 1;
        int matchesPerWeek = teams.size()/2;
        int weeks = listToPrint.size()/((teams.size())/2);
        if (half == 2){
            weekNumber += weeks;
        }
        for (int t = 0; t < weeks; t++){
            System.out.format("Week %d\n", (weekNumber));
            weekNumber++;
            for (int i = 0; i < matchesPerWeek; i++){
                System.out.println(listToPrint.get(0));
                listToPrint.remove(0);
            }
            System.out.println();
        }
    }
}