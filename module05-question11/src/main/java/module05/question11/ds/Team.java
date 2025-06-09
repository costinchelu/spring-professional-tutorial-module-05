package module05.question11.ds;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Team {

    private int teamId;

    private String teamName;

    private List<Person> people;
}
