package es.uvigo.esei.dm1516.p28.Core;

/*
 * Clase Liga
 */

public class League {

    private int teams;
    private String name;


    public League(String name, int teams)
    {
        this.name = name;
        this.teams = teams;
    }


    public int getTeams() {
        return this.teams;
    }


    public String getName() {
        return this.name;
    }


    @Override
    public String toString() {
        return String.format(
                "%s (%05.2f): %06.2f",
                this.getName(),
                this.getTeams());
    }
}
