package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void addMember_adds_member_to_team() {
        team.addMember("Alice");
        assert(team.getMembers().size() == 1);
        assert(team.getMembers().get(0).equals("Alice"));
    }  

    @Test
    public void setName_sets_name_correctly() {
        team.setName("new-team-name");
        assert(team.getName().equals("new-team-name"));
    }

    @Test
    public void equals_returns_true_for_equal_teams() {
        Team team2 = new Team("test-team");
        assert(team.equals(team2));
    }
    
    @Test
    public void equals_returns_false_for_different_teams() {
        Team team2 = new Team("different-team");
        assert(!team.equals(team2));
    }

    @Test
    public void equals_returns_false_for_non_team_object() {
        String notATeam = "I am not a team";
        assert(!team.equals(notATeam));
    }



    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
