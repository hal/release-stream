package org.jboss.hal.samples.rich.client.gin;

import com.google.gwt.inject.client.AsyncProvider;
import org.jboss.as.console.spi.GinExtension;
import org.jboss.hal.samples.rich.client.RichSamplePresenter;

/**
 * @author Harald Pehl
 */

@GinExtension("org.jboss.hal.samples.simple.RichSample")
public interface Extension
{
    AsyncProvider<RichSamplePresenter> getRichSamplePresenter();
}
