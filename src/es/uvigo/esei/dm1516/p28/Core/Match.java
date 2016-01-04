package es.uvigo.esei.dm1516.p28.Core;

public class Match {

    private String localTeam;
    private String visitTeam;
    private int matchDay;
    private int localGoals;
    private int visitGoals;


    public Match(String localTeam, String visitTeam, int matchDay, int localGoals, int visitGoals) {
        this.localTeam = localTeam;
        this.visitTeam = visitTeam;
        this.matchDay = matchDay;
        this.localGoals = localGoals;
        this.visitGoals = visitGoals;
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
}