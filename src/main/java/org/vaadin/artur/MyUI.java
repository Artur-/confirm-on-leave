package org.vaadin.artur;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        MainLayout mainLayout = new MainLayout();
        Navigator navigator = new Navigator(this, (ViewDisplay) mainLayout);
        navigator.addView(FormView.VIEW_ID, new FormView());
        navigator.addView(AboutView.VIEW_ID, AboutView.class);
        navigator.setErrorView(ErrorView.class);
        setNavigator(navigator);
        setContent(mainLayout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
