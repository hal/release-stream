package org.jboss.hal.samples.simple.client;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import org.jboss.as.console.client.core.SuspendableViewImpl;
import org.jboss.as.console.client.shared.viewframework.builder.SimpleLayout;
import org.jboss.hal.samples.simple.client.model.SimpleSampleModel;

/**
 * @author Harald Pehl
 */
public class SimpleSampleView extends SuspendableViewImpl implements SimpleSamplePresenter.MyView
{
    private SimpleSamplePresenter presenter;
    private Label label;

    @Override
    public Widget createWidget()
    {
        label = new Label();

        SimpleLayout layout = new SimpleLayout()
                .setTitle("Simple Sample")
                .setHeadlineWidget(label)
                .setDescription("Hello, I am the simple sample!");
        return layout.build();
    }

    @Override
    public void setPresenter(SimpleSamplePresenter presenter)
    {
        this.presenter = presenter;
    }

    @Override
    public void setData(SimpleSampleModel data)
    {
        label.setText(data.getGreeting());
    }
}
