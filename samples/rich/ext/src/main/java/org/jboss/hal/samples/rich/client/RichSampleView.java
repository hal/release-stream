package org.jboss.hal.samples.rich.client;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import org.jboss.as.console.client.core.SuspendableViewImpl;
import org.jboss.as.console.client.shared.viewframework.builder.SimpleLayout;
import org.jboss.hal.samples.rich.client.model.RichSampleModel;

/**
 * @author Harald Pehl
 */
public class RichSampleView extends SuspendableViewImpl implements RichSamplePresenter.MyView
{
    private RichSamplePresenter presenter;
    private Label label;

    @Override
    public Widget createWidget()
    {
        label = new Label();

        SimpleLayout layout = new SimpleLayout()
                .setTitle("Rich Sample")
                .setHeadlineWidget(label)
                .setDescription("Hello, I am the rich sample!");
        return layout.build();
    }

    @Override
    public void setPresenter(RichSamplePresenter presenter)
    {
        this.presenter = presenter;
    }

    @Override
    public void setData(RichSampleModel data)
    {
        label.setText(data.getGreeting());
    }
}
