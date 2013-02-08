package org.jboss.hal.samples.rich.client;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.Place;
import com.gwtplatform.mvp.client.proxy.Proxy;
import org.jboss.as.console.client.shared.BeanFactory;
import org.jboss.as.console.client.shared.subsys.RevealStrategy;
import org.jboss.as.console.spi.SubsystemExtension;
import org.jboss.hal.samples.rich.client.model.RichSampleModel;

/**
 * @author Harald Pehl
 */
public class RichSamplePresenter extends Presenter<RichSamplePresenter.MyView, RichSamplePresenter.MyProxy>
{
    private final BeanFactory factory;
    private final RevealStrategy revealStrategy;

    @Inject
    public RichSamplePresenter(EventBus eventBus, MyView view, MyProxy proxy, BeanFactory factory,
            RevealStrategy revealStrategy)
    {
        super(eventBus, view, proxy);
        this.factory = factory;
        this.revealStrategy = revealStrategy;
    }

    @Override
    protected void onBind()
    {
        super.onBind();
        getView().setPresenter(this);
    }

    @Override
    protected void onReset()
    {
        super.onReset();

        // populate data model, i.e. from remote call
        RichSampleModel model = factory.getModel().as();
        model.setGreeting("Hello World");

        // update view
        getView().setData(model);
    }

    @Override
    protected void revealInParent()
    {
        revealStrategy.revealInParent(this);
    }


    // ------------------------------------------------------ inner classes


    @ProxyCodeSplit
    @NameToken("module1")
    @SubsystemExtension(name = "Rich Sample", group = "Extensions", key = "logging")
    // fake key, otheriwse it would not be loaded
    public interface MyProxy extends Proxy<RichSamplePresenter>, Place
    {
    }


    public interface MyView extends View
    {
        void setPresenter(RichSamplePresenter presenter);

        void setData(RichSampleModel data);
    }
}
