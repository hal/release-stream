package org.jboss.hal.samples.simple.client.gin;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import org.jboss.as.console.spi.GinExtensionBinding;
import org.jboss.hal.samples.simple.client.SimpleSamplePresenter;
import org.jboss.hal.samples.simple.client.SimpleSampleView;

/**
 * @author Harald Pehl
 */
@GinExtensionBinding
public class SimpleSampleModule extends AbstractPresenterModule
{
    @Override
    protected void configure()
    {
        bindPresenter(SimpleSamplePresenter.class,
                SimpleSamplePresenter.MyView.class,
                SimpleSampleView.class,
                SimpleSamplePresenter.MyProxy.class);
    }
}
