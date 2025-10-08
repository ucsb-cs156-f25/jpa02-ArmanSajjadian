package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        // TODO: Replace Chris G. with your name as shown on
        // <https://bit.ly/cs156-f25-teams>
        assertEquals("Arman", Developer.getName());
    }

    @Test 
    public void getGithubId_returns_correct_github_id() {
        // TODO: Replace ArmanSajjadian with your github id as shown on
        // <https://bit.ly/cs156-f25-teams>
        assertEquals("ArmanSajjadian", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_name_and_members() {
        Team team = Developer.getTeam();
        assertEquals("f25-07", team.getName());
        assertTrue(team.getMembers().contains("Arman"));
        assertTrue(team.getMembers().contains("Ian"));
        assertTrue(team.getMembers().contains("Jakinda"));
        assertTrue(team.getMembers().contains("Evelyn"));
        assertTrue(team.getMembers().contains("Yuchao"));
        assertTrue(team.getMembers().contains("Matthew"));
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
