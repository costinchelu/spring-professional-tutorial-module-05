package module05.question02.application.controller;

import module05.question02.application.view.IndexView;
import module05.question02.framework.controller.ControllerMapping;
import module05.question02.framework.controller.IController;
import module05.question02.framework.ds.ModelAndView;
import module05.question02.framework.model.SimpleModel;

import javax.servlet.http.HttpServletRequest;

@ControllerMapping("/")
public class IndexController implements IController {

    @Override
    public ModelAndView handleRequest(HttpServletRequest req) {
        return new ModelAndView(
                new SimpleModel(),
                new IndexView()
        );
    }
}
