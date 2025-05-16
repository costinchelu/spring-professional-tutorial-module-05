package module05.question02.application.view;

import module05.question02.framework.model.Model;
import module05.question02.framework.view.View;

public class AddNumbersView implements View {
    @Override
    public String render(Model model) {
        return String.format(
                "Result of adding numberA = [%s] and numberB = [%s] is [%s]",
                model.get("numberA"), model.get("numberB"), model.get("result")
        );
    }
}
