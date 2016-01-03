package es.uvigo.esei.dm1516.p28.Core;


public class Team {

    private String nameTeam;
    private String user;
    private int points;
    private int golaverage;
    private String nameLeague;

    public Team(String nameTeam, String user, int points, int golaverage, String nameLeague)
    {
        this.nameTeam = nameTeam;
        this.user = user;
        this.points = points;
        this.golaverage= golaverage;
        this.nameLeague = nameLeague;
    }

    public int getGolaverage() {
        return this.golaverage;
    }

    public int getPoints() {
        return this.points;
    }

    public String getName() {
        return this.nameTeam;
    }

    public String getUser() {
        return this.user;
    }

    public String getNameLeague() {
        return this.nameLeague;
    }


    @Override
    public String toString() {
            return this.nameTeam+" -- "+this.points+" -- "+this.golaverage;
        }

}
