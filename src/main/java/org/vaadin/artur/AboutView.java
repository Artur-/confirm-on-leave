package org.vaadin.artur;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class AboutView extends VerticalLayout implements View {

    public static final String VIEW_ID = "about";

    private Label content = new Label();

    public AboutView() {
        content.setValue(
                "A dummy view just to enable navigating away from the form");
        addComponents(content);
    }

    @Override
    public void enter(ViewChangeEvent event) {
    }

}
