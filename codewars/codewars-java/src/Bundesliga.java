/*My Solution*/

import java.util.ArrayList;

public class Bundesliga {
    private static ArrayList<Team> teamList;

    public static void main(String[] args) {
        String[] sample = {
                "6:0 FC Bayern Muenchen - Werder Bremen",
                "1:0 Eintracht Frankfurt - Schalke 04",
                "0:2 FC Augsburg - VfL Wolfsburg",
                "1:1 Hamburger SV - FC Ingolstadt",
                "2:0 1. FC Koeln - SV Darmstadt",
                "2:1 Borussia Dortmund - FSV Mainz 05",
                "2:1 Borussia Moenchengladbach - Bayer Leverkusen",
                "2:1 Hertha BSC Berlin - SC Freiburg",
                "2:2 TSG 1899 Hoffenheim - RasenBall Leipzig"
        };
        System.out.println(table(sample));
    }

    public static String table(String[] results) {
        teamList = new ArrayList<>();
        for (int i = 0; i < results.length; i++) {
            String tmp = results[i];
            String[] teams = results[i].substring(4).split(" +- +");
            if (tmp.charAt(0) == '-' && tmp.charAt(2) == '-') {
                Team team1 = new Team(teams[0]);
                Team team2 = new Team(teams[1]);
                teamList.add(team1);
                teamList.add(team2);
                continue;
            }

            int first = Character.getNumericValue(tmp.charAt(0));
            int second = Character.getNumericValue(tmp.charAt(2));
            if (checkName(teams[0]) == null && checkName(teams[1]) == null) {
                Team team1 = new Team(teams[0]);
                Team team2 = new Team(teams[1]);
                teamList.add(team1);
                teamList.add(team2);
                calculateMatch(team1, team2, first, second);
            } else if (checkName(teams[0]) != null && checkName(teams[1]) == null) {
                Team team1 = checkName(teams[0]);
                Team team2 = new Team(teams[1]);
                teamList.add(team2);
                calculateMatch(team1, team2, first, second);
            } else if (checkName(teams[0]) == null && checkName(teams[1]) != null) {
                Team team1 = new Team(teams[0]);
                Team team2 = checkName(teams[1]);
                teamList.add(team1);
                calculateMatch(team1, team2, first, second);
            } else if (checkName(teams[0]) != null && checkName(teams[1]) != null) {
                Team team1 = checkName(teams[0]);
                Team team2 = checkName(teams[1]);
                calculateMatch(team1, team2, first, second);
            }
        }
        return printTeam(orderTeams());
    }

    public static void calculateMatch(Team team1, Team team2, int first, int second) {
        if (first > second) {
            team1.points += 3;
            team1.wonMatches += 1;
            team2.lostMatches += 1;
        } else if (second > first) {
            team2.points += 3;
            team2.wonMatches += 1;
            team1.lostMatches += 1;
        } else {
            team1.points += 1;
            team2.points += 1;
            team1.tiedMatches += 1;
            team2.tiedMatches += 1;
        }
        team1.goalsScored += first;
        team1.goalsTaken += second;
        team2.goalsScored += second;
        team2.goalsTaken += first;
        team1.playedMatches += 1;
        team2.playedMatches += 1;
    }

    public static Team checkName(String name) {
        for (int i = 0; i < teamList.size(); i++) {
            Team tmp = teamList.get(i);
            if (tmp.name.equals(name))
                return teamList.get(i);
        }
        return null;
    }

    public static ArrayList<Team> orderTeams() {
        ArrayList<Team> res = new ArrayList<>();
        Team tmp;
        for (int i = 0; i < teamList.size(); i++) {
            tmp = teamList.get(i);
            for (int j = 0; j < teamList.size(); j++) {
                if (tmp.points < teamList.get(j).points) {
                    tmp = teamList.get(j);
                } else if (tmp.points == teamList.get(j).points) {
                    if ((tmp.goalsScored - tmp.goalsTaken) < (teamList.get(j).goalsScored - teamList.get(j).goalsTaken)) {
                        tmp = teamList.get(j);
                    } else if ((tmp.goalsScored - tmp.goalsTaken) == (teamList.get(j).goalsScored - teamList.get(j).goalsTaken)) {
                        if (tmp.goalsScored < teamList.get(j).goalsScored)
                            tmp = teamList.get(j);
                        else if (tmp.goalsScored == teamList.get(j).goalsScored) {
                            tmp = sortAlphaNum(tmp, teamList.get(j));
                        }
                    }
                }
                if (j == teamList.size() - 1) {
                    res.add(tmp);
                    teamList.remove(tmp);
                    i = -1;
                }
            }
        }
        return res;
    }

    private static Team sortAlphaNum(Team team1, Team team2) {
        char[] teamOneCharArray = String.format("%-30s", team1.name).toLowerCase().toCharArray();
        char[] teamTwoCharArray = String.format("%-30s", team2.name).toLowerCase().toCharArray();
        for (int i = 0; i < teamOneCharArray.length; i++) {
            if ((teamOneCharArray[i] >= 32 && teamOneCharArray[i] <= 126)
                    && (teamTwoCharArray[i] >= 32 && teamTwoCharArray[i] <= 126)) {
                if (teamOneCharArray[i] < teamTwoCharArray[i])
                    return team1;
                else if (teamOneCharArray[i] > teamTwoCharArray[i]) {
                    return team2;
                }
            }
        }
        return team1;
    }

    private static String printTeam(ArrayList<Team> inputArray) {
        StringBuilder res = new StringBuilder();
        String position = " 1";
        int counter = 1;
        res.append(position).append(". ").append(inputArray.get(0).name).append(inputArray.get(0).playedMatches).append("  ")
                .append(inputArray.get(0).wonMatches).append("  ").append(inputArray.get(0).tiedMatches).append("  ")
                .append(inputArray.get(0).lostMatches).append("  ").append(inputArray.get(0).goalsScored).append(":")
                .append(inputArray.get(0).goalsTaken).append("  ").append(inputArray.get(0).points).append("\n");
        for (int i = 1; i < inputArray.size(); i++) {
            Team tmp = inputArray.get(i);
            if ((tmp.points == inputArray.get(i - 1).points) && ((tmp.goalsScored - tmp.goalsTaken)
                    == (inputArray.get(i - 1).goalsScored - inputArray.get(i - 1).goalsTaken))
                    && (tmp.goalsScored == inputArray.get(i - 1).goalsScored)) {
                position = counter < 9 ? " " + (counter+1) : "" + (counter+1);
                res.append(position).append(". ").append(tmp.name).append(tmp.playedMatches).append("  ")
                        .append(tmp.wonMatches).append("  ").append(tmp.tiedMatches).append("  ")
                        .append(tmp.lostMatches).append("  ").append(tmp.goalsScored).append(":")
                        .append(tmp.goalsTaken).append("  ").append(tmp.points).append("\n");
            } else {
                position = i < 9 ? " " + (i + 1) : "" + (i + 1);
                res.append(position).append(". ").append(tmp.name).append(tmp.playedMatches).append("  ")
                        .append(tmp.wonMatches).append("  ").append(tmp.tiedMatches).append("  ")
                        .append(tmp.lostMatches).append("  ").append(tmp.goalsScored).append(":")
                        .append(tmp.goalsTaken).append("  ").append(tmp.points).append("\n");
                counter = i;
            }
        }
        res.replace(res.length() - 1, res.length(), "");
        return res.toString();
    }

    private static class Team {
        private final String name;
        private int playedMatches;
        private int wonMatches;
        private int tiedMatches;
        private int lostMatches;
        private int goalsScored;
        private int goalsTaken;
        private int points;

        private Team(String name) {
            if (name.length() < 30)
                name = String.format("%-30s", name);
            this.name = name;
            this.points = 0;
            this.wonMatches = 0;
            this.lostMatches = 0;
            this.tiedMatches = 0;
            this.playedMatches = 0;
            this.goalsTaken = 0;
            this.goalsScored = 0;
        }
    }
}

/*Other Solutions*/

/*
import java.util.*;

public class Bundesliga {

  private enum Result {
    WON,
    LOST,
    DRAW,
    DID_NOT_PLAY
  };

  private static class Team implements Comparable<Team> {
    final String name;
    final Integer goalsFor;
    final Integer goalsAgainst;
    final Result result;
    final int points;
    final int goalDifference;

    // ctor
    Team(final String name, final Integer goalsFor, final Integer goalsAgainst) {
      this.name = name;
      this. result =
        (goalsFor == null || goalsAgainst == null) ? Result.DID_NOT_PLAY :
        (goalsFor > goalsAgainst) ? Result.WON :
        (goalsFor < goalsAgainst) ? Result.LOST :
        Result.DRAW;
      this.goalsFor = goalsFor == null ? 0 : goalsFor;
      this.goalsAgainst = goalsAgainst == null ? 0 : goalsAgainst;
      this.points = result == Result.WON ? 3 : result == Result.DRAW ? 1 : 0;
      this.goalDifference = this.goalsFor - this.goalsAgainst;
    }

    @Override
    public String toString() {
      return String.format("%-30s%d  %1d  %1d  %1d  %1d:%1d  %1d",
        name,
        result == Result.DID_NOT_PLAY ? 0 : 1,
        result == Result.WON ? 1 : 0,
        result == Result.DRAW ? 1 : 0,
        result == Result.LOST ? 1 : 0,
        goalsFor, goalsAgainst,
        points
      );
    }

    @Override
    public int compareTo(final Team other) {
      // 1. Points
      if (this.points > other.points) return -1;
      if (this.points < other.points) return 1;

      // 2. Goal difference
      if (this.goalDifference > other.goalDifference) return -1;
      if (this.goalDifference < other.goalDifference) return 1;

      // 3. Goals scored
      if (this.goalsFor > other.goalsFor) return -1;
      if (this.goalsFor < other.goalsFor) return 1;

      // 4. Compare by team name
      return this.name.toLowerCase().compareTo(other.name.toLowerCase());
    }
  }

  public static String table(String[] results) {
    // Populate the list of Teams from the input
    final List<Team> teamList = new ArrayList<>();
    for (final String result : results) {
      final int spaceIdx = result.indexOf(" ");
      final String goals[] = result.substring(0,spaceIdx).split(":");
      final String teams[] = result.substring(spaceIdx+1).split("-");
      final String g1Str = goals[0].trim();
      final String g2Str = goals[1].trim();
      final Integer g1 = g1Str.equals("-") ? null : Integer.valueOf(g1Str);
      final Integer g2 = g2Str.equals("-") ? null : Integer.valueOf(g2Str);
      final String t1 = teams[0].trim();
      final String t2 = teams[1].trim();
      teamList.add(new Team(t1,g1,g2));  // home team
      teamList.add(new Team(t2,g2,g1));  // away team
    }

    // Sort
    int rank = 1;
    Collections.sort(teamList);
    String output = "";
    Team prevTeam = null;
    for (int i = 0; i < teamList.size(); i++) {
      final Team team = teamList.get(i);
      if (prevTeam != null) {
        if (prevTeam.points != team.points ||
          prevTeam.goalDifference != team.goalDifference ||
          prevTeam.goalsFor != team.goalsFor) {
          rank = i+1;
        }
      }
      output += String.format("%2d. %s", rank, team);
      output += i == teamList.size()-1 ? "" : "\n"; // no newline at the end!!
      prevTeam = team;
    }
    //System.out.println(output);

    return output;
  }
}
*/

/*
import java.util.*;

public class Bundesliga implements Comparator<Map.Entry<String, Map<String, Integer>>> {
  public static String table(String[] results) {
        TreeMap<String, Map<String, Integer>> map = new TreeMap<>();
        for (String result : results) {
            Map<String, Integer> club1 = new HashMap<>();
            Map<String, Integer> club2 = new HashMap<>();
            club1.put("Played", 1);
            club2.put("Played", 1);
            if (result.charAt(0) == '-') {
                club1.put("Played", 0);
                club2.put("Played", 0);
                club1.put("Won" , 0);
                club2.put("Won" , 0);
                club1.put("Lost" , 0);
                club2.put("Lost" , 0);
                club1.put("Tie", 0);
                club2.put("Tie", 0);
                club1.put("Points", 0);
                club2.put("Points", 0);
            } else if (result.charAt(0) > result.charAt(2)) {
                club1.put("Won" , 1);
                club2.put("Won" , 0);
                club1.put("Lost" , 0);
                club2.put("Lost" , 1);
                club1.put("Tie", 0);
                club2.put("Tie", 0);
                club1.put("Points", 3);
                club2.put("Points", 0);
            } else if (result.charAt(0) < result.charAt(2)) {
                club1.put("Won" , 0);
                club2.put("Won" , 1);
                club1.put("Lost" , 1);
                club2.put("Lost" , 0);
                club1.put("Tie", 0);
                club2.put("Tie", 0);
                club1.put("Points", 0);
                club2.put("Points", 3);
            } else {
                club1.put("Won" , 0);
                club2.put("Won" , 0);
                club1.put("Lost" , 0);
                club2.put("Lost" , 0);
                club1.put("Tie", 1);
                club2.put("Tie", 1);
                club1.put("Points", 1);
                club2.put("Points", 1);
            }
            if (result.charAt(0) != '-') {
                club1.put("Shot", Character.getNumericValue(result.charAt(0)));
                club2.put("Shot", Character.getNumericValue(result.charAt(2)));
                club1.put("Gotten", Character.getNumericValue(result.charAt(2)));
                club2.put("Gotten", Character.getNumericValue(result.charAt(0)));
            } else {
                club1.put("Shot", 0);
                club2.put("Shot", 0);
                club1.put("Gotten", 0);
                club2.put("Gotten", 0);
            }
            String name1 = result.substring(4).split(" - ")[0];
            String name2 = result.substring(4).split(" - ")[1];
            map.put(name1, club1);
            map.put(name2, club2);
        }
        List<Map.Entry<String, Map<String, Integer>>> list = new LinkedList<>(map.entrySet());
        list.sort(new Bundesliga());
        return makeTable(list);
    }

    public static String makeTable(List<Map.Entry<String, Map<String, Integer>>> list) {
        StringBuilder result = new StringBuilder();
        int rank = 1;
        int bgRank = 1;
        for (int i = 0; i < list.size(); i++) {
            if (i > 0 && (new Bundesliga().compare(list.get(i), list.get(i-1)) == 1234 ||
                    new Bundesliga().compare(list.get(i), list.get(i-1)) == -1234)) {
                rank = bgRank;
            }
            result.append((rank<10? " " + rank : rank) + ". ");
            bgRank++;

            result.append(list.get(i).getKey());
            for (int j = 30 - list.get(i).getKey().length(); j > 0; j--) {
                result.append(" ");
            }

            result.append(list.get(i).getValue().get("Played") + "  ");
            result.append(list.get(i).getValue().get("Won") + "  ");
            result.append(list.get(i).getValue().get("Tie") + "  ");
            result.append(list.get(i).getValue().get("Lost") + "  ");
            result.append(list.get(i).getValue().get("Shot") + ":" + list.get(i).getValue().get("Gotten") + "  ");
            result.append(list.get(i).getValue().get("Points") + "\n");
        }
        return " " + result.toString().trim();
    }

    @Override
    public int compare(Map.Entry<String, Map<String, Integer>> o1, Map.Entry<String, Map<String, Integer>> o2) {

        // 1. Points
        if (o1.getValue().get("Points") < o2.getValue().get("Points")){
            return 1234;
        } else if (o1.getValue().get("Points") > o2.getValue().get("Points")) {
            return -1234;
        } else {

            // 2. If the points are the same: The difference of goals. (2:0 is better than 1:0)
            if ((o1.getValue().get("Shot") - o1.getValue().get("Gotten")) <
                    (o2.getValue().get("Shot") - o2.getValue().get("Gotten"))){
                return 1234;
            } else if ((o1.getValue().get("Shot") - o1.getValue().get("Gotten")) >
                    (o2.getValue().get("Shot") - o2.getValue().get("Gotten"))) {
                return -1234;
            } else {

                // 3. If the difference of goals is the same: More goals are better! (2:1 is better than 1:0)
                if (o1.getValue().get("Shot") < o2.getValue().get("Shot")){
                    return 1234;
                } else if (o1.getValue().get("Shot") > o2.getValue().get("Shot")) {
                    return -1234;
                } else {
                    // 4. Otherwise: The teams share the same place, but ordered by the name of the team (case-insensitive!)!
                    return o1.getKey().compareToIgnoreCase(o2.getKey());
                }
            }
        }
    }
}
*/

/*
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Bundesliga {
    public static String table(String[] results) {
        Table table = new Table();
        Stream.of(results).map(Match::new).forEach(table::addMatch);
        return table.toString();
    }

    static class Table {
        Map<String, TableTeam> map = new HashMap<>();

        void addMatch(Match m) {
            // make sure all teams are in table
            TableTeam t1 = map.computeIfAbsent(m.team1, TableTeam::new);
            TableTeam t2 = map.computeIfAbsent(m.team2, TableTeam::new);
            if (m.wasPlayed()) { // add the match if it was played
                t1.addMatch(m);
                t2.addMatch(m);
            }
        }

        @Override
        public String toString() {
            List<TableTeam> sorted =
                    map.values().stream().sorted(
                            Comparator.<TableTeam>naturalOrder()
                                    .thenComparing(TableTeam::getName, String::compareToIgnoreCase))
                       .collect(Collectors.toList());
            int rank = 1;
            int step = 1;
            TableTeam lastTeam = null;
            StringBuilder res = new StringBuilder();
            for (TableTeam team : sorted) {
                if (lastTeam == null) {
                    res.append(String.format("%2d. ", rank)).append(team.toString());
                } else {
                    if (lastTeam.compareTo(team) != 0) {
                        rank += step;
                        step = 1;
                    } else {
                        step++;
                    }
                    res.append("\n").append(String.format("%2d. ", rank)).append(team.toString());
                }
                lastTeam = team;
            }
            return res.toString();
        }
    }

    static class TableTeam implements Comparable<TableTeam> {
        String name;
        int winCount, tieCount, lossCount, goalsShot, goalsGotten;

        public TableTeam(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        int getPlayedCount() {
            return winCount + tieCount + lossCount;
        }

        int points() {
            return winCount * 3 + tieCount;
        }

        void addMatch(Match m) {
            if (!m.wasPlayed()) return;
            boolean isT1 = m.team1.equals(name);
            boolean isT2 = m.team2.equals(name);
            if (!isT1 && !isT2) return;
            String winner = m.getWinner(); // win/tie/loss
            if (winner == null) {
                tieCount++;
            } else if (name.equals(winner)) {
                winCount++;
            } else {
                lossCount++;
            }
            if (isT1) { // scores
                goalsShot += m.score1;
                goalsGotten += m.score2;
            } else {
                goalsShot += m.score2;
                goalsGotten += m.score1;
            }
        }

        int goalDiff() {
            return goalsShot - goalsGotten;
        }

        @Override
        public int compareTo(TableTeam o) {
            int comp = Integer.compare(o.points(), points());
            if (comp != 0) return comp;
            comp = Integer.compare(o.goalDiff(), goalDiff());
            if (comp != 0) return comp;
            return Integer.compare(o.goalsShot, goalsShot);
        }

        @Override
        public String toString() {
            return String.format("%-30s%d %2d %2d %2d  %d:%d %2d", name, getPlayedCount(),
                                 winCount, tieCount, lossCount, goalsShot, goalsGotten, points());
        }
    }

    static class Match {
        static Pattern p = Pattern.compile("(-|\\d+):(-|\\d+) (.+) - (.*)");
        Integer score1, score2;
        String team1, team2;

        Match(String s) {
            Matcher matcher = p.matcher(s);
            if (!matcher.matches())
                throw new IllegalArgumentException("unexpected input doesn't match format: " + s);
            try {
                score1 = Integer.parseInt(matcher.group(1));
                score2 = Integer.parseInt(matcher.group(2));
            } catch (NumberFormatException ignored) {}
            team1 = matcher.group(3);
            team2 = matcher.group(4);
        }

        boolean wasPlayed() {
            return score1 != null && score2 != null;
        }

        String getWinner() {
            if (!wasPlayed()) return null;
            return score1 > score2 ? team1 : (score1 < score2 ? team2 : null);
        }
    }
}
*/