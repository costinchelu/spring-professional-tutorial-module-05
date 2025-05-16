package module05.question02.application.view;

import module05.question02.framework.model.Model;
import module05.question02.framework.view.View;

public class SquareNumberView implements View {
    @Override
    public String render(Model model) {
        return String.format(
                "Square number of [%s] is [%s]",
                model.get("number"), model.get("numberSquare")
        );
    }
}
