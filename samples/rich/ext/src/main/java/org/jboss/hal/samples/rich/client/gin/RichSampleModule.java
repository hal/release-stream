package org.jboss.hal.samples.rich.client.gin;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import org.jboss.as.console.spi.GinExtensionBinding;
import org.jboss.hal.samples.rich.client.RichSamplePresenter;
import org.jboss.hal.samples.rich.client.RichSampleView;

/**
 * @author Harald Pehl
 */
@GinExtensionBinding
public class RichSampleModule extends AbstractPresenterModule
{
    @Override
    protected void configure()
    {
        bindPresenter(RichSamplePresenter.class,
                RichSamplePresenter.MyView.class,
                RichSampleView.class,
                RichSamplePresenter.MyProxy.class);
    }
}
