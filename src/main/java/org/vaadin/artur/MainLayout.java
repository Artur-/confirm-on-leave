package org.vaadin.artur;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class MainLayout extends VerticalLayout implements ViewDisplay {

    private Component contents = new Label();

    public MainLayout() {
        Button navigateToForm = createNavigationButton("Form",
                FormView.VIEW_ID);
        Button navigateToAbout = createNavigationButton("About",
                AboutView.VIEW_ID);
        addComponent(new HorizontalLayout(navigateToForm, navigateToAbout,
                createLogout()));
        addComponent(contents);
    }

    private Button createLogout() {
        Button logout = new Button("Logout");
        logout.addStyleName(ValoTheme.BUTTON_LINK);
        logout.addClickListener(e -> {
            getUI().getNavigator()
                    .runAfterLeaveConfirmation(this::performLogout);
        });
        return logout;
    }

    private void performLogout() {
        getSession().getSession().invalidate();
        getUI().getPage().reload();
    }

    private Button createNavigationButton(String caption, String viewId) {
        Button navigateToForm = new Button(caption);
        navigateToForm.addStyleName(ValoTheme.BUTTON_LINK);
        navigateToForm.addClickListener(e -> {
            getUI().getNavigator().navigateTo(viewId);
        });
        return navigateToForm;
    }

    @Override
    public void showView(View view) {
        Component newContents = view.getViewComponent();
        replaceComponent(contents, newContents);
        contents = newContents;
    }

}
