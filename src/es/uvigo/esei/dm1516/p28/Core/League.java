package es.uvigo.esei.dm1516.p28.Core;

public class League {

    private String name;

    public League(String name)
    {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }


    @Override
    public String toString() {
        return "Liga: "+this.name;
    }
}
