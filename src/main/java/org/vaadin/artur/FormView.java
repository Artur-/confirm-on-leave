package org.vaadin.artur;

import org.vaadin.dialogs.ConfirmDialog;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewBeforeLeaveEvent;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class FormView extends VerticalLayout implements View {

    public static final String VIEW_ID = "";

    private static final String CONFIRMATION_MESSAGE = "Your form contains unsaved data. Are you sure you want to leave the view and lose the changes?";

    private Label savedName = new Label();

    private TextField name = new TextField();

    private Button save = new Button("Save");

    public FormView() {
        savedName.setValue("John Doe");
        savedName.setCaption("Name in database");
        name.setCaption("Name");
        save.addClickListener(e -> {
            savedName.setValue(name.getValue());
        });

        addComponents(savedName, name, save);
    }

    @Override
    public void enter(ViewChangeEvent event) {
        name.setValue(savedName.getValue());
    }

    @Override
    public void beforeLeave(ViewBeforeLeaveEvent event) {
        if (!hasChanges()) {
            // No unsaved changes -> allow navigation
            event.navigate();
        } else {
            ConfirmDialog.show(getUI(), CONFIRMATION_MESSAGE, e -> {
                if (e.isConfirmed()) {
                    // Unsaved changes but the user confirmed it's ok to lose
                    // them -> navigate
                    event.navigate();
                }
            });
        }
    }

    private boolean hasChanges() {
        return !savedName.getValue().equals(name.getValue());
    }

}
