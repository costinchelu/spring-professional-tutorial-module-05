package module05.question02.application.controller;

import module05.question02.application.view.AddNumbersView;
import module05.question02.framework.controller.ControllerMapping;
import module05.question02.framework.controller.IController;
import module05.question02.framework.ds.ModelAndView;
import module05.question02.framework.model.Model;
import module05.question02.framework.model.SimpleModel;

import javax.servlet.http.HttpServletRequest;

import static java.lang.String.valueOf;

@ControllerMapping("/add-numbers")
public class AddNumbersController implements IController {

    @Override
    public ModelAndView handleRequest(HttpServletRequest req) {
        Model model = new SimpleModel();

        int numberA = Integer.parseInt(req.getParameter("numberA"));
        int numberB = Integer.parseInt(req.getParameter("numberB"));

        model.set("numberA", valueOf(numberA));
        model.set("numberB", valueOf(numberB));
        model.set("result", valueOf(numberA + numberB));

        return new ModelAndView(
                model,
                new AddNumbersView()
        );
    }
}
