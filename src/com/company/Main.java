package com.company;

public class Main {

    public static void main(String[] args) {

        //generic type [BEST]
        League<Team<FootballPlayer>> footballLeague = new League<>("AFL");

        Team<FootballPlayer> adelaideCrows = new Team<>("Adelaide Crows");
        Team<FootballPlayer> melbourne = new Team<>("Melbourne");
        Team<FootballPlayer> hawthorn = new Team<>("Hawthorn");
        Team<FootballPlayer> fremantle = new Team<>("Fermantle");

        Team<BaseballPlayer> baseballTeam = new Team<>("Chicago Cubs"); //using this to show error with wrong team type

        footballLeague.add(adelaideCrows);
        footballLeague.add(melbourne);
        footballLeague.add(hawthorn);
        footballLeague.add(fremantle);
        //footballLeague.add(baseballTeam); //cannot add because this league is a football league

        footballLeague.showLeagueTable();

        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer beckham = new SoccerPlayer("Beckham");

        Team rawTeam = new Team("Raw Team");
        rawTeam.addPlayer(beckham); //unchecked warning because we aren't checking the type as with Team<T>
        rawTeam.addPlayer(pat); //unchecked warning

        footballLeague.add(rawTeam); //unchecked warning

        //raw type
        League<Team> rawLeague = new League<>("Raw");
        rawLeague.add(adelaideCrows); //no warning
        rawLeague.add(baseballTeam); //no warning
        rawLeague.add(rawTeam); //no warning

        //really raw type
        League reallyRaw = new League("Really raw");
        reallyRaw.add(adelaideCrows); //unchecked warning
        reallyRaw.add(baseballTeam); //unchecked warning
        reallyRaw.add(rawTeam); //unchecked warning

    }
}
