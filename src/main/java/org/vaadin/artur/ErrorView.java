package org.vaadin.artur;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class ErrorView extends VerticalLayout implements View {

    private Label content = new Label();

    public ErrorView() {
        content.setValue(
                "There is no view with that id, please navigate using the menu");
        addComponents(content);
    }

    @Override
    public void enter(ViewChangeEvent event) {
    }

}
