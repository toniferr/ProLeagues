package es.uvigo.esei.dm1516.p28.Core;

public class Match {

    private String localTeam;
    private String visitTeam;
    private int matchDay;
    private int localGoals;
    private int visitGoals;
    private int finalizado;
    private String nameLeague;


    public Match(String localTeam, String visitTeam, int matchDay, int localGoals, int visitGoals, int finalizado, String nameLeague) {
        this.localTeam = localTeam;
        this.visitTeam = visitTeam;
        this.matchDay = matchDay;
        this.localGoals = localGoals;
        this.visitGoals = visitGoals;
        this.finalizado = finalizado;
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

    public int getFinalizado() { return finalizado;}

    public String getNameLeague() { return  nameLeague; }

    public void setLocalGoals(int g){ this.localGoals = g;  }

    public void setVisitGoals(int g){ this.visitGoals = g;  }
}