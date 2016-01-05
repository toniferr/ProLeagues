package es.uvigo.esei.dm1516.p28.Core;

public class Match {

    private String localTeam;
    private String visitTeam;
    private int matchDay;
    private int localGoals;
    private int visitGoals;
    private String nameLeague;


    public Match(String localTeam, String visitTeam, int matchDay, int localGoals, int visitGoals, String nameLeague) {
        this.localTeam = localTeam;
        this.visitTeam = visitTeam;
        this.matchDay = matchDay;
        this.localGoals = localGoals;
        this.visitGoals = visitGoals;
        this.nameLeague = nameLeague;
    }


    public String getLocalTeam() {
        return localTeam;
    }

    public String getVisitTeam() {
        return visitTeam;
    }

    public int getMatchDay() {
        return matchDay;
    }

    public int getLocalGoals() {
        return localGoals;
    }

    public int getVisitGoals() {
        return visitGoals;
    }

    public String getNameLeague() { return  nameLeague; }
}